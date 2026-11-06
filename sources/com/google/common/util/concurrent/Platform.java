package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
abstract class Platform {
    static boolean isInstanceOfThrowableClass(Throwable th, Class cls) {
        return cls.isInstance(th);
    }

    static void restoreInterruptIfIsInterruptedException(Throwable th) {
        Preconditions.checkNotNull(th);
        if (th instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
    }

    static void interruptCurrentThread() {
        Thread.currentThread().interrupt();
    }

    static void rethrowIfErrorOtherThanStackOverflow(Throwable th) {
        Preconditions.checkNotNull(th);
        if ((th instanceof Error) && !(th instanceof StackOverflowError)) {
            throw ((Error) th);
        }
    }

    static Object get(AbstractFuture abstractFuture) {
        return abstractFuture.blockingGet();
    }

    static Object get(AbstractFuture abstractFuture, long j, TimeUnit timeUnit) {
        return abstractFuture.blockingGet(j, timeUnit);
    }
}
