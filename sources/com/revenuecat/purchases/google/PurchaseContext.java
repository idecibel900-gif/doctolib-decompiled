package com.revenuecat.purchases.google;

import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.StoreReplacementMode;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b¢\u0006\u0002\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/google/PurchaseContext;", "", "productType", "Lcom/revenuecat/purchases/ProductType;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "selectedSubscriptionOptionId", "", "replacementMode", "Lcom/revenuecat/purchases/models/StoreReplacementMode;", "subscriptionOptionIdForProductIDs", "", "(Lcom/revenuecat/purchases/ProductType;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/String;Lcom/revenuecat/purchases/models/StoreReplacementMode;Ljava/util/Map;)V", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getProductType", "()Lcom/revenuecat/purchases/ProductType;", "getReplacementMode", "()Lcom/revenuecat/purchases/models/StoreReplacementMode;", "getSelectedSubscriptionOptionId", "()Ljava/lang/String;", "getSubscriptionOptionIdForProductIDs", "()Ljava/util/Map;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PurchaseContext {
    private final PresentedOfferingContext presentedOfferingContext;
    private final ProductType productType;
    private final StoreReplacementMode replacementMode;
    private final String selectedSubscriptionOptionId;
    private final Map<String, String> subscriptionOptionIdForProductIDs;

    public PurchaseContext(ProductType productType, PresentedOfferingContext presentedOfferingContext, String str, StoreReplacementMode storeReplacementMode, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        this.productType = productType;
        this.presentedOfferingContext = presentedOfferingContext;
        this.selectedSubscriptionOptionId = str;
        this.replacementMode = storeReplacementMode;
        this.subscriptionOptionIdForProductIDs = map;
    }

    public final ProductType getProductType() {
        return this.productType;
    }

    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public final String getSelectedSubscriptionOptionId() {
        return this.selectedSubscriptionOptionId;
    }

    public final StoreReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    public final Map<String, String> getSubscriptionOptionIdForProductIDs() {
        return this.subscriptionOptionIdForProductIDs;
    }
}
