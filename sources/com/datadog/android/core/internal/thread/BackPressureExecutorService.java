package com.datadog.android.core.internal.thread;

import androidx.core.content.res.FontResourcesParserCompat$$ExternalSyntheticAutoCloseableForwarder1;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.configuration.BackPressureStrategy;
import com.datadog.android.core.thread.FlushableExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BackPressureExecutorService extends ThreadPoolExecutor implements FlushableExecutorService, AutoCloseable {
    public static final Companion Companion = new Companion(null);
    private static final long THREAD_POOL_MAX_KEEP_ALIVE_MS = TimeUnit.SECONDS.toMillis(5);
    private final InternalLogger logger;

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        FontResourcesParserCompat$$ExternalSyntheticAutoCloseableForwarder1.m(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackPressureExecutorService(InternalLogger logger, String executorContext, BackPressureStrategy backpressureStrategy) {
        super(1, 1, THREAD_POOL_MAX_KEEP_ALIVE_MS, TimeUnit.MILLISECONDS, new BackPressuredBlockingQueue(logger, executorContext, backpressureStrategy), new DatadogThreadFactory(executorContext));
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(executorContext, "executorContext");
        Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
        this.logger = logger;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        ThreadExtKt.loggingAfterExecute(runnable, th, this.logger);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
