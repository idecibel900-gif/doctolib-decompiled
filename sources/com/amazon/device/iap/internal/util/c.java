package com.amazon.device.iap.internal.util;

import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.a.e;
import com.amazon.device.iap.internal.a.f;
import com.amazon.device.iap.internal.model.ReceiptBuilder;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.Receipt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static final String a = "c";

    public static Receipt a(JSONObject jSONObject, String str, String str2) throws f, e, IllegalArgumentException {
        int i = AnonymousClass1.a[b(jSONObject).ordinal()];
        if (i == 1) {
            return c(jSONObject, str, str2);
        }
        if (i == 2) {
            return b(jSONObject, str, str2);
        }
        if (i == 3) {
            return d(jSONObject, str, str2);
        }
        return e(jSONObject, str, str2);
    }

    /* JADX INFO: renamed from: com.amazon.device.iap.internal.util.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            a = iArr;
            try {
                iArr[d.V1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.V2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[d.V3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static Receipt b(JSONObject jSONObject, String str, String str2) throws f, e {
        String strOptString = jSONObject.optString("signature");
        if (com.amazon.a.a.o.f.a(strOptString)) {
            b.b(a, "a signature was not found in the receipt for request ID " + str2);
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, "NO Signature found", strOptString);
            throw new f(str2, null, strOptString);
        }
        try {
            Receipt receiptA = a(jSONObject);
            String str3 = str + "-" + receiptA.getReceiptId();
            boolean zA = com.amazon.a.a.a(str3, strOptString);
            b.a(a, "stringToVerify/legacy:\n" + str3 + "\nsignature:\n" + strOptString);
            if (zA) {
                return receiptA;
            }
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, str3, strOptString);
            throw new f(str2, str3, strOptString);
        } catch (JSONException e) {
            throw new e(str2, jSONObject.toString(), e);
        }
    }

    private static Receipt a(JSONObject jSONObject) throws JSONException {
        String strOptString = jSONObject.optString("token");
        String string = jSONObject.getString("sku");
        ProductType productTypeValueOf = ProductType.valueOf(jSONObject.getString(com.amazon.a.a.o.b.k).toUpperCase());
        String strOptString2 = jSONObject.optString(com.amazon.a.a.o.b.P);
        Date dateB = a(strOptString2) ? null : b(strOptString2);
        String strOptString3 = jSONObject.optString(com.amazon.a.a.o.b.d);
        return new ReceiptBuilder().setReceiptId(strOptString).setSku(string).setProductType(productTypeValueOf).setPurchaseDate(dateB).setCancelDate(a(strOptString3) ? null : b(strOptString3)).build();
    }

    private static Receipt c(JSONObject jSONObject, String str, String str2) throws f, e {
        String strOptString = jSONObject.optString(com.amazon.a.a.o.b.Z);
        String strOptString2 = jSONObject.optString("signature");
        if (com.amazon.a.a.o.f.a(strOptString2)) {
            b.b(a, "a signature was not found in the receipt for request ID " + str2);
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, "NO Signature found", strOptString2);
            throw new f(str2, null, strOptString2);
        }
        try {
            Receipt receiptA = a(jSONObject);
            ProductType productType = receiptA.getProductType();
            String sku = receiptA.getSku();
            String receiptId = receiptA.getReceiptId();
            ProductType productType2 = ProductType.SUBSCRIPTION;
            String str3 = String.format("%s|%s|%s|%s|%s|%s|%s|%tQ|%tQ", PurchasingService.SDK_VERSION, str, strOptString, productType, sku, receiptId, str2, productType2 == receiptA.getProductType() ? receiptA.getPurchaseDate() : null, productType2 == receiptA.getProductType() ? receiptA.getCancelDate() : null);
            b.a(a, "stringToVerify/v1:\n" + str3 + "\nsignature:\n" + strOptString2);
            if (com.amazon.a.a.a(str3, strOptString2)) {
                return receiptA;
            }
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, str3, strOptString2);
            throw new f(str2, str3, strOptString2);
        } catch (JSONException e) {
            throw new e(str2, jSONObject.toString(), e);
        }
    }

    private static Receipt d(JSONObject jSONObject, String str, String str2) throws f, e {
        String strOptString = jSONObject.optString(com.amazon.a.a.o.b.Z);
        String strOptString2 = jSONObject.optString("signature");
        Date dateB = null;
        if (com.amazon.a.a.o.f.a(strOptString2)) {
            b.b(a, "a signature was not found in the receipt for request ID " + str2);
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, "NO Signature found", strOptString2);
            throw new f(str2, null, strOptString2);
        }
        try {
            String string = jSONObject.getString(com.amazon.a.a.o.b.E);
            String string2 = jSONObject.getString("sku");
            ProductType productTypeValueOf = ProductType.valueOf(jSONObject.getString(com.amazon.a.a.o.b.k).toUpperCase());
            String strOptString3 = jSONObject.optString(com.amazon.a.a.o.b.Q);
            Date dateB2 = a(strOptString3) ? null : b(strOptString3);
            String strOptString4 = jSONObject.optString(com.amazon.a.a.o.b.e);
            if (!a(strOptString4)) {
                dateB = b(strOptString4);
            }
            Receipt receiptBuild = new ReceiptBuilder().setReceiptId(string).setSku(string2).setProductType(productTypeValueOf).setPurchaseDate(dateB2).setCancelDate(dateB).build();
            String str3 = String.format("%s|%s|%s|%s|%s|%tQ|%tQ", str, strOptString, receiptBuild.getProductType(), receiptBuild.getSku(), receiptBuild.getReceiptId(), receiptBuild.getPurchaseDate(), receiptBuild.getCancelDate());
            b.a(a, "stringToVerify/v2:\n" + str3 + "\nsignature:\n" + strOptString2);
            if (com.amazon.a.a.a(str3, strOptString2)) {
                return receiptBuild;
            }
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, str3, strOptString2);
            throw new f(str2, str3, strOptString2);
        } catch (JSONException e) {
            throw new e(str2, jSONObject.toString(), e);
        }
    }

    private static Receipt e(JSONObject jSONObject, String str, String str2) throws f, e {
        String strOptString = jSONObject.optString(com.amazon.a.a.o.b.Z);
        String strOptString2 = jSONObject.optString("signature");
        Date dateB = null;
        if (com.amazon.a.a.o.f.a(strOptString2)) {
            b.b(a, "a signature was not found in the receipt for request ID " + str2);
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, "NO Signature found", strOptString2);
            throw new f(str2, null, strOptString2);
        }
        try {
            String string = jSONObject.getString(com.amazon.a.a.o.b.E);
            String string2 = jSONObject.getString("sku");
            String strOptString3 = jSONObject.optString(com.amazon.a.a.o.b.L, null);
            String strOptString4 = jSONObject.optString(com.amazon.a.a.o.b.M, null);
            ProductType productTypeValueOf = ProductType.valueOf(jSONObject.getString(com.amazon.a.a.o.b.k).toUpperCase());
            String strOptString5 = jSONObject.optString(com.amazon.a.a.o.b.Q);
            Date dateB2 = a(strOptString5) ? null : b(strOptString5);
            String strOptString6 = jSONObject.optString(com.amazon.a.a.o.b.e);
            Date dateB3 = a(strOptString6) ? null : b(strOptString6);
            String strOptString7 = jSONObject.optString(com.amazon.a.a.o.b.R);
            if (!a(strOptString7)) {
                dateB = b(strOptString7);
            }
            Receipt receiptBuild = new ReceiptBuilder().setReceiptId(string).setSku(string2).setProductType(productTypeValueOf).setPurchaseDate(dateB2).setCancelDate(dateB3).setDeferredDate(dateB).setDeferredSku(strOptString4).setTermSku(strOptString3).build();
            String str3 = String.format("%s|%s|%s|%s|%s|%s|%s|%tQ|%tQ|%tQ", str, strOptString, receiptBuild.getProductType(), receiptBuild.getSku(), receiptBuild.getReceiptId(), receiptBuild.getDeferredSku(), receiptBuild.getTermSku(), receiptBuild.getPurchaseDate(), receiptBuild.getCancelDate(), receiptBuild.getDeferredDate());
            b.a(a, "stringToVerify/v3:\n" + str3 + "\nsignature:\n" + strOptString2);
            if (com.amazon.a.a.a(str3, strOptString2)) {
                return receiptBuild;
            }
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, str3, strOptString2);
            throw new f(str2, str3, strOptString2);
        } catch (JSONException e) {
            throw new e(str2, jSONObject.toString(), e);
        }
    }

    protected static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    protected static Date b(String str) throws JSONException {
        try {
            Date date = new SimpleDateFormat(com.amazon.a.a.o.b.aj).parse(str);
            if (0 == date.getTime()) {
                return null;
            }
            return date;
        } catch (ParseException e) {
            throw new JSONException(e.getMessage());
        }
    }

    private static d b(JSONObject jSONObject) {
        String strOptString = jSONObject.optString(com.amazon.a.a.o.b.Z);
        String strOptString2 = jSONObject.optString(com.amazon.a.a.o.b.E);
        String strOptString3 = jSONObject.optString(com.amazon.a.a.o.b.N);
        if (!com.amazon.a.a.o.f.a(strOptString3)) {
            d dVar = d.V3;
            if (strOptString3.equals(dVar.name())) {
                return dVar;
            }
        }
        if (!com.amazon.a.a.o.f.a(strOptString2)) {
            return d.V2;
        }
        if (com.amazon.a.a.o.f.a(strOptString)) {
            return d.LEGACY;
        }
        return d.V1;
    }

    protected static JSONObject a(Receipt receipt, String str) {
        JSONObject jSONObject = new JSONObject();
        if (receipt != null && !com.amazon.a.a.o.f.a(str)) {
            try {
                jSONObject.put(com.amazon.a.a.o.b.E, receipt.getReceiptId());
                jSONObject.put("sku", receipt.getSku());
                jSONObject.put(com.amazon.a.a.o.b.k, receipt.getProductType());
                jSONObject.put(com.amazon.a.a.o.b.Q, receipt.getPurchaseDate());
                jSONObject.put(com.amazon.a.a.o.b.d, receipt.getCancelDate());
                jSONObject.put("signature", str);
                return jSONObject;
            } catch (JSONException unused) {
                b.b(a, "Failure during toJsonInternal: " + receipt + ", signature:" + str);
            }
        }
        return jSONObject;
    }

    public static String b(Receipt receipt, String str) {
        try {
            return a(receipt, str).toString(4);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static List<Receipt> a(String str, String str2, String str3) throws JSONException, f, e, IllegalArgumentException {
        if (str2 == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str2);
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(a(jSONArray.getJSONObject(i), str, str3));
            } catch (e e) {
                b.b(a, "fail to parse receipt, requestId:" + e.a());
                throw e;
            } catch (f e2) {
                b.b(a, "fail to verify receipt, requestId:" + e2.a());
                throw e2;
            } catch (Throwable th) {
                b.b(a, "fail to verify receipt, requestId:" + th.getMessage());
                throw th;
            }
        }
        return arrayList;
    }
}
