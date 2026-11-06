package org.bouncycastle.pqc.crypto.sphincsplus;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SPHINCSPlusKeyParameters extends AsymmetricKeyParameter {
    final SPHINCSPlusParameters parameters;

    protected SPHINCSPlusKeyParameters(boolean z, SPHINCSPlusParameters sPHINCSPlusParameters) {
        super(z);
        this.parameters = sPHINCSPlusParameters;
    }

    public SPHINCSPlusParameters getParameters() {
        return this.parameters;
    }
}
