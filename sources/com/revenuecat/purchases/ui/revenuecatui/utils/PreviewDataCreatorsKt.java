package com.revenuecat.purchases.ui.revenuecatui.utils;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.models.InstallmentsInfo;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.RecurrenceMode;
import com.revenuecat.purchases.models.RecurrenceModeKt;
import com.revenuecat.purchases.models.SubscriptionOption;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aA\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0002\u0010\u000b\u001aJ\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00032\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0000¨\u0006\u0017"}, d2 = {"previewPricingPhase", "Lcom/revenuecat/purchases/models/PricingPhase;", "billingPeriod", "Lcom/revenuecat/purchases/models/Period;", "priceCurrencyCodeValue", "", b.x, "", "recurrenceMode", "", "billingCycleCount", "(Lcom/revenuecat/purchases/models/Period;Ljava/lang/String;DILjava/lang/Integer;)Lcom/revenuecat/purchases/models/PricingPhase;", "previewSubscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", DiagnosticsEntry.ID_KEY, "productId", "duration", "pricingPhases", "", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "installmentsInfo", "Lcom/revenuecat/purchases/models/InstallmentsInfo;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class PreviewDataCreatorsKt {
    public static /* synthetic */ SubscriptionOption previewSubscriptionOption$default(String str, String str2, Period period, List list, PresentedOfferingContext presentedOfferingContext, InstallmentsInfo installmentsInfo, int i, Object obj) {
        if ((i & 4) != 0) {
            period = new Period(1, Period.Unit.MONTH, "P1M");
        }
        Period period2 = period;
        if ((i & 8) != 0) {
            list = CollectionsKt.listOf(previewPricingPhase$default(period2, null, 0.0d, 0, null, 30, null));
        }
        return previewSubscriptionOption(str, str2, period2, list, (i & 16) != 0 ? null : presentedOfferingContext, (i & 32) != 0 ? null : installmentsInfo);
    }

    public static final /* synthetic */ SubscriptionOption previewSubscriptionOption(final String id, final String productId, Period duration, final List pricingPhases, final PresentedOfferingContext presentedOfferingContext, final InstallmentsInfo installmentsInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(pricingPhases, "pricingPhases");
        return new SubscriptionOption() { // from class: com.revenuecat.purchases.ui.revenuecatui.utils.PreviewDataCreatorsKt.previewSubscriptionOption.1
            @Override // com.revenuecat.purchases.models.SubscriptionOption
            /* JADX INFO: renamed from: getId, reason: from getter */
            public String get$id() {
                return id;
            }

            @Override // com.revenuecat.purchases.models.SubscriptionOption
            public List<PricingPhase> getPricingPhases() {
                return pricingPhases;
            }

            @Override // com.revenuecat.purchases.models.SubscriptionOption
            public List<String> getTags() {
                return CollectionsKt.listOf("tag");
            }

            @Override // com.revenuecat.purchases.models.SubscriptionOption
            public String getPresentedOfferingIdentifier() {
                PresentedOfferingContext presentedOfferingContext2 = presentedOfferingContext;
                if (presentedOfferingContext2 != null) {
                    return presentedOfferingContext2.getOfferingIdentifier();
                }
                return null;
            }

            @Override // com.revenuecat.purchases.models.SubscriptionOption
            public PresentedOfferingContext getPresentedOfferingContext() {
                return presentedOfferingContext;
            }

            @Override // com.revenuecat.purchases.models.SubscriptionOption
            public PurchasingData getPurchasingData() {
                return new PreviewPurchasingData(productId);
            }

            @Override // com.revenuecat.purchases.models.SubscriptionOption
            public InstallmentsInfo getInstallmentsInfo() {
                return installmentsInfo;
            }
        };
    }

    public static /* synthetic */ PricingPhase previewPricingPhase$default(Period period, String str, double d, int i, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            period = new Period(1, Period.Unit.MONTH, "P1M");
        }
        if ((i2 & 2) != 0) {
            str = "USD";
        }
        if ((i2 & 4) != 0) {
            d = 4.99d;
        }
        if ((i2 & 8) != 0) {
            i = 1;
        }
        if ((i2 & 16) != 0) {
            num = null;
        }
        double d2 = d;
        return previewPricingPhase(period, str, d2, i, num);
    }

    public static final /* synthetic */ PricingPhase previewPricingPhase(Period billingPeriod, String priceCurrencyCodeValue, double d, int i, Integer num) {
        String string;
        Intrinsics.checkNotNullParameter(billingPeriod, "billingPeriod");
        Intrinsics.checkNotNullParameter(priceCurrencyCodeValue, "priceCurrencyCodeValue");
        RecurrenceMode recurrenceMode = RecurrenceModeKt.toRecurrenceMode(Integer.valueOf(i));
        if (d == 0.0d) {
            string = "Free";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('$');
            sb.append(d);
            string = sb.toString();
        }
        return new PricingPhase(billingPeriod, recurrenceMode, num, new Price(string, (long) (d * ((double) 1000000)), priceCurrencyCodeValue));
    }
}
