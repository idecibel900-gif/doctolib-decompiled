package com.google.crypto.tink.subtle;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Hex {
    public static String encode(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            int i = b & 255;
            sb.append("0123456789abcdef".charAt(i / 16));
            sb.append("0123456789abcdef".charAt(i % 16));
        }
        return sb.toString();
    }
}
