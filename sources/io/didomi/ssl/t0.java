package io.didomi.ssl;

import com.facebook.react.bridge.BaseJavaModule;
import io.didomi.ssl.consent.model.ConsentToken;
import io.didomi.ssl.consent.model.DidomiConsentToken;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¨\u0006\n"}, d2 = {"Lio/didomi/sdk/consent/model/ConsentToken;", "Lorg/json/JSONObject;", "a", "", "userId", "Lio/didomi/sdk/consent/model/DidomiConsentToken;", "", "Lio/didomi/sdk/z7;", "", "", "android_release"}, k = 2, mv = {1, 8, 0})
public final class t0 {
    public static final JSONObject a(ConsentToken consentToken) throws JSONException {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        JSONObject jSONObject = new JSONObject();
        SimpleDateFormat simpleDateFormatC = t1.a.c();
        jSONObject.put("created", simpleDateFormatC.format(consentToken.getCreated()));
        jSONObject.put("updated", simpleDateFormatC.format(consentToken.getUpdated()));
        Date lastSyncDate = consentToken.getLastSyncDate();
        if (lastSyncDate != null) {
            jSONObject.put(BaseJavaModule.METHOD_TYPE_SYNC, simpleDateFormatC.format(lastSyncDate));
        }
        String lastSyncedUserId = consentToken.getLastSyncedUserId();
        if (lastSyncedUserId != null) {
            jSONObject.put("sync_user_id", lastSyncedUserId);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("enabled", new JSONArray((Collection) consentToken.getEnabledPurposes().keySet()));
        jSONObject2.put("disabled", new JSONArray((Collection) consentToken.getDisabledPurposes().keySet()));
        jSONObject.put(Didomi.VIEW_PURPOSES, jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("enabled", new JSONArray((Collection) consentToken.getEnabledVendors().keySet()));
        jSONObject3.put("disabled", new JSONArray((Collection) consentToken.getDisabledVendors().keySet()));
        jSONObject.put(Didomi.VIEW_VENDORS, jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("enabled", new JSONArray((Collection) consentToken.getEnabledLegitimatePurposes().keySet()));
        jSONObject4.put("disabled", new JSONArray((Collection) consentToken.getDisabledLegitimatePurposes().keySet()));
        jSONObject.put("purposes_li", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("enabled", new JSONArray((Collection) consentToken.getEnabledLegitimateVendors().keySet()));
        jSONObject5.put("disabled", new JSONArray((Collection) consentToken.getDisabledLegitimateVendors().keySet()));
        jSONObject.put("vendors_li", jSONObject5);
        jSONObject.put("tcf_version", consentToken.getTcfVersion());
        return jSONObject;
    }

    public static final DidomiConsentToken a(ConsentToken consentToken, String userId) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        Intrinsics.checkNotNullParameter(userId, "userId");
        t1 t1Var = t1.a;
        String str = t1Var.c().format(consentToken.getCreated());
        String str2 = t1Var.c().format(consentToken.getUpdated());
        DidomiConsentToken.Ids ids = new DidomiConsentToken.Ids(a(consentToken.getEnabledPurposes()), a(consentToken.getDisabledPurposes()));
        DidomiConsentToken.Ids ids2 = new DidomiConsentToken.Ids(a(consentToken.getEnabledVendors()), a(consentToken.getDisabledVendors()));
        DidomiConsentToken.Ids ids3 = new DidomiConsentToken.Ids(a(consentToken.getEnabledLegitimatePurposes()), a(consentToken.getDisabledLegitimatePurposes()));
        DidomiConsentToken.Ids ids4 = new DidomiConsentToken.Ids(a(consentToken.getEnabledLegitimateVendors()), a(consentToken.getDisabledLegitimateVendors()));
        Intrinsics.checkNotNullExpressionValue(str, "format(created)");
        Intrinsics.checkNotNullExpressionValue(str2, "format(updated)");
        return new DidomiConsentToken(userId, str, str2, null, ids2, ids, ids4, ids3, 8, null);
    }

    private static final Set<Integer> a(Map<String, ? extends z7> map) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, ? extends z7>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            f8 namespaces = it.next().getValue().getNamespaces();
            Integer num = namespaces != null ? namespaces.getNum() : null;
            if (num != null) {
                arrayList.add(num);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }
}
