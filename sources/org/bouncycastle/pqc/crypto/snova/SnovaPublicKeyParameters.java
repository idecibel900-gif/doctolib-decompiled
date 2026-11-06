package org.bouncycastle.pqc.crypto.snova;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class SnovaPublicKeyParameters extends AsymmetricKeyParameter {
    private final SnovaParameters parameters;
    private final byte[] publicKey;

    public SnovaPublicKeyParameters(SnovaParameters snovaParameters, byte[] bArr) {
        super(false);
        this.publicKey = Arrays.clone(bArr);
        this.parameters = snovaParameters;
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.publicKey);
    }

    public SnovaParameters getParameters() {
        return this.parameters;
    }
}
