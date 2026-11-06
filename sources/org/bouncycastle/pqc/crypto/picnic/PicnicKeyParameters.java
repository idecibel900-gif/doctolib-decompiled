package org.bouncycastle.pqc.crypto.picnic;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PicnicKeyParameters extends AsymmetricKeyParameter {
    final PicnicParameters parameters;

    public PicnicKeyParameters(boolean z, PicnicParameters picnicParameters) {
        super(z);
        this.parameters = picnicParameters;
    }

    public PicnicParameters getParameters() {
        return this.parameters;
    }
}
