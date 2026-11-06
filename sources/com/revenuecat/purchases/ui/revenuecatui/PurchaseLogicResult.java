package com.revenuecat.purchases.ui.revenuecatui;

import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogicResult;", "", "Cancellation", "Error", "Success", "Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogicResult$Cancellation;", "Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogicResult$Error;", "Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogicResult$Success;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PurchaseLogicResult {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogicResult$Success;", "Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogicResult;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Success implements PurchaseLogicResult {
        public static final int $stable = 0;
        public static final Success INSTANCE = new Success();

        private Success() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogicResult$Cancellation;", "Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogicResult;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Cancellation implements PurchaseLogicResult {
        public static final int $stable = 0;
        public static final Cancellation INSTANCE = new Cancellation();

        private Cancellation() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogicResult$Error;", "Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogicResult;", "errorDetails", "Lcom/revenuecat/purchases/PurchasesError;", "(Lcom/revenuecat/purchases/PurchasesError;)V", "getErrorDetails", "()Lcom/revenuecat/purchases/PurchasesError;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Error implements PurchaseLogicResult {
        public static final int $stable = 0;
        private final PurchasesError errorDetails;

        /* JADX WARN: Multi-variable type inference failed */
        public Error() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual(this.errorDetails, ((Error) obj).errorDetails);
        }

        public int hashCode() {
            PurchasesError purchasesError = this.errorDetails;
            if (purchasesError == null) {
                return 0;
            }
            return purchasesError.hashCode();
        }

        public String toString() {
            return "Error(errorDetails=" + this.errorDetails + ')';
        }

        public Error(PurchasesError purchasesError) {
            this.errorDetails = purchasesError;
        }

        public /* synthetic */ Error(PurchasesError purchasesError, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : purchasesError);
        }

        public final PurchasesError getErrorDetails() {
            return this.errorDetails;
        }
    }
}
