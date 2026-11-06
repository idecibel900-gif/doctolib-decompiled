package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\t\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004\"\u001e\u0010\t\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\u0004\"\u0018\u0010\r\u001a\u00020\u000e*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0018\u0010\u0011\u001a\u00020\u000e*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010\"\u0018\u0010\u0013\u001a\u00020\u000e*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010\"\u0018\u0010\u0015\u001a\u00020\u000e*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010¨\u0006\u0017"}, d2 = {"periodUnitAbbreviatedLocalizationKey", "Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKey;", "Lcom/revenuecat/purchases/models/Period;", "getPeriodUnitAbbreviatedLocalizationKey", "(Lcom/revenuecat/purchases/models/Period;)Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKey;", "periodUnitLocalizationKey", "getPeriodUnitLocalizationKey", "periodValueWithUnitAbbreviatedLocalizationKey", "getPeriodValueWithUnitAbbreviatedLocalizationKey", "periodValueWithUnitLocalizationKey", "getPeriodValueWithUnitLocalizationKey$annotations", "(Lcom/revenuecat/purchases/models/Period;)V", "getPeriodValueWithUnitLocalizationKey", "roundedValueInDays", "", "getRoundedValueInDays", "(Lcom/revenuecat/purchases/models/Period;)Ljava/lang/String;", "roundedValueInMonths", "getRoundedValueInMonths", "roundedValueInWeeks", "getRoundedValueInWeeks", "roundedValueInYears", "getRoundedValueInYears", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PeriodExtensionsKt {

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

    public static /* synthetic */ void getPeriodValueWithUnitLocalizationKey$annotations(Period period) {
    }

    public static final VariableLocalizationKey getPeriodUnitLocalizationKey(Period period) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[period.getUnit().ordinal()];
        if (i == 1) {
            return VariableLocalizationKey.DAY;
        }
        if (i == 2) {
            return VariableLocalizationKey.WEEK;
        }
        if (i == 3) {
            return VariableLocalizationKey.MONTH;
        }
        if (i == 4) {
            return VariableLocalizationKey.YEAR;
        }
        if (i == 5) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final VariableLocalizationKey getPeriodUnitAbbreviatedLocalizationKey(Period period) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[period.getUnit().ordinal()];
        if (i == 1) {
            return VariableLocalizationKey.DAY_SHORT;
        }
        if (i == 2) {
            return VariableLocalizationKey.WEEK_SHORT;
        }
        if (i == 3) {
            return VariableLocalizationKey.MONTH_SHORT;
        }
        if (i == 4) {
            return VariableLocalizationKey.YEAR_SHORT;
        }
        if (i == 5) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final VariableLocalizationKey getPeriodValueWithUnitLocalizationKey(Period period) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        if (period.getValue() == 0 && period.getUnit() == Period.Unit.DAY) {
            return VariableLocalizationKey.NUM_DAY_ZERO;
        }
        if (period.getValue() == 0 && period.getUnit() == Period.Unit.WEEK) {
            return VariableLocalizationKey.NUM_WEEK_ZERO;
        }
        if (period.getValue() == 0 && period.getUnit() == Period.Unit.MONTH) {
            return VariableLocalizationKey.NUM_MONTH_ZERO;
        }
        if (period.getValue() == 0 && period.getUnit() == Period.Unit.YEAR) {
            return VariableLocalizationKey.NUM_YEAR_ZERO;
        }
        if (period.getValue() == 1 && period.getUnit() == Period.Unit.DAY) {
            return VariableLocalizationKey.NUM_DAY_ONE;
        }
        if (period.getValue() == 1 && period.getUnit() == Period.Unit.WEEK) {
            return VariableLocalizationKey.NUM_WEEK_ONE;
        }
        if (period.getValue() == 1 && period.getUnit() == Period.Unit.MONTH) {
            return VariableLocalizationKey.NUM_MONTH_ONE;
        }
        if (period.getValue() == 1 && period.getUnit() == Period.Unit.YEAR) {
            return VariableLocalizationKey.NUM_YEAR_ONE;
        }
        if (period.getValue() == 2 && period.getUnit() == Period.Unit.DAY) {
            return VariableLocalizationKey.NUM_DAY_TWO;
        }
        if (period.getValue() == 2 && period.getUnit() == Period.Unit.WEEK) {
            return VariableLocalizationKey.NUM_WEEK_TWO;
        }
        if (period.getValue() == 2 && period.getUnit() == Period.Unit.MONTH) {
            return VariableLocalizationKey.NUM_MONTH_TWO;
        }
        if (period.getValue() == 2 && period.getUnit() == Period.Unit.YEAR) {
            return VariableLocalizationKey.NUM_YEAR_TWO;
        }
        int value = period.getValue();
        if (3 <= value && value < 5 && period.getUnit() == Period.Unit.DAY) {
            return VariableLocalizationKey.NUM_DAY_FEW;
        }
        int value2 = period.getValue();
        if (3 <= value2 && value2 < 5 && period.getUnit() == Period.Unit.WEEK) {
            return VariableLocalizationKey.NUM_WEEK_FEW;
        }
        int value3 = period.getValue();
        if (3 <= value3 && value3 < 5 && period.getUnit() == Period.Unit.MONTH) {
            return VariableLocalizationKey.NUM_MONTH_FEW;
        }
        int value4 = period.getValue();
        if (3 <= value4 && value4 < 5 && period.getUnit() == Period.Unit.YEAR) {
            return VariableLocalizationKey.NUM_YEAR_FEW;
        }
        int value5 = period.getValue();
        if (5 <= value5 && value5 < 11 && period.getUnit() == Period.Unit.DAY) {
            return VariableLocalizationKey.NUM_DAY_MANY;
        }
        int value6 = period.getValue();
        if (5 <= value6 && value6 < 11 && period.getUnit() == Period.Unit.WEEK) {
            return VariableLocalizationKey.NUM_WEEK_MANY;
        }
        int value7 = period.getValue();
        if (5 <= value7 && value7 < 11 && period.getUnit() == Period.Unit.MONTH) {
            return VariableLocalizationKey.NUM_MONTH_MANY;
        }
        int value8 = period.getValue();
        if (5 <= value8 && value8 < 11 && period.getUnit() == Period.Unit.YEAR) {
            return VariableLocalizationKey.NUM_YEAR_MANY;
        }
        if (period.getUnit() == Period.Unit.DAY) {
            return VariableLocalizationKey.NUM_DAY_OTHER;
        }
        if (period.getUnit() == Period.Unit.WEEK) {
            return VariableLocalizationKey.NUM_WEEK_OTHER;
        }
        if (period.getUnit() == Period.Unit.MONTH) {
            return VariableLocalizationKey.NUM_MONTH_OTHER;
        }
        return period.getUnit() == Period.Unit.YEAR ? VariableLocalizationKey.NUM_YEAR_OTHER : VariableLocalizationKey.NUM_DAY_OTHER;
    }

    public static final VariableLocalizationKey getPeriodValueWithUnitAbbreviatedLocalizationKey(Period period) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[period.getUnit().ordinal()];
        if (i == 1) {
            return VariableLocalizationKey.NUM_DAYS_SHORT;
        }
        if (i == 2) {
            return VariableLocalizationKey.NUM_WEEKS_SHORT;
        }
        if (i == 3) {
            return VariableLocalizationKey.NUM_MONTHS_SHORT;
        }
        if (i == 4) {
            return VariableLocalizationKey.NUM_YEARS_SHORT;
        }
        if (i == 5) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String getRoundedValueInDays(Period period) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        return String.valueOf(MathKt.roundToInt(period.getValueInDays()));
    }

    public static final String getRoundedValueInWeeks(Period period) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        return String.valueOf(MathKt.roundToInt(period.getValueInWeeks()));
    }

    public static final String getRoundedValueInMonths(Period period) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        return String.valueOf(MathKt.roundToInt(period.getValueInMonths()));
    }

    public static final String getRoundedValueInYears(Period period) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        return String.valueOf(MathKt.roundToInt(period.getValueInYears()));
    }
}
