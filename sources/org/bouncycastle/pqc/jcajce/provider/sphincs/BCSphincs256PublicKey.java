package org.bouncycastle.pqc.jcajce.provider.sphincs;

import java.io.IOException;
import java.security.Key;
import java.security.PublicKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.SPHINCS256KeyParams;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSPublicKeyParameters;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import org.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class BCSphincs256PublicKey implements PublicKey, Key {
    private transient SPHINCSPublicKeyParameters params;
    private transient ASN1ObjectIdentifier treeDigest;

    public BCSphincs256PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        init(subjectPublicKeyInfo);
    }

    private void init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.treeDigest = SPHINCS256KeyParams.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters()).getTreeDigest().getAlgorithm();
        this.params = (SPHINCSPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCSphincs256PublicKey) {
            BCSphincs256PublicKey bCSphincs256PublicKey = (BCSphincs256PublicKey) obj;
            if (this.treeDigest.equals((ASN1Primitive) bCSphincs256PublicKey.treeDigest) && Arrays.areEqual(this.params.getKeyData(), bCSphincs256PublicKey.params.getKeyData())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return (this.params.getTreeDigest() != null ? SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.params) : new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.sphincs256, new SPHINCS256KeyParams(new AlgorithmIdentifier(this.treeDigest))), this.params.getKeyData())).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return this.treeDigest.hashCode() + (Arrays.hashCode(this.params.getKeyData()) * 37);
    }
}
