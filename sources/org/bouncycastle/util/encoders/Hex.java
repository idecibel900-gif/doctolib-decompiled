package org.bouncycastle.util.encoders;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Hex {
    private static final HexEncoder encoder = new HexEncoder();

    public static byte[] decodeStrict(String str) {
        try {
            return encoder.decodeStrict(str, 0, str.length());
        } catch (Exception e) {
            throw new DecoderException("exception decoding Hex string: " + e.getMessage(), e);
        }
    }

    public static byte[] encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public static byte[] encode(byte[] bArr, int i, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            encoder.encode(bArr, i, i2, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new EncoderException("exception encoding Hex string: " + e.getMessage(), e);
        }
    }

    public static String toHexString(byte[] bArr) {
        return toHexString(bArr, 0, bArr.length);
    }

    public static String toHexString(byte[] bArr, int i, int i2) {
        return Strings.fromByteArray(encode(bArr, i, i2));
    }
}
