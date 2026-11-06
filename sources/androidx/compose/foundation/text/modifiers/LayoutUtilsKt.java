package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class LayoutUtilsKt {
    /* JADX INFO: renamed from: finalConstraints-tfFHcEY, reason: not valid java name */
    public static final long m606finalConstraintstfFHcEY(long j, boolean z, int i, float f) {
        return Constraints.Companion.m2538fitPrioritizingWidthZbe2FdA(0, m608finalMaxWidthtfFHcEY(j, z, i, f), 0, Constraints.m2529getMaxHeightimpl(j));
    }

    /* JADX INFO: renamed from: finalMaxWidth-tfFHcEY, reason: not valid java name */
    public static final int m608finalMaxWidthtfFHcEY(long j, boolean z, int i, float f) {
        int iM2530getMaxWidthimpl = ((z || TextOverflow.m2513equalsimpl0(i, TextOverflow.Companion.m2517getEllipsisgIe3tQ8())) && Constraints.m2526getHasBoundedWidthimpl(j)) ? Constraints.m2530getMaxWidthimpl(j) : Integer.MAX_VALUE;
        return Constraints.m2532getMinWidthimpl(j) == iM2530getMaxWidthimpl ? iM2530getMaxWidthimpl : RangesKt.coerceIn(TextDelegateKt.ceilToIntPx(f), Constraints.m2532getMinWidthimpl(j), iM2530getMaxWidthimpl);
    }

    /* JADX INFO: renamed from: finalMaxLines-xdlQI24, reason: not valid java name */
    public static final int m607finalMaxLinesxdlQI24(boolean z, int i, int i2) {
        if (z || !TextOverflow.m2513equalsimpl0(i, TextOverflow.Companion.m2517getEllipsisgIe3tQ8())) {
            return RangesKt.coerceAtLeast(i2, 1);
        }
        return 1;
    }
}
