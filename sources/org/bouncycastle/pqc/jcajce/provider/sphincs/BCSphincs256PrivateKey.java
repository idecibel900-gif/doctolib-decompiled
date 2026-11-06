package org.bouncycastle.pqc.jcajce.provider.sphincs;

import java.io.IOException;
import java.security.Key;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.SPHINCS256KeyParams;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.util.PrivateKeyFactory;
import org.bouncycastle.pqc.crypto.util.PrivateKeyInfoFactory;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class BCSphincs256PrivateKey implements PrivateKey, Key {
    private transient ASN1Set attributes;
    private transient SPHINCSPrivateKeyParameters params;
    private transient ASN1ObjectIdentifier treeDigest;

    public BCSphincs256PrivateKey(PrivateKeyInfo privateKeyInfo) {
        init(privateKeyInfo);
    }

    private void init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        this.treeDigest = SPHINCS256KeyParams.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters()).getTreeDigest().getAlgorithm();
        this.params = (SPHINCSPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCSphincs256PrivateKey) {
            BCSphincs256PrivateKey bCSphincs256PrivateKey = (BCSphincs256PrivateKey) obj;
            if (this.treeDigest.equals((ASN1Primitive) bCSphincs256PrivateKey.treeDigest) && Arrays.areEqual(this.params.getKeyData(), bCSphincs256PrivateKey.params.getKeyData())) {
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
            return (this.params.getTreeDigest() != null ? PrivateKeyInfoFactory.createPrivateKeyInfo(this.params, this.attributes) : new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.sphincs256, new SPHINCS256KeyParams(new AlgorithmIdentifier(this.treeDigest))), new DEROctetString(this.params.getKeyData()), this.attributes)).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.treeDigest.hashCode() + (Arrays.hashCode(this.params.getKeyData()) * 37);
    }
}
