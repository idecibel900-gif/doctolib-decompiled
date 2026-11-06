package com.opentok.otc;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    public static final e c;
    public static final e d;
    public static final e e;
    private static e[] f;
    private static int g;
    private final int a;
    private final String b;

    static {
        e eVar = new e("OTC_SUCCESS", opentokJNI.OTC_SUCCESS_get());
        c = eVar;
        e eVar2 = new e("OTC_FALSE", opentokJNI.OTC_FALSE_get());
        d = eVar2;
        e eVar3 = new e("OTC_TRUE", opentokJNI.OTC_TRUE_get());
        e = eVar3;
        f = new e[]{eVar, eVar2, eVar3};
        g = 0;
    }

    private e(String str, int i) {
        this.b = str;
        this.a = i;
        g = i + 1;
    }

    public final int a() {
        return this.a;
    }

    public String toString() {
        return this.b;
    }
}
