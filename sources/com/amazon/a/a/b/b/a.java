package com.amazon.a.a.b.b;

import android.os.RemoteException;
import com.amazon.a.a.d.b;
import com.amazon.a.a.o.c;
import com.amazon.d.a.h;
import com.amazon.d.a.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.amazon.a.a.n.a.a {
    private static final c b = new c("SubmitCrashReportsTask");

    @com.amazon.a.a.k.a
    private com.amazon.a.a.b.a c;
    private List<com.amazon.a.a.b.c> d;

    @Override // com.amazon.a.a.n.a.a
    protected void a(h hVar) throws b, RemoteException {
    }

    @Override // com.amazon.a.a.n.a.a
    protected void e() throws b {
        this.d = this.c.a();
        if (c.a) {
            c cVar = b;
            cVar.a("--------------- Crash Reports -------------------");
            cVar.a("Size: " + this.d.size());
            cVar.a("--------------------------------------------------");
        }
    }

    @Override // com.amazon.a.a.n.a.a
    protected boolean d() {
        return !this.d.isEmpty();
    }

    @Override // com.amazon.a.a.n.a.a
    protected Map<String, Object> b() {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<com.amazon.a.a.b.c> it = this.d.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        map.put("reports", arrayList);
        return map;
    }

    @Override // com.amazon.a.a.n.a.a
    protected String a_() {
        return "submit_crash_reports";
    }

    @Override // com.amazon.a.a.n.a.a
    protected String c() {
        return "1.0";
    }

    @Override // com.amazon.a.a.n.a.a
    protected void a(j jVar) throws b, RemoteException {
        this.c.a(this.d);
    }
}
