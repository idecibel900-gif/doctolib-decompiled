package androidx.window.core.layout;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class WindowHeightSizeClass {
    private final int rawValue;
    public static final Companion Companion = new Companion(null);
    public static final WindowHeightSizeClass COMPACT = new WindowHeightSizeClass(0);
    public static final WindowHeightSizeClass MEDIUM = new WindowHeightSizeClass(1);
    public static final WindowHeightSizeClass EXPANDED = new WindowHeightSizeClass(2);

    private WindowHeightSizeClass(int i) {
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
        return "WindowHeightSizeClass: " + str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && WindowHeightSizeClass.class == obj.getClass() && this.rawValue == ((WindowHeightSizeClass) obj).rawValue;
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

        public final WindowHeightSizeClass compute$window_core_release(float f) {
            if (f < 0.0f) {
                throw new IllegalArgumentException(("Height must be positive, received " + f).toString());
            }
            if (f < 480.0f) {
                return WindowHeightSizeClass.COMPACT;
            }
            if (f < 900.0f) {
                return WindowHeightSizeClass.MEDIUM;
            }
            return WindowHeightSizeClass.EXPANDED;
        }
    }
}
