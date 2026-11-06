package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/PurchasesTransactionException;", "Lcom/revenuecat/purchases/PurchasesException;", "purchasesError", "Lcom/revenuecat/purchases/PurchasesError;", "userCancelled", "", "(Lcom/revenuecat/purchases/PurchasesError;Z)V", "getUserCancelled", "()Z", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PurchasesTransactionException extends PurchasesException {
    private final boolean userCancelled;

    public final boolean getUserCancelled() {
        return this.userCancelled;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchasesTransactionException(PurchasesError purchasesError, boolean z) {
        super(purchasesError);
        Intrinsics.checkNotNullParameter(purchasesError, "purchasesError");
        this.userCancelled = z;
    }
}
