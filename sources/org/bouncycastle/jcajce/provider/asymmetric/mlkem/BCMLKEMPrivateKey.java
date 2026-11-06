package org.bouncycastle.jcajce.provider.asymmetric.mlkem;

import java.io.IOException;
import java.security.Key;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.jcajce.interfaces.MLKEMPublicKey;
import org.bouncycastle.jcajce.spec.MLKEMParameterSpec;
import org.bouncycastle.pqc.crypto.mlkem.MLKEMPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.util.PrivateKeyFactory;
import org.bouncycastle.pqc.crypto.util.PrivateKeyInfoFactory;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Fingerprint;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes5.dex */
public class BCMLKEMPrivateKey implements PrivateKey, Key {
    private transient String algorithm;
    private transient ASN1Set attributes;
    private transient MLKEMPrivateKeyParameters params;
    private transient byte[] priorEncoding;

    public BCMLKEMPrivateKey(PrivateKeyInfo privateKeyInfo) {
        init(privateKeyInfo);
    }

    public BCMLKEMPrivateKey(MLKEMPrivateKeyParameters mLKEMPrivateKeyParameters) {
        this.params = mLKEMPrivateKeyParameters;
        this.algorithm = Strings.toUpperCase(mLKEMPrivateKeyParameters.getParameters().getName());
    }

    private void init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        this.priorEncoding = privateKeyInfo.getEncoded();
        MLKEMPrivateKeyParameters mLKEMPrivateKeyParameters = (MLKEMPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
        this.params = mLKEMPrivateKeyParameters;
        this.algorithm = Strings.toUpperCase(MLKEMParameterSpec.fromName(mLKEMPrivateKeyParameters.getParameters().getName()).getName());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCMLKEMPrivateKey) {
            return Arrays.areEqual(this.params.getEncoded(), ((BCMLKEMPrivateKey) obj).params.getEncoded());
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
            byte[] bArr = this.priorEncoding;
            return bArr != null ? bArr : PrivateKeyInfoFactory.createPrivateKeyInfo(this.params, this.attributes).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public MLKEMParameterSpec getParameterSpec() {
        return MLKEMParameterSpec.fromName(this.params.getParameters().getName());
    }

    public byte[] getPrivateData() {
        return this.params.getEncoded();
    }

    public MLKEMPublicKey getPublicKey() {
        return new BCMLKEMPublicKey(this.params.getPublicKeyParameters());
    }

    public byte[] getSeed() {
        return this.params.getSeed();
    }

    public int hashCode() {
        return Arrays.hashCode(this.params.getEncoded());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = Strings.lineSeparator();
        byte[] publicKey = this.params.getPublicKey();
        sb.append(getAlgorithm());
        sb.append(" ");
        sb.append("Private Key");
        sb.append(" [");
        sb.append(new Fingerprint(publicKey).toString());
        sb.append("]");
        sb.append(strLineSeparator);
        sb.append("    public data: ");
        sb.append(Hex.toHexString(publicKey));
        sb.append(strLineSeparator);
        return sb.toString();
    }
}
