package com.amazon.a.a.i;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private final String a;
    private final String b;
    private final String c;
    private final String[] d;
    private final a[] e;
    private final boolean f;
    private final boolean g;
    private final int h;
    private final int i;

    public enum a {
        DEFAULT,
        HELP,
        DEEPLINK
    }

    public c(String str, String str2, String str3, boolean z) {
        this(str, str2, str3, z, false);
    }

    public c(String str, String str2, String str3, boolean z, boolean z2) {
        this(str, str2, new String[]{str3}, new a[]{a.DEFAULT}, z, z2, 0);
    }

    public c(String str, String str2, String[] strArr, a[] aVarArr, boolean z, boolean z2, int i) {
        this(new String[]{str}, str2, strArr, aVarArr, z, z2, i);
    }

    public c(String[] strArr, String str, String[] strArr2, a[] aVarArr, boolean z, boolean z2, int i) {
        this(strArr, str, strArr2, aVarArr, z, z2, i, -1);
    }

    public c(String[] strArr, String str, String[] strArr2, a[] aVarArr, boolean z, boolean z2, int i, int i2) {
        String str2 = strArr[0];
        this.a = str2;
        if (strArr.length > 1) {
            this.b = strArr[1];
        } else {
            this.b = str2;
        }
        this.c = str;
        this.d = strArr2;
        this.e = aVarArr;
        this.f = z;
        this.g = z2;
        this.h = i;
        this.i = i2;
    }

    public String a() {
        return this.d[this.h];
    }

    public String[] b() {
        return this.d;
    }

    public a[] c() {
        return this.e;
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.b;
    }

    public String f() {
        return this.a;
    }

    public int g() {
        return this.i;
    }

    public boolean h() {
        return this.f;
    }

    public boolean i() {
        return this.g;
    }

    public String toString() {
        return "PromptContent: [ title:" + this.a + ", message: " + this.c + ", label: " + this.d[0] + ", visible: " + this.f + ", shouldShowFixup: " + this.g + "]";
    }
}
