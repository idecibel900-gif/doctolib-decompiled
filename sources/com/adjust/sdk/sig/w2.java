package com.adjust.sdk.sig;

/* JADX INFO: loaded from: classes3.dex */
public abstract class w2 {
    public static final String[] a;
    public static final byte[] b;

    static {
        String[] strArr = new String[93];
        for (int i = 0; i < 32; i++) {
            int i2 = (i >> 12) & 15;
            int i3 = (i >> 8) & 15;
            int i4 = (i >> 4) & 15;
            int i5 = i & 15;
            strArr[i] = "\\u" + ((char) (i2 < 10 ? i2 + 48 : i2 + 87)) + ((char) (i3 < 10 ? i3 + 48 : i3 + 87)) + ((char) (i4 < 10 ? i4 + 48 : i4 + 87)) + ((char) (i5 < 10 ? i5 + 48 : i5 + 87));
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        a = strArr;
        byte[] bArr = new byte[93];
        for (int i6 = 0; i6 < 32; i6++) {
            bArr[i6] = 1;
        }
        bArr[34] = 34;
        bArr[92] = 92;
        bArr[9] = 116;
        bArr[8] = 98;
        bArr[10] = 110;
        bArr[13] = 114;
        bArr[12] = 102;
        b = bArr;
    }
}
