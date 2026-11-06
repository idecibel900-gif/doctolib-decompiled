package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes5.dex */
public abstract class StreamBlockCipher extends DefaultMultiBlockCipher implements StreamCipher {
    private final BlockCipher cipher;

    protected StreamBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
    }
}
