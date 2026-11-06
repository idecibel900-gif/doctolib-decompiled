package com.amazon.device.iap.internal.a.b;

import com.amazon.d.a.j;
import com.amazon.device.iap.internal.a.e;
import com.amazon.device.iap.internal.a.f;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.internal.model.ReceiptBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends b {
    private static final String d = "c";
    private static final Date e = new Date(0);

    public c(com.amazon.device.iap.internal.a.c cVar, boolean z) {
        super(cVar, "1.0", z);
    }

    @Override // com.amazon.a.a.n.a.h
    protected boolean b(j jVar) throws Exception {
        Map mapB = jVar.b();
        com.amazon.device.iap.internal.util.b.a(d, "data: " + mapB);
        String str = (String) mapB.get("userId");
        String str2 = (String) mapB.get(com.amazon.a.a.o.b.m);
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray((String) mapB.get(com.amazon.a.a.o.b.G));
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Receipt receiptA = com.amazon.device.iap.internal.util.c.a(jSONArray.getJSONObject(i), str, (String) null);
                arrayList.add(receiptA);
                if (ProductType.ENTITLED == receiptA.getProductType()) {
                    com.amazon.device.iap.internal.b.a.a().a(str, receiptA.getReceiptId(), receiptA.getSku());
                }
            } catch (e e2) {
                com.amazon.device.iap.internal.util.b.b(d, "fail to parse receipt, requestId:" + e2.a());
            } catch (f e3) {
                com.amazon.device.iap.internal.util.b.b(d, "fail to verify receipt, requestId:" + e3.a());
            } catch (Throwable th) {
                com.amazon.device.iap.internal.util.b.b(d, "fail to verify receipt, requestId:" + th.getMessage());
            }
        }
        JSONArray jSONArray2 = new JSONArray((String) mapB.get(com.amazon.a.a.o.b.H));
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            try {
                String string = jSONArray2.getString(i2);
                arrayList.add(new ReceiptBuilder().setSku(string).setProductType(ProductType.ENTITLED).setPurchaseDate(null).setCancelDate(e).setReceiptId(com.amazon.device.iap.internal.b.a.a().a(str, string)).build());
            } catch (JSONException unused) {
                com.amazon.device.iap.internal.util.b.b(d, "fail to parse JSON[" + i2 + "] in \"" + jSONArray2 + "\"");
            }
        }
        String str3 = (String) mapB.get(com.amazon.a.a.o.b.b);
        boolean zEqualsIgnoreCase = com.amazon.a.a.o.b.af.equalsIgnoreCase((String) mapB.get(com.amazon.a.a.o.b.i));
        com.amazon.device.iap.internal.a.c cVar = (com.amazon.device.iap.internal.a.c) j();
        PurchaseUpdatesResponse purchaseUpdatesResponseBuild = new PurchaseUpdatesResponseBuilder().setRequestId(cVar.d()).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL).setUserData(new UserDataBuilder().setUserId(str).setMarketplace(str2).build()).setReceipts(arrayList).setHasMore(zEqualsIgnoreCase).build();
        purchaseUpdatesResponseBuild.getReceipts().addAll(com.amazon.device.iap.internal.b.d.a().b(purchaseUpdatesResponseBuild.getUserData().getUserId()));
        cVar.a().a(purchaseUpdatesResponseBuild);
        cVar.a().a(com.amazon.a.a.o.b.ap, str3);
        return true;
    }
}
