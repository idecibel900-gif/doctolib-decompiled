package org.bouncycastle.pqc.crypto.slhdsa;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class SLHDSAPublicKeyParameters extends SLHDSAKeyParameters {
    private final PK pk;

    public SLHDSAPublicKeyParameters(SLHDSAParameters sLHDSAParameters, byte[] bArr) {
        super(false, sLHDSAParameters);
        int n = sLHDSAParameters.getN();
        int i = n * 2;
        if (bArr.length != i) {
            throw new IllegalArgumentException("public key encoding does not match parameters");
        }
        this.pk = new PK(Arrays.copyOfRange(bArr, 0, n), Arrays.copyOfRange(bArr, n, i));
    }

    public byte[] getEncoded() {
        PK pk = this.pk;
        return Arrays.concatenate(pk.seed, pk.root);
    }
}
