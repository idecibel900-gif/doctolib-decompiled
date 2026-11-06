package com.swmansion.enriched.markdown.input.formatting;

import com.swmansion.enriched.markdown.input.model.MutableRangeBounds;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RangeEditAdjustmentKt {
    public static final int sortedInsertionIndex(List ranges, int i) {
        Intrinsics.checkNotNullParameter(ranges, "ranges");
        Iterator it = ranges.iterator();
        int i2 = 0;
        while (it.hasNext() && ((MutableRangeBounds) it.next()).getStart() <= i) {
            i2++;
        }
        return i2;
    }
}
