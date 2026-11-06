package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes.dex */
public final class ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ ExitUntilCollapsedScrollBehavior this$0;

    ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1(ExitUntilCollapsedScrollBehavior exitUntilCollapsedScrollBehavior) {
        this.this$0 = exitUntilCollapsedScrollBehavior;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo433onPreScrollOzD1aCk(long j, int i) {
        if (!((Boolean) this.this$0.getCanScroll().invoke()).booleanValue() || Offset.m1224getYimpl(j) > 0.0f) {
            return Offset.Companion.m1235getZeroF1C5BW0();
        }
        float heightOffset = this.this$0.getState().getHeightOffset();
        this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m1224getYimpl(j));
        if (heightOffset != this.this$0.getState().getHeightOffset()) {
            return Offset.m1217copydBAh8RU$default(j, 0.0f, 0.0f, 2, null);
        }
        return Offset.Companion.m1235getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo238onPostScrollDzOQY0M(long j, long j2, int i) {
        if (!((Boolean) this.this$0.getCanScroll().invoke()).booleanValue()) {
            return Offset.Companion.m1235getZeroF1C5BW0();
        }
        TopAppBarState state = this.this$0.getState();
        state.setContentOffset(state.getContentOffset() + Offset.m1224getYimpl(j));
        if (Offset.m1224getYimpl(j2) < 0.0f || Offset.m1224getYimpl(j) < 0.0f) {
            float heightOffset = this.this$0.getState().getHeightOffset();
            this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m1224getYimpl(j));
            return OffsetKt.Offset(0.0f, this.this$0.getState().getHeightOffset() - heightOffset);
        }
        if (Offset.m1224getYimpl(j) == 0.0f && Offset.m1224getYimpl(j2) > 0.0f) {
            this.this$0.getState().setContentOffset(0.0f);
        }
        if (Offset.m1224getYimpl(j2) > 0.0f) {
            float heightOffset2 = this.this$0.getState().getHeightOffset();
            this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m1224getYimpl(j2));
            return OffsetKt.Offset(0.0f, this.this$0.getState().getHeightOffset() - heightOffset2);
        }
        return Offset.Companion.m1235getZeroF1C5BW0();
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo237onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1 exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1;
        ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1 exitUntilCollapsedScrollBehavior$nestedScrollConnection$1;
        long j3;
        long j4;
        if (continuation instanceof ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1) {
            exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1 = (ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1) continuation;
            int i = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1 = new ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1(this, continuation);
            }
        } else {
            exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1 = new ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1(this, continuation);
        }
        ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1 exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$2 = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1;
        Object objMo237onPostFlingRZ2iAVY = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$2.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo237onPostFlingRZ2iAVY);
            exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$2.L$0 = this;
            exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$2.J$0 = j2;
            exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$2.label = 1;
            objMo237onPostFlingRZ2iAVY = super.mo237onPostFlingRZ2iAVY(j, j2, exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$2);
            if (objMo237onPostFlingRZ2iAVY != coroutine_suspended) {
                exitUntilCollapsedScrollBehavior$nestedScrollConnection$1 = this;
                j3 = j2;
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            j3 = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$2.J$0;
            exitUntilCollapsedScrollBehavior$nestedScrollConnection$1 = (ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1) exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$2.L$0;
            ResultKt.throwOnFailure(objMo237onPostFlingRZ2iAVY);
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j4 = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$2.J$0;
            ResultKt.throwOnFailure(objMo237onPostFlingRZ2iAVY);
        }
        return Velocity.m2642boximpl(Velocity.m2652plusAH228Gc(j4, ((Velocity) objMo237onPostFlingRZ2iAVY).m2655unboximpl()));
        long jM2655unboximpl = ((Velocity) objMo237onPostFlingRZ2iAVY).m2655unboximpl();
        TopAppBarState state = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1.this$0.getState();
        float fM2649getYimpl = Velocity.m2649getYimpl(j3);
        DecayAnimationSpec flingAnimationSpec = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1.this$0.getFlingAnimationSpec();
        AnimationSpec snapAnimationSpec = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1.this$0.getSnapAnimationSpec();
        exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$2.L$0 = null;
        exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$2.J$0 = jM2655unboximpl;
        exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$2.label = 2;
        objMo237onPostFlingRZ2iAVY = AppBarKt.settleAppBar(state, fM2649getYimpl, flingAnimationSpec, snapAnimationSpec, exitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$2);
        if (objMo237onPostFlingRZ2iAVY != coroutine_suspended) {
            j4 = jM2655unboximpl;
            return Velocity.m2642boximpl(Velocity.m2652plusAH228Gc(j4, ((Velocity) objMo237onPostFlingRZ2iAVY).m2655unboximpl()));
        }
        return coroutine_suspended;
    }
}
