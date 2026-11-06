package org.bouncycastle.pqc.crypto.xmss;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public final class XMSSNode implements Serializable {
    private final int height;
    private final byte[] value;

    protected XMSSNode(int i, byte[] bArr) {
        this.height = i;
        this.value = bArr;
    }

    public int getHeight() {
        return this.height;
    }

    public byte[] getValue() {
        return XMSSUtil.cloneArray(this.value);
    }
}
