package com.revenuecat.purchases.utils;

import com.facebook.imageutils.JfifUtil;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.common.OfferingParser;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.RecurrenceMode;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.TestStoreProduct;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u00062\u0006\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/utils/PreviewOfferingParser;", "Lcom/revenuecat/purchases/common/OfferingParser;", "()V", "findMatchingProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "productsById", "", "", "", "packageJson", "Lorg/json/JSONObject;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PreviewOfferingParser extends OfferingParser {

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
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.revenuecat.purchases.common.OfferingParser
    protected StoreProduct findMatchingProduct(Map<String, ? extends List<? extends StoreProduct>> productsById, JSONObject packageJson) throws JSONException {
        Intrinsics.checkNotNullParameter(productsById, "productsById");
        Intrinsics.checkNotNullParameter(packageJson, "packageJson");
        String string = packageJson.getString("identifier");
        for (PackageType packageType : PackageType.values()) {
            if (Intrinsics.areEqual(packageType.getIdentifier(), string)) {
                switch (WhenMappings.$EnumSwitchMapping$0[packageType.ordinal()]) {
                    case 1:
                        return new TestStoreProduct("com.revenuecat.lifetime_product", "Lifetime", "Lifetime (App name)", "Lifetime", new Price("$ 1,000.00", 1000000000L, "USD"), null, null, null, JfifUtil.MARKER_SOFn, null);
                    case 2:
                        return new TestStoreProduct("com.revenuecat.annual_product", "Annual", "Annual (App name)", "Annual", new Price("$ 67.99", 67990000L, "USD"), new Period(1, Period.Unit.YEAR, "P1Y"), new PricingPhase(new Period(1, Period.Unit.MONTH, "P1M"), RecurrenceMode.FINITE_RECURRING, 1, new Price("Free", 0L, "USD")), null, null, 384, null);
                    case 3:
                        return new TestStoreProduct("com.revenuecat.semester_product", "6 month", "6 month (App name)", "6 month", new Price("$ 39.99", 39990000L, "USD"), new Period(6, Period.Unit.MONTH, "P6M"), null, null, JfifUtil.MARKER_SOFn, null);
                    case 4:
                        Price price = new Price("$ 23.99", 23990000L, "USD");
                        Period.Unit unit = Period.Unit.MONTH;
                        Period period = new Period(3, unit, "P3M");
                        Period period2 = new Period(2, Period.Unit.WEEK, "P2W");
                        RecurrenceMode recurrenceMode = RecurrenceMode.FINITE_RECURRING;
                        return new TestStoreProduct("com.revenuecat.quarterly_product", "3 month", "3 month (App name)", "3 month", price, period, new PricingPhase(period2, recurrenceMode, 1, new Price("Free", 0L, "USD")), new PricingPhase(new Period(1, unit, "P1M"), recurrenceMode, 1, new Price("$ 3.99", 3990000L, "USD")), null, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, null);
                    case 5:
                        Price price2 = new Price("$ 15.99", 15990000L, "USD");
                        Period.Unit unit2 = Period.Unit.MONTH;
                        return new TestStoreProduct("com.revenuecat.bimonthly_product", "2 month", "2 month (App name)", "2 month", price2, new Period(2, unit2, "P2M"), null, new PricingPhase(new Period(1, unit2, "P1M"), RecurrenceMode.FINITE_RECURRING, 1, new Price("$ 3.99", 3990000L, "USD")), null, 320, null);
                    case 6:
                        return new TestStoreProduct("com.revenuecat.monthly_product", "Monthly", "Monthly (App name)", "Monthly", new Price("$ 7.99", 7990000L, "USD"), new Period(1, Period.Unit.MONTH, "P1M"), null, null, JfifUtil.MARKER_SOFn, null);
                    case 7:
                        return new TestStoreProduct("com.revenuecat.weekly_product", "Weekly", "Weekly (App name)", "Weekly", new Price("$ 1.49", 1490000L, "USD"), new Period(1, Period.Unit.WEEK, "P1W"), null, null, JfifUtil.MARKER_SOFn, null);
                    default:
                        return null;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }
}
