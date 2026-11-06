package org.bouncycastle.pqc.crypto.falcon;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class FalconKeyParameters extends AsymmetricKeyParameter {
    private final FalconParameters params;

    public FalconKeyParameters(boolean z, FalconParameters falconParameters) {
        super(z);
        this.params = falconParameters;
    }

    public FalconParameters getParameters() {
        return this.params;
    }
}
