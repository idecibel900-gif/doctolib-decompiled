package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PackageExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PriceExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0005J\u001e\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0005J\u001e\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0005J\u001e\u0010\u0017\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0005J \u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0005J \u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0005J\u001e\u0010\u001a\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0005J\u001e\u0010\u001b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0005J \u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0005J \u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0005J\u0017\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0002\u0010!J \u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0005J\u0018\u0010#\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010$\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010%\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010&\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010'\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010(\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010)\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;", "", "resourceProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "preview", "", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;Z)V", "applicationName", "", "getApplicationName", "()Ljava/lang/String;", "firstIntroductoryOfferDuration", "rcPackage", "Lcom/revenuecat/purchases/Package;", "locale", "Ljava/util/Locale;", "getFirstIntroOfferToApply", "Lcom/revenuecat/purchases/models/PricingPhase;", "getSecondIntroOfferToApply", "localizedFirstIntroductoryOfferPrice", "showZeroDecimalPlacePrices", "localizedPrice", "localizedPriceAndPerMonth", "localizedPriceAndPerMonthFull", "localizedPricePerDay", "localizedPricePerMonth", "localizedPricePerPeriod", "localizedPricePerPeriodFull", "localizedPricePerWeek", "localizedPricePerYear", "localizedRelativeDiscount", "discountRelativeToMostExpensivePerMonth", "", "(Ljava/lang/Double;)Ljava/lang/String;", "localizedSecondIntroductoryOfferPrice", "periodLength", "periodName", "periodNameAbbreviation", "productName", "secondIntroductoryOfferDuration", "subscriptionDuration", "subscriptionDurationInMonths", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VariableDataProvider {
    public static final int $stable = 8;
    private final boolean preview;
    private final ResourceProvider resourceProvider;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PackageType.values().length];
            try {
                iArr[PackageType.LIFETIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PackageType.ANNUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PackageType.SIX_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PackageType.THREE_MONTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PackageType.TWO_MONTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PackageType.MONTHLY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PackageType.WEEKLY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PackageType.UNKNOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PackageType.CUSTOM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public VariableDataProvider(ResourceProvider resourceProvider, boolean z) {
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        this.resourceProvider = resourceProvider;
        this.preview = z;
    }

    public /* synthetic */ VariableDataProvider(ResourceProvider resourceProvider, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(resourceProvider, (i & 2) != 0 ? false : z);
    }

    public final String getApplicationName() {
        if (!this.preview) {
            return this.resourceProvider.getApplicationName();
        }
        return "Application Name";
    }

    public final String localizedPrice(Package rcPackage, Locale locale, boolean showZeroDecimalPlacePrices) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return PriceExtensionsKt.localized(rcPackage.getProduct().getPrice(), locale, showZeroDecimalPlacePrices);
    }

    public final String localizedPricePerDay(Package rcPackage, Locale locale, boolean showZeroDecimalPlacePrices) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Price pricePricePerDay = rcPackage.getProduct().pricePerDay(locale);
        if (pricePricePerDay == null) {
            return null;
        }
        if (showZeroDecimalPlacePrices && VariableDataProviderKt.endsIn00Cents(pricePricePerDay)) {
            return VariableDataProviderKt.getTruncatedFormatted(pricePricePerDay, locale);
        }
        return VariableDataProviderKt.getFormatted(pricePricePerDay, locale);
    }

    public final String localizedPricePerWeek(Package rcPackage, Locale locale, boolean showZeroDecimalPlacePrices) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Price pricePricePerWeek = rcPackage.getProduct().pricePerWeek(locale);
        if (pricePricePerWeek == null) {
            return null;
        }
        if (showZeroDecimalPlacePrices && VariableDataProviderKt.endsIn00Cents(pricePricePerWeek)) {
            return VariableDataProviderKt.getTruncatedFormatted(pricePricePerWeek, locale);
        }
        return VariableDataProviderKt.getFormatted(pricePricePerWeek, locale);
    }

    public final String localizedPricePerMonth(Package rcPackage, Locale locale, boolean showZeroDecimalPlacePrices) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Price pricePricePerMonth = rcPackage.getProduct().pricePerMonth(locale);
        if (pricePricePerMonth == null) {
            return null;
        }
        if (showZeroDecimalPlacePrices && VariableDataProviderKt.endsIn00Cents(pricePricePerMonth)) {
            return VariableDataProviderKt.getTruncatedFormatted(pricePricePerMonth, locale);
        }
        return VariableDataProviderKt.getFormatted(pricePricePerMonth, locale);
    }

    public final String localizedPricePerYear(Package rcPackage, Locale locale, boolean showZeroDecimalPlacePrices) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Price pricePricePerYear = rcPackage.getProduct().pricePerYear(locale);
        if (pricePricePerYear == null) {
            return null;
        }
        if (showZeroDecimalPlacePrices && VariableDataProviderKt.endsIn00Cents(pricePricePerYear)) {
            return VariableDataProviderKt.getTruncatedFormatted(pricePricePerYear, locale);
        }
        return VariableDataProviderKt.getFormatted(pricePricePerYear, locale);
    }

    public final String localizedFirstIntroductoryOfferPrice(Package rcPackage, Locale locale, boolean showZeroDecimalPlacePrices) {
        Price price;
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        PricingPhase firstIntroOfferToApply = getFirstIntroOfferToApply(rcPackage);
        if (firstIntroOfferToApply == null || (price = firstIntroOfferToApply.getPrice()) == null) {
            return null;
        }
        if (price.getAmountMicros() == 0) {
            return price.getFormatted();
        }
        if (showZeroDecimalPlacePrices && VariableDataProviderKt.endsIn00Cents(price)) {
            return VariableDataProviderKt.getTruncatedFormatted(price, locale);
        }
        return VariableDataProviderKt.getFormatted(price, locale);
    }

    public final String localizedSecondIntroductoryOfferPrice(Package rcPackage, Locale locale, boolean showZeroDecimalPlacePrices) {
        Price price;
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        PricingPhase secondIntroOfferToApply = getSecondIntroOfferToApply(rcPackage);
        if (secondIntroOfferToApply == null || (price = secondIntroOfferToApply.getPrice()) == null) {
            return null;
        }
        if (price.getAmountMicros() == 0) {
            return price.getFormatted();
        }
        if (showZeroDecimalPlacePrices && VariableDataProviderKt.endsIn00Cents(price)) {
            return VariableDataProviderKt.getTruncatedFormatted(price, locale);
        }
        return VariableDataProviderKt.getFormatted(price, locale);
    }

    public final String productName(Package rcPackage) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        return rcPackage.getProduct().getName();
    }

    public final String periodName(Package rcPackage) {
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        if (rcPackage.getPackageType() == PackageType.CUSTOM || rcPackage.getPackageType() == PackageType.UNKNOWN) {
            return rcPackage.getIdentifier();
        }
        switch (WhenMappings.$EnumSwitchMapping$0[rcPackage.getPackageType().ordinal()]) {
            case 1:
                numValueOf = Integer.valueOf(R.string.lifetime);
                break;
            case 2:
                numValueOf = Integer.valueOf(R.string.annual);
                break;
            case 3:
                numValueOf = Integer.valueOf(R.string.semester);
                break;
            case 4:
                numValueOf = Integer.valueOf(R.string.quarter);
                break;
            case 5:
                numValueOf = Integer.valueOf(R.string.bimonthly);
                break;
            case 6:
                numValueOf = Integer.valueOf(R.string.monthly);
                break;
            case 7:
                numValueOf = Integer.valueOf(R.string.weekly);
                break;
            case 8:
            case 9:
                numValueOf = null;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (numValueOf == null) {
            return null;
        }
        return this.resourceProvider.getString(numValueOf.intValue(), new Object[0]);
    }

    public final String periodLength(Package rcPackage, Locale locale) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Period period = rcPackage.getProduct().getPeriod();
        if (period != null) {
            return com.revenuecat.purchases.ui.revenuecatui.extensions.PeriodExtensionsKt.localizedUnitPeriod(period, locale);
        }
        return null;
    }

    public final String periodNameAbbreviation(Package rcPackage, Locale locale) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Period period = rcPackage.getProduct().getPeriod();
        if (period != null) {
            return com.revenuecat.purchases.ui.revenuecatui.extensions.PeriodExtensionsKt.localizedAbbreviatedPeriod(period, locale);
        }
        return null;
    }

    public final String subscriptionDuration(Package rcPackage, Locale locale) {
        String strLocalizedPeriod$default;
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Period period = rcPackage.getProduct().getPeriod();
        return (period == null || (strLocalizedPeriod$default = com.revenuecat.purchases.ui.revenuecatui.extensions.PeriodExtensionsKt.localizedPeriod$default(period, locale, null, 2, null)) == null) ? periodName(rcPackage) : strLocalizedPeriod$default;
    }

    public final String subscriptionDurationInMonths(Package rcPackage, Locale locale) {
        Period periodNormalizedMonths;
        String strLocalizedPeriod$default;
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Period period = rcPackage.getProduct().getPeriod();
        return (period == null || (periodNormalizedMonths = VariableDataProviderKt.normalizedMonths(period)) == null || (strLocalizedPeriod$default = com.revenuecat.purchases.ui.revenuecatui.extensions.PeriodExtensionsKt.localizedPeriod$default(periodNormalizedMonths, locale, null, 2, null)) == null) ? periodName(rcPackage) : strLocalizedPeriod$default;
    }

    public final String firstIntroductoryOfferDuration(Package rcPackage, Locale locale) {
        Period billingPeriod;
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        PricingPhase firstIntroOfferToApply = getFirstIntroOfferToApply(rcPackage);
        if (firstIntroOfferToApply == null || (billingPeriod = firstIntroOfferToApply.getBillingPeriod()) == null) {
            return null;
        }
        return com.revenuecat.purchases.ui.revenuecatui.extensions.PeriodExtensionsKt.localizedPeriod$default(billingPeriod, locale, null, 2, null);
    }

    public final String secondIntroductoryOfferDuration(Package rcPackage, Locale locale) {
        Period billingPeriod;
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        PricingPhase secondIntroOfferToApply = getSecondIntroOfferToApply(rcPackage);
        if (secondIntroOfferToApply == null || (billingPeriod = secondIntroOfferToApply.getBillingPeriod()) == null) {
            return null;
        }
        return com.revenuecat.purchases.ui.revenuecatui.extensions.PeriodExtensionsKt.localizedPeriod$default(billingPeriod, locale, null, 2, null);
    }

    public final String localizedPricePerPeriod(Package rcPackage, Locale locale, boolean showZeroDecimalPlacePrices) {
        String strLocalizedPerPeriod;
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        StoreProduct product = rcPackage.getProduct();
        Period period = product.getPeriod();
        return (period == null || (strLocalizedPerPeriod = PriceExtensionsKt.localizedPerPeriod(product.getPrice(), period, locale, showZeroDecimalPlacePrices)) == null) ? PriceExtensionsKt.localized(product.getPrice(), locale, showZeroDecimalPlacePrices) : strLocalizedPerPeriod;
    }

    public final String localizedPricePerPeriodFull(Package rcPackage, Locale locale, boolean showZeroDecimalPlacePrices) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        StoreProduct product = rcPackage.getProduct();
        String strLocalized = PriceExtensionsKt.localized(product.getPrice(), locale, showZeroDecimalPlacePrices);
        Period period = product.getPeriod();
        if (period != null) {
            String str = strLocalized + '/' + com.revenuecat.purchases.ui.revenuecatui.extensions.PeriodExtensionsKt.localizedUnitPeriod(period, locale);
            if (str != null) {
                return str;
            }
        }
        return strLocalized;
    }

    public final String localizedPriceAndPerMonth(Package rcPackage, Locale locale, boolean showZeroDecimalPlacePrices) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (!PackageExtensionsKt.isSubscription(rcPackage) || PackageExtensionsKt.isMonthly(rcPackage)) {
            return localizedPricePerPeriod(rcPackage, locale, showZeroDecimalPlacePrices);
        }
        String strLocalizedAbbreviatedPeriod = com.revenuecat.purchases.ui.revenuecatui.extensions.PeriodExtensionsKt.localizedAbbreviatedPeriod(new Period(1, Period.Unit.MONTH, "P1M"), locale);
        return localizedPricePerPeriod(rcPackage, locale, showZeroDecimalPlacePrices) + " (" + localizedPricePerMonth(rcPackage, locale, showZeroDecimalPlacePrices) + '/' + strLocalizedAbbreviatedPeriod + ')';
    }

    public final String localizedPriceAndPerMonthFull(Package rcPackage, Locale locale, boolean showZeroDecimalPlacePrices) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (!PackageExtensionsKt.isSubscription(rcPackage) || PackageExtensionsKt.isMonthly(rcPackage)) {
            return localizedPricePerPeriodFull(rcPackage, locale, showZeroDecimalPlacePrices);
        }
        String strLocalizedUnitPeriod = com.revenuecat.purchases.ui.revenuecatui.extensions.PeriodExtensionsKt.localizedUnitPeriod(new Period(1, Period.Unit.MONTH, "P1M"), locale);
        return localizedPricePerPeriodFull(rcPackage, locale, showZeroDecimalPlacePrices) + " (" + localizedPricePerMonth(rcPackage, locale, showZeroDecimalPlacePrices) + '/' + strLocalizedUnitPeriod + ')';
    }

    public final String localizedRelativeDiscount(Double discountRelativeToMostExpensivePerMonth) {
        return VariableDataProviderKt.localizedDiscount(this.resourceProvider, discountRelativeToMostExpensivePerMonth);
    }

    private final PricingPhase getFirstIntroOfferToApply(Package rcPackage) {
        PricingPhase freePhase;
        SubscriptionOption defaultOption = rcPackage.getProduct().getDefaultOption();
        if (defaultOption != null && (freePhase = defaultOption.getFreePhase()) != null) {
            return freePhase;
        }
        if (defaultOption != null) {
            return defaultOption.getIntroPhase();
        }
        return null;
    }

    private final PricingPhase getSecondIntroOfferToApply(Package rcPackage) {
        SubscriptionOption defaultOption = rcPackage.getProduct().getDefaultOption();
        if ((defaultOption != null ? defaultOption.getFreePhase() : null) != null) {
            return defaultOption.getIntroPhase();
        }
        return null;
    }
}
