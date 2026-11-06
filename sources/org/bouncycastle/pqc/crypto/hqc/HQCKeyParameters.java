package org.bouncycastle.pqc.crypto.hqc;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class HQCKeyParameters extends AsymmetricKeyParameter {
    private HQCParameters params;

    public HQCKeyParameters(boolean z, HQCParameters hQCParameters) {
        super(z);
        this.params = hQCParameters;
    }

    public HQCParameters getParameters() {
        return this.params;
    }
}
