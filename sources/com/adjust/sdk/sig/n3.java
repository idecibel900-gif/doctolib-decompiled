package com.adjust.sdk.sig;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class n3 implements u1, Serializable {
    public g0 a;
    public Object b = l3.a;

    public n3(g0 g0Var) {
        this.a = g0Var;
    }

    @Override // com.adjust.sdk.sig.u1
    public final Object getValue() {
        if (this.b == l3.a) {
            this.b = this.a.a();
            this.a = null;
        }
        return this.b;
    }

    public final String toString() {
        return this.b != l3.a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
