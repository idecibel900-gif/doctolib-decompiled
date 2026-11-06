package org.bouncycastle.pqc.crypto.saber;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;

/* JADX INFO: loaded from: classes5.dex */
class SABEREngine {
    private final int SABER_BYTES_CCA_DEC;
    private final int SABER_EQ;
    private final int SABER_ET;
    private final int SABER_INDCPA_PUBLICKEYBYTES;
    private final int SABER_INDCPA_SECRETKEYBYTES;
    private final int SABER_L;
    private final int SABER_MU;
    private final int SABER_POLYBYTES;
    private final int SABER_POLYCOINBYTES;
    private final int SABER_POLYCOMPRESSEDBYTES;
    private final int SABER_POLYVECBYTES;
    private final int SABER_POLYVECCOMPRESSEDBYTES;
    private final int SABER_PUBLICKEYBYTES;
    private final int SABER_SCALEBYTES_KEM;
    private final int SABER_SECRETKEYBYTES;
    private final int defaultKeySize;
    private final int h1;
    private final int h2;
    private final Poly poly;
    protected final Symmetric symmetric;
    private final boolean usingAES;
    protected final boolean usingEffectiveMasking;
    private final Utils utils;

    public SABEREngine(int i, int i2, boolean z, boolean z2) {
        int i3;
        this.defaultKeySize = i2;
        this.usingAES = z;
        this.usingEffectiveMasking = z2;
        this.SABER_L = i;
        if (i == 2) {
            this.SABER_MU = 10;
            this.SABER_ET = 3;
        } else {
            if (i == 3) {
                this.SABER_MU = 8;
                i3 = 4;
            } else {
                i3 = 6;
                this.SABER_MU = 6;
            }
            this.SABER_ET = i3;
        }
        this.symmetric = z ? new Symmetric.AesSymmetric() : new Symmetric.ShakeSymmetric();
        if (z2) {
            this.SABER_EQ = 12;
            this.SABER_POLYCOINBYTES = 64;
        } else {
            this.SABER_EQ = 13;
            this.SABER_POLYCOINBYTES = (this.SABER_MU * IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) / 8;
        }
        int i4 = this.SABER_EQ;
        int i5 = (i4 * IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) / 8;
        this.SABER_POLYBYTES = i5;
        int i6 = i5 * i;
        this.SABER_POLYVECBYTES = i6;
        this.SABER_POLYCOMPRESSEDBYTES = 320;
        int i7 = i * 320;
        this.SABER_POLYVECCOMPRESSEDBYTES = i7;
        int i8 = this.SABER_ET;
        int i9 = (i8 * IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) / 8;
        this.SABER_SCALEBYTES_KEM = i9;
        int i10 = i7 + 32;
        this.SABER_INDCPA_PUBLICKEYBYTES = i10;
        this.SABER_INDCPA_SECRETKEYBYTES = i6;
        this.SABER_PUBLICKEYBYTES = i10;
        this.SABER_SECRETKEYBYTES = i6 + i10 + 64;
        this.SABER_BYTES_CCA_DEC = i7 + i9;
        this.h1 = 1 << (i4 - 11);
        this.h2 = (256 - (1 << (9 - i8))) + (1 << (i4 - 11));
        this.utils = new Utils(this);
        this.poly = new Poly(this);
    }

    public int getSABER_EP() {
        return 10;
    }

    public int getSABER_ET() {
        return this.SABER_ET;
    }

    public int getSABER_KEYBYTES() {
        return 32;
    }

    public int getSABER_L() {
        return this.SABER_L;
    }

    public int getSABER_N() {
        return IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
    }

    public int getSABER_POLYBYTES() {
        return this.SABER_POLYBYTES;
    }

    public Utils getUtils() {
        return this.utils;
    }
}
