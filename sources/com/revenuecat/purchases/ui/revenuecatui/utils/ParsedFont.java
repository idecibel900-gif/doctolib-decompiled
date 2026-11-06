package com.revenuecat.purchases.ui.revenuecatui.utils;

import androidx.compose.ui.text.font.FontStyle;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\u000f\u001a\u00020\u0006HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\tJ1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/utils/ParsedFont;", "", "resId", "", "weight", "style", "Landroidx/compose/ui/text/font/FontStyle;", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getResId", "()I", "getStyle-_-LCdwA", "I", "getWeight", "component1", "component2", "component3", "component3-_-LCdwA", "copy", "copy-RetOiIg", "(III)Lcom/revenuecat/purchases/ui/revenuecatui/utils/ParsedFont;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ParsedFont {
    public static final int $stable = 0;
    private final int resId;
    private final int style;
    private final int weight;

    public /* synthetic */ ParsedFont(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    /* JADX INFO: renamed from: copy-RetOiIg$default, reason: not valid java name */
    public static /* synthetic */ ParsedFont m4587copyRetOiIg$default(ParsedFont parsedFont, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = parsedFont.resId;
        }
        if ((i4 & 2) != 0) {
            i2 = parsedFont.weight;
        }
        if ((i4 & 4) != 0) {
            i3 = parsedFont.style;
        }
        return parsedFont.m4589copyRetOiIg(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getResId() {
        return this.resId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getWeight() {
        return this.weight;
    }

    /* JADX INFO: renamed from: component3-_-LCdwA, reason: not valid java name and from getter */
    public final int getStyle() {
        return this.style;
    }

    /* JADX INFO: renamed from: copy-RetOiIg, reason: not valid java name */
    public final ParsedFont m4589copyRetOiIg(int resId, int weight, int style) {
        return new ParsedFont(resId, weight, style, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParsedFont)) {
            return false;
        }
        ParsedFont parsedFont = (ParsedFont) other;
        return this.resId == parsedFont.resId && this.weight == parsedFont.weight && FontStyle.m2284equalsimpl0(this.style, parsedFont.style);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.resId) * 31) + Integer.hashCode(this.weight)) * 31) + FontStyle.m2285hashCodeimpl(this.style);
    }

    public String toString() {
        return "ParsedFont(resId=" + this.resId + ", weight=" + this.weight + ", style=" + ((Object) FontStyle.m2286toStringimpl(this.style)) + ')';
    }

    private ParsedFont(int i, int i2, int i3) {
        this.resId = i;
        this.weight = i2;
        this.style = i3;
    }

    public final int getResId() {
        return this.resId;
    }

    public final int getWeight() {
        return this.weight;
    }

    /* JADX INFO: renamed from: getStyle-_-LCdwA, reason: not valid java name */
    public final int m4590getStyle_LCdwA() {
        return this.style;
    }
}
