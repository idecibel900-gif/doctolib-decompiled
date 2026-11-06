package androidx.window.layout;

import android.graphics.Rect;
import androidx.core.view.WindowInsetsCompat;
import androidx.window.core.Bounds;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class WindowMetrics {
    private final Bounds _bounds;
    private final WindowInsetsCompat _windowInsetsCompat;

    public WindowMetrics(Bounds _bounds, WindowInsetsCompat _windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(_bounds, "_bounds");
        Intrinsics.checkNotNullParameter(_windowInsetsCompat, "_windowInsetsCompat");
        this._bounds = _bounds;
        this._windowInsetsCompat = _windowInsetsCompat;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WindowMetrics(Rect rect, WindowInsetsCompat windowInsetsCompat, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            windowInsetsCompat = new WindowInsetsCompat.Builder().build();
            Intrinsics.checkNotNullExpressionValue(windowInsetsCompat, "Builder().build()");
        }
        this(rect, windowInsetsCompat);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WindowMetrics(Rect bounds, WindowInsetsCompat insets) {
        this(new Bounds(bounds), insets);
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(insets, "insets");
    }

    public final Rect getBounds() {
        return this._bounds.toRect();
    }

    public String toString() {
        return "WindowMetrics( bounds=" + this._bounds + ", windowInsetsCompat=" + this._windowInsetsCompat + ')';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(WindowMetrics.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.window.layout.WindowMetrics");
        WindowMetrics windowMetrics = (WindowMetrics) obj;
        return Intrinsics.areEqual(this._bounds, windowMetrics._bounds) && Intrinsics.areEqual(this._windowInsetsCompat, windowMetrics._windowInsetsCompat);
    }

    public int hashCode() {
        return (this._bounds.hashCode() * 31) + this._windowInsetsCompat.hashCode();
    }
}
