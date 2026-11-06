package org.bouncycastle.pqc.crypto.hqc;

/* JADX INFO: loaded from: classes5.dex */
class HQCEngine {
    private int K_BYTE;
    private int K_BYTE_64;
    private int N1N2_BYTE;
    private int N1N2_BYTE_64;
    private int N1_BYTE;
    private int N1_BYTE_64;
    private int N_BYTE;
    private int N_BYTE_64;
    private long RED_MASK;
    private int delta;
    private int fft;
    private int g;
    private int[] generatorPoly;
    private GF2PolynomialCalculator gfCalculator;
    private int k;
    private int mulParam;
    private int n;
    private int n1;
    private int n1n2;
    private int n2;
    private int rejectionThreshold;
    private int w;
    private int we;
    private int wr;
    private int SEED_SIZE = 40;
    private byte G_FCT_DOMAIN = 3;
    private byte K_FCT_DOMAIN = 4;
    private int GF_POLY_WT = 5;
    private int GF_POLY_M2 = 4;
    private int SALT_SIZE_BYTES = 16;
    private int SALT_SIZE_64 = 2;
    private int SHA512_BYTES = 64;

    public HQCEngine(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int[] iArr) {
        this.n = i;
        this.k = i4;
        this.delta = i6;
        this.w = i7;
        this.wr = i8;
        this.we = i9;
        this.n1 = i2;
        this.n2 = i3;
        int i12 = i2 * i3;
        this.n1n2 = i12;
        this.generatorPoly = iArr;
        this.g = i5;
        this.rejectionThreshold = i10;
        this.fft = i11;
        this.mulParam = (int) Math.ceil(i3 / 128);
        this.N_BYTE = Utils.getByteSizeFromBitSize(i);
        this.K_BYTE = i4;
        this.N_BYTE_64 = Utils.getByte64SizeFromBitSize(i);
        this.K_BYTE_64 = Utils.getByteSizeFromBitSize(i4);
        this.N1_BYTE_64 = Utils.getByteSizeFromBitSize(i2);
        this.N1N2_BYTE_64 = Utils.getByte64SizeFromBitSize(i12);
        this.N1N2_BYTE = Utils.getByteSizeFromBitSize(i12);
        this.N1_BYTE = Utils.getByteSizeFromBitSize(i2);
        long j = (1 << ((int) (((long) i) % 64))) - 1;
        this.RED_MASK = j;
        this.gfCalculator = new GF2PolynomialCalculator(this.N_BYTE_64, i, j);
    }
}
