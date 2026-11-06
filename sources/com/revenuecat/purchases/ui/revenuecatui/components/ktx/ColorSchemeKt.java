package com.revenuecat.purchases.ui.revenuecatui.components.ktx;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"colorsForCurrentTheme", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "getColorsForCurrentTheme", "(Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class ColorSchemeKt {
    public static final /* synthetic */ ColorInfo getColorsForCurrentTheme(ColorScheme colorScheme, Composer composer, int i) {
        ColorInfo light;
        Intrinsics.checkNotNullParameter(colorScheme, "<this>");
        composer.startReplaceGroup(1507855460);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1507855460, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.ktx.<get-colorsForCurrentTheme> (ColorScheme.kt:11)");
        }
        if (!DarkThemeKt.isSystemInDarkTheme(composer, 0) || (light = colorScheme.getDark()) == null) {
            light = colorScheme.getLight();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return light;
    }
}
