package org.bouncycastle.asn1;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ASN1VideotexString extends ASN1Primitive {
    static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1VideotexString.class, 21) { // from class: org.bouncycastle.asn1.ASN1VideotexString.1
        @Override // org.bouncycastle.asn1.ASN1UniversalType
        ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1VideotexString.createPrimitive(dEROctetString.getOctets());
        }
    };
    final byte[] contents;

    ASN1VideotexString(byte[] bArr, boolean z) {
        this.contents = z ? Arrays.clone(bArr) : bArr;
    }

    static ASN1VideotexString createPrimitive(byte[] bArr) {
        return new DERVideotexString(bArr, false);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1VideotexString) {
            return Arrays.areEqual(this.contents, ((ASN1VideotexString) aSN1Primitive).contents);
        }
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final void encode(ASN1OutputStream aSN1OutputStream, boolean z) {
        aSN1OutputStream.writeEncodingDL(z, 21, this.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final int encodedLength(boolean z) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, this.contents.length);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public final int hashCode() {
        return Arrays.hashCode(this.contents);
    }
}
