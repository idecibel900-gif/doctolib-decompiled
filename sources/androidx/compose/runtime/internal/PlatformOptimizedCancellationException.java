package androidx.compose.runtime.internal;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public abstract class PlatformOptimizedCancellationException extends CancellationException {
    public PlatformOptimizedCancellationException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
