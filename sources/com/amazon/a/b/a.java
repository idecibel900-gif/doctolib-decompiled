package com.amazon.a.b;

import android.app.Application;
import android.os.RemoteException;
import com.amazon.d.a.j;
import java.security.PublicKey;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.amazon.a.a.n.a.a {
    private static final com.amazon.a.a.o.c b = new com.amazon.a.a.o.c("VerifyApplicationEntitlmentTask");
    private f c = new f();

    @com.amazon.a.a.k.a
    private com.amazon.a.a.h.c d;

    @com.amazon.a.a.k.a
    private Application e;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.n.b f;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c g;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.o.b.b h;

    @Override // com.amazon.a.a.n.a.a
    protected Map<String, Object> b() {
        return null;
    }

    @Override // com.amazon.a.a.n.a.a
    protected void a(j jVar) throws com.amazon.a.a.d.b, RemoteException {
        g gVar = new g(jVar.b());
        b bVarA = a(gVar, this.h.a());
        if (bVarA == null) {
            return;
        }
        a(gVar, bVarA);
        a(bVarA);
        this.d.a(new com.amazon.a.b.b.a());
        this.f.a(com.amazon.a.a.n.b.d.BACKGROUND, new i());
    }

    private b a(g gVar, PublicKey publicKey) throws com.amazon.a.a.o.b.a.c, com.amazon.a.a.o.b.a.b {
        return new b(new com.amazon.a.a.o.b.f(gVar.c(), publicKey));
    }

    private void a(b bVar) {
        b.a("License Verification succeeded!");
        this.g.a(com.amazon.a.a.m.c.b, new com.amazon.a.a.m.a(bVar, bVar.d()) { // from class: com.amazon.a.b.a.1
            @Override // com.amazon.a.a.e.a
            public void d() {
                this.a.a(com.amazon.a.a.n.b.d.COMMAND, new a());
            }
        });
    }

    private void a(g gVar, b bVar) throws com.amazon.a.b.a.a {
        com.amazon.a.a.o.d.c cVar = new com.amazon.a.a.o.d.c();
        cVar.a(gVar.a(), bVar.b(), (com.amazon.a.a.o.d.b) h.CUSTOMER_ID);
        cVar.a(gVar.b(), bVar.c(), (com.amazon.a.a.o.d.b) h.DEVICE_ID);
        cVar.a(bVar.e(), this.e.getPackageName(), (com.amazon.a.a.o.d.b) h.PACKAGE_NAME);
        cVar.a(bVar.d(), new Date(), (com.amazon.a.a.o.d.b) h.EXPIRATION);
        if (cVar.a()) {
            throw new com.amazon.a.b.a.a(cVar);
        }
    }

    @Override // com.amazon.a.a.n.a.a
    protected void a(com.amazon.d.a.h hVar) throws com.amazon.a.a.d.b, RemoteException {
        com.amazon.a.a.i.c cVar = new com.amazon.a.a.i.c(hVar.b(), hVar.c(), hVar.d(), hVar.e());
        b.a("onFailure: " + cVar);
        this.g.a(com.amazon.a.a.m.c.c, cVar);
    }

    @Override // com.amazon.a.a.n.a.a
    protected void b(com.amazon.a.a.d.b bVar) {
        com.amazon.a.a.i.c cVarA = this.c.a(bVar);
        if (cVarA == null && com.amazon.a.a.o.c.b) {
            b.b("No mapping specified for exception: " + bVar, bVar);
        }
        this.g.a(com.amazon.a.a.m.c.c, cVarA);
        this.g.a(com.amazon.a.a.m.c.d, bVar.getClass().getName());
    }

    @Override // com.amazon.a.a.n.a.a
    protected boolean d() {
        return this.g.a(com.amazon.a.a.m.c.b) == null;
    }

    @Override // com.amazon.a.a.n.a.a
    protected String a_() {
        return "get_license";
    }

    @Override // com.amazon.a.a.n.a.a
    protected String c() {
        return "1.0";
    }
}
