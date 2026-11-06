package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/FooterConstants;", "", "()V", "style", "Landroidx/compose/ui/text/TextStyle;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextStyle;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FooterConstants {
    public static final FooterConstants INSTANCE = new FooterConstants();

    private FooterConstants() {
    }

    public final TextStyle style(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2026212701, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.FooterConstants.style (Footer.kt:283)");
        }
        TextStyle bodySmall = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return bodySmall;
    }
}
