package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class ASN1Boolean extends ASN1Primitive {
    private final byte value;
    static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1Boolean.class, 1) { // from class: org.bouncycastle.asn1.ASN1Boolean.1
        @Override // org.bouncycastle.asn1.ASN1UniversalType
        ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1Boolean.createPrimitive(dEROctetString.getOctets());
        }
    };
    public static final ASN1Boolean FALSE = new ASN1Boolean((byte) 0);
    public static final ASN1Boolean TRUE = new ASN1Boolean((byte) -1);

    private ASN1Boolean(byte b) {
        this.value = b;
    }

    static ASN1Boolean createPrimitive(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
        }
        byte b = bArr[0];
        if (b != -1) {
            return b != 0 ? new ASN1Boolean(b) : FALSE;
        }
        return TRUE;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        return (aSN1Primitive instanceof ASN1Boolean) && isTrue() == ((ASN1Boolean) aSN1Primitive).isTrue();
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncodingDL(z, 1, this.value);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean z) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, 1);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return isTrue() ? 1 : 0;
    }

    public boolean isTrue() {
        return this.value != 0;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        return isTrue() ? TRUE : FALSE;
    }

    public String toString() {
        return isTrue() ? "TRUE" : "FALSE";
    }
}
