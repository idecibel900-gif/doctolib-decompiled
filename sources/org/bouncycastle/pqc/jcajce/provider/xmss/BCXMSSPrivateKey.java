package org.bouncycastle.pqc.jcajce.provider.xmss;

import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.pqc.asn1.XMSSKeyParams;
import org.bouncycastle.pqc.crypto.util.PrivateKeyFactory;
import org.bouncycastle.pqc.crypto.util.PrivateKeyInfoFactory;
import org.bouncycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class BCXMSSPrivateKey implements PrivateKey {
    private transient ASN1Set attributes;
    private transient XMSSPrivateKeyParameters keyParams;
    private transient ASN1ObjectIdentifier treeDigest;

    public BCXMSSPrivateKey(PrivateKeyInfo privateKeyInfo) {
        init(privateKeyInfo);
    }

    private void init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        this.treeDigest = XMSSKeyParams.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters()).getTreeDigest().getAlgorithm();
        this.keyParams = (XMSSPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCXMSSPrivateKey) {
            BCXMSSPrivateKey bCXMSSPrivateKey = (BCXMSSPrivateKey) obj;
            if (this.treeDigest.equals((ASN1Primitive) bCXMSSPrivateKey.treeDigest) && Arrays.areEqual(this.keyParams.toByteArray(), bCXMSSPrivateKey.keyParams.toByteArray())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "XMSS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return PrivateKeyInfoFactory.createPrivateKeyInfo(this.keyParams, this.attributes).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.treeDigest.hashCode() + (Arrays.hashCode(this.keyParams.toByteArray()) * 37);
    }
}
