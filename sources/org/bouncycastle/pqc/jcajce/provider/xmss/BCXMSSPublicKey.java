package org.bouncycastle.pqc.jcajce.provider.xmss;

import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import org.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class BCXMSSPublicKey implements PublicKey {
    private transient XMSSPublicKeyParameters keyParams;
    private transient ASN1ObjectIdentifier treeDigest;

    public BCXMSSPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        init(subjectPublicKeyInfo);
    }

    private void init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        XMSSPublicKeyParameters xMSSPublicKeyParameters = (XMSSPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
        this.keyParams = xMSSPublicKeyParameters;
        this.treeDigest = DigestUtil.getDigestOID(xMSSPublicKeyParameters.getTreeDigest());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCXMSSPublicKey) {
            BCXMSSPublicKey bCXMSSPublicKey = (BCXMSSPublicKey) obj;
            try {
                if (this.treeDigest.equals((ASN1Primitive) bCXMSSPublicKey.treeDigest) && Arrays.areEqual(this.keyParams.getEncoded(), bCXMSSPublicKey.keyParams.getEncoded())) {
                    return true;
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSS";
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
        try {
            return this.treeDigest.hashCode() + (Arrays.hashCode(this.keyParams.getEncoded()) * 37);
        } catch (IOException unused) {
            return this.treeDigest.hashCode();
        }
    }
}
