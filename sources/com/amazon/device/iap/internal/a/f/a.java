package com.amazon.device.iap.internal.a.f;

import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.model.PurchaseResponse;

/* JADX INFO: loaded from: classes3.dex */
abstract class a extends h {
    protected static final String b = "purchase_response";

    a(com.amazon.device.iap.internal.a.c cVar, String str) {
        super(cVar, b, str, cVar.d().toString(), PurchasingService.SDK_VERSION);
    }

    protected void a(String str, String str2, String str3, PurchaseResponse.RequestStatus requestStatus) {
        com.amazon.device.iap.internal.a.c cVar = (com.amazon.device.iap.internal.a.c) j();
        cVar.a().a(new PurchaseResponseBuilder().setRequestId(cVar.d()).setRequestStatus(requestStatus).setUserData(new UserDataBuilder().setUserId(str).setMarketplace(str2).build()).setReceipt(null).build());
    }
}
