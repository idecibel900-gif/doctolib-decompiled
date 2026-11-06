package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PlatformBitmapFactory {
    public abstract CloseableReference createBitmapInternal(int i, int i2, Bitmap.Config config);

    public CloseableReference createBitmap(int i, int i2, Bitmap.Config config) {
        return createBitmap(i, i2, config, null);
    }

    public CloseableReference createBitmap(int i, int i2) {
        return createBitmap(i, i2, Bitmap.Config.ARGB_8888);
    }

    public CloseableReference createBitmap(int i, int i2, Bitmap.Config config, Object obj) {
        return createBitmapInternal(i, i2, config);
    }
}
