package com.amazon.device.iap.internal.a;

import android.content.Context;
import android.os.Handler;
import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataResponse;

/* JADX INFO: loaded from: classes3.dex */
public class c extends com.amazon.a.a.j.a {
    private static final String c = "c";
    private RequestId d;

    @Override // com.amazon.a.a.j.a
    public void b() {
    }

    @Override // com.amazon.a.a.j.a
    public void c() {
    }

    public c(RequestId requestId) {
        this.d = requestId;
    }

    @Override // com.amazon.a.a.j.a
    protected void a(h hVar) {
        this.b = hVar;
    }

    protected void a(Object obj) {
        a(obj, null);
    }

    protected void a(final Object obj, final h hVar) {
        com.amazon.a.a.o.f.a(obj, "response");
        Context contextB = com.amazon.device.iap.internal.d.f().b();
        final PurchasingListener purchasingListenerA = com.amazon.device.iap.internal.d.f().a();
        if (contextB == null || purchasingListenerA == null) {
            com.amazon.device.iap.internal.util.b.a(c, "PurchasingListener is not set. Dropping response: " + obj);
            return;
        }
        new Handler(contextB.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.iap.internal.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.a().a(com.amazon.a.a.o.b.ao, Boolean.FALSE);
                try {
                    Object obj2 = obj;
                    if (obj2 instanceof ProductDataResponse) {
                        purchasingListenerA.onProductDataResponse((ProductDataResponse) obj2);
                    } else if (obj2 instanceof UserDataResponse) {
                        purchasingListenerA.onUserDataResponse((UserDataResponse) obj2);
                    } else if (obj2 instanceof PurchaseUpdatesResponse) {
                        PurchaseUpdatesResponse purchaseUpdatesResponse = (PurchaseUpdatesResponse) obj2;
                        purchasingListenerA.onPurchaseUpdatesResponse(purchaseUpdatesResponse);
                        Object objA = c.this.a().a(com.amazon.a.a.o.b.ap);
                        if (objA != null && (objA instanceof String)) {
                            com.amazon.device.iap.internal.util.a.a(purchaseUpdatesResponse.getUserData().getUserId(), objA.toString());
                        }
                    } else if (!(obj2 instanceof PurchaseResponse)) {
                        com.amazon.device.iap.internal.util.b.b(c.c, "Unknown response type:" + obj.getClass().getName());
                    } else {
                        purchasingListenerA.onPurchaseResponse((PurchaseResponse) obj2);
                    }
                    c.this.a().a(com.amazon.a.a.o.b.ao, Boolean.TRUE);
                } catch (Throwable th) {
                    com.amazon.device.iap.internal.util.b.b(c.c, "Error in sendResponse: " + th);
                }
                h hVar2 = hVar;
                if (hVar2 != null) {
                    hVar2.a(true);
                    hVar.l();
                }
            }
        });
    }

    public RequestId d() {
        return this.d;
    }

    @Override // com.amazon.a.a.j.a
    public com.amazon.a.a.j.b a() {
        return this.a;
    }

    public void e() {
        h hVar = this.b;
        if (hVar != null) {
            hVar.l();
        } else {
            b();
        }
    }
}
