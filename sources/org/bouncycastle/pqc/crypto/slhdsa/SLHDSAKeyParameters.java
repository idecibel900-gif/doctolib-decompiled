package org.bouncycastle.pqc.crypto.slhdsa;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SLHDSAKeyParameters extends AsymmetricKeyParameter {
    private final SLHDSAParameters parameters;

    protected SLHDSAKeyParameters(boolean z, SLHDSAParameters sLHDSAParameters) {
        super(z);
        this.parameters = sLHDSAParameters;
    }

    public SLHDSAParameters getParameters() {
        return this.parameters;
    }
}
