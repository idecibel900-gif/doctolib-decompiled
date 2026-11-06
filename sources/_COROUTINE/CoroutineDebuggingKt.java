package _COROUTINE;

import com.amazon.a.a.o.c.a.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class CoroutineDebuggingKt {
    private static final String ARTIFICIAL_FRAME_PACKAGE_NAME = "_COROUTINE";

    /* JADX INFO: Access modifiers changed from: private */
    public static final StackTraceElement artificialFrame(Throwable th, String str) {
        StackTraceElement stackTraceElement = th.getStackTrace()[0];
        return new StackTraceElement(ARTIFICIAL_FRAME_PACKAGE_NAME + b.a + str, "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
    }
}
