package com.revenuecat.purchases.ui.revenuecatui;

import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.models.SubscriptionOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogicParams;", "", "rcPackage", "Lcom/revenuecat/purchases/Package;", "productChange", "Lcom/revenuecat/purchases/ui/revenuecatui/ProductChange;", "subscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "(Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/ProductChange;Lcom/revenuecat/purchases/models/SubscriptionOption;)V", "oldProductId", "", "getOldProductId", "()Ljava/lang/String;", "getProductChange$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/ProductChange;", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "replacementMode", "Lcom/revenuecat/purchases/ReplacementMode;", "getReplacementMode", "()Lcom/revenuecat/purchases/ReplacementMode;", "getSubscriptionOption", "()Lcom/revenuecat/purchases/models/SubscriptionOption;", "Builder", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallPurchaseLogicParams {
    public static final int $stable = 8;
    private final ProductChange productChange;
    private final Package rcPackage;
    private final SubscriptionOption subscriptionOption;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallPurchaseLogicParams)) {
            return false;
        }
        PaywallPurchaseLogicParams paywallPurchaseLogicParams = (PaywallPurchaseLogicParams) obj;
        return Intrinsics.areEqual(this.rcPackage, paywallPurchaseLogicParams.rcPackage) && Intrinsics.areEqual(this.productChange, paywallPurchaseLogicParams.productChange) && Intrinsics.areEqual(this.subscriptionOption, paywallPurchaseLogicParams.subscriptionOption);
    }

    public int hashCode() {
        int iHashCode = this.rcPackage.hashCode() * 31;
        ProductChange productChange = this.productChange;
        int iHashCode2 = (iHashCode + (productChange == null ? 0 : productChange.hashCode())) * 31;
        SubscriptionOption subscriptionOption = this.subscriptionOption;
        return iHashCode2 + (subscriptionOption != null ? subscriptionOption.hashCode() : 0);
    }

    public String toString() {
        return "PaywallPurchaseLogicParams(rcPackage=" + this.rcPackage + ", productChange=" + this.productChange + ", subscriptionOption=" + this.subscriptionOption + ')';
    }

    public PaywallPurchaseLogicParams(Package rcPackage, ProductChange productChange, SubscriptionOption subscriptionOption) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        this.rcPackage = rcPackage;
        this.productChange = productChange;
        this.subscriptionOption = subscriptionOption;
    }

    public final Package getRcPackage() {
        return this.rcPackage;
    }

    /* JADX INFO: renamed from: getProductChange$revenuecatui_defaultsBc8Release, reason: from getter */
    public final ProductChange getProductChange() {
        return this.productChange;
    }

    public final SubscriptionOption getSubscriptionOption() {
        return this.subscriptionOption;
    }

    public final String getOldProductId() {
        ProductChange productChange = this.productChange;
        if (productChange != null) {
            return productChange.getOldProductId();
        }
        return null;
    }

    public final ReplacementMode getReplacementMode() {
        ProductChange productChange = this.productChange;
        if (productChange != null) {
            return productChange.getReplacementMode();
        }
        return null;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogicParams$Builder;", "", "rcPackage", "Lcom/revenuecat/purchases/Package;", "(Lcom/revenuecat/purchases/Package;)V", "oldProductId", "", "replacementMode", "Lcom/revenuecat/purchases/ReplacementMode;", "subscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "build", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogicParams;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private String oldProductId;
        private final Package rcPackage;
        private ReplacementMode replacementMode;
        private SubscriptionOption subscriptionOption;

        public Builder(Package rcPackage) {
            Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
            this.rcPackage = rcPackage;
        }

        public final Builder oldProductId(String oldProductId) {
            Intrinsics.checkNotNullParameter(oldProductId, "oldProductId");
            this.oldProductId = oldProductId;
            return this;
        }

        public final Builder replacementMode(ReplacementMode replacementMode) {
            this.replacementMode = replacementMode;
            return this;
        }

        public final Builder subscriptionOption(SubscriptionOption subscriptionOption) {
            this.subscriptionOption = subscriptionOption;
            return this;
        }

        public final PaywallPurchaseLogicParams build() {
            Package r0 = this.rcPackage;
            String str = this.oldProductId;
            return new PaywallPurchaseLogicParams(r0, str != null ? new ProductChange(str, this.replacementMode) : null, this.subscriptionOption);
        }
    }
}
