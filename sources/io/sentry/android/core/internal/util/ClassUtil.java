package io.sentry.android.core.internal.util;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ClassUtil {
    public static String getClassName(Object obj) {
        if (obj == null) {
            return null;
        }
        String canonicalName = obj.getClass().getCanonicalName();
        return canonicalName != null ? canonicalName : obj.getClass().getSimpleName();
    }
}
