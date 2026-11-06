package io.sentry;

import io.sentry.util.AutoClosableReentrantLock;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryExecutorService implements ISentryExecutorService {
    private final Runnable dummyRunnable;
    private final ScheduledThreadPoolExecutor executorService;
    private final AutoClosableReentrantLock lock;
    private final SentryOptions options;

    public static /* synthetic */ void $r8$lambda$yQuX73Ji_YJThnj5bUTepE7Q5CY() {
    }

    SentryExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, SentryOptions sentryOptions) {
        this.lock = new AutoClosableReentrantLock();
        this.dummyRunnable = new Runnable() { // from class: io.sentry.SentryExecutorService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SentryExecutorService.$r8$lambda$yQuX73Ji_YJThnj5bUTepE7Q5CY();
            }
        };
        this.executorService = scheduledThreadPoolExecutor;
        this.options = sentryOptions;
    }

    public SentryExecutorService(SentryOptions sentryOptions) {
        this(new ScheduledThreadPoolExecutor(1, new SentryExecutorServiceThreadFactory()), sentryOptions);
    }

    public SentryExecutorService() {
        this(new ScheduledThreadPoolExecutor(1, new SentryExecutorServiceThreadFactory()), null);
    }

    private boolean isQueueAvailable() {
        if (this.executorService.getQueue().size() >= 271) {
            this.executorService.purge();
        }
        return this.executorService.getQueue().size() < 271;
    }

    @Override // io.sentry.ISentryExecutorService
    public Future submit(Runnable runnable) {
        if (isQueueAvailable()) {
            return this.executorService.submit(runnable);
        }
        SentryOptions sentryOptions = this.options;
        if (sentryOptions != null) {
            sentryOptions.getLogger().log(SentryLevel.WARNING, "Task " + runnable + " rejected from " + this.executorService, new Object[0]);
        }
        return new CancelledFuture();
    }

    @Override // io.sentry.ISentryExecutorService
    public Future schedule(Runnable runnable, long j) {
        return this.executorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    @Override // io.sentry.ISentryExecutorService
    public void close(long j) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            if (!this.executorService.isShutdown()) {
                this.executorService.shutdown();
                try {
                    if (!this.executorService.awaitTermination(j, TimeUnit.MILLISECONDS)) {
                        this.executorService.shutdownNow();
                    }
                } catch (InterruptedException unused) {
                    this.executorService.shutdownNow();
                    Thread.currentThread().interrupt();
                }
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

    @Override // io.sentry.ISentryExecutorService
    public boolean isClosed() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            boolean zIsShutdown = this.executorService.isShutdown();
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return zIsShutdown;
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

    @Override // io.sentry.ISentryExecutorService
    public void prewarm() {
        try {
            this.executorService.submit(new Runnable() { // from class: io.sentry.SentryExecutorService$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    SentryExecutorService.$r8$lambda$9Gmeasu1QMpGOfYsjWSLqRvbbSU(this.f$0);
                }
            });
        } catch (RejectedExecutionException e) {
            SentryOptions sentryOptions = this.options;
            if (sentryOptions != null) {
                sentryOptions.getLogger().log(SentryLevel.WARNING, "Prewarm task rejected from " + this.executorService, e);
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$9Gmeasu1QMpGOfYsjWSLqRvbbSU(SentryExecutorService sentryExecutorService) {
        sentryExecutorService.getClass();
        for (int i = 0; i < 40; i++) {
            try {
                sentryExecutorService.executorService.schedule(sentryExecutorService.dummyRunnable, 365L, TimeUnit.DAYS).cancel(true);
            } catch (RejectedExecutionException unused) {
                return;
            }
        }
        sentryExecutorService.executorService.purge();
    }

    private static final class SentryExecutorServiceThreadFactory implements ThreadFactory {
        private int cnt;

        private SentryExecutorServiceThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder();
            sb.append("SentryExecutorServiceThreadFactory-");
            int i = this.cnt;
            this.cnt = i + 1;
            sb.append(i);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    private static final class CancelledFuture implements Future {
        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return true;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return true;
        }

        private CancelledFuture() {
        }

        @Override // java.util.concurrent.Future
        public Object get() {
            throw new CancellationException();
        }

        @Override // java.util.concurrent.Future
        public Object get(long j, TimeUnit timeUnit) {
            throw new CancellationException();
        }
    }
}
