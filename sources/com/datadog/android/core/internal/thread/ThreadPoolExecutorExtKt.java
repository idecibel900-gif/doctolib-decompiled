package com.datadog.android.core.internal.thread;

import com.datadog.android.api.InternalLogger;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ThreadPoolExecutorExtKt {
    public static final boolean waitToIdle(ThreadPoolExecutor threadPoolExecutor, long j, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(threadPoolExecutor, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        long jNanoTime = System.nanoTime();
        long nanos = TimeUnit.MILLISECONDS.toNanos(j);
        long jCoerceIn = RangesKt.coerceIn(j, 0L, 10L);
        while (!isIdle(threadPoolExecutor)) {
            boolean zSleepSafe = ThreadExtKt.sleepSafe(jCoerceIn, internalLogger);
            if (System.nanoTime() - jNanoTime >= nanos || zSleepSafe) {
                return isIdle(threadPoolExecutor);
            }
        }
        return true;
    }

    public static final boolean isIdle(ThreadPoolExecutor threadPoolExecutor) {
        Intrinsics.checkNotNullParameter(threadPoolExecutor, "<this>");
        return threadPoolExecutor.getTaskCount() - threadPoolExecutor.getCompletedTaskCount() <= 0;
    }
}
