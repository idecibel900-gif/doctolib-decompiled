package com.amazon.a.a.n.a;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.RemoteException;
import com.amazon.d.a.j;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("CommandServiceClient");
    private static final String b = "com.amazon.venezia.service.command.CommandServiceImpl";
    private static final String c = "com.amazon.venezia.CommandService";
    private com.amazon.d.a.d d;
    private String e;

    @com.amazon.a.a.k.a
    private Application h;

    @com.amazon.a.a.k.a
    private b i;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c j;
    private final BlockingQueue<c> f = new LinkedBlockingQueue();
    private final BlockingQueue<com.amazon.d.a.d> g = new LinkedBlockingQueue();
    private final ServiceConnection k = new ServiceConnection() { // from class: com.amazon.a.a.n.a.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.a.a("onServiceConnected");
            d.this.g.add(com.amazon.d.a.d.a.a(iBinder));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.a.a("onServiceDisconnected!!!");
        }
    };
    private final com.amazon.d.a.i l = new com.amazon.d.a.i.a() { // from class: com.amazon.a.a.n.a.d.2
        @Override // com.amazon.d.a.i
        public void a(j jVar) throws RemoteException {
            d.this.f.add(new c(jVar));
        }

        @Override // com.amazon.d.a.i
        public void a(com.amazon.d.a.h hVar) throws RemoteException {
            d.this.f.add(new c(hVar));
        }

        @Override // com.amazon.d.a.i
        public void a(com.amazon.d.a.f fVar) throws RemoteException {
            d.this.f.add(new c(fVar));
        }

        @Override // com.amazon.d.a.i
        public void a(com.amazon.d.a.g gVar) throws RemoteException {
            d.this.f.add(new c(gVar));
        }
    };

    static class a {
        int a;
        boolean b;
        long c;

        a() {
        }
    }

    public c a(com.amazon.d.a.c cVar) throws com.amazon.a.a.n.a.a.c, RemoteException, com.amazon.a.a.n.a.a.b {
        a aVar = new a();
        aVar.a = 6;
        aVar.c = 100L;
        while (true) {
            try {
                if (!d()) {
                    e();
                }
                return b(cVar);
            } catch (com.amazon.a.a.n.a.a.b e) {
                a(e, aVar);
                if (!aVar.b) {
                    throw e;
                }
            } catch (com.amazon.a.a.n.a.a.c e2) {
                a(e2, aVar);
                if (!aVar.b) {
                    throw e2;
                }
            }
        }
    }

    static void a(com.amazon.a.a.d.b bVar, a aVar) {
        com.amazon.a.a.o.c cVar = a;
        cVar.b("CommandServiceException happened, retriesLeft=" + aVar.a, bVar);
        int i = aVar.a;
        if (i == 0) {
            aVar.b = false;
            return;
        }
        aVar.a = i - 1;
        aVar.b = true;
        try {
            cVar.a("Sleeping for " + aVar.c + " ms");
            Thread.sleep(aVar.c);
        } catch (InterruptedException unused) {
            aVar.b = false;
        }
        aVar.c *= 2;
    }

    private boolean d() {
        return this.d != null;
    }

    public String a() {
        return this.e;
    }

    private void e() throws com.amazon.a.a.n.a.a.c, com.amazon.a.a.n.a.a.b {
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.amazon.a.a.o.c cVar = a;
        cVar.a("Binding Service!!!");
        Intent intentF = f();
        if (!a(this.h, intentF)) {
            throw new com.amazon.a.a.n.a.a.c();
        }
        cVar.a("Found service on one or more packages");
        Intent intentA = a(intentF);
        String packageName = intentA.getComponent().getPackageName();
        cVar.a("Attempting to bind to service on " + packageName);
        if (!this.h.bindService(intentA, this.k, 1)) {
            throw new com.amazon.a.a.n.a.a.b();
        }
        try {
            cVar.a("Blocking while service is being bound!!");
            this.d = this.g.take();
            cVar.a("service bound, returning!!");
            if (com.amazon.a.a.o.c.a) {
                cVar.a("Kiwi.BindService Time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            }
            this.j.a(com.amazon.a.a.m.c.f, packageName);
            this.e = packageName;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new com.amazon.a.a.n.a.a.b();
        }
    }

    private boolean a(Context context, Intent intent) {
        return context.getPackageManager().resolveService(intent, 64) != null;
    }

    private Intent f() {
        Intent intent = new Intent();
        intent.setAction(c);
        a.a("Created intent with  action  com.amazon.venezia.CommandService");
        return intent;
    }

    private Intent a(String str) {
        Intent intent = new Intent();
        intent.setAction(c);
        intent.setClassName(str, b);
        return intent;
    }

    private Intent a(Intent intent) throws com.amazon.a.a.n.a.a.c {
        if (this.e != null) {
            a.a("Using previously determined package " + this.e);
            return a(this.e);
        }
        com.amazon.a.a.o.c cVar = a;
        cVar.a("No previously determined package found, checking for suitable package.");
        Intent intentA = a(this.h.getPackageManager().queryIntentServices(intent, 64));
        if (intentA != null) {
            return intentA;
        }
        cVar.a("No app with valid signature was providing our service.");
        throw new com.amazon.a.a.n.a.a.c();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x009c A[Catch: Exception -> 0x007b, TRY_LEAVE, TryCatch #0 {Exception -> 0x007b, blocks: (B:3:0x0003, B:5:0x000a, B:8:0x0062, B:14:0x009c, B:11:0x007d), top: B:18:0x0003 }] */
    private Intent a(List<ResolveInfo> list) {
        int i = 0;
        String str = null;
        while (i < list.size()) {
            try {
                ResolveInfo resolveInfo = list.get(i);
                String str2 = resolveInfo.serviceInfo.applicationInfo.packageName;
                com.amazon.a.a.o.c cVar = a;
                cVar.a("Examining package " + str2);
                cVar.a("Priority is " + resolveInfo.filter.getPriority());
                cVar.a("Checking signature of package " + str2);
                if (b(str2)) {
                    cVar.a("Signature of package " + str2 + " is okay");
                    str = str2;
                    if (i > -1) {
                        return a(str);
                    }
                    return null;
                }
                cVar.a("Signature of package " + str2 + " is bad");
                i++;
                str = str2;
            } catch (Exception e) {
                a.a("Caught exception " + e);
            }
        }
        i = -1;
        if (i > -1) {
            return a(str);
        }
        return null;
    }

    private c b(com.amazon.d.a.c cVar) throws RemoteException {
        this.j.a(com.amazon.a.a.m.c.g, cVar.b());
        this.d.a(cVar, this.l);
        return g();
    }

    private c g() throws RemoteException {
        try {
            com.amazon.a.a.o.c cVar = a;
            cVar.a("Blocking for result from service");
            c cVarTake = this.f.take();
            cVar.a("Received result from service");
            return cVarTake;
        } catch (InterruptedException unused) {
            a.a("TaskThread interrupted, returning null result");
            return null;
        }
    }

    public c a(com.amazon.d.a.a aVar) throws RemoteException {
        aVar.a(null);
        return g();
    }

    public c a(com.amazon.d.a.f fVar, final e eVar) throws RemoteException {
        fVar.a(new com.amazon.d.a.e.a() { // from class: com.amazon.a.a.n.a.d.3
            @Override // com.amazon.d.a.e
            public Map b() throws RemoteException {
                return null;
            }

            @Override // com.amazon.d.a.e
            public String a() throws RemoteException {
                return eVar.name();
            }
        });
        return g();
    }

    public void b() {
        com.amazon.a.a.o.c cVar = a;
        StringBuilder sb = new StringBuilder();
        sb.append("Finishing CommandServiceClient, unbinding service: ");
        sb.append(this.d != null);
        cVar.a(sb.toString());
        if (this.d != null) {
            this.h.unbindService(this.k);
            this.d = null;
        }
    }

    private boolean b(String str) {
        a.a("isPackageSignatureTrusted " + str);
        return this.i.a(str, i.a);
    }
}
