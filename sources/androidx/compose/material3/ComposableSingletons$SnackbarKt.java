package androidx.compose.material3;

import androidx.compose.material.icons.Icons$Filled;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes.dex */
public final class ComposableSingletons$SnackbarKt {
    public static final ComposableSingletons$SnackbarKt INSTANCE = new ComposableSingletons$SnackbarKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2 f28lambda1 = ComposableLambdaKt.composableLambdaInstance(-505750804, false, new Function2() { // from class: androidx.compose.material3.ComposableSingletons$SnackbarKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-505750804, i, -1, "androidx.compose.material3.ComposableSingletons$SnackbarKt.lambda-1.<anonymous> (Snackbar.kt:231)");
                }
                ImageVector close = CloseKt.getClose(Icons$Filled.INSTANCE);
                Strings.Companion companion = Strings.Companion;
                IconKt.m787Iconww6aTOc(close, Strings_androidKt.m866getString2EP1pXo(Strings.m865constructorimpl(R$string.m3c_snackbar_dismiss), composer, 0), (Modifier) null, 0L, composer, 0, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: getLambda-1$material3_release, reason: not valid java name */
    public final Function2 m771getLambda1$material3_release() {
        return f28lambda1;
    }
}
