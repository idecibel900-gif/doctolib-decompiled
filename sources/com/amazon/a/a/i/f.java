package com.amazon.a.a.i;

import android.app.Activity;
import android.app.Dialog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class f implements e, com.amazon.a.a.k.d {
    public static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("PromptManagerImpl");

    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a b;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.c.f c;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.n.b d;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.k.b e;
    private b f;
    private Set<b> g = new LinkedHashSet();
    private final AtomicBoolean h = new AtomicBoolean(false);

    @Override // com.amazon.a.a.i.e
    public void a(final b bVar) {
        if (com.amazon.a.a.o.c.a) {
            a.a("Scheduling presentation: " + bVar);
        }
        this.e.b(bVar);
        if (this.h.get()) {
            if (com.amazon.a.a.o.c.b) {
                a.b("Prompt: " + bVar + " presented after app destruction expiring it now!");
            }
            bVar.c();
            return;
        }
        this.d.a(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.a.a.i.f.1
            @Override // com.amazon.a.a.n.a
            public void a() {
                f.this.c(bVar);
            }

            public String toString() {
                return "Prompt Presentation on Main Thread: " + bVar + ", " + bVar.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b bVar) {
        if (this.h.get()) {
            if (com.amazon.a.a.o.c.b) {
                a.b("Prompt: " + bVar + " presented after app destruction expiring it now!");
            }
            bVar.c();
            return;
        }
        if (com.amazon.a.a.o.c.a) {
            a.a("Presening Prompt: " + bVar);
        }
        bVar.a(this);
        this.g.add(bVar);
        if (this.f != null) {
            if (com.amazon.a.a.o.c.a) {
                a.a("Dialog currently showing, not presenting given dialog");
            }
        } else {
            Activity activityB = this.b.b();
            if (activityB != null) {
                a(activityB);
            }
        }
    }

    private void a(Activity activity) {
        b bVarA = a();
        if (bVarA == null) {
            return;
        }
        a(bVarA, activity);
    }

    private b a() {
        if (this.g.isEmpty()) {
            return null;
        }
        return this.g.iterator().next();
    }

    private void a(b bVar, Activity activity) {
        this.f = bVar;
        bVar.a(activity);
    }

    @Override // com.amazon.a.a.i.e
    public Dialog a(Activity activity, int i) {
        if (com.amazon.a.a.o.c.a) {
            a.a("onCreateDialog, id: " + i + ", activity: " + activity);
        }
        b bVar = this.f;
        if (bVar == null) {
            if (com.amazon.a.a.o.c.a) {
                a.a("Showing dialog is null, returning");
            }
            return null;
        }
        if (bVar.j() != i) {
            if (com.amazon.a.a.o.c.a) {
                a.a("Showing dialog id does not match given id: " + i + ", returning");
            }
            return null;
        }
        if (com.amazon.a.a.o.c.a) {
            a.a("Creating dialog prompt: " + this.f);
        }
        return this.f.c(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity) {
        b bVar = this.f;
        if (bVar != null) {
            a(bVar, activity);
        } else {
            a(activity);
        }
    }

    @Override // com.amazon.a.a.e.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(final b bVar) {
        this.d.a(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.a.a.i.f.2
            @Override // com.amazon.a.a.n.a
            public void a() {
                f.this.d(bVar);
            }

            public String toString() {
                return "PromptManager:removeExpiredPrompt: " + bVar;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(b bVar) {
        this.g.remove(bVar);
        if (this.f == bVar) {
            this.f = null;
            Activity activityB = this.b.b();
            if (activityB != null) {
                a(activityB);
            }
        }
    }

    @Override // com.amazon.a.a.i.e
    public void a(Activity activity, boolean z) {
        b bVar = this.f;
        if (bVar != null) {
            bVar.a(activity, z);
        }
    }

    @Override // com.amazon.a.a.k.d
    public void e() {
        b();
        c();
    }

    private void b() {
        this.c.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.a>() { // from class: com.amazon.a.a.i.f.3
            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.b.RESUME;
            }

            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.MIDDLE;
            }

            @Override // com.amazon.a.a.c.c
            public void a(com.amazon.a.a.a.a.a aVar) {
                f.this.b(aVar.b());
            }
        });
    }

    private void c() {
        this.c.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.c>() { // from class: com.amazon.a.a.i.f.4
            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.d.DESTROY;
            }

            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.FIRST;
            }

            @Override // com.amazon.a.a.c.c
            public void a(com.amazon.a.a.a.a.c cVar) {
                f.this.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.h.compareAndSet(false, true)) {
            if (com.amazon.a.a.o.c.a) {
                a.a("PromptManager finishing....");
            }
            Iterator<b> it = this.g.iterator();
            while (it.hasNext()) {
                b next = it.next();
                it.remove();
                next.c();
            }
            b bVar = this.f;
            if (bVar != null) {
                bVar.k();
            }
        }
    }
}
