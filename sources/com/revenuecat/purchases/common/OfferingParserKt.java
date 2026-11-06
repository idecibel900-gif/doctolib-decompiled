package com.revenuecat.purchases.common;

import com.revenuecat.purchases.PackageType;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"getWebCheckoutURL", "Ljava/net/URL;", "Lorg/json/JSONObject;", "toPackageType", "Lcom/revenuecat/purchases/PackageType;", "", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OfferingParserKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final URL getWebCheckoutURL(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("web_checkout_url");
        if (strOptString == null || strOptString.length() == 0) {
            strOptString = null;
        }
        if (strOptString == null) {
            return null;
        }
        try {
            return new URL(strOptString);
        } catch (MalformedURLException e) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error parsing web checkout URL: " + strOptString, e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PackageType toPackageType(String str) {
        PackageType packageType;
        PackageType[] packageTypeArrValues = PackageType.values();
        int length = packageTypeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                packageType = null;
                break;
            }
            packageType = packageTypeArrValues[i];
            if (Intrinsics.areEqual(packageType.getIdentifier(), str)) {
                break;
            }
            i++;
        }
        if (packageType == null) {
            return StringsKt.startsWith$default(str, "$rc_", false, 2, (Object) null) ? PackageType.UNKNOWN : PackageType.CUSTOM;
        }
        return packageType;
    }
}
