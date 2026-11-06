package com.amazon.device.iap.internal;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static b a = new b();
    private static final String b = b.class.getName();
    private static volatile e c;

    private b() {
    }

    public static b a() {
        return a;
    }

    public e a(Context context) {
        if (c == null) {
            synchronized (b.class) {
                try {
                    if (c == null) {
                        if (com.amazon.a.a.a((Application) context.getApplicationContext())) {
                            c = new com.amazon.device.iap.internal.c.e();
                        } else {
                            c = new com.amazon.device.iap.internal.a.d();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }
}
