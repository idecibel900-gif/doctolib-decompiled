package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes5.dex */
public interface Digest {
    int doFinal(byte[] bArr, int i);

    String getAlgorithmName();

    int getDigestSize();

    void update(byte b);

    void update(byte[] bArr, int i, int i2);
}
