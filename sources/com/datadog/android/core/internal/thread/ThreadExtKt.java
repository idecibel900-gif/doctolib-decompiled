package com.datadog.android.core.internal.thread;

import com.datadog.android.api.InternalLogger;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ThreadExtKt {
    public static final boolean sleepSafe(long j, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            try {
                Thread.sleep(j);
                return false;
            } catch (SecurityException e) {
                InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.core.internal.thread.ThreadExtKt.sleepSafe.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Thread was unable to set its own interrupted state";
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
                return true;
            }
        } catch (IllegalArgumentException e2) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.core.internal.thread.ThreadExtKt.sleepSafe.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Thread tried to sleep for a negative amount of time";
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            return false;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0042  */
    /* JADX WARN: Code duplicated, block: B:27:? A[RETURN, SYNTHETIC] */
    public static final void loggingAfterExecute(Runnable runnable, Throwable th, InternalLogger logger) {
        Throwable th2;
        Throwable e;
        Intrinsics.checkNotNullParameter(logger, "logger");
        if (th == null && (runnable instanceof Future) && ((Future) runnable).isDone()) {
            try {
                try {
                    ((Future) runnable).get();
                } catch (SecurityException e2) {
                    InternalLogger.DefaultImpls.log$default(logger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.core.internal.thread.ThreadExtKt.loggingAfterExecute.1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Thread was unable to set its own interrupted state";
                        }
                    }, (Throwable) e2, false, (Map) null, 48, (Object) null);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (CancellationException e3) {
                e = e3;
                th2 = e;
                if (th2 != null) {
                    InternalLogger.DefaultImpls.log$default(logger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.core.internal.thread.ThreadExtKt.loggingAfterExecute.2
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Uncaught exception during the task execution";
                        }
                    }, th2, false, (Map) null, 48, (Object) null);
                }
            } catch (ExecutionException e4) {
                e = e4.getCause();
                th2 = e;
                if (th2 != null) {
                    InternalLogger.DefaultImpls.log$default(logger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.core.internal.thread.ThreadExtKt.loggingAfterExecute.2
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Uncaught exception during the task execution";
                        }
                    }, th2, false, (Map) null, 48, (Object) null);
                }
            }
        }
        th2 = th;
        if (th2 != null) {
            InternalLogger.DefaultImpls.log$default(logger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.core.internal.thread.ThreadExtKt.loggingAfterExecute.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Uncaught exception during the task execution";
                }
            }, th2, false, (Map) null, 48, (Object) null);
        }
    }
}
