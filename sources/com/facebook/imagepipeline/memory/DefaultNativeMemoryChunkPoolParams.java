package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultNativeMemoryChunkPoolParams {
    public static final DefaultNativeMemoryChunkPoolParams INSTANCE = new DefaultNativeMemoryChunkPoolParams();

    private DefaultNativeMemoryChunkPoolParams() {
    }

    public static final PoolParams get() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET, 5);
        sparseIntArray.put(2048, 5);
        sparseIntArray.put(4096, 5);
        sparseIntArray.put(8192, 5);
        sparseIntArray.put(Http2.INITIAL_MAX_FRAME_SIZE, 5);
        sparseIntArray.put(32768, 5);
        sparseIntArray.put(65536, 5);
        sparseIntArray.put(131072, 5);
        sparseIntArray.put(262144, 2);
        sparseIntArray.put(524288, 2);
        sparseIntArray.put(1048576, 2);
        DefaultNativeMemoryChunkPoolParams defaultNativeMemoryChunkPoolParams = INSTANCE;
        return new PoolParams(defaultNativeMemoryChunkPoolParams.getMaxSizeSoftCap(), defaultNativeMemoryChunkPoolParams.getMaxSizeHardCap(), sparseIntArray);
    }

    private final int getMaxSizeSoftCap() {
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (iMin < 16777216) {
            return 3145728;
        }
        return iMin < 33554432 ? 6291456 : 12582912;
    }

    private final int getMaxSizeHardCap() {
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (iMin < 16777216) {
            return iMin / 2;
        }
        return (iMin / 4) * 3;
    }
}
