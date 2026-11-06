package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\u001a%\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\u0006\u001aG\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001aA\u0010\u0015\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00132\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000fH\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a1\u0010\u0017\u001a\u0004\u0018\u00010\r*\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a1\u0010\u0019\u001a\u0004\u0018\u00010\r*\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0000¢\u0006\u0004\b\u0019\u0010\u0018\u001a1\u0010\u001a\u001a\u0004\u0018\u00010\r*\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0000¢\u0006\u0004\b\u001a\u0010\u0018\u001a1\u0010\u001b\u001a\u0004\u0018\u00010\r*\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0000¢\u0006\u0004\b\u001b\u0010\u0018\u001a1\u0010\u001c\u001a\u0004\u0018\u00010\r*\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0000¢\u0006\u0004\b\u001c\u0010\u0018\u001aM\u0010!\u001a\u0004\u0018\u00010\r*\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001f0\u0013H\u0000¢\u0006\u0004\b!\u0010\"\u001a)\u0010#\u001a\u0004\u0018\u00010\r*\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0000¢\u0006\u0004\b#\u0010$\u001a)\u0010%\u001a\u0004\u0018\u00010\r*\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0000¢\u0006\u0004\b%\u0010$\u001a1\u0010(\u001a\u0004\u0018\u00010\r*\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\r0\u0013H\u0000¢\u0006\u0004\b(\u0010)\u001a)\u0010*\u001a\u0004\u0018\u00010\r*\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0000¢\u0006\u0004\b*\u0010$\u001a%\u0010-\u001a\u0004\u0018\u00010\r*\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010,\u001a\u00020+H\u0000¢\u0006\u0004\b-\u0010.\u001a\u001b\u00100\u001a\u00020/*\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0000¢\u0006\u0004\b0\u00101\"\u001a\u00104\u001a\u0004\u0018\u00010\r*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u00103\"\u001a\u00106\u001a\u0004\u0018\u00010\r*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u00103\"\u001a\u00108\u001a\u0004\u0018\u00010\r*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b7\u00103\"\u001a\u0010:\u001a\u0004\u0018\u00010\r*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b9\u00103¨\u0006;"}, d2 = {"Lcom/revenuecat/purchases/models/SubscriptionOption;", "subscriptionOption", "Lcom/revenuecat/purchases/Package;", "rcPackage", "Lcom/revenuecat/purchases/models/PricingPhase;", "primaryDiscountPhase", "(Lcom/revenuecat/purchases/models/SubscriptionOption;Lcom/revenuecat/purchases/Package;)Lcom/revenuecat/purchases/models/PricingPhase;", "secondaryDiscountPhase", "discountPhase", "Ljava/util/Locale;", "locale", "", "Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKey;", "", "localizedVariableKeys", "Lkotlin/Function0;", "productFallback", "resolveOfferPrice", "(Lcom/revenuecat/purchases/models/PricingPhase;Ljava/util/Locale;Ljava/util/Map;Lkotlin/jvm/functions/Function0;)Ljava/lang/String;", "Lkotlin/Function1;", "discountValue", "resolveOfferPeriod", "(Lcom/revenuecat/purchases/models/PricingPhase;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/String;", "productOfferPrice", "(Lcom/revenuecat/purchases/models/PricingPhase;Ljava/util/Locale;Ljava/util/Map;)Ljava/lang/String;", "productOfferPricePerDay", "productOfferPricePerWeek", "productOfferPricePerMonth", "productOfferPricePerYear", "Lcom/revenuecat/purchases/models/Period$Unit;", "unit", "Lcom/revenuecat/purchases/models/Price;", "calculatePrice", "productOfferPricePerPeriod", "(Lcom/revenuecat/purchases/models/PricingPhase;Ljava/util/Locale;Ljava/util/Map;Lcom/revenuecat/purchases/models/Period$Unit;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "productOfferPeriod", "(Lcom/revenuecat/purchases/models/PricingPhase;Ljava/util/Map;)Ljava/lang/String;", "productOfferPeriodAbbreviated", "Lcom/revenuecat/purchases/models/Period;", "calculateValue", "productOfferPeriodInPeriodUnit", "(Lcom/revenuecat/purchases/models/PricingPhase;Lcom/revenuecat/purchases/models/Period$Unit;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "productOfferPeriodWithUnit", "Ljava/util/Date;", "date", "productOfferEndDate", "(Lcom/revenuecat/purchases/models/PricingPhase;Ljava/util/Locale;Ljava/util/Date;)Ljava/lang/String;", "", "canDisplay", "(Lcom/revenuecat/purchases/models/PricingPhase;Lcom/revenuecat/purchases/models/Period$Unit;)Z", "getProductOfferPeriodInDays", "(Lcom/revenuecat/purchases/models/PricingPhase;)Ljava/lang/String;", "productOfferPeriodInDays", "getProductOfferPeriodInWeeks", "productOfferPeriodInWeeks", "getProductOfferPeriodInMonths", "productOfferPeriodInMonths", "getProductOfferPeriodInYears", "productOfferPeriodInYears", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PricingPhaseExtensionsKt {
    public static final PricingPhase primaryDiscountPhase(SubscriptionOption subscriptionOption, Package r2) {
        StoreProduct product;
        if (subscriptionOption == null) {
            subscriptionOption = (r2 == null || (product = r2.getProduct()) == null) ? null : product.getDefaultOption();
        }
        if (subscriptionOption == null) {
            return null;
        }
        PricingPhase freePhase = subscriptionOption.getFreePhase();
        return freePhase == null ? subscriptionOption.getIntroPhase() : freePhase;
    }

    public static final PricingPhase secondaryDiscountPhase(SubscriptionOption subscriptionOption, Package r2) {
        StoreProduct product;
        if (subscriptionOption == null) {
            subscriptionOption = (r2 == null || (product = r2.getProduct()) == null) ? null : product.getDefaultOption();
        }
        if (subscriptionOption == null || subscriptionOption.getFreePhase() == null) {
            return null;
        }
        return subscriptionOption.getIntroPhase();
    }

    public static final String resolveOfferPrice(PricingPhase pricingPhase, Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys, Function0 productFallback) {
        String strProductOfferPrice;
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        Intrinsics.checkNotNullParameter(productFallback, "productFallback");
        return (pricingPhase == null || (strProductOfferPrice = productOfferPrice(pricingPhase, locale, localizedVariableKeys)) == null) ? (String) productFallback.invoke() : strProductOfferPrice;
    }

    public static final String resolveOfferPeriod(PricingPhase pricingPhase, Function1 discountValue, Function0 productFallback) {
        String str;
        Intrinsics.checkNotNullParameter(discountValue, "discountValue");
        Intrinsics.checkNotNullParameter(productFallback, "productFallback");
        return (pricingPhase == null || (str = (String) discountValue.invoke(pricingPhase)) == null) ? (String) productFallback.invoke() : str;
    }

    public static final String productOfferPrice(PricingPhase pricingPhase, Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        if (pricingPhase.getPrice().getAmountMicros() == 0) {
            return PackagePeriodExtensionsKt.getStringOrLogError(localizedVariableKeys, VariableLocalizationKey.FREE_PRICE);
        }
        return VariableDataProviderKt.getFormatted(pricingPhase.getPrice(), locale);
    }

    public static final String productOfferPricePerDay(PricingPhase pricingPhase, final Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        return productOfferPricePerPeriod(pricingPhase, locale, localizedVariableKeys, Period.Unit.DAY, new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt.productOfferPricePerDay.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Price invoke(PricingPhase productOfferPricePerPeriod) {
                Intrinsics.checkNotNullParameter(productOfferPricePerPeriod, "$this$productOfferPricePerPeriod");
                return productOfferPricePerPeriod.pricePerDay(locale);
            }
        });
    }

    public static final String productOfferPricePerWeek(PricingPhase pricingPhase, final Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        return productOfferPricePerPeriod(pricingPhase, locale, localizedVariableKeys, Period.Unit.WEEK, new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt.productOfferPricePerWeek.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Price invoke(PricingPhase productOfferPricePerPeriod) {
                Intrinsics.checkNotNullParameter(productOfferPricePerPeriod, "$this$productOfferPricePerPeriod");
                return productOfferPricePerPeriod.pricePerWeek(locale);
            }
        });
    }

    public static final String productOfferPricePerMonth(PricingPhase pricingPhase, final Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        return productOfferPricePerPeriod(pricingPhase, locale, localizedVariableKeys, Period.Unit.MONTH, new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt.productOfferPricePerMonth.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Price invoke(PricingPhase productOfferPricePerPeriod) {
                Intrinsics.checkNotNullParameter(productOfferPricePerPeriod, "$this$productOfferPricePerPeriod");
                return productOfferPricePerPeriod.pricePerMonth(locale);
            }
        });
    }

    public static final String productOfferPricePerYear(PricingPhase pricingPhase, final Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        return productOfferPricePerPeriod(pricingPhase, locale, localizedVariableKeys, Period.Unit.YEAR, new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt.productOfferPricePerYear.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Price invoke(PricingPhase productOfferPricePerPeriod) {
                Intrinsics.checkNotNullParameter(productOfferPricePerPeriod, "$this$productOfferPricePerPeriod");
                return productOfferPricePerPeriod.pricePerYear(locale);
            }
        });
    }

    public static final String productOfferPricePerPeriod(PricingPhase pricingPhase, Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys, Period.Unit unit, Function1 calculatePrice) {
        Price price;
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(calculatePrice, "calculatePrice");
        if (!canDisplay(pricingPhase, unit)) {
            pricingPhase = null;
        }
        if (pricingPhase == null || (price = (Price) calculatePrice.invoke(pricingPhase)) == null) {
            return null;
        }
        if (price.getAmountMicros() == 0) {
            return PackagePeriodExtensionsKt.getStringOrLogError(localizedVariableKeys, VariableLocalizationKey.FREE_PRICE);
        }
        return VariableDataProviderKt.getFormatted(price, locale);
    }

    public static final String productOfferPeriod(PricingPhase pricingPhase, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        VariableLocalizationKey periodUnitLocalizationKey = PeriodExtensionsKt.getPeriodUnitLocalizationKey(pricingPhase.getBillingPeriod());
        if (periodUnitLocalizationKey != null) {
            return PackagePeriodExtensionsKt.getStringOrLogError(localizedVariableKeys, periodUnitLocalizationKey);
        }
        return null;
    }

    public static final String productOfferPeriodAbbreviated(PricingPhase pricingPhase, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        VariableLocalizationKey periodUnitAbbreviatedLocalizationKey = PeriodExtensionsKt.getPeriodUnitAbbreviatedLocalizationKey(pricingPhase.getBillingPeriod());
        if (periodUnitAbbreviatedLocalizationKey != null) {
            return PackagePeriodExtensionsKt.getStringOrLogError(localizedVariableKeys, periodUnitAbbreviatedLocalizationKey);
        }
        return null;
    }

    public static final String productOfferPeriodInPeriodUnit(PricingPhase pricingPhase, Period.Unit unit, Function1 calculateValue) {
        Period billingPeriod;
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(calculateValue, "calculateValue");
        if (!canDisplay(pricingPhase, unit)) {
            pricingPhase = null;
        }
        if (pricingPhase == null || (billingPeriod = pricingPhase.getBillingPeriod()) == null) {
            return null;
        }
        return (String) calculateValue.invoke(billingPeriod);
    }

    public static final String getProductOfferPeriodInDays(PricingPhase pricingPhase) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        return productOfferPeriodInPeriodUnit(pricingPhase, Period.Unit.DAY, new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt$productOfferPeriodInDays$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Period productOfferPeriodInPeriodUnit) {
                Intrinsics.checkNotNullParameter(productOfferPeriodInPeriodUnit, "$this$productOfferPeriodInPeriodUnit");
                return PeriodExtensionsKt.getRoundedValueInDays(productOfferPeriodInPeriodUnit);
            }
        });
    }

    public static final String getProductOfferPeriodInWeeks(PricingPhase pricingPhase) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        return productOfferPeriodInPeriodUnit(pricingPhase, Period.Unit.WEEK, new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt$productOfferPeriodInWeeks$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Period productOfferPeriodInPeriodUnit) {
                Intrinsics.checkNotNullParameter(productOfferPeriodInPeriodUnit, "$this$productOfferPeriodInPeriodUnit");
                return PeriodExtensionsKt.getRoundedValueInWeeks(productOfferPeriodInPeriodUnit);
            }
        });
    }

    public static final String getProductOfferPeriodInMonths(PricingPhase pricingPhase) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        return productOfferPeriodInPeriodUnit(pricingPhase, Period.Unit.MONTH, new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt$productOfferPeriodInMonths$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Period productOfferPeriodInPeriodUnit) {
                Intrinsics.checkNotNullParameter(productOfferPeriodInPeriodUnit, "$this$productOfferPeriodInPeriodUnit");
                return PeriodExtensionsKt.getRoundedValueInMonths(productOfferPeriodInPeriodUnit);
            }
        });
    }

    public static final String getProductOfferPeriodInYears(PricingPhase pricingPhase) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        return productOfferPeriodInPeriodUnit(pricingPhase, Period.Unit.YEAR, new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt$productOfferPeriodInYears$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Period productOfferPeriodInPeriodUnit) {
                Intrinsics.checkNotNullParameter(productOfferPeriodInPeriodUnit, "$this$productOfferPeriodInPeriodUnit");
                return PeriodExtensionsKt.getRoundedValueInYears(productOfferPeriodInPeriodUnit);
            }
        });
    }

    public static final String productOfferPeriodWithUnit(PricingPhase pricingPhase, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        String stringOrLogError = PackagePeriodExtensionsKt.getStringOrLogError(localizedVariableKeys, PeriodExtensionsKt.getPeriodValueWithUnitLocalizationKey(pricingPhase.getBillingPeriod()));
        if (stringOrLogError == null) {
            return null;
        }
        String str = String.format(stringOrLogError, Arrays.copyOf(new Object[]{Integer.valueOf(pricingPhase.getBillingPeriod().getValue())}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final String productOfferEndDate(PricingPhase pricingPhase, Locale locale, Date date) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(date, "date");
        Calendar calendar = Calendar.getInstance(locale);
        calendar.setTime(date);
        calendar.add(6, MathKt.roundToInt(pricingPhase.getBillingPeriod().getValueInDays()));
        return DateFormat.getDateInstance(1, locale).format(calendar.getTime());
    }

    public static final boolean canDisplay(PricingPhase pricingPhase, Period.Unit unit) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return unit.ordinal() <= pricingPhase.getBillingPeriod().getUnit().ordinal();
    }
}
