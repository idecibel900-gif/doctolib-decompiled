package com.revenuecat.purchases.paywalls.events;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0001¨\u0006\u0003"}, d2 = {"toBackendComponentFields", "Lcom/revenuecat/purchases/paywalls/events/BackendPaywallComponentFields;", "Lcom/revenuecat/purchases/paywalls/events/PaywallComponentInteractionData;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PaywallEventKt {
    @InternalRevenueCatAPI
    public static final BackendPaywallComponentFields toBackendComponentFields(PaywallComponentInteractionData paywallComponentInteractionData) {
        if (paywallComponentInteractionData == null) {
            return new BackendPaywallComponentFields(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
        }
        return new BackendPaywallComponentFields(PaywallComponentType.INSTANCE.serializer().getDescriptor().getElementName(paywallComponentInteractionData.getComponentType().ordinal()), paywallComponentInteractionData.getComponentName(), paywallComponentInteractionData.getComponentValue(), paywallComponentInteractionData.getComponentUrl(), paywallComponentInteractionData.getOriginIndex(), paywallComponentInteractionData.getDestinationIndex(), paywallComponentInteractionData.getOriginContextName(), paywallComponentInteractionData.getDestinationContextName(), paywallComponentInteractionData.getDefaultIndex(), paywallComponentInteractionData.getOriginPackageIdentifier(), paywallComponentInteractionData.getDestinationPackageIdentifier(), paywallComponentInteractionData.getDefaultPackageIdentifier(), paywallComponentInteractionData.getOriginProductIdentifier(), paywallComponentInteractionData.getDestinationProductIdentifier(), paywallComponentInteractionData.getDefaultProductIdentifier(), paywallComponentInteractionData.getCurrentPackageIdentifier(), paywallComponentInteractionData.getResultingPackageIdentifier(), paywallComponentInteractionData.getCurrentProductIdentifier(), paywallComponentInteractionData.getResultingProductIdentifier());
    }
}
