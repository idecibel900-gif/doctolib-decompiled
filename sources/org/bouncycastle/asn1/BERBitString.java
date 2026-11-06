package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class BERBitString extends ASN1BitString {
    private final ASN1BitString[] elements;
    private final int segmentLimit;

    public BERBitString(byte[] bArr, int i) {
        this(bArr, i, 1000);
    }

    public BERBitString(byte[] bArr, int i, int i2) {
        super(bArr, i);
        this.elements = null;
        this.segmentLimit = i2;
    }

    public BERBitString(ASN1BitString[] aSN1BitStringArr) {
        this(aSN1BitStringArr, 1000);
    }

    public BERBitString(ASN1BitString[] aSN1BitStringArr, int i) {
        super(flattenBitStrings(aSN1BitStringArr), false);
        this.elements = aSN1BitStringArr;
        this.segmentLimit = i;
    }

    static byte[] flattenBitStrings(ASN1BitString[] aSN1BitStringArr) {
        int length = aSN1BitStringArr.length;
        if (length == 0) {
            return new byte[]{0};
        }
        if (length == 1) {
            return aSN1BitStringArr[0].contents;
        }
        int i = length - 1;
        int length2 = 0;
        for (int i2 = 0; i2 < i; i2++) {
            byte[] bArr = aSN1BitStringArr[i2].contents;
            if (bArr[0] != 0) {
                throw new IllegalArgumentException("only the last nested bitstring can have padding");
            }
            length2 += bArr.length - 1;
        }
        byte[] bArr2 = aSN1BitStringArr[i].contents;
        byte b = bArr2[0];
        byte[] bArr3 = new byte[length2 + bArr2.length];
        bArr3[0] = b;
        int i3 = 1;
        for (ASN1BitString aSN1BitString : aSN1BitStringArr) {
            byte[] bArr4 = aSN1BitString.contents;
            int length3 = bArr4.length - 1;
            System.arraycopy(bArr4, 1, bArr3, i3, length3);
            i3 += length3;
        }
        return bArr3;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        ASN1OutputStream aSN1OutputStream2;
        if (!encodeConstructed()) {
            byte[] bArr = this.contents;
            DLBitString.encode(aSN1OutputStream, z, bArr, 0, bArr.length);
            return;
        }
        aSN1OutputStream.writeIdentifier(z, 35);
        aSN1OutputStream.write(128);
        ASN1BitString[] aSN1BitStringArr = this.elements;
        if (aSN1BitStringArr == null) {
            byte[] bArr2 = this.contents;
            if (bArr2.length >= 2) {
                byte b = bArr2[0];
                int length = bArr2.length;
                int i = length - 1;
                int i2 = this.segmentLimit - 1;
                while (i > i2) {
                    ASN1OutputStream aSN1OutputStream3 = aSN1OutputStream;
                    DLBitString.encode(aSN1OutputStream3, true, (byte) 0, this.contents, length - i, i2);
                    i -= i2;
                    aSN1OutputStream = aSN1OutputStream3;
                }
                aSN1OutputStream2 = aSN1OutputStream;
                DLBitString.encode(aSN1OutputStream2, true, b, this.contents, length - i, i);
            }
            aSN1OutputStream2.write(0);
            aSN1OutputStream2.write(0);
        }
        aSN1OutputStream.writePrimitives(aSN1BitStringArr);
        aSN1OutputStream2 = aSN1OutputStream;
        aSN1OutputStream2.write(0);
        aSN1OutputStream2.write(0);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        return this.elements != null || this.contents.length > this.segmentLimit;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean z) {
        if (!encodeConstructed()) {
            return DLBitString.encodedLength(z, this.contents.length);
        }
        int iEncodedLength = z ? 4 : 3;
        if (this.elements == null) {
            byte[] bArr = this.contents;
            if (bArr.length < 2) {
                return iEncodedLength;
            }
            int length = bArr.length - 2;
            int i = this.segmentLimit;
            int i2 = length / (i - 1);
            return iEncodedLength + (DLBitString.encodedLength(true, i) * i2) + DLBitString.encodedLength(true, this.contents.length - (i2 * (this.segmentLimit - 1)));
        }
        int i3 = 0;
        while (true) {
            ASN1BitString[] aSN1BitStringArr = this.elements;
            if (i3 >= aSN1BitStringArr.length) {
                return iEncodedLength;
            }
            iEncodedLength += aSN1BitStringArr[i3].encodedLength(true);
            i3++;
        }
    }
}
