package com.revenuecat.purchases.ui.revenuecatui.data.testdata.templates;

import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.PaywallTemplate;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"template4", "Lcom/revenuecat/purchases/paywalls/PaywallData;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/testdata/TestData;", "getTemplate4", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/testdata/TestData;)Lcom/revenuecat/purchases/paywalls/PaywallData;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Template4TestDataKt {
    public static final PaywallData getTemplate4(TestData testData) {
        Intrinsics.checkNotNullParameter(testData, "<this>");
        String id = PaywallTemplate.TEMPLATE_4.getId();
        String identifier = PackageType.MONTHLY.getIdentifier();
        Intrinsics.checkNotNull(identifier);
        PackageType packageType = PackageType.SIX_MONTH;
        String identifier2 = packageType.getIdentifier();
        Intrinsics.checkNotNull(identifier2);
        String identifier3 = PackageType.ANNUAL.getIdentifier();
        Intrinsics.checkNotNull(identifier3);
        String identifier4 = PackageType.WEEKLY.getIdentifier();
        Intrinsics.checkNotNull(identifier4);
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{identifier, identifier2, identifier3, identifier4});
        String identifier5 = packageType.getIdentifier();
        Intrinsics.checkNotNull(identifier5);
        PaywallData.Configuration configuration = new PaywallData.Configuration(listListOf, identifier5, new PaywallData.Configuration.Images((String) null, "300883_1690710097.jpg", (String) null, 5, (DefaultConstructorMarker) null), (Map) null, new PaywallData.Configuration.ColorInformation(new PaywallData.Configuration.Colors(new PaywallColor("#FFFFFF"), new PaywallColor("#111111"), new PaywallColor("#333333"), new PaywallColor("#999999"), new PaywallColor("#06357D"), new PaywallColor("#FFFFFF"), (PaywallColor) null, new PaywallColor("#D4B5FC"), new PaywallColor("#DFDFDF"), (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, 32320, (DefaultConstructorMarker) null), (PaywallData.Configuration.Colors) null, 2, (DefaultConstructorMarker) null), (Map) null, (List) null, false, true, new URL("https://revenuecat.com/tos"), new URL("https://revenuecat.com/privacy"), 232, (DefaultConstructorMarker) null);
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("en_US", new PaywallData.LocalizedConfiguration("Get _unlimited_ access", (String) null, "Continue", (String) null, (String) null, "Cancel anytime", "Includes {{ sub_offer_duration }} **free** trial", (String) null, "{{ sub_duration_in_months }}", (List) null, (String) null, (Map) null, 3738, (DefaultConstructorMarker) null)));
        TestData.Constants constants = TestData.Constants.INSTANCE;
        return new PaywallData((String) null, id, configuration, constants.getAssetBaseURL(), 0, mapMapOf, (Map) null, constants.getZeroDecimalPlaceCountries(), (String) null, 337, (DefaultConstructorMarker) null);
    }
}
