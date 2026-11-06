package com.revenuecat.purchases.ui.revenuecatui.components.ktx;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.revenuecat.purchases.paywalls.components.properties.ImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"urlsForCurrentTheme", "Lcom/revenuecat/purchases/paywalls/components/properties/ImageUrls;", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "getUrlsForCurrentTheme", "(Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/paywalls/components/properties/ImageUrls;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class ThemeImageUrlsKt {
    public static final ImageUrls getUrlsForCurrentTheme(ThemeImageUrls themeImageUrls, Composer composer, int i) {
        ImageUrls light;
        Intrinsics.checkNotNullParameter(themeImageUrls, "<this>");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(154958320, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.ktx.<get-urlsForCurrentTheme> (ThemeImageUrls.kt:12)");
        }
        if (!DarkThemeKt.isSystemInDarkTheme(composer, 0) || (light = themeImageUrls.getDark()) == null) {
            light = themeImageUrls.getLight();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return light;
    }
}
