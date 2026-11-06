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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"template2", "Lcom/revenuecat/purchases/paywalls/PaywallData;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/testdata/TestData;", "getTemplate2", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/testdata/TestData;)Lcom/revenuecat/purchases/paywalls/PaywallData;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Template2TestDataKt {
    public static final PaywallData getTemplate2(TestData testData) {
        Intrinsics.checkNotNullParameter(testData, "<this>");
        String id = PaywallTemplate.TEMPLATE_2.getId();
        String identifier = PackageType.ANNUAL.getIdentifier();
        Intrinsics.checkNotNull(identifier);
        PackageType packageType = PackageType.MONTHLY;
        String identifier2 = packageType.getIdentifier();
        Intrinsics.checkNotNull(identifier2);
        String identifier3 = PackageType.LIFETIME.getIdentifier();
        Intrinsics.checkNotNull(identifier3);
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{identifier, identifier2, identifier3});
        String identifier4 = packageType.getIdentifier();
        Intrinsics.checkNotNull(identifier4);
        TestData.Constants constants = TestData.Constants.INSTANCE;
        return new PaywallData((String) null, id, new PaywallData.Configuration(listListOf, identifier4, constants.getImages(), (Map) null, new PaywallData.Configuration.ColorInformation(new PaywallData.Configuration.Colors(new PaywallColor("#FFFFFF"), new PaywallColor("#000000"), (PaywallColor) null, (PaywallColor) null, new PaywallColor("#EC807C"), new PaywallColor("#FFFFFF"), new PaywallColor("#FC609C"), new PaywallColor("#BC66FF"), new PaywallColor("#222222"), (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, 32268, (DefaultConstructorMarker) null), (PaywallData.Configuration.Colors) null, 2, (DefaultConstructorMarker) null), (Map) null, (List) null, true, true, new URL("https://revenuecat.com/tos"), new URL("https://revenuecat.com/privacy"), 104, (DefaultConstructorMarker) null), constants.getAssetBaseURL(), 0, MapsKt.mapOf(TuplesKt.to("en_US", new PaywallData.LocalizedConfiguration("Call to **action** for _better_ conversion.", "**Lorem ipsum** is simply ~dummy~ text of the _printing_ and *typesetting* industry.", "Subscribe for {{ price_per_period }}", "Start your {{ sub_offer_duration }} free trial", (String) null, "{{ total_price_and_per_month }}", "{{ total_price_and_per_month }} after {{ sub_offer_duration }} trial", (String) null, "{{ sub_period }}", (List) null, (String) null, (Map) null, 3728, (DefaultConstructorMarker) null)), TuplesKt.to("es_ES", new PaywallData.LocalizedConfiguration("Título en español", "Un lorem ipsum en español que es más largo para mostrar un subtítulo multilinea.", "Suscribete for {{ price_per_period }}", "Empieza tu prueba gratuita de {{ sub_offer_duration }}", (String) null, "{{ total_price_and_per_month }}", "{{ total_price_and_per_month }} con {{ sub_offer_duration }} de prueba", (String) null, "{{ sub_period }}", (List) null, (String) null, (Map) null, 3728, (DefaultConstructorMarker) null))), (Map) null, constants.getZeroDecimalPlaceCountries(), (String) null, 337, (DefaultConstructorMarker) null);
    }
}
