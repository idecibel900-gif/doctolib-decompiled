package com.amazon.a.a.d;

/* JADX INFO: loaded from: classes3.dex */
public class a extends Exception {
    private static final long a = 1;

    public a(String str) {
        super(str);
    }

    public a(String str, Throwable th) {
        super("Failed to authenticate data: " + str, th);
    }
}
