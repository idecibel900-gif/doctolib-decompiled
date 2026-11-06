package com.revenuecat.purchases.subscriberattributes;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\u0000\u001a\u001c\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0006*\u00020\u0004H\u0000\u001a0\u0010\u0007\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u00060\u0001j\u0002`\t*\u00020\u0004H\u0000¨\u0006\n"}, d2 = {"buildLegacySubscriberAttributes", "", "", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "Lorg/json/JSONObject;", "buildSubscriberAttributesMap", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributeMap;", "buildSubscriberAttributesMapPerUser", "Lcom/revenuecat/purchases/subscriberattributes/caching/AppUserID;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesPerAppUserIDMap;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SubscriberAttributesFactoriesKt {
    public static final Map<String, SubscriberAttribute> buildLegacySubscriberAttributes(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        JSONObject attributesJSONObject = jSONObject.getJSONObject("attributes");
        Intrinsics.checkNotNullExpressionValue(attributesJSONObject, "attributesJSONObject");
        return buildSubscriberAttributesMap(attributesJSONObject);
    }

    public static final Map<String, Map<String, SubscriberAttribute>> buildSubscriberAttributesMapPerUser(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        final JSONObject jSONObject2 = jSONObject.getJSONObject("attributes");
        Iterator<String> itKeys = jSONObject2.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "attributesJSONObject.keys()");
        return MapsKt.toMap(SequencesKt.map(SequencesKt.asSequence(itKeys), new Function1() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesFactoriesKt.buildSubscriberAttributesMapPerUser.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Pair<String, Map<String, SubscriberAttribute>> invoke(String str) throws JSONException {
                Object obj = jSONObject2.get(str);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                return TuplesKt.to(str, SubscriberAttributesFactoriesKt.buildSubscriberAttributesMap((JSONObject) obj));
            }
        }));
    }

    public static final Map<String, SubscriberAttribute> buildSubscriberAttributesMap(final JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Iterator<String> itKeys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "this.keys()");
        return MapsKt.toMap(SequencesKt.map(SequencesKt.asSequence(itKeys), new Function1() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesFactoriesKt.buildSubscriberAttributesMap.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Pair<String, SubscriberAttribute> invoke(String str) throws JSONException {
                Object obj = jSONObject.get(str);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                return TuplesKt.to(str, new SubscriberAttribute((JSONObject) obj));
            }
        }));
    }
}
