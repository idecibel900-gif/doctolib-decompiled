package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class SpanStyleKt {
    private static final long DefaultBackgroundColor;
    private static final long DefaultColor;
    private static final TextForegroundStyle DefaultColorForegroundStyle;
    private static final long DefaultFontSize = TextUnitKt.getSp(14);
    private static final long DefaultLetterSpacing = TextUnitKt.getSp(0);

    public static final Object lerpDiscrete(Object obj, Object obj2, float f) {
        return ((double) f) < 0.5d ? obj : obj2;
    }

    static {
        Color.Companion companion = Color.Companion;
        DefaultBackgroundColor = companion.m1384getTransparent0d7_KjU();
        long jM1376getBlack0d7_KjU = companion.m1376getBlack0d7_KjU();
        DefaultColor = jM1376getBlack0d7_KjU;
        DefaultColorForegroundStyle = TextForegroundStyle.Companion.m2502from8_81llA(jM1376getBlack0d7_KjU);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x017b  */
    /* JADX WARN: Code duplicated, block: B:101:0x017e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0184  */
    /* JADX WARN: Code duplicated, block: B:105:0x018a  */
    /* JADX WARN: Code duplicated, block: B:107:0x0190  */
    /* JADX WARN: Code duplicated, block: B:108:0x0195  */
    /* JADX WARN: Code duplicated, block: B:112:0x019c  */
    /* JADX WARN: Code duplicated, block: B:114:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:116:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:119:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:120:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:77:0x0129  */
    /* JADX WARN: Code duplicated, block: B:78:0x0132  */
    /* JADX WARN: Code duplicated, block: B:7:0x002b A[PHI: r11
      0x002b: PHI (r11v7 long) = 
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v8 long)
     binds: [B:35:0x0096, B:47:0x00c8, B:44:0x00bc, B:41:0x00b0, B:38:0x00a4, B:33:0x0088, B:28:0x0079, B:24:0x0067, B:21:0x005f, B:18:0x0053, B:15:0x0047, B:5:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:81:0x0142  */
    /* JADX WARN: Code duplicated, block: B:82:0x0147  */
    /* JADX WARN: Code duplicated, block: B:86:0x0150  */
    /* JADX WARN: Code duplicated, block: B:88:0x0156  */
    /* JADX WARN: Code duplicated, block: B:89:0x015b  */
    /* JADX WARN: Code duplicated, block: B:91:0x015f  */
    /* JADX WARN: Code duplicated, block: B:92:0x0164  */
    /* JADX WARN: Code duplicated, block: B:94:0x0168  */
    /* JADX WARN: Code duplicated, block: B:95:0x016d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0171  */
    /* JADX INFO: renamed from: fastMerge-dSHsh3o, reason: not valid java name */
    public static final SpanStyle m2192fastMergedSHsh3o(SpanStyle spanStyle, long j, Brush brush, float f, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        long jM2188getFontSizeXSAIIZE;
        TextGeometricTransform textGeometricTransform2;
        long jM2185getBackground0d7_KjU;
        DrawStyle drawStyle2;
        TextForegroundStyle textForegroundStyleM2502from8_81llA;
        FontFamily fontFamily2;
        FontWeight fontWeight2;
        FontStyle fontStyleM2189getFontStyle4Lr2A7w;
        FontSynthesis fontSynthesisM2190getFontSynthesisZQGJjVo;
        long jM2191getLetterSpacingXSAIIZE;
        LocaleList localeList2;
        DrawStyle drawStyle3;
        String fontFeatureSettings = str;
        BaselineShift baselineShiftM2186getBaselineShift5SSeXJ0 = baselineShift;
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow2 = shadow;
        if (!TextUnitKt.m2630isUnspecifiedR2X_6o(j2)) {
            jM2188getFontSizeXSAIIZE = j2;
            if (!TextUnit.m2619equalsimpl0(jM2188getFontSizeXSAIIZE, spanStyle.m2188getFontSizeXSAIIZE())) {
                textGeometricTransform2 = textGeometricTransform;
                jM2185getBackground0d7_KjU = j4;
                drawStyle2 = drawStyle;
            }
            if (brush != null) {
                textForegroundStyleM2502from8_81llA = TextForegroundStyle.Companion.from(brush, f);
            } else {
                textForegroundStyleM2502from8_81llA = TextForegroundStyle.Companion.m2502from8_81llA(j);
            }
            TextForegroundStyle textForegroundStyleMerge = spanStyle.getTextForegroundStyle$ui_text_release().merge(textForegroundStyleM2502from8_81llA);
            if (fontFamily == null) {
                fontFamily2 = spanStyle.getFontFamily();
            } else {
                fontFamily2 = fontFamily;
            }
            if (TextUnitKt.m2630isUnspecifiedR2X_6o(jM2188getFontSizeXSAIIZE)) {
                jM2188getFontSizeXSAIIZE = spanStyle.m2188getFontSizeXSAIIZE();
            }
            if (fontWeight == null) {
                fontWeight2 = spanStyle.getFontWeight();
            } else {
                fontWeight2 = fontWeight;
            }
            if (fontStyle == null) {
                fontStyleM2189getFontStyle4Lr2A7w = spanStyle.m2189getFontStyle4Lr2A7w();
            } else {
                fontStyleM2189getFontStyle4Lr2A7w = fontStyle;
            }
            if (fontSynthesis == null) {
                fontSynthesisM2190getFontSynthesisZQGJjVo = spanStyle.m2190getFontSynthesisZQGJjVo();
            } else {
                fontSynthesisM2190getFontSynthesisZQGJjVo = fontSynthesis;
            }
            if (fontFeatureSettings == null) {
                fontFeatureSettings = spanStyle.getFontFeatureSettings();
            }
            if (TextUnitKt.m2630isUnspecifiedR2X_6o(j3)) {
                jM2191getLetterSpacingXSAIIZE = spanStyle.m2191getLetterSpacingXSAIIZE();
            } else {
                jM2191getLetterSpacingXSAIIZE = j3;
            }
            if (baselineShiftM2186getBaselineShift5SSeXJ0 == null) {
                baselineShiftM2186getBaselineShift5SSeXJ0 = spanStyle.m2186getBaselineShift5SSeXJ0();
            }
            if (textGeometricTransform2 == null) {
                textGeometricTransform2 = spanStyle.getTextGeometricTransform();
            }
            if (localeList == null) {
                localeList2 = spanStyle.getLocaleList();
            } else {
                localeList2 = localeList;
            }
            if (jM2185getBackground0d7_KjU == 16) {
                jM2185getBackground0d7_KjU = spanStyle.m2185getBackground0d7_KjU();
            }
            if (textDecoration2 == null) {
                textDecoration2 = spanStyle.getTextDecoration();
            }
            if (shadow2 == null) {
                shadow2 = spanStyle.getShadow();
            }
            Shadow shadow3 = shadow2;
            PlatformSpanStyle platformSpanStyleMergePlatformStyle = mergePlatformStyle(spanStyle, platformSpanStyle);
            if (drawStyle2 == null) {
                drawStyle3 = spanStyle.getDrawStyle();
            } else {
                drawStyle3 = drawStyle2;
            }
            return new SpanStyle(textForegroundStyleMerge, jM2188getFontSizeXSAIIZE, fontWeight2, fontStyleM2189getFontStyle4Lr2A7w, fontSynthesisM2190getFontSynthesisZQGJjVo, fontFamily2, fontFeatureSettings, jM2191getLetterSpacingXSAIIZE, baselineShiftM2186getBaselineShift5SSeXJ0, textGeometricTransform2, localeList2, jM2185getBackground0d7_KjU, textDecoration2, shadow3, platformSpanStyleMergePlatformStyle, drawStyle3, (DefaultConstructorMarker) null);
        }
        jM2188getFontSizeXSAIIZE = j2;
        if ((brush != null || j == 16 || Color.m1367equalsimpl0(j, spanStyle.getTextForegroundStyle$ui_text_release().mo2417getColor0d7_KjU())) && ((fontStyle == null || Intrinsics.areEqual(fontStyle, spanStyle.m2189getFontStyle4Lr2A7w())) && ((fontWeight == null || Intrinsics.areEqual(fontWeight, spanStyle.getFontWeight())) && ((fontFamily == null || fontFamily == spanStyle.getFontFamily()) && (TextUnitKt.m2630isUnspecifiedR2X_6o(j3) || TextUnit.m2619equalsimpl0(j3, spanStyle.m2191getLetterSpacingXSAIIZE())))))) {
            if ((textDecoration2 == null || Intrinsics.areEqual(textDecoration2, spanStyle.getTextDecoration())) && Intrinsics.areEqual(brush, spanStyle.getTextForegroundStyle$ui_text_release().getBrush()) && ((brush == null || f == spanStyle.getTextForegroundStyle$ui_text_release().getAlpha()) && ((fontSynthesis == null || Intrinsics.areEqual(fontSynthesis, spanStyle.m2190getFontSynthesisZQGJjVo())) && ((fontFeatureSettings == null || Intrinsics.areEqual(fontFeatureSettings, spanStyle.getFontFeatureSettings())) && (baselineShiftM2186getBaselineShift5SSeXJ0 == null || Intrinsics.areEqual(baselineShiftM2186getBaselineShift5SSeXJ0, spanStyle.m2186getBaselineShift5SSeXJ0())))))) {
                if (textGeometricTransform != null) {
                    textGeometricTransform2 = textGeometricTransform;
                    if (Intrinsics.areEqual(textGeometricTransform2, spanStyle.getTextGeometricTransform())) {
                    }
                } else {
                    textGeometricTransform2 = textGeometricTransform;
                }
                if (localeList == null || Intrinsics.areEqual(localeList, spanStyle.getLocaleList())) {
                    if (j4 != 16) {
                        jM2185getBackground0d7_KjU = j4;
                        if (Color.m1367equalsimpl0(jM2185getBackground0d7_KjU, spanStyle.m2185getBackground0d7_KjU())) {
                        }
                    } else {
                        jM2185getBackground0d7_KjU = j4;
                    }
                    if ((shadow2 == null || Intrinsics.areEqual(shadow2, spanStyle.getShadow())) && (platformSpanStyle == null || Intrinsics.areEqual(platformSpanStyle, spanStyle.getPlatformStyle()))) {
                        drawStyle2 = drawStyle;
                        if (drawStyle2 == null || Intrinsics.areEqual(drawStyle2, spanStyle.getDrawStyle())) {
                            return spanStyle;
                        }
                    }
                }
                drawStyle2 = drawStyle;
            } else {
                textGeometricTransform2 = textGeometricTransform;
            }
            jM2185getBackground0d7_KjU = j4;
            drawStyle2 = drawStyle;
        } else {
            textGeometricTransform2 = textGeometricTransform;
            jM2185getBackground0d7_KjU = j4;
            drawStyle2 = drawStyle;
        }
        if (brush != null) {
            textForegroundStyleM2502from8_81llA = TextForegroundStyle.Companion.from(brush, f);
        } else {
            textForegroundStyleM2502from8_81llA = TextForegroundStyle.Companion.m2502from8_81llA(j);
        }
        TextForegroundStyle textForegroundStyleMerge2 = spanStyle.getTextForegroundStyle$ui_text_release().merge(textForegroundStyleM2502from8_81llA);
        if (fontFamily == null) {
            fontFamily2 = spanStyle.getFontFamily();
        } else {
            fontFamily2 = fontFamily;
        }
        if (TextUnitKt.m2630isUnspecifiedR2X_6o(jM2188getFontSizeXSAIIZE)) {
            jM2188getFontSizeXSAIIZE = spanStyle.m2188getFontSizeXSAIIZE();
        }
        if (fontWeight == null) {
            fontWeight2 = spanStyle.getFontWeight();
        } else {
            fontWeight2 = fontWeight;
        }
        if (fontStyle == null) {
            fontStyleM2189getFontStyle4Lr2A7w = spanStyle.m2189getFontStyle4Lr2A7w();
        } else {
            fontStyleM2189getFontStyle4Lr2A7w = fontStyle;
        }
        if (fontSynthesis == null) {
            fontSynthesisM2190getFontSynthesisZQGJjVo = spanStyle.m2190getFontSynthesisZQGJjVo();
        } else {
            fontSynthesisM2190getFontSynthesisZQGJjVo = fontSynthesis;
        }
        if (fontFeatureSettings == null) {
            fontFeatureSettings = spanStyle.getFontFeatureSettings();
        }
        if (TextUnitKt.m2630isUnspecifiedR2X_6o(j3)) {
            jM2191getLetterSpacingXSAIIZE = j3;
        } else {
            jM2191getLetterSpacingXSAIIZE = spanStyle.m2191getLetterSpacingXSAIIZE();
        }
        if (baselineShiftM2186getBaselineShift5SSeXJ0 == null) {
            baselineShiftM2186getBaselineShift5SSeXJ0 = spanStyle.m2186getBaselineShift5SSeXJ0();
        }
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = spanStyle.getTextGeometricTransform();
        }
        if (localeList == null) {
            localeList2 = spanStyle.getLocaleList();
        } else {
            localeList2 = localeList;
        }
        if (jM2185getBackground0d7_KjU == 16) {
            jM2185getBackground0d7_KjU = spanStyle.m2185getBackground0d7_KjU();
        }
        if (textDecoration2 == null) {
            textDecoration2 = spanStyle.getTextDecoration();
        }
        if (shadow2 == null) {
            shadow2 = spanStyle.getShadow();
        }
        Shadow shadow4 = shadow2;
        PlatformSpanStyle platformSpanStyleMergePlatformStyle2 = mergePlatformStyle(spanStyle, platformSpanStyle);
        if (drawStyle2 == null) {
            drawStyle3 = spanStyle.getDrawStyle();
        } else {
            drawStyle3 = drawStyle2;
        }
        return new SpanStyle(textForegroundStyleMerge2, jM2188getFontSizeXSAIIZE, fontWeight2, fontStyleM2189getFontStyle4Lr2A7w, fontSynthesisM2190getFontSynthesisZQGJjVo, fontFamily2, fontFeatureSettings, jM2191getLetterSpacingXSAIIZE, baselineShiftM2186getBaselineShift5SSeXJ0, textGeometricTransform2, localeList2, jM2185getBackground0d7_KjU, textDecoration2, shadow4, platformSpanStyleMergePlatformStyle2, drawStyle3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: renamed from: lerpTextUnitInheritable-C3pnCVY, reason: not valid java name */
    public static final long m2193lerpTextUnitInheritableC3pnCVY(long j, long j2, float f) {
        if (TextUnitKt.m2630isUnspecifiedR2X_6o(j) || TextUnitKt.m2630isUnspecifiedR2X_6o(j2)) {
            return ((TextUnit) lerpDiscrete(TextUnit.m2616boximpl(j), TextUnit.m2616boximpl(j2), f)).m2625unboximpl();
        }
        return TextUnitKt.m2631lerpC3pnCVY(j, j2, f);
    }

    public static final SpanStyle lerp(SpanStyle spanStyle, SpanStyle spanStyle2, float f) {
        TextForegroundStyle textForegroundStyleLerp = TextDrawStyleKt.lerp(spanStyle.getTextForegroundStyle$ui_text_release(), spanStyle2.getTextForegroundStyle$ui_text_release(), f);
        FontFamily fontFamily = (FontFamily) lerpDiscrete(spanStyle.getFontFamily(), spanStyle2.getFontFamily(), f);
        long jM2193lerpTextUnitInheritableC3pnCVY = m2193lerpTextUnitInheritableC3pnCVY(spanStyle.m2188getFontSizeXSAIIZE(), spanStyle2.m2188getFontSizeXSAIIZE(), f);
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = spanStyle2.getFontWeight();
        if (fontWeight2 == null) {
            fontWeight2 = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeightLerp = FontWeightKt.lerp(fontWeight, fontWeight2, f);
        FontStyle fontStyle = (FontStyle) lerpDiscrete(spanStyle.m2189getFontStyle4Lr2A7w(), spanStyle2.m2189getFontStyle4Lr2A7w(), f);
        FontSynthesis fontSynthesis = (FontSynthesis) lerpDiscrete(spanStyle.m2190getFontSynthesisZQGJjVo(), spanStyle2.m2190getFontSynthesisZQGJjVo(), f);
        String str = (String) lerpDiscrete(spanStyle.getFontFeatureSettings(), spanStyle2.getFontFeatureSettings(), f);
        long jM2193lerpTextUnitInheritableC3pnCVY2 = m2193lerpTextUnitInheritableC3pnCVY(spanStyle.m2191getLetterSpacingXSAIIZE(), spanStyle2.m2191getLetterSpacingXSAIIZE(), f);
        BaselineShift baselineShiftM2186getBaselineShift5SSeXJ0 = spanStyle.m2186getBaselineShift5SSeXJ0();
        float fM2414unboximpl = baselineShiftM2186getBaselineShift5SSeXJ0 != null ? baselineShiftM2186getBaselineShift5SSeXJ0.m2414unboximpl() : BaselineShift.m2409constructorimpl(0.0f);
        BaselineShift baselineShiftM2186getBaselineShift5SSeXJ1 = spanStyle2.m2186getBaselineShift5SSeXJ0();
        float fM2416lerpjWV1Mfo = BaselineShiftKt.m2416lerpjWV1Mfo(fM2414unboximpl, baselineShiftM2186getBaselineShift5SSeXJ1 != null ? baselineShiftM2186getBaselineShift5SSeXJ1.m2414unboximpl() : BaselineShift.m2409constructorimpl(0.0f), f);
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = spanStyle2.getTextGeometricTransform();
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransformLerp = TextGeometricTransformKt.lerp(textGeometricTransform, textGeometricTransform2, f);
        LocaleList localeList = (LocaleList) lerpDiscrete(spanStyle.getLocaleList(), spanStyle2.getLocaleList(), f);
        long jM1391lerpjxsXWHM = ColorKt.m1391lerpjxsXWHM(spanStyle.m2185getBackground0d7_KjU(), spanStyle2.m2185getBackground0d7_KjU(), f);
        TextDecoration textDecoration = (TextDecoration) lerpDiscrete(spanStyle.getTextDecoration(), spanStyle2.getTextDecoration(), f);
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        Shadow shadow2 = spanStyle2.getShadow();
        if (shadow2 == null) {
            shadow2 = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        return new SpanStyle(textForegroundStyleLerp, jM2193lerpTextUnitInheritableC3pnCVY, fontWeightLerp, fontStyle, fontSynthesis, fontFamily, str, jM2193lerpTextUnitInheritableC3pnCVY2, BaselineShift.m2408boximpl(fM2416lerpjWV1Mfo), textGeometricTransformLerp, localeList, jM1391lerpjxsXWHM, textDecoration, ShadowKt.lerp(shadow, shadow2, f), lerpPlatformStyle(spanStyle.getPlatformStyle(), spanStyle2.getPlatformStyle(), f), (DrawStyle) lerpDiscrete(spanStyle.getDrawStyle(), spanStyle2.getDrawStyle(), f), (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle lerpPlatformStyle(PlatformSpanStyle platformSpanStyle, PlatformSpanStyle platformSpanStyle2, float f) {
        if (platformSpanStyle == null && platformSpanStyle2 == null) {
            return null;
        }
        if (platformSpanStyle == null) {
            platformSpanStyle = PlatformSpanStyle.Companion.getDefault();
        }
        if (platformSpanStyle2 == null) {
            platformSpanStyle2 = PlatformSpanStyle.Companion.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformSpanStyle, platformSpanStyle2, f);
    }

    public static final SpanStyle resolveSpanStyleDefaults(SpanStyle spanStyle) {
        long jM2191getLetterSpacingXSAIIZE;
        TextForegroundStyle textForegroundStyleTakeOrElse = spanStyle.getTextForegroundStyle$ui_text_release().takeOrElse(new Function0() { // from class: androidx.compose.ui.text.SpanStyleKt.resolveSpanStyleDefaults.1
            @Override // kotlin.jvm.functions.Function0
            public final TextForegroundStyle invoke() {
                return SpanStyleKt.DefaultColorForegroundStyle;
            }
        });
        long jM2188getFontSizeXSAIIZE = TextUnitKt.m2630isUnspecifiedR2X_6o(spanStyle.m2188getFontSizeXSAIIZE()) ? DefaultFontSize : spanStyle.m2188getFontSizeXSAIIZE();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle fontStyleM2189getFontStyle4Lr2A7w = spanStyle.m2189getFontStyle4Lr2A7w();
        FontStyle fontStyleM2281boximpl = FontStyle.m2281boximpl(fontStyleM2189getFontStyle4Lr2A7w != null ? fontStyleM2189getFontStyle4Lr2A7w.m2287unboximpl() : FontStyle.Companion.m2289getNormal_LCdwA());
        FontSynthesis fontSynthesisM2190getFontSynthesisZQGJjVo = spanStyle.m2190getFontSynthesisZQGJjVo();
        FontSynthesis fontSynthesisM2290boximpl = FontSynthesis.m2290boximpl(fontSynthesisM2190getFontSynthesisZQGJjVo != null ? fontSynthesisM2190getFontSynthesisZQGJjVo.m2298unboximpl() : FontSynthesis.Companion.m2299getAllGVVA2EU());
        FontFamily fontFamily = spanStyle.getFontFamily();
        if (fontFamily == null) {
            fontFamily = FontFamily.Companion.getDefault();
        }
        FontFamily fontFamily2 = fontFamily;
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings == null) {
            fontFeatureSettings = "";
        }
        String str = fontFeatureSettings;
        if (TextUnitKt.m2630isUnspecifiedR2X_6o(spanStyle.m2191getLetterSpacingXSAIIZE())) {
            jM2191getLetterSpacingXSAIIZE = DefaultLetterSpacing;
        } else {
            jM2191getLetterSpacingXSAIIZE = spanStyle.m2191getLetterSpacingXSAIIZE();
        }
        long j = jM2191getLetterSpacingXSAIIZE;
        BaselineShift baselineShiftM2186getBaselineShift5SSeXJ0 = spanStyle.m2186getBaselineShift5SSeXJ0();
        BaselineShift baselineShiftM2408boximpl = BaselineShift.m2408boximpl(baselineShiftM2186getBaselineShift5SSeXJ0 != null ? baselineShiftM2186getBaselineShift5SSeXJ0.m2414unboximpl() : BaselineShift.Companion.m2415getNoney9eOQZs());
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = spanStyle.getLocaleList();
        if (localeList == null) {
            localeList = LocaleList.Companion.getCurrent();
        }
        LocaleList localeList2 = localeList;
        long jM2185getBackground0d7_KjU = spanStyle.m2185getBackground0d7_KjU();
        if (jM2185getBackground0d7_KjU == 16) {
            jM2185getBackground0d7_KjU = DefaultBackgroundColor;
        }
        long j2 = jM2185getBackground0d7_KjU;
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.Companion.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = Shadow.Companion.getNone();
        }
        Shadow shadow2 = shadow;
        PlatformSpanStyle platformStyle = spanStyle.getPlatformStyle();
        DrawStyle drawStyle = spanStyle.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        return new SpanStyle(textForegroundStyleTakeOrElse, jM2188getFontSizeXSAIIZE, fontWeight2, fontStyleM2281boximpl, fontSynthesisM2290boximpl, fontFamily2, str, j, baselineShiftM2408boximpl, textGeometricTransform2, localeList2, j2, textDecoration2, shadow2, platformStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle mergePlatformStyle(SpanStyle spanStyle, PlatformSpanStyle platformSpanStyle) {
        if (spanStyle.getPlatformStyle() == null) {
            return platformSpanStyle;
        }
        if (platformSpanStyle == null) {
            return spanStyle.getPlatformStyle();
        }
        return spanStyle.getPlatformStyle().merge(platformSpanStyle);
    }
}
