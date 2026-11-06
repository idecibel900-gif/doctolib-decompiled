package com.opentok.otc;

/* JADX INFO: loaded from: classes4.dex */
public final class j {
    public static final j c;
    public static final j d;
    public static final j e;
    public static final j f;
    private static j[] g;
    private static int h;
    private final int a;
    private final String b;

    static {
        j jVar = new j("OTC_VIDEO_BITRATE_PRESET_DEFAULT");
        c = jVar;
        j jVar2 = new j("OTC_VIDEO_BITRATE_PRESET_BW_SAVER");
        d = jVar2;
        j jVar3 = new j("OTC_VIDEO_BITRATE_PRESET_EXTRA_BW_SAVER");
        e = jVar3;
        j jVar4 = new j("OTC_VIDEO_BITRATE_PRESET_CUSTOM");
        f = jVar4;
        g = new j[]{jVar, jVar2, jVar3, jVar4};
        h = 0;
    }

    private j(String str) {
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

    public static j a(int i) {
        j[] jVarArr = g;
        if (i < jVarArr.length && i >= 0) {
            j jVar = jVarArr[i];
            if (jVar.a == i) {
                return jVar;
            }
        }
        int i2 = 0;
        while (true) {
            j[] jVarArr2 = g;
            if (i2 >= jVarArr2.length) {
                throw new IllegalArgumentException("No enum " + j.class + " with value " + i);
            }
            j jVar2 = jVarArr2[i2];
            if (jVar2.a == i) {
                return jVar2;
            }
            i2++;
        }
    }
}
