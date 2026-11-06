package com.google.crypto.tink.subtle;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SubtleUtil {
    public static boolean isAndroid() {
        return "The Android Project".equals(System.getProperty("java.vendor"));
    }
}
