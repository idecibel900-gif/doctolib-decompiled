package com.revenuecat.purchases.models;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/models/RecurrenceMode;", "", "identifier", "", "(Ljava/lang/String;ILjava/lang/Integer;)V", "getIdentifier", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "INFINITE_RECURRING", "FINITE_RECURRING", "NON_RECURRING", "UNKNOWN", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum RecurrenceMode {
    INFINITE_RECURRING(1),
    FINITE_RECURRING(2),
    NON_RECURRING(3),
    UNKNOWN(null);

    private final Integer identifier;

    RecurrenceMode(Integer num) {
        this.identifier = num;
    }

    public final Integer getIdentifier() {
        return this.identifier;
    }
}
