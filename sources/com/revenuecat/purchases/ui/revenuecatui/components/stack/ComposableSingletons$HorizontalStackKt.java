package com.revenuecat.purchases.ui.revenuecatui.components.stack;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$HorizontalStackKt {
    public static final ComposableSingletons$HorizontalStackKt INSTANCE = new ComposableSingletons$HorizontalStackKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3 f57lambda1 = ComposableLambdaKt.composableLambdaInstance(-1840009934, false, new Function3() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.ComposableSingletons$HorizontalStackKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope rowScope, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(rowScope, "$this$null");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1840009934, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.ComposableSingletons$HorizontalStackKt.lambda-1.<anonymous> (HorizontalStack.kt:88)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function3 m4156getLambda1$revenuecatui_defaultsBc8Release() {
        return f57lambda1;
    }
}
