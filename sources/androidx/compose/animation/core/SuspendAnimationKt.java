package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.MotionDurationScale;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes.dex */
public abstract class SuspendAnimationKt {

    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animate$4, reason: invalid class name */
    static final class AnonymousClass4 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass4(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return SuspendAnimationKt.animate(null, null, 0L, null, this);
        }
    }

    public static /* synthetic */ Object animate$default(float f, float f2, float f3, AnimationSpec animationSpec, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        return animate(f, f2, f3, animationSpec, function2, continuation);
    }

    public static final Object animate(float f, float f2, float f3, AnimationSpec animationSpec, Function2 function2, Continuation continuation) {
        Object objAnimate = animate(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Boxing.boxFloat(f), Boxing.boxFloat(f2), Boxing.boxFloat(f3), animationSpec, function2, continuation);
        return objAnimate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimate : Unit.INSTANCE;
    }

    public static final Object animate(final TwoWayConverter twoWayConverter, Object obj, Object obj2, Object obj3, AnimationSpec animationSpec, final Function2 function2, Continuation continuation) {
        AnimationVector animationVectorNewInstance;
        if (obj3 == null || (animationVectorNewInstance = (AnimationVector) twoWayConverter.getConvertToVector().invoke(obj3)) == null) {
            animationVectorNewInstance = AnimationVectorsKt.newInstance((AnimationVector) twoWayConverter.getConvertToVector().invoke(obj));
        }
        AnimationVector animationVector = animationVectorNewInstance;
        Object objAnimate$default = animate$default(new AnimationState(twoWayConverter, obj, animationVector, 0L, 0L, false, 56, null), new TargetBasedAnimation(animationSpec, twoWayConverter, obj, obj2, animationVector), 0L, new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt.animate.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                invoke((AnimationScope) obj4);
                return Unit.INSTANCE;
            }

            public final void invoke(AnimationScope animationScope) {
                function2.invoke(animationScope.getValue(), twoWayConverter.getConvertFromVector().invoke(animationScope.getVelocityVector()));
            }
        }, continuation, 2, null);
        return objAnimate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimate$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(AnimationState animationState, Object obj, AnimationSpec animationSpec, boolean z, Function1 function1, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            function1 = new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt.animateTo.2
                public final void invoke(AnimationScope animationScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                    invoke((AnimationScope) obj3);
                    return Unit.INSTANCE;
                }
            };
        }
        return animateTo(animationState, obj, animationSpec2, z2, function1, continuation);
    }

    public static final Object animateTo(AnimationState animationState, Object obj, AnimationSpec animationSpec, boolean z, Function1 function1, Continuation continuation) {
        Object objAnimate = animate(animationState, new TargetBasedAnimation(animationSpec, animationState.getTypeConverter(), animationState.getValue(), obj, animationState.getVelocityVector()), z ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, function1, continuation);
        return objAnimate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimate : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateDecay$default(AnimationState animationState, DecayAnimationSpec decayAnimationSpec, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt.animateDecay.4
                public final void invoke(AnimationScope animationScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((AnimationScope) obj2);
                    return Unit.INSTANCE;
                }
            };
        }
        return animateDecay(animationState, decayAnimationSpec, z, function1, continuation);
    }

    public static final Object animateDecay(AnimationState animationState, DecayAnimationSpec decayAnimationSpec, boolean z, Function1 function1, Continuation continuation) {
        Object objAnimate = animate(animationState, new DecayAnimation(decayAnimationSpec, animationState.getTypeConverter(), animationState.getValue(), animationState.getVelocityVector()), z ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, function1, continuation);
        return objAnimate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimate : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:59:0x012f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0138  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public static final Object animate(final AnimationState animationState, Animation animation, long j, final Function1 function1, Continuation continuation) {
        AnonymousClass4 anonymousClass4;
        final Ref$ObjectRef ref$ObjectRef;
        final AnimationState animationState2;
        AnimationState animationState3;
        Ref$ObjectRef ref$ObjectRef2;
        Function1 function2;
        AnimationScope animationScope;
        AnimationScope animationScope2;
        Function1 function3;
        final Animation animation2 = animation;
        if (continuation instanceof AnonymousClass4) {
            anonymousClass4 = (AnonymousClass4) continuation;
            int i = anonymousClass4.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass4.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass4 = new AnonymousClass4(continuation);
            }
        } else {
            anonymousClass4 = new AnonymousClass4(continuation);
        }
        AnonymousClass4 anonymousClass5 = anonymousClass4;
        Object obj = anonymousClass5.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass5.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final Object valueFromNanos = animation2.getValueFromNanos(0L);
            final AnimationVector velocityVectorFromNanos = animation2.getVelocityVectorFromNanos(0L);
            ref$ObjectRef = new Ref$ObjectRef();
            if (j == Long.MIN_VALUE) {
                try {
                    final float durationScale = getDurationScale(anonymousClass5.getContext());
                    animationState2 = animationState;
                    try {
                        Function1 function4 = new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt.animate.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke(((Number) obj2).longValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(long j2) {
                                Ref$ObjectRef ref$ObjectRef3 = ref$ObjectRef;
                                Object obj2 = valueFromNanos;
                                TwoWayConverter typeConverter = animation2.getTypeConverter();
                                AnimationVector animationVector = velocityVectorFromNanos;
                                Object targetValue = animation2.getTargetValue();
                                final AnimationState animationState4 = animationState2;
                                AnimationScope animationScope3 = new AnimationScope(obj2, typeConverter, animationVector, j2, targetValue, j2, true, new Function0() { // from class: androidx.compose.animation.core.SuspendAnimationKt.animate.6.1
                                    {
                                        super(0);
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                    public final void m86invoke() {
                                        animationState4.setRunning$animation_core_release(false);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m86invoke();
                                        return Unit.INSTANCE;
                                    }
                                });
                                SuspendAnimationKt.doAnimationFrameWithScale(animationScope3, j2, durationScale, animation2, animationState2, function1);
                                ref$ObjectRef3.element = animationScope3;
                            }
                        };
                        ref$ObjectRef2 = ref$ObjectRef;
                        try {
                            anonymousClass5.L$0 = animationState2;
                            anonymousClass5.L$1 = animation2;
                            anonymousClass5.L$2 = function1;
                            anonymousClass5.L$3 = ref$ObjectRef2;
                            anonymousClass5.label = 1;
                            if (callWithFrameNanos(animation2, function4, anonymousClass5) != coroutine_suspended) {
                                animationState3 = animationState2;
                                function2 = function1;
                                ref$ObjectRef = ref$ObjectRef2;
                            }
                            return coroutine_suspended;
                        } catch (CancellationException e) {
                            e = e;
                            animationState3 = animationState2;
                            ref$ObjectRef = ref$ObjectRef2;
                            animationScope = (AnimationScope) ref$ObjectRef.element;
                            if (animationScope != null) {
                                animationScope.setRunning$animation_core_release(false);
                            }
                            animationScope2 = (AnimationScope) ref$ObjectRef.element;
                            if (animationScope2 != null && animationScope2.getLastFrameTimeNanos() == animationState3.getLastFrameTimeNanos()) {
                                animationState3.setRunning$animation_core_release(false);
                            }
                            throw e;
                        }
                    } catch (CancellationException e2) {
                        e = e2;
                        animationState3 = animationState2;
                        animationScope = (AnimationScope) ref$ObjectRef.element;
                        if (animationScope != null) {
                            animationScope.setRunning$animation_core_release(false);
                        }
                        animationScope2 = (AnimationScope) ref$ObjectRef.element;
                        if (animationScope2 != null) {
                            animationState3.setRunning$animation_core_release(false);
                        }
                        throw e;
                    }
                } catch (CancellationException e3) {
                    e = e3;
                    animationState2 = animationState;
                }
            } else {
                ref$ObjectRef2 = ref$ObjectRef;
                try {
                    AnimationScope animationScope3 = new AnimationScope(valueFromNanos, animation2.getTypeConverter(), velocityVectorFromNanos, j, animation2.getTargetValue(), j, true, new Function0() { // from class: androidx.compose.animation.core.SuspendAnimationKt.animate.7
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m87invoke() {
                            animationState.setRunning$animation_core_release(false);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m87invoke();
                            return Unit.INSTANCE;
                        }
                    });
                    doAnimationFrameWithScale(animationScope3, j, getDurationScale(anonymousClass5.getContext()), animation2, animationState, function1);
                    ref$ObjectRef2.element = animationScope3;
                    animationState3 = animationState;
                    animation2 = animation;
                    function2 = function1;
                    ref$ObjectRef = ref$ObjectRef2;
                } catch (CancellationException e4) {
                    e = e4;
                    animationState3 = animationState;
                    ref$ObjectRef = ref$ObjectRef2;
                    animationScope = (AnimationScope) ref$ObjectRef.element;
                    if (animationScope != null) {
                        animationScope.setRunning$animation_core_release(false);
                    }
                    animationScope2 = (AnimationScope) ref$ObjectRef.element;
                    if (animationScope2 != null) {
                        animationState3.setRunning$animation_core_release(false);
                    }
                    throw e;
                }
            }
        } else {
            if (i2 != 1 && i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$ObjectRef = (Ref$ObjectRef) anonymousClass5.L$3;
            function2 = (Function1) anonymousClass5.L$2;
            animation2 = (Animation) anonymousClass5.L$1;
            animationState3 = (AnimationState) anonymousClass5.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (CancellationException e5) {
                e = e5;
                animationScope = (AnimationScope) ref$ObjectRef.element;
                if (animationScope != null) {
                    animationScope.setRunning$animation_core_release(false);
                }
                animationScope2 = (AnimationScope) ref$ObjectRef.element;
                if (animationScope2 != null) {
                    animationState3.setRunning$animation_core_release(false);
                }
                throw e;
            }
        }
        do {
            Object obj2 = ref$ObjectRef.element;
            Intrinsics.checkNotNull(obj2);
            if (((AnimationScope) obj2).isRunning()) {
                final float durationScale2 = getDurationScale(anonymousClass5.getContext());
                final Ref$ObjectRef ref$ObjectRef3 = ref$ObjectRef;
                final Function1 function5 = function2;
                final Animation animation3 = animation2;
                final AnimationState animationState4 = animationState3;
                try {
                    function3 = new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt.animate.9
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                            invoke(((Number) obj3).longValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(long j2) {
                            Object obj3 = ref$ObjectRef3.element;
                            Intrinsics.checkNotNull(obj3);
                            SuspendAnimationKt.doAnimationFrameWithScale((AnimationScope) obj3, j2, durationScale2, animation3, animationState4, function5);
                        }
                    };
                    ref$ObjectRef = ref$ObjectRef3;
                    animation2 = animation3;
                    animationState3 = animationState4;
                    function2 = function5;
                    anonymousClass5.L$0 = animationState3;
                    anonymousClass5.L$1 = animation2;
                    anonymousClass5.L$2 = function2;
                    anonymousClass5.L$3 = ref$ObjectRef;
                    anonymousClass5.label = 2;
                } catch (CancellationException e6) {
                    e = e6;
                    ref$ObjectRef = ref$ObjectRef3;
                    animationState3 = animationState4;
                    animationScope = (AnimationScope) ref$ObjectRef.element;
                    if (animationScope != null) {
                        animationScope.setRunning$animation_core_release(false);
                    }
                    animationScope2 = (AnimationScope) ref$ObjectRef.element;
                    if (animationScope2 != null) {
                        animationState3.setRunning$animation_core_release(false);
                    }
                    throw e;
                }
            } else {
                return Unit.INSTANCE;
            }
        } while (callWithFrameNanos(animation2, function3, anonymousClass5) != coroutine_suspended);
        return coroutine_suspended;
    }

    public static /* synthetic */ Object animate$default(AnimationState animationState, Animation animation, long j, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MIN_VALUE;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt.animate.5
                public final void invoke(AnimationScope animationScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((AnimationScope) obj2);
                    return Unit.INSTANCE;
                }
            };
        }
        return animate(animationState, animation, j2, function1, continuation);
    }

    private static final Object callWithFrameNanos(Animation animation, final Function1 function1, Continuation continuation) {
        if (animation.isInfinite()) {
            return InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(function1, continuation);
        }
        return MonotonicFrameClockKt.withFrameNanos(new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt.callWithFrameNanos.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).longValue());
            }

            public final Object invoke(long j) {
                return function1.invoke(Long.valueOf(j));
            }
        }, continuation);
    }

    public static final float getDurationScale(CoroutineContext coroutineContext) {
        MotionDurationScale motionDurationScale = (MotionDurationScale) coroutineContext.get(MotionDurationScale.Key);
        float scaleFactor = motionDurationScale != null ? motionDurationScale.getScaleFactor() : 1.0f;
        if (!(scaleFactor >= 0.0f)) {
            PreconditionsKt.throwIllegalStateException("negative scale factor");
        }
        return scaleFactor;
    }

    public static final void updateState(AnimationScope animationScope, AnimationState animationState) {
        animationState.setValue$animation_core_release(animationScope.getValue());
        AnimationVectorsKt.copyFrom(animationState.getVelocityVector(), animationScope.getVelocityVector());
        animationState.setFinishedTimeNanos$animation_core_release(animationScope.getFinishedTimeNanos());
        animationState.setLastFrameTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
        animationState.setRunning$animation_core_release(animationScope.isRunning());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doAnimationFrameWithScale(AnimationScope animationScope, long j, float f, Animation animation, AnimationState animationState, Function1 function1) {
        long startTimeNanos;
        if (f == 0.0f) {
            startTimeNanos = animation.getDurationNanos();
        } else {
            startTimeNanos = (long) ((j - animationScope.getStartTimeNanos()) / f);
        }
        doAnimationFrame(animationScope, j, startTimeNanos, animation, animationState, function1);
    }

    private static final void doAnimationFrame(AnimationScope animationScope, long j, long j2, Animation animation, AnimationState animationState, Function1 function1) {
        animationScope.setLastFrameTimeNanos$animation_core_release(j);
        animationScope.setValue$animation_core_release(animation.getValueFromNanos(j2));
        animationScope.setVelocityVector$animation_core_release(animation.getVelocityVectorFromNanos(j2));
        if (animation.isFinishedFromNanos(j2)) {
            animationScope.setFinishedTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
            animationScope.setRunning$animation_core_release(false);
        }
        updateState(animationScope, animationState);
        function1.invoke(animationScope);
    }
}
