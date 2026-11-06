package com.datadog.android.core.internal.thread;

import androidx.core.content.res.FontResourcesParserCompat$$ExternalSyntheticAutoCloseableForwarder1;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.configuration.BackPressureStrategy;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class LoggingScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor implements AutoCloseable {
    private final BackPressureStrategy backPressureStrategy;
    private final InternalLogger logger;

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        FontResourcesParserCompat$$ExternalSyntheticAutoCloseableForwarder1.m(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoggingScheduledThreadPoolExecutor(int i, final String executorContext, final InternalLogger logger, final BackPressureStrategy backPressureStrategy) {
        super(i, new DatadogThreadFactory(executorContext), new RejectedExecutionHandler() { // from class: com.datadog.android.core.internal.thread.LoggingScheduledThreadPoolExecutor$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                LoggingScheduledThreadPoolExecutor._init_$lambda$0(logger, executorContext, backPressureStrategy, runnable, threadPoolExecutor);
            }
        });
        Intrinsics.checkNotNullParameter(executorContext, "executorContext");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(backPressureStrategy, "backPressureStrategy");
        this.logger = logger;
        this.backPressureStrategy = backPressureStrategy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(InternalLogger logger, String executorContext, BackPressureStrategy backPressureStrategy, final Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        Intrinsics.checkNotNullParameter(logger, "$logger");
        Intrinsics.checkNotNullParameter(executorContext, "$executorContext");
        Intrinsics.checkNotNullParameter(backPressureStrategy, "$backPressureStrategy");
        if (runnable != null) {
            logger.log(InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.thread.LoggingScheduledThreadPoolExecutor$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Dropped scheduled item in LoggingScheduledThreadPoolExecutor queue: " + runnable;
                }
            }, (Throwable) null, false, MapsKt.mapOf(TuplesKt.to("executor.context", executorContext)));
            backPressureStrategy.getOnItemDropped().invoke(runnable);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        ThreadExtKt.loggingAfterExecute(runnable, th, this.logger);
    }
}
