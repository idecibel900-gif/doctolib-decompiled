package org.bouncycastle.pqc.crypto.hqc;

/* JADX INFO: loaded from: classes5.dex */
abstract class Utils {
    static int getByte64SizeFromBitSize(int i) {
        return (i + 63) / 64;
    }

    static int getByteSizeFromBitSize(int i) {
        return (i + 7) / 8;
    }
}
