package com.amazon.device.iap.internal.a.g;

import com.amazon.a.a.n.a.h;
import com.amazon.d.a.j;
import com.amazon.device.iap.PurchasingService;

/* JADX INFO: loaded from: classes3.dex */
abstract class a extends h {
    protected static final String b = "response_received";

    @Override // com.amazon.a.a.n.a.h
    protected boolean b(j jVar) throws Exception {
        return true;
    }

    a(com.amazon.device.iap.internal.a.c cVar, String str) {
        super(cVar, b, str, cVar.d().toString(), PurchasingService.SDK_VERSION);
        b(false);
    }
}
