package com.amazon.a.a.c;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class g implements f {
    private static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("EventManagerImpl");
    private final Map<b, e<?>> b = new HashMap();

    @Override // com.amazon.a.a.c.f
    public <T extends a> void a(c<T> cVar) {
        com.amazon.a.a.o.a.a.a((Object) cVar, "listener");
        com.amazon.a.a.o.a.a.a();
        b bVarA = cVar.a();
        a.a("Registering listener for event: " + bVarA + ", " + cVar);
        e<?> eVar = this.b.get(bVarA);
        if (eVar == null) {
            eVar = new e<>();
            this.b.put(bVarA, eVar);
        }
        eVar.a(cVar);
    }

    @Override // com.amazon.a.a.c.f
    public void a(a aVar) {
        b bVarA = aVar.a();
        if (com.amazon.a.a.o.c.a) {
            a.a("Posting event: " + bVarA);
        }
        if (!this.b.containsKey(bVarA)) {
            if (com.amazon.a.a.o.c.a) {
                a.a("No registered listeners, returning");
                return;
            }
            return;
        }
        this.b.get(bVarA).a(aVar);
    }
}
