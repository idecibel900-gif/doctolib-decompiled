package com.amazon.a.a.f;

import android.os.RemoteException;
import com.amazon.d.a.h;
import com.amazon.d.a.j;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class b extends com.amazon.a.a.n.a.a {
    private static final String b = "lifeCycle_Events";
    private static final String c = "1.0";
    private Map<String, Object> d;

    @Override // com.amazon.a.a.n.a.a
    protected void a(h hVar) throws com.amazon.a.a.d.b, RemoteException {
    }

    @Override // com.amazon.a.a.n.a.a
    protected void a(j jVar) throws com.amazon.a.a.d.b, RemoteException {
    }

    @Override // com.amazon.a.a.n.a.a
    protected boolean d() {
        return true;
    }

    public b(Map<String, Object> map) {
        this.d = map;
    }

    @Override // com.amazon.a.a.n.a.a
    protected String a_() {
        return b;
    }

    @Override // com.amazon.a.a.n.a.a
    protected String c() {
        return "1.0";
    }

    @Override // com.amazon.a.a.n.a.a
    protected Map<String, Object> b() {
        return this.d;
    }
}
