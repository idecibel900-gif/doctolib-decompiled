package com.amazon.device.simplesignin.a;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
class a {
    private static final String a = "a";
    private static final a b = new a();
    private static volatile b c;

    private a() {
    }

    static a a() {
        return b;
    }

    b a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                try {
                    if (c == null) {
                        if (b(context)) {
                            c = new com.amazon.device.simplesignin.a.c.b();
                            com.amazon.device.simplesignin.a.d.a.a(a, "SDK initialized in Sandbox mode.");
                        } else {
                            c = new com.amazon.device.simplesignin.a.a.b();
                            com.amazon.device.simplesignin.a.d.a.a(a, "SDK initialized in Production mode.");
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    boolean b(Context context) {
        return com.amazon.a.a.a((Application) context.getApplicationContext());
    }
}
