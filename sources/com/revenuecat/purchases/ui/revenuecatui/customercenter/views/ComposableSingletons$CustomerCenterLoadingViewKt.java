package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$CustomerCenterLoadingViewKt {
    public static final ComposableSingletons$CustomerCenterLoadingViewKt INSTANCE = new ComposableSingletons$CustomerCenterLoadingViewKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2 f74lambda1 = ComposableLambdaKt.composableLambdaInstance(-938846909, false, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$CustomerCenterLoadingViewKt$lambda-1$1
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
                ComposerKt.traceEventStart(-938846909, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$CustomerCenterLoadingViewKt.lambda-1.<anonymous> (CustomerCenterLoadingView.kt:164)");
            }
            CustomerCenterLoadingViewKt.CustomerCenterLoadingView(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function2 m4373getLambda1$revenuecatui_defaultsBc8Release() {
        return f74lambda1;
    }
}
