package com.revenuecat.purchases;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.utils.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ0\u0010\u0010\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/CustomerInfoDataResult;", "", "result", "Lcom/revenuecat/purchases/utils/Result;", "Lcom/revenuecat/purchases/CustomerInfo;", "Lcom/revenuecat/purchases/PurchasesError;", "hadUnsyncedPurchasesBefore", "", "(Lcom/revenuecat/purchases/utils/Result;Ljava/lang/Boolean;)V", "getHadUnsyncedPurchasesBefore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getResult", "()Lcom/revenuecat/purchases/utils/Result;", "component1", "component2", "copy", "(Lcom/revenuecat/purchases/utils/Result;Ljava/lang/Boolean;)Lcom/revenuecat/purchases/CustomerInfoDataResult;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final /* data */ class CustomerInfoDataResult {
    private final Boolean hadUnsyncedPurchasesBefore;
    private final Result<CustomerInfo, PurchasesError> result;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomerInfoDataResult copy$default(CustomerInfoDataResult customerInfoDataResult, Result result, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            result = customerInfoDataResult.result;
        }
        if ((i & 2) != 0) {
            bool = customerInfoDataResult.hadUnsyncedPurchasesBefore;
        }
        return customerInfoDataResult.copy(result, bool);
    }

    public final Result<CustomerInfo, PurchasesError> component1() {
        return this.result;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getHadUnsyncedPurchasesBefore() {
        return this.hadUnsyncedPurchasesBefore;
    }

    public final CustomerInfoDataResult copy(Result<CustomerInfo, PurchasesError> result, Boolean hadUnsyncedPurchasesBefore) {
        Intrinsics.checkNotNullParameter(result, "result");
        return new CustomerInfoDataResult(result, hadUnsyncedPurchasesBefore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomerInfoDataResult)) {
            return false;
        }
        CustomerInfoDataResult customerInfoDataResult = (CustomerInfoDataResult) other;
        return Intrinsics.areEqual(this.result, customerInfoDataResult.result) && Intrinsics.areEqual(this.hadUnsyncedPurchasesBefore, customerInfoDataResult.hadUnsyncedPurchasesBefore);
    }

    public int hashCode() {
        int iHashCode = this.result.hashCode() * 31;
        Boolean bool = this.hadUnsyncedPurchasesBefore;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "CustomerInfoDataResult(result=" + this.result + ", hadUnsyncedPurchasesBefore=" + this.hadUnsyncedPurchasesBefore + ')';
    }

    public CustomerInfoDataResult(Result<CustomerInfo, PurchasesError> result, Boolean bool) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.result = result;
        this.hadUnsyncedPurchasesBefore = bool;
    }

    public /* synthetic */ CustomerInfoDataResult(Result result, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(result, (i & 2) != 0 ? null : bool);
    }

    public final Result<CustomerInfo, PurchasesError> getResult() {
        return this.result;
    }

    public final Boolean getHadUnsyncedPurchasesBefore() {
        return this.hadUnsyncedPurchasesBefore;
    }
}
