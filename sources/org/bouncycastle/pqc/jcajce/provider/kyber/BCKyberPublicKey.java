package org.bouncycastle.pqc.jcajce.provider.kyber;

import java.security.Key;
import java.security.PublicKey;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.pqc.crypto.mlkem.MLKEMPublicKeyParameters;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import org.bouncycastle.pqc.jcajce.provider.util.KeyUtil;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class BCKyberPublicKey implements PublicKey, Key {
    private transient String algorithm;
    private transient byte[] encoding;
    private transient MLKEMPublicKeyParameters params;

    public BCKyberPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        init(subjectPublicKeyInfo);
    }

    private void init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        init((MLKEMPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo));
    }

    private void init(MLKEMPublicKeyParameters mLKEMPublicKeyParameters) {
        this.params = mLKEMPublicKeyParameters;
        this.algorithm = Strings.toUpperCase(mLKEMPublicKeyParameters.getParameters().getName());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCKyberPublicKey) {
            return Arrays.areEqual(getEncoded(), ((BCKyberPublicKey) obj).getEncoded());
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
            this.encoding = KeyUtil.getEncodedSubjectPublicKeyInfo(this.params);
        }
        return Arrays.clone(this.encoding);
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return Arrays.hashCode(getEncoded());
    }
}
