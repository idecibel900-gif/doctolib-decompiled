package com.amazon.a.a.n.c;

import com.amazon.a.a.k.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends a implements d {
    private static final com.amazon.a.a.o.c b = new com.amazon.a.a.o.c("TaskWorkflow");

    @com.amazon.a.a.k.a
    private com.amazon.a.a.k.b c;
    protected final List<com.amazon.a.a.n.a> a = new ArrayList();
    private AtomicBoolean d = new AtomicBoolean(false);

    protected void b() {
    }

    protected abstract String b_();

    protected void c() {
    }

    @Override // com.amazon.a.a.n.a
    public final void a() {
        try {
            c();
            f();
        } finally {
            b();
        }
    }

    private void f() {
        if (com.amazon.a.a.o.c.a) {
            b.a("Exiting task workflow: " + this);
        }
        for (com.amazon.a.a.n.a aVar : this.a) {
            if (this.d.get()) {
                if (com.amazon.a.a.o.c.a) {
                    b.a("Finished set, exiting task workflow early");
                    return;
                }
                return;
            }
            aVar.a();
        }
    }

    protected final void a(com.amazon.a.a.n.a aVar) {
        com.amazon.a.a.o.a.a.a((Object) aVar, "task");
        this.a.add(aVar);
        if (aVar instanceof c) {
            ((c) aVar).a(this);
        }
    }

    public final void d() {
        this.d.set(true);
    }

    @Override // com.amazon.a.a.k.d
    public final void e() {
        Iterator<com.amazon.a.a.n.a> it = this.a.iterator();
        while (it.hasNext()) {
            this.c.b(it.next());
        }
    }

    public final String toString() {
        return b_();
    }
}
