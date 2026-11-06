package org.apache.commons.codec.digest;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DigestUtils {
    private static byte[] digest(MessageDigest messageDigest, InputStream inputStream) {
        return updateDigest(messageDigest, inputStream).digest();
    }

    public static MessageDigest getDigest(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static MessageDigest getMd5Digest() {
        return getDigest("MD5");
    }

    public static byte[] md5(InputStream inputStream) {
        return digest(getMd5Digest(), inputStream);
    }

    public static MessageDigest updateDigest(MessageDigest messageDigest, InputStream inputStream) throws IOException {
        byte[] bArr = new byte[IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET];
        int i = inputStream.read(bArr, 0, IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET);
        while (i > -1) {
            messageDigest.update(bArr, 0, i);
            i = inputStream.read(bArr, 0, IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET);
        }
        return messageDigest;
    }
}
