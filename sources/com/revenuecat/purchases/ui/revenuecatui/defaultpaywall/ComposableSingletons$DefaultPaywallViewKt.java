package com.revenuecat.purchases.ui.revenuecatui.defaultpaywall;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$DefaultPaywallViewKt {
    public static final ComposableSingletons$DefaultPaywallViewKt INSTANCE = new ComposableSingletons$DefaultPaywallViewKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3 f82lambda1 = ComposableLambdaKt.composableLambdaInstance(619696328, false, new Function3() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.ComposableSingletons$DefaultPaywallViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((LazyItemScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(619696328, i, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.ComposableSingletons$DefaultPaywallViewKt.lambda-1.<anonymous> (DefaultPaywallView.kt:228)");
            }
            SpacerKt.Spacer(SizeKt.m324height3ABfNKs(Modifier.Companion, Dp.m2551constructorimpl(16)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function3 f83lambda2 = ComposableLambdaKt.composableLambdaInstance(-1207225124, false, new Function3() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.ComposableSingletons$DefaultPaywallViewKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((i & 17) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1207225124, i, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.ComposableSingletons$DefaultPaywallViewKt.lambda-2.<anonymous> (DefaultPaywallView.kt:272)");
                }
                TextKt.m852Text4IGK_g(StringResources_androidKt.stringResource(R.string.revenuecatui_purchase, composer, 0), null, 0L, 0L, null, FontWeight.Companion.getBold(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 196608, 0, 131038);
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
    public static Function3 f84lambda3 = ComposableLambdaKt.composableLambdaInstance(-1536372177, false, new Function3() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.ComposableSingletons$DefaultPaywallViewKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1536372177, i, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.ComposableSingletons$DefaultPaywallViewKt.lambda-3.<anonymous> (DefaultPaywallView.kt:286)");
            }
            TextKt.m852Text4IGK_g(StringResources_androidKt.stringResource(R.string.revenuecatui_restore_purchases, composer, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function3 m4457getLambda1$revenuecatui_defaultsBc8Release() {
        return f82lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function3 m4458getLambda2$revenuecatui_defaultsBc8Release() {
        return f83lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function3 m4459getLambda3$revenuecatui_defaultsBc8Release() {
        return f84lambda3;
    }
}
