package androidx.compose.foundation.pager;

import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class PagerScrollPositionKt {
    public static final long currentAbsoluteScrollOffset(PagerState pagerState) {
        return (((long) pagerState.getCurrentPage()) * ((long) pagerState.getPageSizeWithSpacing$foundation_release())) + MathKt.roundToLong(pagerState.getCurrentPageOffsetFraction() * pagerState.getPageSizeWithSpacing$foundation_release());
    }
}
