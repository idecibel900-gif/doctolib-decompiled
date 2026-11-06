package com.swmansion.enriched.markdown.input.spans;

import android.graphics.Paint;
import android.text.Spanned;
import android.text.style.LineHeightSpan;
import com.swmansion.enriched.markdown.input.formatting.MarkdownSpan;

/* JADX INFO: loaded from: classes4.dex */
public final class InputListItemSpacingSpan implements LineHeightSpan, MarkdownSpan {
    private final int spacingPx;

    public InputListItemSpacingSpan(int i) {
        this.spacingPx = i;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        int spanStart;
        if (fontMetricsInt == null || this.spacingPx <= 0 || !(charSequence instanceof Spanned) || (spanStart = ((Spanned) charSequence).getSpanStart(this)) < i || spanStart >= i2) {
            return;
        }
        int i5 = fontMetricsInt.ascent;
        int i6 = this.spacingPx;
        fontMetricsInt.ascent = i5 - i6;
        fontMetricsInt.top -= i6;
    }
}
