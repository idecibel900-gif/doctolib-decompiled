package org.bouncycastle.pqc.crypto.saber;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SABERKeyParameters extends AsymmetricKeyParameter {
    private SABERParameters params;

    public SABERKeyParameters(boolean z, SABERParameters sABERParameters) {
        super(z);
        this.params = sABERParameters;
    }

    public SABERParameters getParameters() {
        return this.params;
    }
}
