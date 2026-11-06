package com.revenuecat.purchases.ui.revenuecatui.helpers;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.models.SubscriptionOption;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\n\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0001\u0003\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "", "()V", "isPromoOffer", "", "()Z", "subscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "getSubscriptionOption", "()Lcom/revenuecat/purchases/models/SubscriptionOption;", "ConfiguredOffer", "NoConfiguration", "OfferNotFound", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer$ConfiguredOffer;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer$NoConfiguration;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer$OfferNotFound;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ResolvedOffer {
    public static final int $stable = 0;

    public /* synthetic */ ResolvedOffer(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ResolvedOffer() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer$ConfiguredOffer;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "option", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "(Lcom/revenuecat/purchases/models/SubscriptionOption;)V", "getOption", "()Lcom/revenuecat/purchases/models/SubscriptionOption;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ConfiguredOffer extends ResolvedOffer {
        public static final int $stable = 8;
        private final SubscriptionOption option;

        public static /* synthetic */ ConfiguredOffer copy$default(ConfiguredOffer configuredOffer, SubscriptionOption subscriptionOption, int i, Object obj) {
            if ((i & 1) != 0) {
                subscriptionOption = configuredOffer.option;
            }
            return configuredOffer.copy(subscriptionOption);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final SubscriptionOption getOption() {
            return this.option;
        }

        public final ConfiguredOffer copy(SubscriptionOption option) {
            Intrinsics.checkNotNullParameter(option, "option");
            return new ConfiguredOffer(option);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ConfiguredOffer) && Intrinsics.areEqual(this.option, ((ConfiguredOffer) other).option);
        }

        public int hashCode() {
            return this.option.hashCode();
        }

        public String toString() {
            return "ConfiguredOffer(option=" + this.option + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfiguredOffer(SubscriptionOption option) {
            super(null);
            Intrinsics.checkNotNullParameter(option, "option");
            this.option = option;
        }

        public final SubscriptionOption getOption() {
            return this.option;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer$NoConfiguration;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "option", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "(Lcom/revenuecat/purchases/models/SubscriptionOption;)V", "getOption", "()Lcom/revenuecat/purchases/models/SubscriptionOption;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class NoConfiguration extends ResolvedOffer {
        public static final int $stable = 8;
        private final SubscriptionOption option;

        public static /* synthetic */ NoConfiguration copy$default(NoConfiguration noConfiguration, SubscriptionOption subscriptionOption, int i, Object obj) {
            if ((i & 1) != 0) {
                subscriptionOption = noConfiguration.option;
            }
            return noConfiguration.copy(subscriptionOption);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final SubscriptionOption getOption() {
            return this.option;
        }

        public final NoConfiguration copy(SubscriptionOption option) {
            return new NoConfiguration(option);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NoConfiguration) && Intrinsics.areEqual(this.option, ((NoConfiguration) other).option);
        }

        public int hashCode() {
            SubscriptionOption subscriptionOption = this.option;
            if (subscriptionOption == null) {
                return 0;
            }
            return subscriptionOption.hashCode();
        }

        public String toString() {
            return "NoConfiguration(option=" + this.option + ')';
        }

        public NoConfiguration(SubscriptionOption subscriptionOption) {
            super(null);
            this.option = subscriptionOption;
        }

        public final SubscriptionOption getOption() {
            return this.option;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer$OfferNotFound;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "configuredOfferId", "", "fallbackOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "(Ljava/lang/String;Lcom/revenuecat/purchases/models/SubscriptionOption;)V", "getConfiguredOfferId", "()Ljava/lang/String;", "getFallbackOption", "()Lcom/revenuecat/purchases/models/SubscriptionOption;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class OfferNotFound extends ResolvedOffer {
        public static final int $stable = 8;
        private final String configuredOfferId;
        private final SubscriptionOption fallbackOption;

        public static /* synthetic */ OfferNotFound copy$default(OfferNotFound offerNotFound, String str, SubscriptionOption subscriptionOption, int i, Object obj) {
            if ((i & 1) != 0) {
                str = offerNotFound.configuredOfferId;
            }
            if ((i & 2) != 0) {
                subscriptionOption = offerNotFound.fallbackOption;
            }
            return offerNotFound.copy(str, subscriptionOption);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getConfiguredOfferId() {
            return this.configuredOfferId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final SubscriptionOption getFallbackOption() {
            return this.fallbackOption;
        }

        public final OfferNotFound copy(String configuredOfferId, SubscriptionOption fallbackOption) {
            Intrinsics.checkNotNullParameter(configuredOfferId, "configuredOfferId");
            return new OfferNotFound(configuredOfferId, fallbackOption);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OfferNotFound)) {
                return false;
            }
            OfferNotFound offerNotFound = (OfferNotFound) other;
            return Intrinsics.areEqual(this.configuredOfferId, offerNotFound.configuredOfferId) && Intrinsics.areEqual(this.fallbackOption, offerNotFound.fallbackOption);
        }

        public int hashCode() {
            int iHashCode = this.configuredOfferId.hashCode() * 31;
            SubscriptionOption subscriptionOption = this.fallbackOption;
            return iHashCode + (subscriptionOption == null ? 0 : subscriptionOption.hashCode());
        }

        public String toString() {
            return "OfferNotFound(configuredOfferId=" + this.configuredOfferId + ", fallbackOption=" + this.fallbackOption + ')';
        }

        public final String getConfiguredOfferId() {
            return this.configuredOfferId;
        }

        public final SubscriptionOption getFallbackOption() {
            return this.fallbackOption;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OfferNotFound(String configuredOfferId, SubscriptionOption subscriptionOption) {
            super(null);
            Intrinsics.checkNotNullParameter(configuredOfferId, "configuredOfferId");
            this.configuredOfferId = configuredOfferId;
            this.fallbackOption = subscriptionOption;
        }
    }

    public final SubscriptionOption getSubscriptionOption() {
        if (this instanceof ConfiguredOffer) {
            return ((ConfiguredOffer) this).getOption();
        }
        if (this instanceof NoConfiguration) {
            return ((NoConfiguration) this).getOption();
        }
        if (this instanceof OfferNotFound) {
            return ((OfferNotFound) this).getFallbackOption();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isPromoOffer() {
        return this instanceof ConfiguredOffer;
    }
}
