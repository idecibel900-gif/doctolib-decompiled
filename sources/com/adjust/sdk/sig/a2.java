package com.adjust.sdk.sig;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class a2 implements Serializable {
    public final Object a;
    public final Integer b;

    public a2(Class cls, Integer num) {
        this.a = cls;
        this.b = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a2)) {
            return false;
        }
        a2 a2Var = (a2) obj;
        return g1.a(this.a, a2Var.a) && this.b.equals(a2Var.b);
    }

    public final int hashCode() {
        Object obj = this.a;
        return this.b.hashCode() + ((obj == null ? 0 : obj.hashCode()) * 31);
    }

    public final String toString() {
        return "(" + this.a + ", " + this.b + ')';
    }
}
