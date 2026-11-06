package com.datadog.android.internal.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ByteArrayExtKt {
    public static final String toHexString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append("0123456789abcdef".charAt((b & 255) >>> 4));
            sb.append("0123456789abcdef".charAt(b & 15));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "result.toString()");
        return string;
    }
}
