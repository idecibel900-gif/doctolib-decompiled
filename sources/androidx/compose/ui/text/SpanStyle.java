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
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes.dex */
public final class SpanStyle {
    private final long background;
    private final BaselineShift baselineShift;
    private final DrawStyle drawStyle;
    private final FontFamily fontFamily;
    private final String fontFeatureSettings;
    private final long fontSize;
    private final FontStyle fontStyle;
    private final FontSynthesis fontSynthesis;
    private final FontWeight fontWeight;
    private final long letterSpacing;
    private final LocaleList localeList;
    private final PlatformSpanStyle platformStyle;
    private final Shadow shadow;
    private final TextDecoration textDecoration;
    private final TextForegroundStyle textForegroundStyle;
    private final TextGeometricTransform textGeometricTransform;

    public /* synthetic */ SpanStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformSpanStyle, drawStyle);
    }

    public /* synthetic */ SpanStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, platformSpanStyle, drawStyle);
    }

    public /* synthetic */ SpanStyle(TextForegroundStyle textForegroundStyle, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(textForegroundStyle, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, platformSpanStyle, drawStyle);
    }

    private SpanStyle(TextForegroundStyle textForegroundStyle, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        this.textForegroundStyle = textForegroundStyle;
        this.fontSize = j;
        this.fontWeight = fontWeight;
        this.fontStyle = fontStyle;
        this.fontSynthesis = fontSynthesis;
        this.fontFamily = fontFamily;
        this.fontFeatureSettings = str;
        this.letterSpacing = j2;
        this.baselineShift = baselineShift;
        this.textGeometricTransform = textGeometricTransform;
        this.localeList = localeList;
        this.background = j3;
        this.textDecoration = textDecoration;
        this.shadow = shadow;
        this.platformStyle = platformSpanStyle;
        this.drawStyle = drawStyle;
    }

    public final TextForegroundStyle getTextForegroundStyle$ui_text_release() {
        return this.textForegroundStyle;
    }

    /* JADX INFO: renamed from: getFontSize-XSAIIZE, reason: not valid java name */
    public final long m2188getFontSizeXSAIIZE() {
        return this.fontSize;
    }

    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    /* JADX INFO: renamed from: getFontStyle-4Lr2A7w, reason: not valid java name */
    public final FontStyle m2189getFontStyle4Lr2A7w() {
        return this.fontStyle;
    }

    /* JADX INFO: renamed from: getFontSynthesis-ZQGJjVo, reason: not valid java name */
    public final FontSynthesis m2190getFontSynthesisZQGJjVo() {
        return this.fontSynthesis;
    }

    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    /* JADX INFO: renamed from: getLetterSpacing-XSAIIZE, reason: not valid java name */
    public final long m2191getLetterSpacingXSAIIZE() {
        return this.letterSpacing;
    }

    /* JADX INFO: renamed from: getBaselineShift-5SSeXJ0, reason: not valid java name */
    public final BaselineShift m2186getBaselineShift5SSeXJ0() {
        return this.baselineShift;
    }

    public final TextGeometricTransform getTextGeometricTransform() {
        return this.textGeometricTransform;
    }

    public final LocaleList getLocaleList() {
        return this.localeList;
    }

    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m2185getBackground0d7_KjU() {
        return this.background;
    }

    public final TextDecoration getTextDecoration() {
        return this.textDecoration;
    }

    public final Shadow getShadow() {
        return this.shadow;
    }

    public final PlatformSpanStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public final DrawStyle getDrawStyle() {
        return this.drawStyle;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SpanStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long jM1385getUnspecified0d7_KjU = (i & 1) != 0 ? Color.Companion.m1385getUnspecified0d7_KjU() : j;
        long jM2626getUnspecifiedXSAIIZE = (i & 2) != 0 ? TextUnit.Companion.m2626getUnspecifiedXSAIIZE() : j2;
        FontWeight fontWeight2 = (i & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i & 8) != 0 ? null : fontStyle;
        FontSynthesis fontSynthesis2 = (i & 16) != 0 ? null : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? null : fontFamily;
        String str2 = (i & 64) != 0 ? null : str;
        long jM2626getUnspecifiedXSAIIZE2 = (i & 128) != 0 ? TextUnit.Companion.m2626getUnspecifiedXSAIIZE() : j3;
        BaselineShift baselineShift2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : textGeometricTransform;
        LocaleList localeList2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : localeList;
        long jM1385getUnspecified0d7_KjU2 = (i & 2048) != 0 ? Color.Companion.m1385getUnspecified0d7_KjU() : j4;
        TextDecoration textDecoration2 = (i & 4096) != 0 ? null : textDecoration;
        long j5 = jM1385getUnspecified0d7_KjU;
        Shadow shadow2 = (i & 8192) != 0 ? null : shadow;
        PlatformSpanStyle platformSpanStyle2 = (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : platformSpanStyle;
        long j6 = jM2626getUnspecifiedXSAIIZE;
        FontWeight fontWeight3 = fontWeight2;
        TextDecoration textDecoration3 = textDecoration2;
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j7 = jM2626getUnspecifiedXSAIIZE2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j8 = jM1385getUnspecified0d7_KjU2;
        this(j5, j6, fontWeight3, fontStyle3, fontSynthesis3, fontFamily3, str3, j7, baselineShift3, textGeometricTransform3, localeList3, j8, textDecoration3, shadow2, platformSpanStyle2, (i & 32768) != 0 ? null : drawStyle, (DefaultConstructorMarker) null);
    }

    private SpanStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        this(TextForegroundStyle.Companion.m2502from8_81llA(j), j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformSpanStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    private SpanStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        this(TextForegroundStyle.Companion.from(brush, f), j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, platformSpanStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m2187getColor0d7_KjU() {
        return this.textForegroundStyle.mo2417getColor0d7_KjU();
    }

    public final Brush getBrush() {
        return this.textForegroundStyle.getBrush();
    }

    public final float getAlpha() {
        return this.textForegroundStyle.getAlpha();
    }

    public final SpanStyle merge(SpanStyle spanStyle) {
        return spanStyle == null ? this : SpanStyleKt.m2192fastMergedSHsh3o(this, spanStyle.textForegroundStyle.mo2417getColor0d7_KjU(), spanStyle.textForegroundStyle.getBrush(), spanStyle.textForegroundStyle.getAlpha(), spanStyle.fontSize, spanStyle.fontWeight, spanStyle.fontStyle, spanStyle.fontSynthesis, spanStyle.fontFamily, spanStyle.fontFeatureSettings, spanStyle.letterSpacing, spanStyle.baselineShift, spanStyle.textGeometricTransform, spanStyle.localeList, spanStyle.background, spanStyle.textDecoration, spanStyle.shadow, spanStyle.platformStyle, spanStyle.drawStyle);
    }

    public final SpanStyle plus(SpanStyle spanStyle) {
        return merge(spanStyle);
    }

    /* JADX INFO: renamed from: copy-GSF8kmg$default, reason: not valid java name */
    public static /* synthetic */ SpanStyle m2183copyGSF8kmg$default(SpanStyle spanStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, int i, Object obj) {
        long jM2187getColor0d7_KjU = (i & 1) != 0 ? spanStyle.m2187getColor0d7_KjU() : j;
        return spanStyle.m2184copyGSF8kmg(jM2187getColor0d7_KjU, (i & 2) != 0 ? spanStyle.fontSize : j2, (i & 4) != 0 ? spanStyle.fontWeight : fontWeight, (i & 8) != 0 ? spanStyle.fontStyle : fontStyle, (i & 16) != 0 ? spanStyle.fontSynthesis : fontSynthesis, (i & 32) != 0 ? spanStyle.fontFamily : fontFamily, (i & 64) != 0 ? spanStyle.fontFeatureSettings : str, (i & 128) != 0 ? spanStyle.letterSpacing : j3, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? spanStyle.baselineShift : baselineShift, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? spanStyle.textGeometricTransform : textGeometricTransform, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? spanStyle.localeList : localeList, (i & 2048) != 0 ? spanStyle.background : j4, (i & 4096) != 0 ? spanStyle.textDecoration : textDecoration, (i & 8192) != 0 ? spanStyle.shadow : shadow, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? spanStyle.platformStyle : platformSpanStyle, (i & 32768) != 0 ? spanStyle.drawStyle : drawStyle);
    }

    /* JADX INFO: renamed from: copy-GSF8kmg, reason: not valid java name */
    public final SpanStyle m2184copyGSF8kmg(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        TextForegroundStyle textForegroundStyleM2502from8_81llA;
        if (Color.m1367equalsimpl0(j, m2187getColor0d7_KjU())) {
            textForegroundStyleM2502from8_81llA = this.textForegroundStyle;
        } else {
            textForegroundStyleM2502from8_81llA = TextForegroundStyle.Companion.m2502from8_81llA(j);
        }
        return new SpanStyle(textForegroundStyleM2502from8_81llA, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformSpanStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpanStyle)) {
            return false;
        }
        SpanStyle spanStyle = (SpanStyle) obj;
        return hasSameLayoutAffectingAttributes$ui_text_release(spanStyle) && hasSameNonLayoutAttributes$ui_text_release(spanStyle);
    }

    public final boolean hasSameLayoutAffectingAttributes$ui_text_release(SpanStyle spanStyle) {
        if (this == spanStyle) {
            return true;
        }
        return TextUnit.m2619equalsimpl0(this.fontSize, spanStyle.fontSize) && Intrinsics.areEqual(this.fontWeight, spanStyle.fontWeight) && Intrinsics.areEqual(this.fontStyle, spanStyle.fontStyle) && Intrinsics.areEqual(this.fontSynthesis, spanStyle.fontSynthesis) && Intrinsics.areEqual(this.fontFamily, spanStyle.fontFamily) && Intrinsics.areEqual(this.fontFeatureSettings, spanStyle.fontFeatureSettings) && TextUnit.m2619equalsimpl0(this.letterSpacing, spanStyle.letterSpacing) && Intrinsics.areEqual(this.baselineShift, spanStyle.baselineShift) && Intrinsics.areEqual(this.textGeometricTransform, spanStyle.textGeometricTransform) && Intrinsics.areEqual(this.localeList, spanStyle.localeList) && Color.m1367equalsimpl0(this.background, spanStyle.background) && Intrinsics.areEqual(this.platformStyle, spanStyle.platformStyle);
    }

    public final boolean hasSameNonLayoutAttributes$ui_text_release(SpanStyle spanStyle) {
        return Intrinsics.areEqual(this.textForegroundStyle, spanStyle.textForegroundStyle) && Intrinsics.areEqual(this.textDecoration, spanStyle.textDecoration) && Intrinsics.areEqual(this.shadow, spanStyle.shadow) && Intrinsics.areEqual(this.drawStyle, spanStyle.drawStyle);
    }

    public int hashCode() {
        int iM1373hashCodeimpl = Color.m1373hashCodeimpl(m2187getColor0d7_KjU()) * 31;
        Brush brush = getBrush();
        int iHashCode = (((((iM1373hashCodeimpl + (brush != null ? brush.hashCode() : 0)) * 31) + Float.hashCode(getAlpha())) * 31) + TextUnit.m2623hashCodeimpl(this.fontSize)) * 31;
        FontWeight fontWeight = this.fontWeight;
        int iHashCode2 = (iHashCode + (fontWeight != null ? fontWeight.hashCode() : 0)) * 31;
        FontStyle fontStyle = this.fontStyle;
        int iM2285hashCodeimpl = (iHashCode2 + (fontStyle != null ? FontStyle.m2285hashCodeimpl(fontStyle.m2287unboximpl()) : 0)) * 31;
        FontSynthesis fontSynthesis = this.fontSynthesis;
        int iM2294hashCodeimpl = (iM2285hashCodeimpl + (fontSynthesis != null ? FontSynthesis.m2294hashCodeimpl(fontSynthesis.m2298unboximpl()) : 0)) * 31;
        FontFamily fontFamily = this.fontFamily;
        int iHashCode3 = (iM2294hashCodeimpl + (fontFamily != null ? fontFamily.hashCode() : 0)) * 31;
        String str = this.fontFeatureSettings;
        int iHashCode4 = (((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31) + TextUnit.m2623hashCodeimpl(this.letterSpacing)) * 31;
        BaselineShift baselineShift = this.baselineShift;
        int iM2412hashCodeimpl = (iHashCode4 + (baselineShift != null ? BaselineShift.m2412hashCodeimpl(baselineShift.m2414unboximpl()) : 0)) * 31;
        TextGeometricTransform textGeometricTransform = this.textGeometricTransform;
        int iHashCode5 = (iM2412hashCodeimpl + (textGeometricTransform != null ? textGeometricTransform.hashCode() : 0)) * 31;
        LocaleList localeList = this.localeList;
        int iHashCode6 = (((iHashCode5 + (localeList != null ? localeList.hashCode() : 0)) * 31) + Color.m1373hashCodeimpl(this.background)) * 31;
        TextDecoration textDecoration = this.textDecoration;
        int iHashCode7 = (iHashCode6 + (textDecoration != null ? textDecoration.hashCode() : 0)) * 31;
        Shadow shadow = this.shadow;
        int iHashCode8 = (iHashCode7 + (shadow != null ? shadow.hashCode() : 0)) * 31;
        PlatformSpanStyle platformSpanStyle = this.platformStyle;
        int iHashCode9 = (iHashCode8 + (platformSpanStyle != null ? platformSpanStyle.hashCode() : 0)) * 31;
        DrawStyle drawStyle = this.drawStyle;
        return iHashCode9 + (drawStyle != null ? drawStyle.hashCode() : 0);
    }

    public String toString() {
        return "SpanStyle(color=" + ((Object) Color.m1374toStringimpl(m2187getColor0d7_KjU())) + ", brush=" + getBrush() + ", alpha=" + getAlpha() + ", fontSize=" + ((Object) TextUnit.m2624toStringimpl(this.fontSize)) + ", fontWeight=" + this.fontWeight + ", fontStyle=" + this.fontStyle + ", fontSynthesis=" + this.fontSynthesis + ", fontFamily=" + this.fontFamily + ", fontFeatureSettings=" + this.fontFeatureSettings + ", letterSpacing=" + ((Object) TextUnit.m2624toStringimpl(this.letterSpacing)) + ", baselineShift=" + this.baselineShift + ", textGeometricTransform=" + this.textGeometricTransform + ", localeList=" + this.localeList + ", background=" + ((Object) Color.m1374toStringimpl(this.background)) + ", textDecoration=" + this.textDecoration + ", shadow=" + this.shadow + ", platformStyle=" + this.platformStyle + ", drawStyle=" + this.drawStyle + ')';
    }
}
