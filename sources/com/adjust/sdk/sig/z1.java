package com.adjust.sdk.sig;

/* JADX INFO: loaded from: classes3.dex */
public final class z1 implements r1 {
    public final m2 a = new m2(x2.b);

    @Override // com.adjust.sdk.sig.r1
    public final l2 a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z1.class != obj.getClass()) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return x2.a.hashCode();
    }

    @Override // com.adjust.sdk.sig.r1
    public final void a(v2 v2Var, Object obj) {
        if (obj != null) {
            v2Var.a(x2.a, obj);
            return;
        }
        o1 o1Var = v2Var.a.a;
        o1Var.a(o1Var.b, 4);
        "null".getChars(0, 4, o1Var.a, o1Var.b);
        o1Var.b += 4;
    }
}
