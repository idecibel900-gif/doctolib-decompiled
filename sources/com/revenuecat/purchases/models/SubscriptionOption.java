package com.revenuecat.purchases.models;

import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\tR\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u000fR\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070#X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0012\u0010&\u001a\u00020'X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0#X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010%¨\u0006,À\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/models/SubscriptionOption;", "", "billingPeriod", "Lcom/revenuecat/purchases/models/Period;", "getBillingPeriod", "()Lcom/revenuecat/purchases/models/Period;", "freePhase", "Lcom/revenuecat/purchases/models/PricingPhase;", "getFreePhase", "()Lcom/revenuecat/purchases/models/PricingPhase;", "fullPricePhase", "getFullPricePhase", DiagnosticsEntry.ID_KEY, "", "getId", "()Ljava/lang/String;", "installmentsInfo", "Lcom/revenuecat/purchases/models/InstallmentsInfo;", "getInstallmentsInfo", "()Lcom/revenuecat/purchases/models/InstallmentsInfo;", "introPhase", "getIntroPhase", "isBasePlan", "", "()Z", "isPrepaid", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "presentedOfferingIdentifier", "getPresentedOfferingIdentifier$annotations", "()V", "getPresentedOfferingIdentifier", "pricingPhases", "", "getPricingPhases", "()Ljava/util/List;", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "getPurchasingData", "()Lcom/revenuecat/purchases/models/PurchasingData;", "tags", "getTags", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SubscriptionOption {
    String getId();

    InstallmentsInfo getInstallmentsInfo();

    PresentedOfferingContext getPresentedOfferingContext();

    String getPresentedOfferingIdentifier();

    List<PricingPhase> getPricingPhases();

    PurchasingData getPurchasingData();

    List<String> getTags();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
        }

        @Deprecated
        public static boolean isBasePlan(SubscriptionOption subscriptionOption) {
            return SubscriptionOption.super.isBasePlan();
        }

        @Deprecated
        public static Period getBillingPeriod(SubscriptionOption subscriptionOption) {
            return SubscriptionOption.super.getBillingPeriod();
        }

        @Deprecated
        public static boolean isPrepaid(SubscriptionOption subscriptionOption) {
            return SubscriptionOption.super.isPrepaid();
        }

        @Deprecated
        public static PricingPhase getFullPricePhase(SubscriptionOption subscriptionOption) {
            return SubscriptionOption.super.getFullPricePhase();
        }

        @Deprecated
        public static PricingPhase getFreePhase(SubscriptionOption subscriptionOption) {
            return SubscriptionOption.super.getFreePhase();
        }

        @Deprecated
        public static PricingPhase getIntroPhase(SubscriptionOption subscriptionOption) {
            return SubscriptionOption.super.getIntroPhase();
        }
    }

    default boolean isBasePlan() {
        return getPricingPhases().size() == 1;
    }

    default Period getBillingPeriod() {
        PricingPhase fullPricePhase = getFullPricePhase();
        if (fullPricePhase != null) {
            return fullPricePhase.getBillingPeriod();
        }
        return null;
    }

    default boolean isPrepaid() {
        PricingPhase fullPricePhase = getFullPricePhase();
        return (fullPricePhase != null ? fullPricePhase.getRecurrenceMode() : null) == RecurrenceMode.NON_RECURRING;
    }

    default PricingPhase getFullPricePhase() {
        return (PricingPhase) CollectionsKt.lastOrNull((List) getPricingPhases());
    }

    default PricingPhase getFreePhase() {
        Object next;
        Iterator it = CollectionsKt.dropLast(getPricingPhases(), 1).iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((PricingPhase) next).getPrice().getAmountMicros() == 0) {
                return (PricingPhase) next;
            }
        }
        next = null;
        return (PricingPhase) next;
    }

    default PricingPhase getIntroPhase() {
        Object next;
        Iterator it = CollectionsKt.dropLast(getPricingPhases(), 1).iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((PricingPhase) next).getPrice().getAmountMicros() > 0) {
                return (PricingPhase) next;
            }
        }
        next = null;
        return (PricingPhase) next;
    }
}
