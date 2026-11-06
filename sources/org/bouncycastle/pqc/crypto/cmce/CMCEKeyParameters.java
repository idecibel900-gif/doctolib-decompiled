package org.bouncycastle.pqc.crypto.cmce;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CMCEKeyParameters extends AsymmetricKeyParameter {
    private CMCEParameters params;

    public CMCEKeyParameters(boolean z, CMCEParameters cMCEParameters) {
        super(z);
        this.params = cMCEParameters;
    }

    public CMCEParameters getParameters() {
        return this.params;
    }
}
