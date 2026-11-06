package org.bouncycastle.pqc.crypto.slhdsa;

/* JADX INFO: loaded from: classes5.dex */
class SK {
    final byte[] prf;
    final byte[] seed;

    SK(byte[] bArr, byte[] bArr2) {
        this.seed = bArr;
        this.prf = bArr2;
    }
}
