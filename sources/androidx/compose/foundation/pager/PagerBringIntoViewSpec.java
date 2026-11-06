package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
final class PagerBringIntoViewSpec implements BringIntoViewSpec {
    private final BringIntoViewSpec defaultBringIntoViewSpec;
    private final PagerState pagerState;
    private final AnimationSpec scrollAnimationSpec;

    public PagerBringIntoViewSpec(PagerState pagerState, BringIntoViewSpec bringIntoViewSpec) {
        this.pagerState = pagerState;
        this.defaultBringIntoViewSpec = bringIntoViewSpec;
        this.scrollAnimationSpec = bringIntoViewSpec.getScrollAnimationSpec();
    }

    @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
    public AnimationSpec getScrollAnimationSpec() {
        return this.scrollAnimationSpec;
    }

    @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
    public float calculateScrollDistance(float f, float f2, float f3) {
        float fCalculateScrollDistance = this.defaultBringIntoViewSpec.calculateScrollDistance(f, f2, f3);
        if (fCalculateScrollDistance != 0.0f) {
            return overrideProposedOffsetMove(fCalculateScrollDistance);
        }
        if (this.pagerState.getFirstVisiblePageOffset$foundation_release() == 0) {
            return 0.0f;
        }
        float firstVisiblePageOffset$foundation_release = this.pagerState.getFirstVisiblePageOffset$foundation_release() * (-1.0f);
        if (this.pagerState.getLastScrolledForward()) {
            firstVisiblePageOffset$foundation_release += this.pagerState.getPageSizeWithSpacing$foundation_release();
        }
        return RangesKt.coerceIn(firstVisiblePageOffset$foundation_release, -f3, f3);
    }

    private final float overrideProposedOffsetMove(float f) {
        float firstVisiblePageOffset$foundation_release = this.pagerState.getFirstVisiblePageOffset$foundation_release() * (-1);
        while (f > 0.0f && firstVisiblePageOffset$foundation_release < f) {
            firstVisiblePageOffset$foundation_release += this.pagerState.getPageSizeWithSpacing$foundation_release();
        }
        while (f < 0.0f && firstVisiblePageOffset$foundation_release > f) {
            firstVisiblePageOffset$foundation_release -= this.pagerState.getPageSizeWithSpacing$foundation_release();
        }
        return firstVisiblePageOffset$foundation_release;
    }
}
