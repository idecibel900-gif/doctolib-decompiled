package org.bouncycastle.pqc.crypto.ntruprime;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class SNTRUPrimePrivateKeyParameters extends SNTRUPrimeKeyParameters {
    private final byte[] f;
    private final byte[] ginv;
    private final byte[] hash;
    private final byte[] pk;
    private final byte[] rho;

    public SNTRUPrimePrivateKeyParameters(SNTRUPrimeParameters sNTRUPrimeParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        super(true, sNTRUPrimeParameters);
        this.f = Arrays.clone(bArr);
        this.ginv = Arrays.clone(bArr2);
        this.pk = Arrays.clone(bArr3);
        this.rho = Arrays.clone(bArr4);
        this.hash = Arrays.clone(bArr5);
    }

    public byte[] getF() {
        return Arrays.clone(this.f);
    }

    public byte[] getGinv() {
        return Arrays.clone(this.ginv);
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
