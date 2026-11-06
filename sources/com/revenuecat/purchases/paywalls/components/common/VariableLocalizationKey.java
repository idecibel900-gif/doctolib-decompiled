package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b1\b\u0087\u0001\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0¨\u00062"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKey;", "", "(Ljava/lang/String;I)V", "DAY", "DAILY", "DAY_SHORT", "WEEK", "WEEKLY", "WEEK_SHORT", "MONTH", "MONTHLY", "MONTH_SHORT", "YEAR", "YEARLY", "YEAR_SHORT", "ANNUAL", "ANNUALLY", "ANNUAL_SHORT", "LIFETIME", "FREE_PRICE", "PERCENT", "NUM_DAY_ZERO", "NUM_DAY_ONE", "NUM_DAY_TWO", "NUM_DAY_FEW", "NUM_DAY_MANY", "NUM_DAY_OTHER", "NUM_WEEK_ZERO", "NUM_WEEK_ONE", "NUM_WEEK_TWO", "NUM_WEEK_FEW", "NUM_WEEK_MANY", "NUM_WEEK_OTHER", "NUM_MONTH_ZERO", "NUM_MONTH_ONE", "NUM_MONTH_TWO", "NUM_MONTH_FEW", "NUM_MONTH_MANY", "NUM_MONTH_OTHER", "NUM_YEAR_ZERO", "NUM_YEAR_ONE", "NUM_YEAR_TWO", "NUM_YEAR_FEW", "NUM_YEAR_MANY", "NUM_YEAR_OTHER", "NUM_DAYS_SHORT", "NUM_WEEKS_SHORT", "NUM_MONTHS_SHORT", "NUM_YEARS_SHORT", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum VariableLocalizationKey {
    DAY,
    DAILY,
    DAY_SHORT,
    WEEK,
    WEEKLY,
    WEEK_SHORT,
    MONTH,
    MONTHLY,
    MONTH_SHORT,
    YEAR,
    YEARLY,
    YEAR_SHORT,
    ANNUAL,
    ANNUALLY,
    ANNUAL_SHORT,
    LIFETIME,
    FREE_PRICE,
    PERCENT,
    NUM_DAY_ZERO,
    NUM_DAY_ONE,
    NUM_DAY_TWO,
    NUM_DAY_FEW,
    NUM_DAY_MANY,
    NUM_DAY_OTHER,
    NUM_WEEK_ZERO,
    NUM_WEEK_ONE,
    NUM_WEEK_TWO,
    NUM_WEEK_FEW,
    NUM_WEEK_MANY,
    NUM_WEEK_OTHER,
    NUM_MONTH_ZERO,
    NUM_MONTH_ONE,
    NUM_MONTH_TWO,
    NUM_MONTH_FEW,
    NUM_MONTH_MANY,
    NUM_MONTH_OTHER,
    NUM_YEAR_ZERO,
    NUM_YEAR_ONE,
    NUM_YEAR_TWO,
    NUM_YEAR_FEW,
    NUM_YEAR_MANY,
    NUM_YEAR_OTHER,
    NUM_DAYS_SHORT,
    NUM_WEEKS_SHORT,
    NUM_MONTHS_SHORT,
    NUM_YEARS_SHORT;


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey.Companion.1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer invoke() {
            return EnumsKt.createAnnotatedEnumSerializer("com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey", VariableLocalizationKey.values(), new String[]{"day", "daily", "day_short", "week", "weekly", "week_short", "month", "monthly", "month_short", "year", "yearly", "year_short", "annual", "annually", "annual_short", "lifetime", "free_price", "percent", "num_day_zero", "num_day_one", "num_day_two", "num_day_few", "num_day_many", "num_day_other", "num_week_zero", "num_week_one", "num_week_two", "num_week_few", "num_week_many", "num_week_other", "num_month_zero", "num_month_one", "num_month_two", "num_month_few", "num_month_many", "num_month_other", "num_year_zero", "num_year_one", "num_year_two", "num_year_few", "num_year_many", "num_year_other", "num_days_short", "num_weeks_short", "num_months_short", "num_years_short"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, null);
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKey$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKey;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) VariableLocalizationKey.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer serializer() {
            return get$cachedSerializer();
        }
    }
}
