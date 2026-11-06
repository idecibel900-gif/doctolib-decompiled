package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$SimpleBottomSheetScaffoldKt {
    public static final ComposableSingletons$SimpleBottomSheetScaffoldKt INSTANCE = new ComposableSingletons$SimpleBottomSheetScaffoldKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2 f67lambda1 = ComposableLambdaKt.composableLambdaInstance(135206562, false, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.ComposableSingletons$SimpleBottomSheetScaffoldKt$lambda-1$1
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
                ComposerKt.traceEventStart(135206562, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.ComposableSingletons$SimpleBottomSheetScaffoldKt.lambda-1.<anonymous> (SimpleBottomSheetScaffold.kt:75)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2 f68lambda2 = ComposableLambdaKt.composableLambdaInstance(1371851491, false, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.ComposableSingletons$SimpleBottomSheetScaffoldKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1371851491, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.ComposableSingletons$SimpleBottomSheetScaffoldKt.lambda-2.<anonymous> (SimpleBottomSheetScaffold.kt:152)");
                }
                float f = 16;
                Modifier modifierM310padding3ABfNKs = PaddingKt.m310padding3ABfNKs(BackgroundKt.m115backgroundbw27NRU(Modifier.Companion, Color.Companion.m1386getWhite0d7_KjU(), RoundedCornerShapeKt.m461RoundedCornerShapea9UjIt4$default(Dp.m2551constructorimpl(f), Dp.m2551constructorimpl(f), 0.0f, 0.0f, 12, null)), Dp.m2551constructorimpl(f));
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM310padding3ABfNKs);
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
                TextKt.m852Text4IGK_g("Hello from my bottom sheet", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 131070);
                TextKt.m852Text4IGK_g("It's beautiful, isn't it?", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 131070);
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
    public static Function2 f69lambda3 = ComposableLambdaKt.composableLambdaInstance(1748816107, false, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.ComposableSingletons$SimpleBottomSheetScaffoldKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1748816107, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.ComposableSingletons$SimpleBottomSheetScaffoldKt.lambda-3.<anonymous> (SimpleBottomSheetScaffold.kt:177)");
                }
                Modifier modifierM116backgroundbw27NRU$default = BackgroundKt.m116backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), Color.Companion.m1377getBlue0d7_KjU(), null, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
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
                TextKt.m852Text4IGK_g("Hello from my main content", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 131070);
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
    public final Function2 m4230getLambda1$revenuecatui_defaultsBc8Release() {
        return f67lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function2 m4231getLambda2$revenuecatui_defaultsBc8Release() {
        return f68lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function2 m4232getLambda3$revenuecatui_defaultsBc8Release() {
        return f69lambda3;
    }
}
