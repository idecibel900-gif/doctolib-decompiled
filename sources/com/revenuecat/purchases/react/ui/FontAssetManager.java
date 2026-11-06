package com.revenuecat.purchases.react.ui;

import android.content.res.AssetManager;
import androidx.compose.ui.text.font.AndroidFontKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import com.revenuecat.purchases.ui.revenuecatui.fonts.PaywallFont;
import com.revenuecat.purchases.ui.revenuecatui.fonts.PaywallFontFamily;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J>\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0014\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u0002H\u00150\u0017H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/revenuecat/purchases/react/ui/FontAssetManager;", "", "<init>", "()V", "fontFamilyCache", "", "", "Landroidx/compose/ui/text/font/FontFamily;", "paywallFontFamilyCache", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/PaywallFontFamily;", "FILE_EXTENSIONS", "", "[Ljava/lang/String;", "FONT_PATH", "getFontFamily", "fontFamilyName", "assetManager", "Landroid/content/res/AssetManager;", "getPaywallFontFamily", "getFontsInFamily", "", "T", "createFont", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/react/ui/FontAssetManager$FontStyleExtension;", "FontStyleExtension", "react-native-purchases-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FontAssetManager {
    private static final String FONT_PATH = "fonts/";
    public static final FontAssetManager INSTANCE = new FontAssetManager();
    private static Map<String, ? extends FontFamily> fontFamilyCache = MapsKt.emptyMap();
    private static Map<String, PaywallFontFamily> paywallFontFamilyCache = MapsKt.emptyMap();
    private static final String[] FILE_EXTENSIONS = {".ttf", ".otf"};

    private FontAssetManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'REGULAR' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0082\u0081\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/react/ui/FontAssetManager$FontStyleExtension;", "", "extension", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Landroidx/compose/ui/text/font/FontWeight;I)V", "getExtension", "()Ljava/lang/String;", "getWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getStyle-_-LCdwA", "()I", "I", "REGULAR", "BOLD", "ITALIC", "BOLD_ITALIC", "Companion", "react-native-purchases-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final class FontStyleExtension {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FontStyleExtension[] $VALUES;
        public static final FontStyleExtension BOLD;
        public static final FontStyleExtension BOLD_ITALIC;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final FontStyleExtension ITALIC;
        public static final FontStyleExtension REGULAR;
        private final String extension;
        private final int style;
        private final FontWeight weight;

        private static final /* synthetic */ FontStyleExtension[] $values() {
            return new FontStyleExtension[]{REGULAR, BOLD, ITALIC, BOLD_ITALIC};
        }

        public static EnumEntries getEntries() {
            return $ENTRIES;
        }

        private FontStyleExtension(String str, int i, String str2, FontWeight fontWeight, int i2) {
            super(str, i);
            this.extension = str2;
            this.weight = fontWeight;
            this.style = i2;
        }

        public final String getExtension() {
            return this.extension;
        }

        public final FontWeight getWeight() {
            return this.weight;
        }

        /* JADX INFO: renamed from: getStyle-_-LCdwA, reason: not valid java name and from getter */
        public final int getStyle() {
            return this.style;
        }

        static {
            FontWeight.Companion companion = FontWeight.Companion;
            FontWeight normal = companion.getNormal();
            FontStyle.Companion companion2 = FontStyle.Companion;
            REGULAR = new FontStyleExtension("REGULAR", 0, "", normal, companion2.m2289getNormal_LCdwA());
            BOLD = new FontStyleExtension("BOLD", 1, "_bold", companion.getBold(), companion2.m2289getNormal_LCdwA());
            ITALIC = new FontStyleExtension("ITALIC", 2, "_italic", companion.getNormal(), companion2.m2288getItalic_LCdwA());
            BOLD_ITALIC = new FontStyleExtension("BOLD_ITALIC", 3, "_bold_italic", companion.getBold(), companion2.m2288getItalic_LCdwA());
            FontStyleExtension[] fontStyleExtensionArr$values = $values();
            $VALUES = fontStyleExtensionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(fontStyleExtensionArr$values);
            INSTANCE = new Companion(null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/react/ui/FontAssetManager$FontStyleExtension$Companion;", "", "<init>", "()V", "possibleFileNames", "", "", "fontFamilyName", "react-native-purchases-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final List<String> possibleFileNames(String fontFamilyName) {
                Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
                FontStyleExtension[] fontStyleExtensionArrValues = FontStyleExtension.values();
                ArrayList arrayList = new ArrayList();
                for (FontStyleExtension fontStyleExtension : fontStyleExtensionArrValues) {
                    String[] strArr = FontAssetManager.FILE_EXTENSIONS;
                    ArrayList arrayList2 = new ArrayList(strArr.length);
                    for (String str : strArr) {
                        arrayList2.add(fontFamilyName + fontStyleExtension.getExtension() + str);
                    }
                    CollectionsKt.addAll(arrayList, arrayList2);
                }
                return arrayList;
            }
        }

        public static FontStyleExtension valueOf(String str) {
            return (FontStyleExtension) Enum.valueOf(FontStyleExtension.class, str);
        }

        public static FontStyleExtension[] values() {
            return (FontStyleExtension[]) $VALUES.clone();
        }
    }

    public final synchronized FontFamily getFontFamily(String fontFamilyName, final AssetManager assetManager) {
        FontFamily FontFamily;
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        FontFamily fontFamily = fontFamilyCache.get(fontFamilyName);
        if (fontFamily != null) {
            return fontFamily;
        }
        List fontsInFamily = getFontsInFamily(fontFamilyName, assetManager, new Function2() { // from class: com.revenuecat.purchases.react.ui.FontAssetManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FontAssetManager.getFontFamily$lambda$0(assetManager, (String) obj, (FontAssetManager.FontStyleExtension) obj2);
            }
        });
        if (fontsInFamily.isEmpty()) {
            FontFamily = null;
        } else {
            FontFamily = FontFamilyKt.FontFamily(fontsInFamily);
            fontFamilyCache = MapsKt.plus(fontFamilyCache, TuplesKt.to(fontFamilyName, FontFamily));
        }
        return FontFamily;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Font getFontFamily$lambda$0(AssetManager assetManager, String fileName, FontStyleExtension styleExtension) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(styleExtension, "styleExtension");
        return AndroidFontKt.m2252FontMuC2MFs$default(FONT_PATH + fileName, assetManager, styleExtension.getWeight(), styleExtension.getStyle(), null, 16, null);
    }

    public final synchronized PaywallFontFamily getPaywallFontFamily(String fontFamilyName, AssetManager assetManager) {
        PaywallFontFamily paywallFontFamily;
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        PaywallFontFamily paywallFontFamily2 = paywallFontFamilyCache.get(fontFamilyName);
        if (paywallFontFamily2 != null) {
            return paywallFontFamily2;
        }
        List fontsInFamily = getFontsInFamily(fontFamilyName, assetManager, new Function2() { // from class: com.revenuecat.purchases.react.ui.FontAssetManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FontAssetManager.getPaywallFontFamily$lambda$1((String) obj, (FontAssetManager.FontStyleExtension) obj2);
            }
        });
        if (fontsInFamily.isEmpty()) {
            paywallFontFamily = null;
        } else {
            paywallFontFamily = new PaywallFontFamily(fontsInFamily);
            paywallFontFamilyCache = MapsKt.plus(paywallFontFamilyCache, TuplesKt.to(fontFamilyName, paywallFontFamily));
        }
        return paywallFontFamily;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PaywallFont.AssetFont getPaywallFontFamily$lambda$1(String fileName, FontStyleExtension styleExtension) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(styleExtension, "styleExtension");
        return new PaywallFont.AssetFont(FONT_PATH + fileName, styleExtension.getWeight(), styleExtension.getStyle());
    }

    private final <T> List<T> getFontsInFamily(String fontFamilyName, AssetManager assetManager, Function2 createFont) throws IOException {
        List listEmptyList;
        String[] list = assetManager.list(FONT_PATH);
        if (list == null || (listEmptyList = ArraysKt.toList(list)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (FontStyleExtension fontStyleExtension : FontStyleExtension.values()) {
            for (String str : FILE_EXTENSIONS) {
                Object obj = fontFamilyName + fontStyleExtension.getExtension() + str;
                if (listEmptyList.contains(obj)) {
                    arrayList.add(createFont.invoke(obj, fontStyleExtension));
                }
            }
        }
        return arrayList;
    }
}
