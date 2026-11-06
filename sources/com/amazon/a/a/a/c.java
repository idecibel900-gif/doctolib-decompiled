package com.amazon.a.a.a;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import com.amazon.a.a.a.a.d;
import com.amazon.a.a.c.f;
import com.amazon.a.a.o.g;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements a {
    public static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("ContextManagerImplV3");

    @com.amazon.a.a.k.a
    private Application e;

    @com.amazon.a.a.k.a
    private f f;
    private final AtomicReference<Activity> b = new AtomicReference<>();
    private final g<Activity> c = new g<>();
    private final LinkedHashSet<Activity> d = new LinkedHashSet<>();
    private boolean g = false;

    @Override // com.amazon.a.a.a.a
    public void a(Service service) {
    }

    @Override // com.amazon.a.a.a.a
    public void b(Service service) {
    }

    @Override // com.amazon.a.a.a.a
    public boolean d() {
        return false;
    }

    @Override // com.amazon.a.a.a.a
    public void f() {
    }

    @Override // com.amazon.a.a.a.a
    public void g() {
    }

    @Override // com.amazon.a.a.a.a
    public Activity a() {
        com.amazon.a.a.o.a.a.a();
        Object[] array = this.d.toArray();
        Activity activity = null;
        for (int length = array.length - 1; length >= 0; length--) {
            activity = (Activity) array[length];
            if (g(activity)) {
                a.a("root activity" + activity);
                return activity;
            }
        }
        if (activity != null || array.length <= 0) {
            return activity;
        }
        a.a("root not fount returning" + activity);
        return (Activity) array[array.length - 1];
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
        this.d.add(activity);
        if (com.amazon.a.a.o.c.a) {
            a.a("Activity->onCreate.  Activity: " + activity + ", Total Activities: " + this.d.size());
        }
        a(com.amazon.a.a.a.a.b.CREATE, activity);
        if (e()) {
            this.g = true;
            a(d.CREATE);
        }
    }

    private boolean e() {
        return !this.g && this.d.size() == 1;
    }

    private void a(com.amazon.a.a.a.a.b bVar, Activity activity) {
        this.f.a(new com.amazon.a.a.a.a.a(bVar, activity));
    }

    private void a(d dVar) {
        this.f.a(new com.amazon.a.a.a.a.c(dVar, this.e));
    }

    @Override // com.amazon.a.a.a.a
    public void b(Activity activity) {
        com.amazon.a.a.o.a.a.a((Object) activity, "activity");
        com.amazon.a.a.o.a.a.a();
        this.d.remove(activity);
        if (com.amazon.a.a.o.c.a) {
            a.a("Activity->onDestroy.  Activity: " + activity + ", Total Activities: " + this.d.size());
        }
        a(com.amazon.a.a.a.a.b.DESTROY, activity);
        if (h(activity)) {
            a.a("AppLifeCycle application has been destroyed");
            this.g = false;
            a(d.DESTROY);
        }
    }

    private boolean h(Activity activity) {
        if (com.amazon.a.a.o.c.a) {
            a.a("Checking if application is destroyed");
        }
        if (!this.d.isEmpty()) {
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
        this.d.add(activity);
        this.c.a(activity);
        a(com.amazon.a.a.a.a.b.START, activity);
        if (e()) {
            this.g = true;
            a(d.CREATE);
        }
        if (this.c.b() == 1) {
            a(d.START);
        }
    }

    @Override // com.amazon.a.a.a.a
    public void f(Activity activity) {
        com.amazon.a.a.o.a.a.a((Object) activity, "activity");
        com.amazon.a.a.o.a.a.a();
        a.a("Activity stopped: " + activity);
        this.d.add(activity);
        this.c.b(activity);
        a(com.amazon.a.a.a.a.b.STOP, activity);
        if (this.c.a()) {
            a(d.STOP);
        }
    }

    @Override // com.amazon.a.a.a.a
    public void d(Activity activity) {
        com.amazon.a.a.o.a.a.a();
        if (com.amazon.a.a.o.c.a) {
            a.a("Activity paused: " + activity + ", visible activity: " + b());
        }
        this.d.add(activity);
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
        this.c.a(activity);
        this.d.add(activity);
        Activity activityI = i(activity);
        this.b.set(activityI);
        cVar.a("Setting visible to: " + activityI);
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
    public Activity b() {
        com.amazon.a.a.o.a.a.a();
        return this.b.get();
    }

    @Override // com.amazon.a.a.a.a
    public boolean c() {
        return this.b.get() != null;
    }

    @Override // com.amazon.a.a.a.a
    public boolean h() {
        com.amazon.a.a.o.a.a.a();
        return (!c() && this.d.isEmpty() && this.c.a()) ? false : true;
    }
}
