package com.swmansion.enriched.markdown.input.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.swmansion.enriched.markdown.input.formatting.MarkdownSpan;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class InputOrderedListMarkerSpan implements LeadingMarginSpan, MarkdownSpan {
    public static final Companion Companion = new Companion(null);
    private final int depth;
    private final float indentPerDepth;
    private final float markerGap;
    private final float markerWidth;
    private final int ordinal;

    public InputOrderedListMarkerSpan(int i, int i2, float f) {
        this.depth = i;
        this.ordinal = i2;
        float f2 = 18.0f * f;
        this.indentPerDepth = f2;
        this.markerWidth = f2;
        this.markerGap = f * 4.0f;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return (int) ((this.depth * this.indentPerDepth) + this.markerWidth);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        StringBuilder sb;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (z) {
            if (!(charSequence instanceof Spanned) || ((Spanned) charSequence).getSpanStart(this) == i6) {
                int i8 = this.ordinal;
                if (i2 < 0) {
                    sb = new StringBuilder();
                    sb.append(".");
                    sb.append(i8);
                } else {
                    sb = new StringBuilder();
                    sb.append(i8);
                    sb.append(".");
                }
                String string = sb.toString();
                Paint.Align textAlign = paint.getTextAlign();
                paint.setTextAlign(i2 < 0 ? Paint.Align.LEFT : Paint.Align.RIGHT);
                canvas.drawText(string, i + ((((this.depth * this.indentPerDepth) + this.markerWidth) - this.markerGap) * i2), i4, paint);
                paint.setTextAlign(textAlign);
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
