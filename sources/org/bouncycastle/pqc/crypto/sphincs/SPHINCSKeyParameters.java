package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SPHINCSKeyParameters extends AsymmetricKeyParameter {
    private final String treeDigest;

    protected SPHINCSKeyParameters(boolean z, String str) {
        super(z);
        this.treeDigest = str;
    }

    public String getTreeDigest() {
        return this.treeDigest;
    }
}
