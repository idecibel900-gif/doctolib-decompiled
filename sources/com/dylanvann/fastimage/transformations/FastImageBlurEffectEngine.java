package com.dylanvann.fastimage.transformations;

import android.graphics.Bitmap;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FastImageBlurEffectEngine {
    public static Bitmap apply(Bitmap bitmap, float f, ImageView imageView) {
        imageView.setTag(-889275714, bitmap);
        imageView.setTag(-1161901314, Float.valueOf(f));
        ensureDynamicApply(imageView);
        return blur(bitmap, Math.max(0.1f, Math.min(200.0f, f * ((((imageView.getWidth() * (bitmap.getWidth() / 540.0f)) / bitmap.getWidth()) + ((imageView.getHeight() * (bitmap.getHeight() / 540.0f)) / bitmap.getHeight())) / 2.0f))), imageView);
    }

    static Bitmap blur(Bitmap bitmap, float f, ImageView imageView) {
        imageView.setRenderEffect(RenderEffect.createBlurEffect(f, f, Shader.TileMode.CLAMP));
        imageView.invalidate();
        return bitmap;
    }

    private static void ensureDynamicApply(final ImageView imageView) {
        Object tag = imageView.getTag(-559038737);
        if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
            return;
        }
        imageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.dylanvann.fastimage.transformations.FastImageBlurEffectEngine$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                FastImageBlurEffectEngine.m3185$r8$lambda$evnfMhaKhswbzi620Eoo_1oL4g(imageView, view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
        imageView.setTag(-559038737, Boolean.TRUE);
    }

    /* JADX INFO: renamed from: $r8$lambda$evnfMhaKhswbzi620Eoo-_1oL4g, reason: not valid java name */
    public static /* synthetic */ void m3185$r8$lambda$evnfMhaKhswbzi620Eoo_1oL4g(ImageView imageView, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i3 - i == i7 - i5 && i4 - i2 == i8 - i6) {
            return;
        }
        Object tag = imageView.getTag(-889275714);
        if (tag instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) tag;
            Object tag2 = imageView.getTag(-1161901314);
            if (tag2 instanceof Number) {
                apply(bitmap, ((Number) tag2).floatValue(), imageView);
            }
        }
    }

    public static void clean(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        imageView.setRenderEffect(null);
        imageView.invalidate();
        Object tag = imageView.getTag(-559038737);
        if (tag instanceof View.OnLayoutChangeListener) {
            imageView.removeOnLayoutChangeListener((View.OnLayoutChangeListener) tag);
        }
        imageView.setTag(-889275714, null);
        imageView.setTag(-1161901314, null);
        imageView.setTag(-559038737, null);
    }
}
