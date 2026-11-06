package com.revenuecat.purchases.ui.revenuecatui.templates;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$Template1Kt {
    public static final ComposableSingletons$Template1Kt INSTANCE = new ComposableSingletons$Template1Kt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2 f85lambda1 = ComposableLambdaKt.composableLambdaInstance(928009455, false, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.ComposableSingletons$Template1Kt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(928009455, i, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.ComposableSingletons$Template1Kt.lambda-1.<anonymous> (Template1.kt:258)");
                }
                BoxKt.Box(SizeKt.fillMaxHeight(SizeKt.fillMaxWidth$default(BackgroundKt.m116backgroundbw27NRU$default(Modifier.Companion, Color.Companion.m1377getBlue0d7_KjU(), null, 2, null), 0.0f, 1, null), 0.5f), composer, 6);
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
    public final Function2 m4525getLambda1$revenuecatui_defaultsBc8Release() {
        return f85lambda1;
    }
}
