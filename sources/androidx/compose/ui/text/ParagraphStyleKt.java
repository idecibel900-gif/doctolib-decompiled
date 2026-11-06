package androidx.compose.ui.text;

import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextIndentKt;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class ParagraphStyleKt {
    private static final long DefaultLineHeight = TextUnit.Companion.m2626getUnspecifiedXSAIIZE();

    public static final ParagraphStyle lerp(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2, float f) {
        int iM2480unboximpl = ((TextAlign) SpanStyleKt.lerpDiscrete(TextAlign.m2474boximpl(paragraphStyle.m2169getTextAligne0LSkKk()), TextAlign.m2474boximpl(paragraphStyle2.m2169getTextAligne0LSkKk()), f)).m2480unboximpl();
        int iM2494unboximpl = ((TextDirection) SpanStyleKt.lerpDiscrete(TextDirection.m2488boximpl(paragraphStyle.m2170getTextDirections_7Xco()), TextDirection.m2488boximpl(paragraphStyle2.m2170getTextDirections_7Xco()), f)).m2494unboximpl();
        long jM2193lerpTextUnitInheritableC3pnCVY = SpanStyleKt.m2193lerpTextUnitInheritableC3pnCVY(paragraphStyle.m2168getLineHeightXSAIIZE(), paragraphStyle2.m2168getLineHeightXSAIIZE(), f);
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        TextIndent textIndent2 = paragraphStyle2.getTextIndent();
        if (textIndent2 == null) {
            textIndent2 = TextIndent.Companion.getNone();
        }
        return new ParagraphStyle(iM2480unboximpl, iM2494unboximpl, jM2193lerpTextUnitInheritableC3pnCVY, TextIndentKt.lerp(textIndent, textIndent2, f), lerpPlatformStyle(paragraphStyle.getPlatformStyle(), paragraphStyle2.getPlatformStyle(), f), (LineHeightStyle) SpanStyleKt.lerpDiscrete(paragraphStyle.getLineHeightStyle(), paragraphStyle2.getLineHeightStyle(), f), ((LineBreak) SpanStyleKt.lerpDiscrete(LineBreak.m2428boximpl(paragraphStyle.m2167getLineBreakrAG3T2k()), LineBreak.m2428boximpl(paragraphStyle2.m2167getLineBreakrAG3T2k()), f)).m2437unboximpl(), ((Hyphens) SpanStyleKt.lerpDiscrete(Hyphens.m2418boximpl(paragraphStyle.m2166getHyphensvmbZdU8()), Hyphens.m2418boximpl(paragraphStyle2.m2166getHyphensvmbZdU8()), f)).m2424unboximpl(), (TextMotion) SpanStyleKt.lerpDiscrete(paragraphStyle.getTextMotion(), paragraphStyle2.getTextMotion(), f), null);
    }

    private static final PlatformParagraphStyle lerpPlatformStyle(PlatformParagraphStyle platformParagraphStyle, PlatformParagraphStyle platformParagraphStyle2, float f) {
        if (platformParagraphStyle == null && platformParagraphStyle2 == null) {
            return null;
        }
        if (platformParagraphStyle == null) {
            platformParagraphStyle = PlatformParagraphStyle.Companion.getDefault();
        }
        if (platformParagraphStyle2 == null) {
            platformParagraphStyle2 = PlatformParagraphStyle.Companion.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformParagraphStyle, platformParagraphStyle2, f);
    }

    public static final ParagraphStyle resolveParagraphStyleDefaults(ParagraphStyle paragraphStyle, LayoutDirection layoutDirection) {
        int iM2169getTextAligne0LSkKk = paragraphStyle.m2169getTextAligne0LSkKk();
        TextAlign.Companion companion = TextAlign.Companion;
        int iM2486getStarte0LSkKk = TextAlign.m2477equalsimpl0(iM2169getTextAligne0LSkKk, companion.m2487getUnspecifiede0LSkKk()) ? companion.m2486getStarte0LSkKk() : paragraphStyle.m2169getTextAligne0LSkKk();
        int iM2243resolveTextDirectionIhaHGbI = TextStyleKt.m2243resolveTextDirectionIhaHGbI(layoutDirection, paragraphStyle.m2170getTextDirections_7Xco());
        long jM2168getLineHeightXSAIIZE = TextUnitKt.m2630isUnspecifiedR2X_6o(paragraphStyle.m2168getLineHeightXSAIIZE()) ? DefaultLineHeight : paragraphStyle.m2168getLineHeightXSAIIZE();
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        TextIndent textIndent2 = textIndent;
        PlatformParagraphStyle platformStyle = paragraphStyle.getPlatformStyle();
        LineHeightStyle lineHeightStyle = paragraphStyle.getLineHeightStyle();
        int iM2167getLineBreakrAG3T2k = paragraphStyle.m2167getLineBreakrAG3T2k();
        LineBreak.Companion companion2 = LineBreak.Companion;
        int iM2438getSimplerAG3T2k = LineBreak.m2431equalsimpl0(iM2167getLineBreakrAG3T2k, companion2.m2439getUnspecifiedrAG3T2k()) ? companion2.m2438getSimplerAG3T2k() : paragraphStyle.m2167getLineBreakrAG3T2k();
        int iM2166getHyphensvmbZdU8 = paragraphStyle.m2166getHyphensvmbZdU8();
        Hyphens.Companion companion3 = Hyphens.Companion;
        int iM2426getNonevmbZdU8 = Hyphens.m2421equalsimpl0(iM2166getHyphensvmbZdU8, companion3.m2427getUnspecifiedvmbZdU8()) ? companion3.m2426getNonevmbZdU8() : paragraphStyle.m2166getHyphensvmbZdU8();
        TextMotion textMotion = paragraphStyle.getTextMotion();
        if (textMotion == null) {
            textMotion = TextMotion.Companion.getStatic();
        }
        return new ParagraphStyle(iM2486getStarte0LSkKk, iM2243resolveTextDirectionIhaHGbI, jM2168getLineHeightXSAIIZE, textIndent2, platformStyle, lineHeightStyle, iM2438getSimplerAG3T2k, iM2426getNonevmbZdU8, textMotion, null);
    }

    /* JADX INFO: renamed from: fastMerge-j5T8yCg, reason: not valid java name */
    public static final ParagraphStyle m2171fastMergej5T8yCg(ParagraphStyle paragraphStyle, int i, int i2, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion) {
        long j2;
        int iM2169getTextAligne0LSkKk = i;
        TextIndent textIndent2 = textIndent;
        TextAlign.Companion companion = TextAlign.Companion;
        if (TextAlign.m2477equalsimpl0(iM2169getTextAligne0LSkKk, companion.m2487getUnspecifiede0LSkKk()) || TextAlign.m2477equalsimpl0(iM2169getTextAligne0LSkKk, paragraphStyle.m2169getTextAligne0LSkKk())) {
            if (TextUnitKt.m2630isUnspecifiedR2X_6o(j)) {
                j2 = j;
            } else {
                j2 = j;
                if (TextUnit.m2619equalsimpl0(j2, paragraphStyle.m2168getLineHeightXSAIIZE())) {
                }
            }
            if ((textIndent2 == null || Intrinsics.areEqual(textIndent2, paragraphStyle.getTextIndent())) && ((TextDirection.m2491equalsimpl0(i2, TextDirection.Companion.m2500getUnspecifieds_7Xco()) || TextDirection.m2491equalsimpl0(i2, paragraphStyle.m2170getTextDirections_7Xco())) && ((platformParagraphStyle == null || Intrinsics.areEqual(platformParagraphStyle, paragraphStyle.getPlatformStyle())) && ((lineHeightStyle == null || Intrinsics.areEqual(lineHeightStyle, paragraphStyle.getLineHeightStyle())) && ((LineBreak.m2431equalsimpl0(i3, LineBreak.Companion.m2439getUnspecifiedrAG3T2k()) || LineBreak.m2431equalsimpl0(i3, paragraphStyle.m2167getLineBreakrAG3T2k())) && ((Hyphens.m2421equalsimpl0(i4, Hyphens.Companion.m2427getUnspecifiedvmbZdU8()) || Hyphens.m2421equalsimpl0(i4, paragraphStyle.m2166getHyphensvmbZdU8())) && (textMotion == null || Intrinsics.areEqual(textMotion, paragraphStyle.getTextMotion())))))))) {
                return paragraphStyle;
            }
        } else {
            j2 = j;
        }
        long jM2168getLineHeightXSAIIZE = TextUnitKt.m2630isUnspecifiedR2X_6o(j2) ? paragraphStyle.m2168getLineHeightXSAIIZE() : j2;
        if (textIndent2 == null) {
            textIndent2 = paragraphStyle.getTextIndent();
        }
        TextIndent textIndent3 = textIndent2;
        if (TextAlign.m2477equalsimpl0(iM2169getTextAligne0LSkKk, companion.m2487getUnspecifiede0LSkKk())) {
            iM2169getTextAligne0LSkKk = paragraphStyle.m2169getTextAligne0LSkKk();
        }
        return new ParagraphStyle(iM2169getTextAligne0LSkKk, !TextDirection.m2491equalsimpl0(i2, TextDirection.Companion.m2500getUnspecifieds_7Xco()) ? i2 : paragraphStyle.m2170getTextDirections_7Xco(), jM2168getLineHeightXSAIIZE, textIndent3, mergePlatformStyle(paragraphStyle, platformParagraphStyle), lineHeightStyle == null ? paragraphStyle.getLineHeightStyle() : lineHeightStyle, !LineBreak.m2431equalsimpl0(i3, LineBreak.Companion.m2439getUnspecifiedrAG3T2k()) ? i3 : paragraphStyle.m2167getLineBreakrAG3T2k(), !Hyphens.m2421equalsimpl0(i4, Hyphens.Companion.m2427getUnspecifiedvmbZdU8()) ? i4 : paragraphStyle.m2166getHyphensvmbZdU8(), textMotion == null ? paragraphStyle.getTextMotion() : textMotion, null);
    }

    private static final PlatformParagraphStyle mergePlatformStyle(ParagraphStyle paragraphStyle, PlatformParagraphStyle platformParagraphStyle) {
        if (paragraphStyle.getPlatformStyle() == null) {
            return platformParagraphStyle;
        }
        if (platformParagraphStyle == null) {
            return paragraphStyle.getPlatformStyle();
        }
        return paragraphStyle.getPlatformStyle().merge(platformParagraphStyle);
    }
}
