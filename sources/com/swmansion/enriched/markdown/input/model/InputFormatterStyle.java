package com.swmansion.enriched.markdown.input.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class InputFormatterStyle {
    private final Integer boldColor;
    private final List headings;
    private final Integer italicColor;
    private final int linkBackgroundColor;
    private final int linkColor;
    private final boolean linkUnderline;
    private final List linkVariants;
    private final float listItemSpacing;
    private final int spoilerBackgroundColor;
    private final int spoilerColor;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InputFormatterStyle)) {
            return false;
        }
        InputFormatterStyle inputFormatterStyle = (InputFormatterStyle) obj;
        return Intrinsics.areEqual(this.boldColor, inputFormatterStyle.boldColor) && Intrinsics.areEqual(this.italicColor, inputFormatterStyle.italicColor) && this.linkColor == inputFormatterStyle.linkColor && this.linkUnderline == inputFormatterStyle.linkUnderline && this.linkBackgroundColor == inputFormatterStyle.linkBackgroundColor && Intrinsics.areEqual(this.linkVariants, inputFormatterStyle.linkVariants) && this.spoilerColor == inputFormatterStyle.spoilerColor && this.spoilerBackgroundColor == inputFormatterStyle.spoilerBackgroundColor && Intrinsics.areEqual(this.headings, inputFormatterStyle.headings) && Float.compare(this.listItemSpacing, inputFormatterStyle.listItemSpacing) == 0;
    }

    public int hashCode() {
        Integer num = this.boldColor;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.italicColor;
        return ((((((((((((((((iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31) + Integer.hashCode(this.linkColor)) * 31) + Boolean.hashCode(this.linkUnderline)) * 31) + Integer.hashCode(this.linkBackgroundColor)) * 31) + this.linkVariants.hashCode()) * 31) + Integer.hashCode(this.spoilerColor)) * 31) + Integer.hashCode(this.spoilerBackgroundColor)) * 31) + this.headings.hashCode()) * 31) + Float.hashCode(this.listItemSpacing);
    }

    public String toString() {
        return "InputFormatterStyle(boldColor=" + this.boldColor + ", italicColor=" + this.italicColor + ", linkColor=" + this.linkColor + ", linkUnderline=" + this.linkUnderline + ", linkBackgroundColor=" + this.linkBackgroundColor + ", linkVariants=" + this.linkVariants + ", spoilerColor=" + this.spoilerColor + ", spoilerBackgroundColor=" + this.spoilerBackgroundColor + ", headings=" + this.headings + ", listItemSpacing=" + this.listItemSpacing + ")";
    }

    public InputFormatterStyle(Integer num, Integer num2, int i, boolean z, int i2, List linkVariants, int i3, int i4, List headings, float f) {
        Intrinsics.checkNotNullParameter(linkVariants, "linkVariants");
        Intrinsics.checkNotNullParameter(headings, "headings");
        this.boldColor = num;
        this.italicColor = num2;
        this.linkColor = i;
        this.linkUnderline = z;
        this.linkBackgroundColor = i2;
        this.linkVariants = linkVariants;
        this.spoilerColor = i3;
        this.spoilerBackgroundColor = i4;
        this.headings = headings;
        this.listItemSpacing = f;
    }

    public final Integer getBoldColor() {
        return this.boldColor;
    }

    public final Integer getItalicColor() {
        return this.italicColor;
    }

    public final int getLinkColor() {
        return this.linkColor;
    }

    public final boolean getLinkUnderline() {
        return this.linkUnderline;
    }

    public final int getLinkBackgroundColor() {
        return this.linkBackgroundColor;
    }

    public final List getLinkVariants() {
        return this.linkVariants;
    }

    public final int getSpoilerColor() {
        return this.spoilerColor;
    }

    public final int getSpoilerBackgroundColor() {
        return this.spoilerBackgroundColor;
    }

    public final float getListItemSpacing() {
        return this.listItemSpacing;
    }

    public final InputHeadingStyle headingStyle(int i) {
        List list = this.headings;
        return (InputHeadingStyle) list.get(RangesKt.coerceIn(i - 1, 0, list.size() - 1));
    }
}
