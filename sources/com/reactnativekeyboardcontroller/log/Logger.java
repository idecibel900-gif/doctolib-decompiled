package com.reactnativekeyboardcontroller.log;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class Logger {
    public static final Logger INSTANCE = new Logger();

    public final void i(String str, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public final void w(String str, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    private Logger() {
    }

    public static /* synthetic */ void i$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        logger.i(str, str2, th);
    }

    public static /* synthetic */ void w$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        logger.w(str, str2, th);
    }
}
