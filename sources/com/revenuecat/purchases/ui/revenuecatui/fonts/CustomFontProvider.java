package com.revenuecat.purchases.ui.revenuecatui.fonts;

import androidx.compose.ui.text.font.FontFamily;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/fonts/CustomFontProvider;", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "(Landroidx/compose/ui/text/font/FontFamily;)V", "getFont", "type", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/TypographyType;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomFontProvider implements FontProvider {
    public static final int $stable = 0;
    private final FontFamily fontFamily;

    public CustomFontProvider(FontFamily fontFamily) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        this.fontFamily = fontFamily;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.fonts.FontProvider
    public FontFamily getFont(TypographyType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.fontFamily;
    }
}
