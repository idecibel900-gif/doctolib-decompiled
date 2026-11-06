package com.facebook.drawee.drawable;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class DrawableProperties {
    public static final Companion Companion = new Companion(null);
    private ColorFilter colorFilter;
    private boolean isSetColorFilter;
    private int alpha = -1;
    private int dither = -1;
    private int filterBitmap = -1;

    public final void setAlpha(int i) {
        this.alpha = i;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        this.isSetColorFilter = colorFilter != null;
    }

    public final void setDither(boolean z) {
        this.dither = z ? 1 : 0;
    }

    public final void setFilterBitmap(boolean z) {
        this.filterBitmap = z ? 1 : 0;
    }

    public final void applyTo(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        int i = this.alpha;
        if (i != -1) {
            drawable.setAlpha(i);
        }
        if (this.isSetColorFilter) {
            drawable.setColorFilter(this.colorFilter);
        }
        int i2 = this.dither;
        if (i2 != -1) {
            drawable.setDither(i2 != 0);
        }
        int i3 = this.filterBitmap;
        if (i3 != -1) {
            drawable.setFilterBitmap(i3 != 0);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
