package com.swmansion.enriched.markdown.spans;

import android.graphics.Paint;

/* JADX INFO: loaded from: classes4.dex */
public final class LineHeightSpan implements android.text.style.LineHeightSpan {
    private final int lineHeight;

    public LineHeightSpan(float f) {
        this.lineHeight = (int) Math.ceil(f);
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt == null) {
            return;
        }
        int i5 = this.lineHeight;
        int i6 = fontMetricsInt.ascent;
        double d = (i5 - ((-i6) + fontMetricsInt.descent)) / 2.0f;
        fontMetricsInt.ascent = i6 - ((int) Math.ceil(d));
        fontMetricsInt.descent += (int) Math.floor(d);
    }
}
