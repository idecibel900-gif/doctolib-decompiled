package org.bouncycastle.pqc.crypto.sphincsplus;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class SPHINCSPlusPrivateKeyParameters extends SPHINCSPlusKeyParameters {
    final PK pk;
    final SK sk;

    public SPHINCSPlusPrivateKeyParameters(SPHINCSPlusParameters sPHINCSPlusParameters, byte[] bArr) {
        super(true, sPHINCSPlusParameters);
        int n = sPHINCSPlusParameters.getN();
        int i = n * 4;
        if (bArr.length != i) {
            throw new IllegalArgumentException("private key encoding does not match parameters");
        }
        int i2 = n * 2;
        this.sk = new SK(Arrays.copyOfRange(bArr, 0, n), Arrays.copyOfRange(bArr, n, i2));
        int i3 = n * 3;
        this.pk = new PK(Arrays.copyOfRange(bArr, i2, i3), Arrays.copyOfRange(bArr, i3, i));
    }

    public SPHINCSPlusPrivateKeyParameters(SPHINCSPlusParameters sPHINCSPlusParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        super(true, sPHINCSPlusParameters);
        this.sk = new SK(bArr, bArr2);
        this.pk = new PK(bArr3, bArr4);
    }

    public byte[] getEncoded() {
        SK sk = this.sk;
        byte[] bArr = sk.seed;
        byte[] bArr2 = sk.prf;
        PK pk = this.pk;
        return Arrays.concatenate(new byte[][]{bArr, bArr2, pk.seed, pk.root});
    }

    public byte[] getPublicKey() {
        PK pk = this.pk;
        return Arrays.concatenate(pk.seed, pk.root);
    }
}
