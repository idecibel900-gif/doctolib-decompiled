package com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$RestorePurchasesDialogKt {
    public static final ComposableSingletons$RestorePurchasesDialogKt INSTANCE = new ComposableSingletons$RestorePurchasesDialogKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2 f70lambda1 = ComposableLambdaKt.composableLambdaInstance(375690679, false, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.ComposableSingletons$RestorePurchasesDialogKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(375690679, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.ComposableSingletons$RestorePurchasesDialogKt.lambda-1.<anonymous> (RestorePurchasesDialog.kt:70)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2 f71lambda2 = ComposableLambdaKt.composableLambdaInstance(246978940, false, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.ComposableSingletons$RestorePurchasesDialogKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(246978940, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.ComposableSingletons$RestorePurchasesDialogKt.lambda-2.<anonymous> (RestorePurchasesDialog.kt:62)");
                }
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.Companion.getCenterHorizontally(), composer, 54);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
                Updater.m1088setimpl(composerM1086constructorimpl, measurePolicyColumnMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1088setimpl(composerM1086constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (composerM1086constructorimpl.getInserting() || !Intrinsics.areEqual(composerM1086constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM1086constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM1086constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1088setimpl(composerM1086constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ProgressIndicatorKt.m803CircularProgressIndicatorLxG7B9w(null, 0L, 0.0f, 0L, 0, composer, 0, 31);
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
    public final Function2 m4350getLambda1$revenuecatui_defaultsBc8Release() {
        return f70lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function2 m4351getLambda2$revenuecatui_defaultsBc8Release() {
        return f71lambda2;
    }
}
