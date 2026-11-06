package io.sentry.util;

import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Objects {
    public static Object requireNonNull(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new IllegalArgumentException(str);
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int hash(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
