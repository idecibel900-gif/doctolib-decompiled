package io.sentry;

import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.Objects;
import java.net.InetAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class HostnameCache {
    private static volatile HostnameCache INSTANCE;
    private final long cacheDuration;
    private final ExecutorService executorService;
    private volatile long expirationTimestamp;
    private final Callable getLocalhost;
    private volatile String hostname;
    private final AtomicBoolean updateRunning;
    private static final long HOSTNAME_CACHE_DURATION = TimeUnit.HOURS.toMillis(5);
    private static final long GET_HOSTNAME_TIMEOUT = TimeUnit.SECONDS.toMillis(1);
    private static final AutoClosableReentrantLock staticLock = new AutoClosableReentrantLock();

    public static HostnameCache getInstance() {
        if (INSTANCE == null) {
            ISentryLifecycleToken iSentryLifecycleTokenAcquire = staticLock.acquire();
            try {
                if (INSTANCE == null) {
                    INSTANCE = new HostnameCache();
                }
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
            } catch (Throwable th) {
                if (iSentryLifecycleTokenAcquire != null) {
                    try {
                        iSentryLifecycleTokenAcquire.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return INSTANCE;
    }

    private HostnameCache() {
        this(HOSTNAME_CACHE_DURATION);
    }

    HostnameCache(long j) {
        this(j, new Callable() { // from class: io.sentry.HostnameCache$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return InetAddress.getLocalHost();
            }
        });
    }

    HostnameCache(long j, Callable callable) {
        this.updateRunning = new AtomicBoolean(false);
        this.executorService = Executors.newSingleThreadExecutor(new HostnameCacheThreadFactory());
        this.cacheDuration = j;
        this.getLocalhost = (Callable) Objects.requireNonNull(callable, "getLocalhost is required");
        updateCache();
    }

    void close() {
        this.executorService.shutdown();
    }

    public String getHostname() {
        if (this.expirationTimestamp < System.currentTimeMillis() && this.updateRunning.compareAndSet(false, true)) {
            updateCache();
        }
        return this.hostname;
    }

    private void updateCache() {
        try {
            this.executorService.submit(new Callable() { // from class: io.sentry.HostnameCache$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return HostnameCache.$r8$lambda$e2G8NSiOS2js5uJRi2FeyRX3pic(this.f$0);
                }
            }).get(GET_HOSTNAME_TIMEOUT, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            handleCacheUpdateFailure();
        } catch (RuntimeException | ExecutionException | TimeoutException unused2) {
            handleCacheUpdateFailure();
        }
    }

    public static /* synthetic */ Void $r8$lambda$e2G8NSiOS2js5uJRi2FeyRX3pic(HostnameCache hostnameCache) {
        hostnameCache.getClass();
        try {
            hostnameCache.hostname = ((InetAddress) hostnameCache.getLocalhost.call()).getCanonicalHostName();
            hostnameCache.expirationTimestamp = System.currentTimeMillis() + hostnameCache.cacheDuration;
            return null;
        } finally {
            hostnameCache.updateRunning.set(false);
        }
    }

    private void handleCacheUpdateFailure() {
        this.expirationTimestamp = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(1L);
    }

    private static final class HostnameCacheThreadFactory implements ThreadFactory {
        private int cnt;

        private HostnameCacheThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder();
            sb.append("SentryHostnameCache-");
            int i = this.cnt;
            this.cnt = i + 1;
            sb.append(i);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }
}
