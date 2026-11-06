package com.opentok.otc;

/* JADX INFO: loaded from: classes4.dex */
public final class k {
    public static final k c;
    public static final k d;
    public static final k e;
    public static final k f;
    public static final k g;
    public static final k h;
    private static k[] i;
    private static int j;
    private final int a;
    private final String b;

    static {
        k kVar = new k("OTC_VIDEO_FRAME_PLANE_Y", opentokJNI.OTC_VIDEO_FRAME_PLANE_Y_get());
        c = kVar;
        k kVar2 = new k("OTC_VIDEO_FRAME_PLANE_U", opentokJNI.OTC_VIDEO_FRAME_PLANE_U_get());
        d = kVar2;
        k kVar3 = new k("OTC_VIDEO_FRAME_PLANE_V", opentokJNI.OTC_VIDEO_FRAME_PLANE_V_get());
        e = kVar3;
        k kVar4 = new k("OTC_VIDEO_FRAME_PLANE_PACKED", opentokJNI.OTC_VIDEO_FRAME_PLANE_PACKED_get());
        f = kVar4;
        k kVar5 = new k("OTC_VIDEO_FRAME_PLANE_UV_INTERLEAVED", opentokJNI.OTC_VIDEO_FRAME_PLANE_UV_INTERLEAVED_get());
        g = kVar5;
        k kVar6 = new k("OTC_VIDEO_FRAME_PLANE_VU_INTERLEAVED", opentokJNI.OTC_VIDEO_FRAME_PLANE_VU_INTERLEAVED_get());
        h = kVar6;
        i = new k[]{kVar, kVar2, kVar3, kVar4, kVar5, kVar6};
        j = 0;
    }

    private k(String str, int i2) {
        this.b = str;
        this.a = i2;
        j = i2 + 1;
    }

    public final int a() {
        return this.a;
    }

    public String toString() {
        return this.b;
    }
}
