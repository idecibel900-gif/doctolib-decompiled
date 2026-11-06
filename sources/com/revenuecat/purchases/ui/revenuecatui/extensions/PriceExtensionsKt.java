package com.revenuecat.purchases.ui.revenuecatui.extensions;

import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableDataProviderKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a$\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\n"}, d2 = {"localized", "", "Lcom/revenuecat/purchases/models/Price;", "locale", "Ljava/util/Locale;", "showZeroDecimalPlacePrices", "", "localizedPerPeriod", "period", "Lcom/revenuecat/purchases/models/Period;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class PriceExtensionsKt {
    public static final /* synthetic */ String localized(Price price, Locale locale, boolean z) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (z && VariableDataProviderKt.endsIn00Cents(price)) {
            return VariableDataProviderKt.getTruncatedFormatted(price, locale);
        }
        return VariableDataProviderKt.getFormatted(price, locale);
    }

    public static final /* synthetic */ String localizedPerPeriod(Price price, Period period, Locale locale, boolean z) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        Intrinsics.checkNotNullParameter(period, "period");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return localized(price, locale, z) + '/' + PeriodExtensionsKt.localizedAbbreviatedPeriod(period, locale);
    }
}
