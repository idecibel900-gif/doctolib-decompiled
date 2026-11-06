package com.amazon.device.iap.internal.a.a;

import android.os.RemoteException;
import com.amazon.d.a.j;
import com.amazon.device.iap.internal.model.ProductBuilder;
import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.ProductType;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends a {
    private static final String d = "b";

    public b(com.amazon.device.iap.internal.a.c cVar, Set<String> set) {
        super(cVar, "1.0", set);
    }

    @Override // com.amazon.a.a.n.a.h
    protected boolean b(j jVar) throws com.amazon.a.a.d.b, RemoteException {
        Map mapB = jVar.b();
        com.amazon.device.iap.internal.util.b.a(d, "data: " + mapB);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        HashMap map = new HashMap();
        for (String str : ((a) this).c) {
            if (!mapB.containsKey(str)) {
                linkedHashSet.add(str);
            } else {
                try {
                    map.put(str, a(str, mapB));
                } catch (IllegalArgumentException e) {
                    linkedHashSet.add(str);
                    com.amazon.device.iap.internal.util.b.b(d, "Error parsing JSON for SKU " + str + ": " + e.getMessage());
                }
            }
        }
        com.amazon.device.iap.internal.a.c cVar = (com.amazon.device.iap.internal.a.c) j();
        cVar.a().a(new ProductDataResponseBuilder().setRequestId(cVar.d()).setRequestStatus(ProductDataResponse.RequestStatus.SUCCESSFUL).setUnavailableSkus(linkedHashSet).setProductData(map).build());
        return true;
    }

    private Product a(String str, Map map) throws IllegalArgumentException {
        String str2 = (String) map.get(str);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            ProductType productTypeValueOf = ProductType.valueOf(jSONObject.getString(com.amazon.a.a.o.b.k).toUpperCase());
            String string = jSONObject.getString(com.amazon.a.a.o.b.c);
            String strOptString = jSONObject.optString(com.amazon.a.a.o.b.x);
            return new ProductBuilder().setSku(str).setProductType(productTypeValueOf).setDescription(string).setPrice(strOptString).setSmallIconUrl(jSONObject.getString(com.amazon.a.a.o.b.j)).setTitle(jSONObject.getString(com.amazon.a.a.o.b.S)).setCoinsRewardAmount(jSONObject.optInt(com.amazon.a.a.o.b.T, 0)).build();
        } catch (JSONException unused) {
            throw new IllegalArgumentException("error in parsing json string" + str2);
        }
    }
}
