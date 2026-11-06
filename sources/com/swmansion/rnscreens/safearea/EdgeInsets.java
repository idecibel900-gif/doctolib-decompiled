package com.swmansion.rnscreens.safearea;

import androidx.core.graphics.Insets;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class EdgeInsets {
    public static final Companion Companion = new Companion(null);
    private static final EdgeInsets ZERO = new EdgeInsets(0.0f, 0.0f, 0.0f, 0.0f);
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EdgeInsets)) {
            return false;
        }
        EdgeInsets edgeInsets = (EdgeInsets) obj;
        return Float.compare(this.left, edgeInsets.left) == 0 && Float.compare(this.top, edgeInsets.top) == 0 && Float.compare(this.right, edgeInsets.right) == 0 && Float.compare(this.bottom, edgeInsets.bottom) == 0;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.left) * 31) + Float.hashCode(this.top)) * 31) + Float.hashCode(this.right)) * 31) + Float.hashCode(this.bottom);
    }

    public String toString() {
        return "EdgeInsets(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ")";
    }

    public EdgeInsets(float f, float f2, float f3, float f4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getTop() {
        return this.top;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EdgeInsets getZERO() {
            return EdgeInsets.ZERO;
        }

        public final EdgeInsets fromInsets(Insets insets) {
            Intrinsics.checkNotNullParameter(insets, "insets");
            return new EdgeInsets(insets.left, insets.top, insets.right, insets.bottom);
        }

        public final EdgeInsets max(EdgeInsets i1, EdgeInsets i2) {
            Intrinsics.checkNotNullParameter(i1, "i1");
            Intrinsics.checkNotNullParameter(i2, "i2");
            return new EdgeInsets(Math.max(i1.getLeft(), i2.getLeft()), Math.max(i1.getTop(), i2.getTop()), Math.max(i1.getRight(), i2.getRight()), Math.max(i1.getBottom(), i2.getBottom()));
        }
    }
}
