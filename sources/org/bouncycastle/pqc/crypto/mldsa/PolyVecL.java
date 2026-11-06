package org.bouncycastle.pqc.crypto.mldsa;

/* JADX INFO: loaded from: classes5.dex */
class PolyVecL {
    private final Poly[] vec;

    PolyVecL(MLDSAEngine mLDSAEngine) {
        int dilithiumL = mLDSAEngine.getDilithiumL();
        this.vec = new Poly[dilithiumL];
        for (int i = 0; i < dilithiumL; i++) {
            this.vec[i] = new Poly(mLDSAEngine);
        }
    }

    void copyTo(PolyVecL polyVecL) {
        int i = 0;
        while (true) {
            Poly[] polyArr = this.vec;
            if (i >= polyArr.length) {
                return;
            }
            polyArr[i].copyTo(polyVecL.vec[i]);
            i++;
        }
    }

    public Poly getVectorIndex(int i) {
        return this.vec[i];
    }

    public void polyVecNtt() {
        int i = 0;
        while (true) {
            Poly[] polyArr = this.vec;
            if (i >= polyArr.length) {
                return;
            }
            polyArr[i].polyNtt();
            i++;
        }
    }

    public String toString() {
        String str = "\n[";
        for (int i = 0; i < this.vec.length; i++) {
            str = str + "Inner Matrix " + i + " " + getVectorIndex(i).toString();
            if (i != this.vec.length - 1) {
                str = str + ",\n";
            }
        }
        return str + "]";
    }

    void uniformBlocks(byte[] bArr, int i) {
        int i2 = 0;
        while (true) {
            Poly[] polyArr = this.vec;
            if (i2 >= polyArr.length) {
                return;
            }
            polyArr[i2].uniformBlocks(bArr, (short) (i + i2));
            i2++;
        }
    }

    public void uniformEta(byte[] bArr, short s) {
        int i = 0;
        while (i < this.vec.length) {
            getVectorIndex(i).uniformEta(bArr, s);
            i++;
            s = (short) (s + 1);
        }
    }
}
