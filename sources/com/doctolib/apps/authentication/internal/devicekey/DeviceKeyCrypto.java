package com.doctolib.apps.authentication.internal.devicekey;

import android.util.Base64;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.ECPublicKey;
import java.util.Arrays;
import java.util.UUID;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final class DeviceKeyCrypto {
    public static final DeviceKeyCrypto INSTANCE = new DeviceKeyCrypto();

    private DeviceKeyCrypto() {
    }

    public static final class PublicJwk {
        private final String json;
        private final String kid;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PublicJwk)) {
                return false;
            }
            PublicJwk publicJwk = (PublicJwk) obj;
            return Intrinsics.areEqual(this.kid, publicJwk.kid) && Intrinsics.areEqual(this.json, publicJwk.json);
        }

        public int hashCode() {
            return (this.kid.hashCode() * 31) + this.json.hashCode();
        }

        public String toString() {
            return "PublicJwk(kid=" + this.kid + ", json=" + this.json + ")";
        }

        public PublicJwk(String kid, String json) {
            Intrinsics.checkNotNullParameter(kid, "kid");
            Intrinsics.checkNotNullParameter(json, "json");
            this.kid = kid;
            this.json = json;
        }

        public final String getJson() {
            return this.json;
        }

        public final String getKid() {
            return this.kid;
        }
    }

    public final String base64Url(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        String strEncodeToString = Base64.encodeToString(bytes, 11);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    public final PublicJwk publicJwk(ECPublicKey publicKey) {
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        BigInteger affineX = publicKey.getW().getAffineX();
        Intrinsics.checkNotNullExpressionValue(affineX, "getAffineX(...)");
        String strBase64Url = base64Url(DeviceKeyCryptoKt.toFixed32(affineX));
        BigInteger affineY = publicKey.getW().getAffineY();
        Intrinsics.checkNotNullExpressionValue(affineY, "getAffineY(...)");
        String strBase64Url2 = base64Url(DeviceKeyCryptoKt.toFixed32(affineY));
        String strThumbprint = thumbprint(strBase64Url, strBase64Url2);
        return new PublicJwk(strThumbprint, "{\"kty\":\"EC\",\"crv\":\"P-256\",\"kid\":\"" + strThumbprint + "\",\"x\":\"" + strBase64Url + "\",\"y\":\"" + strBase64Url2 + "\",\"alg\":\"ES256\"}");
    }

    public final String thumbprintOfCanonicalJson(String canonicalJson) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(canonicalJson, "canonicalJson");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = canonicalJson.getBytes(Charsets.US_ASCII);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
        return base64Url(bArrDigest);
    }

    public final String thumbprint(String x, String y) {
        Intrinsics.checkNotNullParameter(x, "x");
        Intrinsics.checkNotNullParameter(y, "y");
        return thumbprintOfCanonicalJson("{\"crv\":\"P-256\",\"kty\":\"EC\",\"x\":\"" + x + "\",\"y\":\"" + y + "\"}");
    }

    public final String jwsCompact(Signature signature, String kid, String issuer, String subject, String audience, int i) throws SignatureException {
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(kid, "kid");
        Intrinsics.checkNotNullParameter(issuer, "issuer");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(audience, "audience");
        if (1 > i || i >= 121) {
            throw new IllegalArgumentException("lifetimeSeconds must be between 1 and 120");
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        String str = "{\"alg\":\"ES256\",\"typ\":\"device-key+jwt\",\"kid\":\"" + jsonEscape(kid) + "\"}";
        String str2 = "{\"iss\":\"" + jsonEscape(issuer) + "\",\"sub\":\"" + jsonEscape(subject) + "\",\"aud\":\"" + jsonEscape(audience) + "\",\"iat\":" + jCurrentTimeMillis + ",\"exp\":" + (((long) i) + jCurrentTimeMillis) + ",\"jti\":\"" + UUID.randomUUID() + "\"}";
        Charset charset = Charsets.UTF_8;
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String strBase64Url = base64Url(bytes);
        byte[] bytes2 = str2.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        String str3 = strBase64Url + "." + base64Url(bytes2);
        byte[] bytes3 = str3.getBytes(Charsets.US_ASCII);
        Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
        signature.update(bytes3);
        byte[] bArrSign = signature.sign();
        Intrinsics.checkNotNullExpressionValue(bArrSign, "sign(...)");
        return str3 + "." + base64Url(derToRawEcdsaSignature(bArrSign));
    }

    public final byte[] derToRawEcdsaSignature(byte[] der) {
        Intrinsics.checkNotNullParameter(der, "der");
        if (der.length >= 8) {
            int i = 0;
            if (der[0] == 48) {
                byte b = der[1];
                int i2 = b & 255;
                int i3 = 2;
                if ((b & 128) != 0) {
                    int i4 = b & 127;
                    if (1 > i4 || i4 >= 3 || 2 + i4 > der.length) {
                        throw new IllegalArgumentException("unsupported DER length form");
                    }
                    int i5 = 0;
                    while (i < i4) {
                        i5 = (i5 << 8) | (der[i3] & 255);
                        i++;
                        i3++;
                    }
                    i2 = i5;
                }
                if (i2 + i3 != der.length) {
                    throw new IllegalArgumentException("DER length does not match buffer");
                }
                DerInteger integer = readInteger(der, i3);
                DerInteger integer2 = readInteger(der, integer.getNext());
                if (integer2.getNext() != der.length) {
                    throw new IllegalArgumentException("trailing bytes after INTEGER s");
                }
                return ArraysKt.plus(DeviceKeyCryptoKt.toFixed32(integer.getValue()), DeviceKeyCryptoKt.toFixed32(integer2.getValue()));
            }
        }
        throw new IllegalArgumentException("not a DER SEQUENCE");
    }

    private static final class DerInteger {
        private final int next;
        private final BigInteger value;

        public DerInteger(BigInteger value, int i) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
            this.next = i;
        }

        public final int getNext() {
            return this.next;
        }

        public final BigInteger getValue() {
            return this.value;
        }
    }

    private final DerInteger readInteger(byte[] bArr, int i) {
        int i2 = i + 2;
        if (i2 > bArr.length || bArr[i] != 2) {
            throw new IllegalArgumentException("expected INTEGER");
        }
        int i3 = bArr[i + 1] & 255;
        if (1 > i3 || i3 >= 34 || i2 + i3 > bArr.length) {
            throw new IllegalArgumentException(("bad INTEGER length: " + i3).toString());
        }
        int i4 = i3 + i2;
        return new DerInteger(new BigInteger(ArraysKt.copyOfRange(bArr, i2, i4)), i4);
    }

    private final String jsonEscape(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"') {
                sb.append("\\\"");
            } else if (cCharAt == '\\') {
                sb.append("\\\\");
            } else if (cCharAt == '\n') {
                sb.append("\\n");
            } else if (cCharAt == '\r') {
                sb.append("\\r");
            } else if (cCharAt == '\t') {
                sb.append("\\t");
            } else if (Intrinsics.compare((int) cCharAt, 32) < 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str2 = String.format("\\u%04x", Arrays.copyOf(new Object[]{Integer.valueOf(cCharAt)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                sb.append(str2);
            } else {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
