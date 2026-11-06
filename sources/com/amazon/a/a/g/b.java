package com.amazon.a.a.g;

/* JADX INFO: loaded from: classes3.dex */
public class b implements c {
    private static com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("Appstore SDK - Production Mode");

    @Override // com.amazon.a.a.g.c
    public boolean a() {
        return com.amazon.a.a.o.c.a;
    }

    @Override // com.amazon.a.a.g.c
    public boolean b() {
        return com.amazon.a.a.o.c.b;
    }

    @Override // com.amazon.a.a.g.c
    public boolean c() {
        return com.amazon.a.a.o.c.b();
    }

    @Override // com.amazon.a.a.g.c
    public void a(String str, String str2) {
        a.a(d(str, str2));
    }

    @Override // com.amazon.a.a.g.c
    public void b(String str, String str2) {
        a.b(d(str, str2));
    }

    @Override // com.amazon.a.a.g.c
    public void c(String str, String str2) {
        a.c(d(str, str2));
    }

    private static String d(String str, String str2) {
        return str + ": " + str2;
    }
}
