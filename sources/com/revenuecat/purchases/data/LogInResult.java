package com.revenuecat.purchases.data;

import com.revenuecat.purchases.CustomerInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/data/LogInResult;", "", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "created", "", "(Lcom/revenuecat/purchases/CustomerInfo;Z)V", "getCreated", "()Z", "getCustomerInfo", "()Lcom/revenuecat/purchases/CustomerInfo;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LogInResult {
    private final boolean created;
    private final CustomerInfo customerInfo;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogInResult)) {
            return false;
        }
        LogInResult logInResult = (LogInResult) obj;
        return Intrinsics.areEqual(this.customerInfo, logInResult.customerInfo) && this.created == logInResult.created;
    }

    public int hashCode() {
        return (this.customerInfo.hashCode() * 31) + Boolean.hashCode(this.created);
    }

    public String toString() {
        return "LogInResult(customerInfo=" + this.customerInfo + ", created=" + this.created + ')';
    }

    public LogInResult(CustomerInfo customerInfo, boolean z) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        this.customerInfo = customerInfo;
        this.created = z;
    }

    public final CustomerInfo getCustomerInfo() {
        return this.customerInfo;
    }

    public final boolean getCreated() {
        return this.created;
    }
}
