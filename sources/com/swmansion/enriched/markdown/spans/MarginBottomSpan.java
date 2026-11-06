package com.swmansion.enriched.markdown.spans;

import android.graphics.Paint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class MarginBottomSpan implements android.text.style.LineHeightSpan {
    private final float marginBottom;

    public MarginBottomSpan(float f) {
        this.marginBottom = f;
    }

    public final float getMarginBottom() {
        return this.marginBottom;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence text, int i, int i2, int i3, int i4, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fm, "fm");
        if (i2 <= i || text.charAt(i2 - 1) != '\n') {
            return;
        }
        int i5 = (int) this.marginBottom;
        if (i2 - i == 1 && text.charAt(i) == '\n') {
            if (hasContentAfter(text, i2)) {
                fm.top = 0;
                fm.ascent = 0;
                fm.descent = i5;
                fm.bottom = i5;
                return;
            }
            fm.top = 0;
            fm.ascent = 0;
            fm.descent = 0;
            fm.bottom = 0;
            return;
        }
        if (hasContentAfter(text, i2)) {
            fm.descent += i5;
            fm.bottom += i5;
        }
    }

    private final boolean hasContentAfter(CharSequence charSequence, int i) {
        if (i >= charSequence.length()) {
            return false;
        }
        if (charSequence.charAt(i) != '\n') {
            return true;
        }
        int i2 = i + 1;
        return i2 < charSequence.length() && charSequence.charAt(i2) != '\n';
    }
}
