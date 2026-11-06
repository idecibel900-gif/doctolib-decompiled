package com.revenuecat.purchases.models;

import com.amazon.a.a.o.b;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.simulatedstore.SimulatedStorePurchasingData;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BS\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\rBI\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000eB_\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\n\u00106\u001a\u0004\u0018\u00010.H\u0002J\u0010\u00107\u001a\u00020\u00012\u0006\u00108\u001a\u00020\u0003H\u0017J\u0012\u00109\u001a\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u001aR\u0016\u0010-\u001a\u0004\u0018\u00010.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001aR\u0014\u00102\u001a\u0002038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u0006:"}, d2 = {"Lcom/revenuecat/purchases/models/TestStoreProduct;", "Lcom/revenuecat/purchases/models/StoreProduct;", DiagnosticsEntry.ID_KEY, "", "name", b.S, b.c, b.x, "Lcom/revenuecat/purchases/models/Price;", "period", "Lcom/revenuecat/purchases/models/Period;", b.p, "introPrice", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Price;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/Price;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Price;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/Price;)V", "freeTrialPricingPhase", "Lcom/revenuecat/purchases/models/PricingPhase;", "introPricePricingPhase", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Price;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/PricingPhase;Lcom/revenuecat/purchases/models/PricingPhase;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "defaultOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "getDefaultOption", "()Lcom/revenuecat/purchases/models/SubscriptionOption;", "getDescription", "()Ljava/lang/String;", "getId", "getName", "getPeriod", "()Lcom/revenuecat/purchases/models/Period;", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "presentedOfferingIdentifier", "getPresentedOfferingIdentifier$annotations", "()V", "getPresentedOfferingIdentifier", "getPrice", "()Lcom/revenuecat/purchases/models/Price;", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "getPurchasingData", "()Lcom/revenuecat/purchases/models/PurchasingData;", "sku", "getSku", "subscriptionOptions", "Lcom/revenuecat/purchases/models/SubscriptionOptions;", "getSubscriptionOptions", "()Lcom/revenuecat/purchases/models/SubscriptionOptions;", "getTitle", "type", "Lcom/revenuecat/purchases/ProductType;", "getType", "()Lcom/revenuecat/purchases/ProductType;", "buildSubscriptionOptions", "copyWithOfferingId", "offeringId", "copyWithPresentedOfferingContext", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TestStoreProduct implements StoreProduct {
    private final String description;
    private final PricingPhase freeTrialPricingPhase;
    private final String id;
    private final PricingPhase introPricePricingPhase;
    private final String name;
    private final Period period;
    private final PresentedOfferingContext presentedOfferingContext;
    private final Price price;
    private final PurchasingData purchasingData;
    private final String title;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TestStoreProduct(String id, String name, String title, String description, Price price) {
        this(id, name, title, description, price, null, null, null, null, 480, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(price, "price");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TestStoreProduct(String id, String name, String title, String description, Price price, Period period) {
        this(id, name, title, description, price, period, null, null, null, 448, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(price, "price");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TestStoreProduct(String id, String name, String title, String description, Price price, Period period, PricingPhase pricingPhase) {
        this(id, name, title, description, price, period, pricingPhase, null, null, 384, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(price, "price");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TestStoreProduct(String id, String name, String title, String description, Price price, Period period, PricingPhase pricingPhase, PricingPhase pricingPhase2) {
        this(id, name, title, description, price, period, pricingPhase, pricingPhase2, null, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(price, "price");
    }

    @Deprecated
    public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TestStoreProduct)) {
            return false;
        }
        TestStoreProduct testStoreProduct = (TestStoreProduct) obj;
        return Intrinsics.areEqual(this.id, testStoreProduct.id) && Intrinsics.areEqual(this.name, testStoreProduct.name) && Intrinsics.areEqual(this.title, testStoreProduct.title) && Intrinsics.areEqual(this.description, testStoreProduct.description) && Intrinsics.areEqual(this.price, testStoreProduct.price) && Intrinsics.areEqual(this.period, testStoreProduct.period) && Intrinsics.areEqual(this.freeTrialPricingPhase, testStoreProduct.freeTrialPricingPhase) && Intrinsics.areEqual(this.introPricePricingPhase, testStoreProduct.introPricePricingPhase) && Intrinsics.areEqual(this.presentedOfferingContext, testStoreProduct.presentedOfferingContext);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.price.hashCode()) * 31;
        Period period = this.period;
        int iHashCode2 = (iHashCode + (period == null ? 0 : period.hashCode())) * 31;
        PricingPhase pricingPhase = this.freeTrialPricingPhase;
        int iHashCode3 = (iHashCode2 + (pricingPhase == null ? 0 : pricingPhase.hashCode())) * 31;
        PricingPhase pricingPhase2 = this.introPricePricingPhase;
        int iHashCode4 = (iHashCode3 + (pricingPhase2 == null ? 0 : pricingPhase2.hashCode())) * 31;
        PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
        return iHashCode4 + (presentedOfferingContext != null ? presentedOfferingContext.hashCode() : 0);
    }

    public String toString() {
        return "TestStoreProduct(id=" + this.id + ", name=" + this.name + ", title=" + this.title + ", description=" + this.description + ", price=" + this.price + ", period=" + this.period + ", freeTrialPricingPhase=" + this.freeTrialPricingPhase + ", introPricePricingPhase=" + this.introPricePricingPhase + ", presentedOfferingContext=" + this.presentedOfferingContext + ')';
    }

    public TestStoreProduct(String id, String name, String title, String description, Price price, Period period, PricingPhase pricingPhase, PricingPhase pricingPhase2, PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(price, "price");
        this.id = id;
        this.name = name;
        this.title = title;
        this.description = description;
        this.price = price;
        this.period = period;
        this.freeTrialPricingPhase = pricingPhase;
        this.introPricePricingPhase = pricingPhase2;
        this.presentedOfferingContext = presentedOfferingContext;
        this.purchasingData = new SimulatedStorePurchasingData(getId(), getType(), this);
    }

    public /* synthetic */ TestStoreProduct(String str, String str2, String str3, String str4, Price price, Period period, PricingPhase pricingPhase, PricingPhase pricingPhase2, PresentedOfferingContext presentedOfferingContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, price, (i & 32) != 0 ? null : period, (i & 64) != 0 ? null : pricingPhase, (i & 128) != 0 ? null : pricingPhase2, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : presentedOfferingContext);
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getId() {
        return this.id;
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
    public Price getPrice() {
        return this.price;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public Period getPeriod() {
        return this.period;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public /* synthetic */ TestStoreProduct(String str, String str2, String str3, String str4, Price price, Period period, Period period2, Price price2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, price, (i & 32) != 0 ? null : period, (i & 64) != 0 ? null : period2, (i & 128) != 0 ? null : price2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public TestStoreProduct(String id, String name, String title, String description, Price price, Period period, Period period2, Price price2) {
        this(id, name, title, description, price, period, period2 != null ? new PricingPhase(period2, RecurrenceMode.FINITE_RECURRING, 1, new Price("Free", 0L, price.getCurrencyCode())) : null, price2 != null ? new PricingPhase(new Period(1, Period.Unit.MONTH, "P1M"), RecurrenceMode.FINITE_RECURRING, 1, price2) : null, null, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(price, "price");
    }

    public /* synthetic */ TestStoreProduct(String str, String str2, String str3, Price price, Period period, Period period2, Price price2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, price, period, (i & 32) != 0 ? null : period2, (i & 64) != 0 ? null : price2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public TestStoreProduct(String id, String title, String description, Price price, Period period, Period period2, Price price2) {
        this(id, title, title, description, price, period, period2, price2);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(price, "price");
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public ProductType getType() {
        return getPeriod() == null ? ProductType.INAPP : ProductType.SUBS;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public SubscriptionOptions getSubscriptionOptions() {
        return buildSubscriptionOptions();
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public SubscriptionOption getDefaultOption() {
        SubscriptionOptions subscriptionOptions = getSubscriptionOptions();
        if (subscriptionOptions != null) {
            return subscriptionOptions.getDefaultOffer();
        }
        return null;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public PurchasingData getPurchasingData() {
        return this.purchasingData;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getPresentedOfferingIdentifier() {
        PresentedOfferingContext presentedOfferingContext = getPresentedOfferingContext();
        if (presentedOfferingContext != null) {
            return presentedOfferingContext.getOfferingIdentifier();
        }
        return null;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getSku() {
        return getId();
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    @Deprecated
    public StoreProduct copyWithOfferingId(String offeringId) {
        Intrinsics.checkNotNullParameter(offeringId, "offeringId");
        return copyWithPresentedOfferingContext(new PresentedOfferingContext(offeringId));
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public StoreProduct copyWithPresentedOfferingContext(PresentedOfferingContext presentedOfferingContext) {
        return new TestStoreProduct(getId(), getName(), getTitle(), getDescription(), getPrice(), getPeriod(), this.freeTrialPricingPhase, this.introPricePricingPhase, presentedOfferingContext);
    }

    private final SubscriptionOptions buildSubscriptionOptions() {
        if (getPeriod() == null) {
            return null;
        }
        PricingPhase pricingPhase = new PricingPhase(getPeriod(), RecurrenceMode.INFINITE_RECURRING, null, getPrice());
        return new SubscriptionOptions(CollectionsKt.listOfNotNull((Object[]) new TestSubscriptionOption[]{(this.freeTrialPricingPhase == null && this.introPricePricingPhase == null) ? null : new TestSubscriptionOption(CollectionsKt.listOfNotNull((Object[]) new PricingPhase[]{this.freeTrialPricingPhase, this.introPricePricingPhase, pricingPhase}), null, null, null, null, getPurchasingData(), 30, null), new TestSubscriptionOption(CollectionsKt.listOf(pricingPhase), null, null, null, null, getPurchasingData(), 30, null)}));
    }
}
