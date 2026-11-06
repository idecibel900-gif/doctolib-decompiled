package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultBitmapPoolParams {
    public static final DefaultBitmapPoolParams INSTANCE = new DefaultBitmapPoolParams();
    private static final SparseIntArray DEFAULT_BUCKETS = new SparseIntArray(0);

    private DefaultBitmapPoolParams() {
    }

    private final int getMaxSizeHardCap() {
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (iMin > 16777216) {
            return (iMin / 4) * 3;
        }
        return iMin / 2;
    }

    public static final PoolParams get() {
        return new PoolParams(0, INSTANCE.getMaxSizeHardCap(), DEFAULT_BUCKETS);
    }
}
