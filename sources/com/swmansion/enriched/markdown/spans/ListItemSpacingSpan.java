package com.swmansion.enriched.markdown.spans;

import android.graphics.Paint;
import android.text.Spanned;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ListItemSpacingSpan implements android.text.style.LineHeightSpan {
    private final float spacing;

    public ListItemSpacingSpan(float f) {
        this.spacing = f;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence text, int i, int i2, int i3, int i4, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fm, "fm");
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        if (spanned == null || i2 != spanned.getSpanEnd(this)) {
            return;
        }
        int i5 = (int) this.spacing;
        fm.descent += i5;
        fm.bottom += i5;
    }
}
