package org.apache.commons.lang3;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Validate {
    public static void isTrue(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static Object notNull(Object obj, String str, Object... objArr) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.format(str, objArr));
    }
}
