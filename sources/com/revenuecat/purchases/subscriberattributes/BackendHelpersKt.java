package com.revenuecat.purchases.subscriberattributes;

import com.revenuecat.purchases.common.BackendKt;
import com.revenuecat.purchases.common.SubscriberAttributeError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0004\u0018\u00010\u0003H\u0000\u001a2\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00050\u0005*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0005H\u0000¨\u0006\t"}, d2 = {"getAttributeErrors", "", "Lcom/revenuecat/purchases/common/SubscriberAttributeError;", "Lorg/json/JSONObject;", "toBackendMap", "", "", "", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BackendHelpersKt {
    public static final List<SubscriberAttributeError> getAttributeErrors(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return CollectionsKt.emptyList();
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(BackendKt.ATTRIBUTES_ERROR_RESPONSE_KEY);
        if (jSONObjectOptJSONObject != null) {
            jSONObject = jSONObjectOptJSONObject;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(BackendKt.ATTRIBUTE_ERRORS_KEY);
        if (jSONArrayOptJSONArray != null) {
            IntRange intRangeUntil = RangesKt.until(0, jSONArrayOptJSONArray.length());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator it = intRangeUntil.iterator();
            while (it.hasNext()) {
                arrayList.add(jSONArrayOptJSONArray.getJSONObject(((IntIterator) it).nextInt()));
            }
            ArrayList<JSONObject> arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                JSONObject jSONObject2 = (JSONObject) obj;
                if (jSONObject2.has("key_name") && jSONObject2.has("message")) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (JSONObject jSONObject3 : arrayList2) {
                String string = jSONObject3.getString("key_name");
                Intrinsics.checkNotNullExpressionValue(string, "it.getString(\"key_name\")");
                String string2 = jSONObject3.getString("message");
                Intrinsics.checkNotNullExpressionValue(string2, "it.getString(\"message\")");
                arrayList3.add(new SubscriberAttributeError(string, string2));
            }
            List<SubscriberAttributeError> list = CollectionsKt.toList(arrayList3);
            if (list != null) {
                return list;
            }
        }
        return CollectionsKt.emptyList();
    }

    public static final Map<String, Map<String, Object>> toBackendMap(Map<String, SubscriberAttribute> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, SubscriberAttribute> entry : map.entrySet()) {
            arrayList.add(TuplesKt.to(entry.getKey(), entry.getValue().toBackendMap()));
        }
        return MapsKt.toMap(arrayList);
    }
}
