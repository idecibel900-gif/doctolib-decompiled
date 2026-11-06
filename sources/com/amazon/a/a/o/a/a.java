package com.amazon.a.a.o.a;

import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final boolean a = true;

    public static void a() {
        a(Looper.getMainLooper().getThread().getId());
    }

    public static void a(long j) {
        if (Thread.currentThread().getId() != j) {
            a("Executing thread must be thread: " + j + ", was: " + Thread.currentThread().getId());
        }
    }

    public static void a(String str) {
        throw new b(str);
    }

    public static void a(String str, Throwable th) {
        throw new b(str, th);
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            a("Argument: " + str + " cannot be null");
        }
    }

    public static void a(Object obj, Object obj2, String str) {
        a(a(obj, obj2), str);
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void b(Object obj, String str) {
        a(obj != null, str);
    }

    public static void c(Object obj, String str) {
        a(obj == null, str);
    }

    public static void a(boolean z, String str) {
        if (z) {
            return;
        }
        a(str);
    }

    public static void b(boolean z, String str) {
        if (z) {
            a(str);
        }
    }
}
