package org.bouncycastle.pqc.crypto.ntruprime;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class NTRULPRimePublicKeyParameters extends NTRULPRimeKeyParameters {
    private final byte[] roundEncA;
    private final byte[] seed;

    public NTRULPRimePublicKeyParameters(NTRULPRimeParameters nTRULPRimeParameters, byte[] bArr) {
        super(false, nTRULPRimeParameters);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 32);
        this.seed = bArrCopyOfRange;
        this.roundEncA = Arrays.copyOfRange(bArr, bArrCopyOfRange.length, bArr.length);
    }

    public byte[] getEncoded() {
        byte[] bArr = new byte[getParameters().getPublicKeyBytes()];
        byte[] bArr2 = this.seed;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        byte[] bArr3 = this.roundEncA;
        System.arraycopy(bArr3, 0, bArr, this.seed.length, bArr3.length);
        return bArr;
    }
}
