package com.adjust.sdk.sig;

/* JADX INFO: loaded from: classes3.dex */
public class x {
    public final o1 a;
    public boolean b = true;

    public x(o1 o1Var) {
        this.a = o1Var;
    }

    public void a() {
        this.b = false;
    }

    public void b() {
    }

    public void c() {
    }

    public final void a(char c) {
        o1 o1Var = this.a;
        o1Var.a(o1Var.b, 1);
        char[] cArr = o1Var.a;
        int i = o1Var.b;
        o1Var.b = i + 1;
        cArr[i] = c;
    }
}
