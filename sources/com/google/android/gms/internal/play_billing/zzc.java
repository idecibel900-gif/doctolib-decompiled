package com.google.android.gms.internal.play_billing;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.amazon.a.a.o.b;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.InAppMessageResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.QueryProductDetailsParams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzc {
    public static final int zza = Runtime.getRuntime().availableProcessors();

    public static int zza(Intent intent, String str) {
        if (intent != null) {
            return zzq(intent.getExtras(), "ProxyBillingActivity");
        }
        zzo("ProxyBillingActivity", "Got null intent!");
        return 0;
    }

    public static int zzb(Bundle bundle, String str) {
        if (bundle == null) {
            zzo(str, "Unexpected null bundle received!");
            return 6;
        }
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            zzn(str, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        zzo(str, "Unexpected type for bundle response code: ".concat(obj.getClass().getName()));
        return 6;
    }

    public static Bundle zzc(Bundle bundle, String str, String str2, long j) {
        bundle.putString("playBillingLibraryVersion", str);
        if (str2 != null) {
            bundle.putString("playBillingLibraryWrapperVersion", str2);
        }
        bundle.putLong("billingClientSessionId", j);
        return bundle;
    }

    public static Bundle zzd(BillingResult billingResult, zzjd zzjdVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("RESPONSE_CODE", billingResult.getResponseCode());
        bundle.putString("DEBUG_MESSAGE", billingResult.getDebugMessage());
        bundle.putInt("LOG_REASON", zzjdVar.zza());
        return bundle;
    }

    public static Bundle zze(BillingResult billingResult, zzjd zzjdVar, String str) {
        Bundle bundleZzd = zzd(billingResult, zzjdVar);
        if (str != null) {
            bundleZzd.putString("ADDITIONAL_LOG_DETAILS", str);
        }
        return bundleZzd;
    }

    public static Bundle zzf(BillingFlowParams billingFlowParams, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str, String str2, long j, String str3, long j2) {
        Bundle bundle = new Bundle();
        zzc(bundle, str, str2, j);
        bundle.putLong("billingClientTransactionId", j2);
        if (billingFlowParams.zzb() != 0) {
            bundle.putInt(b.l, billingFlowParams.zzb());
        }
        if (!TextUtils.isEmpty(billingFlowParams.zze())) {
            bundle.putString("accountId", billingFlowParams.zze());
        }
        if (!TextUtils.isEmpty(billingFlowParams.zzf())) {
            bundle.putString("obfuscatedProfileId", billingFlowParams.zzf());
        }
        if (billingFlowParams.zzt()) {
            bundle.putBoolean("isOfferPersonalizedByDeveloper", true);
        }
        if (!TextUtils.isEmpty(null)) {
            bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(null)));
        }
        if (!TextUtils.isEmpty(billingFlowParams.zzh())) {
            bundle.putString("oldSkuPurchaseToken", billingFlowParams.zzh());
        }
        billingFlowParams.zzg();
        if (!TextUtils.isEmpty(null)) {
            billingFlowParams.zzg();
            bundle.putString("oldSkuPurchaseId", null);
        }
        if (!TextUtils.isEmpty(billingFlowParams.zzi())) {
            bundle.putString("originalExternalTransactionId", billingFlowParams.zzi());
        }
        if (!TextUtils.isEmpty(null)) {
            bundle.putString("paymentsPurchaseParams", null);
        }
        if (z && z3) {
            bundle.putBoolean(b.ac, true);
        }
        if (z2 && z4) {
            bundle.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        if (z5) {
            bundle.putBoolean("enableAlternativeBilling", true);
        } else {
            billingFlowParams.getDeveloperBillingOptionParams();
        }
        billingFlowParams.zzc();
        billingFlowParams.zza();
        billingFlowParams.getDeveloperBillingOptionParams();
        ArrayList arrayList = new ArrayList();
        Iterator it = billingFlowParams.zzk().iterator();
        while (it.hasNext()) {
            ((BillingFlowParams.ProductDetailsParams) it.next()).getSubscriptionProductReplacementParams();
        }
        if (!arrayList.isEmpty()) {
            zzds zzdsVarZza = zzdt.zza();
            zzdsVarZza.zza(arrayList);
            bundle.putByteArray("subscriptionProductReplacementParamsList", ((zzdt) zzdsVarZza.zzi()).zzQ());
        }
        return bundle;
    }

    public static Bundle zzg(String str, String str2, ArrayList arrayList, String str3, String str4, zza zzaVar, long j) {
        Bundle bundle = new Bundle();
        zzc(bundle, str, str2, j);
        bundle.putBoolean(b.ac, true);
        bundle.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
        bundle.putStringArrayList("PRODUCT_TYPES_TO_RETURN_MULTIPLE_OFFERS", new ArrayList<>(zzbw.zzm("subs", "inapp")));
        bundle.putStringArrayList("PRODUCT_TYPES_TO_RETURN_PREORDER_OFFERS", new ArrayList<>(zzbw.zzl("inapp")));
        bundle.putStringArrayList("PRODUCT_TYPES_TO_RETURN_RENT_OFFERS", new ArrayList<>(zzbw.zzl("inapp")));
        bundle.putBoolean("SHOULD_RETURN_UNFETCHED_PRODUCTS", true);
        if (zzaVar.zza) {
            bundle.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        ArrayList<String> arrayList4 = new ArrayList<>();
        int size = arrayList.size();
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            QueryProductDetailsParams.Product product = (QueryProductDetailsParams.Product) arrayList.get(i);
            arrayList2.add(null);
            z |= !TextUtils.isEmpty(null);
            arrayList4.add(null);
            z2 |= !TextUtils.isEmpty(null);
            if (product.zzb().equals("first_party")) {
                zzbj.zzc(null, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                arrayList3.add(null);
            }
        }
        if (z) {
            bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList2);
        }
        if (!arrayList3.isEmpty()) {
            bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList3);
        }
        if (!TextUtils.isEmpty(null)) {
            bundle.putString("accountName", null);
        }
        if (z2) {
            bundle.putStringArrayList("SKU_DYNAMIC_PRODUCT_TOKEN_LIST", arrayList4);
        }
        return bundle;
    }

    public static BillingResult zzi(Intent intent, String str) {
        if (intent != null) {
            BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
            builderNewBuilder.setResponseCode(zzb(intent.getExtras(), str));
            builderNewBuilder.setDebugMessage(zzk(intent.getExtras(), str));
            return builderNewBuilder.build();
        }
        zzo("BillingHelper", "Got null intent!");
        BillingResult.Builder builderNewBuilder2 = BillingResult.newBuilder();
        builderNewBuilder2.setResponseCode(6);
        builderNewBuilder2.setDebugMessage("An internal error occurred.");
        return builderNewBuilder2.build();
    }

    public static InAppMessageResult zzj(Bundle bundle, String str) {
        return bundle == null ? new InAppMessageResult(0, null) : new InAppMessageResult(zzq(bundle, "BillingClient"), bundle.getString("IN_APP_MESSAGE_PURCHASE_TOKEN"));
    }

    public static String zzk(Bundle bundle, String str) {
        if (bundle == null) {
            zzo(str, "Unexpected null bundle received!");
            return "";
        }
        Object obj = bundle.get("DEBUG_MESSAGE");
        if (obj == null) {
            zzn(str, "getDebugMessageFromBundle() got null response code, assuming OK");
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        zzo(str, "Unexpected type for debug message: ".concat(obj.getClass().getName()));
        return "";
    }

    public static String zzl(int i) {
        return zzb.zza(i).toString();
    }

    public static List zzm(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        ArrayList arrayList = new ArrayList();
        if (stringArrayList == null || stringArrayList2 == null) {
            Purchase purchaseZzr = zzr(bundle.getString("INAPP_PURCHASE_DATA"), bundle.getString("INAPP_DATA_SIGNATURE"));
            if (purchaseZzr == null) {
                zzn("BillingHelper", "Couldn't find single purchase data as well.");
                return null;
            }
            arrayList.add(purchaseZzr);
            return arrayList;
        }
        zzn("BillingHelper", "Found purchase list of " + stringArrayList.size() + " items");
        for (int i = 0; i < stringArrayList.size() && i < stringArrayList2.size(); i++) {
            Purchase purchaseZzr2 = zzr(stringArrayList.get(i), stringArrayList2.get(i));
            if (purchaseZzr2 != null) {
                arrayList.add(purchaseZzr2);
            }
        }
        return arrayList;
    }

    public static void zzn(String str, String str2) {
        if (!Log.isLoggable(str, 2) || str2.isEmpty()) {
            return;
        }
        int i = 40000;
        while (!str2.isEmpty() && i > 0) {
            int iMin = Math.min(str2.length(), Math.min(4000, i));
            str2.substring(0, iMin);
            str2 = str2.substring(iMin);
            i -= iMin;
        }
    }

    public static void zzo(String str, String str2) {
    }

    public static void zzp(String str, String str2, Throwable th) {
    }

    private static int zzq(Bundle bundle, String str) {
        if (bundle != null) {
            return bundle.getInt("IN_APP_MESSAGE_RESPONSE_CODE", 0);
        }
        zzo(str, "Unexpected null bundle received!");
        return 0;
    }

    private static Purchase zzr(String str, String str2) {
        if (str == null || str2 == null) {
            zzn("BillingHelper", "Received a null purchase data.");
            return null;
        }
        try {
            return new Purchase(str, str2);
        } catch (JSONException e) {
            zzo("BillingHelper", "Got JSONException while parsing purchase data: ".concat(e.toString()));
            return null;
        }
    }
}
