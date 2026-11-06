package com.adjust.sdk.sig;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class j3 implements u1, Serializable {
    public g0 a;
    public volatile Object b = l3.a;
    public final Object c = this;

    public j3(g0 g0Var) {
        this.a = g0Var;
    }

    @Override // com.adjust.sdk.sig.u1
    public final Object getValue() {
        Object objA;
        Object obj = this.b;
        l3 l3Var = l3.a;
        if (obj != l3Var) {
            return obj;
        }
        synchronized (this.c) {
            objA = this.b;
            if (objA == l3Var) {
                objA = this.a.a();
                this.b = objA;
                this.a = null;
            }
        }
        return objA;
    }

    public final String toString() {
        return this.b != l3.a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
