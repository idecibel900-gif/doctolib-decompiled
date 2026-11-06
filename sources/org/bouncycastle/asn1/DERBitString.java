package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class DERBitString extends ASN1BitString {
    public DERBitString(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable.toASN1Primitive().getEncoded("DER"), 0);
    }

    public DERBitString(byte[] bArr) {
        this(bArr, 0);
    }

    public DERBitString(byte[] bArr, int i) {
        super(bArr, i);
    }

    DERBitString(byte[] bArr, boolean z) {
        super(bArr, z);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        byte[] bArr = this.contents;
        int i = bArr[0] & 255;
        int length = bArr.length - 1;
        byte b = bArr[length];
        byte b2 = (byte) ((255 << i) & b);
        if (b == b2) {
            aSN1OutputStream.writeEncodingDL(z, 3, bArr);
        } else {
            aSN1OutputStream.writeEncodingDL(z, 3, bArr, 0, length, b2);
        }
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
    ASN1Primitive toDERObject() {
        return this;
    }

    @Override // org.bouncycastle.asn1.ASN1BitString, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return this;
    }
}
