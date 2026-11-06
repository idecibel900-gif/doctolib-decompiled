package org.bouncycastle.pqc.jcajce.provider.kyber;

import java.io.IOException;
import java.security.Key;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.pqc.crypto.mlkem.MLKEMPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.util.PrivateKeyFactory;
import org.bouncycastle.pqc.crypto.util.PrivateKeyInfoFactory;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class BCKyberPrivateKey implements PrivateKey, Key {
    private transient String algorithm;
    private transient ASN1Set attributes;
    private transient MLKEMPrivateKeyParameters params;

    public BCKyberPrivateKey(PrivateKeyInfo privateKeyInfo) {
        init(privateKeyInfo);
    }

    private void init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        MLKEMPrivateKeyParameters mLKEMPrivateKeyParameters = (MLKEMPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
        this.params = mLKEMPrivateKeyParameters;
        this.algorithm = Strings.toUpperCase(mLKEMPrivateKeyParameters.getParameters().getName());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCKyberPrivateKey) {
            return Arrays.areEqual(getEncoded(), ((BCKyberPrivateKey) obj).getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return this.algorithm;
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
        return Arrays.hashCode(getEncoded());
    }
}
