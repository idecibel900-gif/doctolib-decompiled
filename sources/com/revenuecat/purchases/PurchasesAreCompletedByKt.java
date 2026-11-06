package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"finishTransactions", "", "Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "getFinishTransactions", "(Lcom/revenuecat/purchases/PurchasesAreCompletedBy;)Z", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PurchasesAreCompletedByKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PurchasesAreCompletedBy.values().length];
            try {
                iArr[PurchasesAreCompletedBy.REVENUECAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchasesAreCompletedBy.MY_APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean getFinishTransactions(PurchasesAreCompletedBy purchasesAreCompletedBy) {
        Intrinsics.checkNotNullParameter(purchasesAreCompletedBy, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[purchasesAreCompletedBy.ordinal()];
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }
}
