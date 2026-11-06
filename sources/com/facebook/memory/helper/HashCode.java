package com.facebook.memory.helper;

/* JADX INFO: loaded from: classes3.dex */
public final class HashCode {
    public static final HashCode INSTANCE = new HashCode();

    private HashCode() {
    }

    public static final int extend(int i, Object obj) {
        return (i * 31) + (obj != null ? obj.hashCode() : 0);
    }
}
