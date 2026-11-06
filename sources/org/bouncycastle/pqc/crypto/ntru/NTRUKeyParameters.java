package org.bouncycastle.pqc.crypto.ntru;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class NTRUKeyParameters extends AsymmetricKeyParameter {
    private final NTRUParameters params;

    NTRUKeyParameters(boolean z, NTRUParameters nTRUParameters) {
        super(z);
        this.params = nTRUParameters;
    }

    public NTRUParameters getParameters() {
        return this.params;
    }
}
