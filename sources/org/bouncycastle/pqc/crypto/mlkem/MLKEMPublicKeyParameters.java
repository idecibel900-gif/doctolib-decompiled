package org.bouncycastle.pqc.crypto.mlkem;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class MLKEMPublicKeyParameters extends MLKEMKeyParameters {
    final byte[] rho;
    final byte[] t;

    public MLKEMPublicKeyParameters(MLKEMParameters mLKEMParameters, byte[] bArr) {
        super(false, mLKEMParameters);
        this.t = Arrays.copyOfRange(bArr, 0, bArr.length - 32);
        this.rho = Arrays.copyOfRange(bArr, bArr.length - 32, bArr.length);
    }

    public MLKEMPublicKeyParameters(MLKEMParameters mLKEMParameters, byte[] bArr, byte[] bArr2) {
        super(false, mLKEMParameters);
        this.t = Arrays.clone(bArr);
        this.rho = Arrays.clone(bArr2);
    }

    static byte[] getEncoded(byte[] bArr, byte[] bArr2) {
        return Arrays.concatenate(bArr, bArr2);
    }

    public byte[] getEncoded() {
        return getEncoded(this.t, this.rho);
    }
}
