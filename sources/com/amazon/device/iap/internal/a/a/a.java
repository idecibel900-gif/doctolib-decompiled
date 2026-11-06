package com.amazon.device.iap.internal.a.a;

import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.PurchasingService;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
abstract class a extends h {
    protected static final String b = "getItem_data";
    protected final Set<String> c;

    a(com.amazon.device.iap.internal.a.c cVar, String str, Set<String> set) {
        super(cVar, b, str, cVar.d().toString(), PurchasingService.SDK_VERSION);
        this.c = set;
        a(com.amazon.a.a.o.b.O, set);
    }
}
