package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
final class TargetApproachAnimation implements ApproachAnimation {
    private final AnimationSpec animationSpec;

    public TargetApproachAnimation(AnimationSpec animationSpec) {
        this.animationSpec = animationSpec;
    }

    @Override // androidx.compose.foundation.gestures.snapping.ApproachAnimation
    public /* bridge */ /* synthetic */ Object approachAnimation(ScrollScope scrollScope, Object obj, Object obj2, Function1 function1, Continuation continuation) {
        return approachAnimation(scrollScope, ((Number) obj).floatValue(), ((Number) obj2).floatValue(), function1, continuation);
    }

    public Object approachAnimation(ScrollScope scrollScope, float f, float f2, Function1 function1, Continuation continuation) {
        Object objAnimateWithTarget = SnapFlingBehaviorKt.animateWithTarget(scrollScope, Math.abs(f) * Math.signum(f2), f, AnimationStateKt.AnimationState$default(0.0f, f2, 0L, 0L, false, 28, null), this.animationSpec, function1, continuation);
        return objAnimateWithTarget == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateWithTarget : (AnimationResult) objAnimateWithTarget;
    }
}
