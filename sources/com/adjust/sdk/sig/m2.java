package com.adjust.sdk.sig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class m2 implements l2, h {
    public final l2 a;
    public final String b;
    public final Set c;

    public m2(l2 l2Var) {
        Set setC;
        this.a = l2Var;
        this.b = l2Var.b() + '?';
        if (l2Var instanceof h) {
            setC = ((h) l2Var).c();
        } else {
            HashSet hashSet = new HashSet(l2Var.e());
            int iE = l2Var.e();
            for (int i = 0; i < iE; i++) {
                hashSet.add(l2Var.a(i));
            }
            setC = hashSet;
        }
        this.c = setC;
    }

    @Override // com.adjust.sdk.sig.l2
    public final String a(int i) {
        return this.a.a(i);
    }

    @Override // com.adjust.sdk.sig.l2
    public final l2 b(int i) {
        return this.a.b(i);
    }

    @Override // com.adjust.sdk.sig.h
    public final Set c() {
        return this.c;
    }

    @Override // com.adjust.sdk.sig.l2
    public final p2 d() {
        return this.a.d();
    }

    @Override // com.adjust.sdk.sig.l2
    public final int e() {
        return this.a.e();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m2) && g1.a(this.a, ((m2) obj).a);
    }

    @Override // com.adjust.sdk.sig.l2
    public final List getAnnotations() {
        return this.a.getAnnotations();
    }

    public final int hashCode() {
        return this.a.hashCode() * 31;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append('?');
        return sb.toString();
    }

    @Override // com.adjust.sdk.sig.l2
    public final boolean a() {
        return this.a.a();
    }

    @Override // com.adjust.sdk.sig.l2
    public final String b() {
        return this.b;
    }
}
