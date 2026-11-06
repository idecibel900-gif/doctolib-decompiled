package org.bouncycastle.pqc.crypto.cmce;

/* JADX INFO: loaded from: classes5.dex */
abstract class BENES {
    private static final long[] TRANSPOSE_MASKS = {6148914691236517205L, 3689348814741910323L, 1085102592571150095L, 71777214294589695L, 281470681808895L, 4294967295L};
    protected final int GFBITS;
    protected final int SYS_N;
    protected final int SYS_T;

    public BENES(int i, int i2, int i3) {
        this.SYS_N = i;
        this.SYS_T = i2;
        this.GFBITS = i3;
    }
}
