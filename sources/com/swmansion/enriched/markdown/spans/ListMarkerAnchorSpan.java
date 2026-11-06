package com.swmansion.enriched.markdown.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ListMarkerAnchorSpan implements LeadingMarginSpan {
    private final BaseListSpan marker;

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return 0;
    }

    public ListMarkerAnchorSpan(BaseListSpan marker) {
        Intrinsics.checkNotNullParameter(marker, "marker");
        this.marker = marker;
    }

    public final BaseListSpan getMarker$react_native_enriched_markdown_release() {
        return this.marker;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas c, Paint p, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int i8;
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(p, "p");
        if (z) {
            if (charSequence instanceof Spanned) {
                i8 = i6;
                if (((Spanned) charSequence).getSpanStart(this) != i8) {
                    return;
                }
            } else {
                i8 = i6;
            }
            int width = 0;
            if (i2 <= 0 && layout != null) {
                width = layout.getWidth();
            }
            this.marker.drawMarkerAt(c, p, width, i2, i3, i4, i5, layout, i8);
        }
    }
}
