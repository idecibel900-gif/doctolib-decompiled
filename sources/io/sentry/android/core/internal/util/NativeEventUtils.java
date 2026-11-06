package io.sentry.android.core.internal.util;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes5.dex */
public abstract class NativeEventUtils {
    public static byte[] readBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET];
            while (true) {
                int i = inputStream.read(bArr, 0, IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String buildIdToDebugId(String str) {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new BigInteger("10" + str, 16).toByteArray());
            byteBufferWrap.get();
            return String.format("%08x-%04x-%04x-%04x-%04x%08x", Integer.valueOf(byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN).getInt()), Short.valueOf(byteBufferWrap.getShort()), Short.valueOf(byteBufferWrap.getShort()), Short.valueOf(byteBufferWrap.order(ByteOrder.BIG_ENDIAN).getShort()), Short.valueOf(byteBufferWrap.getShort()), Integer.valueOf(byteBufferWrap.getInt()));
        } catch (NumberFormatException | BufferUnderflowException unused) {
            return null;
        }
    }
}
