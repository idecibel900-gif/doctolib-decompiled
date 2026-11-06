package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$CustomerCenterErrorViewKt {
    public static final ComposableSingletons$CustomerCenterErrorViewKt INSTANCE = new ComposableSingletons$CustomerCenterErrorViewKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2 f73lambda1 = ComposableLambdaKt.composableLambdaInstance(-1516678677, false, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$CustomerCenterErrorViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1516678677, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$CustomerCenterErrorViewKt.lambda-1.<anonymous> (CustomerCenterErrorView.kt:23)");
                }
                CustomerCenterErrorViewKt.CustomerCenterErrorView(new CustomerCenterState.Error(new PurchasesError(PurchasesErrorCode.UnknownError, "Mock error")), composer, 0);
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
    public final Function2 m4372getLambda1$revenuecatui_defaultsBc8Release() {
        return f73lambda1;
    }
}
