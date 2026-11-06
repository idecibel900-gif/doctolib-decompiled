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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"template1", "Lcom/revenuecat/purchases/paywalls/PaywallData;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/testdata/TestData;", "getTemplate1", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/testdata/TestData;)Lcom/revenuecat/purchases/paywalls/PaywallData;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Template1TestDataKt {
    public static final PaywallData getTemplate1(TestData testData) {
        Intrinsics.checkNotNullParameter(testData, "<this>");
        String id = PaywallTemplate.TEMPLATE_1.getId();
        PackageType packageType = PackageType.MONTHLY;
        String identifier = packageType.getIdentifier();
        Intrinsics.checkNotNull(identifier);
        List listListOf = CollectionsKt.listOf(identifier);
        String identifier2 = packageType.getIdentifier();
        Intrinsics.checkNotNull(identifier2);
        TestData.Constants constants = TestData.Constants.INSTANCE;
        return new PaywallData((String) null, id, new PaywallData.Configuration(listListOf, identifier2, constants.getImages(), (Map) null, new PaywallData.Configuration.ColorInformation(new PaywallData.Configuration.Colors(new PaywallColor("#FFFFFF"), new PaywallColor("#000000"), (PaywallColor) null, (PaywallColor) null, new PaywallColor("#5CD27A"), new PaywallColor("#FFFFFF"), (PaywallColor) null, new PaywallColor("#BC66FF"), (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, 32588, (DefaultConstructorMarker) null), new PaywallData.Configuration.Colors(new PaywallColor("#000000"), new PaywallColor("#FFFFFF"), (PaywallColor) null, (PaywallColor) null, new PaywallColor("#ACD27A"), new PaywallColor("#000000"), (PaywallColor) null, new PaywallColor("#B022BB"), (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, 32588, (DefaultConstructorMarker) null)), (Map) null, (List) null, true, true, new URL("https://revenuecat.com/tos"), (URL) null, 1128, (DefaultConstructorMarker) null), constants.getAssetBaseURL(), 0, MapsKt.mapOf(TuplesKt.to("en_US", new PaywallData.LocalizedConfiguration("Ignite your _child_'s curiosity", "Get access to **all our educational content** trusted by thousands of parents.", "Subscribe for _only_ {{ sub_price_per_month }}", "Purchase for _only_ {{ sub_price_per_month }} per month", (String) null, "*Just* {{ sub_price_per_month }} per month", "Start your {{ sub_offer_duration }} trial, then {{ sub_price_per_month }} per month", (String) null, (String) null, (List) null, (String) null, (Map) null, 3984, (DefaultConstructorMarker) null))), (Map) null, constants.getZeroDecimalPlaceCountries(), (String) null, 337, (DefaultConstructorMarker) null);
    }
}
