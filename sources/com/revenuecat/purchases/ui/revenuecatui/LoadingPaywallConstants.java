package com.revenuecat.purchases.ui.revenuecatui;

import androidx.compose.ui.graphics.Color;
import com.facebook.imageutils.JfifUtil;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.TestStoreProduct;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.PaywallTemplate;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/LoadingPaywallConstants;", "", "()V", "offeringIdentifier", "", "packages", "", "Lcom/revenuecat/purchases/Package;", "getPackages", "()Ljava/util/List;", "placeholderAlpha", "", "placeholderColor", "Landroidx/compose/ui/graphics/Color;", "getPlaceholderColor-0d7_KjU", "()J", "J", "template", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PaywallTemplate;", "getTemplate", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PaywallTemplate;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LoadingPaywallConstants {
    public static final float placeholderAlpha = 0.5f;
    public static final LoadingPaywallConstants INSTANCE = new LoadingPaywallConstants();
    private static final long placeholderColor = Color.m1365copywmQWz5c$default(Color.Companion.m1380getGray0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null);
    private static final PaywallTemplate template = PaywallTemplate.TEMPLATE_2;
    public static final String offeringIdentifier = "loading_offering";
    private static final List<Package> packages = CollectionsKt.listOf((Object[]) new Package[]{new Package("weekly", PackageType.WEEKLY, new TestStoreProduct("com.revenuecat.weekly", "Weekly", "Weekly (App name)", "Weekly", new Price("$1.99", 1990000, "USD"), new Period(1, Period.Unit.WEEK, "P1W"), null, null, JfifUtil.MARKER_SOFn, null), offeringIdentifier), new Package("monthly", PackageType.MONTHLY, new TestStoreProduct("com.revenuecat.monthly", "Monthly", "Monthly (App name)", "Monthly", new Price("$5.99", 5990000, "USD"), new Period(1, Period.Unit.MONTH, "P1M"), null, null, JfifUtil.MARKER_SOFn, null), offeringIdentifier), new Package("annual", PackageType.ANNUAL, new TestStoreProduct("com.revenuecat.annual", "Annual", "Annual (App name)", "Annual", new Price("$15.99", 5990000, "USD"), new Period(1, Period.Unit.YEAR, "P1Y"), null, null, JfifUtil.MARKER_SOFn, null), offeringIdentifier)});

    private LoadingPaywallConstants() {
    }

    /* JADX INFO: renamed from: getPlaceholderColor-0d7_KjU, reason: not valid java name */
    public final long m4031getPlaceholderColor0d7_KjU() {
        return placeholderColor;
    }

    public final PaywallTemplate getTemplate() {
        return template;
    }

    public final List<Package> getPackages() {
        return packages;
    }
}
