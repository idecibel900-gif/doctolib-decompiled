package com.revenuecat.purchases.ui.revenuecatui.components.stack;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$VerticalStackKt {
    public static final ComposableSingletons$VerticalStackKt INSTANCE = new ComposableSingletons$VerticalStackKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3 f58lambda1 = ComposableLambdaKt.composableLambdaInstance(-988616884, false, new Function3() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.ComposableSingletons$VerticalStackKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((ColumnScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ColumnScope columnScope, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(columnScope, "$this$null");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-988616884, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.ComposableSingletons$VerticalStackKt.lambda-1.<anonymous> (VerticalStack.kt:88)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function3 m4157getLambda1$revenuecatui_defaultsBc8Release() {
        return f58lambda1;
    }
}
