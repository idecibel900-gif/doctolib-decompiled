package com.facebook.imagepipeline.drawable;

import android.graphics.drawable.Drawable;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: classes3.dex */
public interface DrawableFactory {
    Drawable createDrawable(CloseableImage closeableImage);

    boolean supportsImageType(CloseableImage closeableImage);
}
