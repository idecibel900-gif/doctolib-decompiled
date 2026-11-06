package org.bouncycastle.pqc.crypto.mldsa;

/* JADX INFO: loaded from: classes5.dex */
class PolyVecMatrix {
    private final PolyVecL[] matrix;

    PolyVecMatrix(MLDSAEngine mLDSAEngine) {
        int dilithiumK = mLDSAEngine.getDilithiumK();
        this.matrix = new PolyVecL[dilithiumK];
        for (int i = 0; i < dilithiumK; i++) {
            this.matrix[i] = new PolyVecL(mLDSAEngine);
        }
    }

    public void expandMatrix(byte[] bArr) {
        int i = 0;
        while (true) {
            PolyVecL[] polyVecLArr = this.matrix;
            if (i >= polyVecLArr.length) {
                return;
            }
            polyVecLArr[i].uniformBlocks(bArr, i << 8);
            i++;
        }
    }

    public void pointwiseMontgomery(PolyVecK polyVecK, PolyVecL polyVecL) {
        for (int i = 0; i < this.matrix.length; i++) {
            polyVecK.getVectorIndex(i).pointwiseAccountMontgomery(this.matrix[i], polyVecL);
        }
    }
}
