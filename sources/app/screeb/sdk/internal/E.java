package app.screeb.sdk.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class E {
    public final long a;
    public final int b;
    public final int c;
    public final int d;

    public E(long j, int i, int i2, int i3) {
        this.a = j;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    public final int a() {
        return this.d;
    }

    public final int b() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof E)) {
            return false;
        }
        E e = (E) obj;
        return this.a == e.a && this.b == e.b && this.c == e.c && this.d == e.d;
    }

    public final int hashCode() {
        return Integer.hashCode(this.d) + AbstractC0310k.a(this.c, AbstractC0310k.a(this.b, AbstractC0310k.a(0, Long.hashCode(this.a) * 31, 31), 31), 31);
    }

    public final String toString() {
        return "ScrollFramePlan(baseFrameId=" + this.a + ", dx=0, dy=" + this.b + ", revealedY=" + this.c + ", revealedH=" + this.d + ")";
    }
}
