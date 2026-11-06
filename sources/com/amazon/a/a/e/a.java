package com.amazon.a.a.e;

import com.amazon.a.a.e.a;
import com.amazon.a.a.k.d;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T extends a<T>> implements d {
    private static final com.amazon.a.a.o.c b = new com.amazon.a.a.o.c("Expirable");

    @com.amazon.a.a.k.a
    protected com.amazon.a.a.n.b a;
    private AtomicBoolean c = new AtomicBoolean(false);
    private final List<b<T>> d = new Vector();

    protected abstract Date a();

    protected void b() {
    }

    protected abstract void d();

    @Override // com.amazon.a.a.k.d
    public final void e() {
        h();
        b();
    }

    private void h() {
        this.a.a(com.amazon.a.a.n.b.d.BACKGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.a.a.e.a.1
            @Override // com.amazon.a.a.n.a
            public void a() {
                a.this.c();
            }

            public String toString() {
                return "Expire: " + a.this.toString();
            }
        }, a());
    }

    public void c() {
        if (this.c.compareAndSet(false, true)) {
            if (com.amazon.a.a.o.c.a) {
                b.a("Expiring: " + this);
            }
            d();
            if (com.amazon.a.a.o.c.a) {
                b.a("Notifying Observers of expiration: " + this);
            }
            i();
        }
    }

    public final void f() {
        if (this.c.compareAndSet(false, true)) {
            i();
        }
    }

    public final void a(b<T> bVar) {
        this.d.add(bVar);
    }

    private void i() {
        Iterator<b<T>> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    protected boolean g() {
        return this.c.get();
    }
}
