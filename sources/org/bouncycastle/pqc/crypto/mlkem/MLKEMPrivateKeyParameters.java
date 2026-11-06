package org.bouncycastle.pqc.crypto.mlkem;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class MLKEMPrivateKeyParameters extends MLKEMKeyParameters {
    final byte[] hpk;
    final byte[] nonce;
    private final int prefFormat;
    final byte[] rho;
    final byte[] s;
    final byte[] seed;
    final byte[] t;

    public MLKEMPrivateKeyParameters(MLKEMParameters mLKEMParameters, byte[] bArr) {
        this(mLKEMParameters, bArr, null);
    }

    public MLKEMPrivateKeyParameters(MLKEMParameters mLKEMParameters, byte[] bArr, MLKEMPublicKeyParameters mLKEMPublicKeyParameters) {
        super(true, mLKEMParameters);
        MLKEMEngine engine = mLKEMParameters.getEngine();
        if (bArr.length == 64) {
            byte[][] bArrGenerateKemKeyPairInternal = engine.generateKemKeyPairInternal(Arrays.copyOfRange(bArr, 0, 32), Arrays.copyOfRange(bArr, 32, bArr.length));
            this.s = bArrGenerateKemKeyPairInternal[2];
            this.hpk = bArrGenerateKemKeyPairInternal[3];
            this.nonce = bArrGenerateKemKeyPairInternal[4];
            this.t = bArrGenerateKemKeyPairInternal[0];
            this.rho = bArrGenerateKemKeyPairInternal[1];
            this.seed = bArrGenerateKemKeyPairInternal[5];
        } else {
            this.s = Arrays.copyOfRange(bArr, 0, engine.getKyberIndCpaSecretKeyBytes());
            int kyberIndCpaSecretKeyBytes = engine.getKyberIndCpaSecretKeyBytes();
            this.t = Arrays.copyOfRange(bArr, kyberIndCpaSecretKeyBytes, (engine.getKyberIndCpaPublicKeyBytes() + kyberIndCpaSecretKeyBytes) - 32);
            int kyberIndCpaPublicKeyBytes = kyberIndCpaSecretKeyBytes + (engine.getKyberIndCpaPublicKeyBytes() - 32);
            int i = kyberIndCpaPublicKeyBytes + 32;
            this.rho = Arrays.copyOfRange(bArr, kyberIndCpaPublicKeyBytes, i);
            int i2 = kyberIndCpaPublicKeyBytes + 64;
            this.hpk = Arrays.copyOfRange(bArr, i, i2);
            this.nonce = Arrays.copyOfRange(bArr, i2, kyberIndCpaPublicKeyBytes + 96);
            this.seed = null;
        }
        if (mLKEMPublicKeyParameters != null && (!Arrays.constantTimeAreEqual(this.t, mLKEMPublicKeyParameters.t) || !Arrays.constantTimeAreEqual(this.rho, mLKEMPublicKeyParameters.rho))) {
            throw new IllegalArgumentException("passed in public key does not match private values");
        }
        this.prefFormat = this.seed != null ? 0 : 2;
    }

    public byte[] getEncoded() {
        return Arrays.concatenate(new byte[][]{this.s, this.t, this.rho, this.hpk, this.nonce});
    }

    public int getPreferredFormat() {
        return this.prefFormat;
    }

    public byte[] getPublicKey() {
        return MLKEMPublicKeyParameters.getEncoded(this.t, this.rho);
    }

    public MLKEMPublicKeyParameters getPublicKeyParameters() {
        return new MLKEMPublicKeyParameters(getParameters(), this.t, this.rho);
    }

    public byte[] getSeed() {
        return Arrays.clone(this.seed);
    }
}
