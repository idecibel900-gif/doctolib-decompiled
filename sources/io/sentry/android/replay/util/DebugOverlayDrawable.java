package io.sentry.android.replay.util;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class DebugOverlayDrawable extends Drawable {
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final int maskBackgroundColor = Color.argb(32, 255, 20, 20);
    private static final int maskBorderColor = Color.argb(128, 255, 20, 20);
    private final Paint paint = new Paint(1);
    private final float padding = 6.0f;
    private final Rect tmpRect = new Rect();
    private List masks = CollectionsKt.emptyList();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.paint.setTextSize(32.0f);
        this.paint.setColor(-16777216);
        this.paint.setStrokeWidth(6.0f);
        for (Rect rect : this.masks) {
            this.paint.setColor(maskBackgroundColor);
            this.paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(rect, this.paint);
            this.paint.setColor(maskBorderColor);
            this.paint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(rect, this.paint);
            StringBuilder sb = new StringBuilder();
            sb.append(rect.left);
            sb.append('/');
            sb.append(rect.top);
            String string = sb.toString();
            this.paint.getTextBounds(string, 0, string.length(), this.tmpRect);
            drawTextWithOutline(canvas, string, rect.left, rect.top);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(rect.right);
            sb2.append('/');
            sb2.append(rect.bottom);
            String string2 = sb2.toString();
            this.paint.getTextBounds(string2, 0, string2.length(), this.tmpRect);
            drawTextWithOutline(canvas, string2, rect.right - this.tmpRect.width(), rect.bottom + this.tmpRect.height());
        }
    }

    private final void drawTextWithOutline(Canvas canvas, String str, float f, float f2) {
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        canvas.drawText(str, f, f2, this.paint);
        this.paint.setColor(-16777216);
        this.paint.setStyle(Paint.Style.FILL);
        canvas.drawText(str, f, f2, this.paint);
    }

    public final void updateMasks(List masks) {
        Intrinsics.checkNotNullParameter(masks, "masks");
        this.masks = masks;
        invalidateSelf();
    }
}
