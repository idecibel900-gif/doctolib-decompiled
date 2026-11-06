package androidx.window.core.layout;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class WindowWidthSizeClass {
    private final int rawValue;
    public static final Companion Companion = new Companion(null);
    public static final WindowWidthSizeClass COMPACT = new WindowWidthSizeClass(0);
    public static final WindowWidthSizeClass MEDIUM = new WindowWidthSizeClass(1);
    public static final WindowWidthSizeClass EXPANDED = new WindowWidthSizeClass(2);

    private WindowWidthSizeClass(int i) {
        this.rawValue = i;
    }

    public String toString() {
        String str;
        if (Intrinsics.areEqual(this, COMPACT)) {
            str = "COMPACT";
        } else if (Intrinsics.areEqual(this, MEDIUM)) {
            str = "MEDIUM";
        } else {
            str = Intrinsics.areEqual(this, EXPANDED) ? "EXPANDED" : "UNKNOWN";
        }
        return "WindowWidthSizeClass: " + str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && WindowWidthSizeClass.class == obj.getClass() && this.rawValue == ((WindowWidthSizeClass) obj).rawValue;
    }

    public int hashCode() {
        return this.rawValue;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WindowWidthSizeClass compute$window_core_release(float f) {
            if (f < 0.0f) {
                throw new IllegalArgumentException(("Width must be positive, received " + f).toString());
            }
            if (f < 600.0f) {
                return WindowWidthSizeClass.COMPACT;
            }
            if (f < 840.0f) {
                return WindowWidthSizeClass.MEDIUM;
            }
            return WindowWidthSizeClass.EXPANDED;
        }
    }
}
