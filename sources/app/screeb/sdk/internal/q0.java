package app.screeb.sdk.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class q0 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public q0(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return this.a == q0Var.a && this.b == q0Var.b && this.c == q0Var.c && this.d == q0Var.d;
    }

    public final int hashCode() {
        return Integer.hashCode(this.d) + AbstractC0310k.a(this.c, AbstractC0310k.a(this.b, Integer.hashCode(this.a) * 31, 31), 31);
    }

    public final String toString() {
        return "IntRect(left=" + this.a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + ")";
    }
}
