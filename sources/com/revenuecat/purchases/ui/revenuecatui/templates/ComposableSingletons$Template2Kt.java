package com.revenuecat.purchases.ui.revenuecatui.templates;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.revenuecat.purchases.ui.revenuecatui.UIConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$Template2Kt {
    public static final ComposableSingletons$Template2Kt INSTANCE = new ComposableSingletons$Template2Kt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3 f86lambda1 = ComposableLambdaKt.composableLambdaInstance(-1707838296, false, new Function3() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.ComposableSingletons$Template2Kt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1707838296, i, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.ComposableSingletons$Template2Kt.lambda-1.<anonymous> (Template2.kt:115)");
            }
            SpacerKt.Spacer(SizeKt.m324height3ABfNKs(Modifier.Companion, UIConstant.INSTANCE.m4043getDefaultVerticalSpacingD9Ej5fM()), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function3 m4526getLambda1$revenuecatui_defaultsBc8Release() {
        return f86lambda1;
    }
}
