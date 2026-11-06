package com.revenuecat.purchases.amazon;

import com.amazon.a.a.o.b;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Bg\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00101\u001a\u00020\u000eHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\u0081\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006<"}, d2 = {"Lcom/revenuecat/purchases/amazon/ComparableData;", "", "amazonStoreProduct", "Lcom/revenuecat/purchases/amazon/AmazonStoreProduct;", "(Lcom/revenuecat/purchases/amazon/AmazonStoreProduct;)V", DiagnosticsEntry.ID_KEY, "", "type", "Lcom/revenuecat/purchases/ProductType;", b.S, b.c, "period", "Lcom/revenuecat/purchases/models/Period;", b.x, "Lcom/revenuecat/purchases/models/Price;", "subscriptionOptions", "Lcom/revenuecat/purchases/models/SubscriptionOptions;", "defaultOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", b.j, b.p, "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/Price;Lcom/revenuecat/purchases/models/SubscriptionOptions;Lcom/revenuecat/purchases/models/SubscriptionOption;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "getDefaultOption", "()Lcom/revenuecat/purchases/models/SubscriptionOption;", "getDescription", "()Ljava/lang/String;", "getFreeTrialPeriod", "()Lcom/revenuecat/purchases/models/Period;", "getIconUrl", "getId", "getPeriod", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPrice", "()Lcom/revenuecat/purchases/models/Price;", "getSubscriptionOptions", "()Lcom/revenuecat/purchases/models/SubscriptionOptions;", "getTitle", "getType", "()Lcom/revenuecat/purchases/ProductType;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final /* data */ class ComparableData {
    private final SubscriptionOption defaultOption;
    private final String description;
    private final Period freeTrialPeriod;
    private final String iconUrl;
    private final String id;
    private final Period period;
    private final PresentedOfferingContext presentedOfferingContext;
    private final Price price;
    private final SubscriptionOptions subscriptionOptions;
    private final String title;
    private final ProductType type;

    public static /* synthetic */ ComparableData copy$default(ComparableData comparableData, String str, ProductType productType, String str2, String str3, Period period, Price price, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, String str4, Period period2, PresentedOfferingContext presentedOfferingContext, int i, Object obj) {
        if ((i & 1) != 0) {
            str = comparableData.id;
        }
        if ((i & 2) != 0) {
            productType = comparableData.type;
        }
        if ((i & 4) != 0) {
            str2 = comparableData.title;
        }
        if ((i & 8) != 0) {
            str3 = comparableData.description;
        }
        if ((i & 16) != 0) {
            period = comparableData.period;
        }
        if ((i & 32) != 0) {
            price = comparableData.price;
        }
        if ((i & 64) != 0) {
            subscriptionOptions = comparableData.subscriptionOptions;
        }
        if ((i & 128) != 0) {
            subscriptionOption = comparableData.defaultOption;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
            str4 = comparableData.iconUrl;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
            period2 = comparableData.freeTrialPeriod;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0) {
            presentedOfferingContext = comparableData.presentedOfferingContext;
        }
        Period period3 = period2;
        PresentedOfferingContext presentedOfferingContext2 = presentedOfferingContext;
        SubscriptionOption subscriptionOption2 = subscriptionOption;
        String str5 = str4;
        Price price2 = price;
        SubscriptionOptions subscriptionOptions2 = subscriptionOptions;
        Period period4 = period;
        String str6 = str2;
        return comparableData.copy(str, productType, str6, str3, period4, price2, subscriptionOptions2, subscriptionOption2, str5, period3, presentedOfferingContext2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Period getFreeTrialPeriod() {
        return this.freeTrialPeriod;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ProductType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Period getPeriod() {
        return this.period;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Price getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final SubscriptionOptions getSubscriptionOptions() {
        return this.subscriptionOptions;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final SubscriptionOption getDefaultOption() {
        return this.defaultOption;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final ComparableData copy(String id, ProductType type, String title, String description, Period period, Price price, SubscriptionOptions subscriptionOptions, SubscriptionOption defaultOption, String iconUrl, Period freeTrialPeriod, PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        return new ComparableData(id, type, title, description, period, price, subscriptionOptions, defaultOption, iconUrl, freeTrialPeriod, presentedOfferingContext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ComparableData)) {
            return false;
        }
        ComparableData comparableData = (ComparableData) other;
        return Intrinsics.areEqual(this.id, comparableData.id) && this.type == comparableData.type && Intrinsics.areEqual(this.title, comparableData.title) && Intrinsics.areEqual(this.description, comparableData.description) && Intrinsics.areEqual(this.period, comparableData.period) && Intrinsics.areEqual(this.price, comparableData.price) && Intrinsics.areEqual(this.subscriptionOptions, comparableData.subscriptionOptions) && Intrinsics.areEqual(this.defaultOption, comparableData.defaultOption) && Intrinsics.areEqual(this.iconUrl, comparableData.iconUrl) && Intrinsics.areEqual(this.freeTrialPeriod, comparableData.freeTrialPeriod) && Intrinsics.areEqual(this.presentedOfferingContext, comparableData.presentedOfferingContext);
    }

    public int hashCode() {
        int iHashCode = ((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31;
        Period period = this.period;
        int iHashCode2 = (((iHashCode + (period == null ? 0 : period.hashCode())) * 31) + this.price.hashCode()) * 31;
        SubscriptionOptions subscriptionOptions = this.subscriptionOptions;
        int iHashCode3 = (iHashCode2 + (subscriptionOptions == null ? 0 : subscriptionOptions.hashCode())) * 31;
        SubscriptionOption subscriptionOption = this.defaultOption;
        int iHashCode4 = (((iHashCode3 + (subscriptionOption == null ? 0 : subscriptionOption.hashCode())) * 31) + this.iconUrl.hashCode()) * 31;
        Period period2 = this.freeTrialPeriod;
        int iHashCode5 = (iHashCode4 + (period2 == null ? 0 : period2.hashCode())) * 31;
        PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
        return iHashCode5 + (presentedOfferingContext != null ? presentedOfferingContext.hashCode() : 0);
    }

    public String toString() {
        return "ComparableData(id=" + this.id + ", type=" + this.type + ", title=" + this.title + ", description=" + this.description + ", period=" + this.period + ", price=" + this.price + ", subscriptionOptions=" + this.subscriptionOptions + ", defaultOption=" + this.defaultOption + ", iconUrl=" + this.iconUrl + ", freeTrialPeriod=" + this.freeTrialPeriod + ", presentedOfferingContext=" + this.presentedOfferingContext + ')';
    }

    public ComparableData(String id, ProductType type, String title, String description, Period period, Price price, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, String iconUrl, Period period2, PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        this.id = id;
        this.type = type;
        this.title = title;
        this.description = description;
        this.period = period;
        this.price = price;
        this.subscriptionOptions = subscriptionOptions;
        this.defaultOption = subscriptionOption;
        this.iconUrl = iconUrl;
        this.freeTrialPeriod = period2;
        this.presentedOfferingContext = presentedOfferingContext;
    }

    public final String getId() {
        return this.id;
    }

    public final ProductType getType() {
        return this.type;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Period getPeriod() {
        return this.period;
    }

    public final Price getPrice() {
        return this.price;
    }

    public final SubscriptionOptions getSubscriptionOptions() {
        return this.subscriptionOptions;
    }

    public final SubscriptionOption getDefaultOption() {
        return this.defaultOption;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final Period getFreeTrialPeriod() {
        return this.freeTrialPeriod;
    }

    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ComparableData(AmazonStoreProduct amazonStoreProduct) {
        this(amazonStoreProduct.getId(), amazonStoreProduct.getType(), amazonStoreProduct.getTitle(), amazonStoreProduct.getDescription(), amazonStoreProduct.getPeriod(), amazonStoreProduct.getPrice(), amazonStoreProduct.getSubscriptionOptions(), amazonStoreProduct.getDefaultOption(), amazonStoreProduct.getIconUrl(), amazonStoreProduct.getFreeTrialPeriod(), amazonStoreProduct.getPresentedOfferingContext());
        Intrinsics.checkNotNullParameter(amazonStoreProduct, "amazonStoreProduct");
    }
}
