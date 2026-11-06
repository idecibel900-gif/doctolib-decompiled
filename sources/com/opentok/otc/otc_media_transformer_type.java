package com.opentok.otc;

/* JADX INFO: loaded from: classes4.dex */
public final class otc_media_transformer_type {
    public static final otc_media_transformer_type c;
    public static final otc_media_transformer_type d;
    private static otc_media_transformer_type[] e;
    private static int f;
    private final int a;
    private final String b;

    static {
        otc_media_transformer_type otc_media_transformer_typeVar = new otc_media_transformer_type("OTC_MEDIA_TRANSFORMER_TYPE_CUSTOM", opentokJNI.OTC_MEDIA_TRANSFORMER_TYPE_CUSTOM_get());
        c = otc_media_transformer_typeVar;
        otc_media_transformer_type otc_media_transformer_typeVar2 = new otc_media_transformer_type("OTC_MEDIA_TRANSFORMER_TYPE_VONAGE");
        d = otc_media_transformer_typeVar2;
        e = new otc_media_transformer_type[]{otc_media_transformer_typeVar, otc_media_transformer_typeVar2};
        f = 0;
    }

    private otc_media_transformer_type(String str) {
        this.b = str;
        int i = f;
        f = i + 1;
        this.a = i;
    }

    public final int a() {
        return this.a;
    }

    public String toString() {
        return this.b;
    }

    private otc_media_transformer_type(String str, int i) {
        this.b = str;
        this.a = i;
        f = i + 1;
    }
}
