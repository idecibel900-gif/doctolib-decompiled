package com.amazon.a.a.l;

import android.app.Activity;
import android.content.Intent;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import com.amazon.a.a.c.f;
import com.amazon.a.a.k.d;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public class c implements d, b {
    private static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("ActivityResultManagerImpl");
    private static final Random b = new Random();
    private static final int c = 65535;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.n.b d;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a e;

    @com.amazon.a.a.k.a
    private f f;
    private AtomicReference<a> g = new AtomicReference<>();
    private BlockingQueue<com.amazon.a.a.l.a> h = new LinkedBlockingQueue();

    private static final class a {
        private final Intent a;
        private final int b;
        private Activity c;

        public a(Intent intent, int i) {
            this.a = intent;
            this.b = i;
        }

        public void a(Activity activity) {
            c.a.a("Calling startActivityForResult from: " + activity);
            activity.startActivityForResult(this.a, this.b);
            this.c = activity;
        }

        public void b(Activity activity) {
            c.a.b("Context changed while awaiting result!");
            if (this.c != null) {
                c.a.b("Finishing activity from old context: " + this.c);
                this.c.finishActivity(this.b);
            }
            a(activity);
        }

        public int a() {
            return this.b;
        }
    }

    @Override // com.amazon.a.a.k.d
    public void e() {
        this.f.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.a>() { // from class: com.amazon.a.a.l.c.1
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
                a aVar2 = (a) c.this.g.get();
                if (aVar2 != null) {
                    aVar2.b(aVar.b());
                }
            }
        });
    }

    @Override // com.amazon.a.a.l.b
    public com.amazon.a.a.l.a a(Intent intent) {
        final a aVar = new a(intent, b());
        if (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.g, null, aVar)) {
            a.b("StartActivityForResult called while ActivityResultManager is already awaiting a result");
            return null;
        }
        com.amazon.a.a.o.c cVar = a;
        cVar.a("Starting activity for result: " + intent + ", " + intent.getFlags() + ", requestId: " + aVar.a());
        this.d.b(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.a.a.l.c.2
            @Override // com.amazon.a.a.n.a
            public void a() {
                Activity activityB = c.this.e.b();
                if (activityB == null) {
                    c.a.a("No activity to call startActivityForResult on. startActivityForResult when an activity becomes visible");
                } else {
                    aVar.a(activityB);
                }
            }
        });
        try {
            cVar.a("Blocking for request: " + aVar.a());
            return this.h.take();
        } catch (InterruptedException unused) {
            a.a("Interrupted while awaiting for request, returning null");
            return null;
        } finally {
            a.a("Received Response: " + aVar.a());
            this.g.set(null);
        }
    }

    private int b() {
        return b.nextInt(65535) + 1;
    }

    @Override // com.amazon.a.a.l.b
    public boolean a(com.amazon.a.a.l.a aVar) {
        if (com.amazon.a.a.o.c.a) {
            a.a("Recieved ActivityResult: " + aVar);
        }
        a aVar2 = this.g.get();
        if (aVar2 == null) {
            if (com.amazon.a.a.o.c.a) {
                a.a("We don't have a current open request, returning");
            }
            return false;
        }
        if (aVar2.a() != aVar.b()) {
            if (com.amazon.a.a.o.c.a) {
                a.a("We don't have a request with code: " + aVar.b() + ", returning");
            }
            return false;
        }
        if (com.amazon.a.a.o.c.a) {
            a.a("Signaling thread waiting for request: " + aVar.b());
        }
        this.h.add(aVar);
        return true;
    }
}
