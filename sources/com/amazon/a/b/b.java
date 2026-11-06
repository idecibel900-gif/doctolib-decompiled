package com.amazon.a.b;

import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private final String a;
    private final String b;
    private final String c;
    private final Date d;
    private final String e;

    public b(com.amazon.a.a.o.b.f fVar) throws com.amazon.a.a.o.b.a.b {
        this.a = a("checksum", fVar);
        this.b = a("customerId", fVar);
        this.c = a("deviceId", fVar);
        this.e = a("packageName", fVar);
        this.d = b("expiration", fVar);
    }

    private String a(String str, com.amazon.a.a.o.b.f fVar) throws com.amazon.a.a.o.b.a.b {
        String strA = fVar.a(str);
        if (com.amazon.a.a.o.e.a(strA)) {
            throw com.amazon.a.a.o.b.a.b.a(str);
        }
        return strA;
    }

    private Date b(String str, com.amazon.a.a.o.b.f fVar) throws com.amazon.a.a.o.b.a.b {
        String strA = a(str, fVar);
        try {
            return new Date(Long.parseLong(strA));
        } catch (NumberFormatException unused) {
            throw com.amazon.a.a.o.b.a.b.a(str, strA);
        }
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public Date d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }
}
