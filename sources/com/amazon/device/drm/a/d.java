package com.amazon.device.drm.a;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.amazon.device.drm.LicensingListener;
import com.amazon.device.drm.model.AppstoreSDKModes;
import com.amazon.device.drm.model.RequestId;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static String a = "d";
    private static d b = new d();
    private c c;
    private Context d;
    private LicensingListener e;

    private d() {
    }

    public void a(Context context, LicensingListener licensingListener) {
        if (licensingListener == null || context == null) {
            throw new IllegalArgumentException("LicensingManager/Context cannot be null");
        }
        com.amazon.device.drm.a.e.b.a(a, "LicensingListener registered: " + licensingListener);
        com.amazon.device.drm.a.e.b.a(a, "LicensingListener Context: " + context);
        this.d = context.getApplicationContext();
        this.e = licensingListener;
        c cVarA = a.a().a(this.d);
        this.c = cVarA;
        if (cVarA == null) {
            com.amazon.device.drm.a.e.b.a(a, "requestHandler is null");
        }
    }

    public String a() {
        try {
            g();
            if (com.amazon.a.a.a((Application) this.d.getApplicationContext())) {
                return AppstoreSDKModes.SANDBOX.name();
            }
            return AppstoreSDKModes.PRODUCTION.name();
        } catch (IllegalStateException unused) {
            return AppstoreSDKModes.UNKNOWN.name();
        }
    }

    private void f() {
        if (this.e == null) {
            throw new IllegalStateException("You must register a PurchasingListener before invoking this operation");
        }
    }

    private void g() {
        if (this.d == null) {
            throw new IllegalStateException("You must register a ApplicationContext before invoking this operation");
        }
    }

    public LicensingListener b() {
        return this.e;
    }

    public Context c() {
        return this.d;
    }

    public static d d() {
        return b;
    }

    public RequestId e() {
        f();
        RequestId requestId = new RequestId();
        this.c.a(requestId);
        return requestId;
    }

    public void a(Context context, Intent intent) {
        try {
            this.c.a(context, intent);
        } catch (Exception e) {
            com.amazon.device.drm.a.e.b.b(a, "Error in onReceive: " + e);
        }
    }
}
