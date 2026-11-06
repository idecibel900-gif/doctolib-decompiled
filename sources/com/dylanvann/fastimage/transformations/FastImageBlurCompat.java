package com.dylanvann.fastimage.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FastImageBlurCompat {
    public static Bitmap blur(Context context, Bitmap bitmap, float f, ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 31) {
            return FastImageBlurEffectEngine.apply(bitmap, f, imageView);
        }
        return FastImageBlurScriptEngine.apply(bitmap, f, context);
    }

    public static void clean(ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 31) {
            FastImageBlurEffectEngine.clean(imageView);
        } else {
            FastImageBlurScriptEngine.clean(imageView);
        }
    }
}
