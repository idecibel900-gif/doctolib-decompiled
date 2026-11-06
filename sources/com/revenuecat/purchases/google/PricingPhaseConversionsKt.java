package com.revenuecat.purchases.google;

import com.android.billingclient.api.ProductDetails;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.RecurrenceMode;
import com.revenuecat.purchases.models.RecurrenceModeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toRevenueCatPricingPhase", "Lcom/revenuecat/purchases/models/PricingPhase;", "Lcom/android/billingclient/api/ProductDetails$PricingPhase;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PricingPhaseConversionsKt {
    public static final PricingPhase toRevenueCatPricingPhase(ProductDetails.PricingPhase pricingPhase) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Period.Companion companion = Period.INSTANCE;
        String billingPeriod = pricingPhase.getBillingPeriod();
        Intrinsics.checkNotNullExpressionValue(billingPeriod, "billingPeriod");
        Period periodCreate = companion.create(billingPeriod);
        RecurrenceMode recurrenceMode = RecurrenceModeKt.toRecurrenceMode(Integer.valueOf(pricingPhase.getRecurrenceMode()));
        Integer numValueOf = Integer.valueOf(pricingPhase.getBillingCycleCount());
        String formattedPrice = pricingPhase.getFormattedPrice();
        Intrinsics.checkNotNullExpressionValue(formattedPrice, "formattedPrice");
        long priceAmountMicros = pricingPhase.getPriceAmountMicros();
        String priceCurrencyCode = pricingPhase.getPriceCurrencyCode();
        Intrinsics.checkNotNullExpressionValue(priceCurrencyCode, "priceCurrencyCode");
        return new PricingPhase(periodCreate, recurrenceMode, numValueOf, new Price(formattedPrice, priceAmountMicros, priceCurrencyCode));
    }
}
