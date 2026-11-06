package com.facebook.drawee.debug.listener;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ImageLoadingTimeControllerListener extends BaseControllerListener {
    private final ImageLoadingTimeListener imageLoadingTimeListener;
    private long requestSubmitTimeMs = -1;
    private long finalImageSetTimeMs = -1;

    public ImageLoadingTimeControllerListener(ImageLoadingTimeListener imageLoadingTimeListener) {
        this.imageLoadingTimeListener = imageLoadingTimeListener;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String id, Object obj) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.requestSubmitTimeMs = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String id, Object obj, Animatable animatable) {
        Intrinsics.checkNotNullParameter(id, "id");
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.finalImageSetTimeMs = jCurrentTimeMillis;
        ImageLoadingTimeListener imageLoadingTimeListener = this.imageLoadingTimeListener;
        if (imageLoadingTimeListener != null) {
            imageLoadingTimeListener.onFinalImageSet(jCurrentTimeMillis - this.requestSubmitTimeMs);
        }
    }
}
