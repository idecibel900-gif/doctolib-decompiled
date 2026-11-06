package org.bouncycastle.pqc.crypto.mlkem;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
class MLKEMIndCpa {
    public final int KyberGenerateMatrixNBlocks;
    private MLKEMEngine engine;
    private int indCpaBytes;
    private int indCpaPublicKeyBytes;
    private int kyberK;
    private int polyCompressedBytes;
    private int polyVecBytes;
    private int polyVecCompressedBytes;
    private Symmetric symmetric;

    public MLKEMIndCpa(MLKEMEngine mLKEMEngine) {
        this.engine = mLKEMEngine;
        this.kyberK = mLKEMEngine.getKyberK();
        this.indCpaPublicKeyBytes = mLKEMEngine.getKyberPublicKeyBytes();
        this.polyVecBytes = mLKEMEngine.getKyberPolyVecBytes();
        this.indCpaBytes = mLKEMEngine.getKyberIndCpaBytes();
        this.polyVecCompressedBytes = mLKEMEngine.getKyberPolyVecCompressedBytes();
        this.polyCompressedBytes = mLKEMEngine.getKyberPolyCompressedBytes();
        Symmetric symmetric = mLKEMEngine.getSymmetric();
        this.symmetric = symmetric;
        int i = symmetric.xofBlockBytes;
        this.KyberGenerateMatrixNBlocks = (i + 472) / i;
    }

    private static int rejectionSampling(Poly poly, int i, int i2, byte[] bArr, int i3) {
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = i5 + 3;
            if (i6 > i3) {
                break;
            }
            short s = (short) (bArr[i5] & 255);
            byte b = bArr[i5 + 1];
            short s2 = (short) ((s | (((short) (b & 255)) << 8)) & 4095);
            short s3 = (short) (((((short) (bArr[i5 + 2] & 255)) << 4) | (((short) (b & 255)) >> 4)) & 4095);
            if (s2 < 3329) {
                poly.setCoeffIndex(i + i4, s2);
                i4++;
            }
            if (i4 < i2 && s3 < 3329) {
                poly.setCoeffIndex(i + i4, s3);
                i4++;
            }
            i5 = i6;
        }
        return i4;
    }

    byte[][] generateKeyPair(byte[] bArr) {
        PolyVec polyVec = new PolyVec(this.engine);
        PolyVec polyVec2 = new PolyVec(this.engine);
        PolyVec polyVec3 = new PolyVec(this.engine);
        byte[] bArr2 = new byte[64];
        this.symmetric.hash_g(bArr2, Arrays.append(bArr, (byte) this.kyberK));
        byte[] bArr3 = new byte[32];
        byte[] bArr4 = new byte[32];
        System.arraycopy(bArr2, 0, bArr3, 0, 32);
        System.arraycopy(bArr2, 32, bArr4, 0, 32);
        PolyVec[] polyVecArr = new PolyVec[this.kyberK];
        for (int i = 0; i < this.kyberK; i++) {
            polyVecArr[i] = new PolyVec(this.engine);
        }
        generateMatrix(polyVecArr, bArr3, false);
        byte b = 0;
        for (int i2 = 0; i2 < this.kyberK; i2++) {
            polyVec.getVectorIndex(i2).getEta1Noise(bArr4, b);
            b = (byte) (b + 1);
        }
        for (int i3 = 0; i3 < this.kyberK; i3++) {
            polyVec3.getVectorIndex(i3).getEta1Noise(bArr4, b);
            b = (byte) (b + 1);
        }
        polyVec.polyVecNtt();
        polyVec3.polyVecNtt();
        for (int i4 = 0; i4 < this.kyberK; i4++) {
            PolyVec.pointwiseAccountMontgomery(polyVec2.getVectorIndex(i4), polyVecArr[i4], polyVec, this.engine);
            polyVec2.getVectorIndex(i4).convertToMont();
        }
        polyVec2.addPoly(polyVec3);
        polyVec2.reducePoly();
        return new byte[][]{packPublicKey(polyVec2, bArr3), packSecretKey(polyVec)};
    }

    public void generateMatrix(PolyVec[] polyVecArr, byte[] bArr, boolean z) {
        byte b;
        byte b2;
        byte[] bArr2 = new byte[(this.KyberGenerateMatrixNBlocks * this.symmetric.xofBlockBytes) + 2];
        for (int i = 0; i < this.kyberK; i++) {
            for (int i2 = 0; i2 < this.kyberK; i2++) {
                Symmetric symmetric = this.symmetric;
                if (z) {
                    b = (byte) i;
                    b2 = (byte) i2;
                } else {
                    b = (byte) i2;
                    b2 = (byte) i;
                }
                symmetric.xofAbsorb(bArr, b, b2);
                Symmetric symmetric2 = this.symmetric;
                symmetric2.xofSqueezeBlocks(bArr2, 0, symmetric2.xofBlockBytes * this.KyberGenerateMatrixNBlocks);
                int i3 = this.KyberGenerateMatrixNBlocks * this.symmetric.xofBlockBytes;
                int iRejectionSampling = rejectionSampling(polyVecArr[i].getVectorIndex(i2), 0, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, bArr2, i3);
                while (iRejectionSampling < 256) {
                    int i4 = i3 % 3;
                    for (int i5 = 0; i5 < i4; i5++) {
                        bArr2[i5] = bArr2[(i3 - i4) + i5];
                    }
                    Symmetric symmetric3 = this.symmetric;
                    symmetric3.xofSqueezeBlocks(bArr2, i4, symmetric3.xofBlockBytes * 2);
                    i3 = this.symmetric.xofBlockBytes + i4;
                    iRejectionSampling += rejectionSampling(polyVecArr[i].getVectorIndex(i2), iRejectionSampling, 256 - iRejectionSampling, bArr2, i3);
                }
            }
        }
    }

    public byte[] packPublicKey(PolyVec polyVec, byte[] bArr) {
        byte[] bArr2 = new byte[this.indCpaPublicKeyBytes];
        System.arraycopy(polyVec.toBytes(), 0, bArr2, 0, this.polyVecBytes);
        System.arraycopy(bArr, 0, bArr2, this.polyVecBytes, 32);
        return bArr2;
    }

    public byte[] packSecretKey(PolyVec polyVec) {
        return polyVec.toBytes();
    }
}
