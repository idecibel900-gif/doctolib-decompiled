package androidx.window.core.layout;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class WindowSizeClass {
    public static final Companion Companion = new Companion(null);
    private final WindowHeightSizeClass windowHeightSizeClass;
    private final WindowWidthSizeClass windowWidthSizeClass;

    public /* synthetic */ WindowSizeClass(WindowWidthSizeClass windowWidthSizeClass, WindowHeightSizeClass windowHeightSizeClass, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowWidthSizeClass, windowHeightSizeClass);
    }

    private WindowSizeClass(WindowWidthSizeClass windowWidthSizeClass, WindowHeightSizeClass windowHeightSizeClass) {
        this.windowWidthSizeClass = windowWidthSizeClass;
        this.windowHeightSizeClass = windowHeightSizeClass;
    }

    public final WindowWidthSizeClass getWindowWidthSizeClass() {
        return this.windowWidthSizeClass;
    }

    public final WindowHeightSizeClass getWindowHeightSizeClass() {
        return this.windowHeightSizeClass;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(WindowSizeClass.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.window.core.layout.WindowSizeClass");
        WindowSizeClass windowSizeClass = (WindowSizeClass) obj;
        return Intrinsics.areEqual(this.windowWidthSizeClass, windowSizeClass.windowWidthSizeClass) && Intrinsics.areEqual(this.windowHeightSizeClass, windowSizeClass.windowHeightSizeClass);
    }

    public int hashCode() {
        return (this.windowWidthSizeClass.hashCode() * 31) + this.windowHeightSizeClass.hashCode();
    }

    public String toString() {
        return "WindowSizeClass {windowWidthSizeClass=" + this.windowWidthSizeClass + ", windowHeightSizeClass=" + this.windowHeightSizeClass + " }";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WindowSizeClass compute(float f, float f2) {
            return new WindowSizeClass(WindowWidthSizeClass.Companion.compute$window_core_release(f), WindowHeightSizeClass.Companion.compute$window_core_release(f2), null);
        }
    }
}
