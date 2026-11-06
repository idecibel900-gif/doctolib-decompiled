package com.amazon.a.a.a;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.amazon.a.a.c.f;
import com.amazon.a.a.k.d;
import com.amazon.a.a.o.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements a, d {
    public static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("ContextManagerImplV2");

    @com.amazon.a.a.k.a
    private Application i;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.n.b j;

    @com.amazon.a.a.k.a
    private f k;
    private String l;
    private final AtomicReference<Activity> b = new AtomicReference<>();
    private final List<Activity> c = new ArrayList();
    private final g<Service> d = new g<>();
    private final g<Activity> e = new g<>();
    private final AtomicBoolean f = new AtomicBoolean(false);
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final AtomicBoolean h = new AtomicBoolean(false);
    private boolean m = false;

    @Override // com.amazon.a.a.a.a
    public Activity a() {
        com.amazon.a.a.o.a.a.a();
        for (int size = this.c.size() - 1; size >= 0; size--) {
            Activity activity = this.c.get(size);
            if (g(activity)) {
                return activity;
            }
        }
        return null;
    }

    private boolean g(Activity activity) {
        if (activity == null) {
            return false;
        }
        return activity.isTaskRoot();
    }

    @Override // com.amazon.a.a.a.a
    public void a(Activity activity) {
        com.amazon.a.a.o.a.a.a((Object) activity, "activity");
        com.amazon.a.a.o.a.a.a();
        this.c.add(activity);
        if (com.amazon.a.a.o.c.a) {
            a.a("Activity->onCreate.  Activity: " + activity + ", Total Activities: " + this.c.size());
        }
        a(com.amazon.a.a.a.a.b.CREATE, activity);
        if (i()) {
            this.m = true;
            a(com.amazon.a.a.a.a.d.CREATE);
        }
    }

    private boolean i() {
        return !this.m && this.c.size() == 1;
    }

    private void a(com.amazon.a.a.a.a.b bVar, Activity activity) {
        this.k.a(new com.amazon.a.a.a.a.a(bVar, activity));
    }

    private void a(com.amazon.a.a.a.a.d dVar) {
        this.k.a(new com.amazon.a.a.a.a.c(dVar, this.i));
    }

    @Override // com.amazon.a.a.a.a
    public void b(Activity activity) {
        com.amazon.a.a.o.a.a.a((Object) activity, "activity");
        com.amazon.a.a.o.a.a.a();
        this.c.remove(activity);
        if (com.amazon.a.a.o.c.a) {
            a.a("Activity->onDestroy.  Activity: " + activity + ", Total Activities: " + this.c.size());
        }
        a(com.amazon.a.a.a.a.b.DESTROY, activity);
        if (h(activity)) {
            this.m = false;
            a(com.amazon.a.a.a.a.d.DESTROY);
        }
    }

    private boolean h(Activity activity) {
        if (com.amazon.a.a.o.c.a) {
            a.a("Checking if application is destroyed");
        }
        if (!this.c.isEmpty()) {
            return false;
        }
        a.a("App is destroyed: " + activity.isTaskRoot() + ", " + activity.isFinishing());
        return activity.isTaskRoot() && activity.isFinishing();
    }

    @Override // com.amazon.a.a.a.a
    public void e(Activity activity) {
        com.amazon.a.a.o.a.a.a((Object) activity, "activity");
        com.amazon.a.a.o.a.a.a();
        a.a("Activity started: " + activity);
        this.e.a(activity);
        a(com.amazon.a.a.a.a.b.START, activity);
        if (this.e.b() == 1) {
            a(com.amazon.a.a.a.a.d.START);
        }
    }

    @Override // com.amazon.a.a.a.a
    public void f(Activity activity) {
        com.amazon.a.a.o.a.a.a((Object) activity, "activity");
        com.amazon.a.a.o.a.a.a();
        a.a("Activity stopped: " + activity);
        this.e.b(activity);
        a(com.amazon.a.a.a.a.b.STOP, activity);
        if (this.e.a()) {
            a(com.amazon.a.a.a.a.d.STOP);
        }
    }

    @Override // com.amazon.a.a.a.a
    public void d(Activity activity) {
        com.amazon.a.a.o.a.a.a();
        if (com.amazon.a.a.o.c.a) {
            a.a("Activity paused: " + activity + ", visible activity: " + b());
        }
        if (b() == activity) {
            if (com.amazon.a.a.o.c.a) {
                a.a("Setting visible activity to null");
            }
            this.b.set(null);
            a(com.amazon.a.a.a.a.b.PAUSE, activity);
        }
    }

    @Override // com.amazon.a.a.a.a
    public void c(Activity activity) {
        com.amazon.a.a.o.a.a.a();
        com.amazon.a.a.o.c cVar = a;
        cVar.a("Activity resumed: " + activity + ", is child: " + activity.isChild());
        Activity activityI = i(activity);
        StringBuilder sb = new StringBuilder();
        sb.append("Setting visible to: ");
        sb.append(activityI);
        cVar.a(sb.toString());
        this.b.set(activityI);
        if (com.amazon.a.a.o.c.a) {
            cVar.a("Activity now visible: " + activity + ", publishing resume event");
        }
        a(com.amazon.a.a.a.a.b.RESUME, activity);
    }

    private Activity i(Activity activity) {
        while (activity.isChild()) {
            activity = activity.getParent();
        }
        return activity;
    }

    @Override // com.amazon.a.a.a.a
    public void a(Service service) {
        com.amazon.a.a.o.a.a.a();
        if (com.amazon.a.a.o.c.a) {
            a.a("Service->onCreate: " + service);
        }
        this.d.a(service);
    }

    @Override // com.amazon.a.a.a.a
    public void b(Service service) {
        com.amazon.a.a.o.a.a.a();
        this.d.b(service);
    }

    @Override // com.amazon.a.a.a.a
    public boolean d() {
        return this.g.get() || this.f.get();
    }

    @Override // com.amazon.a.a.a.a
    public Activity b() {
        com.amazon.a.a.o.a.a.a();
        return this.b.get();
    }

    @Override // com.amazon.a.a.a.a
    public boolean c() {
        return this.b.get() != null;
    }

    @Override // com.amazon.a.a.a.a
    public void f() {
        if (this.f.compareAndSet(false, true)) {
            if (com.amazon.a.a.o.c.a) {
                com.amazon.a.a.o.c cVar = a;
                cVar.a("---------- SCHEDULING FINISH ACTIVITIES -----------");
                cVar.a(this.i.getPackageName());
                cVar.a(Thread.currentThread().toString());
                cVar.a("---------------------------------------------------");
            }
            this.j.a(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.a.a.a.b.1
                @Override // com.amazon.a.a.n.a
                public void a() {
                    b.this.j();
                }

                public String toString() {
                    return "ContextManager: init app shutdown on main thread";
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (com.amazon.a.a.o.c.a) {
            com.amazon.a.a.o.c cVar = a;
            cVar.a("----------- EXECUTING FINISH ACTIVITIES -----------");
            cVar.a(this.i.getPackageName());
            cVar.a("---------------------------------------------------");
        }
        k();
        l();
        m();
    }

    private void k() {
        Activity activityA = a();
        for (Activity activity : this.c) {
            if (!activity.equals(activityA)) {
                j(activity);
            }
        }
    }

    private void j(Activity activity) {
        if (activity == null) {
            return;
        }
        if (activity.isChild()) {
            a.a("Not finishing activity: " + activity + ", it is a child of: " + activity.getParent());
            return;
        }
        a.a("Finishing Activity: " + activity);
        activity.finish();
    }

    private void l() {
        Activity activityA = a();
        if (activityA == null) {
            a.a("Shutdown found no root, no activities to pop off stack!");
            return;
        }
        com.amazon.a.a.o.c cVar = a;
        cVar.a("Moving task to background");
        activityA.moveTaskToBack(true);
        cVar.a("Popping activity stack, root: " + activityA);
        Intent intent = new Intent(activityA, activityA.getClass());
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        activityA.startActivity(intent);
    }

    private void m() {
        this.j.a(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.a.a.a.b.2
            @Override // com.amazon.a.a.n.a
            public void a() {
                Activity activityA = b.this.a();
                com.amazon.a.a.o.c cVar = b.a;
                cVar.a("Finishing Root Task: " + activityA);
                if (activityA != null) {
                    cVar.a("Finishing Root");
                    activityA.finish();
                }
            }

            public String toString() {
                return "ContextManager: kill root task";
            }
        });
    }

    @Override // com.amazon.a.a.a.a
    public void g() {
        if (!this.g.compareAndSet(false, true) && com.amazon.a.a.o.c.a) {
            a.a("Ignoring duplicate stopServices request");
        }
        if (com.amazon.a.a.o.c.a) {
            com.amazon.a.a.o.c cVar = a;
            cVar.a("------------- STOPPING SERVICES -------------------");
            cVar.a(this.i.getPackageName());
            cVar.a("---------------------------------------------------");
        }
        Intent intent = new Intent(this.l);
        intent.setPackage(this.i.getPackageName());
        if (com.amazon.a.a.o.c.a) {
            a.a("Sending Broadcast!!!!: " + intent + ", Thread: " + Thread.currentThread());
        }
        this.i.sendBroadcast(intent);
    }

    @Override // com.amazon.a.a.k.d
    public void e() {
        this.l = "com.amazon." + this.i.getPackageName() + ".shutdown";
        this.i.registerReceiver(new BroadcastReceiver() { // from class: com.amazon.a.a.a.b.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                b.this.a(intent);
            }
        }, new IntentFilter(this.l));
    }

    @Override // com.amazon.a.a.a.a
    public boolean h() {
        com.amazon.a.a.o.a.a.a("Method isContextAware() is not used for Kiwi's ContextManagerImplV2");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        if (com.amazon.a.a.o.c.a) {
            a.a("Received broadcast intent: " + intent);
        }
        if (!intent.getAction().equals(this.l)) {
            if (com.amazon.a.a.o.c.b) {
                a.b("Received broadcast for unrequested action: " + intent.getAction());
                return;
            }
            return;
        }
        if (!this.g.get()) {
            if (com.amazon.a.a.o.c.b) {
                a.b("Received intent to shutdown app when we are not in shutdown state: " + intent);
                return;
            }
            return;
        }
        if (!this.h.compareAndSet(false, true)) {
            if (com.amazon.a.a.o.c.a) {
                a.a("shutdown broadcast already received, ignoring");
                return;
            }
            return;
        }
        if (com.amazon.a.a.o.c.a) {
            com.amazon.a.a.o.c cVar = a;
            cVar.a("Stopping services in response to broadcast");
            cVar.a("Service to stop: " + this.d.b());
        }
        Iterator<Service> it = this.d.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
    }

    private void c(Service service) {
        if (service == null) {
            return;
        }
        if (com.amazon.a.a.o.c.a) {
            a.a("Stopping service: " + service);
        }
        service.stopSelf();
    }
}
