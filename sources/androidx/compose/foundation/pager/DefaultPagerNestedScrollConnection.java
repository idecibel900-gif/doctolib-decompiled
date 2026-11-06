package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
final class DefaultPagerNestedScrollConnection implements NestedScrollConnection {
    private final Orientation orientation;
    private final PagerState state;

    public DefaultPagerNestedScrollConnection(PagerState pagerState, Orientation orientation) {
        this.state = pagerState;
        this.orientation = orientation;
    }

    /* JADX INFO: renamed from: consumeOnOrientation-QWom1Mo, reason: not valid java name */
    public final long m432consumeOnOrientationQWom1Mo(long j, Orientation orientation) {
        if (orientation == Orientation.Vertical) {
            return Velocity.m2645copyOhffZ5M$default(j, 0.0f, 0.0f, 2, null);
        }
        return Velocity.m2645copyOhffZ5M$default(j, 0.0f, 0.0f, 1, null);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public long mo433onPreScrollOzD1aCk(long j, int i) {
        if (NestedScrollSource.m1737equalsimpl0(i, NestedScrollSource.Companion.m1739getUserInputWNlRxjI()) && Math.abs(this.state.getCurrentPageOffsetFraction()) > 1.0E-6d) {
            float currentPageOffsetFraction = this.state.getCurrentPageOffsetFraction() * this.state.getPageSize$foundation_release();
            float pageSize = ((this.state.getLayoutInfo().getPageSize() + this.state.getLayoutInfo().getPageSpacing()) * (-Math.signum(this.state.getCurrentPageOffsetFraction()))) + currentPageOffsetFraction;
            if (this.state.getCurrentPageOffsetFraction() > 0.0f) {
                pageSize = currentPageOffsetFraction;
                currentPageOffsetFraction = pageSize;
            }
            Orientation orientation = this.orientation;
            Orientation orientation2 = Orientation.Horizontal;
            float fM1224getYimpl = -this.state.dispatchRawDelta(-RangesKt.coerceIn(orientation == orientation2 ? Offset.m1223getXimpl(j) : Offset.m1224getYimpl(j), currentPageOffsetFraction, pageSize));
            float fM1223getXimpl = this.orientation == orientation2 ? fM1224getYimpl : Offset.m1223getXimpl(j);
            if (this.orientation != Orientation.Vertical) {
                fM1224getYimpl = Offset.m1224getYimpl(j);
            }
            return Offset.m1216copydBAh8RU(j, fM1223getXimpl, fM1224getYimpl);
        }
        return Offset.Companion.m1235getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo238onPostScrollDzOQY0M(long j, long j2, int i) {
        if (NestedScrollSource.m1737equalsimpl0(i, NestedScrollSource.Companion.m1738getSideEffectWNlRxjI()) && m431mainAxisk4lQ0M(j2) != 0.0f) {
            throw new CancellationException("Scroll cancelled");
        }
        return Offset.Companion.m1235getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo237onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        return Velocity.m2642boximpl(m432consumeOnOrientationQWom1Mo(j2, this.orientation));
    }

    /* JADX INFO: renamed from: mainAxis-k-4lQ0M, reason: not valid java name */
    private final float m431mainAxisk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m1223getXimpl(j) : Offset.m1224getYimpl(j);
    }
}
