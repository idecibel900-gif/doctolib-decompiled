package kotlin.io;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CloseableKt {
    public static final void closeFinally(Closeable closeable, Throwable th) throws IOException {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                kotlin.ExceptionsKt.addSuppressed(th, th2);
            }
        }
    }
}
