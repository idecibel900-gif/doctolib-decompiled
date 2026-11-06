package com.revenuecat.purchases.utils;

import com.revenuecat.purchases.models.Price;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/utils/PriceFactory;", "", "()V", "createPrice", "Lcom/revenuecat/purchases/models/Price;", "amountMicros", "", "currencyCode", "", "locale", "Ljava/util/Locale;", "createPrice$purchases_defaultsBc8Release", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PriceFactory {
    public static final PriceFactory INSTANCE = new PriceFactory();

    private PriceFactory() {
    }

    public final /* synthetic */ Price createPrice$purchases_defaultsBc8Release(long amountMicros, String currencyCode, Locale locale) {
        Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Currency currency = Currency.getInstance(currencyCode);
        int iCoerceAtLeast = RangesKt.coerceAtLeast(currency.getDefaultFractionDigits(), 0);
        double dRoundToDecimalPlaces = DoubleExtensionsKt.roundToDecimalPlaces(amountMicros / 1000000.0d, iCoerceAtLeast);
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
        currencyInstance.setCurrency(currency);
        currencyInstance.setMaximumFractionDigits(iCoerceAtLeast);
        currencyInstance.setMinimumFractionDigits(iCoerceAtLeast);
        String formatted = currencyInstance.format(dRoundToDecimalPlaces);
        Intrinsics.checkNotNullExpressionValue(formatted, "formatted");
        return new Price(formatted, amountMicros, currencyCode);
    }
}
