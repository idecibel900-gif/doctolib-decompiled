package com.facebook.react.uimanager.style;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class ColorEdges {
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColorEdges)) {
            return false;
        }
        ColorEdges colorEdges = (ColorEdges) obj;
        return this.left == colorEdges.left && this.top == colorEdges.top && this.right == colorEdges.right && this.bottom == colorEdges.bottom;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.left) * 31) + Integer.hashCode(this.top)) * 31) + Integer.hashCode(this.right)) * 31) + Integer.hashCode(this.bottom);
    }

    public String toString() {
        return "ColorEdges(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ")";
    }

    public ColorEdges(int i, int i2, int i3, int i4) {
        this.left = i;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
    }

    public /* synthetic */ ColorEdges(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? -16777216 : i, (i5 & 2) != 0 ? -16777216 : i2, (i5 & 4) != 0 ? -16777216 : i3, (i5 & 8) != 0 ? -16777216 : i4);
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getTop() {
        return this.top;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getBottom() {
        return this.bottom;
    }
}
