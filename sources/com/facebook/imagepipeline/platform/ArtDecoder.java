package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.util.Pools$Pool;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ArtDecoder extends DefaultDecoder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtDecoder(BitmapPool bitmapPool, Pools$Pool decodeBuffers, PlatformDecoderOptions platformDecoderOptions) {
        super(bitmapPool, decodeBuffers, platformDecoderOptions);
        Intrinsics.checkNotNullParameter(bitmapPool, "bitmapPool");
        Intrinsics.checkNotNullParameter(decodeBuffers, "decodeBuffers");
        Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
    }

    @Override // com.facebook.imagepipeline.platform.DefaultDecoder
    public int getBitmapSize(int i, int i2, BitmapFactory.Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        Bitmap.Config config = options.inPreferredConfig;
        if (config == null) {
            throw new IllegalStateException("Required value was null.");
        }
        return BitmapUtil.getSizeInByteForBitmap(i, i2, config);
    }
}
