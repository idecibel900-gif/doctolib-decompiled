package com.amazon.device.iap.internal.a.f;

import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.amazon.device.iap.internal.a.c {
    public d(RequestId requestId) {
        super(requestId);
        c cVar = new c(this);
        cVar.b(new b(this));
        a((h) cVar);
    }

    @Override // com.amazon.device.iap.internal.a.c, com.amazon.a.a.j.a
    public void b() {
        PurchaseResponse purchaseResponse = (PurchaseResponse) a().b();
        if (purchaseResponse == null) {
            return;
        }
        Receipt receipt = purchaseResponse.getReceipt();
        boolean z = receipt != null;
        h cVar = new com.amazon.device.iap.internal.a.g.c(this, z);
        if (z && (ProductType.ENTITLED == receipt.getProductType() || ProductType.SUBSCRIPTION == receipt.getProductType())) {
            cVar.b(new com.amazon.device.iap.internal.a.g.b(this, d().toString()));
        }
        a(purchaseResponse, cVar);
    }

    @Override // com.amazon.device.iap.internal.a.c, com.amazon.a.a.j.a
    public void c() {
        PurchaseResponse purchaseResponseBuild = (PurchaseResponse) a().b();
        if (purchaseResponseBuild == null) {
            purchaseResponseBuild = new PurchaseResponseBuilder().setRequestId(d()).setRequestStatus(PurchaseResponse.RequestStatus.FAILED).build();
        }
        a(purchaseResponseBuild, new com.amazon.device.iap.internal.a.g.c(this, false));
    }
}
