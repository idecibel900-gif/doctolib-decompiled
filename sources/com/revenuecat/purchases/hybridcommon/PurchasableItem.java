package com.revenuecat.purchases.hybridcommon;

import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/PurchasableItem;", "", "Package", "Product", "SubscriptionOption", "Lcom/revenuecat/purchases/hybridcommon/PurchasableItem$Package;", "Lcom/revenuecat/purchases/hybridcommon/PurchasableItem$Product;", "Lcom/revenuecat/purchases/hybridcommon/PurchasableItem$SubscriptionOption;", "hybridcommon_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
interface PurchasableItem {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/PurchasableItem$Product;", "Lcom/revenuecat/purchases/hybridcommon/PurchasableItem;", "productIdentifier", "", "type", "googleBasePlanId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getGoogleBasePlanId", "()Ljava/lang/String;", "getProductIdentifier", "getType", "component1", "component2", "component3", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "hybridcommon_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Product implements PurchasableItem {
        private final String googleBasePlanId;
        private final String productIdentifier;
        private final String type;

        public static /* synthetic */ Product copy$default(Product product, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = product.productIdentifier;
            }
            if ((i & 2) != 0) {
                str2 = product.type;
            }
            if ((i & 4) != 0) {
                str3 = product.googleBasePlanId;
            }
            return product.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getProductIdentifier() {
            return this.productIdentifier;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getGoogleBasePlanId() {
            return this.googleBasePlanId;
        }

        public final Product copy(String productIdentifier, String type, String googleBasePlanId) {
            Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
            Intrinsics.checkNotNullParameter(type, "type");
            return new Product(productIdentifier, type, googleBasePlanId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Product)) {
                return false;
            }
            Product product = (Product) other;
            return Intrinsics.areEqual(this.productIdentifier, product.productIdentifier) && Intrinsics.areEqual(this.type, product.type) && Intrinsics.areEqual(this.googleBasePlanId, product.googleBasePlanId);
        }

        public int hashCode() {
            int iHashCode = ((this.productIdentifier.hashCode() * 31) + this.type.hashCode()) * 31;
            String str = this.googleBasePlanId;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Product(productIdentifier=" + this.productIdentifier + ", type=" + this.type + ", googleBasePlanId=" + this.googleBasePlanId + ')';
        }

        public Product(String productIdentifier, String type, String str) {
            Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
            Intrinsics.checkNotNullParameter(type, "type");
            this.productIdentifier = productIdentifier;
            this.type = type;
            this.googleBasePlanId = str;
        }

        public final String getProductIdentifier() {
            return this.productIdentifier;
        }

        public final String getType() {
            return this.type;
        }

        public final String getGoogleBasePlanId() {
            return this.googleBasePlanId;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/PurchasableItem$Package;", "Lcom/revenuecat/purchases/hybridcommon/PurchasableItem;", "packageIdentifier", "", "(Ljava/lang/String;)V", "getPackageIdentifier", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "hybridcommon_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Package implements PurchasableItem {
        private final String packageIdentifier;

        public static /* synthetic */ Package copy$default(Package r0, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = r0.packageIdentifier;
            }
            return r0.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPackageIdentifier() {
            return this.packageIdentifier;
        }

        public final Package copy(String packageIdentifier) {
            Intrinsics.checkNotNullParameter(packageIdentifier, "packageIdentifier");
            return new Package(packageIdentifier);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Package) && Intrinsics.areEqual(this.packageIdentifier, ((Package) other).packageIdentifier);
        }

        public int hashCode() {
            return this.packageIdentifier.hashCode();
        }

        public String toString() {
            return "Package(packageIdentifier=" + this.packageIdentifier + ')';
        }

        public Package(String packageIdentifier) {
            Intrinsics.checkNotNullParameter(packageIdentifier, "packageIdentifier");
            this.packageIdentifier = packageIdentifier;
        }

        public final String getPackageIdentifier() {
            return this.packageIdentifier;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/PurchasableItem$SubscriptionOption;", "Lcom/revenuecat/purchases/hybridcommon/PurchasableItem;", "productIdentifier", "", "optionIdentifier", "(Ljava/lang/String;Ljava/lang/String;)V", "getOptionIdentifier", "()Ljava/lang/String;", "getProductIdentifier", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "hybridcommon_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class SubscriptionOption implements PurchasableItem {
        private final String optionIdentifier;
        private final String productIdentifier;

        public static /* synthetic */ SubscriptionOption copy$default(SubscriptionOption subscriptionOption, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subscriptionOption.productIdentifier;
            }
            if ((i & 2) != 0) {
                str2 = subscriptionOption.optionIdentifier;
            }
            return subscriptionOption.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getProductIdentifier() {
            return this.productIdentifier;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getOptionIdentifier() {
            return this.optionIdentifier;
        }

        public final SubscriptionOption copy(String productIdentifier, String optionIdentifier) {
            Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
            Intrinsics.checkNotNullParameter(optionIdentifier, "optionIdentifier");
            return new SubscriptionOption(productIdentifier, optionIdentifier);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubscriptionOption)) {
                return false;
            }
            SubscriptionOption subscriptionOption = (SubscriptionOption) other;
            return Intrinsics.areEqual(this.productIdentifier, subscriptionOption.productIdentifier) && Intrinsics.areEqual(this.optionIdentifier, subscriptionOption.optionIdentifier);
        }

        public int hashCode() {
            return (this.productIdentifier.hashCode() * 31) + this.optionIdentifier.hashCode();
        }

        public String toString() {
            return "SubscriptionOption(productIdentifier=" + this.productIdentifier + ", optionIdentifier=" + this.optionIdentifier + ')';
        }

        public SubscriptionOption(String productIdentifier, String optionIdentifier) {
            Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
            Intrinsics.checkNotNullParameter(optionIdentifier, "optionIdentifier");
            this.productIdentifier = productIdentifier;
            this.optionIdentifier = optionIdentifier;
        }

        public final String getProductIdentifier() {
            return this.productIdentifier;
        }

        public final String getOptionIdentifier() {
            return this.optionIdentifier;
        }
    }
}
