package com.amazon.device.iap.internal.a;

/* JADX INFO: loaded from: classes3.dex */
public class e extends RuntimeException {
    private static final long a = 7955687159702952249L;
    private final String b;
    private final String c;

    public e(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    public e(String str, String str2, Throwable th) {
        super(th);
        this.b = str;
        this.c = str2;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }
}
