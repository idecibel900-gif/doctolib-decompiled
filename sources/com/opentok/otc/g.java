package com.opentok.otc;

/* JADX INFO: loaded from: classes4.dex */
public final class g {
    public static final g c;
    public static final g d;
    public static final g e;
    public static final g f;
    private static g[] g;
    private static int h;
    private final int a;
    private final String b;

    static {
        g gVar = new g("otc_external_video", opentokJNI.otc_external_video_get());
        c = gVar;
        g gVar2 = new g("otc_external_audio", opentokJNI.otc_external_audio_get());
        d = gVar2;
        g gVar3 = new g("otc_internal_video", opentokJNI.otc_internal_video_get());
        e = gVar3;
        g gVar4 = new g("otc_internal_audio", opentokJNI.otc_internal_audio_get());
        f = gVar4;
        g = new g[]{gVar, gVar2, gVar3, gVar4};
        h = 0;
    }

    private g(String str, int i) {
        this.b = str;
        this.a = i;
        h = i + 1;
    }

    public final int a() {
        return this.a;
    }

    public String toString() {
        return this.b;
    }

    public static g a(int i) {
        g[] gVarArr = g;
        if (i < gVarArr.length && i >= 0) {
            g gVar = gVarArr[i];
            if (gVar.a == i) {
                return gVar;
            }
        }
        int i2 = 0;
        while (true) {
            g[] gVarArr2 = g;
            if (i2 >= gVarArr2.length) {
                throw new IllegalArgumentException("No enum " + g.class + " with value " + i);
            }
            g gVar2 = gVarArr2[i2];
            if (gVar2.a == i) {
                return gVar2;
            }
            i2++;
        }
    }
}
