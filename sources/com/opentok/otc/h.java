package com.opentok.otc;

/* JADX INFO: loaded from: classes4.dex */
public final class h {
    public static final h c;
    public static final h d;
    private static h[] e;
    private static int f;
    private final int a;
    private final String b;

    static {
        h hVar = new h("OTC_PUBLISHER_VIDEO_TYPE_CAMERA", opentokJNI.OTC_PUBLISHER_VIDEO_TYPE_CAMERA_get());
        c = hVar;
        h hVar2 = new h("OTC_PUBLISHER_VIDEO_TYPE_SCREEN", opentokJNI.OTC_PUBLISHER_VIDEO_TYPE_SCREEN_get());
        d = hVar2;
        e = new h[]{hVar, hVar2};
        f = 0;
    }

    private h(String str, int i) {
        this.b = str;
        this.a = i;
        f = i + 1;
    }

    public final int a() {
        return this.a;
    }

    public String toString() {
        return this.b;
    }

    public static h a(int i) {
        h[] hVarArr = e;
        if (i < hVarArr.length && i >= 0) {
            h hVar = hVarArr[i];
            if (hVar.a == i) {
                return hVar;
            }
        }
        int i2 = 0;
        while (true) {
            h[] hVarArr2 = e;
            if (i2 >= hVarArr2.length) {
                throw new IllegalArgumentException("No enum " + h.class + " with value " + i);
            }
            h hVar2 = hVarArr2[i2];
            if (hVar2.a == i) {
                return hVar2;
            }
            i2++;
        }
    }
}
