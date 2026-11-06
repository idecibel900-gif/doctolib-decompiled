package org.bouncycastle.pqc.crypto.sphincsplus;

/* JADX INFO: loaded from: classes5.dex */
class PK {
    final byte[] root;
    final byte[] seed;

    PK(byte[] bArr, byte[] bArr2) {
        this.seed = bArr;
        this.root = bArr2;
    }
}
