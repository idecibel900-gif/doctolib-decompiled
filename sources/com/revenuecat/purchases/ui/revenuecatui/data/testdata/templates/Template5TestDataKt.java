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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"template5", "Lcom/revenuecat/purchases/paywalls/PaywallData;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/testdata/TestData;", "getTemplate5", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/testdata/TestData;)Lcom/revenuecat/purchases/paywalls/PaywallData;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Template5TestDataKt {
    public static final PaywallData getTemplate5(TestData testData) {
        Intrinsics.checkNotNullParameter(testData, "<this>");
        String id = PaywallTemplate.TEMPLATE_5.getId();
        PackageType packageType = PackageType.ANNUAL;
        String identifier = packageType.getIdentifier();
        Intrinsics.checkNotNull(identifier);
        String identifier2 = PackageType.MONTHLY.getIdentifier();
        Intrinsics.checkNotNull(identifier2);
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{identifier, identifier2});
        String identifier3 = packageType.getIdentifier();
        Intrinsics.checkNotNull(identifier3);
        PaywallData.Configuration configuration = new PaywallData.Configuration(listListOf, identifier3, new PaywallData.Configuration.Images("954459_1692992845.png", (String) null, (String) null, 6, (DefaultConstructorMarker) null), (Map) null, new PaywallData.Configuration.ColorInformation(new PaywallData.Configuration.Colors(new PaywallColor("#FFFFFF"), new PaywallColor("#000000"), new PaywallColor("#adf5c5"), new PaywallColor("#b15d5d"), new PaywallColor("#45c186"), new PaywallColor("#ffffff"), (PaywallColor) null, new PaywallColor("#b24010"), new PaywallColor("#027424"), new PaywallColor("#D1D1D1"), (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, 31808, (DefaultConstructorMarker) null), (PaywallData.Configuration.Colors) null, 2, (DefaultConstructorMarker) null), (Map) null, (List) null, false, true, (URL) null, new URL("https://revenuecat.com/privacy"), 744, (DefaultConstructorMarker) null);
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("en_US", new PaywallData.LocalizedConfiguration("Spice Up Your Kitchen - Go Pro for Exclusive Benefits!", (String) null, "Continue", "Start your Free Trial", (String) null, "{{ total_price_and_per_month }}", "Free for {{ sub_offer_duration }}, then {{ total_price_and_per_month }}", (String) null, "{{ sub_period }}", CollectionsKt.listOf((Object[]) new PaywallData.LocalizedConfiguration.Feature[]{new PaywallData.LocalizedConfiguration.Feature("Unique gourmet recipes", (String) null, "tick", 2, (DefaultConstructorMarker) null), new PaywallData.LocalizedConfiguration.Feature("Advanced nutritional recipes", (String) null, "apple", 2, (DefaultConstructorMarker) null), new PaywallData.LocalizedConfiguration.Feature("Personalized support from our Chef", (String) null, "warning", 2, (DefaultConstructorMarker) null), new PaywallData.LocalizedConfiguration.Feature("Unlimited receipt collections", (String) null, "bookmark", 2, (DefaultConstructorMarker) null)}), (String) null, (Map) null, 3218, (DefaultConstructorMarker) null)));
        TestData.Constants constants = TestData.Constants.INSTANCE;
        return new PaywallData((String) null, id, configuration, constants.getAssetBaseURL(), 0, mapMapOf, (Map) null, constants.getZeroDecimalPlaceCountries(), (String) null, 337, (DefaultConstructorMarker) null);
    }
}
