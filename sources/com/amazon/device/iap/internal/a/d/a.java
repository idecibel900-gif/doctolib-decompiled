package com.amazon.device.iap.internal.a.d;

import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.internal.a.c;
import com.amazon.device.iap.internal.b.d;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.RequestId;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends c {
    private final String c;
    private final FulfillmentResult d;

    @Override // com.amazon.device.iap.internal.a.c, com.amazon.a.a.j.a
    public void b() {
    }

    public a(RequestId requestId, String str, FulfillmentResult fulfillmentResult) {
        super(requestId);
        HashSet hashSet = new HashSet();
        hashSet.add(str);
        this.c = str;
        this.d = fulfillmentResult;
        a((h) new b(this, hashSet, fulfillmentResult.toString()));
    }

    @Override // com.amazon.device.iap.internal.a.c, com.amazon.a.a.j.a
    public void c() {
        String strC;
        FulfillmentResult fulfillmentResult = FulfillmentResult.FULFILLED;
        FulfillmentResult fulfillmentResult2 = this.d;
        if ((fulfillmentResult == fulfillmentResult2 || FulfillmentResult.UNAVAILABLE == fulfillmentResult2) && (strC = d.a().c(this.c)) != null) {
            new com.amazon.device.iap.internal.a.g.b(this, strC).l();
            d.a().a(this.c);
        }
    }
}
