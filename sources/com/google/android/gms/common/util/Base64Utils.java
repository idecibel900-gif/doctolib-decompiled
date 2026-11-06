package com.google.android.gms.common.util;

import android.util.Base64;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Base64Utils {
    public static String encodeUrlSafeNoPadding(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 11);
    }
}
