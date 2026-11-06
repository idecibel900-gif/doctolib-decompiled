package com.amazon.a.b;

/* JADX INFO: loaded from: classes3.dex */
public class c extends com.amazon.a.a.n.c.a {
    private static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("LicenseKillTask");

    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c b;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.i.e c;

    @Override // com.amazon.a.a.n.a
    public void a() {
        if (com.amazon.a.a.o.c.a) {
            a.a("License Kill Task Executing!!!");
        }
        if (b()) {
            a.c("license verification succeeded");
            return;
        }
        if (com.amazon.a.a.o.c.a) {
            a.a("License Kill Task determined app is not licensed, killing app");
        }
        if (m()) {
            n();
        }
        this.c.a((com.amazon.a.a.i.b) new com.amazon.a.a.i.g(c()));
    }

    private boolean b() {
        return this.b.b(com.amazon.a.a.m.c.b);
    }

    private com.amazon.a.a.i.c c() {
        com.amazon.a.a.i.c cVar = (com.amazon.a.a.i.c) this.b.a(com.amazon.a.a.m.c.c);
        if (cVar != null) {
            if (com.amazon.a.a.o.c.a) {
                a.a("Fetched failure content from store: " + cVar);
            }
            this.b.c(com.amazon.a.a.m.c.c);
            return cVar;
        }
        return e.e;
    }
}
