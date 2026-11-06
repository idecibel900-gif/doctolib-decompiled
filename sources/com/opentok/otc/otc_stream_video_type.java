package com.opentok.otc;

/* JADX INFO: loaded from: classes4.dex */
public final class otc_stream_video_type {
    public static final otc_stream_video_type c;
    public static final otc_stream_video_type d;
    public static final otc_stream_video_type e;
    private static otc_stream_video_type[] f;
    private static int g;
    private final int a;
    private final String b;

    static {
        otc_stream_video_type otc_stream_video_typeVar = new otc_stream_video_type("OTC_STREAM_VIDEO_TYPE_CAMERA", opentokJNI.OTC_STREAM_VIDEO_TYPE_CAMERA_get());
        c = otc_stream_video_typeVar;
        otc_stream_video_type otc_stream_video_typeVar2 = new otc_stream_video_type("OTC_STREAM_VIDEO_TYPE_SCREEN", opentokJNI.OTC_STREAM_VIDEO_TYPE_SCREEN_get());
        d = otc_stream_video_typeVar2;
        otc_stream_video_type otc_stream_video_typeVar3 = new otc_stream_video_type("OTC_STREAM_VIDEO_TYPE_CUSTOM", opentokJNI.OTC_STREAM_VIDEO_TYPE_CUSTOM_get());
        e = otc_stream_video_typeVar3;
        f = new otc_stream_video_type[]{otc_stream_video_typeVar, otc_stream_video_typeVar2, otc_stream_video_typeVar3};
        g = 0;
    }

    private otc_stream_video_type(String str, int i) {
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

    public static otc_stream_video_type a(int i) {
        otc_stream_video_type[] otc_stream_video_typeVarArr = f;
        if (i < otc_stream_video_typeVarArr.length && i >= 0) {
            otc_stream_video_type otc_stream_video_typeVar = otc_stream_video_typeVarArr[i];
            if (otc_stream_video_typeVar.a == i) {
                return otc_stream_video_typeVar;
            }
        }
        int i2 = 0;
        while (true) {
            otc_stream_video_type[] otc_stream_video_typeVarArr2 = f;
            if (i2 >= otc_stream_video_typeVarArr2.length) {
                throw new IllegalArgumentException("No enum " + otc_stream_video_type.class + " with value " + i);
            }
            otc_stream_video_type otc_stream_video_typeVar2 = otc_stream_video_typeVarArr2[i2];
            if (otc_stream_video_typeVar2.a == i) {
                return otc_stream_video_typeVar2;
            }
            i2++;
        }
    }
}
