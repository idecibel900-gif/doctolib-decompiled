package org.bouncycastle.pqc.crypto.crystals.dilithium;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DilithiumKeyParameters extends AsymmetricKeyParameter {
    private final DilithiumParameters params;

    public DilithiumKeyParameters(boolean z, DilithiumParameters dilithiumParameters) {
        super(z);
        this.params = dilithiumParameters;
    }

    public DilithiumParameters getParameters() {
        return this.params;
    }
}
