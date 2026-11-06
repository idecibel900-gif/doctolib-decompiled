package com.revenuecat.purchases.utils;

import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001c\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001c\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\f"}, d2 = {"pricePerDay", "Lcom/revenuecat/purchases/models/Price;", "billingPeriod", "Lcom/revenuecat/purchases/models/Period;", "locale", "Ljava/util/Locale;", "pricePerMonth", "pricePerPeriod", "units", "", "pricePerWeek", "pricePerYear", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PriceExtensionsKt {
    public static final /* synthetic */ Price pricePerDay(Price price, Period billingPeriod, Locale locale) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        Intrinsics.checkNotNullParameter(billingPeriod, "billingPeriod");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return pricePerPeriod(price, billingPeriod.getValueInDays(), locale);
    }

    public static final Price pricePerWeek(Price price, Period billingPeriod, Locale locale) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        Intrinsics.checkNotNullParameter(billingPeriod, "billingPeriod");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return pricePerPeriod(price, billingPeriod.getValueInWeeks(), locale);
    }

    public static final Price pricePerMonth(Price price, Period billingPeriod, Locale locale) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        Intrinsics.checkNotNullParameter(billingPeriod, "billingPeriod");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return pricePerPeriod(price, billingPeriod.getValueInMonths(), locale);
    }

    public static final Price pricePerYear(Price price, Period billingPeriod, Locale locale) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        Intrinsics.checkNotNullParameter(billingPeriod, "billingPeriod");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return pricePerPeriod(price, billingPeriod.getValueInYears(), locale);
    }

    private static final Price pricePerPeriod(Price price, double d, Locale locale) {
        return PriceFactory.INSTANCE.createPrice$purchases_defaultsBc8Release((long) (price.getAmountMicros() / d), price.getCurrencyCode(), locale);
    }
}
