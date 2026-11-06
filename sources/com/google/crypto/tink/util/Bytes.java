package com.google.crypto.tink.util;

import com.google.crypto.tink.subtle.Hex;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class Bytes {
    private final byte[] data;

    public static Bytes copyFrom(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("data must be non-null");
        }
        return copyFrom(bArr, 0, bArr.length);
    }

    public static Bytes copyFrom(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("data must be non-null");
        }
        return new Bytes(bArr, i, i2);
    }

    public byte[] toByteArray() {
        byte[] bArr = this.data;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private Bytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.data = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Bytes) {
            return Arrays.equals(((Bytes) obj).data, this.data);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.data);
    }

    public String toString() {
        return "Bytes(" + Hex.encode(this.data) + ")";
    }
}
