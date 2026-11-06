package com.amazon.device.drm.a;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static a a = new a();
    private static volatile c b;

    private a() {
    }

    public static a a() {
        return a;
    }

    public c a(Context context) {
        if (b == null) {
            synchronized (a.class) {
                try {
                    if (b == null) {
                        if (com.amazon.a.a.a((Application) context.getApplicationContext())) {
                            b = new com.amazon.device.drm.a.d.c();
                        } else {
                            b = new com.amazon.device.drm.a.b.c();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }
}
