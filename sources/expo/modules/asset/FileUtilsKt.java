package expo.modules.asset;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FileUtilsKt {
    public static final String getMD5HashOfFileContent(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[8192];
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                try {
                    int i = fileInputStream.read(bArr);
                    if (i != -1) {
                        messageDigest.update(bArr, 0, i);
                    } else {
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileInputStream, null);
                        byte[] bArrDigest = messageDigest.digest();
                        Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
                        return ArraysKt.joinToString$default(bArrDigest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: expo.modules.asset.FileUtilsKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return FileUtilsKt.getMD5HashOfFileContent$lambda$1(((Byte) obj).byteValue());
                            }
                        }, 30, (Object) null);
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(fileInputStream, th);
                        throw th2;
                    }
                }
                e.printStackTrace();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getMD5HashOfFileContent$lambda$1(byte b) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
