package com.bumptech.glide.integration.webp.decoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes3.dex */
abstract class Utils {
    static int getSampleSize(int i, int i2, int i3, int i4) {
        int iMin = Math.min(i2 / i4, i / i3);
        return Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
    }

    static byte[] inputStreamToBytes(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Http2.INITIAL_MAX_FRAME_SIZE);
        try {
            byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
