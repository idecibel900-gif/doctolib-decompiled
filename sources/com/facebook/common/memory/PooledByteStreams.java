package com.facebook.common.memory;

import com.facebook.common.internal.Preconditions;
import java.io.InputStream;
import java.io.OutputStream;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes3.dex */
public class PooledByteStreams {
    private final ByteArrayPool mByteArrayPool;
    private final int mTempBufSize;

    public PooledByteStreams(ByteArrayPool byteArrayPool) {
        this(byteArrayPool, Http2.INITIAL_MAX_FRAME_SIZE);
    }

    public PooledByteStreams(ByteArrayPool byteArrayPool, int i) {
        Preconditions.checkArgument(Boolean.valueOf(i > 0));
        this.mTempBufSize = i;
        this.mByteArrayPool = byteArrayPool;
    }

    public long copy(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = (byte[]) this.mByteArrayPool.get(this.mTempBufSize);
        long j = 0;
        while (true) {
            try {
                int i = inputStream.read(bArr, 0, this.mTempBufSize);
                if (i != -1) {
                    outputStream.write(bArr, 0, i);
                    j += (long) i;
                } else {
                    this.mByteArrayPool.release(bArr);
                    return j;
                }
            } catch (Throwable th) {
                this.mByteArrayPool.release(bArr);
                throw th;
            }
        }
    }
}
