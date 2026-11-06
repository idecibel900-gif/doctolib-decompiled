package com.lyft.kronos.internal.ntp;

import com.lyft.kronos.Clock;
import com.lyft.kronos.KronosTime;
import com.lyft.kronos.SyncListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SntpServiceImpl implements SntpService {
    private final long cacheExpirationMs;
    private final AtomicLong cachedSyncTime;
    private final Clock deviceClock;
    private final ExecutorService executor;
    private final long maxNtpResponseTimeMs;
    private final long minWaitTimeBetweenSyncMs;
    private final List ntpHosts;
    private final SyncListener ntpSyncListener;
    private final long requestTimeoutMs;
    private final SntpResponseCache responseCache;
    private final SntpClient sntpClient;
    private final AtomicReference state;

    private enum State {
        IDLE,
        SYNCING,
        STOPPED
    }

    public SntpServiceImpl(SntpClient sntpClient, Clock deviceClock, SntpResponseCache responseCache, SyncListener syncListener, List ntpHosts, long j, long j2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(sntpClient, "sntpClient");
        Intrinsics.checkNotNullParameter(deviceClock, "deviceClock");
        Intrinsics.checkNotNullParameter(responseCache, "responseCache");
        Intrinsics.checkNotNullParameter(ntpHosts, "ntpHosts");
        this.sntpClient = sntpClient;
        this.deviceClock = deviceClock;
        this.responseCache = responseCache;
        this.ntpSyncListener = syncListener;
        this.ntpHosts = ntpHosts;
        this.requestTimeoutMs = j;
        this.minWaitTimeBetweenSyncMs = j2;
        this.cacheExpirationMs = j3;
        this.maxNtpResponseTimeMs = j4;
        this.state = new AtomicReference(State.IDLE);
        this.cachedSyncTime = new AtomicLong(0L);
        this.executor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.lyft.kronos.internal.ntp.SntpServiceImpl$executor$1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "kronos-android");
            }
        });
    }

    private final SntpClient.Response getResponse() {
        SntpClient.Response response = this.responseCache.get();
        if (((State) this.state.get()) != State.IDLE || response == null || response.isFromSameBoot()) {
            return response;
        }
        this.responseCache.clear();
        return null;
    }

    private final long getCacheSyncAge() {
        return this.deviceClock.getElapsedTimeMs() - this.cachedSyncTime.get();
    }

    @Override // com.lyft.kronos.internal.ntp.SntpService
    public KronosTime currentTime() {
        ensureServiceIsRunning();
        SntpClient.Response response = getResponse();
        if (response == null) {
            if (getCacheSyncAge() < this.minWaitTimeBetweenSyncMs) {
                return null;
            }
            syncInBackground();
            return null;
        }
        long responseAge = response.getResponseAge();
        if (responseAge >= this.cacheExpirationMs && getCacheSyncAge() >= this.minWaitTimeBetweenSyncMs) {
            syncInBackground();
        }
        return new KronosTime(response.getCurrentTimeMs(), Long.valueOf(responseAge));
    }

    @Override // com.lyft.kronos.internal.ntp.SntpService
    public void syncInBackground() {
        ensureServiceIsRunning();
        if (((State) this.state.get()) != State.SYNCING) {
            this.executor.submit(new Runnable() { // from class: com.lyft.kronos.internal.ntp.SntpServiceImpl.syncInBackground.1
                @Override // java.lang.Runnable
                public final void run() {
                    SntpServiceImpl.this.sync();
                }
            });
        }
    }

    @Override // com.lyft.kronos.internal.ntp.SntpService
    public void shutdown() {
        ensureServiceIsRunning();
        this.state.set(State.STOPPED);
        this.executor.shutdown();
    }

    public boolean sync() {
        ensureServiceIsRunning();
        Iterator it = this.ntpHosts.iterator();
        while (it.hasNext()) {
            if (sync((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final void ensureServiceIsRunning() {
        if (((State) this.state.get()) == State.STOPPED) {
            throw new IllegalStateException("Service already shutdown");
        }
    }

    private final boolean sync(String str) {
        AtomicReference atomicReference = this.state;
        State state = State.SYNCING;
        if (((State) atomicReference.getAndSet(state)) == state) {
            return false;
        }
        long elapsedTimeMs = this.deviceClock.getElapsedTimeMs();
        SyncListener syncListener = this.ntpSyncListener;
        if (syncListener != null) {
            syncListener.onStartSync(str);
        }
        try {
            SntpClient.Response response = this.sntpClient.requestTime(str, Long.valueOf(this.requestTimeoutMs));
            Intrinsics.checkNotNullExpressionValue(response, "response");
            if (response.getCurrentTimeMs() < 0) {
                throw new NTPSyncException("Invalid time " + response.getCurrentTimeMs() + " received from " + str);
            }
            long elapsedTimeMs2 = this.deviceClock.getElapsedTimeMs() - elapsedTimeMs;
            if (elapsedTimeMs2 > this.maxNtpResponseTimeMs) {
                throw new NTPSyncException("Ignoring response from " + str + " because the network latency (" + elapsedTimeMs2 + " ms) is longer than the required value (" + this.maxNtpResponseTimeMs + " ms");
            }
            this.responseCache.update(response);
            long offsetMs = response.getOffsetMs();
            SyncListener syncListener2 = this.ntpSyncListener;
            if (syncListener2 != null) {
                syncListener2.onSuccess(offsetMs, elapsedTimeMs2);
            }
            this.state.set(State.IDLE);
            this.cachedSyncTime.set(this.deviceClock.getElapsedTimeMs());
            return true;
        } catch (Throwable th) {
            try {
                SyncListener syncListener3 = this.ntpSyncListener;
                if (syncListener3 != null) {
                    syncListener3.onError(str, th);
                }
                return false;
            } finally {
                this.state.set(State.IDLE);
                this.cachedSyncTime.set(this.deviceClock.getElapsedTimeMs());
            }
        }
    }
}
