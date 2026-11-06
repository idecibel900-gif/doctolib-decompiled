package com.revenuecat.purchases;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/PackageType;", "", "identifier", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "UNKNOWN", "CUSTOM", "LIFETIME", "ANNUAL", "SIX_MONTH", "THREE_MONTH", "TWO_MONTH", "MONTHLY", "WEEKLY", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum PackageType {
    UNKNOWN(null),
    CUSTOM(null),
    LIFETIME("$rc_lifetime"),
    ANNUAL("$rc_annual"),
    SIX_MONTH("$rc_six_month"),
    THREE_MONTH("$rc_three_month"),
    TWO_MONTH("$rc_two_month"),
    MONTHLY("$rc_monthly"),
    WEEKLY("$rc_weekly");

    private final String identifier;

    PackageType(String str) {
        this.identifier = str;
    }

    public final String getIdentifier() {
        return this.identifier;
    }
}
