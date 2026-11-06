package app.screeb.sdk.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class m0 {
    public final int a;
    public final int b;

    public m0(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        return this.a == m0Var.a && this.b == m0Var.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Integer.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "ScrollState(x=" + this.a + ", y=" + this.b + ")";
    }
}
