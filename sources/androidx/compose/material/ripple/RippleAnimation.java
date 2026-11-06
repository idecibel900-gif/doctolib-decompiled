package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.imageutils.JfifUtil;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes.dex */
public final class RippleAnimation {
    private final Animatable animatedAlpha;
    private final Animatable animatedCenterPercent;
    private final Animatable animatedRadiusPercent;
    private final boolean bounded;
    private final MutableState finishRequested$delegate;
    private final CompletableDeferred finishSignalDeferred;
    private final MutableState finishedFadingIn$delegate;
    private Offset origin;
    private final float radius;
    private Float startRadius;
    private Offset targetCenter;

    /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$animate$1, reason: invalid class name */
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
            return RippleAnimation.this.animate(this);
        }
    }

    public /* synthetic */ RippleAnimation(Offset offset, float f, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(offset, f, z);
    }

    private RippleAnimation(Offset offset, float f, boolean z) {
        this.origin = offset;
        this.radius = f;
        this.bounded = z;
        this.animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.animatedRadiusPercent = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.animatedCenterPercent = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.finishSignalDeferred = CompletableDeferredKt.CompletableDeferred(null);
        Boolean bool = Boolean.FALSE;
        this.finishedFadingIn$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.finishRequested$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
    }

    private final boolean getFinishedFadingIn() {
        return ((Boolean) this.finishedFadingIn$delegate.getValue()).booleanValue();
    }

    private final void setFinishedFadingIn(boolean z) {
        this.finishedFadingIn$delegate.setValue(Boolean.valueOf(z));
    }

    private final boolean getFinishRequested() {
        return ((Boolean) this.finishRequested$delegate.getValue()).booleanValue();
    }

    private final void setFinishRequested(boolean z) {
        this.finishRequested$delegate.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
    
        if (r2.fadeOut(r0) == r1) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animate(kotlin.coroutines.Continuation r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.compose.material.ripple.RippleAnimation.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.material.ripple.RippleAnimation$animate$1 r0 = (androidx.compose.material.ripple.RippleAnimation.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.material.ripple.RippleAnimation$animate$1 r0 = new androidx.compose.material.ripple.RippleAnimation$animate$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L47
            if (r2 == r5) goto L3f
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r7)
            goto L72
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L37:
            java.lang.Object r2 = r0.L$0
            androidx.compose.material.ripple.RippleAnimation r2 = (androidx.compose.material.ripple.RippleAnimation) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L66
        L3f:
            java.lang.Object r2 = r0.L$0
            androidx.compose.material.ripple.RippleAnimation r2 = (androidx.compose.material.ripple.RippleAnimation) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L56
        L47:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r7 = r6.fadeIn(r0)
            if (r7 != r1) goto L55
            goto L71
        L55:
            r2 = r6
        L56:
            r2.setFinishedFadingIn(r5)
            kotlinx.coroutines.CompletableDeferred r7 = r2.finishSignalDeferred
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r7.await(r0)
            if (r7 != r1) goto L66
            goto L71
        L66:
            r7 = 0
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r7 = r2.fadeOut(r0)
            if (r7 != r1) goto L72
        L71:
            return r1
        L72:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ripple.RippleAnimation.animate(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$fadeIn$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = RippleAnimation.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$fadeIn$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2 {
            int label;
            final /* synthetic */ RippleAnimation this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(RippleAnimation rippleAnimation, Continuation continuation) {
                super(2, continuation);
                this.this$0 = rippleAnimation;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = this.this$0.animatedAlpha;
                    Float fBoxFloat = Boxing.boxFloat(1.0f);
                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(75, 0, EasingKt.getLinearEasing(), 2, null);
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, fBoxFloat, tweenSpecTween$default, null, null, this, 12, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(RippleAnimation.this, null), 3, null);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C00312(RippleAnimation.this, null), 3, null);
                return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass3(RippleAnimation.this, null), 3, null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$fadeIn$2$2, reason: invalid class name and collision with other inner class name */
        static final class C00312 extends SuspendLambda implements Function2 {
            int label;
            final /* synthetic */ RippleAnimation this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00312(RippleAnimation rippleAnimation, Continuation continuation) {
                super(2, continuation);
                this.this$0 = rippleAnimation;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C00312(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C00312) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = this.this$0.animatedRadiusPercent;
                    Float fBoxFloat = Boxing.boxFloat(1.0f);
                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(JfifUtil.MARKER_APP1, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, fBoxFloat, tweenSpecTween$default, null, null, this, 12, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$fadeIn$2$3, reason: invalid class name */
        static final class AnonymousClass3 extends SuspendLambda implements Function2 {
            int label;
            final /* synthetic */ RippleAnimation this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(RippleAnimation rippleAnimation, Continuation continuation) {
                super(2, continuation);
                this.this$0 = rippleAnimation;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass3(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = this.this$0.animatedCenterPercent;
                    Float fBoxFloat = Boxing.boxFloat(1.0f);
                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(JfifUtil.MARKER_APP1, 0, EasingKt.getLinearEasing(), 2, null);
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, fBoxFloat, tweenSpecTween$default, null, null, this, 12, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
    }

    private final Object fadeIn(Continuation continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass2(null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$fadeOut$2, reason: invalid class name and case insensitive filesystem */
    static final class C02212 extends SuspendLambda implements Function2 {
        private /* synthetic */ Object L$0;
        int label;

        C02212(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C02212 c02212 = RippleAnimation.this.new C02212(continuation);
            c02212.L$0 = obj;
            return c02212;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C02212) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$fadeOut$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2 {
            int label;
            final /* synthetic */ RippleAnimation this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(RippleAnimation rippleAnimation, Continuation continuation) {
                super(2, continuation);
                this.this$0 = rippleAnimation;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = this.this$0.animatedAlpha;
                    Float fBoxFloat = Boxing.boxFloat(0.0f);
                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, EasingKt.getLinearEasing(), 2, null);
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, fBoxFloat, tweenSpecTween$default, null, null, this, 12, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new AnonymousClass1(RippleAnimation.this, null), 3, null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final Object fadeOut(Continuation continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C02212(null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    public final void finish() {
        setFinishRequested(true);
        this.finishSignalDeferred.complete(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: draw-4WTKRHQ, reason: not valid java name */
    public final void m672draw4WTKRHQ(DrawScope drawScope, long j) {
        if (this.startRadius == null) {
            this.startRadius = Float.valueOf(RippleAnimationKt.m674getRippleStartRadiusuvyYCjk(drawScope.mo1599getSizeNHjbRc()));
        }
        if (this.origin == null) {
            this.origin = Offset.m1214boximpl(drawScope.mo1598getCenterF1C5BW0());
        }
        if (this.targetCenter == null) {
            this.targetCenter = Offset.m1214boximpl(OffsetKt.Offset(Size.m1261getWidthimpl(drawScope.mo1599getSizeNHjbRc()) / 2.0f, Size.m1259getHeightimpl(drawScope.mo1599getSizeNHjbRc()) / 2.0f));
        }
        float fFloatValue = (!getFinishRequested() || getFinishedFadingIn()) ? ((Number) this.animatedAlpha.getValue()).floatValue() : 1.0f;
        Float f = this.startRadius;
        Intrinsics.checkNotNull(f);
        float fLerp = MathHelpersKt.lerp(f.floatValue(), this.radius, ((Number) this.animatedRadiusPercent.getValue()).floatValue());
        Offset offset = this.origin;
        Intrinsics.checkNotNull(offset);
        float fM1223getXimpl = Offset.m1223getXimpl(offset.m1232unboximpl());
        Offset offset2 = this.targetCenter;
        Intrinsics.checkNotNull(offset2);
        float fLerp2 = MathHelpersKt.lerp(fM1223getXimpl, Offset.m1223getXimpl(offset2.m1232unboximpl()), ((Number) this.animatedCenterPercent.getValue()).floatValue());
        Offset offset3 = this.origin;
        Intrinsics.checkNotNull(offset3);
        float fM1224getYimpl = Offset.m1224getYimpl(offset3.m1232unboximpl());
        Offset offset4 = this.targetCenter;
        Intrinsics.checkNotNull(offset4);
        long jOffset = OffsetKt.Offset(fLerp2, MathHelpersKt.lerp(fM1224getYimpl, Offset.m1224getYimpl(offset4.m1232unboximpl()), ((Number) this.animatedCenterPercent.getValue()).floatValue()));
        long jM1365copywmQWz5c$default = Color.m1365copywmQWz5c$default(j, Color.m1368getAlphaimpl(j) * fFloatValue, 0.0f, 0.0f, 0.0f, 14, null);
        if (!this.bounded) {
            DrawScope.m1588drawCircleVaOC9Bg$default(drawScope, jM1365copywmQWz5c$default, fLerp, jOffset, 0.0f, null, null, 0, 120, null);
            return;
        }
        float fM1261getWidthimpl = Size.m1261getWidthimpl(drawScope.mo1599getSizeNHjbRc());
        float fM1259getHeightimpl = Size.m1259getHeightimpl(drawScope.mo1599getSizeNHjbRc());
        int iM1360getIntersectrtfAjoo = ClipOp.Companion.m1360getIntersectrtfAjoo();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo1579getSizeNHjbRc = drawContext.mo1579getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo1582clipRectN_I0leg(0.0f, 0.0f, fM1261getWidthimpl, fM1259getHeightimpl, iM1360getIntersectrtfAjoo);
        DrawScope.m1588drawCircleVaOC9Bg$default(drawScope, jM1365copywmQWz5c$default, fLerp, jOffset, 0.0f, null, null, 0, 120, null);
        drawContext.getCanvas().restore();
        drawContext.mo1580setSizeuvyYCjk(jMo1579getSizeNHjbRc);
    }
}
