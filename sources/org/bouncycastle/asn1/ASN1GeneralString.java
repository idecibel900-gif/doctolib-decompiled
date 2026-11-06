package org.bouncycastle.asn1;

import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ASN1GeneralString extends ASN1Primitive {
    static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1GeneralString.class, 27) { // from class: org.bouncycastle.asn1.ASN1GeneralString.1
        @Override // org.bouncycastle.asn1.ASN1UniversalType
        ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1GeneralString.createPrimitive(dEROctetString.getOctets());
        }
    };
    final byte[] contents;

    ASN1GeneralString(byte[] bArr, boolean z) {
        this.contents = z ? Arrays.clone(bArr) : bArr;
    }

    static ASN1GeneralString createPrimitive(byte[] bArr) {
        return new DERGeneralString(bArr, false);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1GeneralString) {
            return Arrays.areEqual(this.contents, ((ASN1GeneralString) aSN1Primitive).contents);
        }
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final void encode(ASN1OutputStream aSN1OutputStream, boolean z) {
        aSN1OutputStream.writeEncodingDL(z, 27, this.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final int encodedLength(boolean z) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, this.contents.length);
    }

    public final String getString() {
        return Strings.fromByteArray(this.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public final int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public String toString() {
        return getString();
    }
}
