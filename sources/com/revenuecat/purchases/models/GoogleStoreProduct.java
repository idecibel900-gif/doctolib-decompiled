package com.revenuecat.purchases.models;

import com.amazon.a.a.o.b;
import com.android.billingclient.api.ProductDetails;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001Bs\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016Bk\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0018B-\b\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0000\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u001bB\u007f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u001cJ\u0010\u0010=\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\u0003H\u0017J\u0012\u0010?\u001a\u00020\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010@\u001a\u0004\u0018\u00010\u00032\u0006\u0010A\u001a\u00020BH\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u000b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001eR\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010*\u001a\u0004\b+\u0010\u001eR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0014\u00101\u001a\u0002028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b6\u0010*\u001a\u0004\b7\u0010\u001eR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0014\u0010\n\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<¨\u0006C"}, d2 = {"Lcom/revenuecat/purchases/models/GoogleStoreProduct;", "Lcom/revenuecat/purchases/models/StoreProduct;", "productId", "", "basePlanId", "type", "Lcom/revenuecat/purchases/ProductType;", b.x, "Lcom/revenuecat/purchases/models/Price;", "name", b.S, b.c, "period", "Lcom/revenuecat/purchases/models/Period;", "subscriptionOptions", "Lcom/revenuecat/purchases/models/SubscriptionOptions;", "defaultOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "productDetails", "Lcom/android/billingclient/api/ProductDetails;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;Lcom/revenuecat/purchases/models/Price;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/SubscriptionOptions;Lcom/revenuecat/purchases/models/SubscriptionOption;Lcom/android/billingclient/api/ProductDetails;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "presentedOfferingIdentifier", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;Lcom/revenuecat/purchases/models/Price;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/SubscriptionOptions;Lcom/revenuecat/purchases/models/SubscriptionOption;Lcom/android/billingclient/api/ProductDetails;Ljava/lang/String;)V", "otherProduct", "subscriptionOptionsWithOfferingId", "(Lcom/revenuecat/purchases/models/GoogleStoreProduct;Lcom/revenuecat/purchases/models/SubscriptionOption;Lcom/revenuecat/purchases/models/SubscriptionOptions;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;Lcom/revenuecat/purchases/models/Price;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/SubscriptionOptions;Lcom/revenuecat/purchases/models/SubscriptionOption;Lcom/android/billingclient/api/ProductDetails;Ljava/lang/String;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "getBasePlanId", "()Ljava/lang/String;", "getDefaultOption", "()Lcom/revenuecat/purchases/models/SubscriptionOption;", "getDescription", DiagnosticsEntry.ID_KEY, "getId", "getName", "getPeriod", "()Lcom/revenuecat/purchases/models/Period;", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPresentedOfferingIdentifier$annotations", "()V", "getPresentedOfferingIdentifier", "getPrice", "()Lcom/revenuecat/purchases/models/Price;", "getProductDetails", "()Lcom/android/billingclient/api/ProductDetails;", "getProductId", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "getPurchasingData", "()Lcom/revenuecat/purchases/models/PurchasingData;", "sku", "getSku$annotations", "getSku", "getSubscriptionOptions", "()Lcom/revenuecat/purchases/models/SubscriptionOptions;", "getTitle", "getType", "()Lcom/revenuecat/purchases/ProductType;", "copyWithOfferingId", "offeringId", "copyWithPresentedOfferingContext", "formattedPricePerMonth", "locale", "Ljava/util/Locale;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GoogleStoreProduct implements StoreProduct {
    private final String basePlanId;
    private final SubscriptionOption defaultOption;
    private final String description;
    private final String name;
    private final Period period;
    private final PresentedOfferingContext presentedOfferingContext;
    private final String presentedOfferingIdentifier;
    private final Price price;
    private final ProductDetails productDetails;
    private final String productId;
    private final SubscriptionOptions subscriptionOptions;
    private final String title;
    private final ProductType type;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public GoogleStoreProduct(String productId, String str, ProductType type, Price price, String name, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails) {
        this(productId, str, type, price, name, title, description, period, subscriptionOptions, subscriptionOption, productDetails, null, null, 6144, null);
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public GoogleStoreProduct(String productId, String str, ProductType type, Price price, String name, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, String str2) {
        this(productId, str, type, price, name, title, description, period, subscriptionOptions, subscriptionOption, productDetails, str2, null, 4096, null);
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
    }

    @Deprecated
    public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getSku$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoogleStoreProduct)) {
            return false;
        }
        GoogleStoreProduct googleStoreProduct = (GoogleStoreProduct) obj;
        return Intrinsics.areEqual(this.productId, googleStoreProduct.productId) && Intrinsics.areEqual(this.basePlanId, googleStoreProduct.basePlanId) && this.type == googleStoreProduct.type && Intrinsics.areEqual(this.price, googleStoreProduct.price) && Intrinsics.areEqual(this.name, googleStoreProduct.name) && Intrinsics.areEqual(this.title, googleStoreProduct.title) && Intrinsics.areEqual(this.description, googleStoreProduct.description) && Intrinsics.areEqual(this.period, googleStoreProduct.period) && Intrinsics.areEqual(this.subscriptionOptions, googleStoreProduct.subscriptionOptions) && Intrinsics.areEqual(this.defaultOption, googleStoreProduct.defaultOption) && Intrinsics.areEqual(this.productDetails, googleStoreProduct.productDetails) && Intrinsics.areEqual(this.presentedOfferingIdentifier, googleStoreProduct.presentedOfferingIdentifier) && Intrinsics.areEqual(this.presentedOfferingContext, googleStoreProduct.presentedOfferingContext);
    }

    public int hashCode() {
        int iHashCode = this.productId.hashCode() * 31;
        String str = this.basePlanId;
        int iHashCode2 = (((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.type.hashCode()) * 31) + this.price.hashCode()) * 31) + this.name.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31;
        Period period = this.period;
        int iHashCode3 = (iHashCode2 + (period == null ? 0 : period.hashCode())) * 31;
        SubscriptionOptions subscriptionOptions = this.subscriptionOptions;
        int iHashCode4 = (iHashCode3 + (subscriptionOptions == null ? 0 : subscriptionOptions.hashCode())) * 31;
        SubscriptionOption subscriptionOption = this.defaultOption;
        int iHashCode5 = (((iHashCode4 + (subscriptionOption == null ? 0 : subscriptionOption.hashCode())) * 31) + this.productDetails.hashCode()) * 31;
        String str2 = this.presentedOfferingIdentifier;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
        return iHashCode6 + (presentedOfferingContext != null ? presentedOfferingContext.hashCode() : 0);
    }

    public String toString() {
        return "GoogleStoreProduct(productId=" + this.productId + ", basePlanId=" + this.basePlanId + ", type=" + this.type + ", price=" + this.price + ", name=" + this.name + ", title=" + this.title + ", description=" + this.description + ", period=" + this.period + ", subscriptionOptions=" + this.subscriptionOptions + ", defaultOption=" + this.defaultOption + ", productDetails=" + this.productDetails + ", presentedOfferingIdentifier=" + this.presentedOfferingIdentifier + ", presentedOfferingContext=" + this.presentedOfferingContext + ')';
    }

    @Deprecated
    public GoogleStoreProduct(String productId, String str, ProductType type, Price price, String name, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, String str2, PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        this.productId = productId;
        this.basePlanId = str;
        this.type = type;
        this.price = price;
        this.name = name;
        this.title = title;
        this.description = description;
        this.period = period;
        this.subscriptionOptions = subscriptionOptions;
        this.defaultOption = subscriptionOption;
        this.productDetails = productDetails;
        this.presentedOfferingIdentifier = str2;
        this.presentedOfferingContext = presentedOfferingContext;
    }

    public /* synthetic */ GoogleStoreProduct(String str, String str2, ProductType productType, Price price, String str3, String str4, String str5, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, String str6, PresentedOfferingContext presentedOfferingContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, productType, price, str3, str4, str5, period, subscriptionOptions, subscriptionOption, productDetails, (i & 2048) != 0 ? null : str6, (i & 4096) != 0 ? null : presentedOfferingContext);
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getBasePlanId() {
        return this.basePlanId;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public ProductType getType() {
        return this.type;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public Price getPrice() {
        return this.price;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getName() {
        return this.name;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getTitle() {
        return this.title;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getDescription() {
        return this.description;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public Period getPeriod() {
        return this.period;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public SubscriptionOptions getSubscriptionOptions() {
        return this.subscriptionOptions;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public SubscriptionOption getDefaultOption() {
        return this.defaultOption;
    }

    public final ProductDetails getProductDetails() {
        return this.productDetails;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getPresentedOfferingIdentifier() {
        return this.presentedOfferingIdentifier;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public /* synthetic */ GoogleStoreProduct(String str, String str2, ProductType productType, Price price, String str3, String str4, String str5, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, PresentedOfferingContext presentedOfferingContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, productType, price, str3, str4, str5, period, subscriptionOptions, subscriptionOption, productDetails, (i & 2048) != 0 ? null : presentedOfferingContext);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GoogleStoreProduct(String productId, String str, ProductType type, Price price, String name, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, PresentedOfferingContext presentedOfferingContext) {
        this(productId, str, type, price, name, title, description, period, subscriptionOptions, subscriptionOption, productDetails, presentedOfferingContext != null ? presentedOfferingContext.getOfferingIdentifier() : null, presentedOfferingContext);
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
    }

    public /* synthetic */ GoogleStoreProduct(String str, String str2, ProductType productType, Price price, String str3, String str4, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, productType, price, str3, str4, period, subscriptionOptions, subscriptionOption, productDetails, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : str5);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public GoogleStoreProduct(String productId, String str, ProductType type, Price price, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, String str2) {
        this(productId, str, type, price, title, title, description, period, subscriptionOptions, subscriptionOption, productDetails, str2 != null ? new PresentedOfferingContext(str2) : null);
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
    }

    private GoogleStoreProduct(GoogleStoreProduct googleStoreProduct, SubscriptionOption subscriptionOption, SubscriptionOptions subscriptionOptions, PresentedOfferingContext presentedOfferingContext) {
        this(googleStoreProduct.productId, googleStoreProduct.basePlanId, googleStoreProduct.getType(), googleStoreProduct.getPrice(), googleStoreProduct.getName(), googleStoreProduct.getTitle(), googleStoreProduct.getDescription(), googleStoreProduct.getPeriod(), subscriptionOptions, subscriptionOption, googleStoreProduct.productDetails, presentedOfferingContext);
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getId() {
        if (this.basePlanId != null) {
            String str = this.productId + ':' + this.basePlanId;
            if (str != null) {
                return str;
            }
        }
        return this.productId;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public PurchasingData getPurchasingData() {
        if (getType() == ProductType.SUBS && getDefaultOption() != null) {
            return getDefaultOption().getPurchasingData();
        }
        return new GooglePurchasingData.InAppProduct(getId(), this.productDetails);
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getSku() {
        return this.productId;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    @Deprecated
    public StoreProduct copyWithOfferingId(String offeringId) {
        String str;
        PresentedOfferingContext presentedOfferingContext;
        Intrinsics.checkNotNullParameter(offeringId, "offeringId");
        PresentedOfferingContext presentedOfferingContext2 = getPresentedOfferingContext();
        if (presentedOfferingContext2 != null) {
            str = offeringId;
            presentedOfferingContext = PresentedOfferingContext.copy$default(presentedOfferingContext2, str, null, null, 6, null);
            if (presentedOfferingContext == null) {
            }
            return copyWithPresentedOfferingContext(presentedOfferingContext);
        }
        str = offeringId;
        presentedOfferingContext = new PresentedOfferingContext(str);
        return copyWithPresentedOfferingContext(presentedOfferingContext);
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public StoreProduct copyWithPresentedOfferingContext(PresentedOfferingContext presentedOfferingContext) {
        ArrayList arrayList;
        SubscriptionOptions subscriptionOptions = getSubscriptionOptions();
        if (subscriptionOptions != null) {
            arrayList = new ArrayList();
            for (SubscriptionOption subscriptionOption : subscriptionOptions) {
                GoogleSubscriptionOption googleSubscriptionOption = subscriptionOption instanceof GoogleSubscriptionOption ? (GoogleSubscriptionOption) subscriptionOption : null;
                GoogleSubscriptionOption googleSubscriptionOption2 = googleSubscriptionOption != null ? new GoogleSubscriptionOption(googleSubscriptionOption, presentedOfferingContext) : null;
                if (googleSubscriptionOption2 != null) {
                    arrayList.add(googleSubscriptionOption2);
                }
            }
        } else {
            arrayList = null;
        }
        SubscriptionOption defaultOption = getDefaultOption();
        GoogleSubscriptionOption googleSubscriptionOption3 = defaultOption instanceof GoogleSubscriptionOption ? (GoogleSubscriptionOption) defaultOption : null;
        return new GoogleStoreProduct(this, googleSubscriptionOption3 != null ? new GoogleSubscriptionOption(googleSubscriptionOption3, presentedOfferingContext) : null, arrayList != null ? new SubscriptionOptions(arrayList) : null, presentedOfferingContext);
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String formattedPricePerMonth(Locale locale) {
        SubscriptionOption basePlan;
        List<PricingPhase> pricingPhases;
        PricingPhase pricingPhase;
        Intrinsics.checkNotNullParameter(locale, "locale");
        SubscriptionOptions subscriptionOptions = getSubscriptionOptions();
        if (subscriptionOptions == null || (basePlan = subscriptionOptions.getBasePlan()) == null || (pricingPhases = basePlan.getPricingPhases()) == null || (pricingPhase = (PricingPhase) CollectionsKt.last((List) pricingPhases)) == null) {
            return null;
        }
        return pricingPhase.formattedPriceInMonths(locale);
    }
}
