package com.amazon.device.iap.internal.a;

/* JADX INFO: loaded from: classes3.dex */
public class f extends RuntimeException {
    private static final long a = 3715222306172636179L;
    private final String b;
    private final String c;
    private final String d;

    public f(String str, String str2, String str3) {
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public f(String str, String str2, String str3, Throwable th) {
        super(th);
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }
}
