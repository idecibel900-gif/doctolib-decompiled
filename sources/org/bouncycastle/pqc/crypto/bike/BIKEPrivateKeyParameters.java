package org.bouncycastle.pqc.crypto.bike;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class BIKEPrivateKeyParameters extends BIKEKeyParameters {
    private byte[] h0;
    private byte[] h1;
    private byte[] sigma;

    public BIKEPrivateKeyParameters(BIKEParameters bIKEParameters, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(true, bIKEParameters);
        this.h0 = Arrays.clone(bArr);
        this.h1 = Arrays.clone(bArr2);
        this.sigma = Arrays.clone(bArr3);
    }

    public byte[] getEncoded() {
        return Arrays.concatenate(this.h0, this.h1, this.sigma);
    }
}
