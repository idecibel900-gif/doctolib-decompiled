package com.swmansion.enriched.markdown.input.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class InputHeadingStyle {
    private final Integer color;
    private final Float fontSizePx;
    private final int fontWeight;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InputHeadingStyle)) {
            return false;
        }
        InputHeadingStyle inputHeadingStyle = (InputHeadingStyle) obj;
        return Intrinsics.areEqual(this.fontSizePx, inputHeadingStyle.fontSizePx) && this.fontWeight == inputHeadingStyle.fontWeight && Intrinsics.areEqual(this.color, inputHeadingStyle.color);
    }

    public int hashCode() {
        Float f = this.fontSizePx;
        int iHashCode = (((f == null ? 0 : f.hashCode()) * 31) + Integer.hashCode(this.fontWeight)) * 31;
        Integer num = this.color;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "InputHeadingStyle(fontSizePx=" + this.fontSizePx + ", fontWeight=" + this.fontWeight + ", color=" + this.color + ")";
    }

    public InputHeadingStyle(Float f, int i, Integer num) {
        this.fontSizePx = f;
        this.fontWeight = i;
        this.color = num;
    }

    public final Float getFontSizePx() {
        return this.fontSizePx;
    }

    public final int getFontWeight() {
        return this.fontWeight;
    }

    public final Integer getColor() {
        return this.color;
    }
}
