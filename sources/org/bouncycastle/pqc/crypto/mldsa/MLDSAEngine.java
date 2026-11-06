package org.bouncycastle.pqc.crypto.mldsa;

import com.facebook.imageutils.JfifUtil;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.security.SecureRandom;
import org.bouncycastle.crypto.digests.SHAKEDigest;

/* JADX INFO: loaded from: classes5.dex */
class MLDSAEngine {
    private final int CryptoBytes;
    private final int CryptoPublicKeyBytes;
    private final int CryptoSecretKeyBytes;
    private final int DilithiumBeta;
    private final int DilithiumCTilde;
    private final int DilithiumEta;
    private final int DilithiumGamma1;
    private final int DilithiumGamma2;
    private final int DilithiumK;
    private final int DilithiumL;
    private final int DilithiumMode;
    private final int DilithiumOmega;
    private final int DilithiumPolyEtaPackedBytes;
    private final int DilithiumPolyVecHPackedBytes;
    private final int DilithiumPolyW1PackedBytes;
    private final int DilithiumPolyZPackedBytes;
    private final int DilithiumTau;
    private final int PolyUniformGamma1NBlocks;
    private final SecureRandom random;
    final SHAKEDigest shake256Digest = new SHAKEDigest(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
    private final Symmetric symmetric;

    MLDSAEngine(int i, SecureRandom secureRandom) {
        int i2;
        int i3;
        int i4;
        this.DilithiumMode = i;
        if (i != 2) {
            if (i == 3) {
                this.DilithiumK = 6;
                this.DilithiumL = 5;
                this.DilithiumEta = 4;
                this.DilithiumTau = 49;
                this.DilithiumBeta = 196;
                this.DilithiumGamma1 = 524288;
                this.DilithiumGamma2 = 261888;
                this.DilithiumOmega = 55;
                this.DilithiumPolyZPackedBytes = 640;
                this.DilithiumPolyW1PackedBytes = 128;
                this.DilithiumPolyEtaPackedBytes = 128;
                i4 = 48;
            } else {
                if (i != 5) {
                    throw new IllegalArgumentException("The mode " + i + "is not supported by Crystals Dilithium!");
                }
                this.DilithiumK = 8;
                this.DilithiumL = 7;
                this.DilithiumEta = 2;
                this.DilithiumTau = 60;
                this.DilithiumBeta = 120;
                this.DilithiumGamma1 = 524288;
                this.DilithiumGamma2 = 261888;
                this.DilithiumOmega = 75;
                this.DilithiumPolyZPackedBytes = 640;
                this.DilithiumPolyW1PackedBytes = 128;
                this.DilithiumPolyEtaPackedBytes = 96;
                i4 = 64;
            }
            this.DilithiumCTilde = i4;
        } else {
            this.DilithiumK = 4;
            this.DilithiumL = 4;
            this.DilithiumEta = 2;
            this.DilithiumTau = 39;
            this.DilithiumBeta = 78;
            this.DilithiumGamma1 = 131072;
            this.DilithiumGamma2 = 95232;
            this.DilithiumOmega = 80;
            this.DilithiumPolyZPackedBytes = 576;
            this.DilithiumPolyW1PackedBytes = JfifUtil.MARKER_SOFn;
            this.DilithiumPolyEtaPackedBytes = 96;
            this.DilithiumCTilde = 32;
        }
        Symmetric.ShakeSymmetric shakeSymmetric = new Symmetric.ShakeSymmetric();
        this.symmetric = shakeSymmetric;
        this.random = secureRandom;
        int i5 = this.DilithiumOmega;
        int i6 = this.DilithiumK;
        int i7 = i5 + i6;
        this.DilithiumPolyVecHPackedBytes = i7;
        this.CryptoPublicKeyBytes = (i6 * 320) + 32;
        int i8 = this.DilithiumL;
        int i9 = this.DilithiumPolyEtaPackedBytes;
        this.CryptoSecretKeyBytes = (i8 * i9) + 128 + (i9 * i6) + (i6 * 416);
        this.CryptoBytes = this.DilithiumCTilde + (i8 * this.DilithiumPolyZPackedBytes) + i7;
        int i10 = this.DilithiumGamma1;
        if (i10 == 131072) {
            i2 = shakeSymmetric.stream256BlockBytes;
            i3 = i2 + 575;
        } else {
            if (i10 != 524288) {
                throw new RuntimeException("Wrong Dilithium Gamma1!");
            }
            i2 = shakeSymmetric.stream256BlockBytes;
            i3 = i2 + 639;
        }
        this.PolyUniformGamma1NBlocks = i3 / i2;
    }

    protected Symmetric GetSymmetric() {
        return this.symmetric;
    }

    byte[] deriveT1(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
        PolyVecMatrix polyVecMatrix = new PolyVecMatrix(this);
        PolyVecL polyVecL = new PolyVecL(this);
        PolyVecK polyVecK = new PolyVecK(this);
        PolyVecK polyVecK2 = new PolyVecK(this);
        PolyVecK polyVecK3 = new PolyVecK(this);
        Packing.unpackSecretKey(polyVecK3, polyVecL, polyVecK, bArr6, bArr4, bArr5, this);
        polyVecMatrix.expandMatrix(bArr);
        PolyVecL polyVecL2 = new PolyVecL(this);
        polyVecL.copyTo(polyVecL2);
        polyVecL2.polyVecNtt();
        polyVecMatrix.pointwiseMontgomery(polyVecK2, polyVecL2);
        polyVecK2.reduce();
        polyVecK2.invNttToMont();
        polyVecK2.addPolyVecK(polyVecK);
        polyVecK2.conditionalAddQ();
        polyVecK2.power2Round(polyVecK3);
        return Packing.packPublicKey(polyVecK2, this);
    }

    byte[][] generateKeyPairInternal(byte[] bArr) {
        byte[] bArr2 = new byte[128];
        byte[] bArr3 = new byte[64];
        byte[] bArr4 = new byte[32];
        byte[] bArr5 = new byte[64];
        byte[] bArr6 = new byte[32];
        PolyVecMatrix polyVecMatrix = new PolyVecMatrix(this);
        PolyVecL polyVecL = new PolyVecL(this);
        PolyVecK polyVecK = new PolyVecK(this);
        PolyVecK polyVecK2 = new PolyVecK(this);
        PolyVecK polyVecK3 = new PolyVecK(this);
        this.shake256Digest.update(bArr, 0, 32);
        this.shake256Digest.update((byte) this.DilithiumK);
        this.shake256Digest.update((byte) this.DilithiumL);
        this.shake256Digest.doFinal(bArr2, 0, 128);
        System.arraycopy(bArr2, 0, bArr4, 0, 32);
        System.arraycopy(bArr2, 32, bArr5, 0, 64);
        System.arraycopy(bArr2, 96, bArr6, 0, 32);
        polyVecMatrix.expandMatrix(bArr4);
        polyVecL.uniformEta(bArr5, (short) 0);
        polyVecK.uniformEta(bArr5, (short) this.DilithiumL);
        PolyVecL polyVecL2 = new PolyVecL(this);
        polyVecL.copyTo(polyVecL2);
        polyVecL2.polyVecNtt();
        polyVecMatrix.pointwiseMontgomery(polyVecK2, polyVecL2);
        polyVecK2.reduce();
        polyVecK2.invNttToMont();
        polyVecK2.addPolyVecK(polyVecK);
        polyVecK2.conditionalAddQ();
        polyVecK2.power2Round(polyVecK3);
        byte[] bArrPackPublicKey = Packing.packPublicKey(polyVecK2, this);
        this.shake256Digest.update(bArr4, 0, 32);
        this.shake256Digest.update(bArrPackPublicKey, 0, bArrPackPublicKey.length);
        this.shake256Digest.doFinal(bArr3, 0, 64);
        byte[][] bArrPackSecretKey = Packing.packSecretKey(bArr4, bArr3, bArr6, polyVecK3, polyVecL, polyVecK, this);
        return new byte[][]{bArrPackSecretKey[0], bArrPackSecretKey[1], bArrPackSecretKey[2], bArrPackSecretKey[3], bArrPackSecretKey[4], bArrPackSecretKey[5], bArrPackPublicKey, bArr};
    }

    int getCryptoPublicKeyBytes() {
        return this.CryptoPublicKeyBytes;
    }

    int getDilithiumEta() {
        return this.DilithiumEta;
    }

    int getDilithiumK() {
        return this.DilithiumK;
    }

    int getDilithiumL() {
        return this.DilithiumL;
    }

    int getDilithiumPolyEtaPackedBytes() {
        return this.DilithiumPolyEtaPackedBytes;
    }
}
