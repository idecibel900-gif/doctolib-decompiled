package com.swmansion.enriched.markdown.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ThematicBreakSpan extends ReplacementSpan {
    private final int lineColor;
    private final float lineHeight;
    private final float marginBottom;
    private final float marginTop;

    public ThematicBreakSpan(int i, float f, float f2, float f3) {
        this.lineColor = i;
        this.lineHeight = f;
        this.marginTop = f2;
        this.marginBottom = f3;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        int i3 = (int) (this.marginTop + this.lineHeight + this.marginBottom);
        if (fontMetricsInt != null) {
            int i4 = -i3;
            fontMetricsInt.ascent = i4;
            fontMetricsInt.top = i4;
            fontMetricsInt.descent = 0;
            fontMetricsInt.bottom = 0;
        }
        return 0;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        int i6 = this.lineColor;
        float f2 = this.lineHeight;
        int color = paint.getColor();
        float strokeWidth = paint.getStrokeWidth();
        Paint.Style style = paint.getStyle();
        paint.setColor(i6);
        paint.setStrokeWidth(f2);
        paint.setStyle(Paint.Style.STROKE);
        float f3 = i3 + this.marginTop + (this.lineHeight / 2.0f);
        canvas.drawLine(0.0f, f3, canvas.getWidth(), f3, paint);
        paint.setColor(color);
        paint.setStrokeWidth(strokeWidth);
        paint.setStyle(style);
    }
}
