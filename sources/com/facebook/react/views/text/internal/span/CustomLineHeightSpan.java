package com.facebook.react.views.text.internal.span;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CustomLineHeightSpan implements LineHeightSpan, ReactSpan {
    private final int lineHeight;

    public CustomLineHeightSpan(float f) {
        this.lineHeight = (int) Math.ceil(f);
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence text, int i, int i2, int i3, int i4, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fm, "fm");
        int i5 = this.lineHeight;
        int i6 = fm.ascent;
        double d = (i5 - ((-i6) + fm.descent)) / 2.0f;
        fm.ascent = i6 - ((int) Math.ceil(d));
        fm.descent += (int) Math.floor(d);
        if (i == 0) {
            fm.top = fm.ascent;
        }
        if (i2 == text.length()) {
            fm.bottom = fm.descent;
        }
    }
}
