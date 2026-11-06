package org.bouncycastle.pqc.crypto.falcon;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class FalconPrivateKeyParameters extends FalconKeyParameters {
    private final byte[] F;
    private final byte[] f;
    private final byte[] g;
    private final byte[] pk;

    public FalconPrivateKeyParameters(FalconParameters falconParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        super(true, falconParameters);
        this.f = Arrays.clone(bArr);
        this.g = Arrays.clone(bArr2);
        this.F = Arrays.clone(bArr3);
        this.pk = Arrays.clone(bArr4);
    }

    public byte[] getG() {
        return Arrays.clone(this.g);
    }

    public byte[] getPublicKey() {
        return Arrays.clone(this.pk);
    }

    public byte[] getSpolyF() {
        return Arrays.clone(this.F);
    }

    public byte[] getSpolyf() {
        return Arrays.clone(this.f);
    }
}
