package com.facebook.react.views.image;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReactImageDownloadListener extends ForwardingDrawable implements ControllerListener {
    public static final Companion Companion = new Companion(null);

    private static final class EmptyDrawable extends Drawable {
        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageFailed(String id, Throwable throwable) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageSet(String id, Object obj) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    public abstract void onProgressChange(int i, int i2);

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onRelease(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    public ReactImageDownloadListener() {
        super(new EmptyDrawable());
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        onProgressChange(i, ColorExtractionConstants.MAX_PIXEL_SAMPLES);
        return super.onLevelChange(i);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
