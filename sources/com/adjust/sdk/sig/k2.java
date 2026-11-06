package com.adjust.sdk.sig;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class k2 implements u1, Serializable {
    public static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(k2.class, Object.class, "b");
    public volatile g0 a;
    public volatile Object b = l3.a;

    public k2(g0 g0Var) {
        this.a = g0Var;
    }

    @Override // com.adjust.sdk.sig.u1
    public final Object getValue() {
        Object obj = this.b;
        l3 l3Var = l3.a;
        if (obj != l3Var) {
            return obj;
        }
        g0 g0Var = this.a;
        if (g0Var != null) {
            Object objA = g0Var.a();
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(c, this, l3Var, objA)) {
                this.a = null;
                return objA;
            }
        }
        return this.b;
    }

    public final String toString() {
        return this.b != l3.a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
