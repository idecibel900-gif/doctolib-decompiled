package com.facebook.react.views.text.internal.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TextInlineViewPlaceholderSpan extends ReplacementSpan implements ReactSpan {
    private final int height;
    private final int reactTag;
    private final int width;

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getReactTag() {
        return this.reactTag;
    }

    public final int getWidth() {
        return this.width;
    }

    public TextInlineViewPlaceholderSpan(int i, int i2, int i3) {
        this.reactTag = i;
        this.width = i2;
        this.height = i3;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (fontMetricsInt != null) {
            int i3 = -this.height;
            fontMetricsInt.ascent = i3;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i3;
            fontMetricsInt.bottom = 0;
        }
        return this.width;
    }
}
