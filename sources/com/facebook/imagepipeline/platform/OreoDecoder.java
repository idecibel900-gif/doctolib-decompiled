package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.util.Pools$Pool;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class OreoDecoder extends DefaultDecoder {
    private final PlatformDecoderOptions platformDecoderOptions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OreoDecoder(BitmapPool bitmapPool, Pools$Pool decodeBuffers, PlatformDecoderOptions platformDecoderOptions) {
        super(bitmapPool, decodeBuffers, platformDecoderOptions);
        Intrinsics.checkNotNullParameter(bitmapPool, "bitmapPool");
        Intrinsics.checkNotNullParameter(decodeBuffers, "decodeBuffers");
        Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
        this.platformDecoderOptions = platformDecoderOptions;
    }

    @Override // com.facebook.imagepipeline.platform.DefaultDecoder
    public int getBitmapSize(int i, int i2, BitmapFactory.Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        Bitmap.Config config = options.outConfig;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        return BitmapUtil.getSizeInByteForBitmap(i, i2, config);
    }
}
