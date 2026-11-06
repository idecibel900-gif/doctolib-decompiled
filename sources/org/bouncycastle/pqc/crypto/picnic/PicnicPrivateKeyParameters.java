package org.bouncycastle.pqc.crypto.picnic;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class PicnicPrivateKeyParameters extends PicnicKeyParameters {
    private final byte[] privateKey;

    public PicnicPrivateKeyParameters(PicnicParameters picnicParameters, byte[] bArr) {
        super(true, picnicParameters);
        this.privateKey = Arrays.clone(bArr);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.privateKey);
    }
}
