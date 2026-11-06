package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.util.ListUtilsKt;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class SnackbarHostKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SnackbarDuration.values().length];
            try {
                iArr[SnackbarDuration.Indefinite.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SnackbarDuration.Long.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SnackbarDuration.Short.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void SnackbarHost(final SnackbarHostState snackbarHostState, Modifier modifier, Function3 function3, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        final Function3 function4;
        Composer composerStartRestartGroup = composer.startRestartGroup(464178177);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(snackbarHostState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER : 128;
        }
        if ((i3 & 147) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (i5 != 0) {
                function3 = ComposableSingletons$SnackbarHostKt.INSTANCE.m770getLambda1$material3_release();
            }
            Function3 function5 = function3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(464178177, i3, -1, "androidx.compose.material3.SnackbarHost (SnackbarHost.kt:221)");
            }
            SnackbarData currentSnackbarData = snackbarHostState.getCurrentSnackbarData();
            AccessibilityManager accessibilityManager = (AccessibilityManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalAccessibilityManager());
            boolean zChanged = composerStartRestartGroup.changed(currentSnackbarData) | composerStartRestartGroup.changedInstance(accessibilityManager);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SnackbarHostKt$SnackbarHost$1$1(currentSnackbarData, accessibilityManager, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.LaunchedEffect(currentSnackbarData, (Function2) objRememberedValue, composerStartRestartGroup, 0);
            Modifier modifier3 = modifier;
            FadeInFadeOutWithScale(snackbarHostState.getCurrentSnackbarData(), modifier3, function5, composerStartRestartGroup, i3 & 1008, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            function4 = function5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            function4 = function3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SnackbarHostKt.SnackbarHost.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    SnackbarHostKt.SnackbarHost(snackbarHostState, modifier2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public static final long toMillis(SnackbarDuration snackbarDuration, boolean z, AccessibilityManager accessibilityManager) {
        long j;
        int i = WhenMappings.$EnumSwitchMapping$0[snackbarDuration.ordinal()];
        if (i == 1) {
            j = Long.MAX_VALUE;
        } else if (i == 2) {
            j = 10000;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            j = 4000;
        }
        long j2 = j;
        return accessibilityManager == null ? j2 : accessibilityManager.calculateRecommendedTimeoutMillis(j2, true, true, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x0045  */
    /* JADX WARN: Code duplicated, block: B:27:0x0048  */
    /* JADX WARN: Code duplicated, block: B:29:0x004c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0052  */
    /* JADX WARN: Code duplicated, block: B:32:0x0055  */
    /* JADX WARN: Code duplicated, block: B:40:0x006b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x006d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0070  */
    /* JADX WARN: Code duplicated, block: B:45:0x0077  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:53:0x00bd A[LOOP:0: B:52:0x00bb->B:53:0x00bd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:56:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f4 A[LOOP:1: B:58:0x00f2->B:59:0x00f4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:63:0x013b  */
    /* JADX WARN: Code duplicated, block: B:66:0x0147  */
    /* JADX WARN: Code duplicated, block: B:67:0x014b  */
    /* JADX WARN: Code duplicated, block: B:70:0x016a  */
    /* JADX WARN: Code duplicated, block: B:72:0x0178  */
    /* JADX WARN: Code duplicated, block: B:75:0x01a8 A[LOOP:2: B:74:0x01a6->B:75:0x01a8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:78:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:81:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:86:? A[RETURN, SYNTHETIC] */
    public static final void FadeInFadeOutWithScale(final SnackbarData snackbarData, Modifier modifier, final Function3 function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Modifier modifier3;
        Object objRememberedValue;
        final FadeInFadeOutState fadeInFadeOutState;
        int currentCompositeKeyHash;
        Function0 constructor;
        Composer composerM1086constructorimpl;
        Function2 setCompositeKeyHash;
        List items;
        int size;
        int i5;
        List items2;
        ArrayList arrayList;
        int size2;
        int i6;
        final List mutableList;
        List listFastFilterNotNull;
        List items3;
        int size3;
        int i7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final SnackbarData snackbarData2 = snackbarData;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1316639904);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(snackbarData2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 4) != 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i4 = IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
                } else {
                    i4 = 128;
                }
                i3 |= i4;
            }
            if ((i3 & 147) != 146 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i8 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1316639904, i3, -1, "androidx.compose.material3.FadeInFadeOutWithScale (SnackbarHost.kt:327)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new FadeInFadeOutState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                fadeInFadeOutState = (FadeInFadeOutState) objRememberedValue;
                composerStartRestartGroup.startReplaceGroup(-1256811491);
                if (!Intrinsics.areEqual(snackbarData2, fadeInFadeOutState.getCurrent())) {
                    fadeInFadeOutState.setCurrent(snackbarData2);
                    items2 = fadeInFadeOutState.getItems();
                    arrayList = new ArrayList(items2.size());
                    size2 = items2.size();
                    for (i6 = 0; i6 < size2; i6++) {
                        arrayList.add((SnackbarData) ((FadeInFadeOutAnimationItem) items2.get(i6)).getKey());
                    }
                    mutableList = CollectionsKt.toMutableList((Collection) arrayList);
                    if (!mutableList.contains(snackbarData2)) {
                        mutableList.add(snackbarData2);
                    }
                    fadeInFadeOutState.getItems().clear();
                    listFastFilterNotNull = ListUtilsKt.fastFilterNotNull(mutableList);
                    items3 = fadeInFadeOutState.getItems();
                    size3 = listFastFilterNotNull.size();
                    i7 = 0;
                    while (i7 < size3) {
                        final SnackbarData snackbarData3 = (SnackbarData) listFastFilterNotNull.get(i7);
                        items3.add(new FadeInFadeOutAnimationItem(snackbarData3, ComposableLambdaKt.rememberComposableLambda(-1654683077, true, new Function3() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((Function2) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Function2 function2, Composer composer2, int i9) {
                                int i10;
                                if ((i9 & 6) == 0) {
                                    i10 = i9 | (composer2.changedInstance(function2) ? 4 : 2);
                                } else {
                                    i10 = i9;
                                }
                                if ((i10 & 19) != 18 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1654683077, i10, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous> (SnackbarHost.kt:338)");
                                    }
                                    boolean zAreEqual = Intrinsics.areEqual(snackbarData3, snackbarData2);
                                    int i11 = zAreEqual ? 150 : 75;
                                    int i12 = (!zAreEqual || ListUtilsKt.fastFilterNotNull(mutableList).size() == 1) ? 0 : 75;
                                    TweenSpec tweenSpecTween = AnimationSpecKt.tween(i11, i12, EasingKt.getLinearEasing());
                                    boolean zChanged = composer2.changed(snackbarData3) | composer2.changedInstance(fadeInFadeOutState);
                                    final SnackbarData snackbarData4 = snackbarData3;
                                    final FadeInFadeOutState fadeInFadeOutState2 = fadeInFadeOutState;
                                    Object objRememberedValue2 = composer2.rememberedValue();
                                    if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                        objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public /* bridge */ /* synthetic */ Object invoke() {
                                                m818invoke();
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                            public final void m818invoke() {
                                                if (Intrinsics.areEqual(snackbarData4, fadeInFadeOutState2.getCurrent())) {
                                                    return;
                                                }
                                                List items4 = fadeInFadeOutState2.getItems();
                                                final SnackbarData snackbarData5 = snackbarData4;
                                                CollectionsKt.removeAll(items4, new Function1() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1$1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Boolean invoke(FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem) {
                                                        return Boolean.valueOf(Intrinsics.areEqual(fadeInFadeOutAnimationItem.getKey(), snackbarData5));
                                                    }
                                                });
                                                RecomposeScope scope = fadeInFadeOutState2.getScope();
                                                if (scope != null) {
                                                    scope.invalidate();
                                                }
                                            }
                                        };
                                        composer2.updateRememberedValue(objRememberedValue2);
                                    }
                                    State stateAnimatedOpacity = SnackbarHostKt.animatedOpacity(tweenSpecTween, zAreEqual, (Function0) objRememberedValue2, composer2, 0, 0);
                                    State stateAnimatedScale = SnackbarHostKt.animatedScale(AnimationSpecKt.tween(i11, i12, EasingKt.getFastOutSlowInEasing()), zAreEqual, composer2, 0);
                                    Modifier modifierM1414graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m1414graphicsLayerAp8cVGQ$default(Modifier.Companion, ((Number) stateAnimatedScale.getValue()).floatValue(), ((Number) stateAnimatedScale.getValue()).floatValue(), ((Number) stateAnimatedOpacity.getValue()).floatValue(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131064, null);
                                    boolean zChanged2 = composer2.changed(snackbarData3);
                                    final SnackbarData snackbarData5 = snackbarData3;
                                    Object objRememberedValue3 = composer2.rememberedValue();
                                    if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                                        objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$1$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((SemanticsPropertyReceiver) obj);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                SemanticsPropertiesKt.m2115setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.Companion.m2094getPolite0phEisY());
                                                final SnackbarData snackbarData6 = snackbarData5;
                                                SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$1$1.1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Boolean invoke() {
                                                        snackbarData6.dismiss();
                                                        return Boolean.TRUE;
                                                    }
                                                }, 1, null);
                                            }
                                        };
                                        composer2.updateRememberedValue(objRememberedValue3);
                                    }
                                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierM1414graphicsLayerAp8cVGQ$default, false, (Function1) objRememberedValue3, 1, null);
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierSemantics$default);
                                    ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                                    Function0 constructor2 = companion.getConstructor();
                                    if (composer2.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(constructor2);
                                    } else {
                                        composer2.useNode();
                                    }
                                    Composer composerM1086constructorimpl2 = Updater.m1086constructorimpl(composer2);
                                    Updater.m1088setimpl(composerM1086constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                                    Updater.m1088setimpl(composerM1086constructorimpl2, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash2 = companion.getSetCompositeKeyHash();
                                    if (composerM1086constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM1086constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        composerM1086constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        composerM1086constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    Updater.m1088setimpl(composerM1086constructorimpl2, modifierMaterializeModifier, companion.getSetModifier());
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    function2.invoke(composer2, Integer.valueOf(i10 & 14));
                                    composer2.endNode();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54)));
                        i7++;
                        snackbarData2 = snackbarData;
                    }
                }
                composerStartRestartGroup.endReplaceGroup();
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                constructor = companion.getConstructor();
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM1086constructorimpl = Updater.m1086constructorimpl(composerStartRestartGroup);
                Updater.m1088setimpl(composerM1086constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1088setimpl(composerM1086constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (!composerM1086constructorimpl.getInserting() || !Intrinsics.areEqual(composerM1086constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM1086constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM1086constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1088setimpl(composerM1086constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                fadeInFadeOutState.setScope(ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0));
                composerStartRestartGroup.startReplaceGroup(1748085441);
                items = fadeInFadeOutState.getItems();
                size = items.size();
                for (i5 = 0; i5 < size; i5++) {
                    FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem = (FadeInFadeOutAnimationItem) items.get(i5);
                    final SnackbarData snackbarData4 = (SnackbarData) fadeInFadeOutAnimationItem.component1();
                    Function3 function3Component2 = fadeInFadeOutAnimationItem.component2();
                    composerStartRestartGroup.startMovableGroup(1201076541, snackbarData4);
                    function3Component2.invoke(ComposableLambdaKt.rememberComposableLambda(-1135367807, true, new Function2() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i9) {
                            if ((i9 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1135367807, i9, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SnackbarHost.kt:395)");
                            }
                            Function3 function4 = function3;
                            SnackbarData snackbarData5 = snackbarData4;
                            Intrinsics.checkNotNull(snackbarData5);
                            function4.invoke(snackbarData5, composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endMovableGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier4 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SnackbarHostKt.FadeInFadeOutWithScale.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        SnackbarHostKt.FadeInFadeOutWithScale(snackbarData, modifier4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i4 = IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        if ((i3 & 147) != 146) {
            if (i8 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1316639904, i3, -1, "androidx.compose.material3.FadeInFadeOutWithScale (SnackbarHost.kt:327)");
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new FadeInFadeOutState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            fadeInFadeOutState = (FadeInFadeOutState) objRememberedValue;
            composerStartRestartGroup.startReplaceGroup(-1256811491);
            if (!Intrinsics.areEqual(snackbarData2, fadeInFadeOutState.getCurrent())) {
                fadeInFadeOutState.setCurrent(snackbarData2);
                items2 = fadeInFadeOutState.getItems();
                arrayList = new ArrayList(items2.size());
                size2 = items2.size();
                while (i6 < size2) {
                    arrayList.add((SnackbarData) ((FadeInFadeOutAnimationItem) items2.get(i6)).getKey());
                }
                mutableList = CollectionsKt.toMutableList((Collection) arrayList);
                if (!mutableList.contains(snackbarData2)) {
                    mutableList.add(snackbarData2);
                }
                fadeInFadeOutState.getItems().clear();
                listFastFilterNotNull = ListUtilsKt.fastFilterNotNull(mutableList);
                items3 = fadeInFadeOutState.getItems();
                size3 = listFastFilterNotNull.size();
                i7 = 0;
                while (i7 < size3) {
                    final SnackbarData snackbarData5 = (SnackbarData) listFastFilterNotNull.get(i7);
                    items3.add(new FadeInFadeOutAnimationItem(snackbarData5, ComposableLambdaKt.rememberComposableLambda(-1654683077, true, new Function3() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((Function2) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Function2 function2, Composer composer2, int i9) {
                            int i10;
                            if ((i9 & 6) == 0) {
                                i10 = i9 | (composer2.changedInstance(function2) ? 4 : 2);
                            } else {
                                i10 = i9;
                            }
                            if ((i10 & 19) != 18 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1654683077, i10, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous> (SnackbarHost.kt:338)");
                                }
                                boolean zAreEqual = Intrinsics.areEqual(snackbarData5, snackbarData2);
                                int i11 = zAreEqual ? 150 : 75;
                                int i12 = (!zAreEqual || ListUtilsKt.fastFilterNotNull(mutableList).size() == 1) ? 0 : 75;
                                TweenSpec tweenSpecTween = AnimationSpecKt.tween(i11, i12, EasingKt.getLinearEasing());
                                boolean zChanged = composer2.changed(snackbarData5) | composer2.changedInstance(fadeInFadeOutState);
                                final SnackbarData snackbarData6 = snackbarData5;
                                final FadeInFadeOutState fadeInFadeOutState2 = fadeInFadeOutState;
                                Object objRememberedValue2 = composer2.rememberedValue();
                                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                    objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Object invoke() {
                                            m818invoke();
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                        public final void m818invoke() {
                                            if (Intrinsics.areEqual(snackbarData6, fadeInFadeOutState2.getCurrent())) {
                                                return;
                                            }
                                            List items4 = fadeInFadeOutState2.getItems();
                                            final SnackbarData snackbarData7 = snackbarData6;
                                            CollectionsKt.removeAll(items4, new Function1() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1$1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Boolean invoke(FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem2) {
                                                    return Boolean.valueOf(Intrinsics.areEqual(fadeInFadeOutAnimationItem2.getKey(), snackbarData7));
                                                }
                                            });
                                            RecomposeScope scope = fadeInFadeOutState2.getScope();
                                            if (scope != null) {
                                                scope.invalidate();
                                            }
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue2);
                                }
                                State stateAnimatedOpacity = SnackbarHostKt.animatedOpacity(tweenSpecTween, zAreEqual, (Function0) objRememberedValue2, composer2, 0, 0);
                                State stateAnimatedScale = SnackbarHostKt.animatedScale(AnimationSpecKt.tween(i11, i12, EasingKt.getFastOutSlowInEasing()), zAreEqual, composer2, 0);
                                Modifier modifierM1414graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m1414graphicsLayerAp8cVGQ$default(Modifier.Companion, ((Number) stateAnimatedScale.getValue()).floatValue(), ((Number) stateAnimatedScale.getValue()).floatValue(), ((Number) stateAnimatedOpacity.getValue()).floatValue(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131064, null);
                                boolean zChanged2 = composer2.changed(snackbarData5);
                                final SnackbarData snackbarData7 = snackbarData5;
                                Object objRememberedValue3 = composer2.rememberedValue();
                                if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$1$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((SemanticsPropertyReceiver) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            SemanticsPropertiesKt.m2115setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.Companion.m2094getPolite0phEisY());
                                            final SnackbarData snackbarData8 = snackbarData7;
                                            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$1$1.1
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    snackbarData8.dismiss();
                                                    return Boolean.TRUE;
                                                }
                                            }, 1, null);
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue3);
                                }
                                Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierM1414graphicsLayerAp8cVGQ$default, false, (Function1) objRememberedValue3, 1, null);
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierSemantics$default);
                                ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                                Function0 constructor2 = companion2.getConstructor();
                                if (composer2.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor2);
                                } else {
                                    composer2.useNode();
                                }
                                Composer composerM1086constructorimpl2 = Updater.m1086constructorimpl(composer2);
                                Updater.m1088setimpl(composerM1086constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                                Updater.m1088setimpl(composerM1086constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                                if (composerM1086constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM1086constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    composerM1086constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    composerM1086constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                Updater.m1088setimpl(composerM1086constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                function2.invoke(composer2, Integer.valueOf(i10 & 14));
                                composer2.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54)));
                    i7++;
                    snackbarData2 = snackbarData;
                }
            }
            composerStartRestartGroup.endReplaceGroup();
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            constructor = companion2.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM1086constructorimpl = Updater.m1086constructorimpl(composerStartRestartGroup);
            Updater.m1088setimpl(composerM1086constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m1088setimpl(composerM1086constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (!composerM1086constructorimpl.getInserting()) {
                composerM1086constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM1086constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM1086constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM1086constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1088setimpl(composerM1086constructorimpl, modifierMaterializeModifier2, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            fadeInFadeOutState.setScope(ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0));
            composerStartRestartGroup.startReplaceGroup(1748085441);
            items = fadeInFadeOutState.getItems();
            size = items.size();
            while (i5 < size) {
                FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem2 = (FadeInFadeOutAnimationItem) items.get(i5);
                final SnackbarData snackbarData6 = (SnackbarData) fadeInFadeOutAnimationItem2.component1();
                Function3 function3Component3 = fadeInFadeOutAnimationItem2.component2();
                composerStartRestartGroup.startMovableGroup(1201076541, snackbarData6);
                function3Component3.invoke(ComposableLambdaKt.rememberComposableLambda(-1135367807, true, new Function2() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        if ((i9 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1135367807, i9, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SnackbarHost.kt:395)");
                        }
                        Function3 function4 = function3;
                        SnackbarData snackbarData7 = snackbarData6;
                        Intrinsics.checkNotNull(snackbarData7);
                        function4.invoke(snackbarData7, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                composerStartRestartGroup.endMovableGroup();
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            if (i8 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1316639904, i3, -1, "androidx.compose.material3.FadeInFadeOutWithScale (SnackbarHost.kt:327)");
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new FadeInFadeOutState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            fadeInFadeOutState = (FadeInFadeOutState) objRememberedValue;
            composerStartRestartGroup.startReplaceGroup(-1256811491);
            if (!Intrinsics.areEqual(snackbarData2, fadeInFadeOutState.getCurrent())) {
                fadeInFadeOutState.setCurrent(snackbarData2);
                items2 = fadeInFadeOutState.getItems();
                arrayList = new ArrayList(items2.size());
                size2 = items2.size();
                while (i6 < size2) {
                    arrayList.add((SnackbarData) ((FadeInFadeOutAnimationItem) items2.get(i6)).getKey());
                }
                mutableList = CollectionsKt.toMutableList((Collection) arrayList);
                if (!mutableList.contains(snackbarData2)) {
                    mutableList.add(snackbarData2);
                }
                fadeInFadeOutState.getItems().clear();
                listFastFilterNotNull = ListUtilsKt.fastFilterNotNull(mutableList);
                items3 = fadeInFadeOutState.getItems();
                size3 = listFastFilterNotNull.size();
                i7 = 0;
                while (i7 < size3) {
                    final SnackbarData snackbarData7 = (SnackbarData) listFastFilterNotNull.get(i7);
                    items3.add(new FadeInFadeOutAnimationItem(snackbarData7, ComposableLambdaKt.rememberComposableLambda(-1654683077, true, new Function3() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((Function2) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Function2 function2, Composer composer2, int i9) {
                            int i10;
                            if ((i9 & 6) == 0) {
                                i10 = i9 | (composer2.changedInstance(function2) ? 4 : 2);
                            } else {
                                i10 = i9;
                            }
                            if ((i10 & 19) != 18 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1654683077, i10, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous> (SnackbarHost.kt:338)");
                                }
                                boolean zAreEqual = Intrinsics.areEqual(snackbarData7, snackbarData2);
                                int i11 = zAreEqual ? 150 : 75;
                                int i12 = (!zAreEqual || ListUtilsKt.fastFilterNotNull(mutableList).size() == 1) ? 0 : 75;
                                TweenSpec tweenSpecTween = AnimationSpecKt.tween(i11, i12, EasingKt.getLinearEasing());
                                boolean zChanged = composer2.changed(snackbarData7) | composer2.changedInstance(fadeInFadeOutState);
                                final SnackbarData snackbarData8 = snackbarData7;
                                final FadeInFadeOutState fadeInFadeOutState2 = fadeInFadeOutState;
                                Object objRememberedValue2 = composer2.rememberedValue();
                                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                    objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Object invoke() {
                                            m818invoke();
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                        public final void m818invoke() {
                                            if (Intrinsics.areEqual(snackbarData8, fadeInFadeOutState2.getCurrent())) {
                                                return;
                                            }
                                            List items4 = fadeInFadeOutState2.getItems();
                                            final SnackbarData snackbarData9 = snackbarData8;
                                            CollectionsKt.removeAll(items4, new Function1() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1$1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Boolean invoke(FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem3) {
                                                    return Boolean.valueOf(Intrinsics.areEqual(fadeInFadeOutAnimationItem3.getKey(), snackbarData9));
                                                }
                                            });
                                            RecomposeScope scope = fadeInFadeOutState2.getScope();
                                            if (scope != null) {
                                                scope.invalidate();
                                            }
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue2);
                                }
                                State stateAnimatedOpacity = SnackbarHostKt.animatedOpacity(tweenSpecTween, zAreEqual, (Function0) objRememberedValue2, composer2, 0, 0);
                                State stateAnimatedScale = SnackbarHostKt.animatedScale(AnimationSpecKt.tween(i11, i12, EasingKt.getFastOutSlowInEasing()), zAreEqual, composer2, 0);
                                Modifier modifierM1414graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m1414graphicsLayerAp8cVGQ$default(Modifier.Companion, ((Number) stateAnimatedScale.getValue()).floatValue(), ((Number) stateAnimatedScale.getValue()).floatValue(), ((Number) stateAnimatedOpacity.getValue()).floatValue(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131064, null);
                                boolean zChanged2 = composer2.changed(snackbarData7);
                                final SnackbarData snackbarData9 = snackbarData7;
                                Object objRememberedValue3 = composer2.rememberedValue();
                                if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$1$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((SemanticsPropertyReceiver) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            SemanticsPropertiesKt.m2115setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.Companion.m2094getPolite0phEisY());
                                            final SnackbarData snackbarData10 = snackbarData9;
                                            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$1$1.1
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    snackbarData10.dismiss();
                                                    return Boolean.TRUE;
                                                }
                                            }, 1, null);
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue3);
                                }
                                Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierM1414graphicsLayerAp8cVGQ$default, false, (Function1) objRememberedValue3, 1, null);
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierSemantics$default);
                                ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
                                Function0 constructor2 = companion3.getConstructor();
                                if (composer2.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor2);
                                } else {
                                    composer2.useNode();
                                }
                                Composer composerM1086constructorimpl2 = Updater.m1086constructorimpl(composer2);
                                Updater.m1088setimpl(composerM1086constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy3, companion3.getSetMeasurePolicy());
                                Updater.m1088setimpl(composerM1086constructorimpl2, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                                if (composerM1086constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM1086constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    composerM1086constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    composerM1086constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                Updater.m1088setimpl(composerM1086constructorimpl2, modifierMaterializeModifier3, companion3.getSetModifier());
                                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                                function2.invoke(composer2, Integer.valueOf(i10 & 14));
                                composer2.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54)));
                    i7++;
                    snackbarData2 = snackbarData;
                }
            }
            composerStartRestartGroup.endReplaceGroup();
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            constructor = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM1086constructorimpl = Updater.m1086constructorimpl(composerStartRestartGroup);
            Updater.m1088setimpl(composerM1086constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.m1088setimpl(composerM1086constructorimpl, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (!composerM1086constructorimpl.getInserting()) {
                composerM1086constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM1086constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM1086constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM1086constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1088setimpl(composerM1086constructorimpl, modifierMaterializeModifier3, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            fadeInFadeOutState.setScope(ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0));
            composerStartRestartGroup.startReplaceGroup(1748085441);
            items = fadeInFadeOutState.getItems();
            size = items.size();
            while (i5 < size) {
                FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem3 = (FadeInFadeOutAnimationItem) items.get(i5);
                final SnackbarData snackbarData8 = (SnackbarData) fadeInFadeOutAnimationItem3.component1();
                Function3 function3Component4 = fadeInFadeOutAnimationItem3.component2();
                composerStartRestartGroup.startMovableGroup(1201076541, snackbarData8);
                function3Component4.invoke(ComposableLambdaKt.rememberComposableLambda(-1135367807, true, new Function2() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        if ((i9 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1135367807, i9, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SnackbarHost.kt:395)");
                        }
                        Function3 function4 = function3;
                        SnackbarData snackbarData9 = snackbarData8;
                        Intrinsics.checkNotNull(snackbarData9);
                        function4.invoke(snackbarData9, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                composerStartRestartGroup.endMovableGroup();
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SnackbarHostKt.FadeInFadeOutWithScale.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i9) {
                    SnackbarHostKt.FadeInFadeOutWithScale(snackbarData, modifier5, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final State animatedOpacity(AnimationSpec animationSpec, boolean z, Function0 function0, Composer composer, int i, int i2) {
        if ((i2 & 4) != 0) {
            function0 = new Function0() { // from class: androidx.compose.material3.SnackbarHostKt.animatedOpacity.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m819invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m819invoke();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function1 = function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1431889134, i, -1, "androidx.compose.material3.animatedOpacity (SnackbarHost.kt:418)");
        }
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = AnimatableKt.Animatable$default(!z ? 1.0f : 0.0f, 0.0f, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        Animatable animatable = (Animatable) objRememberedValue;
        Boolean boolValueOf = Boolean.valueOf(z);
        boolean zChangedInstance = composer.changedInstance(animatable) | ((((i & 112) ^ 48) > 32 && composer.changed(z)) || (i & 48) == 32) | composer.changedInstance(animationSpec) | ((((i & 896) ^ 384) > 256 && composer.changed(function1)) || (i & 384) == 256);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
            Object snackbarHostKt$animatedOpacity$2$1 = new SnackbarHostKt$animatedOpacity$2$1(animatable, z, animationSpec, function1, null);
            composer.updateRememberedValue(snackbarHostKt$animatedOpacity$2$1);
            objRememberedValue2 = snackbarHostKt$animatedOpacity$2$1;
        }
        EffectsKt.LaunchedEffect(boolValueOf, (Function2) objRememberedValue2, composer, (i >> 3) & 14);
        State stateAsState = animatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateAsState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final State animatedScale(AnimationSpec animationSpec, boolean z, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1966809761, i, -1, "androidx.compose.material3.animatedScale (SnackbarHost.kt:428)");
        }
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = AnimatableKt.Animatable$default(!z ? 1.0f : 0.8f, 0.0f, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        Animatable animatable = (Animatable) objRememberedValue;
        Boolean boolValueOf = Boolean.valueOf(z);
        boolean zChangedInstance = composer.changedInstance(animatable) | ((((i & 112) ^ 48) > 32 && composer.changed(z)) || (i & 48) == 32) | composer.changedInstance(animationSpec);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new SnackbarHostKt$animatedScale$1$1(animatable, z, animationSpec, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        EffectsKt.LaunchedEffect(boolValueOf, (Function2) objRememberedValue2, composer, (i >> 3) & 14);
        State stateAsState = animatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateAsState;
    }
}
