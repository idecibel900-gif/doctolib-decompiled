package org.bouncycastle.pqc.crypto.slhdsa;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class SLHDSAPrivateKeyParameters extends SLHDSAKeyParameters {
    final PK pk;
    final SK sk;

    public SLHDSAPrivateKeyParameters(SLHDSAParameters sLHDSAParameters, byte[] bArr) {
        super(true, sLHDSAParameters);
        int n = sLHDSAParameters.getN();
        int i = n * 4;
        if (bArr.length != i) {
            throw new IllegalArgumentException("private key encoding does not match parameters");
        }
        int i2 = n * 2;
        this.sk = new SK(Arrays.copyOfRange(bArr, 0, n), Arrays.copyOfRange(bArr, n, i2));
        int i3 = n * 3;
        this.pk = new PK(Arrays.copyOfRange(bArr, i2, i3), Arrays.copyOfRange(bArr, i3, i));
    }

    public byte[] getEncoded() {
        SK sk = this.sk;
        byte[] bArr = sk.seed;
        byte[] bArr2 = sk.prf;
        PK pk = this.pk;
        return Arrays.concatenate(new byte[][]{bArr, bArr2, pk.seed, pk.root});
    }
}
