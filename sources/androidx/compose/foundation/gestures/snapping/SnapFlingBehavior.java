package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.ui.MotionDurationScale;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes.dex */
public final class SnapFlingBehavior implements TargetedFlingBehavior {
    private final DecayAnimationSpec decayAnimationSpec;
    private MotionDurationScale motionScaleDuration = ScrollableKt.getDefaultScrollMotionDurationScale();
    private final AnimationSpec snapAnimationSpec;
    private final SnapLayoutInfoProvider snapLayoutInfoProvider;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return SnapFlingBehavior.this.fling(null, 0.0f, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1, reason: invalid class name and case insensitive filesystem */
    static final class C02001 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C02001(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return SnapFlingBehavior.this.performFling(null, 0.0f, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$tryApproach$1, reason: invalid class name and case insensitive filesystem */
    static final class C02011 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C02011(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return SnapFlingBehavior.this.tryApproach(null, 0.0f, 0.0f, null, this);
        }
    }

    public SnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, DecayAnimationSpec decayAnimationSpec, AnimationSpec animationSpec) {
        this.snapLayoutInfoProvider = snapLayoutInfoProvider;
        this.decayAnimationSpec = decayAnimationSpec;
        this.snapAnimationSpec = animationSpec;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.foundation.gestures.TargetedFlingBehavior
    public Object performFling(ScrollScope scrollScope, float f, Function1 function1, Continuation continuation) {
        C02001 c02001;
        if (continuation instanceof C02001) {
            c02001 = (C02001) continuation;
            int i = c02001.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c02001.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c02001 = new C02001(continuation);
            }
        } else {
            c02001 = new C02001(continuation);
        }
        Object objFling = c02001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02001.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFling);
            c02001.label = 1;
            objFling = fling(scrollScope, f, function1, c02001);
            if (objFling == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objFling);
        }
        AnimationResult animationResult = (AnimationResult) objFling;
        return Boxing.boxFloat(((Number) animationResult.component1()).floatValue() != 0.0f ? ((Number) animationResult.component2().getVelocity()).floatValue() : 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object fling(ScrollScope scrollScope, float f, Function1 function1, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        Function1 function2;
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
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            MotionDurationScale motionDurationScale = this.motionScaleDuration;
            SnapFlingBehavior$fling$result$1 snapFlingBehavior$fling$result$1 = new SnapFlingBehavior$fling$result$1(this, f, function1, scrollScope, null);
            anonymousClass1.L$0 = function1;
            anonymousClass1.label = 1;
            objWithContext = BuildersKt.withContext(motionDurationScale, snapFlingBehavior$fling$result$1, anonymousClass1);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            function2 = function1;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function2 = (Function1) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objWithContext);
        }
        AnimationResult animationResult = (AnimationResult) objWithContext;
        function2.invoke(Boxing.boxFloat(0.0f));
        return animationResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public final Object tryApproach(ScrollScope scrollScope, float f, float f2, Function1 function1, Continuation continuation) {
        C02011 c02011;
        SnapFlingBehavior snapFlingBehavior;
        if (continuation instanceof C02011) {
            c02011 = (C02011) continuation;
            int i = c02011.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c02011.label = i - LinearLayoutManager.INVALID_OFFSET;
                snapFlingBehavior = this;
            } else {
                snapFlingBehavior = this;
                c02011 = snapFlingBehavior.new C02011(continuation);
            }
        } else {
            snapFlingBehavior = this;
            c02011 = snapFlingBehavior.new C02011(continuation);
        }
        C02011 c02012 = c02011;
        Object objRunApproach = c02012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02012.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objRunApproach);
            if (Math.abs(f) == 0.0f || Math.abs(f2) == 0.0f) {
                return AnimationStateKt.AnimationState$default(f, f2, 0L, 0L, false, 28, null);
            }
            c02012.label = 1;
            objRunApproach = snapFlingBehavior.runApproach(scrollScope, f, f2, function1, c02012);
            if (objRunApproach == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objRunApproach);
        }
        return ((AnimationResult) objRunApproach).getCurrentAnimationState();
    }

    private final Object runApproach(ScrollScope scrollScope, float f, float f2, Function1 function1, Continuation continuation) {
        ApproachAnimation targetApproachAnimation;
        if (isDecayApproachPossible(f, f2)) {
            targetApproachAnimation = new DecayApproachAnimation(this.decayAnimationSpec);
        } else {
            targetApproachAnimation = new TargetApproachAnimation(this.snapAnimationSpec);
        }
        return SnapFlingBehaviorKt.approach(scrollScope, f, f2, targetApproachAnimation, function1, continuation);
    }

    private final boolean isDecayApproachPossible(float f, float f2) {
        return Math.abs(DecayAnimationSpecKt.calculateTargetValue(this.decayAnimationSpec, 0.0f, f2)) >= Math.abs(f);
    }

    public boolean equals(Object obj) {
        if (obj instanceof SnapFlingBehavior) {
            SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) obj;
            if (Intrinsics.areEqual(snapFlingBehavior.snapAnimationSpec, this.snapAnimationSpec) && Intrinsics.areEqual(snapFlingBehavior.decayAnimationSpec, this.decayAnimationSpec) && Intrinsics.areEqual(snapFlingBehavior.snapLayoutInfoProvider, this.snapLayoutInfoProvider)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.snapAnimationSpec.hashCode() * 31) + this.decayAnimationSpec.hashCode()) * 31) + this.snapLayoutInfoProvider.hashCode();
    }
}
