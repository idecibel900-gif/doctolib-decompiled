package com.amazon.device.iap.internal.a.a;

import android.os.RemoteException;
import com.amazon.a.a.o.f;
import com.amazon.d.a.j;
import com.amazon.device.iap.internal.model.ProductBuilder;
import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import com.amazon.device.iap.internal.util.MetricsHelper;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.Promotion;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends a {
    private static final String d = "c";

    public c(com.amazon.device.iap.internal.a.c cVar, Set<String> set) {
        super(cVar, com.amazon.a.a.o.b.ah, set);
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
                    String str2 = (String) mapB.get(str);
                    String strK = k();
                    StringBuilder sb = new StringBuilder();
                    String str3 = d;
                    sb.append(str3);
                    sb.append(".onResult()");
                    MetricsHelper.submitJsonParsingExceptionMetrics(strK, str2, sb.toString());
                    com.amazon.device.iap.internal.util.b.b(str3, "Error parsing JSON for SKU " + str + ": " + e.getMessage());
                }
            }
        }
        com.amazon.device.iap.internal.a.c cVar = (com.amazon.device.iap.internal.a.c) j();
        cVar.a().a(new ProductDataResponseBuilder().setRequestId(cVar.d()).setRequestStatus(ProductDataResponse.RequestStatus.SUCCESSFUL).setUnavailableSkus(linkedHashSet).setProductData(map).build());
        return true;
    }

    private Product a(String str, Map map) throws IllegalArgumentException {
        JSONObject jSONObjectOptJSONObject;
        String str2 = (String) map.get(str);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            ProductType productTypeValueOf = ProductType.valueOf(jSONObject.getString(com.amazon.a.a.o.b.k).toUpperCase());
            String string = jSONObject.getString(com.amazon.a.a.o.b.c);
            List<Promotion> listA = null;
            String strOptString = jSONObject.optString(com.amazon.a.a.o.b.x, null);
            if (f.a(strOptString) && (jSONObjectOptJSONObject = jSONObject.optJSONObject(com.amazon.a.a.o.b.y)) != null) {
                Currency currency = Currency.getInstance(jSONObjectOptJSONObject.getString(com.amazon.a.a.o.b.a));
                strOptString = currency.getSymbol() + new BigDecimal(jSONObjectOptJSONObject.getString("value"));
            }
            String string2 = jSONObject.getString(com.amazon.a.a.o.b.S);
            String string3 = jSONObject.getString(com.amazon.a.a.o.b.j);
            int iOptInt = jSONObject.optInt(com.amazon.a.a.o.b.T, 0);
            String string4 = jSONObject.isNull(com.amazon.a.a.o.b.o) ? null : jSONObject.getString(com.amazon.a.a.o.b.o);
            String string5 = jSONObject.isNull(com.amazon.a.a.o.b.p) ? null : jSONObject.getString(com.amazon.a.a.o.b.p);
            if (!jSONObject.isNull(com.amazon.a.a.o.b.q)) {
                listA = e.a(jSONObject);
            }
            return new ProductBuilder().setSku(str).setProductType(productTypeValueOf).setDescription(string).setPrice(strOptString).setSmallIconUrl(string3).setTitle(string2).setCoinsRewardAmount(iOptInt).setSubscriptionPeriod(string4).setFreeTrialPeriod(string5).setPromotions(listA).build();
        } catch (JSONException unused) {
            throw new IllegalArgumentException("error in parsing json string" + str2);
        }
    }
}
