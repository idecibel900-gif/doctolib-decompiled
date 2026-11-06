package com.revenuecat.purchases.ui.revenuecatui.utils;

import android.content.res.XmlResourceParser;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001b\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00162\u0006\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/utils/FontFamilyXmlParser;", "", "()V", "ANDROID_NAMESPACE", "", "APP_NAMESPACE", "DEFAULT_FONT_WEIGHT", "", "UNRECOGNIZED_VALUE", "getFontResourceId", "parser", "Landroid/content/res/XmlResourceParser;", "getFontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "getFontStyle-MIvY41s", "(Landroid/content/res/XmlResourceParser;)I", "getFontWeight", "parse", "Landroidx/compose/ui/text/font/FontFamily;", "parseFontData", "Lcom/revenuecat/purchases/ui/revenuecatui/utils/ParsedFont;", "parseXmlData", "", "parseXmlData$revenuecatui_defaultsBc8Release", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FontFamilyXmlParser {
    public static final int $stable = 0;
    private static final String ANDROID_NAMESPACE = "http://schemas.android.com/apk/res/android";
    private static final String APP_NAMESPACE = "http://schemas.android.com/apk/res-auto";
    private static final int DEFAULT_FONT_WEIGHT = 400;
    public static final FontFamilyXmlParser INSTANCE = new FontFamilyXmlParser();
    private static final int UNRECOGNIZED_VALUE = -1;

    private FontFamilyXmlParser() {
    }

    public final FontFamily parse(XmlResourceParser parser) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        List<ParsedFont> xmlData$revenuecatui_defaultsBc8Release = parseXmlData$revenuecatui_defaultsBc8Release(parser);
        if (xmlData$revenuecatui_defaultsBc8Release.isEmpty()) {
            return null;
        }
        List<ParsedFont> list = xmlData$revenuecatui_defaultsBc8Release;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ParsedFont parsedFont : list) {
            int resId = parsedFont.getResId();
            int weight = parsedFont.getWeight();
            arrayList.add(FontKt.m2272FontYpTlLL0$default(resId, new FontWeight(weight), parsedFont.getStyle(), 0, 8, null));
        }
        return FontFamilyKt.FontFamily(arrayList);
    }

    public final List<ParsedFont> parseXmlData$revenuecatui_defaultsBc8Release(XmlResourceParser parser) throws XmlPullParserException, IOException {
        ParsedFont fontData;
        Intrinsics.checkNotNullParameter(parser, "parser");
        ArrayList arrayList = new ArrayList();
        int eventType = parser.getEventType();
        while (eventType != 1) {
            if (eventType == 2 && Intrinsics.areEqual(parser.getName(), "font") && (fontData = parseFontData(parser)) != null) {
                arrayList.add(fontData);
            }
            eventType = parser.next();
        }
        return arrayList;
    }

    private final ParsedFont parseFontData(XmlResourceParser parser) {
        int fontResourceId = getFontResourceId(parser);
        if (fontResourceId == -1) {
            return null;
        }
        return new ParsedFont(fontResourceId, getFontWeight(parser), m4586getFontStyleMIvY41s(parser), null);
    }

    private final int getFontResourceId(XmlResourceParser parser) {
        int attributeResourceValue = parser.getAttributeResourceValue(APP_NAMESPACE, "font", -1);
        return attributeResourceValue == -1 ? parser.getAttributeResourceValue(ANDROID_NAMESPACE, "font", -1) : attributeResourceValue;
    }

    private final int getFontWeight(XmlResourceParser parser) {
        int attributeIntValue = parser.getAttributeIntValue(APP_NAMESPACE, "fontWeight", -1);
        if (attributeIntValue == -1) {
            attributeIntValue = parser.getAttributeIntValue(ANDROID_NAMESPACE, "fontWeight", 400);
        }
        if (attributeIntValue == -1) {
            return 400;
        }
        return attributeIntValue;
    }

    /* JADX INFO: renamed from: getFontStyle-MIvY41s, reason: not valid java name */
    private final int m4586getFontStyleMIvY41s(XmlResourceParser parser) {
        String attributeValue = parser.getAttributeValue(APP_NAMESPACE, "fontStyle");
        if (attributeValue == null) {
            attributeValue = parser.getAttributeValue(ANDROID_NAMESPACE, "fontStyle");
        }
        return Intrinsics.areEqual(attributeValue, "italic") ? FontStyle.Companion.m2288getItalic_LCdwA() : FontStyle.Companion.m2289getNormal_LCdwA();
    }
}
