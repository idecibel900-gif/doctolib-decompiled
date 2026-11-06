package kotlin.jdk7;

import androidx.core.content.res.FontResourcesParserCompat$$ExternalSyntheticAutoCloseableDispatcher0;
import kotlin.ExceptionsKt;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AutoCloseableKt {
    public static final void closeFinally(AutoCloseable autoCloseable, Throwable th) throws Exception {
        if (autoCloseable != null) {
            if (th == null) {
                FontResourcesParserCompat$$ExternalSyntheticAutoCloseableDispatcher0.m(autoCloseable);
                return;
            }
            try {
                FontResourcesParserCompat$$ExternalSyntheticAutoCloseableDispatcher0.m(autoCloseable);
            } catch (Throwable th2) {
                ExceptionsKt.addSuppressed(th, th2);
            }
        }
    }
}
