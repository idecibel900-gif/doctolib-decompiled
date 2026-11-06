package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import com.revenuecat.purchases.ui.revenuecatui.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$ErrorDialogKt {
    public static final ComposableSingletons$ErrorDialogKt INSTANCE = new ComposableSingletons$ErrorDialogKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3 f65lambda1 = ComposableLambdaKt.composableLambdaInstance(1324687321, false, new Function3() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.ComposableSingletons$ErrorDialogKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            if ((i & 17) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1324687321, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.ComposableSingletons$ErrorDialogKt.lambda-1.<anonymous> (ErrorDialog.kt:25)");
                }
                TextKt.m852Text4IGK_g(StringResources_androidKt.stringResource(R.string.OK, composer, 0), null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2474boximpl(TextAlign.Companion.m2481getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer, 0, 0, 130558);
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
    public static Function2 f66lambda2 = ComposableLambdaKt.composableLambdaInstance(-1820821153, false, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.ComposableSingletons$ErrorDialogKt$lambda-2$1
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
                ComposerKt.traceEventStart(-1820821153, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.ComposableSingletons$ErrorDialogKt.lambda-2.<anonymous> (ErrorDialog.kt:31)");
            }
            IconKt.m786Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.error, composer, 0), (String) null, (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function3 m4228getLambda1$revenuecatui_defaultsBc8Release() {
        return f65lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function2 m4229getLambda2$revenuecatui_defaultsBc8Release() {
        return f66lambda2;
    }
}
