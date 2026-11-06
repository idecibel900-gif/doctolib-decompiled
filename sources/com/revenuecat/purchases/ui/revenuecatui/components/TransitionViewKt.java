package com.revenuecat.purchases.ui.revenuecatui.components;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import com.revenuecat.purchases.paywalls.components.PaywallAnimation;
import com.revenuecat.purchases.paywalls.components.PaywallTransition;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a'\u0010\u0005\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\u001a!\u0010\n\u001a\u00020\u0003*\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0003¢\u0006\u0004\b\n\u0010\u0006\u001a\u0013\u0010\f\u001a\u00020\u000b*\u00020\u0000H\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u0015\u0010\u0010\u001a\u00020\u000f*\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0013\u0010\u0012\u001a\u00020\u000f*\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011¨\u0006\u0015²\u0006\u000e\u0010\u0014\u001a\u00020\u00138\n@\nX\u008a\u008e\u0002"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PaywallTransition;", "transition", "Lkotlin/Function0;", "", "content", "TransitionView", "(Lcom/revenuecat/purchases/paywalls/components/PaywallTransition;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/Modifier;", "hidden", "(Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;", "AnimatedVisibility", "Landroidx/compose/animation/EnterTransition;", "enterTransition", "(Lcom/revenuecat/purchases/paywalls/components/PaywallTransition;)Landroidx/compose/animation/EnterTransition;", "Lcom/revenuecat/purchases/paywalls/components/PaywallAnimation;", "Landroidx/compose/animation/core/Easing;", "easing", "(Lcom/revenuecat/purchases/paywalls/components/PaywallAnimation;)Landroidx/compose/animation/core/Easing;", "getEasing", "", "shouldShow", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TransitionViewKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PaywallTransition.TransitionType.values().length];
            try {
                iArr[PaywallTransition.TransitionType.FADE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaywallTransition.TransitionType.FADE_AND_SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PaywallTransition.TransitionType.SCALE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PaywallTransition.TransitionType.SLIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PaywallAnimation.AnimationType.values().length];
            try {
                iArr2[PaywallAnimation.AnimationType.EASE_IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[PaywallAnimation.AnimationType.EASE_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[PaywallAnimation.AnimationType.EASE_IN_OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[PaywallAnimation.AnimationType.LINEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final void TransitionView(final PaywallTransition paywallTransition, final Function2 content, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1753108978);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(paywallTransition) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1753108978, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.TransitionView (TransitionView.kt:29)");
            }
            if (paywallTransition == null) {
                composerStartRestartGroup.startReplaceGroup(1473784896);
                content.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1473826622);
                if (paywallTransition.getDisplacementStrategy() != PaywallTransition.DisplacementStrategy.GREEDY) {
                    composerStartRestartGroup.startReplaceGroup(1474120502);
                    AnimatedVisibility(paywallTransition, ComposableLambdaKt.rememberComposableLambda(797485256, true, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.TransitionView.2
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i3) {
                            if ((i3 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(797485256, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.TransitionView.<anonymous> (TransitionView.kt:42)");
                            }
                            content.invoke(composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2 & 14) | 48);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1473916429);
                    Modifier.Companion companion = Modifier.Companion;
                    Alignment.Companion companion2 = Alignment.Companion;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
                    Function0 constructor = companion3.getConstructor();
                    if (composerStartRestartGroup.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1086constructorimpl = Updater.m1086constructorimpl(composerStartRestartGroup);
                    Updater.m1088setimpl(composerM1086constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                    Updater.m1088setimpl(composerM1086constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                    if (composerM1086constructorimpl.getInserting() || !Intrinsics.areEqual(composerM1086constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM1086constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM1086constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1088setimpl(composerM1086constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    Modifier modifierHidden = hidden(companion);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierHidden);
                    Function0 constructor2 = companion3.getConstructor();
                    if (composerStartRestartGroup.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM1086constructorimpl2 = Updater.m1086constructorimpl(composerStartRestartGroup);
                    Updater.m1088setimpl(composerM1086constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                    Updater.m1088setimpl(composerM1086constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                    if (composerM1086constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM1086constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM1086constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM1086constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m1088setimpl(composerM1086constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                    composerStartRestartGroup.endNode();
                    AnimatedVisibility(paywallTransition, ComposableLambdaKt.rememberComposableLambda(1120237739, true, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt$TransitionView$1$2
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i3) {
                            if ((i3 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1120237739, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.TransitionView.<anonymous>.<anonymous> (TransitionView.kt:39)");
                            }
                            content.invoke(composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2 & 14) | 48);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.TransitionView.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    TransitionViewKt.TransitionView(paywallTransition, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final Modifier hidden(Modifier modifier) {
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.hidden.1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return m4052invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m2536unboximpl());
            }

            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m4052invoke3p2s80s(MeasureScope layout, Measurable measurable, long j) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Intrinsics.checkNotNullParameter(measurable, "measurable");
                Placeable placeableMo1843measureBRTryo0 = measurable.mo1843measureBRTryo0(j);
                return MeasureScope.layout$default(layout, placeableMo1843measureBRTryo0.getWidth(), placeableMo1843measureBRTryo0.getHeight(), null, new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.hidden.1.1
                    public final void invoke(Placeable.PlacementScope layout2) {
                        Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.INSTANCE;
                    }
                }, 4, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AnimatedVisibility(final PaywallTransition paywallTransition, final Function2 function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(391884057);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(paywallTransition) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(391884057, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.AnimatedVisibility (TransitionView.kt:57)");
            }
            composerStartRestartGroup.startReplaceGroup(1463461260);
            boolean zChanged = composerStartRestartGroup.changed(paywallTransition);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(1463463365);
            boolean zChanged2 = composerStartRestartGroup.changed(mutableState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new TransitionViewKt$AnimatedVisibility$1$1(mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(paywallTransition, (Function2) objRememberedValue2, composerStartRestartGroup, i2 & 14);
            AnimatedVisibilityKt.AnimatedVisibility(AnimatedVisibility$lambda$3(mutableState), null, enterTransition(paywallTransition), null, null, ComposableLambdaKt.rememberComposableLambda(1879822145, true, new Function3() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.AnimatedVisibility.2
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i3) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1879822145, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.AnimatedVisibility.<anonymous> (TransitionView.kt:66)");
                    }
                    function2.invoke(composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 196608, 26);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.AnimatedVisibility.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    TransitionViewKt.AnimatedVisibility(paywallTransition, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AnimatedVisibility$lambda$4(MutableState mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final EnterTransition enterTransition(PaywallTransition paywallTransition) {
        int msDuration;
        int i = WhenMappings.$EnumSwitchMapping$0[paywallTransition.getType().ordinal()];
        if (i == 1) {
            PaywallAnimation animation = paywallTransition.getAnimation();
            msDuration = animation != null ? animation.getMsDuration() : 300;
            PaywallAnimation animation2 = paywallTransition.getAnimation();
            return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween(msDuration, animation2 != null ? animation2.getMsDelay() : 0, easing(paywallTransition.getAnimation())), 0.0f, 2, null);
        }
        if (i == 2) {
            PaywallAnimation animation3 = paywallTransition.getAnimation();
            int msDuration2 = animation3 != null ? animation3.getMsDuration() : 300;
            PaywallAnimation animation4 = paywallTransition.getAnimation();
            EnterTransition enterTransitionFadeIn$default = EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween(msDuration2, animation4 != null ? animation4.getMsDelay() : 0, easing(paywallTransition.getAnimation())), 0.0f, 2, null);
            PaywallAnimation animation5 = paywallTransition.getAnimation();
            msDuration = animation5 != null ? animation5.getMsDuration() : 300;
            PaywallAnimation animation6 = paywallTransition.getAnimation();
            return enterTransitionFadeIn$default.plus(EnterExitTransitionKt.m41scaleInL8ZKhE$default(AnimationSpecKt.tween(msDuration, animation6 != null ? animation6.getMsDelay() : 0, easing(paywallTransition.getAnimation())), 0.0f, 0L, 6, null));
        }
        if (i == 3) {
            PaywallAnimation animation7 = paywallTransition.getAnimation();
            msDuration = animation7 != null ? animation7.getMsDuration() : 300;
            PaywallAnimation animation8 = paywallTransition.getAnimation();
            return EnterExitTransitionKt.m41scaleInL8ZKhE$default(AnimationSpecKt.tween(msDuration, animation8 != null ? animation8.getMsDelay() : 0, easing(paywallTransition.getAnimation())), 0.0f, 0L, 6, null);
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        PaywallAnimation animation9 = paywallTransition.getAnimation();
        msDuration = animation9 != null ? animation9.getMsDuration() : 300;
        PaywallAnimation animation10 = paywallTransition.getAnimation();
        return EnterExitTransitionKt.slideIn(AnimationSpecKt.tween(msDuration, animation10 != null ? animation10.getMsDelay() : 0, easing(paywallTransition.getAnimation())), new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.enterTransition.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntOffset.m2583boximpl(m4051invokemHKZG7I(((IntSize) obj).m2612unboximpl()));
            }

            /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m4051invokemHKZG7I(long j) {
                return IntOffsetKt.IntOffset(-180, 0);
            }
        });
    }

    private static final boolean AnimatedVisibility$lambda$3(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final Easing easing(PaywallAnimation paywallAnimation) {
        Easing easing;
        return (paywallAnimation == null || (easing = getEasing(paywallAnimation)) == null) ? EasingKt.getLinearOutSlowInEasing() : easing;
    }

    private static final Easing getEasing(PaywallAnimation paywallAnimation) {
        int i = WhenMappings.$EnumSwitchMapping$1[paywallAnimation.getType().ordinal()];
        if (i == 1) {
            return EasingKt.getFastOutSlowInEasing();
        }
        if (i == 2) {
            return EasingKt.getFastOutLinearInEasing();
        }
        if (i == 3) {
            return EasingKt.getLinearOutSlowInEasing();
        }
        if (i == 4) {
            return EasingKt.getLinearEasing();
        }
        throw new NoWhenBranchMatchedException();
    }
}
