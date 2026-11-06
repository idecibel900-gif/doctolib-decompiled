package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SnackbarData;
import androidx.compose.material3.SnackbarKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$CreateSupportTicketViewKt {
    public static final ComposableSingletons$CreateSupportTicketViewKt INSTANCE = new ComposableSingletons$CreateSupportTicketViewKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3 f72lambda1 = ComposableLambdaKt.composableLambdaInstance(-1015639048, false, new Function3() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$CreateSupportTicketViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((SnackbarData) obj, (Composer) obj2, ((Number) obj3).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(SnackbarData snackbarData, Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(snackbarData, "snackbarData");
            if ((i & 6) == 0) {
                i2 = i | (composer.changed(snackbarData) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) != 18 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1015639048, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$CreateSupportTicketViewKt.lambda-1.<anonymous> (CreateSupportTicketView.kt:361)");
                }
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i3 = MaterialTheme.$stable;
                SnackbarKt.m823SnackbarsDKtq54(snackbarData, null, false, null, materialTheme.getColorScheme(composer, i3).m718getErrorContainer0d7_KjU(), materialTheme.getColorScheme(composer, i3).m724getOnErrorContainer0d7_KjU(), 0L, 0L, 0L, composer, i2 & 14, 462);
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
    public final Function3 m4371getLambda1$revenuecatui_defaultsBc8Release() {
        return f72lambda1;
    }
}
