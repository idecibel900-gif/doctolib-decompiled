package com.horcrux.svg;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: loaded from: classes4.dex */
class FontData {
    static final FontData Defaults = new FontData();
    int absoluteFontWeight;
    final ReadableMap fontData;
    final String fontFamily;
    final String fontFeatureSettings;
    final double fontSize;
    final TextProperties$FontStyle fontStyle;
    final TextProperties$FontVariantLigatures fontVariantLigatures;
    final String fontVariationSettings;
    TextProperties$FontWeight fontWeight;
    final double kerning;
    final double letterSpacing;
    final boolean manualKerning;
    final TextProperties$TextAnchor textAnchor;
    private final TextProperties$TextDecoration textDecoration;
    final double wordSpacing;

    static class AbsoluteFontWeight {
        private static final TextProperties$FontWeight[] WEIGHTS;
        private static final int[] absoluteFontWeights;

        private static int bolder(int i) {
            if (i < 350) {
                return 400;
            }
            if (i < 550) {
                return ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD;
            }
            if (i < 900) {
                return 900;
            }
            return i;
        }

        private static int lighter(int i) {
            if (i < 100) {
                return i;
            }
            if (i < 550) {
                return 100;
            }
            if (i < 750) {
                return 400;
            }
            return ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD;
        }

        static {
            TextProperties$FontWeight textProperties$FontWeight = TextProperties$FontWeight.w100;
            TextProperties$FontWeight textProperties$FontWeight2 = TextProperties$FontWeight.w200;
            TextProperties$FontWeight textProperties$FontWeight3 = TextProperties$FontWeight.w300;
            TextProperties$FontWeight textProperties$FontWeight4 = TextProperties$FontWeight.Normal;
            TextProperties$FontWeight textProperties$FontWeight5 = TextProperties$FontWeight.w500;
            TextProperties$FontWeight textProperties$FontWeight6 = TextProperties$FontWeight.w600;
            TextProperties$FontWeight textProperties$FontWeight7 = TextProperties$FontWeight.Bold;
            TextProperties$FontWeight textProperties$FontWeight8 = TextProperties$FontWeight.w800;
            TextProperties$FontWeight textProperties$FontWeight9 = TextProperties$FontWeight.w900;
            WEIGHTS = new TextProperties$FontWeight[]{textProperties$FontWeight, textProperties$FontWeight, textProperties$FontWeight2, textProperties$FontWeight3, textProperties$FontWeight4, textProperties$FontWeight5, textProperties$FontWeight6, textProperties$FontWeight7, textProperties$FontWeight8, textProperties$FontWeight9, textProperties$FontWeight9};
            absoluteFontWeights = new int[]{400, ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD, 100, 200, 300, 400, 500, 600, ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD, 800, 900};
        }

        static TextProperties$FontWeight nearestFontWeight(int i) {
            return WEIGHTS[Math.round(i / 100.0f)];
        }

        static int from(TextProperties$FontWeight textProperties$FontWeight, FontData fontData) {
            if (textProperties$FontWeight == TextProperties$FontWeight.Bolder) {
                return bolder(fontData.absoluteFontWeight);
            }
            if (textProperties$FontWeight == TextProperties$FontWeight.Lighter) {
                return lighter(fontData.absoluteFontWeight);
            }
            return absoluteFontWeights[textProperties$FontWeight.ordinal()];
        }
    }

    private FontData() {
        this.fontData = null;
        this.fontFamily = "";
        this.fontStyle = TextProperties$FontStyle.normal;
        this.fontWeight = TextProperties$FontWeight.Normal;
        this.absoluteFontWeight = 400;
        this.fontFeatureSettings = "";
        this.fontVariationSettings = "";
        this.fontVariantLigatures = TextProperties$FontVariantLigatures.normal;
        this.textAnchor = TextProperties$TextAnchor.start;
        this.textDecoration = TextProperties$TextDecoration.None;
        this.manualKerning = false;
        this.kerning = 0.0d;
        this.fontSize = 12.0d;
        this.wordSpacing = 0.0d;
        this.letterSpacing = 0.0d;
    }

    private double toAbsolute(ReadableMap readableMap, String str, double d, double d2, double d3) {
        if (readableMap.getType(str) == ReadableType.Number) {
            return readableMap.getDouble(str) * d;
        }
        return PropHelper.fromRelative(readableMap.getString(str), d3, d, d2);
    }

    private void setInheritedWeight(FontData fontData) {
        this.absoluteFontWeight = fontData.absoluteFontWeight;
        this.fontWeight = fontData.fontWeight;
    }

