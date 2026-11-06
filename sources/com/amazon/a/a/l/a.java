package com.amazon.a.a.l;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private final Activity a;
    private final int b;
    private final int c;
    private final Intent d;

    public a(Activity activity, int i, int i2, Intent intent) {
        this.a = activity;
        this.b = i;
        this.c = i2;
        this.d = intent;
    }

    public Activity a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public Intent c() {
        return this.d;
    }

    public int d() {
        return this.c;
    }

    public String toString() {
        return "ActivtyResult: [ requestCode: " + this.b + ", resultCode: " + this.c + ", activity: " + this.a + ", intent: " + this.d + "]";
    }
}
