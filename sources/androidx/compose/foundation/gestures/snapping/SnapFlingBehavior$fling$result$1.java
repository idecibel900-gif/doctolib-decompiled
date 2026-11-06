package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes.dex */
final class SnapFlingBehavior$fling$result$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ float $initialVelocity;
    final /* synthetic */ Function1 $onRemainingScrollOffsetUpdate;
    final /* synthetic */ ScrollScope $this_fling;
    Object L$0;
    int label;
    final /* synthetic */ SnapFlingBehavior this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnapFlingBehavior$fling$result$1(SnapFlingBehavior snapFlingBehavior, float f, Function1 function1, ScrollScope scrollScope, Continuation continuation) {
        super(2, continuation);
        this.this$0 = snapFlingBehavior;
        this.$initialVelocity = f;
        this.$onRemainingScrollOffsetUpdate = function1;
        this.$this_fling = scrollScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SnapFlingBehavior$fling$result$1(this.this$0, this.$initialVelocity, this.$onRemainingScrollOffsetUpdate, this.$this_fling, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SnapFlingBehavior$fling$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final Ref$FloatRef ref$FloatRef;
        Object objTryApproach;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            float fCalculateApproachOffset = this.this$0.snapLayoutInfoProvider.calculateApproachOffset(this.$initialVelocity, DecayAnimationSpecKt.calculateTargetValue(this.this$0.decayAnimationSpec, 0.0f, this.$initialVelocity));
            if (Float.isNaN(fCalculateApproachOffset)) {
                throw new IllegalStateException("calculateApproachOffset returned NaN. Please use a valid value.");
            }
            ref$FloatRef = new Ref$FloatRef();
            float fAbs = Math.abs(fCalculateApproachOffset) * Math.signum(this.$initialVelocity);
            ref$FloatRef.element = fAbs;
            this.$onRemainingScrollOffsetUpdate.invoke(Boxing.boxFloat(fAbs));
            SnapFlingBehavior snapFlingBehavior = this.this$0;
            ScrollScope scrollScope = this.$this_fling;
            float f = ref$FloatRef.element;
            float f2 = this.$initialVelocity;
            final Function1 function1 = this.$onRemainingScrollOffsetUpdate;
            Function1 function2 = new Function1() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1$animationState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke(((Number) obj2).floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f3) {
                    Ref$FloatRef ref$FloatRef2 = ref$FloatRef;
                    float f4 = ref$FloatRef2.element - f3;
                    ref$FloatRef2.element = f4;
                    function1.invoke(Float.valueOf(f4));
                }
            };
            this.L$0 = ref$FloatRef;
            this.label = 1;
            objTryApproach = snapFlingBehavior.tryApproach(scrollScope, f, f2, function2, this);
            if (objTryApproach != coroutine_suspended) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        Ref$FloatRef ref$FloatRef2 = (Ref$FloatRef) this.L$0;
        ResultKt.throwOnFailure(obj);
        ref$FloatRef = ref$FloatRef2;
        objTryApproach = obj;
        AnimationState animationState = (AnimationState) objTryApproach;
        float fCalculateSnapOffset = this.this$0.snapLayoutInfoProvider.calculateSnapOffset(((Number) animationState.getVelocity()).floatValue());
        if (Float.isNaN(fCalculateSnapOffset)) {
            throw new IllegalStateException("calculateSnapOffset returned NaN. Please use a valid value.");
        }
        ref$FloatRef.element = fCalculateSnapOffset;
        ScrollScope scrollScope2 = this.$this_fling;
        AnimationState animationStateCopy$default = AnimationStateKt.copy$default(animationState, 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
        AnimationSpec animationSpec = this.this$0.snapAnimationSpec;
        final Function1 function3 = this.$onRemainingScrollOffsetUpdate;
        Function1 function4 = new Function1() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke(((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f3) {
                Ref$FloatRef ref$FloatRef3 = ref$FloatRef;
                float f4 = ref$FloatRef3.element - f3;
                ref$FloatRef3.element = f4;
                function3.invoke(Float.valueOf(f4));
            }
        };
        this.L$0 = null;
        this.label = 2;
        Object objAnimateWithTarget = SnapFlingBehaviorKt.animateWithTarget(scrollScope2, fCalculateSnapOffset, fCalculateSnapOffset, animationStateCopy$default, animationSpec, function4, this);
        return objAnimateWithTarget == coroutine_suspended ? coroutine_suspended : objAnimateWithTarget;
    }
}
