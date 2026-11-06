package com.amazon.a;

import android.app.Activity;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("CrossPlatformPluginUtils");

    private static boolean a() {
        if (a.b() != null) {
            return a.b().h();
        }
        return false;
    }

    public static void a(Activity activity) {
        com.amazon.a.a.o.a.a.a(a.d(), "AppstoreSDK not initialized");
        if (a()) {
            return;
        }
        a.b().c(activity);
        if (com.amazon.a.a.o.c.a) {
            a.a("Notified Visibility for activity:" + activity);
        }
    }
}
