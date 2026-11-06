package org.bouncycastle.pqc.crypto.mlkem;

/* JADX INFO: loaded from: classes5.dex */
class PolyVec {
    private MLKEMEngine engine;
    private int kyberK;
    private int polyVecBytes;
    Poly[] vec;

    public PolyVec(MLKEMEngine mLKEMEngine) {
        this.engine = mLKEMEngine;
        this.kyberK = mLKEMEngine.getKyberK();
        this.polyVecBytes = mLKEMEngine.getKyberPolyVecBytes();
        this.vec = new Poly[this.kyberK];
        for (int i = 0; i < this.kyberK; i++) {
            this.vec[i] = new Poly(mLKEMEngine);
        }
    }

    public static void pointwiseAccountMontgomery(Poly poly, PolyVec polyVec, PolyVec polyVec2, MLKEMEngine mLKEMEngine) {
        Poly poly2 = new Poly(mLKEMEngine);
        Poly.baseMultMontgomery(poly, polyVec.getVectorIndex(0), polyVec2.getVectorIndex(0));
        for (int i = 1; i < mLKEMEngine.getKyberK(); i++) {
            Poly.baseMultMontgomery(poly2, polyVec.getVectorIndex(i), polyVec2.getVectorIndex(i));
            poly.addCoeffs(poly2);
        }
        poly.reduce();
    }

    public void addPoly(PolyVec polyVec) {
        for (int i = 0; i < this.kyberK; i++) {
            getVectorIndex(i).addCoeffs(polyVec.getVectorIndex(i));
        }
    }

    public Poly getVectorIndex(int i) {
        return this.vec[i];
    }

    public void polyVecNtt() {
        for (int i = 0; i < this.kyberK; i++) {
            getVectorIndex(i).polyNtt();
        }
    }

    public void reducePoly() {
        for (int i = 0; i < this.kyberK; i++) {
            getVectorIndex(i).reduce();
        }
    }

    public byte[] toBytes() {
        byte[] bArr = new byte[this.polyVecBytes];
        for (int i = 0; i < this.kyberK; i++) {
            System.arraycopy(this.vec[i].toBytes(), 0, bArr, i * 384, 384);
        }
        return bArr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (int i = 0; i < this.kyberK; i++) {
            stringBuffer.append(this.vec[i].toString());
            if (i != this.kyberK - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
