package com.facebook.imagepipeline.memory;

import com.facebook.react.devsupport.CxxInspectorPackagerConnection;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BitmapCounterProvider {
    public static final BitmapCounterProvider INSTANCE;
    public static final int MAX_BITMAP_TOTAL_SIZE;
    private static volatile BitmapCounter bitmapCounter;
    private static int maxBitmapCount;

    private BitmapCounterProvider() {
    }

    static {
        BitmapCounterProvider bitmapCounterProvider = new BitmapCounterProvider();
        INSTANCE = bitmapCounterProvider;
        MAX_BITMAP_TOTAL_SIZE = bitmapCounterProvider.getMaxSizeHardCap();
        maxBitmapCount = 384;
    }

    private final int getMaxSizeHardCap() {
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (iMin > CxxInspectorPackagerConnection.MAX_QUEUE_SIZE) {
            return (iMin / 4) * 3;
        }
        return iMin / 2;
    }

    public static final BitmapCounter get() {
        if (bitmapCounter == null) {
            synchronized (BitmapCounterProvider.class) {
                try {
                    if (bitmapCounter == null) {
                        bitmapCounter = new BitmapCounter(maxBitmapCount, MAX_BITMAP_TOTAL_SIZE);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        BitmapCounter bitmapCounter2 = bitmapCounter;
        Intrinsics.checkNotNull(bitmapCounter2);
        return bitmapCounter2;
    }
}