    private void handleNumericWeight(FontData fontData, double d) {
        long jRound = Math.round(d);
        if (jRound >= 1 && jRound <= 1000) {
            int i = (int) jRound;
            this.absoluteFontWeight = i;
            this.fontWeight = AbsoluteFontWeight.nearestFontWeight(i);
            return;
        }
        setInheritedWeight(fontData);
    }

    FontData(ReadableMap readableMap, FontData fontData, double d) {
        String string;
        String string2;
        TextProperties$FontVariantLigatures textProperties$FontVariantLigaturesValueOf;
        TextProperties$TextAnchor textProperties$TextAnchorValueOf;
        TextProperties$TextDecoration textProperties$TextDecoration;
        double absolute;
        double absolute2;
        double d2 = fontData.fontSize;
        if (readableMap.hasKey("fontSize")) {
            this.fontSize = toAbsolute(readableMap, "fontSize", 1.0d, d2, d2);
        } else {
            this.fontSize = d2;
        }
        if (readableMap.hasKey("fontWeight")) {
            if (readableMap.getType("fontWeight") == ReadableType.Number) {
                handleNumericWeight(fontData, readableMap.getDouble("fontWeight"));
            } else {
                String string3 = readableMap.getString("fontWeight");
                if (TextProperties$FontWeight.hasEnum(string3)) {
                    int iFrom = AbsoluteFontWeight.from(TextProperties$FontWeight.get(string3), fontData);
                    this.absoluteFontWeight = iFrom;
                    this.fontWeight = AbsoluteFontWeight.nearestFontWeight(iFrom);
                } else if (string3 != null) {
                    handleNumericWeight(fontData, Double.parseDouble(string3));
                } else {
                    setInheritedWeight(fontData);
                }
            }
        } else {
            setInheritedWeight(fontData);
        }
        this.fontData = readableMap.hasKey("fontData") ? readableMap.getMap("fontData") : fontData.fontData;
        this.fontFamily = readableMap.hasKey("fontFamily") ? readableMap.getString("fontFamily") : fontData.fontFamily;
        this.fontStyle = readableMap.hasKey("fontStyle") ? TextProperties$FontStyle.valueOf(readableMap.getString("fontStyle")) : fontData.fontStyle;
        if (readableMap.hasKey("fontFeatureSettings")) {
            string = readableMap.getString("fontFeatureSettings");
        } else {
            string = fontData.fontFeatureSettings;
        }
        this.fontFeatureSettings = string;
        if (readableMap.hasKey("fontVariationSettings")) {
            string2 = readableMap.getString("fontVariationSettings");
        } else {
            string2 = fontData.fontVariationSettings;
        }
        this.fontVariationSettings = string2;
        if (readableMap.hasKey("fontVariantLigatures")) {
            textProperties$FontVariantLigaturesValueOf = TextProperties$FontVariantLigatures.valueOf(readableMap.getString("fontVariantLigatures"));
        } else {
            textProperties$FontVariantLigaturesValueOf = fontData.fontVariantLigatures;
        }
        this.fontVariantLigatures = textProperties$FontVariantLigaturesValueOf;
        if (readableMap.hasKey("textAnchor")) {
            textProperties$TextAnchorValueOf = TextProperties$TextAnchor.valueOf(readableMap.getString("textAnchor"));
        } else {
            textProperties$TextAnchorValueOf = fontData.textAnchor;
        }
        this.textAnchor = textProperties$TextAnchorValueOf;
        if (readableMap.hasKey("textDecoration")) {
            textProperties$TextDecoration = TextProperties$TextDecoration.getEnum(readableMap.getString("textDecoration"));
        } else {
            textProperties$TextDecoration = fontData.textDecoration;
        }
        this.textDecoration = textProperties$TextDecoration;
        boolean zHasKey = readableMap.hasKey("kerning");
        this.manualKerning = zHasKey || fontData.manualKerning;
        this.kerning = zHasKey ? toAbsolute(readableMap, "kerning", d, this.fontSize, 0.0d) : fontData.kerning;
        if (readableMap.hasKey("wordSpacing")) {
            absolute = toAbsolute(readableMap, "wordSpacing", d, this.fontSize, 0.0d);
        } else {
            absolute = fontData.wordSpacing;
        }
        this.wordSpacing = absolute;
        if (readableMap.hasKey("letterSpacing")) {
            absolute2 = toAbsolute(readableMap, "letterSpacing", d, this.fontSize, 0.0d);
        } else {
            absolute2 = fontData.letterSpacing;
        }
        this.letterSpacing = absolute2;
    }
}
