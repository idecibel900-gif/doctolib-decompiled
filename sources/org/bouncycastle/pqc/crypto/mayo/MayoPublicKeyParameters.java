package org.bouncycastle.pqc.crypto.mayo;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class MayoPublicKeyParameters extends MayoKeyParameters {
    private final byte[] p;

    public MayoPublicKeyParameters(MayoParameters mayoParameters, byte[] bArr) {
        super(false, mayoParameters);
        this.p = Arrays.clone(bArr);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.p);
    }
}
