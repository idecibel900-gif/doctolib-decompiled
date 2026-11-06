package org.bouncycastle.pqc.jcajce.provider.xmss;

import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import org.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class BCXMSSMTPublicKey implements PublicKey {
    private transient XMSSMTPublicKeyParameters keyParams;
    private transient ASN1ObjectIdentifier treeDigest;

    public BCXMSSMTPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        init(subjectPublicKeyInfo);
    }

    private void init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        XMSSMTPublicKeyParameters xMSSMTPublicKeyParameters = (XMSSMTPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
        this.keyParams = xMSSMTPublicKeyParameters;
        this.treeDigest = DigestUtil.getDigestOID(xMSSMTPublicKeyParameters.getTreeDigest());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCXMSSMTPublicKey) {
            BCXMSSMTPublicKey bCXMSSMTPublicKey = (BCXMSSMTPublicKey) obj;
            if (this.treeDigest.equals((ASN1Primitive) bCXMSSMTPublicKey.treeDigest) && Arrays.areEqual(this.keyParams.toByteArray(), bCXMSSMTPublicKey.keyParams.toByteArray())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSSMT";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.keyParams).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return this.treeDigest.hashCode() + (Arrays.hashCode(this.keyParams.toByteArray()) * 37);
    }
}
