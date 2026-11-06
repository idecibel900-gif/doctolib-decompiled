package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes5.dex */
public class SubjectPublicKeyInfo extends ASN1Object {
    private AlgorithmIdentifier algId;
    private ASN1BitString keyData;

    public SubjectPublicKeyInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            Enumeration objects = aSN1Sequence.getObjects();
            this.algId = AlgorithmIdentifier.getInstance(objects.nextElement());
            this.keyData = ASN1BitString.getInstance(objects.nextElement());
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1Encodable aSN1Encodable) {
        this.keyData = new DERBitString(aSN1Encodable);
        this.algId = algorithmIdentifier;
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.keyData = new DERBitString(bArr);
        this.algId = algorithmIdentifier;
    }

    public static SubjectPublicKeyInfo getInstance(Object obj) {
        if (obj instanceof SubjectPublicKeyInfo) {
            return (SubjectPublicKeyInfo) obj;
        }
        if (obj != null) {
            return new SubjectPublicKeyInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getAlgorithm() {
        return this.algId;
    }

    public ASN1BitString getPublicKeyData() {
        return this.keyData;
    }

    public ASN1Primitive parsePublicKey() {
        return ASN1Primitive.fromByteArray(this.keyData.getOctets());
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.algId, this.keyData);
    }
}
