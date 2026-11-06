package androidx.compose.ui.text;

import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class ParagraphStyle {
    private final int hyphens;
    private final int lineBreak;
    private final long lineHeight;
    private final LineHeightStyle lineHeightStyle;
    private final PlatformParagraphStyle platformStyle;
    private final int textAlign;
    private final int textDirection;
    private final TextIndent textIndent;
    private final TextMotion textMotion;

    public /* synthetic */ ParagraphStyle(int i, int i2, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, j, textIndent, platformParagraphStyle, lineHeightStyle, i3, i4, textMotion);
    }

    private ParagraphStyle(int i, int i2, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion) {
        this.textAlign = i;
        this.textDirection = i2;
        this.lineHeight = j;
        this.textIndent = textIndent;
        this.platformStyle = platformParagraphStyle;
        this.lineHeightStyle = lineHeightStyle;
        this.lineBreak = i3;
        this.hyphens = i4;
        this.textMotion = textMotion;
        if (TextUnit.m2619equalsimpl0(j, TextUnit.Companion.m2626getUnspecifiedXSAIIZE()) || TextUnit.m2622getValueimpl(j) >= 0.0f) {
            return;
        }
        throw new IllegalStateException(("lineHeight can't be negative (" + TextUnit.m2622getValueimpl(j) + ')').toString());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ParagraphStyle(int i, int i2, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        int iM2487getUnspecifiede0LSkKk = (i5 & 1) != 0 ? TextAlign.Companion.m2487getUnspecifiede0LSkKk() : i;
        int iM2500getUnspecifieds_7Xco = (i5 & 2) != 0 ? TextDirection.Companion.m2500getUnspecifieds_7Xco() : i2;
        long jM2626getUnspecifiedXSAIIZE = (i5 & 4) != 0 ? TextUnit.Companion.m2626getUnspecifiedXSAIIZE() : j;
        TextIndent textIndent2 = (i5 & 8) != 0 ? null : textIndent;
        PlatformParagraphStyle platformParagraphStyle2 = (i5 & 16) != 0 ? null : platformParagraphStyle;
        LineHeightStyle lineHeightStyle2 = (i5 & 32) != 0 ? null : lineHeightStyle;
        int iM2439getUnspecifiedrAG3T2k = (i5 & 64) != 0 ? LineBreak.Companion.m2439getUnspecifiedrAG3T2k() : i3;
        int iM2427getUnspecifiedvmbZdU8 = (i5 & 128) != 0 ? Hyphens.Companion.m2427getUnspecifiedvmbZdU8() : i4;
        this(iM2487getUnspecifiede0LSkKk, iM2500getUnspecifieds_7Xco, jM2626getUnspecifiedXSAIIZE, textIndent2, platformParagraphStyle2, lineHeightStyle2, iM2439getUnspecifiedrAG3T2k, iM2427getUnspecifiedvmbZdU8, (i5 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 0 ? textMotion : null, null);
    }

    /* JADX INFO: renamed from: getTextAlign-e0LSkKk, reason: not valid java name */
    public final int m2169getTextAligne0LSkKk() {
        return this.textAlign;
    }

    /* JADX INFO: renamed from: getTextDirection-s_7X-co, reason: not valid java name */
    public final int m2170getTextDirections_7Xco() {
        return this.textDirection;
    }

    /* JADX INFO: renamed from: getLineHeight-XSAIIZE, reason: not valid java name */
    public final long m2168getLineHeightXSAIIZE() {
        return this.lineHeight;
    }

    public final TextIndent getTextIndent() {
        return this.textIndent;
    }

    public final PlatformParagraphStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public final LineHeightStyle getLineHeightStyle() {
        return this.lineHeightStyle;
    }

    /* JADX INFO: renamed from: getLineBreak-rAG3T2k, reason: not valid java name */
    public final int m2167getLineBreakrAG3T2k() {
        return this.lineBreak;
    }

    /* JADX INFO: renamed from: getHyphens-vmbZdU8, reason: not valid java name */
    public final int m2166getHyphensvmbZdU8() {
        return this.hyphens;
    }

    public final TextMotion getTextMotion() {
        return this.textMotion;
    }

    public final ParagraphStyle merge(ParagraphStyle paragraphStyle) {
        return paragraphStyle == null ? this : ParagraphStyleKt.m2171fastMergej5T8yCg(this, paragraphStyle.textAlign, paragraphStyle.textDirection, paragraphStyle.lineHeight, paragraphStyle.textIndent, paragraphStyle.platformStyle, paragraphStyle.lineHeightStyle, paragraphStyle.lineBreak, paragraphStyle.hyphens, paragraphStyle.textMotion);
    }

    /* JADX INFO: renamed from: copy-ykzQM6k$default, reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m2164copyykzQM6k$default(ParagraphStyle paragraphStyle, int i, int i2, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = paragraphStyle.textAlign;
        }
        if ((i5 & 2) != 0) {
            i2 = paragraphStyle.textDirection;
        }
        if ((i5 & 4) != 0) {
            j = paragraphStyle.lineHeight;
        }
        if ((i5 & 8) != 0) {
            textIndent = paragraphStyle.textIndent;
        }
        if ((i5 & 16) != 0) {
            platformParagraphStyle = paragraphStyle.platformStyle;
        }
        if ((i5 & 32) != 0) {
            lineHeightStyle = paragraphStyle.lineHeightStyle;
        }
        if ((i5 & 64) != 0) {
            i3 = paragraphStyle.lineBreak;
        }
        if ((i5 & 128) != 0) {
            i4 = paragraphStyle.hyphens;
        }
        if ((i5 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
            textMotion = paragraphStyle.textMotion;
        }
        int i6 = i4;
        TextMotion textMotion2 = textMotion;
        long j2 = j;
        return paragraphStyle.m2165copyykzQM6k(i, i2, j2, textIndent, platformParagraphStyle, lineHeightStyle, i3, i6, textMotion2);
    }

    /* JADX INFO: renamed from: copy-ykzQM6k, reason: not valid java name */
    public final ParagraphStyle m2165copyykzQM6k(int i, int i2, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion) {
        return new ParagraphStyle(i, i2, j, textIndent, platformParagraphStyle, lineHeightStyle, i3, i4, textMotion, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphStyle)) {
            return false;
        }
        ParagraphStyle paragraphStyle = (ParagraphStyle) obj;
        return TextAlign.m2477equalsimpl0(this.textAlign, paragraphStyle.textAlign) && TextDirection.m2491equalsimpl0(this.textDirection, paragraphStyle.textDirection) && TextUnit.m2619equalsimpl0(this.lineHeight, paragraphStyle.lineHeight) && Intrinsics.areEqual(this.textIndent, paragraphStyle.textIndent) && Intrinsics.areEqual(this.platformStyle, paragraphStyle.platformStyle) && Intrinsics.areEqual(this.lineHeightStyle, paragraphStyle.lineHeightStyle) && LineBreak.m2431equalsimpl0(this.lineBreak, paragraphStyle.lineBreak) && Hyphens.m2421equalsimpl0(this.hyphens, paragraphStyle.hyphens) && Intrinsics.areEqual(this.textMotion, paragraphStyle.textMotion);
    }

    public int hashCode() {
        int iM2478hashCodeimpl = ((((TextAlign.m2478hashCodeimpl(this.textAlign) * 31) + TextDirection.m2492hashCodeimpl(this.textDirection)) * 31) + TextUnit.m2623hashCodeimpl(this.lineHeight)) * 31;
        TextIndent textIndent = this.textIndent;
        int iHashCode = (iM2478hashCodeimpl + (textIndent != null ? textIndent.hashCode() : 0)) * 31;
        PlatformParagraphStyle platformParagraphStyle = this.platformStyle;
        int iHashCode2 = (iHashCode + (platformParagraphStyle != null ? platformParagraphStyle.hashCode() : 0)) * 31;
        LineHeightStyle lineHeightStyle = this.lineHeightStyle;
        int iHashCode3 = (((((iHashCode2 + (lineHeightStyle != null ? lineHeightStyle.hashCode() : 0)) * 31) + LineBreak.m2435hashCodeimpl(this.lineBreak)) * 31) + Hyphens.m2422hashCodeimpl(this.hyphens)) * 31;
        TextMotion textMotion = this.textMotion;
        return iHashCode3 + (textMotion != null ? textMotion.hashCode() : 0);
    }

    public String toString() {
        return "ParagraphStyle(textAlign=" + ((Object) TextAlign.m2479toStringimpl(this.textAlign)) + ", textDirection=" + ((Object) TextDirection.m2493toStringimpl(this.textDirection)) + ", lineHeight=" + ((Object) TextUnit.m2624toStringimpl(this.lineHeight)) + ", textIndent=" + this.textIndent + ", platformStyle=" + this.platformStyle + ", lineHeightStyle=" + this.lineHeightStyle + ", lineBreak=" + ((Object) LineBreak.m2436toStringimpl(this.lineBreak)) + ", hyphens=" + ((Object) Hyphens.m2423toStringimpl(this.hyphens)) + ", textMotion=" + this.textMotion + ')';
    }
}
