package com.amazon.a.a.n.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public class f extends com.amazon.a.a.i.b {
    private static final com.amazon.a.a.o.c b = new com.amazon.a.a.o.c("DecisionDialog");
    private final b d;
    private final BlockingQueue<a> e = new LinkedBlockingQueue();
    private final Thread c = Thread.currentThread();

    private static class b {
        private final String a;
        private final String b;
        private final long c;
        private final a d;
        private final a e;
        private final a f;

        public b(com.amazon.d.a.f fVar) throws RemoteException {
            this.a = fVar.b();
            this.b = fVar.c();
            this.c = fVar.d();
            this.d = a(fVar.e());
            this.e = a(fVar.f());
            this.f = a(fVar.g());
        }

        private a a(com.amazon.d.a.a aVar) throws RemoteException {
            if (aVar == null) {
                return null;
            }
            return new a(aVar);
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public long c() {
            return this.c;
        }

        public a d() {
            return this.f;
        }

        public a e() {
            return this.e;
        }

        public a f() {
            return this.d;
        }
    }

    private static class a {
        private final com.amazon.d.a.a a;
        private final String b;
        private final Intent c;

        public a(com.amazon.d.a.a aVar) throws RemoteException {
            this.a = aVar;
            this.b = aVar.a();
            this.c = aVar.b();
        }

        public com.amazon.d.a.a a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public Intent c() {
            return this.c;
        }
    }

    public f(com.amazon.d.a.f fVar) throws RemoteException {
        this.d = new b(fVar);
    }

    public com.amazon.d.a.a i() throws com.amazon.a.a.n.a.a.e {
        if (com.amazon.a.a.o.c.a) {
            b.a("GetCustomerDecision: " + this.c);
        }
        return n();
    }

    private com.amazon.d.a.a n() throws com.amazon.a.a.n.a.a.e {
        try {
            if (com.amazon.a.a.o.c.a) {
                b.a("Blocking while awaiting customer decision: " + Thread.currentThread());
            }
            return this.e.take().a();
        } catch (InterruptedException unused) {
            if (com.amazon.a.a.o.c.a) {
                b.a("Interrupted while awaiting decision, throwing decision expired!");
            }
            throw new com.amazon.a.a.n.a.a.e(o());
        }
    }

    private e o() {
        if (l() == com.amazon.a.a.i.d.NOT_COMPATIBLE) {
            return e.APP_NOT_COMPATIBLE;
        }
        return e.EXPIRATION_DURATION_ELAPSED;
    }

    @Override // com.amazon.a.a.i.b
    public Dialog d(Activity activity) {
        return f(activity);
    }

    @Override // com.amazon.a.a.i.b
    public boolean b(Activity activity) {
        if (!p()) {
            return true;
        }
        ActivityInfo activityInfoE = e(activity);
        if (activityInfoE == null) {
            return false;
        }
        boolean z = activityInfoE.launchMode == 3;
        com.amazon.a.a.o.c cVar = b;
        cVar.a("Single instance: " + z);
        boolean z2 = (activityInfoE.flags & 2) != 0;
        cVar.a("Finish on task launch:" + z2);
        boolean z3 = (activityInfoE.flags & 128) != 0;
        cVar.a("No History: " + z3);
        return (z || z2 || z3) ? false : true;
    }

    private boolean p() {
        return a(this.d.f()) || a(this.d.e()) || a(this.d.d());
    }

    private boolean a(a aVar) {
        return (aVar == null || aVar.c() == null) ? false : true;
    }

    private ActivityInfo e(Activity activity) {
        try {
            return activity.getPackageManager().getActivityInfo(activity.getComponentName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            if (!com.amazon.a.a.o.c.b) {
                return null;
            }
            b.b("Unable to get info for activity: " + activity);
            return null;
        }
    }

    @Override // com.amazon.a.a.e.c
    protected long h() {
        return this.d.c();
    }

    @Override // com.amazon.a.a.i.b
    protected void a(com.amazon.a.a.i.d dVar) {
        if (com.amazon.a.a.o.c.a) {
            b.a("Expiring Decision Dialog: Thread: " + Thread.currentThread());
        }
        this.c.interrupt();
    }

    private Dialog f(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(this.d.a()).setMessage(this.d.b()).setCancelable(false);
        AlertDialog alertDialogCreate = builder.create();
        a(activity, alertDialogCreate, this.d.f(), -1);
        a(activity, alertDialogCreate, this.d.e(), -3);
        a(activity, alertDialogCreate, this.d.d(), -2);
        return alertDialogCreate;
    }

    private void a(Activity activity, AlertDialog alertDialog, final a aVar, int i) {
        if (aVar == null) {
            return;
        }
        alertDialog.setButton(i, aVar.b(), new DialogInterface.OnClickListener() { // from class: com.amazon.a.a.n.a.f.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (com.amazon.a.a.o.c.a) {
                    f.b.a("Choice selected!");
                }
                if (f.this.k()) {
                    f.this.e.add(aVar);
                }
            }
        });
    }

    public String toString() {
        return "DecisionDialog: " + this.d.a();
    }
}
