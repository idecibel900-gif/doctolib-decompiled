package org.bouncycastle.util;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Pack {
    public static int bigEndianToInt(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | (bArr[i] << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static long bigEndianToLong(byte[] bArr, int i) {
        int iBigEndianToInt = bigEndianToInt(bArr, i);
        return (((long) bigEndianToInt(bArr, i + 4)) & 4294967295L) | ((((long) iBigEndianToInt) & 4294967295L) << 32);
    }

    public static void intToBigEndian(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
    }

    public static void intToLittleEndian(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    public static int littleEndianToInt(byte[] bArr, int i) {
        return (bArr[i + 3] << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static long littleEndianToLong(byte[] bArr, int i) {
        return ((((long) littleEndianToInt(bArr, i + 4)) & 4294967295L) << 32) | (((long) littleEndianToInt(bArr, i)) & 4294967295L);
    }

    public static short littleEndianToShort(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & 255) << 8) | (bArr[i] & 255));
    }

    public static void longToBigEndian(long j, byte[] bArr, int i) {
        intToBigEndian((int) (j >>> 32), bArr, i);
        intToBigEndian((int) (j & 4294967295L), bArr, i + 4);
    }

    public static void longToLittleEndian(long j, byte[] bArr, int i) {
        intToLittleEndian((int) (4294967295L & j), bArr, i);
        intToLittleEndian((int) (j >>> 32), bArr, i + 4);
    }

    public static void longToLittleEndian(long[] jArr, int i, int i2, byte[] bArr, int i3) {
        for (int i4 = 0; i4 < i2; i4++) {
            longToLittleEndian(jArr[i + i4], bArr, i3);
            i3 += 8;
        }
    }

    public static void shortToBigEndian(short s, byte[] bArr, int i) {
        bArr[i] = (byte) (s >>> 8);
        bArr[i + 1] = (byte) s;
    }

    public static void shortToLittleEndian(short s, byte[] bArr, int i) {
        bArr[i] = (byte) s;
        bArr[i + 1] = (byte) (s >>> 8);
    }
}
