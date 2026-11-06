package org.bouncycastle.pqc.crypto.mldsa;

/* JADX INFO: loaded from: classes5.dex */
class PolyVecK {
    private final Poly[] vec;

    PolyVecK(MLDSAEngine mLDSAEngine) {
        int dilithiumK = mLDSAEngine.getDilithiumK();
        this.vec = new Poly[dilithiumK];
        for (int i = 0; i < dilithiumK; i++) {
            this.vec[i] = new Poly(mLDSAEngine);
        }
    }

    public void addPolyVecK(PolyVecK polyVecK) {
        for (int i = 0; i < this.vec.length; i++) {
            getVectorIndex(i).addPoly(polyVecK.getVectorIndex(i));
        }
    }

    public void conditionalAddQ() {
        for (int i = 0; i < this.vec.length; i++) {
            getVectorIndex(i).conditionalAddQ();
        }
    }

    Poly getVectorIndex(int i) {
        return this.vec[i];
    }

    public void invNttToMont() {
        for (int i = 0; i < this.vec.length; i++) {
            getVectorIndex(i).invNttToMont();
        }
    }

    public void power2Round(PolyVecK polyVecK) {
        for (int i = 0; i < this.vec.length; i++) {
            getVectorIndex(i).power2Round(polyVecK.getVectorIndex(i));
        }
    }

    public void reduce() {
        for (int i = 0; i < this.vec.length; i++) {
            getVectorIndex(i).reduce();
        }
    }

    public String toString() {
        String str = "[";
        for (int i = 0; i < this.vec.length; i++) {
            str = str + i + " " + getVectorIndex(i).toString();
            if (i != this.vec.length - 1) {
                str = str + ",\n";
            }
        }
        return str + "]";
    }

    public void uniformEta(byte[] bArr, short s) {
        int i = 0;
        while (true) {
            Poly[] polyArr = this.vec;
            if (i >= polyArr.length) {
                return;
            }
            polyArr[i].uniformEta(bArr, s);
            i++;
            s = (short) (s + 1);
        }
    }
}
