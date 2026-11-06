package com.swmansion.enriched.markdown.input.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.swmansion.enriched.markdown.input.formatting.MarkdownSpan;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class InputBulletSpan implements LeadingMarginSpan, MarkdownSpan {
    public static final Companion Companion = new Companion(null);
    private final int depth;
    private final float indentPerDepth;
    private final float markerWidth;

    public InputBulletSpan(int i, float f) {
        this.depth = i;
        float f2 = f * 18.0f;
        this.indentPerDepth = f2;
        this.markerWidth = f2;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return (int) ((this.depth * this.indentPerDepth) + this.markerWidth);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (z) {
            if (!(charSequence instanceof Spanned) || ((Spanned) charSequence).getSpanStart(this) == i6) {
                float fCoerceAtLeast = RangesKt.coerceAtLeast(paint.getTextSize() * 0.3f, 4.0f);
                float f = fCoerceAtLeast / 2.0f;
                float f2 = i + (((this.depth * this.indentPerDepth) + (this.markerWidth * 0.5f)) * i2);
                Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                float f3 = i4 + ((fontMetrics.ascent + fontMetrics.descent) / 2.0f);
                Paint.Style style = paint.getStyle();
                float strokeWidth = paint.getStrokeWidth();
                int i8 = this.depth;
                if (i8 >= 2) {
                    i8 = 2;
                }
                if (i8 == 0) {
                    paint.setStyle(Paint.Style.FILL);
                    canvas.drawCircle(f2, f3, f, paint);
                } else if (i8 == 1) {
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(RangesKt.coerceAtLeast(fCoerceAtLeast * 0.15f, 1.0f));
                    canvas.drawCircle(f2, f3, f - (paint.getStrokeWidth() / 2.0f), paint);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    canvas.drawRect(f2 - f, f3 - f, f2 + f, f3 + f, paint);
                }
                paint.setStyle(style);
                paint.setStrokeWidth(strokeWidth);
            }
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
