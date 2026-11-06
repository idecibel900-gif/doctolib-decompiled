package com.revenuecat.purchases.common.diagnostics;

import com.revenuecat.purchases.ProductType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"diagnosticsName", "", "Lcom/revenuecat/purchases/ProductType;", "getDiagnosticsName", "(Lcom/revenuecat/purchases/ProductType;)Ljava/lang/String;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DiagnosticsTrackerKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProductType.values().length];
            try {
                iArr[ProductType.SUBS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProductType.INAPP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProductType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getDiagnosticsName(ProductType productType) {
        int i = WhenMappings.$EnumSwitchMapping$0[productType.ordinal()];
        if (i == 1) {
            return "AUTO_RENEWABLE_SUBSCRIPTION";
        }
        if (i == 2) {
            return "NON_SUBSCRIPTION";
        }
        if (i == 3) {
            return "UNKNOWN";
        }
        throw new NoWhenBranchMatchedException();
    }
}
