package com.facebook.common.memory;

import androidx.core.util.Pools$Pool;
import java.nio.ByteBuffer;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes3.dex */
public class DecodeBufferHelper implements Pools$Pool {
    public static final DecodeBufferHelper INSTANCE = new DecodeBufferHelper();
    private static int sRecommendedDecodeBufferSize = Http2.INITIAL_MAX_FRAME_SIZE;
    private static final ThreadLocal sBuffer = new ThreadLocal() { // from class: com.facebook.common.memory.DecodeBufferHelper.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ByteBuffer initialValue() {
            return ByteBuffer.allocate(DecodeBufferHelper.sRecommendedDecodeBufferSize);
        }
    };

    @Override // androidx.core.util.Pools$Pool
    public boolean release(ByteBuffer byteBuffer) {
        return true;
    }

    public static int getRecommendedDecodeBufferSize() {
        return sRecommendedDecodeBufferSize;
    }

    @Override // androidx.core.util.Pools$Pool
    public ByteBuffer acquire() {
        return (ByteBuffer) sBuffer.get();
    }
}
