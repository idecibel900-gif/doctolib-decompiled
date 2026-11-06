package expo.modules.kotlin.uuidv5;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Uuidv5Kt {
    public static final UUID uuidv5(UUID namespace, String name) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(name, "name");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update(toBytes(namespace));
        byte[] bytes = name.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        messageDigest.update(bytes);
        byte[] bArrDigest = messageDigest.digest();
        bArrDigest[6] = (byte) ((bArrDigest[6] & 15) | 80);
        bArrDigest[8] = (byte) ((bArrDigest[8] & 63) | 128);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArrDigest);
        return new UUID(byteBufferWrap.getLong(), byteBufferWrap.getLong());
    }

    public static final byte[] toBytes(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[16]);
        byteBufferWrap.putLong(uuid.getMostSignificantBits());
        byteBufferWrap.putLong(uuid.getLeastSignificantBits());
        byte[] bArrArray = byteBufferWrap.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        return bArrArray;
    }
}
