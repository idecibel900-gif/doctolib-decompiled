package org.bouncycastle.asn1;

import com.amazon.a.a.o.c.a.b;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Properties;

/* JADX INFO: loaded from: classes5.dex */
public class ASN1RelativeOID extends ASN1Primitive {
    static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1RelativeOID.class, 13) { // from class: org.bouncycastle.asn1.ASN1RelativeOID.1
        @Override // org.bouncycastle.asn1.ASN1UniversalType
        ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1RelativeOID.createPrimitive(dEROctetString.getOctets(), false);
        }
    };
    private static final ConcurrentMap pool = new ConcurrentHashMap();
    private final byte[] contents;
    private String identifier;

    private ASN1RelativeOID(byte[] bArr, String str) {
        this.contents = bArr;
        this.identifier = str;
    }

    static void checkContentsLength(int i) {
        if (i > 4096) {
            throw new IllegalArgumentException("exceeded relative OID contents length limit");
        }
    }

    static void checkIdentifier(String str) {
        if (str == null) {
            throw new NullPointerException("'identifier' cannot be null");
        }
        if (str.length() > 16383) {
            throw new IllegalArgumentException("exceeded relative OID contents length limit");
        }
        if (isValidIdentifier(str, 0)) {
            return;
        }
        throw new IllegalArgumentException("string " + str + " not a valid relative OID");
    }

    static ASN1RelativeOID createPrimitive(byte[] bArr, boolean z) {
        checkContentsLength(bArr.length);
        ASN1RelativeOID aSN1RelativeOID = (ASN1RelativeOID) pool.get(new ASN1ObjectIdentifier.OidHandle(bArr));
        if (aSN1RelativeOID != null) {
            return aSN1RelativeOID;
        }
        if (!isValidContents(bArr)) {
            throw new IllegalArgumentException("invalid relative OID contents");
        }
        if (z) {
            bArr = Arrays.clone(bArr);
        }
        return new ASN1RelativeOID(bArr, null);
    }

    static boolean isValidContents(byte[] bArr) {
        if (Properties.isOverrideSet("org.bouncycastle.asn1.allow_wrong_oid_enc")) {
            return true;
        }
        if (bArr.length < 1) {
            return false;
        }
        boolean z = true;
        for (int i = 0; i < bArr.length; i++) {
            if (z && (bArr[i] & 255) == 128) {
                return false;
            }
            z = (bArr[i] & 128) == 0;
        }
        return z;
    }

    static boolean isValidIdentifier(String str, int i) {
        int length = str.length();
        int i2 = 0;
        while (true) {
            int i3 = length - 1;
            if (i3 < i) {
                return i2 != 0 && (i2 <= 1 || str.charAt(length) != '0');
            }
            char cCharAt = str.charAt(i3);
            if (cCharAt == '.') {
                if (i2 == 0 || (i2 > 1 && str.charAt(length) == '0')) {
                    return false;
                }
                i2 = 0;
            } else {
                if ('0' > cCharAt || cCharAt > '9') {
                    return false;
                }
                i2++;
            }
            length = i3;
        }
    }

    static String parseContents(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        BigInteger bigIntegerShiftLeft = null;
        long j = 0;
        for (int i = 0; i != bArr.length; i++) {
            byte b = bArr[i];
            if (j <= 72057594037927808L) {
                long j2 = j + ((long) (b & 127));
                if ((b & 128) == 0) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(b.a);
                    }
                    sb.append(j2);
                    j = 0;
                } else {
                    j = j2 << 7;
                }
            } else {
                if (bigIntegerShiftLeft == null) {
                    bigIntegerShiftLeft = BigInteger.valueOf(j);
                }
                BigInteger bigIntegerOr = bigIntegerShiftLeft.or(BigInteger.valueOf(b & 127));
                if ((b & 128) == 0) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(b.a);
                    }
                    sb.append(bigIntegerOr);
                    bigIntegerShiftLeft = null;
                    j = 0;
                } else {
                    bigIntegerShiftLeft = bigIntegerOr.shiftLeft(7);
                }
            }
        }
        return sb.toString();
    }

    static byte[] parseIdentifier(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OIDTokenizer oIDTokenizer = new OIDTokenizer(str);
        while (oIDTokenizer.hasMoreTokens()) {
            String strNextToken = oIDTokenizer.nextToken();
            if (strNextToken.length() <= 18) {
                writeField(byteArrayOutputStream, Long.parseLong(strNextToken));
            } else {
                writeField(byteArrayOutputStream, new BigInteger(strNextToken));
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    static void writeField(ByteArrayOutputStream byteArrayOutputStream, long j) {
        byte[] bArr = new byte[9];
        int i = 8;
        bArr[8] = (byte) (((int) j) & 127);
        while (j >= 128) {
            j >>= 7;
            i--;
            bArr[i] = (byte) (((int) j) | 128);
        }
        byteArrayOutputStream.write(bArr, i, 9 - i);
    }

    static void writeField(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int iBitLength = (bigInteger.bitLength() + 6) / 7;
        if (iBitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[iBitLength];
        int i = iBitLength - 1;
        for (int i2 = i; i2 >= 0; i2--) {
            bArr[i2] = (byte) (bigInteger.intValue() | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i] = (byte) (bArr[i] & 127);
        byteArrayOutputStream.write(bArr, 0, iBitLength);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (this == aSN1Primitive) {
            return true;
        }
        if (aSN1Primitive instanceof ASN1RelativeOID) {
            return Arrays.areEqual(this.contents, ((ASN1RelativeOID) aSN1Primitive).contents);
        }
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream aSN1OutputStream, boolean z) {
        aSN1OutputStream.writeEncodingDL(z, 13, this.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean z) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, this.contents.length);
    }

    public synchronized String getId() {
        try {
            if (this.identifier == null) {
                this.identifier = parseContents(this.contents);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.identifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public String toString() {
        return getId();
    }
}
