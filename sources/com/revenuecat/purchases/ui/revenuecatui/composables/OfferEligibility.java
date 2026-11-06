package com.revenuecat.purchases.ui.revenuecatui.composables;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0006\t\n\u000b\f\r\u000eB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0082\u0001\u0006\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "", "()V", "hasMultipleDiscountedPhases", "", "getHasMultipleDiscountedPhases", "()Z", "isIntroOffer", "isPromoOffer", "Ineligible", "IntroOfferMultiple", "IntroOfferSingle", "PromoOfferIneligible", "PromoOfferMultiple", "PromoOfferSingle", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility$Ineligible;", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility$IntroOfferMultiple;", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility$IntroOfferSingle;", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility$PromoOfferIneligible;", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility$PromoOfferMultiple;", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility$PromoOfferSingle;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class OfferEligibility {
    public static final int $stable = 0;

    public /* synthetic */ OfferEligibility(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private OfferEligibility() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility$Ineligible;", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Ineligible extends OfferEligibility {
        public static final int $stable = 0;
        public static final Ineligible INSTANCE = new Ineligible();

        private Ineligible() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility$IntroOfferSingle;", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class IntroOfferSingle extends OfferEligibility {
        public static final int $stable = 0;
        public static final IntroOfferSingle INSTANCE = new IntroOfferSingle();

        private IntroOfferSingle() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility$IntroOfferMultiple;", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class IntroOfferMultiple extends OfferEligibility {
        public static final int $stable = 0;
        public static final IntroOfferMultiple INSTANCE = new IntroOfferMultiple();

        private IntroOfferMultiple() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility$PromoOfferSingle;", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PromoOfferSingle extends OfferEligibility {
        public static final int $stable = 0;
        public static final PromoOfferSingle INSTANCE = new PromoOfferSingle();

        private PromoOfferSingle() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility$PromoOfferMultiple;", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PromoOfferMultiple extends OfferEligibility {
        public static final int $stable = 0;
        public static final PromoOfferMultiple INSTANCE = new PromoOfferMultiple();

        private PromoOfferMultiple() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility$PromoOfferIneligible;", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PromoOfferIneligible extends OfferEligibility {
        public static final int $stable = 0;
        public static final PromoOfferIneligible INSTANCE = new PromoOfferIneligible();

        private PromoOfferIneligible() {
            super(null);
        }
    }

    public final boolean getHasMultipleDiscountedPhases() {
        return (this instanceof IntroOfferMultiple) || (this instanceof PromoOfferMultiple);
    }

    public final boolean isIntroOffer() {
        return (this instanceof IntroOfferSingle) || (this instanceof IntroOfferMultiple);
    }

    public final boolean isPromoOffer() {
        return (this instanceof PromoOfferSingle) || (this instanceof PromoOfferMultiple);
    }
}
