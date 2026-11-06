package com.facebook.imagepipeline.platform;

import android.os.Build;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.common.memory.DecodeBufferHelper;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imagepipeline.memory.PoolFactory;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class PlatformDecoderFactory {
    public static final PlatformDecoderFactory INSTANCE = new PlatformDecoderFactory();

    private PlatformDecoderFactory() {
    }

    public static final PlatformDecoder buildPlatformDecoder(PoolFactory poolFactory, boolean z, boolean z2, PlatformDecoderOptions platformDecoderOptions) {
        Intrinsics.checkNotNullParameter(poolFactory, "poolFactory");
        Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
        if (Build.VERSION.SDK_INT >= 26) {
            BitmapPool bitmapPool = poolFactory.getBitmapPool();
            Intrinsics.checkNotNullExpressionValue(bitmapPool, "getBitmapPool(...)");
            return new OreoDecoder(bitmapPool, createPool(poolFactory, z2), platformDecoderOptions);
        }
        BitmapPool bitmapPool2 = poolFactory.getBitmapPool();
        Intrinsics.checkNotNullExpressionValue(bitmapPool2, "getBitmapPool(...)");
        return new ArtDecoder(bitmapPool2, createPool(poolFactory, z2), platformDecoderOptions);
    }

    public static final Pools$Pool createPool(PoolFactory poolFactory, boolean z) {
        Intrinsics.checkNotNullParameter(poolFactory, "poolFactory");
        if (z) {
            DecodeBufferHelper INSTANCE2 = DecodeBufferHelper.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
            return INSTANCE2;
        }
        int flexByteArrayPoolMaxNumThreads = poolFactory.getFlexByteArrayPoolMaxNumThreads();
        Pools$SynchronizedPool pools$SynchronizedPool = new Pools$SynchronizedPool(flexByteArrayPoolMaxNumThreads);
        for (int i = 0; i < flexByteArrayPoolMaxNumThreads; i++) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(DecodeBufferHelper.getRecommendedDecodeBufferSize());
            Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
            pools$SynchronizedPool.release(byteBufferAllocate);
        }
        return pools$SynchronizedPool;
    }
}
