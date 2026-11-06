package com.facebook.react.uimanager.style;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ComputedBorderRadius {
    private final CornerRadii bottomLeft;
    private final CornerRadii bottomRight;
    private final CornerRadii topLeft;
    private final CornerRadii topRight;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComputedBorderRadius)) {
            return false;
        }
        ComputedBorderRadius computedBorderRadius = (ComputedBorderRadius) obj;
        return Intrinsics.areEqual(this.topLeft, computedBorderRadius.topLeft) && Intrinsics.areEqual(this.topRight, computedBorderRadius.topRight) && Intrinsics.areEqual(this.bottomLeft, computedBorderRadius.bottomLeft) && Intrinsics.areEqual(this.bottomRight, computedBorderRadius.bottomRight);
    }

    public int hashCode() {
        return (((((this.topLeft.hashCode() * 31) + this.topRight.hashCode()) * 31) + this.bottomLeft.hashCode()) * 31) + this.bottomRight.hashCode();
    }

    public String toString() {
        return "ComputedBorderRadius(topLeft=" + this.topLeft + ", topRight=" + this.topRight + ", bottomLeft=" + this.bottomLeft + ", bottomRight=" + this.bottomRight + ")";
    }

    public ComputedBorderRadius(CornerRadii topLeft, CornerRadii topRight, CornerRadii bottomLeft, CornerRadii bottomRight) {
        Intrinsics.checkNotNullParameter(topLeft, "topLeft");
        Intrinsics.checkNotNullParameter(topRight, "topRight");
        Intrinsics.checkNotNullParameter(bottomLeft, "bottomLeft");
        Intrinsics.checkNotNullParameter(bottomRight, "bottomRight");
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    public final CornerRadii getTopLeft() {
        return this.topLeft;
    }

    public final CornerRadii getTopRight() {
        return this.topRight;
    }

    public final CornerRadii getBottomLeft() {
        return this.bottomLeft;
    }

    public final CornerRadii getBottomRight() {
        return this.bottomRight;
    }

    public final boolean hasRoundedBorders() {
        return this.topLeft.getHorizontal() > 0.0f || this.topLeft.getVertical() > 0.0f || this.topRight.getHorizontal() > 0.0f || this.topRight.getVertical() > 0.0f || this.bottomLeft.getHorizontal() > 0.0f || this.bottomLeft.getVertical() > 0.0f || this.bottomRight.getHorizontal() > 0.0f;
    }

    public final boolean isUniform() {
        return Intrinsics.areEqual(this.topLeft, this.topRight) && Intrinsics.areEqual(this.topLeft, this.bottomLeft) && Intrinsics.areEqual(this.topLeft, this.bottomRight);
    }
}
