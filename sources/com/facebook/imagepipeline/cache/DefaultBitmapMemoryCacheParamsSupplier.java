package com.facebook.imagepipeline.cache;

import android.app.ActivityManager;
import com.facebook.common.internal.Supplier;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultBitmapMemoryCacheParamsSupplier implements Supplier {
    private static final long PARAMS_CHECK_INTERVAL_MS = TimeUnit.MINUTES.toMillis(5);
    private final ActivityManager mActivityManager;

    public DefaultBitmapMemoryCacheParamsSupplier(ActivityManager activityManager) {
        this.mActivityManager = activityManager;
    }

    @Override // com.facebook.common.internal.Supplier
    public MemoryCacheParams get() {
        return new MemoryCacheParams(getMaxCacheSize(), IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, PARAMS_CHECK_INTERVAL_MS);
    }

    private int getMaxCacheSize() {
        int iMin = Math.min(this.mActivityManager.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        if (iMin < 33554432) {
            return 4194304;
        }
        if (iMin < 67108864) {
            return 6291456;
        }
        return iMin / 4;
    }
}
