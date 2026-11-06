package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.pager.PageInfo;
import androidx.compose.foundation.pager.PagerLayoutInfo;
import androidx.compose.foundation.pager.PagerLayoutInfoKt;
import androidx.compose.foundation.pager.PagerSnapDistance;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class PagerSnapLayoutInfoProviderKt {
    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(final PagerState pagerState, final PagerSnapDistance pagerSnapDistance, final Function3 function3) {
        return new SnapLayoutInfoProvider() { // from class: androidx.compose.foundation.gestures.snapping.PagerSnapLayoutInfoProviderKt.SnapLayoutInfoProvider.1
            public final boolean isValidDistance(float f) {
                return (f == Float.POSITIVE_INFINITY || f == Float.NEGATIVE_INFINITY) ? false : true;
            }

            public final PagerLayoutInfo getLayoutInfo() {
                return pagerState.getLayoutInfo();
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateSnapOffset(float f) {
                Pair pairSearchForSnappingBounds = searchForSnappingBounds(pagerState.getLayoutInfo().getSnapPosition());
                float fFloatValue = ((Number) pairSearchForSnappingBounds.getFirst()).floatValue();
                float fFloatValue2 = ((Number) pairSearchForSnappingBounds.getSecond()).floatValue();
                float fFloatValue3 = ((Number) function3.invoke(Float.valueOf(f), Float.valueOf(fFloatValue), Float.valueOf(fFloatValue2))).floatValue();
                if (fFloatValue3 != fFloatValue && fFloatValue3 != fFloatValue2 && fFloatValue3 != 0.0f) {
                    throw new IllegalStateException(("Final Snapping Offset Should Be one of " + fFloatValue + ", " + fFloatValue2 + " or 0.0").toString());
                }
                if (isValidDistance(fFloatValue3)) {
                    return fFloatValue3;
                }
                return 0.0f;
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateApproachOffset(float f, float f2) {
                int firstVisiblePage$foundation_release;
                int pageSize$foundation_release = pagerState.getPageSize$foundation_release() + pagerState.getPageSpacing$foundation_release();
                if (pageSize$foundation_release == 0) {
                    return 0.0f;
                }
                if (f < 0.0f) {
                    firstVisiblePage$foundation_release = pagerState.getFirstVisiblePage$foundation_release() + 1;
                } else {
                    firstVisiblePage$foundation_release = pagerState.getFirstVisiblePage$foundation_release();
                }
                int i = firstVisiblePage$foundation_release;
                int iCoerceAtLeast = RangesKt.coerceAtLeast(Math.abs((RangesKt.coerceIn(pagerSnapDistance.calculateTargetPage(i, RangesKt.coerceIn(((int) (f2 / pageSize$foundation_release)) + i, 0, pagerState.getPageCount()), f, pagerState.getPageSize$foundation_release(), pagerState.getPageSpacing$foundation_release()), 0, pagerState.getPageCount()) - i) * pageSize$foundation_release) - pageSize$foundation_release, 0);
                return iCoerceAtLeast == 0 ? iCoerceAtLeast : iCoerceAtLeast * Math.signum(f);
            }

            private final Pair searchForSnappingBounds(SnapPosition snapPosition) {
                float f;
                List visiblePagesInfo = getLayoutInfo().getVisiblePagesInfo();
                PagerState pagerState2 = pagerState;
                int size = visiblePagesInfo.size();
                float f2 = Float.NEGATIVE_INFINITY;
                float f3 = Float.POSITIVE_INFINITY;
                int i = 0;
                while (true) {
                    f = 0.0f;
                    if (i >= size) {
                        break;
                    }
                    PageInfo pageInfo = (PageInfo) visiblePagesInfo.get(i);
                    float fCalculateDistanceToDesiredSnapPosition = SnapPositionKt.calculateDistanceToDesiredSnapPosition(PagerLayoutInfoKt.getMainAxisViewportSize(getLayoutInfo()), getLayoutInfo().getBeforeContentPadding(), getLayoutInfo().getAfterContentPadding(), getLayoutInfo().getPageSize(), pageInfo.getOffset(), pageInfo.getIndex(), snapPosition, pagerState2.getPageCount());
                    if (fCalculateDistanceToDesiredSnapPosition <= 0.0f && fCalculateDistanceToDesiredSnapPosition > f2) {
                        f2 = fCalculateDistanceToDesiredSnapPosition;
                    }
                    if (fCalculateDistanceToDesiredSnapPosition >= 0.0f && fCalculateDistanceToDesiredSnapPosition < f3) {
                        f3 = fCalculateDistanceToDesiredSnapPosition;
                    }
                    i++;
                }
                if (f2 == Float.NEGATIVE_INFINITY) {
                    f2 = f3;
                }
                if (f3 == Float.POSITIVE_INFINITY) {
                    f3 = f2;
                }
                boolean z = PagerSnapLayoutInfoProviderKt.dragGestureDelta(pagerState) == 0.0f;
                if (!pagerState.getCanScrollForward()) {
                    if (z || !PagerSnapLayoutInfoProviderKt.isScrollingForward(pagerState)) {
                        f3 = 0.0f;
                    } else {
                        f2 = 0.0f;
                        f3 = 0.0f;
                    }
                }
                if (pagerState.getCanScrollBackward()) {
                    f = f2;
                } else if (!z && !PagerSnapLayoutInfoProviderKt.isScrollingForward(pagerState)) {
                    f3 = 0.0f;
                }
                return TuplesKt.to(Float.valueOf(f), Float.valueOf(f3));
            }
        };
    }

    private static final boolean isLtrDragging(PagerState pagerState) {
        return dragGestureDelta(pagerState) > 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isScrollingForward(PagerState pagerState) {
        boolean reverseLayout = pagerState.getLayoutInfo().getReverseLayout();
        if (isLtrDragging(pagerState) && reverseLayout) {
            return true;
        }
        return (isLtrDragging(pagerState) || reverseLayout) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float dragGestureDelta(PagerState pagerState) {
        if (pagerState.getLayoutInfo().getOrientation() == Orientation.Horizontal) {
            return Offset.m1223getXimpl(pagerState.m445getUpDownDifferenceF1C5BW0$foundation_release());
        }
        return Offset.m1224getYimpl(pagerState.m445getUpDownDifferenceF1C5BW0$foundation_release());
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008e A[RETURN] */
    public static final float calculateFinalSnappingBound(PagerState pagerState, LayoutDirection layoutDirection, float f, float f2, float f3, float f4) {
        boolean zIsScrollingForward;
        if (pagerState.getLayoutInfo().getOrientation() == Orientation.Vertical || layoutDirection == LayoutDirection.Ltr) {
            zIsScrollingForward = isScrollingForward(pagerState);
        } else {
            zIsScrollingForward = !isScrollingForward(pagerState);
        }
        int pageSize = pagerState.getLayoutInfo().getPageSize();
        float fDragGestureDelta = pageSize == 0 ? 0.0f : dragGestureDelta(pagerState) / pageSize;
        float f5 = fDragGestureDelta - ((int) fDragGestureDelta);
        int iCalculateFinalSnappingItem = LazyListSnapLayoutInfoProviderKt.calculateFinalSnappingItem(pagerState.getDensity$foundation_release(), f2);
        FinalSnappingItem.Companion companion = FinalSnappingItem.Companion;
        if (!FinalSnappingItem.m264equalsimpl0(iCalculateFinalSnappingItem, companion.m265getClosestItembbeMdSM())) {
            if (!FinalSnappingItem.m264equalsimpl0(iCalculateFinalSnappingItem, companion.m266getNextItembbeMdSM())) {
                if (FinalSnappingItem.m264equalsimpl0(iCalculateFinalSnappingItem, companion.m267getPreviousItembbeMdSM())) {
                    return f3;
                }
                return 0.0f;
            }
            return f4;
        }
        if (Math.abs(f5) <= f ? Math.abs(fDragGestureDelta) < Math.abs(pagerState.getPositionThresholdFraction$foundation_release()) ? Math.abs(f3) >= Math.abs(f4) : !zIsScrollingForward : zIsScrollingForward) {
            return f4;
        }
        return f3;
    }
}
