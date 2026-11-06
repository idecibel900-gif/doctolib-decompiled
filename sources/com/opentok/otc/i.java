package com.opentok.otc;

/* JADX INFO: loaded from: classes4.dex */
public final class i {
    public static final i c;
    public static final i d;
    public static final i e;
    public static final i f;
    private static i[] g;
    private static int h;
    private final int a;
    private final String b;

    static {
        i iVar = new i("otc_SimulcastLevelNone", opentokJNI.otc_SimulcastLevelNone_get());
        c = iVar;
        i iVar2 = new i("otc_SimulcastLevelVGA", opentokJNI.otc_SimulcastLevelVGA_get());
        d = iVar2;
        i iVar3 = new i("otc_SimulcastLevel720p", opentokJNI.otc_SimulcastLevel720p_get());
        e = iVar3;
        i iVar4 = new i("otc_SimulcastLevelNumLevels");
        f = iVar4;
        g = new i[]{iVar, iVar2, iVar3, iVar4};
        h = 0;
    }

    private i(String str) {
        this.b = str;
        int i = h;
        h = i + 1;
        this.a = i;
    }

    public final int a() {
        return this.a;
    }

    public String toString() {
        return this.b;
    }

    private i(String str, int i) {
        this.b = str;
        this.a = i;
        h = i + 1;
    }
}
