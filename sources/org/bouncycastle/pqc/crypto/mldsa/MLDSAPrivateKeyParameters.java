package org.bouncycastle.pqc.crypto.mldsa;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class MLDSAPrivateKeyParameters extends MLDSAKeyParameters {
    final byte[] k;
    private final int prefFormat;
    final byte[] rho;
    final byte[] s1;
    final byte[] s2;
    private final byte[] seed;
    final byte[] t0;
    private final byte[] t1;
    final byte[] tr;

    public MLDSAPrivateKeyParameters(MLDSAParameters mLDSAParameters, byte[] bArr, MLDSAPublicKeyParameters mLDSAPublicKeyParameters) {
        super(true, mLDSAParameters);
        MLDSAEngine engine = mLDSAParameters.getEngine(null);
        if (bArr.length == 32) {
            byte[][] bArrGenerateKeyPairInternal = engine.generateKeyPairInternal(bArr);
            this.rho = bArrGenerateKeyPairInternal[0];
            this.k = bArrGenerateKeyPairInternal[1];
            this.tr = bArrGenerateKeyPairInternal[2];
            this.s1 = bArrGenerateKeyPairInternal[3];
            this.s2 = bArrGenerateKeyPairInternal[4];
            this.t0 = bArrGenerateKeyPairInternal[5];
            this.t1 = bArrGenerateKeyPairInternal[6];
            this.seed = bArrGenerateKeyPairInternal[7];
        } else {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 32);
            this.rho = bArrCopyOfRange;
            byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, 32, 64);
            this.k = bArrCopyOfRange2;
            byte[] bArrCopyOfRange3 = Arrays.copyOfRange(bArr, 64, 128);
            this.tr = bArrCopyOfRange3;
            int dilithiumL = (engine.getDilithiumL() * engine.getDilithiumPolyEtaPackedBytes()) + 128;
            byte[] bArrCopyOfRange4 = Arrays.copyOfRange(bArr, 128, dilithiumL);
            this.s1 = bArrCopyOfRange4;
            int dilithiumK = (engine.getDilithiumK() * engine.getDilithiumPolyEtaPackedBytes()) + dilithiumL;
            byte[] bArrCopyOfRange5 = Arrays.copyOfRange(bArr, dilithiumL, dilithiumK);
            this.s2 = bArrCopyOfRange5;
            byte[] bArrCopyOfRange6 = Arrays.copyOfRange(bArr, dilithiumK, (engine.getDilithiumK() * 416) + dilithiumK);
            this.t0 = bArrCopyOfRange6;
            this.t1 = engine.deriveT1(bArrCopyOfRange, bArrCopyOfRange2, bArrCopyOfRange3, bArrCopyOfRange4, bArrCopyOfRange5, bArrCopyOfRange6);
            this.seed = null;
        }
        if (mLDSAPublicKeyParameters != null && !Arrays.constantTimeAreEqual(this.t1, mLDSAPublicKeyParameters.getT1())) {
            throw new IllegalArgumentException("passed in public key does not match private values");
        }
        this.prefFormat = this.seed != null ? 0 : 2;
    }

    public byte[] getEncoded() {
        return Arrays.concatenate(new byte[][]{this.rho, this.k, this.tr, this.s1, this.s2, this.t0});
    }

    public int getPreferredFormat() {
        return this.prefFormat;
    }

    public byte[] getSeed() {
        return Arrays.clone(this.seed);
    }
}
