package org.bouncycastle.pqc.crypto.mldsa;

/* JADX INFO: loaded from: classes5.dex */
abstract class Packing {
    static byte[] packPublicKey(PolyVecK polyVecK, MLDSAEngine mLDSAEngine) {
        byte[] bArr = new byte[mLDSAEngine.getCryptoPublicKeyBytes() - 32];
        for (int i = 0; i < mLDSAEngine.getDilithiumK(); i++) {
            System.arraycopy(polyVecK.getVectorIndex(i).polyt1Pack(), 0, bArr, i * 320, 320);
        }
        return bArr;
    }

    static byte[][] packSecretKey(byte[] bArr, byte[] bArr2, byte[] bArr3, PolyVecK polyVecK, PolyVecL polyVecL, PolyVecK polyVecK2, MLDSAEngine mLDSAEngine) {
        byte[][] bArr4 = new byte[6][];
        bArr4[0] = bArr;
        bArr4[1] = bArr3;
        bArr4[2] = bArr2;
        bArr4[3] = new byte[mLDSAEngine.getDilithiumL() * mLDSAEngine.getDilithiumPolyEtaPackedBytes()];
        for (int i = 0; i < mLDSAEngine.getDilithiumL(); i++) {
            polyVecL.getVectorIndex(i).polyEtaPack(bArr4[3], mLDSAEngine.getDilithiumPolyEtaPackedBytes() * i);
        }
        bArr4[4] = new byte[mLDSAEngine.getDilithiumK() * mLDSAEngine.getDilithiumPolyEtaPackedBytes()];
        for (int i2 = 0; i2 < mLDSAEngine.getDilithiumK(); i2++) {
            polyVecK2.getVectorIndex(i2).polyEtaPack(bArr4[4], mLDSAEngine.getDilithiumPolyEtaPackedBytes() * i2);
        }
        bArr4[5] = new byte[mLDSAEngine.getDilithiumK() * 416];
        for (int i3 = 0; i3 < mLDSAEngine.getDilithiumK(); i3++) {
            polyVecK.getVectorIndex(i3).polyt0Pack(bArr4[5], i3 * 416);
        }
        return bArr4;
    }

    static void unpackSecretKey(PolyVecK polyVecK, PolyVecL polyVecL, PolyVecK polyVecK2, byte[] bArr, byte[] bArr2, byte[] bArr3, MLDSAEngine mLDSAEngine) {
        for (int i = 0; i < mLDSAEngine.getDilithiumL(); i++) {
            polyVecL.getVectorIndex(i).polyEtaUnpack(bArr2, mLDSAEngine.getDilithiumPolyEtaPackedBytes() * i);
        }
        for (int i2 = 0; i2 < mLDSAEngine.getDilithiumK(); i2++) {
            polyVecK2.getVectorIndex(i2).polyEtaUnpack(bArr3, mLDSAEngine.getDilithiumPolyEtaPackedBytes() * i2);
        }
        for (int i3 = 0; i3 < mLDSAEngine.getDilithiumK(); i3++) {
            polyVecK.getVectorIndex(i3).polyt0Unpack(bArr, i3 * 416);
        }
    }
}
