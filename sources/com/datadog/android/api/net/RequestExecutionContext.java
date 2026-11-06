package com.datadog.android.api.net;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class RequestExecutionContext {
    private final int attemptNumber;
    private final Integer previousResponseCode;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestExecutionContext)) {
            return false;
        }
        RequestExecutionContext requestExecutionContext = (RequestExecutionContext) obj;
        return this.attemptNumber == requestExecutionContext.attemptNumber && Intrinsics.areEqual(this.previousResponseCode, requestExecutionContext.previousResponseCode);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.attemptNumber) * 31;
        Integer num = this.previousResponseCode;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "RequestExecutionContext(attemptNumber=" + this.attemptNumber + ", previousResponseCode=" + this.previousResponseCode + ")";
    }

    public RequestExecutionContext(int i, Integer num) {
        this.attemptNumber = i;
        this.previousResponseCode = num;
    }

    public final int getAttemptNumber() {
        return this.attemptNumber;
    }

    public final Integer getPreviousResponseCode() {
        return this.previousResponseCode;
    }
}
