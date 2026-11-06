package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes.dex */
public final class TextStyle {
    public static final Companion Companion = new Companion(null);
    private static final TextStyle Default = new TextStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777215, null);
    private final ParagraphStyle paragraphStyle;
    private final PlatformTextStyle platformStyle;
    private final SpanStyle spanStyle;

    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, drawStyle, i, i2, j5, textIndent, platformTextStyle, lineHeightStyle, i3, i4, textMotion);
    }

    public TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle, PlatformTextStyle platformTextStyle) {
        this.spanStyle = spanStyle;
        this.paragraphStyle = paragraphStyle;
        this.platformStyle = platformTextStyle;
    }

    public final SpanStyle getSpanStyle$ui_text_release() {
        return this.spanStyle;
    }

    public final ParagraphStyle getParagraphStyle$ui_text_release() {
        return this.paragraphStyle;
    }

    public final PlatformTextStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle) {
        this(spanStyle, paragraphStyle, TextStyleKt.createPlatformTextStyleInternal(spanStyle.getPlatformStyle(), paragraphStyle.getPlatformStyle()));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        long jM1385getUnspecified0d7_KjU = (i5 & 1) != 0 ? Color.Companion.m1385getUnspecified0d7_KjU() : j;
        long jM2626getUnspecifiedXSAIIZE = (i5 & 2) != 0 ? TextUnit.Companion.m2626getUnspecifiedXSAIIZE() : j2;
        FontWeight fontWeight2 = (i5 & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i5 & 8) != 0 ? null : fontStyle;
        FontSynthesis fontSynthesis2 = (i5 & 16) != 0 ? null : fontSynthesis;
        FontFamily fontFamily2 = (i5 & 32) != 0 ? null : fontFamily;
        String str2 = (i5 & 64) != 0 ? null : str;
        long jM2626getUnspecifiedXSAIIZE2 = (i5 & 128) != 0 ? TextUnit.Companion.m2626getUnspecifiedXSAIIZE() : j3;
        BaselineShift baselineShift2 = (i5 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i5 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : textGeometricTransform;
        LocaleList localeList2 = (i5 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : localeList;
        long jM1385getUnspecified0d7_KjU2 = (i5 & 2048) != 0 ? Color.Companion.m1385getUnspecified0d7_KjU() : j4;
        TextDecoration textDecoration2 = (i5 & 4096) != 0 ? null : textDecoration;
        long j6 = jM1385getUnspecified0d7_KjU;
        Shadow shadow2 = (i5 & 8192) != 0 ? null : shadow;
        DrawStyle drawStyle2 = (i5 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : drawStyle;
        int iM2487getUnspecifiede0LSkKk = (i5 & 32768) != 0 ? TextAlign.Companion.m2487getUnspecifiede0LSkKk() : i;
        int iM2500getUnspecifieds_7Xco = (i5 & 65536) != 0 ? TextDirection.Companion.m2500getUnspecifieds_7Xco() : i2;
        long jM2626getUnspecifiedXSAIIZE3 = (i5 & 131072) != 0 ? TextUnit.Companion.m2626getUnspecifiedXSAIIZE() : j5;
        TextIndent textIndent2 = (i5 & 262144) != 0 ? null : textIndent;
        PlatformTextStyle platformTextStyle2 = (i5 & 524288) != 0 ? null : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i5 & 1048576) != 0 ? null : lineHeightStyle;
        int iM2439getUnspecifiedrAG3T2k = (i5 & 2097152) != 0 ? LineBreak.Companion.m2439getUnspecifiedrAG3T2k() : i3;
        int iM2427getUnspecifiedvmbZdU8 = (i5 & 4194304) != 0 ? Hyphens.Companion.m2427getUnspecifiedvmbZdU8() : i4;
        long j7 = jM2626getUnspecifiedXSAIIZE;
        FontWeight fontWeight3 = fontWeight2;
        TextDecoration textDecoration3 = textDecoration2;
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j8 = jM2626getUnspecifiedXSAIIZE2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j9 = jM1385getUnspecified0d7_KjU2;
        this(j6, j7, fontWeight3, fontStyle3, fontSynthesis3, fontFamily3, str3, j8, baselineShift3, textGeometricTransform3, localeList3, j9, textDecoration3, shadow2, drawStyle2, iM2487getUnspecifiede0LSkKk, iM2500getUnspecifieds_7Xco, jM2626getUnspecifiedXSAIIZE3, textIndent2, platformTextStyle2, lineHeightStyle2, iM2439getUnspecifiedrAG3T2k, iM2427getUnspecifiedvmbZdU8, (i5 & 8388608) != 0 ? null : textMotion, null);
    }

    private TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion) {
        this(new SpanStyle(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(i, i2, j5, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, i3, i4, textMotion, null), platformTextStyle);
    }

    public final SpanStyle toSpanStyle() {
        return this.spanStyle;
    }

    public final ParagraphStyle toParagraphStyle() {
        return this.paragraphStyle;
    }

    public final TextStyle merge(TextStyle textStyle) {
        return (textStyle == null || Intrinsics.areEqual(textStyle, Default)) ? this : new TextStyle(toSpanStyle().merge(textStyle.toSpanStyle()), toParagraphStyle().merge(textStyle.toParagraphStyle()));
    }

    /* JADX INFO: renamed from: merge-dA7vx0o, reason: not valid java name */
    public final TextStyle m2242mergedA7vx0o(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, LineHeightStyle lineHeightStyle, int i3, int i4, PlatformTextStyle platformTextStyle, TextMotion textMotion) {
        SpanStyle spanStyleM2192fastMergedSHsh3o = SpanStyleKt.m2192fastMergedSHsh3o(this.spanStyle, j, null, Float.NaN, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle);
        ParagraphStyle paragraphStyleM2171fastMergej5T8yCg = ParagraphStyleKt.m2171fastMergej5T8yCg(this.paragraphStyle, i, i2, j5, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, i3, i4, textMotion);
        return (this.spanStyle == spanStyleM2192fastMergedSHsh3o && this.paragraphStyle == paragraphStyleM2171fastMergej5T8yCg) ? this : new TextStyle(spanStyleM2192fastMergedSHsh3o, paragraphStyleM2171fastMergej5T8yCg);
    }

    public final TextStyle merge(ParagraphStyle paragraphStyle) {
        return new TextStyle(toSpanStyle(), toParagraphStyle().merge(paragraphStyle));
    }

    /* JADX INFO: renamed from: copy-p1EtxEg$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m2226copyp1EtxEg$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion, int i5, Object obj) {
        TextMotion textMotion2;
        int i6;
        long jM2187getColor0d7_KjU = (i5 & 1) != 0 ? textStyle.spanStyle.m2187getColor0d7_KjU() : j;
        long jM2188getFontSizeXSAIIZE = (i5 & 2) != 0 ? textStyle.spanStyle.m2188getFontSizeXSAIIZE() : j2;
        FontWeight fontWeight2 = (i5 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle fontStyleM2189getFontStyle4Lr2A7w = (i5 & 8) != 0 ? textStyle.spanStyle.m2189getFontStyle4Lr2A7w() : fontStyle;
        FontSynthesis fontSynthesisM2190getFontSynthesisZQGJjVo = (i5 & 16) != 0 ? textStyle.spanStyle.m2190getFontSynthesisZQGJjVo() : fontSynthesis;
        FontFamily fontFamily2 = (i5 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i5 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long jM2191getLetterSpacingXSAIIZE = (i5 & 128) != 0 ? textStyle.spanStyle.m2191getLetterSpacingXSAIIZE() : j3;
        BaselineShift baselineShiftM2186getBaselineShift5SSeXJ0 = (i5 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? textStyle.spanStyle.m2186getBaselineShift5SSeXJ0() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i5 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i5 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long j6 = jM2187getColor0d7_KjU;
        long jM2185getBackground0d7_KjU = (i5 & 2048) != 0 ? textStyle.spanStyle.m2185getBackground0d7_KjU() : j4;
        TextDecoration textDecoration2 = (i5 & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow2 = (i5 & 8192) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        TextDecoration textDecoration3 = textDecoration2;
        DrawStyle drawStyle2 = (i5 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? textStyle.spanStyle.getDrawStyle() : drawStyle;
        int iM2169getTextAligne0LSkKk = (i5 & 32768) != 0 ? textStyle.paragraphStyle.m2169getTextAligne0LSkKk() : i;
        int iM2170getTextDirections_7Xco = (i5 & 65536) != 0 ? textStyle.paragraphStyle.m2170getTextDirections_7Xco() : i2;
        long jM2168getLineHeightXSAIIZE = (i5 & 131072) != 0 ? textStyle.paragraphStyle.m2168getLineHeightXSAIIZE() : j5;
        TextIndent textIndent2 = (i5 & 262144) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        PlatformTextStyle platformTextStyle2 = (i5 & 524288) != 0 ? textStyle.platformStyle : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i5 & 1048576) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : lineHeightStyle;
        int iM2167getLineBreakrAG3T2k = (i5 & 2097152) != 0 ? textStyle.paragraphStyle.m2167getLineBreakrAG3T2k() : i3;
        int iM2166getHyphensvmbZdU8 = (i5 & 4194304) != 0 ? textStyle.paragraphStyle.m2166getHyphensvmbZdU8() : i4;
        if ((i5 & 8388608) != 0) {
            i6 = iM2166getHyphensvmbZdU8;
            textMotion2 = textStyle.paragraphStyle.getTextMotion();
        } else {
            textMotion2 = textMotion;
            i6 = iM2166getHyphensvmbZdU8;
        }
        return textStyle.m2229copyp1EtxEg(j6, jM2188getFontSizeXSAIIZE, fontWeight2, fontStyleM2189getFontStyle4Lr2A7w, fontSynthesisM2190getFontSynthesisZQGJjVo, fontFamily2, fontFeatureSettings, jM2191getLetterSpacingXSAIIZE, baselineShiftM2186getBaselineShift5SSeXJ0, textGeometricTransform2, localeList2, jM2185getBackground0d7_KjU, textDecoration3, shadow2, drawStyle2, iM2169getTextAligne0LSkKk, iM2170getTextDirections_7Xco, jM2168getLineHeightXSAIIZE, textIndent2, platformTextStyle2, lineHeightStyle2, iM2167getLineBreakrAG3T2k, i6, textMotion2);
    }

    /* JADX INFO: renamed from: copy-p1EtxEg, reason: not valid java name */
    public final TextStyle m2229copyp1EtxEg(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion) {
        TextForegroundStyle textForegroundStyleM2502from8_81llA;
        if (Color.m1367equalsimpl0(j, this.spanStyle.m2187getColor0d7_KjU())) {
            textForegroundStyleM2502from8_81llA = this.spanStyle.getTextForegroundStyle$ui_text_release();
        } else {
            textForegroundStyleM2502from8_81llA = TextForegroundStyle.Companion.m2502from8_81llA(j);
        }
        return new TextStyle(new SpanStyle(textForegroundStyleM2502from8_81llA, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(i, i2, j5, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, i3, i4, textMotion, null), platformTextStyle);
    }

    /* JADX INFO: renamed from: copy-Ns73l9s$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m2225copyNs73l9s$default(TextStyle textStyle, Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion, int i5, Object obj) {
        TextMotion textMotion2;
        int i6;
        float alpha = (i5 & 2) != 0 ? textStyle.spanStyle.getAlpha() : f;
        long jM2188getFontSizeXSAIIZE = (i5 & 4) != 0 ? textStyle.spanStyle.m2188getFontSizeXSAIIZE() : j;
        FontWeight fontWeight2 = (i5 & 8) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle fontStyleM2189getFontStyle4Lr2A7w = (i5 & 16) != 0 ? textStyle.spanStyle.m2189getFontStyle4Lr2A7w() : fontStyle;
        FontSynthesis fontSynthesisM2190getFontSynthesisZQGJjVo = (i5 & 32) != 0 ? textStyle.spanStyle.m2190getFontSynthesisZQGJjVo() : fontSynthesis;
        FontFamily fontFamily2 = (i5 & 64) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i5 & 128) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long jM2191getLetterSpacingXSAIIZE = (i5 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? textStyle.spanStyle.m2191getLetterSpacingXSAIIZE() : j2;
        BaselineShift baselineShiftM2186getBaselineShift5SSeXJ0 = (i5 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? textStyle.spanStyle.m2186getBaselineShift5SSeXJ0() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i5 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i5 & 2048) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long jM2185getBackground0d7_KjU = (i5 & 4096) != 0 ? textStyle.spanStyle.m2185getBackground0d7_KjU() : j3;
        float f2 = alpha;
        TextDecoration textDecoration2 = (i5 & 8192) != 0 ? textStyle.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow2 = (i5 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        DrawStyle drawStyle2 = (i5 & 32768) != 0 ? textStyle.spanStyle.getDrawStyle() : drawStyle;
        int iM2169getTextAligne0LSkKk = (i5 & 65536) != 0 ? textStyle.paragraphStyle.m2169getTextAligne0LSkKk() : i;
        int iM2170getTextDirections_7Xco = (i5 & 131072) != 0 ? textStyle.paragraphStyle.m2170getTextDirections_7Xco() : i2;
        long jM2168getLineHeightXSAIIZE = (i5 & 262144) != 0 ? textStyle.paragraphStyle.m2168getLineHeightXSAIIZE() : j4;
        TextIndent textIndent2 = (i5 & 524288) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        PlatformTextStyle platformTextStyle2 = (i5 & 1048576) != 0 ? textStyle.platformStyle : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i5 & 2097152) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : lineHeightStyle;
        int iM2167getLineBreakrAG3T2k = (i5 & 4194304) != 0 ? textStyle.paragraphStyle.m2167getLineBreakrAG3T2k() : i3;
        int iM2166getHyphensvmbZdU8 = (i5 & 8388608) != 0 ? textStyle.paragraphStyle.m2166getHyphensvmbZdU8() : i4;
        if ((i5 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0) {
            i6 = iM2166getHyphensvmbZdU8;
            textMotion2 = textStyle.paragraphStyle.getTextMotion();
        } else {
            textMotion2 = textMotion;
            i6 = iM2166getHyphensvmbZdU8;
        }
        return textStyle.m2228copyNs73l9s(brush, f2, jM2188getFontSizeXSAIIZE, fontWeight2, fontStyleM2189getFontStyle4Lr2A7w, fontSynthesisM2190getFontSynthesisZQGJjVo, fontFamily2, fontFeatureSettings, jM2191getLetterSpacingXSAIIZE, baselineShiftM2186getBaselineShift5SSeXJ0, textGeometricTransform2, localeList2, jM2185getBackground0d7_KjU, textDecoration2, shadow2, drawStyle2, iM2169getTextAligne0LSkKk, iM2170getTextDirections_7Xco, jM2168getLineHeightXSAIIZE, textIndent2, platformTextStyle2, lineHeightStyle2, iM2167getLineBreakrAG3T2k, i6, textMotion2);
    }

    /* JADX INFO: renamed from: copy-Ns73l9s, reason: not valid java name */
    public final TextStyle m2228copyNs73l9s(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion) {
        return new TextStyle(new SpanStyle(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(i, i2, j4, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, i3, i4, textMotion, null), platformTextStyle);
    }

    public final Brush getBrush() {
        return this.spanStyle.getBrush();
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m2232getColor0d7_KjU() {
        return this.spanStyle.m2187getColor0d7_KjU();
    }

    public final float getAlpha() {
        return this.spanStyle.getAlpha();
    }

    /* JADX INFO: renamed from: getFontSize-XSAIIZE, reason: not valid java name */
    public final long m2233getFontSizeXSAIIZE() {
        return this.spanStyle.m2188getFontSizeXSAIIZE();
    }

    public final FontWeight getFontWeight() {
        return this.spanStyle.getFontWeight();
    }

    /* JADX INFO: renamed from: getFontStyle-4Lr2A7w, reason: not valid java name */
    public final FontStyle m2234getFontStyle4Lr2A7w() {
        return this.spanStyle.m2189getFontStyle4Lr2A7w();
    }

    /* JADX INFO: renamed from: getFontSynthesis-ZQGJjVo, reason: not valid java name */
    public final FontSynthesis m2235getFontSynthesisZQGJjVo() {
        return this.spanStyle.m2190getFontSynthesisZQGJjVo();
    }

    public final FontFamily getFontFamily() {
        return this.spanStyle.getFontFamily();
    }

    public final String getFontFeatureSettings() {
        return this.spanStyle.getFontFeatureSettings();
    }

    /* JADX INFO: renamed from: getLetterSpacing-XSAIIZE, reason: not valid java name */
    public final long m2237getLetterSpacingXSAIIZE() {
        return this.spanStyle.m2191getLetterSpacingXSAIIZE();
    }

    /* JADX INFO: renamed from: getBaselineShift-5SSeXJ0, reason: not valid java name */
    public final BaselineShift m2231getBaselineShift5SSeXJ0() {
        return this.spanStyle.m2186getBaselineShift5SSeXJ0();
    }

    public final TextGeometricTransform getTextGeometricTransform() {
        return this.spanStyle.getTextGeometricTransform();
    }

    public final LocaleList getLocaleList() {
        return this.spanStyle.getLocaleList();
    }

    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m2230getBackground0d7_KjU() {
        return this.spanStyle.m2185getBackground0d7_KjU();
    }

    public final TextDecoration getTextDecoration() {
        return this.spanStyle.getTextDecoration();
    }

    public final Shadow getShadow() {
        return this.spanStyle.getShadow();
    }

    public final DrawStyle getDrawStyle() {
        return this.spanStyle.getDrawStyle();
    }

    /* JADX INFO: renamed from: getTextAlign-e0LSkKk, reason: not valid java name */
    public final int m2240getTextAligne0LSkKk() {
        return this.paragraphStyle.m2169getTextAligne0LSkKk();
    }

    /* JADX INFO: renamed from: getTextDirection-s_7X-co, reason: not valid java name */
    public final int m2241getTextDirections_7Xco() {
        return this.paragraphStyle.m2170getTextDirections_7Xco();
    }

    /* JADX INFO: renamed from: getLineHeight-XSAIIZE, reason: not valid java name */
    public final long m2239getLineHeightXSAIIZE() {
        return this.paragraphStyle.m2168getLineHeightXSAIIZE();
    }

    public final TextIndent getTextIndent() {
        return this.paragraphStyle.getTextIndent();
    }

    public final LineHeightStyle getLineHeightStyle() {
        return this.paragraphStyle.getLineHeightStyle();
    }

    /* JADX INFO: renamed from: getHyphens-vmbZdU8, reason: not valid java name */
    public final int m2236getHyphensvmbZdU8() {
        return this.paragraphStyle.m2166getHyphensvmbZdU8();
    }

    /* JADX INFO: renamed from: getLineBreak-rAG3T2k, reason: not valid java name */
    public final int m2238getLineBreakrAG3T2k() {
        return this.paragraphStyle.m2167getLineBreakrAG3T2k();
    }

    public final TextMotion getTextMotion() {
        return this.paragraphStyle.getTextMotion();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStyle)) {
            return false;
        }
        TextStyle textStyle = (TextStyle) obj;
        return Intrinsics.areEqual(this.spanStyle, textStyle.spanStyle) && Intrinsics.areEqual(this.paragraphStyle, textStyle.paragraphStyle) && Intrinsics.areEqual(this.platformStyle, textStyle.platformStyle);
    }

    public final boolean hasSameLayoutAffectingAttributes(TextStyle textStyle) {
        if (this != textStyle) {
            return Intrinsics.areEqual(this.paragraphStyle, textStyle.paragraphStyle) && this.spanStyle.hasSameLayoutAffectingAttributes$ui_text_release(textStyle.spanStyle);
        }
        return true;
    }

    public final boolean hasSameDrawAffectingAttributes(TextStyle textStyle) {
        return this == textStyle || this.spanStyle.hasSameNonLayoutAttributes$ui_text_release(textStyle.spanStyle);
    }

    public int hashCode() {
        int iHashCode = ((this.spanStyle.hashCode() * 31) + this.paragraphStyle.hashCode()) * 31;
        PlatformTextStyle platformTextStyle = this.platformStyle;
        return iHashCode + (platformTextStyle != null ? platformTextStyle.hashCode() : 0);
    }

    public String toString() {
        return "TextStyle(color=" + ((Object) Color.m1374toStringimpl(m2232getColor0d7_KjU())) + ", brush=" + getBrush() + ", alpha=" + getAlpha() + ", fontSize=" + ((Object) TextUnit.m2624toStringimpl(m2233getFontSizeXSAIIZE())) + ", fontWeight=" + getFontWeight() + ", fontStyle=" + m2234getFontStyle4Lr2A7w() + ", fontSynthesis=" + m2235getFontSynthesisZQGJjVo() + ", fontFamily=" + getFontFamily() + ", fontFeatureSettings=" + getFontFeatureSettings() + ", letterSpacing=" + ((Object) TextUnit.m2624toStringimpl(m2237getLetterSpacingXSAIIZE())) + ", baselineShift=" + m2231getBaselineShift5SSeXJ0() + ", textGeometricTransform=" + getTextGeometricTransform() + ", localeList=" + getLocaleList() + ", background=" + ((Object) Color.m1374toStringimpl(m2230getBackground0d7_KjU())) + ", textDecoration=" + getTextDecoration() + ", shadow=" + getShadow() + ", drawStyle=" + getDrawStyle() + ", textAlign=" + ((Object) TextAlign.m2479toStringimpl(m2240getTextAligne0LSkKk())) + ", textDirection=" + ((Object) TextDirection.m2493toStringimpl(m2241getTextDirections_7Xco())) + ", lineHeight=" + ((Object) TextUnit.m2624toStringimpl(m2239getLineHeightXSAIIZE())) + ", textIndent=" + getTextIndent() + ", platformStyle=" + this.platformStyle + ", lineHeightStyle=" + getLineHeightStyle() + ", lineBreak=" + ((Object) LineBreak.m2436toStringimpl(m2238getLineBreakrAG3T2k())) + ", hyphens=" + ((Object) Hyphens.m2423toStringimpl(m2236getHyphensvmbZdU8())) + ", textMotion=" + getTextMotion() + ')';
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TextStyle getDefault() {
            return TextStyle.Default;
        }
    }
}
