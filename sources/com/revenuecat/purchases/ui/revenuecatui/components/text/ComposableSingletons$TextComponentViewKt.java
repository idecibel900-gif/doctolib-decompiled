package com.revenuecat.purchases.ui.revenuecatui.components.text;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$TextComponentViewKt {
    public static final ComposableSingletons$TextComponentViewKt INSTANCE = new ComposableSingletons$TextComponentViewKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2 f60lambda1 = ComposableLambdaKt.composableLambdaInstance(765510784, false, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.ComposableSingletons$TextComponentViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(765510784, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.ComposableSingletons$TextComponentViewKt.lambda-1.<anonymous> (TextComponentView.kt:206)");
                }
                TextComponentViewKt.TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Experience Pro today!", new ColorStyles(ColorStyle.Solid.m4126boximpl(ColorStyle.Solid.m4127constructorimpl(Color.Companion.m1376getBlack0d7_KjU())), null, 2, null), 34, FontWeight.EXTRA_BOLD, null, null, null, null, false, null, null, null, null, null, null, null, 65520, null), PreviewHelpersKt.previewEmptyState(null, composer, 0, 1), null, null, composer, 0, 12);
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
    public static Function2 f61lambda2 = ComposableLambdaKt.composableLambdaInstance(55915153, false, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.ComposableSingletons$TextComponentViewKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(55915153, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.ComposableSingletons$TextComponentViewKt.lambda-2.<anonymous> (TextComponentView.kt:205)");
                }
                TextKt.ProvideTextStyle(TextStyle.m2226copyp1EtxEg$default((TextStyle) composer.consume(TextKt.getLocalTextStyle()), Color.Companion.m1377getBlue0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), ComposableSingletons$TextComponentViewKt.INSTANCE.m4197getLambda1$revenuecatui_defaultsBc8Release(), composer, 48);
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
    public final Function2 m4197getLambda1$revenuecatui_defaultsBc8Release() {
        return f60lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function2 m4198getLambda2$revenuecatui_defaultsBc8Release() {
        return f61lambda2;
    }
}
