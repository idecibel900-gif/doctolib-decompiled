package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ArtBitmapFactory extends PlatformBitmapFactory {
    private final BitmapPool bitmapPool;
    private final CloseableReferenceFactory closeableReferenceFactory;

    public ArtBitmapFactory(BitmapPool bitmapPool, CloseableReferenceFactory closeableReferenceFactory) {
        Intrinsics.checkNotNullParameter(bitmapPool, "bitmapPool");
        Intrinsics.checkNotNullParameter(closeableReferenceFactory, "closeableReferenceFactory");
        this.bitmapPool = bitmapPool;
        this.closeableReferenceFactory = closeableReferenceFactory;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public CloseableReference createBitmapInternal(int i, int i2, Bitmap.Config bitmapConfig) {
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        Bitmap bitmap = (Bitmap) this.bitmapPool.get(BitmapUtil.getSizeInByteForBitmap(i, i2, bitmapConfig));
        if (bitmap.getAllocationByteCount() < i * i2 * BitmapUtil.getPixelSizeForBitmapConfig(bitmapConfig)) {
            throw new IllegalStateException("Check failed.");
        }
        bitmap.reconfigure(i, i2, bitmapConfig);
        CloseableReference closeableReferenceCreate = this.closeableReferenceFactory.create(bitmap, this.bitmapPool);
        Intrinsics.checkNotNullExpressionValue(closeableReferenceCreate, "create(...)");
        return closeableReferenceCreate;
    }
}
