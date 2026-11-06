package androidx.compose.ui.platform;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
final class MutableSpanStyle {
    private long background;
    private BaselineShift baselineShift;
    private long color;
    private FontFamily fontFamily;
    private String fontFeatureSettings;
    private long fontSize;
    private FontStyle fontStyle;
    private FontSynthesis fontSynthesis;
    private FontWeight fontWeight;
    private long letterSpacing;
    private LocaleList localeList;
    private Shadow shadow;
    private TextDecoration textDecoration;
    private TextGeometricTransform textGeometricTransform;

    public /* synthetic */ MutableSpanStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow);
    }

    private MutableSpanStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow) {
        this.color = j;
        this.fontSize = j2;
        this.fontWeight = fontWeight;
        this.fontStyle = fontStyle;
        this.fontSynthesis = fontSynthesis;
        this.fontFamily = fontFamily;
        this.fontFeatureSettings = str;
        this.letterSpacing = j3;
        this.baselineShift = baselineShift;
        this.textGeometricTransform = textGeometricTransform;
        this.localeList = localeList;
        this.background = j4;
        this.textDecoration = textDecoration;
        this.shadow = shadow;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MutableSpanStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, int i, DefaultConstructorMarker defaultConstructorMarker) {
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
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j5 = jM2626getUnspecifiedXSAIIZE2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j6 = jM1385getUnspecified0d7_KjU2;
        this(jM1385getUnspecified0d7_KjU, jM2626getUnspecifiedXSAIIZE, fontWeight2, fontStyle3, fontSynthesis3, fontFamily3, str3, j5, baselineShift3, textGeometricTransform3, localeList3, j6, (i & 4096) != 0 ? null : textDecoration, (i & 8192) != 0 ? null : shadow, null);
    }

    /* JADX INFO: renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m2073setColor8_81llA(long j) {
        this.color = j;
    }

    /* JADX INFO: renamed from: setFontSize--R2X_6o, reason: not valid java name */
    public final void m2074setFontSizeR2X_6o(long j) {
        this.fontSize = j;
    }

    public final void setFontWeight(FontWeight fontWeight) {
        this.fontWeight = fontWeight;
    }

    /* JADX INFO: renamed from: setFontStyle-mLjRB2g, reason: not valid java name */
    public final void m2075setFontStylemLjRB2g(FontStyle fontStyle) {
        this.fontStyle = fontStyle;
    }

    /* JADX INFO: renamed from: setFontSynthesis-tDdu0R4, reason: not valid java name */
    public final void m2076setFontSynthesistDdu0R4(FontSynthesis fontSynthesis) {
        this.fontSynthesis = fontSynthesis;
    }

    public final void setFontFeatureSettings(String str) {
        this.fontFeatureSettings = str;
    }

    /* JADX INFO: renamed from: setLetterSpacing--R2X_6o, reason: not valid java name */
    public final void m2077setLetterSpacingR2X_6o(long j) {
        this.letterSpacing = j;
    }

    /* JADX INFO: renamed from: setBaselineShift-_isdbwI, reason: not valid java name */
    public final void m2072setBaselineShift_isdbwI(BaselineShift baselineShift) {
        this.baselineShift = baselineShift;
    }

    public final void setTextGeometricTransform(TextGeometricTransform textGeometricTransform) {
        this.textGeometricTransform = textGeometricTransform;
    }

    /* JADX INFO: renamed from: setBackground-8_81llA, reason: not valid java name */
    public final void m2071setBackground8_81llA(long j) {
        this.background = j;
    }

    public final void setTextDecoration(TextDecoration textDecoration) {
        this.textDecoration = textDecoration;
    }

    public final void setShadow(Shadow shadow) {
        this.shadow = shadow;
    }

    public final SpanStyle toSpanStyle() {
        return new SpanStyle(this.color, this.fontSize, this.fontWeight, this.fontStyle, this.fontSynthesis, this.fontFamily, this.fontFeatureSettings, this.letterSpacing, this.baselineShift, this.textGeometricTransform, this.localeList, this.background, this.textDecoration, this.shadow, (PlatformSpanStyle) null, (DrawStyle) null, 49152, (DefaultConstructorMarker) null);
    }
}
