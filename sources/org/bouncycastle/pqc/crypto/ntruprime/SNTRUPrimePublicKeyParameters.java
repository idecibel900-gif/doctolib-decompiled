package org.bouncycastle.pqc.crypto.ntruprime;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class SNTRUPrimePublicKeyParameters extends SNTRUPrimeKeyParameters {
    private final byte[] encH;

    public SNTRUPrimePublicKeyParameters(SNTRUPrimeParameters sNTRUPrimeParameters, byte[] bArr) {
        super(false, sNTRUPrimeParameters);
        this.encH = Arrays.clone(bArr);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.encH);
    }
}
