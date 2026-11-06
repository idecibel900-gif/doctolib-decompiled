package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BitmapTransformation implements Transformation {
    protected abstract Bitmap transform(Context context, BitmapPool bitmapPool, Bitmap bitmap, int i, int i2);

    @Override // com.bumptech.glide.load.Transformation
    public final Resource transform(Context context, Resource resource, int i, int i2) {
        if (!Util.isValidDimensions(i, i2)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
        Bitmap bitmap = (Bitmap) resource.get();
        if (i == Integer.MIN_VALUE) {
            i = bitmap.getWidth();
        }
        int i3 = i;
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getHeight();
        }
        Bitmap bitmapTransform = transform(context.getApplicationContext(), bitmapPool, bitmap, i3, i2);
        return bitmap.equals(bitmapTransform) ? resource : BitmapResource.obtain(bitmapTransform, bitmapPool);
    }

    void setCanvasBitmapDensity(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setDensity(bitmap.getDensity());
    }
}
