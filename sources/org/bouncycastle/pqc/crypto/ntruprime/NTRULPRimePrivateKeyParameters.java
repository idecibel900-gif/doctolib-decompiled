package org.bouncycastle.pqc.crypto.ntruprime;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class NTRULPRimePrivateKeyParameters extends NTRULPRimeKeyParameters {
    private final byte[] enca;
    private final byte[] hash;
    private final byte[] pk;
    private final byte[] rho;

    public NTRULPRimePrivateKeyParameters(NTRULPRimeParameters nTRULPRimeParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        super(true, nTRULPRimeParameters);
        this.enca = Arrays.clone(bArr);
        this.pk = Arrays.clone(bArr2);
        this.rho = Arrays.clone(bArr3);
        this.hash = Arrays.clone(bArr4);
    }

    public byte[] getEnca() {
        return Arrays.clone(this.enca);
    }

    public byte[] getHash() {
        return Arrays.clone(this.hash);
    }

    public byte[] getPk() {
        return Arrays.clone(this.pk);
    }

    public byte[] getRho() {
        return Arrays.clone(this.rho);
    }
}
