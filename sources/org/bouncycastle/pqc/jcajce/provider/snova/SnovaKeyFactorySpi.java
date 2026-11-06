package org.bouncycastle.pqc.jcajce.provider.snova;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.pqc.jcajce.provider.util.BaseKeyFactorySpi;

/* JADX INFO: loaded from: classes5.dex */
public class SnovaKeyFactorySpi extends BaseKeyFactorySpi {
    private static final Set keyOids;

    static {
        HashSet hashSet = new HashSet();
        keyOids = hashSet;
        hashSet.add(BCObjectIdentifiers.snova_24_5_4_ssk);
        hashSet.add(BCObjectIdentifiers.snova_24_5_4_esk);
        hashSet.add(BCObjectIdentifiers.snova_24_5_4_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_24_5_4_shake_esk);
        hashSet.add(BCObjectIdentifiers.snova_24_5_5_ssk);
        hashSet.add(BCObjectIdentifiers.snova_24_5_5_esk);
        hashSet.add(BCObjectIdentifiers.snova_24_5_5_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_24_5_5_shake_esk);
        hashSet.add(BCObjectIdentifiers.snova_25_8_3_ssk);
        hashSet.add(BCObjectIdentifiers.snova_25_8_3_esk);
        hashSet.add(BCObjectIdentifiers.snova_25_8_3_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_25_8_3_shake_esk);
        hashSet.add(BCObjectIdentifiers.snova_29_6_5_ssk);
        hashSet.add(BCObjectIdentifiers.snova_29_6_5_esk);
        hashSet.add(BCObjectIdentifiers.snova_29_6_5_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_29_6_5_shake_esk);
        hashSet.add(BCObjectIdentifiers.snova_37_8_4_ssk);
        hashSet.add(BCObjectIdentifiers.snova_37_8_4_esk);
        hashSet.add(BCObjectIdentifiers.snova_37_8_4_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_37_8_4_shake_esk);
        hashSet.add(BCObjectIdentifiers.snova_37_17_2_ssk);
        hashSet.add(BCObjectIdentifiers.snova_37_17_2_esk);
        hashSet.add(BCObjectIdentifiers.snova_37_17_2_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_37_17_2_shake_esk);
        hashSet.add(BCObjectIdentifiers.snova_49_11_3_ssk);
        hashSet.add(BCObjectIdentifiers.snova_49_11_3_esk);
        hashSet.add(BCObjectIdentifiers.snova_49_11_3_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_49_11_3_shake_esk);
        hashSet.add(BCObjectIdentifiers.snova_56_25_2_ssk);
        hashSet.add(BCObjectIdentifiers.snova_56_25_2_esk);
        hashSet.add(BCObjectIdentifiers.snova_56_25_2_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_56_25_2_shake_esk);
        hashSet.add(BCObjectIdentifiers.snova_60_10_4_ssk);
        hashSet.add(BCObjectIdentifiers.snova_60_10_4_esk);
        hashSet.add(BCObjectIdentifiers.snova_60_10_4_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_60_10_4_shake_esk);
        hashSet.add(BCObjectIdentifiers.snova_66_15_3_ssk);
        hashSet.add(BCObjectIdentifiers.snova_66_15_3_esk);
        hashSet.add(BCObjectIdentifiers.snova_66_15_3_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_66_15_3_shake_esk);
        hashSet.add(BCObjectIdentifiers.snova_75_33_2_ssk);
        hashSet.add(BCObjectIdentifiers.snova_75_33_2_esk);
        hashSet.add(BCObjectIdentifiers.snova_75_33_2_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_75_33_2_shake_esk);
    }

    public SnovaKeyFactorySpi() {
        super(keyOids);
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (key instanceof BCSnovaPrivateKey) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
        } else {
            if (!(key instanceof BCSnovaPublicKey)) {
                throw new InvalidKeySpecException("Unsupported key type: " + key.getClass() + ".");
            }
            if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new X509EncodedKeySpec(key.getEncoded());
            }
        }
        throw new InvalidKeySpecException("Unknown key specification: " + cls + ".");
    }

    @Override // java.security.KeyFactorySpi
    public final Key engineTranslateKey(Key key) throws InvalidKeyException {
        if ((key instanceof BCSnovaPrivateKey) || (key instanceof BCSnovaPublicKey)) {
            return key;
        }
        throw new InvalidKeyException("Unsupported key type");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo) {
        return new BCSnovaPrivateKey(privateKeyInfo);
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        return new BCSnovaPublicKey(subjectPublicKeyInfo);
    }
}
