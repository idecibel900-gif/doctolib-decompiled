package io.sentry.backpressure;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import io.sentry.IScopes;
import io.sentry.ISentryExecutorService;
import io.sentry.ISentryLifecycleToken;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.util.AutoClosableReentrantLock;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes5.dex */
public final class BackpressureMonitor implements IBackpressureMonitor, Runnable {
    private int downsampleFactor = 0;
    private volatile Future latestScheduledRun = null;
    private final AutoClosableReentrantLock lock = new AutoClosableReentrantLock();
    private final IScopes scopes;
    private final SentryOptions sentryOptions;

    public BackpressureMonitor(SentryOptions sentryOptions, IScopes iScopes) {
        this.sentryOptions = sentryOptions;
        this.scopes = iScopes;
    }

    @Override // io.sentry.backpressure.IBackpressureMonitor
    public void start() {
        reschedule(500);
    }

    @Override // java.lang.Runnable
    public void run() {
        checkHealth();
        reschedule(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
    }

    @Override // io.sentry.backpressure.IBackpressureMonitor
    public int getDownsampleFactor() {
        return this.downsampleFactor;
    }

    @Override // io.sentry.backpressure.IBackpressureMonitor
    public void close() {
        Future future = this.latestScheduledRun;
        if (future != null) {
            ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
            try {
                future.cancel(true);
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
    }

    void checkHealth() {
        if (isHealthy()) {
            if (this.downsampleFactor > 0) {
                this.sentryOptions.getLogger().log(SentryLevel.DEBUG, "Health check positive, reverting to normal sampling.", new Object[0]);
            }
            this.downsampleFactor = 0;
        } else {
            int i = this.downsampleFactor;
            if (i < 10) {
                this.downsampleFactor = i + 1;
                this.sentryOptions.getLogger().log(SentryLevel.DEBUG, "Health check negative, downsampling with a factor of %d", Integer.valueOf(this.downsampleFactor));
            }
        }
    }

    private void reschedule(int i) {
        ISentryExecutorService executorService = this.sentryOptions.getExecutorService();
        if (executorService.isClosed()) {
            return;
        }
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            try {
                this.latestScheduledRun = executorService.schedule(this, i);
            } catch (RejectedExecutionException e) {
                this.sentryOptions.getLogger().log(SentryLevel.WARNING, "Backpressure monitor reschedule task rejected", e);
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

    private boolean isHealthy() {
        return this.scopes.isHealthy();
    }
}
