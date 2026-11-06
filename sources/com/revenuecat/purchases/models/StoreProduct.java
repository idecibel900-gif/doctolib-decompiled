package com.revenuecat.purchases.models;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.utils.PriceExtensionsKt;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0007H'J\u0012\u00101\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u0014\u00102\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u00103\u001a\u000204H\u0016J\u0014\u00105\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u00103\u001a\u000204H\u0016J\u0014\u00106\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u00103\u001a\u000204H\u0016J\u0014\u00107\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u00103\u001a\u000204H\u0016J\u0014\u00108\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u00103\u001a\u000204H\u0016R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00078&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\tR\u0014\u0010%\u001a\u0004\u0018\u00010&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0012\u0010)\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\tR\u0012\u0010+\u001a\u00020,X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00069À\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/models/StoreProduct;", "", "defaultOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "getDefaultOption", "()Lcom/revenuecat/purchases/models/SubscriptionOption;", b.c, "", "getDescription", "()Ljava/lang/String;", DiagnosticsEntry.ID_KEY, "getId", "name", "getName", "period", "Lcom/revenuecat/purchases/models/Period;", "getPeriod", "()Lcom/revenuecat/purchases/models/Period;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "presentedOfferingIdentifier", "getPresentedOfferingIdentifier$annotations", "()V", "getPresentedOfferingIdentifier", b.x, "Lcom/revenuecat/purchases/models/Price;", "getPrice", "()Lcom/revenuecat/purchases/models/Price;", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "getPurchasingData", "()Lcom/revenuecat/purchases/models/PurchasingData;", "sku", "getSku$annotations", "getSku", "subscriptionOptions", "Lcom/revenuecat/purchases/models/SubscriptionOptions;", "getSubscriptionOptions", "()Lcom/revenuecat/purchases/models/SubscriptionOptions;", b.S, "getTitle", "type", "Lcom/revenuecat/purchases/ProductType;", "getType", "()Lcom/revenuecat/purchases/ProductType;", "copyWithOfferingId", "offeringId", "copyWithPresentedOfferingContext", "formattedPricePerMonth", "locale", "Ljava/util/Locale;", "pricePerDay", "pricePerMonth", "pricePerWeek", "pricePerYear", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface StoreProduct {
    @Deprecated
    StoreProduct copyWithOfferingId(String offeringId);

    StoreProduct copyWithPresentedOfferingContext(PresentedOfferingContext presentedOfferingContext);

    SubscriptionOption getDefaultOption();

    String getDescription();

    String getId();

    String getName();

    Period getPeriod();

    PresentedOfferingContext getPresentedOfferingContext();

    String getPresentedOfferingIdentifier();

    Price getPrice();

    PurchasingData getPurchasingData();

    String getSku();

    SubscriptionOptions getSubscriptionOptions();

    String getTitle();

    ProductType getType();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
        }

        @Deprecated
        public static /* synthetic */ void getSku$annotations() {
        }

        @Deprecated
        public static Price pricePerDay(StoreProduct storeProduct, Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            return StoreProduct.super.pricePerDay(locale);
        }

        @Deprecated
        public static Price pricePerWeek(StoreProduct storeProduct, Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            return StoreProduct.super.pricePerWeek(locale);
        }

        @Deprecated
        public static Price pricePerMonth(StoreProduct storeProduct, Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            return StoreProduct.super.pricePerMonth(locale);
        }

        @Deprecated
        public static Price pricePerYear(StoreProduct storeProduct, Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            return StoreProduct.super.pricePerYear(locale);
        }

        @Deprecated
        public static String formattedPricePerMonth(StoreProduct storeProduct, Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            return StoreProduct.super.formattedPricePerMonth(locale);
        }
    }

    static /* synthetic */ Price pricePerDay$default(StoreProduct storeProduct, Locale locale, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pricePerDay");
        }
        if ((i & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return storeProduct.pricePerDay(locale);
    }

    default Price pricePerDay(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Period period = getPeriod();
        if (period != null) {
            return PriceExtensionsKt.pricePerDay(getPrice(), period, locale);
        }
        return null;
    }

    static /* synthetic */ Price pricePerWeek$default(StoreProduct storeProduct, Locale locale, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pricePerWeek");
        }
        if ((i & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return storeProduct.pricePerWeek(locale);
    }

    default Price pricePerWeek(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Period period = getPeriod();
        if (period != null) {
            return PriceExtensionsKt.pricePerWeek(getPrice(), period, locale);
        }
        return null;
    }

    static /* synthetic */ Price pricePerMonth$default(StoreProduct storeProduct, Locale locale, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pricePerMonth");
        }
        if ((i & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return storeProduct.pricePerMonth(locale);
    }

    default Price pricePerMonth(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Period period = getPeriod();
        if (period != null) {
            return PriceExtensionsKt.pricePerMonth(getPrice(), period, locale);
        }
        return null;
    }

    static /* synthetic */ Price pricePerYear$default(StoreProduct storeProduct, Locale locale, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pricePerYear");
        }
        if ((i & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return storeProduct.pricePerYear(locale);
    }

    default Price pricePerYear(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Period period = getPeriod();
        if (period != null) {
            return PriceExtensionsKt.pricePerYear(getPrice(), period, locale);
        }
        return null;
    }

    static /* synthetic */ String formattedPricePerMonth$default(StoreProduct storeProduct, Locale locale, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: formattedPricePerMonth");
        }
        if ((i & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return storeProduct.formattedPricePerMonth(locale);
    }

    default String formattedPricePerMonth(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Price pricePricePerMonth = pricePerMonth(locale);
        if (pricePricePerMonth != null) {
            return pricePricePerMonth.getFormatted();
        }
        return null;
    }
}
