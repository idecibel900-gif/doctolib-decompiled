package com.amazon.a.a.o;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static boolean a = true;
    public static boolean b = true;
    private static boolean c = false;
    private static final String d = "Kiwi";
    private String e;

    public c(String str) {
        this.e = str;
    }

    public void a(String str) {
        if (a) {
            d(str);
        }
    }

    private String d(String str) {
        return this.e + ": " + str;
    }

    public void a(String str, Throwable th) {
        if (a) {
            d(str);
        }
    }

    public void b(String str) {
        if (b) {
            d(str);
        }
    }

    public void b(String str, Throwable th) {
        if (b) {
            d(str);
        }
    }

    public void c(String str) {
        if (c) {
            d(str);
        }
    }

    public static void a() {
        c = true;
    }

    public static boolean b() {
        return c;
    }
}
