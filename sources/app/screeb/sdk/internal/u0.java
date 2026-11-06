package app.screeb.sdk.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class u0 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final float f;
    public final int g;
    public final boolean h;

    public u0(int i, int i2, int i3, int i4, int i5, float f, int i6, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = f;
        this.g = i6;
        this.h = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u0)) {
            return false;
        }
        u0 u0Var = (u0) obj;
        return this.a == u0Var.a && this.b == u0Var.b && this.c == u0Var.c && this.d == u0Var.d && this.e == u0Var.e && Float.compare(this.f, u0Var.f) == 0 && this.g == u0Var.g && this.h == u0Var.h;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.h) + AbstractC0310k.a(this.g, (Float.hashCode(this.f) + AbstractC0310k.a(this.e, AbstractC0310k.a(this.d, AbstractC0310k.a(this.c, AbstractC0310k.a(this.b, Integer.hashCode(this.a) * 31, 31), 31), 31), 31)) * 31, 31);
    }

    public final String toString() {
        return "Region(left=" + this.a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + ", charCount=" + this.e + ", textSizePx=" + this.f + ", bgColor=" + this.g + ", opaqueBlock=" + this.h + ")";
    }
}
