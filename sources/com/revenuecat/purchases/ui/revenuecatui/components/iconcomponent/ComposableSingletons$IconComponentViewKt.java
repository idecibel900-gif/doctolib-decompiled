package com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
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
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$IconComponentViewKt {
    public static final ComposableSingletons$IconComponentViewKt INSTANCE = new ComposableSingletons$IconComponentViewKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2 f55lambda1 = ComposableLambdaKt.composableLambdaInstance(-994446119, false, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.ComposableSingletons$IconComponentViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-994446119, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.ComposableSingletons$IconComponentViewKt.lambda-1.<anonymous> (IconComponentView.kt:90)");
                }
                Modifier modifierM116backgroundbw27NRU$default = BackgroundKt.m116backgroundbw27NRU$default(Modifier.Companion, Color.Companion.m1382getLightGray0d7_KjU(), null, 2, null);
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
                IconComponentViewKt.IconComponentView(PreviewHelpersKt.previewIconComponentStyle(new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fixed(200, null)), false, null, null, null, null, null, null, null, composer, 6, 510), PreviewHelpersKt.previewEmptyState(null, composer, 0, 1), null, composer, 0, 4);
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
    public static Function2 f56lambda2 = ComposableLambdaKt.composableLambdaInstance(-1847956518, false, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.ComposableSingletons$IconComponentViewKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1847956518, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.ComposableSingletons$IconComponentViewKt.lambda-2.<anonymous> (IconComponentView.kt:109)");
                }
                Modifier modifierM116backgroundbw27NRU$default = BackgroundKt.m116backgroundbw27NRU$default(Modifier.Companion, Color.Companion.m1382getLightGray0d7_KjU(), null, 2, null);
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
                IconComponentViewKt.IconComponentView(PreviewHelpersKt.previewIconComponentStyle(new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fixed(200, null)), false, null, null, null, PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(100)), null, null, null, composer, 196614, 478), PreviewHelpersKt.previewEmptyState(null, composer, 0, 1), null, composer, 0, 4);
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
    public final Function2 m4068getLambda1$revenuecatui_defaultsBc8Release() {
        return f55lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function2 m4069getLambda2$revenuecatui_defaultsBc8Release() {
        return f56lambda2;
    }
}
