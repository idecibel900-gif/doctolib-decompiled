package io.sentry.android.replay.util;

import androidx.core.content.res.FontResourcesParserCompat$$ExternalSyntheticAutoCloseableForwarder1;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class ReplayExecutorService implements ScheduledExecutorService, AutoCloseable {
    private final ScheduledExecutorService delegate;
    private final SentryOptions options;

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.delegate.awaitTermination(j, timeUnit);
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        FontResourcesParserCompat$$ExternalSyntheticAutoCloseableForwarder1.m(this);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.delegate.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection) {
        return this.delegate.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection, long j, TimeUnit timeUnit) {
        return this.delegate.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection) {
        return this.delegate.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection, long j, TimeUnit timeUnit) {
        return this.delegate.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.delegate.schedule(runnable, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        return this.delegate.schedule(callable, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.delegate.scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.delegate.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public List shutdownNow() {
        return this.delegate.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable, Object obj) {
        return this.delegate.submit(runnable, obj);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Callable callable) {
        return this.delegate.submit(callable);
    }

    public ReplayExecutorService(ScheduledExecutorService delegate, SentryOptions options) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(options, "options");
        this.delegate = delegate;
        this.options = options;
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(final Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        String name = Thread.currentThread().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (StringsKt.startsWith$default(name, "SentryReplayIntegration", false, 2, (Object) null)) {
            task.run();
            return null;
        }
        try {
            return this.delegate.submit(new Runnable() { // from class: io.sentry.android.replay.util.ReplayExecutorService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ReplayExecutorService.submit$lambda$0(task, this);
                }
            });
        } catch (Throwable th) {
            ILogger logger = this.options.getLogger();
            SentryLevel sentryLevel = SentryLevel.ERROR;
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to submit task ");
            sb.append(task instanceof ReplayRunnable ? ((ReplayRunnable) task).getTaskName() : "");
            sb.append(" to executor");
            logger.log(sentryLevel, sb.toString(), th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submit$lambda$0(Runnable runnable, ReplayExecutorService replayExecutorService) {
        try {
            runnable.run();
        } catch (Throwable th) {
            ILogger logger = replayExecutorService.options.getLogger();
            SentryLevel sentryLevel = SentryLevel.ERROR;
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to execute task ");
            sb.append(runnable instanceof ReplayRunnable ? ((ReplayRunnable) runnable).getTaskName() : "");
            logger.log(sentryLevel, sb.toString(), th);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        synchronized (this) {
            if (!isShutdown()) {
                this.delegate.shutdown();
            }
            try {
                if (!awaitTermination(this.options.getShutdownTimeoutMillis(), TimeUnit.MILLISECONDS)) {
                    shutdownNow();
                }
            } catch (InterruptedException unused) {
                shutdownNow();
                Thread.currentThread().interrupt();
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
