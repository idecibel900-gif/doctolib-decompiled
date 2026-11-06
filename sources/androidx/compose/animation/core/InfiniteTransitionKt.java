package androidx.compose.animation.core;

import androidx.compose.animation.core.InfiniteTransition.TransitionAnimationState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class InfiniteTransitionKt {
    public static final InfiniteTransition rememberInfiniteTransition(String str, Composer composer, int i, int i2) {
        if ((i2 & 1) != 0) {
            str = "InfiniteTransition";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1013651573, i, -1, "androidx.compose.animation.core.rememberInfiniteTransition (InfiniteTransition.kt:44)");
        }
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new InfiniteTransition(str);
            composer.updateRememberedValue(objRememberedValue);
        }
        InfiniteTransition infiniteTransition = (InfiniteTransition) objRememberedValue;
        infiniteTransition.run$animation_core_release(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return infiniteTransition;
    }

    public static final State animateValue(InfiniteTransition infiniteTransition, Object obj, Object obj2, TwoWayConverter twoWayConverter, InfiniteRepeatableSpec infiniteRepeatableSpec, String str, Composer composer, int i, int i2) {
        final InfiniteTransition infiniteTransition2;
        final Object obj3;
        final Object obj4;
        final InfiniteRepeatableSpec infiniteRepeatableSpec2;
        if ((i2 & 16) != 0) {
            str = "ValueAnimation";
        }
        String str2 = str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1062847727, i, -1, "androidx.compose.animation.core.animateValue (InfiniteTransition.kt:260)");
        }
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            infiniteTransition2 = infiniteTransition;
            obj3 = obj;
            obj4 = obj2;
            infiniteRepeatableSpec2 = infiniteRepeatableSpec;
            InfiniteTransition.TransitionAnimationState transitionAnimationState = infiniteTransition2.new TransitionAnimationState(obj3, obj4, twoWayConverter, infiniteRepeatableSpec2, str2);
            composer.updateRememberedValue(transitionAnimationState);
            objRememberedValue = transitionAnimationState;
        } else {
            infiniteTransition2 = infiniteTransition;
            obj3 = obj;
            obj4 = obj2;
            infiniteRepeatableSpec2 = infiniteRepeatableSpec;
        }
        final InfiniteTransition.TransitionAnimationState transitionAnimationState2 = (InfiniteTransition.TransitionAnimationState) objRememberedValue;
        boolean z = true;
        boolean z2 = ((((i & 112) ^ 48) > 32 && composer.changedInstance(obj3)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changedInstance(obj4)) || (i & 384) == 256);
        if ((((57344 & i) ^ 24576) <= 16384 || !composer.changedInstance(infiniteRepeatableSpec2)) && (i & 24576) != 16384) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z3 || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m73invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m73invoke() {
                    if (Intrinsics.areEqual(obj3, transitionAnimationState2.getInitialValue$animation_core_release()) && Intrinsics.areEqual(obj4, transitionAnimationState2.getTargetValue$animation_core_release())) {
                        return;
                    }
                    transitionAnimationState2.updateValues$animation_core_release(obj3, obj4, infiniteRepeatableSpec2);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        EffectsKt.SideEffect((Function0) objRememberedValue2, composer, 0);
        boolean zChangedInstance = composer.changedInstance(infiniteTransition2);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = new Function1() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    infiniteTransition2.addAnimation$animation_core_release(transitionAnimationState2);
                    final InfiniteTransition infiniteTransition3 = infiniteTransition2;
                    final InfiniteTransition.TransitionAnimationState transitionAnimationState3 = transitionAnimationState2;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$2$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            infiniteTransition3.removeAnimation$animation_core_release(transitionAnimationState3);
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        EffectsKt.DisposableEffect(transitionAnimationState2, (Function1) objRememberedValue3, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transitionAnimationState2;
    }

    public static final State animateFloat(InfiniteTransition infiniteTransition, float f, float f2, InfiniteRepeatableSpec infiniteRepeatableSpec, String str, Composer composer, int i, int i2) {
        if ((i2 & 8) != 0) {
            str = "FloatAnimation";
        }
        String str2 = str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-644770905, i, -1, "androidx.compose.animation.core.animateFloat (InfiniteTransition.kt:316)");
        }
        int i3 = i << 3;
        State stateAnimateValue = animateValue(infiniteTransition, Float.valueOf(f), Float.valueOf(f2), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), infiniteRepeatableSpec, str2, composer, (i & 1022) | (57344 & i3) | (i3 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateAnimateValue;
    }
}
