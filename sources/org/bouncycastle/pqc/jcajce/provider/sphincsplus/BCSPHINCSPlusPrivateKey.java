package org.bouncycastle.pqc.jcajce.provider.sphincsplus;

import java.io.IOException;
import java.security.Key;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.util.PrivateKeyFactory;
import org.bouncycastle.pqc.crypto.util.PrivateKeyInfoFactory;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class BCSPHINCSPlusPrivateKey implements PrivateKey, Key {
    private transient ASN1Set attributes;
    private transient SPHINCSPlusPrivateKeyParameters params;

    public BCSPHINCSPlusPrivateKey(PrivateKeyInfo privateKeyInfo) {
        init(privateKeyInfo);
    }

    private void init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        this.params = (SPHINCSPlusPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCSPHINCSPlusPrivateKey) {
            return Arrays.areEqual(this.params.getEncoded(), ((BCSPHINCSPlusPrivateKey) obj).params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SPHINCS+";
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
        return Arrays.hashCode(this.params.getEncoded());
    }
}
