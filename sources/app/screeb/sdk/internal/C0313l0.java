package app.screeb.sdk.internal;

/* JADX INFO: renamed from: app.screeb.sdk.internal.l0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0313l0 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public C0313l0(int i, int i2, int i3, int i4, int i5, int i6) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0313l0)) {
            return false;
        }
        C0313l0 c0313l0 = (C0313l0) obj;
        return this.a == c0313l0.a && this.b == c0313l0.b && this.c == c0313l0.c && this.d == c0313l0.d && this.e == c0313l0.e && this.f == c0313l0.f;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f) + AbstractC0310k.a(this.e, AbstractC0310k.a(this.d, AbstractC0310k.a(this.c, AbstractC0310k.a(this.b, Integer.hashCode(this.a) * 31, 31), 31), 31), 31);
    }

    public final String toString() {
        return "Motion(dx=" + this.a + ", dy=" + this.b + ", scrollerLeft=" + this.c + ", scrollerTop=" + this.d + ", scrollerRight=" + this.e + ", scrollerBottom=" + this.f + ")";
    }
}
