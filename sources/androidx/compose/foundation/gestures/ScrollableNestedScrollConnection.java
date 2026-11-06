package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes.dex */
final class ScrollableNestedScrollConnection implements NestedScrollConnection {
    private boolean enabled;
    private final ScrollingLogic scrollingLogic;

    public ScrollableNestedScrollConnection(ScrollingLogic scrollingLogic, boolean z) {
        this.scrollingLogic = scrollingLogic;
        this.enabled = z;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long mo238onPostScrollDzOQY0M(long j, long j2, int i) {
        if (this.enabled) {
            return this.scrollingLogic.m251performRawScrollMKHz9U(j2);
        }
        return Offset.Companion.m1235getZeroF1C5BW0();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public Object mo237onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        ScrollableNestedScrollConnection$onPostFling$1 scrollableNestedScrollConnection$onPostFling$1;
        long jM2656getZero9UxMQ8M;
        if (continuation instanceof ScrollableNestedScrollConnection$onPostFling$1) {
            scrollableNestedScrollConnection$onPostFling$1 = (ScrollableNestedScrollConnection$onPostFling$1) continuation;
            int i = scrollableNestedScrollConnection$onPostFling$1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                scrollableNestedScrollConnection$onPostFling$1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                scrollableNestedScrollConnection$onPostFling$1 = new ScrollableNestedScrollConnection$onPostFling$1(this, continuation);
            }
        } else {
            scrollableNestedScrollConnection$onPostFling$1 = new ScrollableNestedScrollConnection$onPostFling$1(this, continuation);
        }
        Object objM249doFlingAnimationQWom1Mo = scrollableNestedScrollConnection$onPostFling$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = scrollableNestedScrollConnection$onPostFling$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objM249doFlingAnimationQWom1Mo);
            if (this.enabled) {
                ScrollingLogic scrollingLogic = this.scrollingLogic;
                scrollableNestedScrollConnection$onPostFling$1.J$0 = j2;
                scrollableNestedScrollConnection$onPostFling$1.label = 1;
                objM249doFlingAnimationQWom1Mo = scrollingLogic.m249doFlingAnimationQWom1Mo(j2, scrollableNestedScrollConnection$onPostFling$1);
                if (objM249doFlingAnimationQWom1Mo == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                jM2656getZero9UxMQ8M = Velocity.Companion.m2656getZero9UxMQ8M();
            }
            return Velocity.m2642boximpl(jM2656getZero9UxMQ8M);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        j2 = scrollableNestedScrollConnection$onPostFling$1.J$0;
        ResultKt.throwOnFailure(objM249doFlingAnimationQWom1Mo);
        jM2656getZero9UxMQ8M = Velocity.m2651minusAH228Gc(j2, ((Velocity) objM249doFlingAnimationQWom1Mo).m2655unboximpl());
        return Velocity.m2642boximpl(jM2656getZero9UxMQ8M);
    }
}
