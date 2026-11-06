package com.revenuecat.purchases.ui.revenuecatui.extensions;

import android.icu.text.MeasureFormat;
import android.icu.util.Measure;
import android.icu.util.MeasureUnit;
import com.revenuecat.purchases.models.Period;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001c\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0014\u0010\f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u001e\u0010\r\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000bH\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0010"}, d2 = {"measureUnit", "Landroid/icu/util/MeasureUnit;", "Lcom/revenuecat/purchases/models/Period$Unit;", "getMeasureUnit", "(Lcom/revenuecat/purchases/models/Period$Unit;)Landroid/icu/util/MeasureUnit;", "localized", "", "Lcom/revenuecat/purchases/models/Period;", "locale", "Ljava/util/Locale;", "width", "Landroid/icu/text/MeasureFormat$FormatWidth;", "localizedAbbreviatedPeriod", "localizedPeriod", "formatWidth", "localizedUnitPeriod", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class PeriodExtensionsKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Period.Unit.values().length];
            try {
                iArr[Period.Unit.DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Period.Unit.WEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Period.Unit.MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Period.Unit.YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Period.Unit.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ String localizedAbbreviatedPeriod(Period period, Locale locale) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return localized(period, locale, MeasureFormat.FormatWidth.SHORT);
    }

    public static final /* synthetic */ String localizedUnitPeriod(Period period, Locale locale) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return localized(period, locale, MeasureFormat.FormatWidth.WIDE);
    }

    public static /* synthetic */ String localizedPeriod$default(Period period, Locale locale, MeasureFormat.FormatWidth formatWidth, int i, Object obj) {
        if ((i & 2) != 0) {
            formatWidth = MeasureFormat.FormatWidth.WIDE;
        }
        return localizedPeriod(period, locale, formatWidth);
    }

    public static final /* synthetic */ String localizedPeriod(Period period, Locale locale, MeasureFormat.FormatWidth formatWidth) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(formatWidth, "formatWidth");
        String str = MeasureFormat.getInstance(locale, formatWidth).format(new Measure(Integer.valueOf(period.getValue()), getMeasureUnit(period.getUnit())));
        Intrinsics.checkNotNullExpressionValue(str, "getInstance(locale, form… unit.measureUnit),\n    )");
        return str;
    }

    public static final /* synthetic */ MeasureUnit getMeasureUnit(Period.Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[unit.ordinal()];
        if (i == 1) {
            return MeasureUnit.DAY;
        }
        if (i == 2) {
            return MeasureUnit.WEEK;
        }
        if (i == 3) {
            return MeasureUnit.MONTH;
        }
        if (i == 4) {
            return MeasureUnit.YEAR;
        }
        if (i == 5) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final String localized(Period period, Locale locale, MeasureFormat.FormatWidth formatWidth) {
        String strLocalizedPeriod = localizedPeriod(period, locale, formatWidth);
        if (period.getValue() != 1 || !StringsKt.startsWith$default(strLocalizedPeriod, "1", false, 2, (Object) null)) {
            return strLocalizedPeriod;
        }
        String strSubstring = strLocalizedPeriod.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return StringsKt.trim(strSubstring).toString();
    }
}
