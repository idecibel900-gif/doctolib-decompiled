package org.bouncycastle.pqc.crypto.rainbow;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RainbowKeyParameters extends AsymmetricKeyParameter {
    private final int docLength;
    private final RainbowParameters params;

    public RainbowKeyParameters(boolean z, RainbowParameters rainbowParameters) {
        super(z);
        this.params = rainbowParameters;
        this.docLength = rainbowParameters.getM();
    }

    public RainbowParameters getParameters() {
        return this.params;
    }
}
