package com.amazon.a.a.i;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes3.dex */
public class a extends h {
    private static final String b = "a";
    private static final String e = "http://www.amazon.com/gp/mas/get-appstore/android/ref=mas_mx_mba_iap_dl";
    private static final String f = "Amazon Appstore required";
    private static final String g = "Amazon Appstore Update Required";
    private static final long j = 31536000;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a h;
    private final c i;

    @Override // com.amazon.a.a.e.c
    protected long h() {
        return 31536000L;
    }

    public a(c cVar) {
        super(cVar);
        this.i = cVar;
    }

    @Override // com.amazon.a.a.i.h
    protected void i() {
        if (f.equalsIgnoreCase(this.i.e()) || g.equalsIgnoreCase(this.i.e())) {
            try {
                Activity activityB = this.h.b();
                if (activityB == null) {
                    activityB = this.h.a();
                }
                activityB.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(e)));
            } catch (Exception unused) {
            }
        }
    }

    public String toString() {
        return b;
    }
}
