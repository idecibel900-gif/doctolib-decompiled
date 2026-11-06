package com.amazon.a.a.h.a;

import android.os.RemoteException;
import com.amazon.a.a.h.b;
import com.amazon.a.a.o.c;
import com.amazon.d.a.h;
import com.amazon.d.a.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.amazon.a.a.n.a.a {
    private static final c b = new c("SubmitMetricsTask");

    @com.amazon.a.a.k.a
    private com.amazon.a.a.h.c c;
    private b d;

    @Override // com.amazon.a.a.n.a.a
    protected void a(h hVar) throws com.amazon.a.a.d.b, RemoteException {
    }

    @Override // com.amazon.a.a.n.a.a
    protected void a(j jVar) throws com.amazon.a.a.d.b, RemoteException {
    }

    @Override // com.amazon.a.a.n.a.a
    protected void e() throws com.amazon.a.a.d.b {
        this.d = this.c.a();
        if (c.a) {
            c cVar = b;
            cVar.a("--------------- SUBMIT METRICS -------------------");
            cVar.a("Size: " + this.d.c());
            cVar.a("--------------------------------------------------");
        }
    }

    @Override // com.amazon.a.a.n.a.a
    protected boolean d() {
        return !this.d.a();
    }

    @Override // com.amazon.a.a.n.a.a
    protected String a_() {
        return "submit_metrics";
    }

    @Override // com.amazon.a.a.n.a.a
    protected String c() {
        return "1.0";
    }

    @Override // com.amazon.a.a.n.a.a
    protected Map<String, Object> b() {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList(this.d.c());
        Iterator<com.amazon.a.a.h.a> it = this.d.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        map.put("metrics", arrayList);
        return map;
    }
}
