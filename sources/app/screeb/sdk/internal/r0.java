package app.screeb.sdk.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 {
    public final q0 a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public r0(q0 sourceRect, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(sourceRect, "sourceRect");
        this.a = sourceRect;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
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
        if (!(obj instanceof r0)) {
            return false;
        }
        r0 r0Var = (r0) obj;
        return Intrinsics.areEqual(this.a, r0Var.a) && this.b == r0Var.b && this.c == r0Var.c && this.d == r0Var.d && this.e == r0Var.e;
    }

    public final int hashCode() {
        return Integer.hashCode(this.e) + AbstractC0310k.a(this.d, AbstractC0310k.a(this.c, AbstractC0310k.a(this.b, this.a.hashCode() * 31, 31), 31), 31);
    }

    public final String toString() {
        return "Plan(sourceRect=" + this.a + ", worldX=" + this.b + ", worldY=" + this.c + ", captureW=" + this.d + ", captureH=" + this.e + ")";
    }
}
