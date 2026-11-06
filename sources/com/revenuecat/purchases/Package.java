package com.revenuecat.purchases;

import com.revenuecat.purchases.models.StoreProduct;
import java.net.URL;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tB3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/Package;", "", "identifier", "", "packageType", "Lcom/revenuecat/purchases/PackageType;", "product", "Lcom/revenuecat/purchases/models/StoreProduct;", "offering", "(Ljava/lang/String;Lcom/revenuecat/purchases/PackageType;Lcom/revenuecat/purchases/models/StoreProduct;Ljava/lang/String;)V", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "webCheckoutURL", "Ljava/net/URL;", "(Ljava/lang/String;Lcom/revenuecat/purchases/PackageType;Lcom/revenuecat/purchases/models/StoreProduct;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/net/URL;)V", "getIdentifier", "()Ljava/lang/String;", "getOffering$annotations", "()V", "getOffering", "getPackageType", "()Lcom/revenuecat/purchases/PackageType;", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getProduct", "()Lcom/revenuecat/purchases/models/StoreProduct;", "getWebCheckoutURL", "()Ljava/net/URL;", "copy", "copy$purchases_defaultsBc8Release", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Package {
    private final String identifier;
    private final PackageType packageType;
    private final PresentedOfferingContext presentedOfferingContext;
    private final StoreProduct product;
    private final URL webCheckoutURL;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Package(String identifier, PackageType packageType, StoreProduct product, PresentedOfferingContext presentedOfferingContext) {
        this(identifier, packageType, product, presentedOfferingContext, null, 16, null);
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(packageType, "packageType");
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
    }

    @Deprecated
    public static /* synthetic */ void getOffering$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Package)) {
            return false;
        }
        Package r5 = (Package) obj;
        return Intrinsics.areEqual(this.identifier, r5.identifier) && this.packageType == r5.packageType && Intrinsics.areEqual(this.product, r5.product) && Intrinsics.areEqual(this.presentedOfferingContext, r5.presentedOfferingContext) && Intrinsics.areEqual(this.webCheckoutURL, r5.webCheckoutURL);
    }

    public int hashCode() {
        int iHashCode = ((((((this.identifier.hashCode() * 31) + this.packageType.hashCode()) * 31) + this.product.hashCode()) * 31) + this.presentedOfferingContext.hashCode()) * 31;
        URL url = this.webCheckoutURL;
        return iHashCode + (url == null ? 0 : url.hashCode());
    }

    public String toString() {
        return "Package(identifier=" + this.identifier + ", packageType=" + this.packageType + ", product=" + this.product + ", presentedOfferingContext=" + this.presentedOfferingContext + ", webCheckoutURL=" + this.webCheckoutURL + ')';
    }

    public Package(String identifier, PackageType packageType, StoreProduct product, PresentedOfferingContext presentedOfferingContext, URL url) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(packageType, "packageType");
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        this.identifier = identifier;
        this.packageType = packageType;
        this.product = product;
        this.presentedOfferingContext = presentedOfferingContext;
        this.webCheckoutURL = url;
    }

    public /* synthetic */ Package(String str, PackageType packageType, StoreProduct storeProduct, PresentedOfferingContext presentedOfferingContext, URL url, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, packageType, storeProduct, presentedOfferingContext, (i & 16) != 0 ? null : url);
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final PackageType getPackageType() {
        return this.packageType;
    }

    public final StoreProduct getProduct() {
        return this.product;
    }

    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public final URL getWebCheckoutURL() {
        return this.webCheckoutURL;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public Package(String identifier, PackageType packageType, StoreProduct product, String offering) {
        this(identifier, packageType, product, new PresentedOfferingContext(offering), null);
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(packageType, "packageType");
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(offering, "offering");
    }

    public final String getOffering() {
        String offeringIdentifier = this.presentedOfferingContext.getOfferingIdentifier();
        return offeringIdentifier == null ? "" : offeringIdentifier;
    }

    public final Package copy$purchases_defaultsBc8Release(PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        return new Package(this.identifier, this.packageType, this.product.copyWithPresentedOfferingContext(presentedOfferingContext), presentedOfferingContext, this.webCheckoutURL);
    }
}
