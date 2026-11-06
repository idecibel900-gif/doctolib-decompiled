package com.revenuecat.purchases.ui.revenuecatui.extensions;

import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\r\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0000\u001a\f\u0010\u0011\u001a\u00020\u0001*\u00020\u000fH\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0018\u0010\b\u001a\u00020\u0006*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007\"\u0018\u0010\t\u001a\u00020\u0001*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"introOfferEligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "Lcom/revenuecat/purchases/Package;", "getIntroOfferEligibility", "(Lcom/revenuecat/purchases/Package;)Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "isMonthly", "", "(Lcom/revenuecat/purchases/Package;)Z", "isSubscription", "offerEligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "getOfferEligibility", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;)Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "calculateOfferEligibility", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "rcPackage", "promoOfferEligibility", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PackageExtensionsKt {
    public static final boolean isSubscription(Package r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getProduct().getType() == ProductType.SUBS;
    }

    public static final boolean isMonthly(Package r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Period period = r3.getProduct().getPeriod();
        return period != null && period.getUnit() == Period.Unit.MONTH && period.getValue() == 1;
    }

    public static final OfferEligibility calculateOfferEligibility(ResolvedOffer resolvedOffer, Package rcPackage) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        if (resolvedOffer != null && resolvedOffer.isPromoOffer()) {
            OfferEligibility offerEligibilityPromoOfferEligibility = promoOfferEligibility(resolvedOffer);
            if (!Intrinsics.areEqual(offerEligibilityPromoOfferEligibility, OfferEligibility.PromoOfferIneligible.INSTANCE)) {
                return offerEligibilityPromoOfferEligibility;
            }
        }
        return getIntroOfferEligibility(rcPackage);
    }

    public static final OfferEligibility getIntroOfferEligibility(Package r1) {
        List<PricingPhase> pricingPhases;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        SubscriptionOption defaultOption = r1.getProduct().getDefaultOption();
        int size = ((defaultOption == null || (pricingPhases = defaultOption.getPricingPhases()) == null) ? 0 : pricingPhases.size()) - 1;
        if (size == 1) {
            return OfferEligibility.IntroOfferSingle.INSTANCE;
        }
        if (size == 2) {
            return OfferEligibility.IntroOfferMultiple.INSTANCE;
        }
        return OfferEligibility.Ineligible.INSTANCE;
    }

    private static final OfferEligibility promoOfferEligibility(ResolvedOffer resolvedOffer) {
        List<PricingPhase> pricingPhases;
        SubscriptionOption subscriptionOption = resolvedOffer.getSubscriptionOption();
        int size = ((subscriptionOption == null || (pricingPhases = subscriptionOption.getPricingPhases()) == null) ? 0 : pricingPhases.size()) - 1;
        if (size == 1) {
            return OfferEligibility.PromoOfferSingle.INSTANCE;
        }
        if (size == 2) {
            return OfferEligibility.PromoOfferMultiple.INSTANCE;
        }
        return OfferEligibility.PromoOfferIneligible.INSTANCE;
    }

    public static final OfferEligibility getOfferEligibility(TemplateConfiguration.PackageInfo packageInfo) {
        Intrinsics.checkNotNullParameter(packageInfo, "<this>");
        return getIntroOfferEligibility(packageInfo.getRcPackage());
    }
}
