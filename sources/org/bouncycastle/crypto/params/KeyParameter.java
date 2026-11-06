package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes5.dex */
public class KeyParameter implements CipherParameters {
    private byte[] key;

    private KeyParameter(int i) {
        this.key = new byte[i];
    }

    public KeyParameter(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public KeyParameter(byte[] bArr, int i, int i2) {
        this(i2);
        System.arraycopy(bArr, i, this.key, 0, i2);
    }

    public byte[] getKey() {
        return this.key;
    }
}
