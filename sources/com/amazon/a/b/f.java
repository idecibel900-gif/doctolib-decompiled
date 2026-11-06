package com.amazon.a.b;

import android.os.Build;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class f {
    private final Map<Class<? extends com.amazon.a.a.d.b>, c<? extends com.amazon.a.a.d.b>> a = new HashMap();

    private interface c<T extends com.amazon.a.a.d.b> {
        com.amazon.a.a.i.c a(T t);
    }

    private static final class a implements c<com.amazon.a.a.n.a.a.f> {
        final Map<String, com.amazon.a.a.i.c> a;

        private a() {
            this.a = new HashMap<String, com.amazon.a.a.i.c>() { // from class: com.amazon.a.b.f.a.1
                {
                    put("NO_INTERNET", e.d);
                    put("INVALID_CONTENT_ID", e.e);
                    put("INTERNAL_SERVICE_ERROR", e.f);
                }
            };
        }

        @Override // com.amazon.a.b.f.c
        public com.amazon.a.a.i.c a(com.amazon.a.a.n.a.a.f fVar) {
            com.amazon.a.a.i.c cVar = this.a.get(fVar.b());
            return cVar != null ? cVar : e.e;
        }
    }

    private static final class b implements c<com.amazon.a.b.a.a> {
        private b() {
        }

        @Override // com.amazon.a.b.f.c
        public com.amazon.a.a.i.c a(com.amazon.a.b.a.a aVar) {
            if (aVar.d().a(h.EXPIRATION)) {
                return e.d;
            }
            return e.e;
        }
    }

    public f() {
        if ("Amazon".equals(Build.MANUFACTURER)) {
            a(com.amazon.a.a.n.a.a.c.class, e.b);
        } else {
            a(com.amazon.a.a.n.a.a.c.class, e.a);
        }
        com.amazon.a.a.i.c cVar = e.b;
        a(com.amazon.a.a.n.a.a.b.class, cVar);
        a(com.amazon.a.a.n.a.a.d.class, cVar);
        a(com.amazon.a.a.n.a.a.a.class, e.c);
        a(com.amazon.a.a.n.a.a.f.class, new a());
        com.amazon.a.a.i.c cVar2 = e.e;
        a(com.amazon.a.a.n.a.a.g.class, cVar2);
        a(com.amazon.a.a.n.a.a.h.class, cVar2);
        a(com.amazon.a.b.a.a.class, new b());
        a(com.amazon.a.a.o.b.a.a.class, e.g);
        a(com.amazon.a.a.o.b.a.b.class, cVar2);
        a(com.amazon.a.a.o.b.a.c.class, cVar2);
    }

    private void a(Class<? extends com.amazon.a.a.d.b> cls, final com.amazon.a.a.i.c cVar) {
        a(cls, new c<com.amazon.a.a.d.b>() { // from class: com.amazon.a.b.f.1
            @Override // com.amazon.a.b.f.c
            public com.amazon.a.a.i.c a(com.amazon.a.a.d.b bVar) {
                return cVar;
            }
        });
    }

    private void a(Class<? extends com.amazon.a.a.d.b> cls, c<? extends com.amazon.a.a.d.b> cVar) {
        com.amazon.a.a.o.a.a.b(this.a.containsKey(cls), "mapping exists for type: " + cls);
        this.a.put(cls, cVar);
    }

    public com.amazon.a.a.i.c a(com.amazon.a.a.d.b bVar) {
        c<? extends com.amazon.a.a.d.b> cVar = this.a.get(bVar.getClass());
        if (cVar == null) {
            return null;
        }
        return cVar.a(bVar);
    }
}
