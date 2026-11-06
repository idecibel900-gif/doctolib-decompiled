package org.bouncycastle.pqc.crypto.mayo;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MayoKeyParameters extends AsymmetricKeyParameter {
    private final MayoParameters params;

    public MayoKeyParameters(boolean z, MayoParameters mayoParameters) {
        super(z);
        this.params = mayoParameters;
    }

    public MayoParameters getParameters() {
        return this.params;
    }
}
