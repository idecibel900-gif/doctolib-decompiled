package org.bouncycastle.pqc.crypto.bike;

/* JADX INFO: loaded from: classes5.dex */
class BIKEEngine {
    private int L_BYTE;
    private int R2_BYTE;
    private int R_BYTE;
    private final BIKERing bikeRing;
    private int hw;
    private int nbIter;
    private int r;
    private int t;
    private int tau;
    private int w;

    public BIKEEngine(int i, int i2, int i3, int i4, int i5, int i6) {
        this.r = i;
        this.w = i2;
        this.t = i3;
        this.nbIter = i5;
        this.tau = i6;
        this.hw = i2 / 2;
        this.L_BYTE = i4 / 8;
        this.R_BYTE = (i + 7) >>> 3;
        this.R2_BYTE = ((i * 2) + 7) >>> 3;
        this.bikeRing = new BIKERing(i);
    }
}
