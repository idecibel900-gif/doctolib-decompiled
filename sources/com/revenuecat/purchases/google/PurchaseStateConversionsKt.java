package com.revenuecat.purchases.google;

import com.revenuecat.purchases.models.PurchaseState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"toGooglePurchaseState", "", "Lcom/revenuecat/purchases/models/PurchaseState;", "toRevenueCatPurchaseState", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PurchaseStateConversionsKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PurchaseState.values().length];
            try {
                iArr[PurchaseState.UNSPECIFIED_STATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchaseState.PURCHASED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PurchaseState.PENDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final PurchaseState toRevenueCatPurchaseState(int i) {
        if (i == 0) {
            return PurchaseState.UNSPECIFIED_STATE;
        }
        if (i == 1) {
            return PurchaseState.PURCHASED;
        }
        if (i == 2) {
            return PurchaseState.PENDING;
        }
        return PurchaseState.UNSPECIFIED_STATE;
    }

    public static final int toGooglePurchaseState(PurchaseState purchaseState) {
        Intrinsics.checkNotNullParameter(purchaseState, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[purchaseState.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }
}
