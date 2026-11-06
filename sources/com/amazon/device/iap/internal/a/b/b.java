package com.amazon.device.iap.internal.a.b;

import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.PurchasingService;

/* JADX INFO: loaded from: classes3.dex */
abstract class b extends h {
    protected static final String b = "purchase_updates";
    protected final boolean c;

    b(com.amazon.device.iap.internal.a.c cVar, String str, boolean z) {
        super(cVar, b, str, cVar.d().toString(), PurchasingService.SDK_VERSION);
        this.c = z;
    }

    @Override // com.amazon.a.a.n.a.a
    protected void e() throws com.amazon.a.a.d.b {
        super.e();
        a(com.amazon.a.a.o.b.b, this.c ? null : com.amazon.device.iap.internal.util.a.a((String) ((com.amazon.device.iap.internal.a.c) j()).a().a("userId")));
        a(com.amazon.a.a.o.b.ac, Boolean.valueOf(com.amazon.device.iap.internal.d.f().d()));
    }
}
