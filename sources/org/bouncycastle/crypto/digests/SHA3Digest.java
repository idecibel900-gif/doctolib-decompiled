package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.CryptoServicePurpose;

/* JADX INFO: loaded from: classes5.dex */
public class SHA3Digest extends KeccakDigest {
    public SHA3Digest(int i) {
        super(checkBitLength(i), CryptoServicePurpose.ANY);
    }

    private static int checkBitLength(int i) {
        if (i == 224 || i == 256 || i == 384 || i == 512) {
            return i;
        }
        throw new IllegalArgumentException("'bitLength' " + i + " not supported for SHA-3");
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        absorbBits(2, 2);
        return super.doFinal(bArr, i);
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA3-" + this.fixedOutputLength;
    }
}
