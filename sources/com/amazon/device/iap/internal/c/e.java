package com.amazon.device.iap.internal.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.amazon.a.a.o.f;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.model.ProductBuilder;
import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.internal.model.ReceiptBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataRequest;
import com.amazon.device.iap.model.UserDataResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.amazon.device.iap.internal.e {
    private static final String a = "e";
    private static final String b = "com.amazon.sdktestclient";
    private static final String c = "com.amazon.sdktestclient.command.CommandBroker";

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, UserDataRequest userDataRequest) {
        com.amazon.device.iap.internal.util.b.a(a, "sendGetUserDataRequest");
        a(requestId.toString(), false, false, userDataRequest);
    }

    private void a(String str, boolean z, boolean z2, UserDataRequest userDataRequest) {
        try {
            Context contextB = com.amazon.device.iap.internal.d.f().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", str);
            jSONObject.put("packageName", contextB.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.I, PurchasingService.SDK_VERSION);
            jSONObject.put(b.at, z);
            jSONObject.put(b.au, z2);
            if (userDataRequest != null) {
                jSONObject.put("UserDataRequest.fetchLWAConsentStatus", userDataRequest.getFetchLWAConsentStatus());
            }
            bundle.putString("userInput", jSONObject.toString());
            Intent intentA = a("com.amazon.testclient.iap.appUserId");
            intentA.addFlags(268435456);
            intentA.putExtras(bundle);
            contextB.startService(intentA);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.b.b(a, "Error in sendGetUserDataRequest.");
        }
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, String str) {
        com.amazon.device.iap.internal.util.b.a(a, "sendPurchaseRequest");
        try {
            Context contextB = com.amazon.device.iap.internal.d.f().b();
            boolean zD = com.amazon.device.iap.internal.d.f().d();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sku", str);
            jSONObject.put(com.amazon.a.a.o.b.ac, zD);
            jSONObject.put("requestId", requestId.toString());
            jSONObject.put("packageName", contextB.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.I, PurchasingService.SDK_VERSION);
            bundle.putString("purchaseInput", jSONObject.toString());
            Intent intentA = a("com.amazon.testclient.iap.purchase");
            intentA.addFlags(268435456);
            intentA.putExtras(bundle);
            contextB.startService(intentA);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.b.b(a, "Error in sendPurchaseRequest.");
        }
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, Set<String> set) {
        com.amazon.device.iap.internal.util.b.a(a, "sendItemDataRequest");
        try {
            Context contextB = com.amazon.device.iap.internal.d.f().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray((Collection) set);
            jSONObject.put("requestId", requestId.toString());
            jSONObject.put("packageName", contextB.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.O, jSONArray);
            jSONObject.put(com.amazon.a.a.o.b.I, PurchasingService.SDK_VERSION);
            bundle.putString("itemDataInput", jSONObject.toString());
            Intent intentA = a("com.amazon.testclient.iap.itemData");
            intentA.addFlags(268435456);
            intentA.putExtras(bundle);
            contextB.startService(intentA);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.b.b(a, "Error in sendItemDataRequest.");
        }
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, boolean z) {
        if (requestId == null) {
            requestId = new RequestId();
        }
        com.amazon.device.iap.internal.util.b.a(a, "sendPurchaseUpdatesRequest/sendGetUserData first:" + requestId);
        a(requestId.toString(), true, z, null);
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, String str, FulfillmentResult fulfillmentResult) {
        com.amazon.device.iap.internal.util.b.a(a, "sendNotifyPurchaseFulfilled");
        try {
            Context contextB = com.amazon.device.iap.internal.d.f().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", requestId.toString());
            jSONObject.put("packageName", contextB.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.E, str);
            jSONObject.put("fulfillmentResult", fulfillmentResult);
            jSONObject.put(com.amazon.a.a.o.b.I, PurchasingService.SDK_VERSION);
            bundle.putString("purchaseFulfilledInput", jSONObject.toString());
            Intent intentA = a("com.amazon.testclient.iap.purchaseFulfilled");
            intentA.addFlags(268435456);
            intentA.putExtras(bundle);
            contextB.startService(intentA);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.b.b(a, "Error in sendNotifyPurchaseFulfilled.");
        }
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(Context context, Intent intent) {
        com.amazon.device.iap.internal.util.b.a(a, "handleResponse");
        intent.setComponent(new ComponentName(b, c));
        try {
            String string = intent.getExtras().getString("responseType");
            if (string.equalsIgnoreCase("com.amazon.testclient.iap.purchase")) {
                g(intent);
                return;
            }
            if (string.equalsIgnoreCase("com.amazon.testclient.iap.appUserId")) {
                e(intent);
            } else if (string.equalsIgnoreCase("com.amazon.testclient.iap.itemData")) {
                c(intent);
            } else if (string.equalsIgnoreCase("com.amazon.testclient.iap.purchaseUpdates")) {
                a(intent);
            }
        } catch (Exception unused) {
        }
    }

    private Intent a(String str) {
        Intent intent = new Intent(str);
        intent.setComponent(new ComponentName(b, c));
        return intent;
    }

    protected void a(final Object obj) {
        f.a(obj, "response");
        Context contextB = com.amazon.device.iap.internal.d.f().b();
        final PurchasingListener purchasingListenerA = com.amazon.device.iap.internal.d.f().a();
        if (contextB == null || purchasingListenerA == null) {
            com.amazon.device.iap.internal.util.b.a(a, "PurchasingListener is not set. Dropping response: " + obj);
            return;
        }
        new Handler(contextB.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.iap.internal.c.e.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Object obj2 = obj;
                    if (obj2 instanceof ProductDataResponse) {
                        purchasingListenerA.onProductDataResponse((ProductDataResponse) obj2);
                        return;
                    }
                    if (obj2 instanceof UserDataResponse) {
                        purchasingListenerA.onUserDataResponse((UserDataResponse) obj2);
                        return;
                    }
                    if (obj2 instanceof PurchaseUpdatesResponse) {
                        purchasingListenerA.onPurchaseUpdatesResponse((PurchaseUpdatesResponse) obj2);
                        return;
                    }
                    if (!(obj2 instanceof PurchaseResponse)) {
                        com.amazon.device.iap.internal.util.b.b(e.a, "Unknown response type:" + obj.getClass().getName());
                        return;
                    }
                    purchasingListenerA.onPurchaseResponse((PurchaseResponse) obj2);
                } catch (Exception e) {
                    com.amazon.device.iap.internal.util.b.b(e.a, "Error in sendResponse: " + e);
                }
            }
        });
    }

    private void a(Intent intent) throws JSONException {
        PurchaseUpdatesResponse purchaseUpdatesResponseB = b(intent);
        if (purchaseUpdatesResponseB.getRequestStatus() == PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL) {
            com.amazon.device.iap.internal.util.a.a(purchaseUpdatesResponseB.getUserData().getUserId(), new JSONObject(intent.getStringExtra("purchaseUpdatesOutput")).optString(b.as));
        }
        a(purchaseUpdatesResponseB);
    }

    private PurchaseUpdatesResponse b(Intent intent) {
        UserData userDataBuild;
        ArrayList arrayList;
        RequestId requestIdFromString;
        boolean zOptBoolean;
        PurchaseUpdatesResponse.RequestStatus requestStatusValueOf = PurchaseUpdatesResponse.RequestStatus.FAILED;
        RequestId requestId = null;
        ArrayList arrayList2 = null;
        boolean z = false;
        z = false;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("purchaseUpdatesOutput"));
            requestIdFromString = RequestId.fromString(jSONObject.optString("requestId"));
            try {
                requestStatusValueOf = PurchaseUpdatesResponse.RequestStatus.valueOf(jSONObject.optString("status"));
                zOptBoolean = jSONObject.optBoolean("isMore");
                try {
                    userDataBuild = new UserDataBuilder().setUserId(jSONObject.optString("userId")).setMarketplace(jSONObject.optString(com.amazon.a.a.o.b.m)).build();
                    try {
                        if (requestStatusValueOf == PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL) {
                            arrayList = new ArrayList();
                            try {
                                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(com.amazon.a.a.o.b.G);
                                if (jSONArrayOptJSONArray != null) {
                                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                                        try {
                                            arrayList.add(a(jSONObjectOptJSONObject));
                                        } catch (Exception unused) {
                                            Objects.toString(jSONObjectOptJSONObject);
                                        }
                                    }
                                }
                            } catch (Exception unused2) {
                                requestId = requestIdFromString;
                                z = zOptBoolean;
                                requestIdFromString = requestId;
                                zOptBoolean = z;
                            }
                            arrayList2 = arrayList;
                        }
                    } catch (Exception unused3) {
                        arrayList = null;
                        z = zOptBoolean;
                        requestId = requestIdFromString;
                        requestIdFromString = requestId;
                        zOptBoolean = z;
                        arrayList2 = arrayList;
                        return new PurchaseUpdatesResponseBuilder().setRequestId(requestIdFromString).setRequestStatus(requestStatusValueOf).setUserData(userDataBuild).setReceipts(arrayList2).setHasMore(zOptBoolean).build();
                    }
                } catch (Exception unused4) {
                    userDataBuild = null;
                    arrayList = null;
                }
            } catch (Exception unused5) {
                userDataBuild = null;
                arrayList = null;
            }
        } catch (Exception unused6) {
            userDataBuild = null;
            arrayList = null;
        }
        return new PurchaseUpdatesResponseBuilder().setRequestId(requestIdFromString).setRequestStatus(requestStatusValueOf).setUserData(userDataBuild).setReceipts(arrayList2).setHasMore(zOptBoolean).build();
    }

    private void c(Intent intent) {
        a(d(intent));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v7, types: [com.amazon.device.iap.internal.model.ProductDataResponseBuilder] */
    private ProductDataResponse d(Intent intent) {
        ?? r8;
        RequestId requestIdFromString;
        ProductDataResponse.RequestStatus requestStatusValueOf;
        ProductDataResponse.RequestStatus requestStatus = ProductDataResponse.RequestStatus.FAILED;
        RequestId requestId = null;
        HashMap map = null;
        ?? r1 = 0;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("itemDataOutput"));
            requestIdFromString = RequestId.fromString(jSONObject.optString("requestId"));
            try {
                requestStatusValueOf = ProductDataResponse.RequestStatus.valueOf(jSONObject.optString("status"));
                if (requestStatusValueOf != requestStatus) {
                    try {
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        try {
                            map = new HashMap();
                            try {
                                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("unavailableSkus");
                                if (jSONArrayOptJSONArray != null) {
                                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                        linkedHashSet.add(jSONArrayOptJSONArray.getString(i));
                                    }
                                }
                                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("items");
                                if (jSONObjectOptJSONObject != null) {
                                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                                    while (itKeys.hasNext()) {
                                        String next = itKeys.next();
                                        map.put(next, a(next, jSONObjectOptJSONObject.optJSONObject(next)));
                                    }
                                }
                                r1 = linkedHashSet;
                            } catch (Exception unused) {
                                requestId = requestIdFromString;
                                r8 = linkedHashSet;
                                requestStatus = requestStatusValueOf;
                                RequestId requestId2 = requestId;
                                r1 = r8;
                                requestIdFromString = requestId2;
                                requestStatusValueOf = requestStatus;
                            }
                        } catch (Exception unused2) {
                            map = null;
                        }
                    } catch (Exception unused3) {
                        requestStatus = requestStatusValueOf;
                        requestId = requestIdFromString;
                        r8 = requestId;
                        RequestId requestId3 = requestId;
                        r1 = r8;
                        requestIdFromString = requestId3;
                        requestStatusValueOf = requestStatus;
                        return new ProductDataResponseBuilder().setRequestId(requestIdFromString).setRequestStatus(requestStatusValueOf).setProductData(map).setUnavailableSkus(r1).build();
                    }
                } else {
                    map = null;
                }
            } catch (Exception unused4) {
            }
        } catch (Exception unused5) {
            r8 = 0;
            map = null;
        }
        return new ProductDataResponseBuilder().setRequestId(requestIdFromString).setRequestStatus(requestStatusValueOf).setProductData(map).setUnavailableSkus(r1).build();
    }

    private Product a(String str, JSONObject jSONObject) throws JSONException {
        String str2;
        ProductType productTypeValueOf = ProductType.valueOf(jSONObject.optString(com.amazon.a.a.o.b.k));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.amazon.a.a.o.b.y);
        if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject == JSONObject.NULL) {
            str2 = null;
        } else {
            Currency currency = Currency.getInstance(jSONObjectOptJSONObject.optString(com.amazon.a.a.o.b.a));
            str2 = currency.getSymbol() + jSONObjectOptJSONObject.optString("value");
        }
        String strOptString = jSONObject.optString(com.amazon.a.a.o.b.S);
        String strOptString2 = jSONObject.optString(com.amazon.a.a.o.b.c);
        String strOptString3 = jSONObject.optString("smallIconUrl");
        int iOptInt = jSONObject.optInt(com.amazon.a.a.o.b.T, 0);
        return new ProductBuilder().setSku(str).setProductType(productTypeValueOf).setDescription(strOptString2).setPrice(str2).setSmallIconUrl(strOptString3).setTitle(strOptString).setCoinsRewardAmount(iOptInt).setSubscriptionPeriod(jSONObject.isNull("term") ? null : jSONObject.getString("term")).setFreeTrialPeriod(jSONObject.isNull(com.amazon.a.a.o.b.p) ? null : jSONObject.getString(com.amazon.a.a.o.b.p)).setPromotions(jSONObject.isNull(com.amazon.a.a.o.b.q) ? null : a.a(jSONObject)).build();
    }

    private void e(Intent intent) {
        JSONObject jSONObject;
        UserDataResponse userDataResponseF = f(intent);
        RequestId requestId = userDataResponseF.getRequestId();
        try {
            jSONObject = new JSONObject(intent.getStringExtra("userInput"));
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (requestId == null || jSONObject == null) {
            a(userDataResponseF);
            return;
        }
        if (!jSONObject.optBoolean(b.at, false)) {
            a(userDataResponseF);
            return;
        }
        if (userDataResponseF.getUserData() == null || f.a(userDataResponseF.getUserData().getUserId())) {
            userDataResponseF.toString();
            a(new PurchaseUpdatesResponseBuilder().setRequestId(requestId).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.FAILED).setUserData(userDataResponseF.getUserData()).setReceipts(new ArrayList()).setHasMore(false).build());
        } else {
            userDataResponseF.getUserData().getUserId();
            a(requestId.toString(), userDataResponseF.getUserData().getUserId(), jSONObject.optBoolean(b.au, true));
        }
    }

    private void a(String str, String str2, boolean z) {
        try {
            Context contextB = com.amazon.device.iap.internal.d.f().b();
            String strA = com.amazon.device.iap.internal.util.a.a(str2);
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", str.toString());
            if (z) {
                strA = null;
            }
            jSONObject.put(b.as, strA);
            jSONObject.put(com.amazon.a.a.o.b.I, PurchasingService.SDK_VERSION);
            jSONObject.put("packageName", contextB.getPackageName());
            bundle.putString("purchaseUpdatesInput", jSONObject.toString());
            Intent intentA = a("com.amazon.testclient.iap.purchaseUpdates");
            intentA.addFlags(268435456);
            intentA.putExtras(bundle);
            contextB.startService(intentA);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.b.b(a, "Error in sendPurchaseUpdatesRequest.");
        }
    }

    private UserDataResponse f(Intent intent) {
        RequestId requestIdFromString;
        UserDataResponse.RequestStatus requestStatusValueOf = UserDataResponse.RequestStatus.FAILED;
        UserData userDataBuild = null;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("userOutput"));
            requestIdFromString = RequestId.fromString(jSONObject.optString("requestId"));
            try {
                requestStatusValueOf = UserDataResponse.RequestStatus.valueOf(jSONObject.optString("status"));
                if (requestStatusValueOf == UserDataResponse.RequestStatus.SUCCESSFUL) {
                    String strOptString = jSONObject.optString("userId");
                    userDataBuild = new UserDataBuilder().setUserId(strOptString).setMarketplace(jSONObject.optString(com.amazon.a.a.o.b.m)).setLWAConsentStatus(jSONObject.optString("UserDataResponse.LWAConsentStatus")).build();
                }
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            requestIdFromString = null;
        }
        return new UserDataResponseBuilder().setRequestId(requestIdFromString).setRequestStatus(requestStatusValueOf).setUserData(userDataBuild).build();
    }

    private void g(Intent intent) {
        a(h(intent));
    }

    private PurchaseResponse h(Intent intent) {
        RequestId requestIdFromString;
        UserData userDataBuild;
        PurchaseResponse.RequestStatus requestStatusSafeValueOf = PurchaseResponse.RequestStatus.FAILED;
        Receipt receiptA = null;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("purchaseOutput"));
            requestIdFromString = RequestId.fromString(jSONObject.optString("requestId"));
            try {
                userDataBuild = new UserDataBuilder().setUserId(jSONObject.optString("userId")).setMarketplace(jSONObject.optString(com.amazon.a.a.o.b.m)).build();
                try {
                    requestStatusSafeValueOf = PurchaseResponse.RequestStatus.safeValueOf(jSONObject.optString("purchaseStatus"));
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.amazon.a.a.o.b.D);
                    if (jSONObjectOptJSONObject != null) {
                        receiptA = a(jSONObjectOptJSONObject);
                    }
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                userDataBuild = null;
            }
        } catch (Exception unused3) {
            requestIdFromString = null;
            userDataBuild = null;
        }
        return new PurchaseResponseBuilder().setRequestId(requestIdFromString).setRequestStatus(requestStatusSafeValueOf).setUserData(userDataBuild).setReceipt(receiptA).build();
    }

    private Receipt a(JSONObject jSONObject) throws ParseException {
        String strOptString = jSONObject.optString(com.amazon.a.a.o.b.E);
        String strOptString2 = jSONObject.optString("sku");
        ProductType productTypeValueOf = ProductType.valueOf(jSONObject.optString(com.amazon.a.a.o.b.k));
        String strOptString3 = jSONObject.optString(com.amazon.a.a.o.b.Q);
        DateFormat dateFormat = b.ar;
        Date date = dateFormat.parse(strOptString3);
        String strOptString4 = jSONObject.optString(com.amazon.a.a.o.b.e);
        Date date2 = (strOptString4 == null || strOptString4.length() == 0) ? null : dateFormat.parse(strOptString4);
        String strOptString5 = jSONObject.optString(com.amazon.a.a.o.b.R);
        return new ReceiptBuilder().setReceiptId(strOptString).setSku(strOptString2).setProductType(productTypeValueOf).setPurchaseDate(date).setCancelDate(date2).setDeferredSku(jSONObject.optString(com.amazon.a.a.o.b.M, null)).setDeferredDate((strOptString5 == null || strOptString5.length() == 0) ? null : dateFormat.parse(strOptString5)).setTermSku(jSONObject.optString(com.amazon.a.a.o.b.L, null)).build();
    }
}
