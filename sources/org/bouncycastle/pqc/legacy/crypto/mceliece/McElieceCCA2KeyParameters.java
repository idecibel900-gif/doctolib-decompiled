package org.bouncycastle.pqc.legacy.crypto.mceliece;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class McElieceCCA2KeyParameters extends AsymmetricKeyParameter {
    private String params;

    public McElieceCCA2KeyParameters(boolean z, String str) {
        super(z);
        this.params = str;
    }

    public String getDigest() {
        return this.params;
    }
}
