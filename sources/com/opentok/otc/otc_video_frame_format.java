package com.opentok.otc;

/* JADX INFO: loaded from: classes4.dex */
public final class otc_video_frame_format {
    public static final otc_video_frame_format c;
    public static final otc_video_frame_format d;
    public static final otc_video_frame_format e;
    public static final otc_video_frame_format f;
    public static final otc_video_frame_format g;
    public static final otc_video_frame_format h;
    public static final otc_video_frame_format i;
    public static final otc_video_frame_format j;
    public static final otc_video_frame_format k;
    public static final otc_video_frame_format l;
    public static final otc_video_frame_format m;
    public static final otc_video_frame_format n;
    public static final otc_video_frame_format o;
    public static final otc_video_frame_format p;
    private static otc_video_frame_format[] q;
    private static int r;
    private final int a;
    private final String b;

    static {
        otc_video_frame_format otc_video_frame_formatVar = new otc_video_frame_format("OTC_VIDEO_FRAME_FORMAT_UNKNOWN", opentokJNI.OTC_VIDEO_FRAME_FORMAT_UNKNOWN_get());
        c = otc_video_frame_formatVar;
        otc_video_frame_format otc_video_frame_formatVar2 = new otc_video_frame_format("OTC_VIDEO_FRAME_FORMAT_YUV420P", opentokJNI.OTC_VIDEO_FRAME_FORMAT_YUV420P_get());
        d = otc_video_frame_formatVar2;
        otc_video_frame_format otc_video_frame_formatVar3 = new otc_video_frame_format("OTC_VIDEO_FRAME_FORMAT_NV12", opentokJNI.OTC_VIDEO_FRAME_FORMAT_NV12_get());
        e = otc_video_frame_formatVar3;
        otc_video_frame_format otc_video_frame_formatVar4 = new otc_video_frame_format("OTC_VIDEO_FRAME_FORMAT_NV21", opentokJNI.OTC_VIDEO_FRAME_FORMAT_NV21_get());
        f = otc_video_frame_formatVar4;
        otc_video_frame_format otc_video_frame_formatVar5 = new otc_video_frame_format("OTC_VIDEO_FRAME_FORMAT_YUY2", opentokJNI.OTC_VIDEO_FRAME_FORMAT_YUY2_get());
        g = otc_video_frame_formatVar5;
        otc_video_frame_format otc_video_frame_formatVar6 = new otc_video_frame_format("OTC_VIDEO_FRAME_FORMAT_UYVY", opentokJNI.OTC_VIDEO_FRAME_FORMAT_UYVY_get());
        h = otc_video_frame_formatVar6;
        otc_video_frame_format otc_video_frame_formatVar7 = new otc_video_frame_format("OTC_VIDEO_FRAME_FORMAT_ARGB32", opentokJNI.OTC_VIDEO_FRAME_FORMAT_ARGB32_get());
        i = otc_video_frame_formatVar7;
        otc_video_frame_format otc_video_frame_formatVar8 = new otc_video_frame_format("OTC_VIDEO_FRAME_FORMAT_BGRA32", opentokJNI.OTC_VIDEO_FRAME_FORMAT_BGRA32_get());
        j = otc_video_frame_formatVar8;
        otc_video_frame_format otc_video_frame_formatVar9 = new otc_video_frame_format("OTC_VIDEO_FRAME_FORMAT_RGB24", opentokJNI.OTC_VIDEO_FRAME_FORMAT_RGB24_get());
        k = otc_video_frame_formatVar9;
        otc_video_frame_format otc_video_frame_formatVar10 = new otc_video_frame_format("OTC_VIDEO_FRAME_FORMAT_ABGR32", opentokJNI.OTC_VIDEO_FRAME_FORMAT_ABGR32_get());
        l = otc_video_frame_formatVar10;
        otc_video_frame_format otc_video_frame_formatVar11 = new otc_video_frame_format("OTC_VIDEO_FRAME_FORMAT_MJPEG", opentokJNI.OTC_VIDEO_FRAME_FORMAT_MJPEG_get());
        m = otc_video_frame_formatVar11;
        otc_video_frame_format otc_video_frame_formatVar12 = new otc_video_frame_format("OTC_VIDEO_FRAME_FORMAT_RGBA32", opentokJNI.OTC_VIDEO_FRAME_FORMAT_RGBA32_get());
        n = otc_video_frame_formatVar12;
        otc_video_frame_format otc_video_frame_formatVar13 = new otc_video_frame_format("OTC_VIDEO_FRAME_FORMAT_MAX");
        o = otc_video_frame_formatVar13;
        otc_video_frame_format otc_video_frame_formatVar14 = new otc_video_frame_format("OTC_VIDEO_FRAME_FORMAT_COMPRESSED", opentokJNI.OTC_VIDEO_FRAME_FORMAT_COMPRESSED_get());
        p = otc_video_frame_formatVar14;
        q = new otc_video_frame_format[]{otc_video_frame_formatVar, otc_video_frame_formatVar2, otc_video_frame_formatVar3, otc_video_frame_formatVar4, otc_video_frame_formatVar5, otc_video_frame_formatVar6, otc_video_frame_formatVar7, otc_video_frame_formatVar8, otc_video_frame_formatVar9, otc_video_frame_formatVar10, otc_video_frame_formatVar11, otc_video_frame_formatVar12, otc_video_frame_formatVar13, otc_video_frame_formatVar14};
        r = 0;
    }

    private otc_video_frame_format(String str) {
        this.b = str;
        int i2 = r;
        r = i2 + 1;
        this.a = i2;
    }

    public final int a() {
        return this.a;
    }

    public String toString() {
        return this.b;
    }

    public static otc_video_frame_format a(int i2) {
        otc_video_frame_format[] otc_video_frame_formatVarArr = q;
        if (i2 < otc_video_frame_formatVarArr.length && i2 >= 0) {
            otc_video_frame_format otc_video_frame_formatVar = otc_video_frame_formatVarArr[i2];
            if (otc_video_frame_formatVar.a == i2) {
                return otc_video_frame_formatVar;
            }
        }
        int i3 = 0;
        while (true) {
            otc_video_frame_format[] otc_video_frame_formatVarArr2 = q;
            if (i3 >= otc_video_frame_formatVarArr2.length) {
                throw new IllegalArgumentException("No enum " + otc_video_frame_format.class + " with value " + i2);
            }
            otc_video_frame_format otc_video_frame_formatVar2 = otc_video_frame_formatVarArr2[i3];
            if (otc_video_frame_formatVar2.a == i2) {
                return otc_video_frame_formatVar2;
            }
            i3++;
        }
    }

    private otc_video_frame_format(String str, int i2) {
        this.b = str;
        this.a = i2;
        r = i2 + 1;
    }
}
