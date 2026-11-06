package org.bouncycastle.asn1.pkcs;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes5.dex */
public class PrivateKeyInfo extends ASN1Object {
    private ASN1Set attributes;
    private ASN1OctetString privateKey;
    private AlgorithmIdentifier privateKeyAlgorithm;
    private ASN1BitString publicKey;
    private ASN1Integer version;

    private PrivateKeyInfo(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        ASN1Integer aSN1Integer = ASN1Integer.getInstance(objects.nextElement());
        this.version = aSN1Integer;
        int versionValue = getVersionValue(aSN1Integer);
        this.privateKeyAlgorithm = AlgorithmIdentifier.getInstance(objects.nextElement());
        this.privateKey = ASN1OctetString.getInstance(objects.nextElement());
        int i = -1;
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo <= i) {
                throw new IllegalArgumentException("invalid optional field in private key info");
            }
            if (tagNo == 0) {
                this.attributes = ASN1Set.getInstance(aSN1TaggedObject, false);
            } else {
                if (tagNo != 1) {
                    throw new IllegalArgumentException("unknown optional field in private key info");
                }
                if (versionValue < 1) {
                    throw new IllegalArgumentException("'publicKey' requires version v2(1) or later");
                }
                this.publicKey = ASN1BitString.getInstance(aSN1TaggedObject, false);
            }
            i = tagNo;
        }
    }

    public PrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1Encodable aSN1Encodable) {
        this(algorithmIdentifier, aSN1Encodable, (ASN1Set) null, (byte[]) null);
    }

    public PrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1Encodable aSN1Encodable, ASN1Set aSN1Set) {
        this(algorithmIdentifier, aSN1Encodable, aSN1Set, (byte[]) null);
    }

    public PrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1Encodable aSN1Encodable, ASN1Set aSN1Set, byte[] bArr) {
        this(algorithmIdentifier, aSN1Encodable.toASN1Primitive().getEncoded("DER"), aSN1Set, bArr);
    }

    public PrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, ASN1Set aSN1Set) {
        this(algorithmIdentifier, bArr, aSN1Set, (byte[]) null);
    }

    public PrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, ASN1Set aSN1Set, byte[] bArr2) {
        this.version = new ASN1Integer(bArr2 != null ? BigIntegers.ONE : BigIntegers.ZERO);
        this.privateKeyAlgorithm = algorithmIdentifier;
        this.privateKey = new DEROctetString(bArr);
        this.attributes = aSN1Set;
        this.publicKey = bArr2 == null ? null : new DERBitString(bArr2);
    }

    public static PrivateKeyInfo getInstance(Object obj) {
        if (obj instanceof PrivateKeyInfo) {
            return (PrivateKeyInfo) obj;
        }
        if (obj != null) {
            return new PrivateKeyInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private static int getVersionValue(ASN1Integer aSN1Integer) {
        int iIntValueExact = aSN1Integer.intValueExact();
        if (iIntValueExact < 0 || iIntValueExact > 1) {
            throw new IllegalArgumentException("invalid version for private key info");
        }
        return iIntValueExact;
    }

    public ASN1Set getAttributes() {
        return this.attributes;
    }

    public ASN1OctetString getPrivateKey() {
        return new DEROctetString(this.privateKey.getOctets());
    }

    public AlgorithmIdentifier getPrivateKeyAlgorithm() {
        return this.privateKeyAlgorithm;
    }

    public ASN1BitString getPublicKeyData() {
        return this.publicKey;
    }

    public ASN1Encodable parsePrivateKey() {
        return ASN1Primitive.fromByteArray(this.privateKey.getOctets());
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(5);
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(this.privateKeyAlgorithm);
        aSN1EncodableVector.add(this.privateKey);
        ASN1Set aSN1Set = this.attributes;
        if (aSN1Set != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, aSN1Set));
        }
        ASN1BitString aSN1BitString = this.publicKey;
        if (aSN1BitString != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, aSN1BitString));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
