package org.bouncycastle.pqc.crypto.sphincsplus;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class SPHINCSPlusPublicKeyParameters extends SPHINCSPlusKeyParameters {
    private final PK pk;

    public SPHINCSPlusPublicKeyParameters(SPHINCSPlusParameters sPHINCSPlusParameters, byte[] bArr) {
        super(false, sPHINCSPlusParameters);
        int n = sPHINCSPlusParameters.getN();
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
