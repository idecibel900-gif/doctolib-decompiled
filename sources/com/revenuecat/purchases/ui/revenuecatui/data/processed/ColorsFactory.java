package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.paywalls.PaywallData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/ColorsFactory;", "", "()V", "create", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;", "paywallDataColors", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ColorsFactory {
    public static final int $stable = 0;
    public static final ColorsFactory INSTANCE = new ColorsFactory();

    private ColorsFactory() {
    }

    public final TemplateConfiguration.Colors create(PaywallData.Configuration.Colors paywallDataColors) {
        Intrinsics.checkNotNullParameter(paywallDataColors, "paywallDataColors");
        int colorInt = paywallDataColors.getBackground().getColorInt();
        int colorInt2 = paywallDataColors.getText1().getColorInt();
        PaywallColor text2 = paywallDataColors.getText2();
        int colorInt3 = text2 != null ? text2.getColorInt() : colorInt2;
        PaywallColor text3 = paywallDataColors.getText3();
        int colorInt4 = text3 != null ? text3.getColorInt() : colorInt3;
        int colorInt5 = paywallDataColors.getCallToActionBackground().getColorInt();
        int colorInt6 = paywallDataColors.getCallToActionForeground().getColorInt();
        PaywallColor callToActionSecondaryBackground = paywallDataColors.getCallToActionSecondaryBackground();
        Integer numValueOf = callToActionSecondaryBackground != null ? Integer.valueOf(callToActionSecondaryBackground.getColorInt()) : null;
        PaywallColor accent1 = paywallDataColors.getAccent1();
        int colorInt7 = accent1 != null ? accent1.getColorInt() : colorInt6;
        PaywallColor accent2 = paywallDataColors.getAccent2();
        int colorInt8 = accent2 != null ? accent2.getColorInt() : colorInt7;
        PaywallColor accent3 = paywallDataColors.getAccent3();
        int colorInt9 = accent3 != null ? accent3.getColorInt() : colorInt8;
        PaywallColor closeButton = paywallDataColors.getCloseButton();
        Integer numValueOf2 = closeButton != null ? Integer.valueOf(closeButton.getColorInt()) : null;
        PaywallColor tierControlBackground = paywallDataColors.getTierControlBackground();
        Integer numValueOf3 = tierControlBackground != null ? Integer.valueOf(tierControlBackground.getColorInt()) : null;
        PaywallColor tierControlForeground = paywallDataColors.getTierControlForeground();
        Integer numValueOf4 = tierControlForeground != null ? Integer.valueOf(tierControlForeground.getColorInt()) : null;
        PaywallColor tierControlSelectedBackground = paywallDataColors.getTierControlSelectedBackground();
        Integer numValueOf5 = tierControlSelectedBackground != null ? Integer.valueOf(tierControlSelectedBackground.getColorInt()) : null;
        PaywallColor tierControlSelectedForeground = paywallDataColors.getTierControlSelectedForeground();
        Integer numValueOf6 = tierControlSelectedForeground != null ? Integer.valueOf(tierControlSelectedForeground.getColorInt()) : null;
        return new TemplateConfiguration.Colors(ColorKt.Color(colorInt), ColorKt.Color(colorInt2), ColorKt.Color(colorInt3), ColorKt.Color(colorInt4), ColorKt.Color(colorInt5), ColorKt.Color(colorInt6), numValueOf != null ? Color.m1361boximpl(ColorKt.Color(numValueOf.intValue())) : null, ColorKt.Color(colorInt7), ColorKt.Color(colorInt8), ColorKt.Color(colorInt9), numValueOf2 != null ? Color.m1361boximpl(ColorKt.Color(numValueOf2.intValue())) : null, numValueOf3 != null ? Color.m1361boximpl(ColorKt.Color(numValueOf3.intValue())) : null, numValueOf4 != null ? Color.m1361boximpl(ColorKt.Color(numValueOf4.intValue())) : null, numValueOf5 != null ? Color.m1361boximpl(ColorKt.Color(numValueOf5.intValue())) : null, numValueOf6 != null ? Color.m1361boximpl(ColorKt.Color(numValueOf6.intValue())) : null, null);
    }
}
