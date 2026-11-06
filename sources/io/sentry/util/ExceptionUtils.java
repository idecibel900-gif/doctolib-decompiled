package io.sentry.util;

import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ExceptionUtils {
    public static Throwable findRootCause(Throwable th) {
        Objects.requireNonNull(th, "throwable cannot be null");
        while (th.getCause() != null && th.getCause() != th) {
            th = th.getCause();
        }
        return th;
    }

    public static boolean isIgnored(Set set, Throwable th) {
        return set.contains(th.getClass());
    }
}
