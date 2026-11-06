package com.facebook.common.util;

import com.facebook.common.internal.Preconditions;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class StreamUtil {
    public static long skip(InputStream inputStream, long j) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkArgument(Boolean.valueOf(j >= 0));
        long j2 = j;
        while (j2 > 0) {
            long jSkip = inputStream.skip(j2);
            if (jSkip <= 0) {
                if (inputStream.read() == -1) {
                    return j - j2;
                }
                jSkip = 1;
            }
            j2 -= jSkip;
        }
        return j;
    }
}
