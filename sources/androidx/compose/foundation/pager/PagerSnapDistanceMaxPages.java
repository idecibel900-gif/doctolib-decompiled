package androidx.compose.foundation.pager;

import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public final class PagerSnapDistanceMaxPages implements PagerSnapDistance {
    private final int pagesLimit;

    public PagerSnapDistanceMaxPages(int i) {
        this.pagesLimit = i;
    }

    @Override // androidx.compose.foundation.pager.PagerSnapDistance
    public int calculateTargetPage(int i, int i2, float f, int i3, int i4) {
        long j = i;
        return RangesKt.coerceIn(i2, (int) RangesKt.coerceAtLeast(j - ((long) this.pagesLimit), 0L), (int) RangesKt.coerceAtMost(j + ((long) this.pagesLimit), 2147483647L));
    }

    public boolean equals(Object obj) {
        return (obj instanceof PagerSnapDistanceMaxPages) && this.pagesLimit == ((PagerSnapDistanceMaxPages) obj).pagesLimit;
    }

    public int hashCode() {
        return Integer.hashCode(this.pagesLimit);
    }
}
