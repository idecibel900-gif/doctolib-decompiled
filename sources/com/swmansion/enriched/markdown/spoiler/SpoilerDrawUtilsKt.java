package com.swmansion.enriched.markdown.spoiler;

import android.graphics.Color;
import android.graphics.Paint;
import android.text.Layout;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SpoilerDrawUtilsKt {
    public static final SegmentRect computeSegmentRect(Layout layout, int i, int i2, int i3, Paint.FontMetrics fontMetrics, float f, float f2) {
        float primaryHorizontal;
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(fontMetrics, "fontMetrics");
        float primaryHorizontal2 = layout.getPrimaryHorizontal(i2);
        if (i3 >= layout.getLineEnd(i)) {
            primaryHorizontal = layout.getLineRight(i);
        } else {
            primaryHorizontal = layout.getPrimaryHorizontal(i3);
        }
        float lineBaseline = layout.getLineBaseline(i);
        float fMin = Math.min(primaryHorizontal2, primaryHorizontal) + f;
        float fMax = Math.max(primaryHorizontal2, primaryHorizontal) + f;
        float f3 = fontMetrics.ascent + lineBaseline + f2;
        float f4 = fMax - fMin;
        float f5 = ((lineBaseline + fontMetrics.descent) + f2) - f3;
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return null;
        }
        return new SegmentRect(fMin, f3, f4, f5);
    }

    public static final int colorWithAlpha(int i, float f) {
        return Color.argb(RangesKt.coerceIn((int) (Color.alpha(i) * f), 0, 255), Color.red(i), Color.green(i), Color.blue(i));
    }
}
