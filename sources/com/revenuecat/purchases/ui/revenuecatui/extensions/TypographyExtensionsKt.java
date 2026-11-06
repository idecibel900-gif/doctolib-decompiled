package com.revenuecat.purchases.ui.revenuecatui.extensions;

import androidx.compose.material3.Typography;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import com.revenuecat.purchases.ui.revenuecatui.fonts.FontProvider;
import com.revenuecat.purchases.ui.revenuecatui.fonts.TypographyType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\b"}, d2 = {"copyWithFontProvider", "Landroidx/compose/material3/Typography;", "fontProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "modifyFontIfNeeded", "Landroidx/compose/ui/text/TextStyle;", "typographyType", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/TypographyType;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TypographyExtensionsKt {
    public static final Typography copyWithFontProvider(Typography typography, FontProvider fontProvider) {
        Intrinsics.checkNotNullParameter(typography, "<this>");
        Intrinsics.checkNotNullParameter(fontProvider, "fontProvider");
        return typography.copy(modifyFontIfNeeded(typography.getDisplayLarge(), TypographyType.DISPLAY_LARGE, fontProvider), modifyFontIfNeeded(typography.getDisplayMedium(), TypographyType.DISPLAY_MEDIUM, fontProvider), modifyFontIfNeeded(typography.getDisplaySmall(), TypographyType.DISPLAY_SMALL, fontProvider), modifyFontIfNeeded(typography.getHeadlineLarge(), TypographyType.HEADLINE_LARGE, fontProvider), modifyFontIfNeeded(typography.getHeadlineMedium(), TypographyType.HEADLINE_MEDIUM, fontProvider), modifyFontIfNeeded(typography.getHeadlineSmall(), TypographyType.HEADLINE_SMALL, fontProvider), modifyFontIfNeeded(typography.getTitleLarge(), TypographyType.TITLE_LARGE, fontProvider), modifyFontIfNeeded(typography.getTitleMedium(), TypographyType.TITLE_MEDIUM, fontProvider), modifyFontIfNeeded(typography.getTitleSmall(), TypographyType.TITLE_SMALL, fontProvider), modifyFontIfNeeded(typography.getBodyLarge(), TypographyType.BODY_LARGE, fontProvider), modifyFontIfNeeded(typography.getBodyMedium(), TypographyType.BODY_MEDIUM, fontProvider), modifyFontIfNeeded(typography.getBodySmall(), TypographyType.BODY_SMALL, fontProvider), modifyFontIfNeeded(typography.getLabelLarge(), TypographyType.LABEL_LARGE, fontProvider), modifyFontIfNeeded(typography.getLabelMedium(), TypographyType.LABEL_MEDIUM, fontProvider), modifyFontIfNeeded(typography.getLabelSmall(), TypographyType.LABEL_SMALL, fontProvider));
    }

    private static final TextStyle modifyFontIfNeeded(TextStyle textStyle, TypographyType typographyType, FontProvider fontProvider) {
        FontFamily font = fontProvider.getFont(typographyType);
        return font == null ? textStyle : TextStyle.m2226copyp1EtxEg$default(textStyle, 0L, 0L, null, null, null, font, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777183, null);
    }
}
