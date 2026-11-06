package org.bouncycastle.pqc.jcajce.provider.newhope;

import java.io.IOException;
import java.security.Key;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.pqc.crypto.newhope.NHPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.util.PrivateKeyFactory;
import org.bouncycastle.pqc.crypto.util.PrivateKeyInfoFactory;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class BCNHPrivateKey implements Key, PrivateKey {
    private transient ASN1Set attributes;
    private transient NHPrivateKeyParameters params;

    public BCNHPrivateKey(PrivateKeyInfo privateKeyInfo) {
        init(privateKeyInfo);
    }

    private void init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        this.params = (NHPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
    }

    public boolean equals(Object obj) {
        if (obj instanceof BCNHPrivateKey) {
            return Arrays.areEqual(this.params.getSecData(), ((BCNHPrivateKey) obj).params.getSecData());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "NH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return PrivateKeyInfoFactory.createPrivateKeyInfo(this.params, this.attributes).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return Arrays.hashCode(this.params.getSecData());
    }
}
