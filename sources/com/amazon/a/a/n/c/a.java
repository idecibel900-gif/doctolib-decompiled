package com.amazon.a.a.n.c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements c {
    private b a;

    @Override // com.amazon.a.a.n.c.c
    public final void a(b bVar) {
        com.amazon.a.a.o.a.a.a((Object) bVar, "workflow");
        com.amazon.a.a.o.a.a.c(this.a, "workflow instance can only be set once");
        this.a = bVar;
    }

    protected final boolean m() {
        return this.a != null;
    }

    protected final void n() {
        com.amazon.a.a.o.a.a.a(m(), "task is no a workflow child");
        this.a.d();
    }
}
