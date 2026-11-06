package com.amazon.a.a.o.b.a;

import com.amazon.a.a.n.a.a.g;
import com.revenuecat.purchases.common.Constants;

/* JADX INFO: loaded from: classes3.dex */
public class b extends com.amazon.a.a.d.b {
    private static final long a = 1;

    private b(String str, String str2) {
        super("SIGNED_TOKEN_PARSE_FAILURE", str, str2);
    }

    public static b d() {
        return new b("INVALID_FORMAT", null);
    }

    public static b a(Throwable th) {
        return new b("DECODE", th.getMessage());
    }

    public static b a(String str) {
        return new b(g.b, str);
    }

    public static b a(String str, String str2) {
        return new b("INVALID_FIELD_VALUE", str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str2);
    }
}
