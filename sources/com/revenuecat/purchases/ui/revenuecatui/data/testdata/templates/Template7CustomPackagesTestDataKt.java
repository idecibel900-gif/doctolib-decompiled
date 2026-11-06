package com.revenuecat.purchases.ui.revenuecatui.data.testdata.templates;

import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"template7CustomPackages", "Lcom/revenuecat/purchases/paywalls/PaywallData;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/testdata/TestData;", "getTemplate7CustomPackages", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/testdata/TestData;)Lcom/revenuecat/purchases/paywalls/PaywallData;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Template7CustomPackagesTestDataKt {
    public static final PaywallData getTemplate7CustomPackages(TestData testData) {
        Intrinsics.checkNotNullParameter(testData, "<this>");
        List listEmptyList = CollectionsKt.emptyList();
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("basic", new PaywallData.Configuration.Images("954459_1703109702.png", (String) null, (String) null, 6, (DefaultConstructorMarker) null)), TuplesKt.to("premium", new PaywallData.Configuration.Images("954459_1701267532.jpeg", (String) null, (String) null, 6, (DefaultConstructorMarker) null)));
        PackageType packageType = PackageType.ANNUAL;
        String identifier = packageType.getIdentifier();
        Intrinsics.checkNotNull(identifier);
        PackageType packageType2 = PackageType.MONTHLY;
        String identifier2 = packageType2.getIdentifier();
        Intrinsics.checkNotNull(identifier2);
        PackageType packageType3 = PackageType.SIX_MONTH;
        String identifier3 = packageType3.getIdentifier();
        Intrinsics.checkNotNull(identifier3);
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{identifier, identifier2, identifier3});
        String identifier4 = packageType.getIdentifier();
        Intrinsics.checkNotNull(identifier4);
        PaywallData.Configuration.Tier tier = new PaywallData.Configuration.Tier("basic", listListOf, identifier4);
        PackageType packageType4 = PackageType.LIFETIME;
        String identifier5 = packageType4.getIdentifier();
        Intrinsics.checkNotNull(identifier5);
        List listListOf2 = CollectionsKt.listOf(identifier5);
        String identifier6 = packageType4.getIdentifier();
        Intrinsics.checkNotNull(identifier6);
        PaywallData.Configuration configuration = new PaywallData.Configuration(listEmptyList, (String) null, (PaywallData.Configuration.Images) null, (PaywallData.Configuration.Images) null, mapMapOf, false, true, new URL("https://revenuecat.com/tos"), new URL("https://revenuecat.com/privacy"), new PaywallData.Configuration.ColorInformation(new PaywallData.Configuration.Colors(new PaywallColor("#FFFFFF"), new PaywallColor("#000000"), (PaywallColor) null, (PaywallColor) null, new PaywallColor("#45c186"), new PaywallColor("#ffffff"), (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, 32716, (DefaultConstructorMarker) null), (PaywallData.Configuration.Colors) null, 2, (DefaultConstructorMarker) null), MapsKt.mapOf(TuplesKt.to("basic", new PaywallData.Configuration.ColorInformation(new PaywallData.Configuration.Colors(new PaywallColor("#FFFFFF"), new PaywallColor("#000000"), new PaywallColor("#ffffff"), new PaywallColor("#30A0F8AA"), new PaywallColor("#3fc1f7"), new PaywallColor("#ffffff"), (PaywallColor) null, new PaywallColor("#2d7fc1"), new PaywallColor("#7676801F"), new PaywallColor("#100031"), (PaywallColor) null, new PaywallColor("#eeeef0"), new PaywallColor("#000000"), new PaywallColor("#2d7fc1"), new PaywallColor("#000000"), 1088, (DefaultConstructorMarker) null), (PaywallData.Configuration.Colors) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to("premium", new PaywallData.Configuration.ColorInformation(new PaywallData.Configuration.Colors(new PaywallColor("#FFFFFF"), new PaywallColor("#000000"), new PaywallColor("#ffffff"), new PaywallColor("#30A0F8AA"), new PaywallColor("#94d269"), new PaywallColor("#ffffff"), (PaywallColor) null, new PaywallColor("#76c343"), new PaywallColor("#7676801F"), new PaywallColor("#213711"), (PaywallColor) null, new PaywallColor("#eeeef0"), new PaywallColor("#000000"), new PaywallColor("#76c343"), new PaywallColor("#000000"), 1088, (DefaultConstructorMarker) null), (PaywallData.Configuration.Colors) null, 2, (DefaultConstructorMarker) null))), CollectionsKt.listOf((Object[]) new PaywallData.Configuration.Tier[]{tier, new PaywallData.Configuration.Tier("premium", listListOf2, identifier6)}), (String) null, 4142, (DefaultConstructorMarker) null);
        TestData.Constants constants = TestData.Constants.INSTANCE;
        URL assetBaseURL = constants.getAssetBaseURL();
        Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to("en_US", new PaywallData.LocalizedConfiguration("Get started with our Basic plan", (String) null, "{{ price_per_period }}", (String) null, (String) null, "{{ total_price_and_per_month }}", (String) null, (String) null, "{{ sub_period }}", (List) null, (String) null, (Map) null, 3802, (DefaultConstructorMarker) null)));
        List listListOf3 = CollectionsKt.listOf(new PaywallData.LocalizedConfiguration.Feature("Access to all 150 of our cinematic LUTs", (String) null, "tick", 2, (DefaultConstructorMarker) null));
        String identifier7 = packageType2.getIdentifier();
        Intrinsics.checkNotNull(identifier7);
        Pair pair = TuplesKt.to(identifier7, new PaywallData.LocalizedConfiguration.OfferOverride("{{ sub_period }}", "{{ total_price_and_per_month }}", (String) null, (String) null, (String) null, 12, (DefaultConstructorMarker) null));
        String identifier8 = packageType.getIdentifier();
        Intrinsics.checkNotNull(identifier8);
        Pair pair2 = TuplesKt.to(identifier8, new PaywallData.LocalizedConfiguration.OfferOverride("NAME OVERRIDE {{ sub_period }}", "DETAIL OVERRIDE {{ total_price_and_per_month }}", (String) null, (String) null, (String) null, 12, (DefaultConstructorMarker) null));
        String identifier9 = packageType3.getIdentifier();
        Intrinsics.checkNotNull(identifier9);
        return new PaywallData((String) null, "7", configuration, assetBaseURL, 0, mapMapOf2, MapsKt.mapOf(TuplesKt.to("en_US", MapsKt.mapOf(TuplesKt.to("basic", new PaywallData.LocalizedConfiguration("Get started with our Basic plan", (String) null, "Subscribe for {{ price_per_period }}", "Start your {{ sub_offer_duration }} free trial", (String) null, "{{ total_price_and_per_month }}", "{{ total_price_and_per_month }} after {{ sub_offer_duration }} trial", (String) null, "{{ sub_period }}", listListOf3, "Basic", MapsKt.mapOf(pair, pair2, TuplesKt.to(identifier9, new PaywallData.LocalizedConfiguration.OfferOverride("NAME OVERRIDE {{ sub_period }}", "DETAIL OVERRIDE {{ total_price_and_per_month }}", (String) null, (String) null, "BADGE OVERRIDE {{ sub_relative_discount }}", 12, (DefaultConstructorMarker) null))), 146, (DefaultConstructorMarker) null)), TuplesKt.to("premium", new PaywallData.LocalizedConfiguration("Master the art of video editing", (String) null, "Subscribe for {{ price_per_period }}", "Start your {{ sub_offer_duration }} free trial", (String) null, "{{ total_price_and_per_month }}", "{{ total_price_and_per_month }} after {{ sub_offer_duration }} trial", (String) null, "{{ sub_period }}", CollectionsKt.listOf((Object[]) new PaywallData.LocalizedConfiguration.Feature[]{new PaywallData.LocalizedConfiguration.Feature("Access to all 150 of our cinematic LUTs", (String) null, "tick", 2, (DefaultConstructorMarker) null), new PaywallData.LocalizedConfiguration.Feature("Custom design tools and transition effects", (String) null, "tick", 2, (DefaultConstructorMarker) null), new PaywallData.LocalizedConfiguration.Feature("100+ exclusive templates", (String) null, "tick", 2, (DefaultConstructorMarker) null)}), "Premium", (Map) null, 2194, (DefaultConstructorMarker) null))))), constants.getZeroDecimalPlaceCountries(), (String) null, 273, (DefaultConstructorMarker) null);
    }
}
