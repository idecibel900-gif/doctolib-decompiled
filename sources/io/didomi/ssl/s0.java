package io.didomi.ssl;

import com.facebook.react.bridge.BaseJavaModule;
import io.didomi.ssl.consent.model.ConsentToken;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lio/didomi/sdk/s0;", "", "", "jsonString", "Lio/didomi/sdk/zh;", "vendorRepository", "Lio/didomi/sdk/consent/model/ConsentToken;", "a", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class s0 {
    public static final s0 a = new s0();

    private s0() {
    }

    /* JADX WARN: Code duplicated, block: B:80:0x01f4  */
    public final ConsentToken a(String jsonString, zh vendorRepository) throws Exception {
        Date date;
        Date date2;
        LinkedHashSet linkedHashSet;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(vendorRepository, "vendorRepository");
        if (jsonString == null || StringsKt.isBlank(jsonString)) {
            throw new Exception("Empty JSON string provided");
        }
        JSONObject jSONObject = new JSONObject(jsonString);
        SimpleDateFormat simpleDateFormatC = t1.a.c();
        Date date3 = simpleDateFormatC.parse(jSONObject.getString("created"));
        Date date4 = simpleDateFormatC.parse(jSONObject.getString("updated"));
        Date date5 = jSONObject.has(BaseJavaModule.METHOD_TYPE_SYNC) ? simpleDateFormatC.parse(jSONObject.optString(BaseJavaModule.METHOD_TYPE_SYNC)) : null;
        JSONObject jSONObject2 = jSONObject.has("sync_user_id") ? jSONObject : null;
        String string = jSONObject2 != null ? jSONObject2.getString("sync_user_id") : null;
        JSONObject jSONObject3 = jSONObject.getJSONObject(Didomi.VIEW_PURPOSES);
        JSONArray jSONArray = jSONObject3.getJSONArray("enabled");
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            String string2 = jSONArray.getString(i3);
            Intrinsics.checkNotNullExpressionValue(string2, "enabledPurposesIds.getString(i)");
            Purpose purposeC = vendorRepository.c(string2);
            if (purposeC != null) {
                linkedHashSet2.add(purposeC);
            }
        }
        JSONArray jSONArray2 = jSONObject3.getJSONArray("disabled");
        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
        int length2 = jSONArray2.length();
        for (int i4 = 0; i4 < length2; i4++) {
            String string3 = jSONArray2.getString(i4);
            Intrinsics.checkNotNullExpressionValue(string3, "disabledPurposesIds.getString(i)");
            Purpose purposeC2 = vendorRepository.c(string3);
            if (purposeC2 != null) {
                linkedHashSet3.add(purposeC2);
            }
        }
        LinkedHashSet linkedHashSet4 = new LinkedHashSet();
        LinkedHashSet linkedHashSet5 = new LinkedHashSet();
        if (jSONObject.has("purposes_li")) {
            JSONObject jSONObject4 = jSONObject.getJSONObject("purposes_li");
            JSONArray jSONArray3 = jSONObject4.getJSONArray("enabled");
            int length3 = jSONArray3.length();
            int i5 = 0;
            while (i5 < length3) {
                Date date6 = date3;
                String string4 = jSONArray3.getString(i5);
                Date date7 = date4;
                Intrinsics.checkNotNullExpressionValue(string4, "enabledLegitimatePurposesIds.getString(i)");
                Purpose purposeC3 = vendorRepository.c(string4);
                if (purposeC3 != null) {
                    linkedHashSet4.add(purposeC3);
                }
                i5++;
                date3 = date6;
                date4 = date7;
            }
            date = date3;
            date2 = date4;
            JSONArray jSONArray4 = jSONObject4.getJSONArray("disabled");
            int length4 = jSONArray4.length();
            for (int i6 = 0; i6 < length4; i6++) {
                String string5 = jSONArray4.getString(i6);
                Intrinsics.checkNotNullExpressionValue(string5, "disabledLegitimatePurposesIds.getString(i)");
                Purpose purposeC4 = vendorRepository.c(string5);
                if (purposeC4 != null) {
                    linkedHashSet5.add(purposeC4);
                }
            }
        } else {
            date = date3;
            date2 = date4;
            Log.i$default("Didomi - purposes_li array not found in JSON!", null, 2, null);
        }
        JSONObject jSONObject5 = jSONObject.getJSONObject(Didomi.VIEW_VENDORS);
        JSONArray jSONArray5 = jSONObject5.getJSONArray("enabled");
        LinkedHashSet linkedHashSet6 = new LinkedHashSet();
        int length5 = jSONArray5.length();
        int i7 = 0;
        while (i7 < length5) {
            String string6 = jSONArray5.getString(i7);
            LinkedHashSet linkedHashSet7 = linkedHashSet4;
            Intrinsics.checkNotNullExpressionValue(string6, "enabledVendorsIds.getString(i)");
            Vendor vendorG = vendorRepository.g(string6);
            if (vendorG != null) {
                linkedHashSet6.add(vendorG);
            }
            i7++;
            linkedHashSet4 = linkedHashSet7;
        }
        LinkedHashSet linkedHashSet8 = linkedHashSet4;
        JSONArray jSONArray6 = jSONObject5.getJSONArray("disabled");
        LinkedHashSet linkedHashSet9 = new LinkedHashSet();
        int length6 = jSONArray6.length();
        for (int i8 = 0; i8 < length6; i8++) {
            String string7 = jSONArray6.getString(i8);
            Intrinsics.checkNotNullExpressionValue(string7, "disabledVendorsIds.getString(i)");
            Vendor vendorG2 = vendorRepository.g(string7);
            if (vendorG2 != null) {
                linkedHashSet9.add(vendorG2);
            }
        }
        LinkedHashSet linkedHashSet10 = new LinkedHashSet();
        LinkedHashSet linkedHashSet11 = new LinkedHashSet();
        if (jSONObject.has("vendors_li")) {
            JSONObject jSONObject6 = jSONObject.getJSONObject("vendors_li");
            JSONArray jSONArray7 = jSONObject6.getJSONArray("enabled");
            int length7 = jSONArray7.length();
            int i9 = 0;
            while (i9 < length7) {
                LinkedHashSet linkedHashSet12 = linkedHashSet9;
                String string8 = jSONArray7.getString(i9);
                JSONArray jSONArray8 = jSONArray7;
                Intrinsics.checkNotNullExpressionValue(string8, "enabledLegIntVendorsIds.getString(i)");
                Vendor vendorG3 = vendorRepository.g(string8);
                if (vendorG3 != null) {
                    linkedHashSet10.add(vendorG3);
                }
                i9++;
                jSONArray7 = jSONArray8;
                linkedHashSet9 = linkedHashSet12;
            }
            linkedHashSet = linkedHashSet9;
            JSONArray jSONArray9 = jSONObject6.getJSONArray("disabled");
            int length8 = jSONArray9.length();
            for (int i10 = 0; i10 < length8; i10++) {
                String string9 = jSONArray9.getString(i10);
                Intrinsics.checkNotNullExpressionValue(string9, "disabledLegIntVendorsIds.getString(i)");
                Vendor vendorG4 = vendorRepository.g(string9);
                if (vendorG4 != null) {
                    linkedHashSet11.add(vendorG4);
                }
            }
            i = 2;
        } else {
            linkedHashSet = linkedHashSet9;
            i = 2;
            Log.i$default("Didomi - vendors_li array not found in JSON!", null, 2, null);
        }
        if (jSONObject.has("tcf_version")) {
            try {
                int i11 = jSONObject.getInt("tcf_version");
                if (i11 == 1 || i11 == i) {
                    i2 = i11;
                } else {
                    i2 = 1;
                }
            } catch (Exception unused) {
                Log.e$default("Invalid tcf_version in token. Defaulting to 1.", null, i, null);
            }
        } else {
            i2 = 1;
        }
        ConsentToken consentToken = new ConsentToken(date == null ? t1.a.a() : date, date2 == null ? t1.a.a() : date2, date5, string, null, null, null, null, null, null, null, null, i2, 4080, null);
        u0.a(consentToken, linkedHashSet2, linkedHashSet3, linkedHashSet8, linkedHashSet5, linkedHashSet6, linkedHashSet, linkedHashSet10, linkedHashSet11);
        return consentToken;
    }
}
