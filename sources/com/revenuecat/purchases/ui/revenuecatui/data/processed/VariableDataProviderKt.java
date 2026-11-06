package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0016\u0010\t\u001a\u00020\u0006*\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0016\u0010\n\u001a\u0004\u0018\u00010\u0006*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u001d\u0010\n\u001a\u0004\u0018\u00010\u0006*\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010\u000f\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0011H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"MICRO_MULTIPLIER", "", "endsIn00Cents", "", "Lcom/revenuecat/purchases/models/Price;", "getFormatted", "", "locale", "Ljava/util/Locale;", "getTruncatedFormatted", "localizedDiscount", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "resourceProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "discountRelativeToMostExpensivePerMonth", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;Ljava/lang/Double;)Ljava/lang/String;", "normalizedMonths", "Lcom/revenuecat/purchases/models/Period;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class VariableDataProviderKt {
    private static final double MICRO_MULTIPLIER = 1000000.0d;

    public static final String localizedDiscount(TemplateConfiguration.PackageInfo packageInfo, ResourceProvider resourceProvider) {
        Intrinsics.checkNotNullParameter(packageInfo, "<this>");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        return localizedDiscount(resourceProvider, packageInfo.getDiscountRelativeToMostExpensivePerMonth());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String localizedDiscount(ResourceProvider resourceProvider, Double d) {
        if (d == null) {
            return null;
        }
        return resourceProvider.getString(R.string.package_discount, Integer.valueOf(MathKt.roundToInt(d.doubleValue() * 100.0d)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Period normalizedMonths(Period period) {
        if (period.getUnit() != Period.Unit.YEAR) {
            return period;
        }
        int value = period.getValue() * 12;
        Period.Unit unit = Period.Unit.MONTH;
        StringBuilder sb = new StringBuilder();
        sb.append('P');
        sb.append(value);
        sb.append('M');
        return new Period(value, unit, sb.toString());
    }

    public static final boolean endsIn00Cents(Price price) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        double d = 100;
        return ((((double) Math.round((((double) price.getAmountMicros()) / 1000000.0d) * d)) / 100.0d) * d) % d == 0.0d;
    }

    public static /* synthetic */ String getFormatted$default(Price price, Locale locale, int i, Object obj) {
        if ((i & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return getFormatted(price, locale);
    }

    public static final String getFormatted(Price price, Locale locale) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Currency currency = Currency.getInstance(price.getCurrencyCode());
        int iCoerceAtLeast = RangesKt.coerceAtLeast(currency.getDefaultFractionDigits(), 0);
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
        currencyInstance.setCurrency(currency);
        currencyInstance.setMaximumFractionDigits(iCoerceAtLeast);
        currencyInstance.setMinimumFractionDigits(iCoerceAtLeast);
        String str = currencyInstance.format(BigDecimal.valueOf(price.getAmountMicros()).divide(BigDecimal.valueOf(1000000L), iCoerceAtLeast, RoundingMode.DOWN));
        Intrinsics.checkNotNullExpressionValue(str, "numberFormat.format(amount)");
        return str;
    }

    public static /* synthetic */ String getTruncatedFormatted$default(Price price, Locale locale, int i, Object obj) {
        if ((i & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return getTruncatedFormatted(price, locale);
    }

    public static final String getTruncatedFormatted(Price price, Locale locale) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
        currencyInstance.setCurrency(Currency.getInstance(price.getCurrencyCode()));
        currencyInstance.setMaximumFractionDigits(0);
        String str = currencyInstance.format(price.getAmountMicros() / 1000000.0d);
        Intrinsics.checkNotNullExpressionValue(str, "numberFormat.format(amount)");
        return str;
    }
}
