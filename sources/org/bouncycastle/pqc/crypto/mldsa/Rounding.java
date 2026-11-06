package org.bouncycastle.pqc.crypto.mldsa;

/* JADX INFO: loaded from: classes5.dex */
abstract class Rounding {
    public static int[] power2Round(int i) {
        int i2 = (i + 4095) >> 13;
        return new int[]{i2, i - (i2 << 13)};
    }
}
