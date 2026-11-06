package com.amazon.a;

import android.os.RemoteException;
import app.notifee.core.event.LogEvent;
import com.amazon.d.a.h;
import com.amazon.d.a.j;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class c extends com.amazon.a.a.n.a.a {
    private static final com.amazon.a.a.o.c b = new com.amazon.a.a.o.c("CheckIfAppisBlockedTask");

    @com.amazon.a.a.k.a
    private com.amazon.a.a.i.e c;

    @Override // com.amazon.a.a.n.a.a
    protected Map<String, Object> b() {
        return null;
    }

    @Override // com.amazon.a.a.n.a.a
    protected boolean d() {
        return true;
    }

    @Override // com.amazon.a.a.n.a.a
    protected String a_() {
        return "check_blocked_status";
    }

    @Override // com.amazon.a.a.n.a.a
    protected String c() {
        return "1.0";
    }

    @Override // com.amazon.a.a.n.a.a
    protected void a(j jVar) throws com.amazon.a.a.d.b, RemoteException {
        if (jVar.b() == null || !jVar.b().containsKey(LogEvent.LEVEL_VERBOSE)) {
            return;
        }
        boolean zBooleanValue = ((Boolean) jVar.b().get(LogEvent.LEVEL_VERBOSE)).booleanValue();
        com.amazon.a.a.o.c.b = zBooleanValue;
        com.amazon.a.a.o.c.a = zBooleanValue;
    }

    @Override // com.amazon.a.a.n.a.a
    protected void a(h hVar) throws com.amazon.a.a.d.b, RemoteException {
        if (m()) {
            n();
        }
        b.c("app is blocked, killing");
        this.c.a((com.amazon.a.a.i.b) new com.amazon.a.a.i.g(new com.amazon.a.a.i.c(hVar.b(), hVar.c(), hVar.d(), hVar.e())));
    }
}
