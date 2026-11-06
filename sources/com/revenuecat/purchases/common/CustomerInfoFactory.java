package com.revenuecat.purchases.common;

import android.net.Uri;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.CustomerInfoOriginalSource;
import com.revenuecat.purchases.EntitlementInfos;
import com.revenuecat.purchases.SubscriptionInfo;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.revenuecat.purchases.common.responses.SubscriptionInfoResponse;
import com.revenuecat.purchases.utils.Iso8601Utils;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import com.revenuecat.purchases.utils.SerializationException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\nJ4\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0018j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\n`\u0019*\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0013H\u0002J\u001a\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0012*\u00020\bH\u0002J\u001a\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0012*\u00020\bH\u0002¨\u0006\u001d"}, d2 = {"Lcom/revenuecat/purchases/common/CustomerInfoFactory;", "", "()V", "buildCustomerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "httpResult", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "body", "Lorg/json/JSONObject;", "overrideRequestDate", "Ljava/util/Date;", "verificationResult", "Lcom/revenuecat/purchases/VerificationResult;", "originalSource", "Lcom/revenuecat/purchases/CustomerInfoOriginalSource;", "loadedFromCache", "", "parseSubscriptionInfos", "", "", "Lcom/revenuecat/purchases/SubscriptionInfo;", "subscriberJSONObject", "requestDate", "parseDates", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "jsonKey", "parseExpirations", "parsePurchaseDates", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomerInfoFactory {
    public static final CustomerInfoFactory INSTANCE = new CustomerInfoFactory();

    private CustomerInfoFactory() {
    }

    public final CustomerInfo buildCustomerInfo(HTTPResult httpResult) throws JSONException {
        CustomerInfoOriginalSource customerInfoOriginalSource;
        Intrinsics.checkNotNullParameter(httpResult, "httpResult");
        if (httpResult.isLoadShedderResponse()) {
            customerInfoOriginalSource = CustomerInfoOriginalSource.LOAD_SHEDDER;
        } else {
            customerInfoOriginalSource = CustomerInfoOriginalSource.MAIN;
        }
        return buildCustomerInfo(httpResult.getBody(), httpResult.getRequestDate(), httpResult.getVerificationResult(), customerInfoOriginalSource, false);
    }

    public static /* synthetic */ CustomerInfo buildCustomerInfo$default(CustomerInfoFactory customerInfoFactory, JSONObject jSONObject, Date date, VerificationResult verificationResult, CustomerInfoOriginalSource customerInfoOriginalSource, boolean z, int i, Object obj) throws JSONException {
        if ((i & 8) != 0) {
            customerInfoOriginalSource = CustomerInfoOriginalSource.MAIN;
        }
        CustomerInfoOriginalSource customerInfoOriginalSource2 = customerInfoOriginalSource;
        if ((i & 16) != 0) {
            z = false;
        }
        return customerInfoFactory.buildCustomerInfo(jSONObject, date, verificationResult, customerInfoOriginalSource2, z);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0093  */
    public final CustomerInfo buildCustomerInfo(JSONObject body, Date overrideRequestDate, VerificationResult verificationResult, CustomerInfoOriginalSource originalSource, boolean loadedFromCache) throws JSONException {
        EntitlementInfos entitlementInfos;
        Date date;
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        Intrinsics.checkNotNullParameter(originalSource, "originalSource");
        JSONObject subscriber = body.getJSONObject(CustomerInfoResponseJsonKeys.SUBSCRIBER);
        JSONObject jSONObject = subscriber.getJSONObject(CustomerInfoResponseJsonKeys.NON_SUBSCRIPTIONS);
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> itKeys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "nonSubscriptions.keys()");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONArray jSONArray = jSONObject.getJSONArray(next);
            int length = jSONArray.length();
            if (length > 0) {
                jSONObject2.put(next, jSONArray.getJSONObject(length - 1));
            }
        }
        JSONObject subscriptions = subscriber.getJSONObject(CustomerInfoResponseJsonKeys.SUBSCRIPTIONS);
        Intrinsics.checkNotNullExpressionValue(subscriptions, "subscriptions");
        Map<String, Date> expirations = parseExpirations(subscriptions);
        Map mapPlus = MapsKt.plus(parsePurchaseDates(subscriptions), parsePurchaseDates(jSONObject2));
        JSONObject jSONObjectOptJSONObject = subscriber.optJSONObject(CustomerInfoResponseJsonKeys.ENTITLEMENTS);
        Date requestDate = overrideRequestDate == null ? Iso8601Utils.parse(body.getString(CustomerInfoResponseJsonKeys.REQUEST_DATE)) : overrideRequestDate;
        Date firstSeen = Iso8601Utils.parse(subscriber.getString(CustomerInfoResponseJsonKeys.FIRST_SEEN));
        if (jSONObjectOptJSONObject != null) {
            Intrinsics.checkNotNullExpressionValue(requestDate, "requestDate");
            entitlementInfos = EntitlementInfoFactoriesKt.buildEntitlementInfos(jSONObjectOptJSONObject, subscriptions, jSONObject2, requestDate, verificationResult);
            if (entitlementInfos == null) {
                Map map = Collections.EMPTY_MAP;
                Intrinsics.checkNotNullExpressionValue(map, "emptyMap()");
                entitlementInfos = new EntitlementInfos(map, verificationResult);
            }
        } else {
            Map map2 = Collections.EMPTY_MAP;
            Intrinsics.checkNotNullExpressionValue(map2, "emptyMap()");
            entitlementInfos = new EntitlementInfos(map2, verificationResult);
        }
        Intrinsics.checkNotNullExpressionValue(subscriber, "subscriber");
        String strOptNullableString = JSONObjectExtensionsKt.optNullableString(subscriber, "management_url");
        String strOptNullableString2 = JSONObjectExtensionsKt.optNullableString(subscriber, "original_purchase_date");
        if (strOptNullableString2 == null || (date = Iso8601Utils.parse(strOptNullableString2)) == null) {
            date = null;
        }
        int iOptInt = body.optInt("schema_version", 3);
        String strOptString = subscriber.optString(CustomerInfoResponseJsonKeys.ORIGINAL_APP_USER_ID);
        Uri uri = strOptNullableString != null ? Uri.parse(strOptNullableString) : null;
        Intrinsics.checkNotNullExpressionValue(requestDate, "requestDate");
        Intrinsics.checkNotNullExpressionValue(firstSeen, "firstSeen");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(CustomerInfoRe…eys.ORIGINAL_APP_USER_ID)");
        return new CustomerInfo(entitlementInfos, expirations, mapPlus, requestDate, iOptInt, firstSeen, strOptString, uri, date, body, originalSource, loadedFromCache);
    }

    public final Map<String, SubscriptionInfo> parseSubscriptionInfos(JSONObject subscriberJSONObject, Date requestDate) throws JSONException {
        Intrinsics.checkNotNullParameter(subscriberJSONObject, "subscriberJSONObject");
        Intrinsics.checkNotNullParameter(requestDate, "requestDate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = subscriberJSONObject.getJSONObject(CustomerInfoResponseJsonKeys.SUBSCRIPTIONS);
        try {
            Iterator<String> itKeys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "subscriptions.keys()");
            while (itKeys.hasNext()) {
                String productId = itKeys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(productId);
                Json defaultJson = JsonProvider.INSTANCE.getDefaultJson();
                String string = jSONObject2.toString();
                Intrinsics.checkNotNullExpressionValue(string, "subscriptionJSONObject.toString()");
                defaultJson.getSerializersModule();
                SubscriptionInfoResponse subscriptionInfoResponse = (SubscriptionInfoResponse) defaultJson.decodeFromString(SubscriptionInfoResponse.INSTANCE.serializer(), string);
                Intrinsics.checkNotNullExpressionValue(productId, "productId");
                Date date = requestDate;
                linkedHashMap.put(productId, new SubscriptionInfo(productId, date, subscriptionInfoResponse, null, 8, null));
                requestDate = date;
            }
        } catch (SerializationException e) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error deserializing subscription information", e);
        } catch (IllegalArgumentException e2) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error deserializing subscription information. The input is not a SubscriptionInfo", e2);
        }
        return linkedHashMap;
    }

    private final Map<String, Date> parseExpirations(JSONObject jSONObject) {
        return parseDates(jSONObject, "expires_date");
    }

    private final Map<String, Date> parsePurchaseDates(JSONObject jSONObject) {
        return parseDates(jSONObject, "purchase_date");
    }

    private final HashMap<String, Date> parseDates(JSONObject jSONObject, String str) throws JSONException {
        HashMap<String, Date> map = new HashMap<>();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            String it = jSONObject.getJSONObject(key).optString("product_plan_identifier");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.length() <= 0) {
                it = null;
            }
            JSONObject expirationObject = jSONObject.getJSONObject(key);
            if (it != null) {
                String str2 = key + ':' + it;
                if (str2 != null) {
                    key = str2;
                }
            }
            Intrinsics.checkNotNullExpressionValue(key, "key");
            Intrinsics.checkNotNullExpressionValue(expirationObject, "expirationObject");
            map.put(key, JSONObjectExtensionsKt.optDate(expirationObject, str));
        }
        return map;
    }
}
