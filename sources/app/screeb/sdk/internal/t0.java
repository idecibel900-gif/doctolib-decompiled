package app.screeb.sdk.internal;

import android.graphics.Rect;
import android.view.SurfaceView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class t0 {
    public final SurfaceView a;
    public final int b;
    public final int c;
    public final Rect d;

    public t0(SurfaceView view, int i, int i2, Rect boundsInWindow) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(boundsInWindow, "boundsInWindow");
        this.a = view;
        this.b = i;
        this.c = i2;
        this.d = boundsInWindow;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t0)) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return Intrinsics.areEqual(this.a, t0Var.a) && this.b == t0Var.b && this.c == t0Var.c && Intrinsics.areEqual(this.d, t0Var.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + AbstractC0310k.a(this.c, AbstractC0310k.a(this.b, this.a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        return "SurfaceCaptureTarget(view=" + this.a + ", key=" + this.b + ", ordinal=" + this.c + ", boundsInWindow=" + this.d + ")";
    }
}
