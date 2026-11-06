package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.ui.unit.Dp;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class SnapFlingBehaviorKt {
    private static final float MinFlingVelocityDp = Dp.m2551constructorimpl(400);

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return SnapFlingBehaviorKt.animateDecay(null, 0.0f, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateWithTarget$1, reason: invalid class name and case insensitive filesystem */
    static final class C02021 extends ContinuationImpl {
        float F$0;
        float F$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02021(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return SnapFlingBehaviorKt.animateWithTarget(null, 0.0f, 0.0f, null, null, null, this);
        }
    }

    public static final TargetedFlingBehavior snapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, DecayAnimationSpec decayAnimationSpec, AnimationSpec animationSpec) {
        return new SnapFlingBehavior(snapLayoutInfoProvider, decayAnimationSpec, animationSpec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object approach(ScrollScope scrollScope, float f, float f2, ApproachAnimation approachAnimation, Function1 function1, Continuation continuation) {
        return approachAnimation.approachAnimation(scrollScope, Boxing.boxFloat(f), Boxing.boxFloat(f2), function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object animateDecay(final ScrollScope scrollScope, final float f, AnimationState animationState, DecayAnimationSpec decayAnimationSpec, final Function1 function1, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        Ref$FloatRef ref$FloatRef;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
            boolean z = ((Number) animationState.getVelocity()).floatValue() == 0.0f;
            Function1 function2 = new Function1() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.animateDecay.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((AnimationScope) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimationScope animationScope) {
                    if (Math.abs(((Number) animationScope.getValue()).floatValue()) >= Math.abs(f)) {
                        float fCoerceToTarget = SnapFlingBehaviorKt.coerceToTarget(((Number) animationScope.getValue()).floatValue(), f);
                        SnapFlingBehaviorKt.animateDecay$consumeDelta(animationScope, scrollScope, function1, fCoerceToTarget - ref$FloatRef2.element);
                        animationScope.cancelAnimation();
                        ref$FloatRef2.element = fCoerceToTarget;
                        return;
                    }
                    SnapFlingBehaviorKt.animateDecay$consumeDelta(animationScope, scrollScope, function1, ((Number) animationScope.getValue()).floatValue() - ref$FloatRef2.element);
                    ref$FloatRef2.element = ((Number) animationScope.getValue()).floatValue();
                }
            };
            anonymousClass1.L$0 = animationState;
            anonymousClass1.L$1 = ref$FloatRef2;
            anonymousClass1.F$0 = f;
            anonymousClass1.label = 1;
            if (SuspendAnimationKt.animateDecay(animationState, decayAnimationSpec, !z, function2, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            ref$FloatRef = ref$FloatRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f = anonymousClass1.F$0;
            ref$FloatRef = (Ref$FloatRef) anonymousClass1.L$1;
            animationState = (AnimationState) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return new AnimationResult(Boxing.boxFloat(f - ref$FloatRef.element), animationState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateDecay$consumeDelta(AnimationScope animationScope, ScrollScope scrollScope, Function1 function1, float f) {
        float fScrollBy = scrollScope.scrollBy(f);
        function1.invoke(Float.valueOf(fScrollBy));
        if (Math.abs(f - fScrollBy) > 0.5f) {
            animationScope.cancelAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    public static final Object animateWithTarget(final ScrollScope scrollScope, float f, final float f2, AnimationState animationState, AnimationSpec animationSpec, final Function1 function1, Continuation continuation) {
        C02021 c02021;
        float f3;
        AnimationState animationState2;
        Ref$FloatRef ref$FloatRef;
        float f4;
        if (continuation instanceof C02021) {
            c02021 = (C02021) continuation;
            int i = c02021.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c02021.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c02021 = new C02021(continuation);
            }
        } else {
            c02021 = new C02021(continuation);
        }
        C02021 c02022 = c02021;
        Object obj = c02022.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02022.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
            float fFloatValue = ((Number) animationState.getVelocity()).floatValue();
            Float fBoxFloat = Boxing.boxFloat(f);
            boolean z = ((Number) animationState.getVelocity()).floatValue() == 0.0f;
            Function1 function2 = new Function1() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.animateWithTarget.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((AnimationScope) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimationScope animationScope) {
                    float fCoerceToTarget = SnapFlingBehaviorKt.coerceToTarget(((Number) animationScope.getValue()).floatValue(), f2);
                    float f5 = fCoerceToTarget - ref$FloatRef2.element;
                    float fScrollBy = scrollScope.scrollBy(f5);
                    function1.invoke(Float.valueOf(fScrollBy));
                    if (Math.abs(f5 - fScrollBy) > 0.5f || fCoerceToTarget != ((Number) animationScope.getValue()).floatValue()) {
                        animationScope.cancelAnimation();
                    }
                    ref$FloatRef2.element += fScrollBy;
                }
            };
            c02022.L$0 = animationState;
            c02022.L$1 = ref$FloatRef2;
            f3 = f;
            c02022.F$0 = f3;
            c02022.F$1 = fFloatValue;
            c02022.label = 1;
            if (SuspendAnimationKt.animateTo(animationState, fBoxFloat, animationSpec, !z, function2, c02022) == coroutine_suspended) {
                return coroutine_suspended;
            }
            animationState2 = animationState;
            ref$FloatRef = ref$FloatRef2;
            f4 = fFloatValue;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f4 = c02022.F$1;
            float f5 = c02022.F$0;
            ref$FloatRef = (Ref$FloatRef) c02022.L$1;
            AnimationState animationState3 = (AnimationState) c02022.L$0;
            ResultKt.throwOnFailure(obj);
            f3 = f5;
            animationState2 = animationState3;
        }
        return new AnimationResult(Boxing.boxFloat(f3 - ref$FloatRef.element), AnimationStateKt.copy$default(animationState2, 0.0f, coerceToTarget(((Number) animationState2.getVelocity()).floatValue(), f4), 0L, 0L, false, 29, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float coerceToTarget(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        return f2 > 0.0f ? RangesKt.coerceAtMost(f, f2) : RangesKt.coerceAtLeast(f, f2);
    }

    public static final float getMinFlingVelocityDp() {
        return MinFlingVelocityDp;
    }
}
