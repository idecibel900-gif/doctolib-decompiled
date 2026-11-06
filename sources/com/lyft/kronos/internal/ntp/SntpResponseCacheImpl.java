package com.lyft.kronos.internal.ntp;

import com.lyft.kronos.Clock;
import com.lyft.kronos.SyncResponseCache;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SntpResponseCacheImpl implements SntpResponseCache {
    private final Clock deviceClock;
    private final SyncResponseCache syncResponseCache;

    public SntpResponseCacheImpl(SyncResponseCache syncResponseCache, Clock deviceClock) {
        Intrinsics.checkNotNullParameter(syncResponseCache, "syncResponseCache");
        Intrinsics.checkNotNullParameter(deviceClock, "deviceClock");
        this.syncResponseCache = syncResponseCache;
        this.deviceClock = deviceClock;
    }

    @Override // com.lyft.kronos.internal.ntp.SntpResponseCache
    public SntpClient.Response get() {
        long currentTime = this.syncResponseCache.getCurrentTime();
        long elapsedTime = this.syncResponseCache.getElapsedTime();
        long currentOffset = this.syncResponseCache.getCurrentOffset();
        if (elapsedTime == 0) {
            return null;
        }
        return new SntpClient.Response(currentTime, elapsedTime, currentOffset, this.deviceClock);
    }

    @Override // com.lyft.kronos.internal.ntp.SntpResponseCache
    public void update(SntpClient.Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        synchronized (this) {
            this.syncResponseCache.setCurrentTime(response.getDeviceCurrentTimestampMs());
            this.syncResponseCache.setElapsedTime(response.getDeviceElapsedTimestampMs());
            this.syncResponseCache.setCurrentOffset(response.getOffsetMs());
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.lyft.kronos.internal.ntp.SntpResponseCache
    public void clear() {
        synchronized (this) {
            this.syncResponseCache.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
