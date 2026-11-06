package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes5.dex */
public class DLBitString extends ASN1BitString {
    DLBitString(byte[] bArr, boolean z) {
        super(bArr, z);
    }

    static void encode(ASN1OutputStream aSN1OutputStream, boolean z, byte b, byte[] bArr, int i, int i2) {
        aSN1OutputStream.writeEncodingDL(z, 3, b, bArr, i, i2);
    }

    static void encode(ASN1OutputStream aSN1OutputStream, boolean z, byte[] bArr, int i, int i2) {
        aSN1OutputStream.writeEncodingDL(z, 3, bArr, i, i2);
    }

    static int encodedLength(boolean z, int i) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, i);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream aSN1OutputStream, boolean z) {
        aSN1OutputStream.writeEncodingDL(z, 3, this.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean z) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, this.contents.length);
    }

    @Override // org.bouncycastle.asn1.ASN1BitString, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return this;
    }
}
