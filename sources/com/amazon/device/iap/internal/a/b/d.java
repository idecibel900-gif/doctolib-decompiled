package com.amazon.device.iap.internal.a.b;

import com.amazon.d.a.j;
import com.amazon.device.iap.internal.a.e;
import com.amazon.device.iap.internal.a.f;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends b {
    private static final String d = "d";

    public d(com.amazon.device.iap.internal.a.c cVar, boolean z) {
        super(cVar, com.amazon.a.a.o.b.ah, z);
    }

    @Override // com.amazon.a.a.n.a.h
    protected boolean b(j jVar) throws Exception {
        Map mapB = jVar.b();
        com.amazon.device.iap.internal.util.b.a(d, "data: " + mapB);
        String str = (String) mapB.get("userId");
        String str2 = (String) mapB.get(com.amazon.a.a.o.b.m);
        List<Receipt> listA = a(str, (String) mapB.get(com.amazon.a.a.o.b.G), (String) mapB.get("requestId"));
        String str3 = (String) mapB.get(com.amazon.a.a.o.b.b);
        boolean zBooleanValue = Boolean.valueOf((String) mapB.get(com.amazon.a.a.o.b.i)).booleanValue();
        com.amazon.device.iap.internal.a.c cVar = (com.amazon.device.iap.internal.a.c) j();
        PurchaseUpdatesResponse purchaseUpdatesResponseBuild = new PurchaseUpdatesResponseBuilder().setRequestId(cVar.d()).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL).setUserData(new UserDataBuilder().setUserId(str).setMarketplace(str2).build()).setReceipts(listA).setHasMore(zBooleanValue).build();
        cVar.a().a(com.amazon.a.a.o.b.ap, str3);
        cVar.a().a(purchaseUpdatesResponseBuild);
        return true;
    }

    private List<Receipt> a(String str, String str2, String str3) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str2);
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(com.amazon.device.iap.internal.util.c.a(jSONArray.getJSONObject(i), str, str3));
            } catch (e e) {
                com.amazon.device.iap.internal.util.b.b(d, "fail to parse receipt, requestId:" + e.a());
            } catch (f e2) {
                com.amazon.device.iap.internal.util.b.b(d, "fail to verify receipt, requestId:" + e2.a());
            } catch (Throwable th) {
                com.amazon.device.iap.internal.util.b.b(d, "fail to verify receipt, requestId:" + th.getMessage());
            }
        }
        return arrayList;
    }
}
