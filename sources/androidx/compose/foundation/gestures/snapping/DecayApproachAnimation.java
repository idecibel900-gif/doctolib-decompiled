package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
final class DecayApproachAnimation implements ApproachAnimation {
    private final DecayAnimationSpec decayAnimationSpec;

    public DecayApproachAnimation(DecayAnimationSpec decayAnimationSpec) {
        this.decayAnimationSpec = decayAnimationSpec;
    }

    @Override // androidx.compose.foundation.gestures.snapping.ApproachAnimation
    public /* bridge */ /* synthetic */ Object approachAnimation(ScrollScope scrollScope, Object obj, Object obj2, Function1 function1, Continuation continuation) {
        return approachAnimation(scrollScope, ((Number) obj).floatValue(), ((Number) obj2).floatValue(), function1, continuation);
    }

    public Object approachAnimation(ScrollScope scrollScope, float f, float f2, Function1 function1, Continuation continuation) {
        Object objAnimateDecay = SnapFlingBehaviorKt.animateDecay(scrollScope, f, AnimationStateKt.AnimationState$default(0.0f, f2, 0L, 0L, false, 28, null), this.decayAnimationSpec, function1, continuation);
        return objAnimateDecay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateDecay : (AnimationResult) objAnimateDecay;
    }
}
