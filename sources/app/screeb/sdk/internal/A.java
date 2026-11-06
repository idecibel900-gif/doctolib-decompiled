package app.screeb.sdk.internal;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class A {
    public final WeakReference a;
    public final WeakReference b;
    public boolean c;
    public final PowerManager d;
    public final C0326z e;
    public final PowerManager.OnThermalStatusChangedListener f;
    public final ComponentCallbacks2C0325y g;
    public final C0324x h;

    public A(Application application, J pipeline) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(pipeline, "pipeline");
        this.a = new WeakReference(application);
        this.b = new WeakReference(pipeline);
        Object systemService = application.getSystemService("power");
        this.d = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        this.e = new C0326z(this);
        this.f = Build.VERSION.SDK_INT >= 29 ? new PowerManager.OnThermalStatusChangedListener() { // from class: app.screeb.sdk.internal.A$$ExternalSyntheticLambda0
            @Override // android.os.PowerManager.OnThermalStatusChangedListener
            public final void onThermalStatusChanged(int i) {
                A.a(this.f$0, i);
            }
        } : null;
        this.g = new ComponentCallbacks2C0325y(this);
        this.h = new C0324x(this);
    }

    public static final void a(A a, int i) {
        a.c();
    }

    public final void a() {
        Application application;
        PowerManager.OnThermalStatusChangedListener onThermalStatusChangedListener;
        if (this.c || (application = (Application) this.a.get()) == null) {
            return;
        }
        application.registerComponentCallbacks(this.g);
        application.registerActivityLifecycleCallbacks(this.h);
        try {
            application.registerReceiver(this.e, new IntentFilter("android.os.action.POWER_SAVE_MODE_CHANGED"));
        } catch (Throwable unused) {
        }
        if (Build.VERSION.SDK_INT >= 29 && (onThermalStatusChangedListener = this.f) != null) {
            try {
                PowerManager powerManager = this.d;
                if (powerManager != null) {
                    powerManager.addThermalStatusListener(onThermalStatusChangedListener);
                }
            } catch (Throwable unused2) {
            }
        }
        c();
        this.c = true;
    }

    public final void b() {
        Application application;
        PowerManager.OnThermalStatusChangedListener onThermalStatusChangedListener;
        if (this.c && (application = (Application) this.a.get()) != null) {
            try {
                application.unregisterComponentCallbacks(this.g);
            } catch (Throwable unused) {
            }
            try {
                application.unregisterActivityLifecycleCallbacks(this.h);
            } catch (Throwable unused2) {
            }
            try {
                application.unregisterReceiver(this.e);
            } catch (Throwable unused3) {
            }
            if (Build.VERSION.SDK_INT >= 29 && (onThermalStatusChangedListener = this.f) != null) {
                try {
                    PowerManager powerManager = this.d;
                    if (powerManager != null) {
                        powerManager.removeThermalStatusListener(onThermalStatusChangedListener);
                    }
                } catch (Throwable unused4) {
                }
            }
            this.c = false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0075  */
    public final void c() {
        boolean z;
        int currentThermalStatus;
        boolean z2;
        try {
            PowerManager powerManager = this.d;
            z = powerManager != null && powerManager.isPowerSaveMode();
        } catch (Throwable unused) {
        }
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                PowerManager powerManager2 = this.d;
                if (powerManager2 != null) {
                    currentThermalStatus = powerManager2.getCurrentThermalStatus();
                } else {
                    currentThermalStatus = 0;
                }
            } catch (Throwable unused2) {
            }
        } else {
            currentThermalStatus = 0;
        }
        J j = (J) this.b.get();
        if (j != null) {
            Application application = (Application) this.a.get();
            if (application != null) {
                try {
                    Intent intentRegisterReceiver = application.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                    int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("status", -1) : -1;
                    boolean z3 = intExtra == 2 || intExtra == 5;
                    int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("level", -1) : -1;
                    int intExtra3 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : -1;
                    z2 = intExtra2 >= 0 && intExtra3 > 0 && !z3 && (intExtra2 * 100) / intExtra3 <= 15;
                } catch (Throwable unused3) {
                }
            }
            C0296d c0296d = j.f;
            synchronized (c0296d) {
                c0296d.k = z;
                c0296d.l = RangesKt.coerceAtLeast(currentThermalStatus, 0);
                c0296d.m = z2;
            }
        }
    }
}
