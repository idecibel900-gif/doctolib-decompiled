package com.revenuecat.purchases;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000¨\u0006\u0006"}, d2 = {"withPresentedContext", "Lcom/revenuecat/purchases/Offering;", "placementId", "", "targeting", "Lcom/revenuecat/purchases/Offerings$Targeting;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OfferingsKt {
    public static final Offering withPresentedContext(Offering offering, String str, Offerings.Targeting targeting) {
        PresentedOfferingContext.TargetingContext targetingContext;
        Intrinsics.checkNotNullParameter(offering, "<this>");
        List<Package> availablePackages = offering.getAvailablePackages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(availablePackages, 10));
        for (Package r2 : availablePackages) {
            PresentedOfferingContext presentedOfferingContext = r2.getPresentedOfferingContext();
            String placementIdentifier = str == null ? presentedOfferingContext.getPlacementIdentifier() : str;
            if (targeting != null) {
                targetingContext = new PresentedOfferingContext.TargetingContext(targeting.getRevision(), targeting.getRuleId());
            } else {
                targetingContext = presentedOfferingContext.getTargetingContext();
            }
            PresentedOfferingContext presentedOfferingContextCopy$default = PresentedOfferingContext.copy$default(presentedOfferingContext, null, placementIdentifier, targetingContext, 1, null);
            arrayList.add(new Package(r2.getIdentifier(), r2.getPackageType(), r2.getProduct().copyWithPresentedOfferingContext(presentedOfferingContextCopy$default), presentedOfferingContextCopy$default, r2.getWebCheckoutURL()));
        }
        return new Offering(offering.getIdentifier(), offering.getServerDescription(), offering.getMetadata(), arrayList, offering.getPaywall(), offering.getPaywallComponents(), offering.getWebCheckoutURL());
    }
}
