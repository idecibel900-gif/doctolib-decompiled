package org.bouncycastle.pqc.crypto.saber;

/* JADX INFO: loaded from: classes5.dex */
class Poly {
    private final int N_RES;
    private final int N_SB;
    private final int N_SB_RES;
    private final int SABER_L;
    private final int SABER_N;
    private final SABEREngine engine;
    private final Utils utils;

    public Poly(SABEREngine sABEREngine) {
        this.engine = sABEREngine;
        this.SABER_L = sABEREngine.getSABER_L();
        int saber_n = sABEREngine.getSABER_N();
        this.SABER_N = saber_n;
        this.N_RES = saber_n << 1;
        int i = saber_n >> 2;
        this.N_SB = i;
        this.N_SB_RES = (i * 2) - 1;
        this.utils = sABEREngine.getUtils();
    }
}
