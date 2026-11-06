package org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ASN1BitString extends ASN1Primitive implements ASN1BitStringParser {
    static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1BitString.class, 3) { // from class: org.bouncycastle.asn1.ASN1BitString.1
        @Override // org.bouncycastle.asn1.ASN1UniversalType
        ASN1Primitive fromImplicitConstructed(ASN1Sequence aSN1Sequence) {
            return aSN1Sequence.toASN1BitString();
        }

        @Override // org.bouncycastle.asn1.ASN1UniversalType
        ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1BitString.createPrimitive(dEROctetString.getOctets());
        }
    };
    private static final char[] table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    final byte[] contents;

    ASN1BitString(byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException("'data' cannot be null");
        }
        if (bArr.length == 0 && i != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        }
        if (i > 7 || i < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }
        this.contents = Arrays.prepend(bArr, (byte) i);
    }

    ASN1BitString(byte[] bArr, boolean z) {
        if (z) {
            if (bArr == null) {
                throw new NullPointerException("'contents' cannot be null");
            }
            if (bArr.length < 1) {
                throw new IllegalArgumentException("'contents' cannot be empty");
            }
            int i = bArr[0] & 255;
            if (i > 0) {
                if (bArr.length < 2) {
                    throw new IllegalArgumentException("zero length data with non-zero pad bits");
                }
                if (i > 7) {
                    throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
                }
            }
        }
        this.contents = bArr;
    }

    static ASN1BitString createPrimitive(byte[] bArr) {
        int length = bArr.length;
        if (length < 1) {
            throw new IllegalArgumentException("truncated BIT STRING detected");
        }
        int i = bArr[0] & 255;
        if (i > 0) {
            if (i > 7 || length < 2) {
                throw new IllegalArgumentException("invalid pad bits detected");
            }
            byte b = bArr[length - 1];
            if (b != ((byte) ((255 << i) & b))) {
                return new DLBitString(bArr, false);
            }
        }
        return new DERBitString(bArr, false);
    }

    public static ASN1BitString getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1BitString)) {
            return (ASN1BitString) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1BitString) {
                return (ASN1BitString) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (ASN1BitString) TYPE.fromByteArray((byte[]) obj);
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct BIT STRING from byte[]: " + e.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static ASN1BitString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1BitString) TYPE.getContextInstance(aSN1TaggedObject, z);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1BitString)) {
            return false;
        }
        byte[] bArr = this.contents;
        byte[] bArr2 = ((ASN1BitString) aSN1Primitive).contents;
        int length = bArr.length;
        if (bArr2.length != length) {
            return false;
        }
        if (length == 1) {
            return true;
        }
        int i = length - 1;
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        int i3 = 255 << (bArr[0] & 255);
        return ((byte) (bArr[i] & i3)) == ((byte) (bArr2[i] & i3));
    }

    @Override // org.bouncycastle.asn1.ASN1BitStringParser
    public InputStream getBitStream() {
        byte[] bArr = this.contents;
        return new ByteArrayInputStream(bArr, 1, bArr.length - 1);
    }

    public byte[] getBytes() {
        byte[] bArr = this.contents;
        if (bArr.length == 1) {
            return ASN1OctetString.EMPTY_OCTETS;
        }
        int i = bArr[0] & 255;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 1, bArr.length);
        int length = bArrCopyOfRange.length - 1;
        bArrCopyOfRange[length] = (byte) (((byte) (255 << i)) & bArrCopyOfRange[length]);
        return bArrCopyOfRange;
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return toASN1Primitive();
    }

    public byte[] getOctets() {
        byte[] bArr = this.contents;
        if (bArr[0] == 0) {
            return Arrays.copyOfRange(bArr, 1, bArr.length);
        }
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    @Override // org.bouncycastle.asn1.ASN1BitStringParser
    public int getPadBits() {
        return this.contents[0] & 255;
    }

    public String getString() {
        try {
            byte[] encoded = getEncoded();
            StringBuffer stringBuffer = new StringBuffer((encoded.length * 2) + 1);
            stringBuffer.append('#');
            for (int i = 0; i != encoded.length; i++) {
                byte b = encoded[i];
                char[] cArr = table;
                stringBuffer.append(cArr[(b >>> 4) & 15]);
                stringBuffer.append(cArr[b & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            throw new ASN1ParsingException("Internal error encoding BitString: " + e.getMessage(), e);
        }
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        byte[] bArr = this.contents;
        if (bArr.length < 2) {
            return 1;
        }
        int i = bArr[0] & 255;
        int length = bArr.length - 1;
        return (Arrays.hashCode(bArr, 0, length) * 257) ^ ((byte) ((255 << i) & bArr[length]));
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        return new DERBitString(this.contents, false);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return new DLBitString(this.contents, false);
    }

    public String toString() {
        return getString();
    }
}
