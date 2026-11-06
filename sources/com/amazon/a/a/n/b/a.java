package com.amazon.a.a.n.b;

import com.amazon.a.a.c.f;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class a implements com.amazon.a.a.k.d, c {
    private static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("ForegroundTaskPipeline");

    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a b;

    @com.amazon.a.a.k.a
    private f c;
    private c e;
    private List<com.amazon.a.a.n.a> f = new ArrayList();
    private c d = b.b("KIWI_UI");

    public a(c cVar) {
        this.e = cVar;
    }

    @Override // com.amazon.a.a.k.d
    public void e() {
        this.c.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.a>() { // from class: com.amazon.a.a.n.b.a.1
            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.b.RESUME;
            }

            @Override // com.amazon.a.a.c.c
            public void a(com.amazon.a.a.a.a.a aVar) {
                a.this.b();
            }

            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.MIDDLE;
            }

            public String toString() {
                return "ForegroundTaskPipeline:onResume listener";
            }
        });
    }

    @Override // com.amazon.a.a.n.b.c
    public void a(com.amazon.a.a.n.a aVar) {
        a(aVar, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.amazon.a.a.n.a aVar, boolean z) {
        if (this.b.c()) {
            if (z) {
                this.d.b(aVar);
                return;
            } else {
                this.d.a(aVar);
                return;
            }
        }
        if (com.amazon.a.a.o.c.a) {
            a.a("No UI visible to execute task: " + aVar + ", placing into pending queue until task is visible");
        }
        this.f.add(aVar);
    }

    @Override // com.amazon.a.a.n.b.c
    public void b(com.amazon.a.a.n.a aVar) {
        a(aVar, true);
    }

    @Override // com.amazon.a.a.n.b.c
    public void a(com.amazon.a.a.n.a aVar, Date date) {
        this.e.a(c(aVar), date);
    }

    private com.amazon.a.a.n.a c(final com.amazon.a.a.n.a aVar) {
        return new com.amazon.a.a.n.a() { // from class: com.amazon.a.a.n.b.a.2
            @Override // com.amazon.a.a.n.a
            public void a() {
                a.this.a(aVar, true);
            }

            public String toString() {
                return "Future:PostToUITask: " + aVar.toString();
            }
        };
    }

    @Override // com.amazon.a.a.n.b.c
    public void a(com.amazon.a.a.n.a aVar, long j) {
        this.e.a(c(aVar), j);
    }

    @Override // com.amazon.a.a.n.b.c
    public void a() {
        this.d.a();
        this.e.a();
        this.f.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (com.amazon.a.a.o.c.a) {
            a.a("Activity resumed, scheduling tasks on UI thread");
        }
        Iterator<com.amazon.a.a.n.a> it = this.f.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        this.f.clear();
    }
}
