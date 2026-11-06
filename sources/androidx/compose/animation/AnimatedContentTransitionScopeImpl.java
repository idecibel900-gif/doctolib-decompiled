package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class AnimatedContentTransitionScopeImpl implements AnimatedContentTransitionScope {
    private State animatedSize;
    private Alignment contentAlignment;
    private LayoutDirection layoutDirection;
    private final MutableState measuredSize$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m2604boximpl(IntSize.Companion.m2613getZeroYbymL2g()), null, 2, null);
    private final MutableScatterMap targetSizeMap = ScatterMapKt.mutableScatterMapOf();
    private final Transition transition;

    private static final boolean createSizeAnimationModifier$lambda$2(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    public AnimatedContentTransitionScopeImpl(Transition transition, Alignment alignment, LayoutDirection layoutDirection) {
        this.transition = transition;
        this.contentAlignment = alignment;
        this.layoutDirection = layoutDirection;
    }

    public Alignment getContentAlignment() {
        return this.contentAlignment;
    }

    public void setContentAlignment(Alignment alignment) {
        this.contentAlignment = alignment;
    }

    public final void setLayoutDirection$animation_release(LayoutDirection layoutDirection) {
        this.layoutDirection = layoutDirection;
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public Object getInitialState() {
        return this.transition.getSegment().getInitialState();
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public Object getTargetState() {
        return this.transition.getSegment().getTargetState();
    }

    /* JADX INFO: renamed from: setMeasuredSize-ozmzZPI$animation_release, reason: not valid java name */
    public final void m31setMeasuredSizeozmzZPI$animation_release(long j) {
        this.measuredSize$delegate.setValue(IntSize.m2604boximpl(j));
    }

    public final MutableScatterMap getTargetSizeMap$animation_release() {
        return this.targetSizeMap;
    }

    public final void setAnimatedSize$animation_release(State state) {
        this.animatedSize = state;
    }

    public final Modifier createSizeAnimationModifier$animation_release(ContentTransform contentTransform, Composer composer, int i) {
        Modifier modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(93755870, i, -1, "androidx.compose.animation.AnimatedContentTransitionScopeImpl.createSizeAnimationModifier (AnimatedContent.kt:573)");
        }
        boolean zChanged = composer.changed(this);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(contentTransform.getSizeTransform(), composer, 0);
        if (Intrinsics.areEqual(this.transition.getCurrentState(), this.transition.getTargetState())) {
            createSizeAnimationModifier$lambda$3(mutableState, false);
        } else if (stateRememberUpdatedState.getValue() != null) {
            createSizeAnimationModifier$lambda$3(mutableState, true);
        }
        if (createSizeAnimationModifier$lambda$2(mutableState)) {
            composer.startReplaceGroup(249037309);
            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation = TransitionKt.createDeferredAnimation(this.transition, VectorConvertersKt.getVectorConverter(IntSize.Companion), null, composer, 0, 2);
            boolean zChanged2 = composer.changed(deferredAnimationCreateDeferredAnimation);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                SizeTransform sizeTransform = (SizeTransform) stateRememberUpdatedState.getValue();
                objRememberedValue2 = ((sizeTransform == null || sizeTransform.getClip()) ? ClipKt.clipToBounds(Modifier.Companion) : Modifier.Companion).then(new SizeModifier(deferredAnimationCreateDeferredAnimation, stateRememberUpdatedState));
                composer.updateRememberedValue(objRememberedValue2);
            }
            modifier = (Modifier) objRememberedValue2;
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(249353726);
            composer.endReplaceGroup();
            this.animatedSize = null;
            modifier = Modifier.Companion;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return modifier;
    }

    private static final void createSizeAnimationModifier$lambda$3(MutableState mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    public static final class ChildData implements ParentDataModifier {
        private final MutableState isTarget$delegate;

        @Override // androidx.compose.ui.layout.ParentDataModifier
        public Object modifyParentData(Density density, Object obj) {
            return this;
        }

        public ChildData(boolean z) {
            this.isTarget$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), null, 2, null);
        }

        public final boolean isTarget() {
            return ((Boolean) this.isTarget$delegate.getValue()).booleanValue();
        }

        public final void setTarget(boolean z) {
            this.isTarget$delegate.setValue(Boolean.valueOf(z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class SizeModifier extends LayoutModifierWithPassThroughIntrinsics {
        private final Transition.DeferredAnimation sizeAnimation;
        private final State sizeTransform;

        public SizeModifier(Transition.DeferredAnimation deferredAnimation, State state) {
            this.sizeAnimation = deferredAnimation;
            this.sizeTransform = state;
        }

        public final State getSizeTransform() {
            return this.sizeTransform;
        }

        @Override // androidx.compose.ui.layout.LayoutModifier
        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
        public MeasureResult mo32measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
            final long jM2612unboximpl;
            final Placeable placeableMo1843measureBRTryo0 = measurable.mo1843measureBRTryo0(j);
            Transition.DeferredAnimation deferredAnimation = this.sizeAnimation;
            final AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl = AnimatedContentTransitionScopeImpl.this;
            Function1 function1 = new Function1() { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$SizeModifier$measure$size$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final FiniteAnimationSpec invoke(Transition.Segment segment) {
                    FiniteAnimationSpec finiteAnimationSpecMo63createAnimationSpecTemP2vQ;
                    State state = (State) animatedContentTransitionScopeImpl.getTargetSizeMap$animation_release().get(segment.getInitialState());
                    long jM2612unboximpl2 = state != null ? ((IntSize) state.getValue()).m2612unboximpl() : IntSize.Companion.m2613getZeroYbymL2g();
                    State state2 = (State) animatedContentTransitionScopeImpl.getTargetSizeMap$animation_release().get(segment.getTargetState());
                    long jM2612unboximpl3 = state2 != null ? ((IntSize) state2.getValue()).m2612unboximpl() : IntSize.Companion.m2613getZeroYbymL2g();
                    SizeTransform sizeTransform = (SizeTransform) this.getSizeTransform().getValue();
                    return (sizeTransform == null || (finiteAnimationSpecMo63createAnimationSpecTemP2vQ = sizeTransform.mo63createAnimationSpecTemP2vQ(jM2612unboximpl2, jM2612unboximpl3)) == null) ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : finiteAnimationSpecMo63createAnimationSpecTemP2vQ;
                }
            };
            final AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl2 = AnimatedContentTransitionScopeImpl.this;
            State stateAnimate = deferredAnimation.animate(function1, new Function1() { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$SizeModifier$measure$size$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return IntSize.m2604boximpl(m33invokeYEO4UFw(obj));
                }

                /* JADX INFO: renamed from: invoke-YEO4UFw, reason: not valid java name */
                public final long m33invokeYEO4UFw(Object obj) {
                    State state = (State) animatedContentTransitionScopeImpl2.getTargetSizeMap$animation_release().get(obj);
                    return state != null ? ((IntSize) state.getValue()).m2612unboximpl() : IntSize.Companion.m2613getZeroYbymL2g();
                }
            });
            AnimatedContentTransitionScopeImpl.this.setAnimatedSize$animation_release(stateAnimate);
            if (measureScope.isLookingAhead()) {
                jM2612unboximpl = IntSizeKt.IntSize(placeableMo1843measureBRTryo0.getWidth(), placeableMo1843measureBRTryo0.getHeight());
            } else {
                jM2612unboximpl = ((IntSize) stateAnimate.getValue()).m2612unboximpl();
            }
            int iM2609getWidthimpl = IntSize.m2609getWidthimpl(jM2612unboximpl);
            int iM2608getHeightimpl = IntSize.m2608getHeightimpl(jM2612unboximpl);
            final AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl3 = AnimatedContentTransitionScopeImpl.this;
            return MeasureScope.layout$default(measureScope, iM2609getWidthimpl, iM2608getHeightimpl, null, new Function1() { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$SizeModifier$measure$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Placeable.PlacementScope placementScope) {
                    Placeable.PlacementScope.m1865place70tqf50$default(placementScope, placeableMo1843measureBRTryo0, animatedContentTransitionScopeImpl3.getContentAlignment().mo1118alignKFBX0sM(IntSizeKt.IntSize(placeableMo1843measureBRTryo0.getWidth(), placeableMo1843measureBRTryo0.getHeight()), jM2612unboximpl, LayoutDirection.Ltr), 0.0f, 2, null);
                }
            }, 4, null);
        }
    }
}
