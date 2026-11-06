package com.revenuecat.purchases.ui.revenuecatui.data.testdata;

import androidx.compose.material3.ColorScheme;
import androidx.compose.ui.graphics.Color;
import com.facebook.imageutils.JfifUtil;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.TestStoreProduct;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.components.PackageComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.PromoOfferConfig;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.templates.Template1TestDataKt;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.templates.Template2TestDataKt;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.templates.Template3TestDataKt;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.templates.Template4TestDataKt;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.templates.Template5TestDataKt;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.templates.Template7CustomPackagesTestDataKt;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.templates.Template7TestDataKt;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003\"#$B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001f\u001a\u00020 *\u00020 2\u0006\u0010!\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0013\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0015\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0011\u0010\u0017\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u0011\u0010\u0019\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000eR\u0011\u0010\u001b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000eR\u0011\u0010\u001d\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000e¨\u0006%"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/testdata/TestData;", "", "()V", "TEMPLATE_1_ID", "", "TEMPLATE_2_ID", "TEMPLATE_3_ID", "TEMPLATE_4_ID", "TEMPLATE_5_ID", "TEMPLATE_7_CUSTOM_PACKAGE_ID", "TEMPLATE_7_ID", "offeringWithNoPaywall", "Lcom/revenuecat/purchases/Offering;", "getOfferingWithNoPaywall", "()Lcom/revenuecat/purchases/Offering;", "template1Offering", "getTemplate1Offering", "template1OfferingNoFooter", "getTemplate1OfferingNoFooter", "template2Offering", "getTemplate2Offering", "template3Offering", "getTemplate3Offering", "template4Offering", "getTemplate4Offering", "template5Offering", "getTemplate5Offering", "template7CustomPackageOffering", "getTemplate7CustomPackageOffering", "template7Offering", "getTemplate7Offering", "copy", "Lcom/revenuecat/purchases/Package;", "offeringId", "Components", "Constants", "Packages", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TestData {
    public static final int $stable;
    public static final TestData INSTANCE;
    private static final String TEMPLATE_1_ID = "Template1";
    private static final String TEMPLATE_2_ID = "Template2";
    private static final String TEMPLATE_3_ID = "Template3";
    private static final String TEMPLATE_4_ID = "Template4";
    private static final String TEMPLATE_5_ID = "Template5";
    private static final String TEMPLATE_7_CUSTOM_PACKAGE_ID = "Template7CustomPackage";
    private static final String TEMPLATE_7_ID = "Template7";
    private static final Offering offeringWithNoPaywall;
    private static final Offering template1Offering;
    private static final Offering template1OfferingNoFooter;
    private static final Offering template2Offering;
    private static final Offering template3Offering;
    private static final Offering template4Offering;
    private static final Offering template5Offering;
    private static final Offering template7CustomPackageOffering;
    private static final Offering template7Offering;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/testdata/TestData$Constants;", "", "()V", "assetBaseURL", "Ljava/net/URL;", "getAssetBaseURL", "()Ljava/net/URL;", "currentColorScheme", "Landroidx/compose/material3/ColorScheme;", "getCurrentColorScheme", "()Landroidx/compose/material3/ColorScheme;", "images", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;", "getImages", "()Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;", "localization", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;", "getLocalization", "()Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;", "zeroDecimalPlaceCountries", "", "", "getZeroDecimalPlaceCountries", "()Ljava/util/List;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Constants {
        public static final int $stable;
        private static final ColorScheme currentColorScheme;
        public static final Constants INSTANCE = new Constants();
        private static final PaywallData.Configuration.Images images = new PaywallData.Configuration.Images("9a17e0a7_1689854430..jpeg", "9a17e0a7_1689854342..jpg", "9a17e0a7_1689854430..jpeg");
        private static final URL assetBaseURL = new URL("https://assets.pawwalls.com");
        private static final List<String> zeroDecimalPlaceCountries = CollectionsKt.listOf((Object[]) new String[]{"PH", "KZ", "TW", "MX", "TH"});
        private static final PaywallData.LocalizedConfiguration localization = new PaywallData.LocalizedConfiguration("Call to action for _better_ conversion.", "Lorem ipsum is simply dummy text of the ~printing and~ typesetting industry.", "Subscribe for {{ sub_price_per_month }}/mo", (String) null, (String) null, "{{ total_price_and_per_month }}", "{{ total_price_and_per_month }} after {{ sub_offer_duration }} trial", (String) null, "{{ sub_period }}", CollectionsKt.emptyList(), (String) null, (Map) null, 3224, (DefaultConstructorMarker) null);

        private Constants() {
        }

        static {
            Color.Companion companion = Color.Companion;
            currentColorScheme = new ColorScheme(companion.m1386getWhite0d7_KjU(), companion.m1386getWhite0d7_KjU(), companion.m1386getWhite0d7_KjU(), companion.m1386getWhite0d7_KjU(), companion.m1381getGreen0d7_KjU(), companion.m1376getBlack0d7_KjU(), companion.m1376getBlack0d7_KjU(), companion.m1376getBlack0d7_KjU(), companion.m1376getBlack0d7_KjU(), companion.m1378getCyan0d7_KjU(), companion.m1376getBlack0d7_KjU(), companion.m1380getGray0d7_KjU(), companion.m1386getWhite0d7_KjU(), companion.m1386getWhite0d7_KjU(), companion.m1376getBlack0d7_KjU(), companion.m1380getGray0d7_KjU(), companion.m1376getBlack0d7_KjU(), companion.m1379getDarkGray0d7_KjU(), companion.m1386getWhite0d7_KjU(), companion.m1382getLightGray0d7_KjU(), companion.m1376getBlack0d7_KjU(), companion.m1386getWhite0d7_KjU(), companion.m1383getRed0d7_KjU(), companion.m1386getWhite0d7_KjU(), companion.m1383getRed0d7_KjU(), companion.m1386getWhite0d7_KjU(), companion.m1384getTransparent0d7_KjU(), companion.m1382getLightGray0d7_KjU(), companion.m1380getGray0d7_KjU(), null);
            $stable = 8;
        }

        public final PaywallData.Configuration.Images getImages() {
            return images;
        }

        public final URL getAssetBaseURL() {
            return assetBaseURL;
        }

        public final List<String> getZeroDecimalPlaceCountries() {
            return zeroDecimalPlaceCountries;
        }

        public final PaywallData.LocalizedConfiguration getLocalization() {
            return localization;
        }

        public final ColorScheme getCurrentColorScheme() {
            return currentColorScheme;
        }
    }

    private TestData() {
    }

    public final Offering getOfferingWithNoPaywall() {
        return offeringWithNoPaywall;
    }

    static {
        TestData testData = new TestData();
        INSTANCE = testData;
        Packages packages = Packages.INSTANCE;
        offeringWithNoPaywall = new Offering(TEMPLATE_1_ID, "", MapsKt.emptyMap(), CollectionsKt.listOf(testData.copy(packages.getMonthly(), TEMPLATE_1_ID)), null, null, null, 96, null);
        template1Offering = new Offering(TEMPLATE_1_ID, "", MapsKt.emptyMap(), CollectionsKt.listOf(testData.copy(packages.getMonthly(), TEMPLATE_1_ID)), Template1TestDataKt.getTemplate1(testData), null, null, 96, null);
        template1OfferingNoFooter = new Offering(TEMPLATE_1_ID, "", MapsKt.emptyMap(), CollectionsKt.listOf(testData.copy(packages.getMonthly(), TEMPLATE_1_ID)), PaywallData.copy$default(Template1TestDataKt.getTemplate1(testData), null, PaywallData.Configuration.copy$default(Template1TestDataKt.getTemplate1(testData).getConfig(), null, null, null, null, null, false, false, null, null, null, null, null, null, 7743, null), null, 0, null, null, null, null, 253, null), null, null, 96, null);
        template2Offering = new Offering(TEMPLATE_2_ID, "", MapsKt.emptyMap(), CollectionsKt.listOf((Object[]) new Package[]{testData.copy(packages.getWeekly(), TEMPLATE_2_ID), testData.copy(packages.getMonthly(), TEMPLATE_2_ID), testData.copy(packages.getAnnual(), TEMPLATE_2_ID), testData.copy(packages.getLifetime(), TEMPLATE_2_ID)}), Template2TestDataKt.getTemplate2(testData), null, null, 96, null);
        template3Offering = new Offering(TEMPLATE_3_ID, "", MapsKt.emptyMap(), CollectionsKt.listOf(testData.copy(packages.getMonthly(), TEMPLATE_3_ID)), Template3TestDataKt.getTemplate3(testData), null, null, 96, null);
        template4Offering = new Offering(TEMPLATE_4_ID, "", MapsKt.emptyMap(), CollectionsKt.listOf((Object[]) new Package[]{testData.copy(packages.getMonthly(), TEMPLATE_4_ID), testData.copy(packages.getSemester(), TEMPLATE_4_ID), testData.copy(packages.getAnnual(), TEMPLATE_4_ID), testData.copy(packages.getWeekly(), TEMPLATE_4_ID)}), Template4TestDataKt.getTemplate4(testData), null, null, 96, null);
        template5Offering = new Offering(TEMPLATE_5_ID, "", MapsKt.emptyMap(), CollectionsKt.listOf((Object[]) new Package[]{testData.copy(packages.getMonthly(), TEMPLATE_5_ID), testData.copy(packages.getAnnual(), TEMPLATE_5_ID)}), Template5TestDataKt.getTemplate5(testData), null, null, 96, null);
        template7Offering = new Offering(TEMPLATE_7_ID, "", MapsKt.emptyMap(), CollectionsKt.listOf((Object[]) new Package[]{testData.copy(packages.getMonthly(), TEMPLATE_7_ID), testData.copy(packages.getAnnual(), TEMPLATE_7_ID), testData.copy(packages.getBimonthly(), TEMPLATE_7_ID), testData.copy(packages.getQuarterly(), TEMPLATE_7_ID), testData.copy(packages.getSemester(), TEMPLATE_7_ID), testData.copy(packages.getLifetime(), TEMPLATE_7_ID)}), Template7TestDataKt.getTemplate7(testData), null, null, 96, null);
        template7CustomPackageOffering = new Offering(TEMPLATE_7_CUSTOM_PACKAGE_ID, "", MapsKt.emptyMap(), CollectionsKt.listOf((Object[]) new Package[]{testData.copy(packages.getMonthly(), TEMPLATE_7_CUSTOM_PACKAGE_ID), testData.copy(packages.getAnnual(), TEMPLATE_7_CUSTOM_PACKAGE_ID), testData.copy(packages.getBimonthly(), TEMPLATE_7_CUSTOM_PACKAGE_ID), testData.copy(packages.getQuarterly(), TEMPLATE_7_CUSTOM_PACKAGE_ID), testData.copy(packages.getSemester(), TEMPLATE_7_CUSTOM_PACKAGE_ID), testData.copy(packages.getLifetime(), TEMPLATE_7_CUSTOM_PACKAGE_ID)}), Template7CustomPackagesTestDataKt.getTemplate7CustomPackages(testData), null, null, 96, null);
        $stable = 8;
    }

    public final Offering getTemplate1Offering() {
        return template1Offering;
    }

    public final Offering getTemplate1OfferingNoFooter() {
        return template1OfferingNoFooter;
    }

    public final Offering getTemplate2Offering() {
        return template2Offering;
    }

    public final Offering getTemplate3Offering() {
        return template3Offering;
    }

    public final Offering getTemplate4Offering() {
        return template4Offering;
    }

    public final Offering getTemplate5Offering() {
        return template5Offering;
    }

    public final Offering getTemplate7Offering() {
        return template7Offering;
    }

    public final Offering getTemplate7CustomPackageOffering() {
        return template7CustomPackageOffering;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/testdata/TestData$Packages;", "", "()V", "annual", "Lcom/revenuecat/purchases/Package;", "getAnnual", "()Lcom/revenuecat/purchases/Package;", "annualEuros", "getAnnualEuros", "annualTaiwan", "getAnnualTaiwan", "bimonthly", "getBimonthly", "custom", "getCustom", "lifetime", "getLifetime", "monthly", "getMonthly", "monthlyMexico", "getMonthlyMexico", "quarterly", "getQuarterly", "quarterlyThailand", "getQuarterlyThailand", "semester", "getSemester", "unknown", "getUnknown", "weekly", "getWeekly", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Packages {
        public static final int $stable;
        public static final Packages INSTANCE = new Packages();
        private static final Package annual;
        private static final Package annualEuros;
        private static final Package annualTaiwan;
        private static final Package bimonthly;
        private static final Package custom;
        private static final Package lifetime;
        private static final Package monthly;
        private static final Package monthlyMexico;
        private static final Package quarterly;
        private static final Package quarterlyThailand;
        private static final Package semester;
        private static final Package unknown;
        private static final Package weekly;

        private Packages() {
        }

        public final Package getWeekly() {
            return weekly;
        }

        static {
            PackageType packageType = PackageType.WEEKLY;
            String identifier = packageType.getIdentifier();
            Intrinsics.checkNotNull(identifier);
            Price price = new Price("$1.49", 1490000L, "USD");
            Period.Unit unit = Period.Unit.WEEK;
            weekly = new Package(identifier, packageType, new TestStoreProduct("com.revenuecat.weekly_product", "Weekly", "Weekly (App name)", "Weekly", price, new Period(1, unit, "P1W"), null, null, JfifUtil.MARKER_SOFn, null), "offering");
            PackageType packageType2 = PackageType.MONTHLY;
            String identifier2 = packageType2.getIdentifier();
            Intrinsics.checkNotNull(identifier2);
            Price price2 = new Price("$7.99", 7990000L, "USD");
            Period.Unit unit2 = Period.Unit.MONTH;
            monthly = new Package(identifier2, packageType2, new TestStoreProduct("com.revenuecat.monthly_product", "Monthly", "Monthly (App name)", "Monthly", price2, new Period(1, unit2, "P1M"), null, null, JfifUtil.MARKER_SOFn, null), new PresentedOfferingContext("offering"), new URL("https://test-web-billing.revenuecat.com?rc_package=" + packageType2.getIdentifier()));
            PackageType packageType3 = PackageType.ANNUAL;
            String identifier3 = packageType3.getIdentifier();
            Intrinsics.checkNotNull(identifier3);
            Price price3 = new Price("$67.99", 67990000L, "USD");
            Period.Unit unit3 = Period.Unit.YEAR;
            annual = new Package(identifier3, packageType3, new TestStoreProduct("com.revenuecat.annual_product", "Annual", "Annual (App name)", "Annual", price3, new Period(1, unit3, "P1Y"), new Period(1, unit2, "P1M"), null, 128, null), new PresentedOfferingContext("offering"), new URL("https://test-web-billing.revenuecat.com?rc_package=" + packageType3.getIdentifier()));
            String identifier4 = packageType3.getIdentifier();
            Intrinsics.checkNotNull(identifier4);
            annualEuros = new Package(identifier4, packageType3, new TestStoreProduct("com.revenuecat.annual_product", "Annual", "Annual (App name)", "Annual", new Price("67,99 €", 67990000L, "EUR"), new Period(1, unit3, "P1Y"), new Period(1, unit2, "P1M"), null, 128, null), "offering");
            PackageType packageType4 = PackageType.LIFETIME;
            String identifier5 = packageType4.getIdentifier();
            Intrinsics.checkNotNull(identifier5);
            lifetime = new Package(identifier5, packageType4, new TestStoreProduct("com.revenuecat.lifetime_product", "Lifetime", "Lifetime (App name)", "Lifetime", new Price("$1,000", 1000000000L, "USD"), null, null, null, JfifUtil.MARKER_SOFn, null), "offering");
            PackageType packageType5 = PackageType.TWO_MONTH;
            String identifier6 = packageType5.getIdentifier();
            Intrinsics.checkNotNull(identifier6);
            bimonthly = new Package(identifier6, packageType5, new TestStoreProduct("com.revenuecat.bimonthly_product", "2 month", "2 month (App name)", "2 month", new Price("$15.99", 15990000L, "USD"), new Period(2, unit2, "P2M"), null, new Price("$3.99", 3990000L, "USD"), 64, null), "offering");
            PackageType packageType6 = PackageType.THREE_MONTH;
            String identifier7 = packageType6.getIdentifier();
            Intrinsics.checkNotNull(identifier7);
            quarterly = new Package(identifier7, packageType6, new TestStoreProduct("com.revenuecat.quarterly_product", "3 month", "3 month (App name)", "3 month", new Price("$23.99", 23990000L, "USD"), new Period(3, unit2, "P3M"), new Period(2, unit, "P2W"), new Price("$3.99", 3990000L, "USD")), "offering");
            PackageType packageType7 = PackageType.SIX_MONTH;
            String identifier8 = packageType7.getIdentifier();
            Intrinsics.checkNotNull(identifier8);
            semester = new Package(identifier8, packageType7, new TestStoreProduct("com.revenuecat.semester_product", "6 month", "6 month (App name)", "6 month", new Price("$39.99", 39990000L, "USD"), new Period(6, unit2, "P6M"), null, null, JfifUtil.MARKER_SOFn, null), "offering");
            custom = new Package("Custom", PackageType.CUSTOM, new TestStoreProduct("com.revenuecat.semester_product", "6 month", "6 month (App name)", "6 month", new Price("$39.99", 39990000L, "USD"), new Period(6, unit2, "P6M"), null, null, JfifUtil.MARKER_SOFn, null), "offering");
            unknown = new Package("Unknown", PackageType.UNKNOWN, new TestStoreProduct("com.revenuecat.semester_product", "6 month", "6 month (App name)", "6 month", new Price("$39.99", 39990000L, "USD"), new Period(6, unit2, "P6M"), null, null, JfifUtil.MARKER_SOFn, null), "offering");
            String identifier9 = packageType3.getIdentifier();
            Intrinsics.checkNotNull(identifier9);
            annualTaiwan = new Package(identifier9, packageType3, new TestStoreProduct("com.revenuecat.annual_product", "Annual", "Annual (App name)", "Annual", new Price("NT$67.00", 67000000L, "TWD"), new Period(1, unit3, "P1Y"), new Period(1, unit2, "P1M"), null, 128, null), "offering");
            String identifier10 = packageType2.getIdentifier();
            Intrinsics.checkNotNull(identifier10);
            monthlyMexico = new Package(identifier10, packageType2, new TestStoreProduct("com.revenuecat.monthly_product", "Monthly", "Monthly (App name)", "Monthly", new Price("$8.00", 8000000L, "MXN"), new Period(1, unit2, "P1M"), null, null, JfifUtil.MARKER_SOFn, null), "offering");
            String identifier11 = packageType6.getIdentifier();
            Intrinsics.checkNotNull(identifier11);
            quarterlyThailand = new Package(identifier11, packageType6, new TestStoreProduct("com.revenuecat.quarterly_product", "3 month", "3 month (App name)", "3 month", new Price("THB24.00", 24000000L, "THB"), new Period(3, unit2, "P3M"), null, new Price("THB4.00", 4000000L, "THB"), 64, null), "offering");
            $stable = 8;
        }

        public final Package getMonthly() {
            return monthly;
        }

        public final Package getAnnual() {
            return annual;
        }

        public final Package getAnnualEuros() {
            return annualEuros;
        }

        public final Package getLifetime() {
            return lifetime;
        }

        public final Package getBimonthly() {
            return bimonthly;
        }

        public final Package getQuarterly() {
            return quarterly;
        }

        public final Package getSemester() {
            return semester;
        }

        public final Package getCustom() {
            return custom;
        }

        public final Package getUnknown() {
            return unknown;
        }

        public final Package getAnnualTaiwan() {
            return annualTaiwan;
        }

        public final Package getMonthlyMexico() {
            return monthlyMexico;
        }

        public final Package getQuarterlyThailand() {
            return quarterlyThailand;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/testdata/TestData$Components;", "", "()V", "monthlyPackageComponent", "Lcom/revenuecat/purchases/paywalls/components/PackageComponent;", "getMonthlyPackageComponent", "()Lcom/revenuecat/purchases/paywalls/components/PackageComponent;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Components {
        public static final int $stable = 0;
        public static final Components INSTANCE = new Components();
        private static final PackageComponent monthlyPackageComponent;

        private Components() {
        }

        static {
            String identifier = PackageType.MONTHLY.getIdentifier();
            Intrinsics.checkNotNull(identifier);
            monthlyPackageComponent = new PackageComponent(identifier, false, new StackComponent(CollectionsKt.emptyList(), (Boolean) null, (Dimension) null, (Size) null, (Float) null, (com.revenuecat.purchases.paywalls.components.properties.ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65534, (DefaultConstructorMarker) null), (PromoOfferConfig) null, (String) null, (Boolean) null, (List) null, 120, (DefaultConstructorMarker) null);
        }

        public final PackageComponent getMonthlyPackageComponent() {
            return monthlyPackageComponent;
        }
    }

    public final Package copy(Package r8, String offeringId) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(offeringId, "offeringId");
        PresentedOfferingContext presentedOfferingContext = new PresentedOfferingContext(offeringId);
        return new Package(r8.getIdentifier(), r8.getPackageType(), r8.getProduct().copyWithPresentedOfferingContext(presentedOfferingContext), presentedOfferingContext, r8.getWebCheckoutURL());
    }
}
