package org.bouncycastle.pqc.jcajce.provider.lms;

import java.io.IOException;
import java.security.Key;
import java.security.PublicKey;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.pqc.crypto.lms.LMSKeyParameters;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import org.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class BCLMSPublicKey implements PublicKey, Key {
    private transient LMSKeyParameters keyParams;

    public BCLMSPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        init(subjectPublicKeyInfo);
    }

    private void init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.keyParams = (LMSKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCLMSPublicKey) {
            try {
                return Arrays.areEqual(this.keyParams.getEncoded(), ((BCLMSPublicKey) obj).keyParams.getEncoded());
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "LMS";
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
            return Arrays.hashCode(this.keyParams.getEncoded());
        } catch (IOException unused) {
            return -1;
        }
    }
}
