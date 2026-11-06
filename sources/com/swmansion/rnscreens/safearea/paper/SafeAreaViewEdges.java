package com.swmansion.rnscreens.safearea.paper;

import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class SafeAreaViewEdges {
    public static final Companion Companion = new Companion(null);
    private static final SafeAreaViewEdges ZERO = new SafeAreaViewEdges(false, false, false, false);
    private final boolean bottom;
    private final boolean left;
    private final boolean right;
    private final boolean top;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SafeAreaViewEdges)) {
            return false;
        }
        SafeAreaViewEdges safeAreaViewEdges = (SafeAreaViewEdges) obj;
        return this.left == safeAreaViewEdges.left && this.top == safeAreaViewEdges.top && this.right == safeAreaViewEdges.right && this.bottom == safeAreaViewEdges.bottom;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.left) * 31) + Boolean.hashCode(this.top)) * 31) + Boolean.hashCode(this.right)) * 31) + Boolean.hashCode(this.bottom);
    }

    public String toString() {
        return "SafeAreaViewEdges(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ")";
    }

    public SafeAreaViewEdges(boolean z, boolean z2, boolean z3, boolean z4) {
        this.left = z;
        this.top = z2;
        this.right = z3;
        this.bottom = z4;
    }

    public final boolean getLeft() {
        return this.left;
    }

    public final boolean getTop() {
        return this.top;
    }

    public final boolean getRight() {
        return this.right;
    }

    public final boolean getBottom() {
        return this.bottom;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SafeAreaViewEdges fromProp(ReadableMap readableMap) {
            if (readableMap != null) {
                return new SafeAreaViewEdges(readableMap.getBoolean("left"), readableMap.getBoolean("top"), readableMap.getBoolean("right"), readableMap.getBoolean("bottom"));
            }
            return null;
        }
    }
}
