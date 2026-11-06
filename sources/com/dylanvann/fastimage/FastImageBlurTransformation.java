package com.dylanvann.fastimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.ImageView;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.dylanvann.fastimage.transformations.FastImageBlurCompat;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public class FastImageBlurTransformation extends BitmapTransformation {
    private static final byte[] ID_BYTES = "com.dylanvann.fastimage.FastImageBlurTransformation".getBytes(Key.CHARSET);
    private final Context context;
    private final float radius;
    private final ImageView view;

    public FastImageBlurTransformation(Context context, float f, ImageView imageView) {
        this.context = context.getApplicationContext();
        this.radius = normalizeBlurRadius(f);
        this.view = imageView;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return FastImageBlurCompat.blur(this.context, bitmap, this.radius, this.view);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return Build.VERSION.SDK_INT < 31 && (obj instanceof FastImageBlurTransformation) && this.radius == ((FastImageBlurTransformation) obj).radius;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 210279540 + Float.valueOf(this.radius).hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        messageDigest.update(ByteBuffer.allocate(4).putFloat(this.radius).array());
    }

    private float normalizeBlurRadius(float f) {
        return Math.min(200.0f, Math.max(0.1f, f));
    }

    public static void clean(ImageView imageView) {
        FastImageBlurCompat.clean(imageView);
    }
}
