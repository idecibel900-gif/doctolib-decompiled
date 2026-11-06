package org.bouncycastle.pqc.jcajce.provider.falcon;

import java.security.Key;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.pqc.crypto.falcon.FalconPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.util.PrivateKeyFactory;
import org.bouncycastle.pqc.jcajce.provider.util.KeyUtil;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class BCFalconPrivateKey implements PrivateKey, Key {
    private transient String algorithm;
    private transient ASN1Set attributes;
    private transient byte[] encoding;
    private transient FalconPrivateKeyParameters params;

    public BCFalconPrivateKey(PrivateKeyInfo privateKeyInfo) {
        init(privateKeyInfo);
    }

    private void init(PrivateKeyInfo privateKeyInfo) {
        init((FalconPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo), privateKeyInfo.getAttributes());
    }

    private void init(FalconPrivateKeyParameters falconPrivateKeyParameters, ASN1Set aSN1Set) {
        this.attributes = aSN1Set;
        this.params = falconPrivateKeyParameters;
        this.algorithm = Strings.toUpperCase(falconPrivateKeyParameters.getParameters().getName());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCFalconPrivateKey) {
            return Arrays.areEqual(getEncoded(), ((BCFalconPrivateKey) obj).getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = KeyUtil.getEncodedPrivateKeyInfo(this.params, this.attributes);
        }
        return Arrays.clone(this.encoding);
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return Arrays.hashCode(getEncoded());
    }
}
