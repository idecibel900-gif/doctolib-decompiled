package org.bouncycastle.pqc.jcajce.provider.mayo;

import java.io.IOException;
import java.security.Key;
import java.security.PublicKey;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.pqc.crypto.mayo.MayoPublicKeyParameters;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import org.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class BCMayoPublicKey implements PublicKey, Key {
    private transient MayoPublicKeyParameters params;

    public BCMayoPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        init(subjectPublicKeyInfo);
    }

    private void init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.params = (MayoPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCMayoPublicKey) {
            return Arrays.areEqual(this.params.getEncoded(), ((BCMayoPublicKey) obj).params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return Strings.toUpperCase(this.params.getParameters().getName());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.params).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return Arrays.hashCode(this.params.getEncoded());
    }
}
