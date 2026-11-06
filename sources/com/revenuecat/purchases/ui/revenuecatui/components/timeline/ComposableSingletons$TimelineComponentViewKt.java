package com.revenuecat.purchases.ui.revenuecatui.components.timeline;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$TimelineComponentViewKt {
    public static final ComposableSingletons$TimelineComponentViewKt INSTANCE = new ComposableSingletons$TimelineComponentViewKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2 f62lambda1 = ComposableLambdaKt.composableLambdaInstance(-1193220131, false, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.ComposableSingletons$TimelineComponentViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1193220131, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.ComposableSingletons$TimelineComponentViewKt.lambda-1.<anonymous> (TimelineComponentView.kt:216)");
                }
                Modifier modifierM116backgroundbw27NRU$default = BackgroundKt.m116backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Color.Companion.m1386getWhite0d7_KjU(), null, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM116backgroundbw27NRU$default);
                ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                Function0 constructor = companion.getConstructor();
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer composerM1086constructorimpl = Updater.m1086constructorimpl(composer);
                Updater.m1088setimpl(composerM1086constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1088setimpl(composerM1086constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (composerM1086constructorimpl.getInserting() || !Intrinsics.areEqual(composerM1086constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM1086constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM1086constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1088setimpl(composerM1086constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                TimelineComponentViewKt.TimelineComponentView(TimelineComponentViewKt.previewStyle(0, 0, 0, TimelineComponent.IconAlignment.Title, false, null, null, null, null, composer, 3072, 503), PreviewHelpersKt.previewEmptyState(null, composer, 0, 1), null, composer, 0, 4);
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2 f63lambda2 = ComposableLambdaKt.composableLambdaInstance(490589432, false, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.ComposableSingletons$TimelineComponentViewKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(490589432, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.ComposableSingletons$TimelineComponentViewKt.lambda-2.<anonymous> (TimelineComponentView.kt:229)");
                }
                Modifier modifierM116backgroundbw27NRU$default = BackgroundKt.m116backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Color.Companion.m1386getWhite0d7_KjU(), null, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM116backgroundbw27NRU$default);
                ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                Function0 constructor = companion.getConstructor();
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer composerM1086constructorimpl = Updater.m1086constructorimpl(composer);
                Updater.m1088setimpl(composerM1086constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1088setimpl(composerM1086constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (composerM1086constructorimpl.getInserting() || !Intrinsics.areEqual(composerM1086constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM1086constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM1086constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1088setimpl(composerM1086constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                TimelineComponentViewKt.TimelineComponentView(TimelineComponentViewKt.previewStyle(0, 0, 0, TimelineComponent.IconAlignment.TitleAndDescription, false, null, null, null, null, composer, 3072, 503), PreviewHelpersKt.previewEmptyState(null, composer, 0, 1), null, composer, 0, 4);
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2 f64lambda3 = ComposableLambdaKt.composableLambdaInstance(-307258215, false, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.ComposableSingletons$TimelineComponentViewKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-307258215, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.ComposableSingletons$TimelineComponentViewKt.lambda-3.<anonymous> (TimelineComponentView.kt:242)");
                }
                Modifier modifierM116backgroundbw27NRU$default = BackgroundKt.m116backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Color.Companion.m1386getWhite0d7_KjU(), null, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM116backgroundbw27NRU$default);
                ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                Function0 constructor = companion.getConstructor();
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer composerM1086constructorimpl = Updater.m1086constructorimpl(composer);
                Updater.m1088setimpl(composerM1086constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1088setimpl(composerM1086constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (composerM1086constructorimpl.getInserting() || !Intrinsics.areEqual(composerM1086constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM1086constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM1086constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1088setimpl(composerM1086constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                float f = 0;
                float f2 = 12;
                TimelineComponentViewKt.TimelineComponentView(TimelineComponentViewKt.previewStyle(0, 0, 0, TimelineComponent.IconAlignment.TitleAndDescription, false, null, null, null, TimelineComponentViewKt.previewItems(PaddingKt.m308PaddingValuesa9UjIt4(Dp.m2551constructorimpl(f), Dp.m2551constructorimpl(f2), Dp.m2551constructorimpl(f), Dp.m2551constructorimpl(f2)), composer, 6, 0), composer, 3072, 247), PreviewHelpersKt.previewEmptyState(null, composer, 0, 1), null, composer, 0, 4);
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: getLambda-1$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function2 m4204getLambda1$revenuecatui_defaultsBc8Release() {
        return f62lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function2 m4205getLambda2$revenuecatui_defaultsBc8Release() {
        return f63lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function2 m4206getLambda3$revenuecatui_defaultsBc8Release() {
        return f64lambda3;
    }
}
