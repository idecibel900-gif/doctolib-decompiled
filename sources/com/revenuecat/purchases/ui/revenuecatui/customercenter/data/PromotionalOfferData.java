package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.models.SubscriptionOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PromotionalOfferData;", "", "configuredPromotionalOffer", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;", "subscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "originalPath", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath;", "localizedPricingPhasesDescription", "", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;Lcom/revenuecat/purchases/models/SubscriptionOption;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath;Ljava/lang/String;)V", "getConfiguredPromotionalOffer", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;", "getLocalizedPricingPhasesDescription", "()Ljava/lang/String;", "getOriginalPath", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath;", "getSubscriptionOption", "()Lcom/revenuecat/purchases/models/SubscriptionOption;", "component1", "component2", "component3", "component4", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PromotionalOfferData {
    public static final int $stable = 8;
    private final CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer configuredPromotionalOffer;
    private final String localizedPricingPhasesDescription;
    private final CustomerCenterConfigData.HelpPath originalPath;
    private final SubscriptionOption subscriptionOption;

    public static /* synthetic */ PromotionalOfferData copy$default(PromotionalOfferData promotionalOfferData, CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer, SubscriptionOption subscriptionOption, CustomerCenterConfigData.HelpPath helpPath, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            promotionalOffer = promotionalOfferData.configuredPromotionalOffer;
        }
        if ((i & 2) != 0) {
            subscriptionOption = promotionalOfferData.subscriptionOption;
        }
        if ((i & 4) != 0) {
            helpPath = promotionalOfferData.originalPath;
        }
        if ((i & 8) != 0) {
            str = promotionalOfferData.localizedPricingPhasesDescription;
        }
        return promotionalOfferData.copy(promotionalOffer, subscriptionOption, helpPath, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer getConfiguredPromotionalOffer() {
        return this.configuredPromotionalOffer;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SubscriptionOption getSubscriptionOption() {
        return this.subscriptionOption;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CustomerCenterConfigData.HelpPath getOriginalPath() {
        return this.originalPath;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLocalizedPricingPhasesDescription() {
        return this.localizedPricingPhasesDescription;
    }

    public final PromotionalOfferData copy(CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer configuredPromotionalOffer, SubscriptionOption subscriptionOption, CustomerCenterConfigData.HelpPath originalPath, String localizedPricingPhasesDescription) {
        Intrinsics.checkNotNullParameter(configuredPromotionalOffer, "configuredPromotionalOffer");
        Intrinsics.checkNotNullParameter(subscriptionOption, "subscriptionOption");
        Intrinsics.checkNotNullParameter(originalPath, "originalPath");
        Intrinsics.checkNotNullParameter(localizedPricingPhasesDescription, "localizedPricingPhasesDescription");
        return new PromotionalOfferData(configuredPromotionalOffer, subscriptionOption, originalPath, localizedPricingPhasesDescription);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PromotionalOfferData)) {
            return false;
        }
        PromotionalOfferData promotionalOfferData = (PromotionalOfferData) other;
        return Intrinsics.areEqual(this.configuredPromotionalOffer, promotionalOfferData.configuredPromotionalOffer) && Intrinsics.areEqual(this.subscriptionOption, promotionalOfferData.subscriptionOption) && Intrinsics.areEqual(this.originalPath, promotionalOfferData.originalPath) && Intrinsics.areEqual(this.localizedPricingPhasesDescription, promotionalOfferData.localizedPricingPhasesDescription);
    }

    public int hashCode() {
        return (((((this.configuredPromotionalOffer.hashCode() * 31) + this.subscriptionOption.hashCode()) * 31) + this.originalPath.hashCode()) * 31) + this.localizedPricingPhasesDescription.hashCode();
    }

    public String toString() {
        return "PromotionalOfferData(configuredPromotionalOffer=" + this.configuredPromotionalOffer + ", subscriptionOption=" + this.subscriptionOption + ", originalPath=" + this.originalPath + ", localizedPricingPhasesDescription=" + this.localizedPricingPhasesDescription + ')';
    }

    public PromotionalOfferData(CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer configuredPromotionalOffer, SubscriptionOption subscriptionOption, CustomerCenterConfigData.HelpPath originalPath, String localizedPricingPhasesDescription) {
        Intrinsics.checkNotNullParameter(configuredPromotionalOffer, "configuredPromotionalOffer");
        Intrinsics.checkNotNullParameter(subscriptionOption, "subscriptionOption");
        Intrinsics.checkNotNullParameter(originalPath, "originalPath");
        Intrinsics.checkNotNullParameter(localizedPricingPhasesDescription, "localizedPricingPhasesDescription");
        this.configuredPromotionalOffer = configuredPromotionalOffer;
        this.subscriptionOption = subscriptionOption;
        this.originalPath = originalPath;
        this.localizedPricingPhasesDescription = localizedPricingPhasesDescription;
    }

    public final /* synthetic */ CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer getConfiguredPromotionalOffer() {
        return this.configuredPromotionalOffer;
    }

    public final /* synthetic */ SubscriptionOption getSubscriptionOption() {
        return this.subscriptionOption;
    }

    public final /* synthetic */ CustomerCenterConfigData.HelpPath getOriginalPath() {
        return this.originalPath;
    }

    public final /* synthetic */ String getLocalizedPricingPhasesDescription() {
        return this.localizedPricingPhasesDescription;
    }
}
