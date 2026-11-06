package com.facebook.common.util;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HashCodeUtil {
    public static int hashCode(int i, int i2) {
        return ((i + 31) * 31) + i2;
    }

    public static int hashCode(Object obj, Object obj2) {
        return hashCode(obj == null ? 0 : obj.hashCode(), obj2 != null ? obj2.hashCode() : 0);
    }
}
