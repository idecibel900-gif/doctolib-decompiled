package com.datadog.android.core.internal.utils;

import com.datadog.android.api.InternalLogger;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ConcurrencyExtKt {
    public static final void executeSafe(Executor executor, final String operationName, InternalLogger internalLogger, Runnable runnable) {
        Intrinsics.checkNotNullParameter(executor, "<this>");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        try {
            executor.execute(runnable);
        } catch (RejectedExecutionException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.utils.ConcurrencyExtKt.executeSafe.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Unable to schedule %s task on the executor", Arrays.copyOf(new Object[]{operationName}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        }
    }

    public static final ScheduledFuture scheduleSafe(ScheduledExecutorService scheduledExecutorService, final String operationName, long j, TimeUnit unit, InternalLogger internalLogger, Runnable runnable) {
        Intrinsics.checkNotNullParameter(scheduledExecutorService, "<this>");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        try {
            return scheduledExecutorService.schedule(runnable, j, unit);
        } catch (RejectedExecutionException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.utils.ConcurrencyExtKt.scheduleSafe.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Unable to schedule %s task on the executor", Arrays.copyOf(new Object[]{operationName}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }
}
