package com.revenuecat.purchases.google.usecase;

import kotlin.Metadata;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\"\u0014\u0010\u0001\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u001a\u0010\u0006\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u0007\u0010\b\"\u001a\u0010\t\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\b*L\b\u0000\u0010\u0010\"\"\u0012\u0004\u0012\u00020\f\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u0004\u0012\u00020\u000f0\u000b2\"\u0012\u0004\u0012\u00020\f\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u0004\u0012\u00020\u000f0\u000b¨\u0006\u0011"}, d2 = {"", "MAX_RETRIES_DEFAULT", "I", "Lkotlin/time/Duration;", "RETRY_TIMER_START", "J", "RETRY_TIMER_MAX_TIME", "getRETRY_TIMER_MAX_TIME", "()J", "RETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND", "getRETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND", "Lkotlin/Function2;", "", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "", "ExecuteRequestOnUIThreadFunction", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BillingClientUseCaseKt {
    private static final int MAX_RETRIES_DEFAULT = 3;
    private static final long RETRY_TIMER_MAX_TIME;
    private static final long RETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND;
    private static final long RETRY_TIMER_START;

    static {
        Duration.Companion companion = Duration.Companion;
        RETRY_TIMER_START = DurationKt.toDuration(878, DurationUnit.MILLISECONDS);
        RETRY_TIMER_MAX_TIME = DurationKt.toDuration(15, DurationUnit.MINUTES);
        RETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND = DurationKt.toDuration(4, DurationUnit.SECONDS);
    }

    public static final long getRETRY_TIMER_MAX_TIME() {
        return RETRY_TIMER_MAX_TIME;
    }

    public static final long getRETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND() {
        return RETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND;
    }
}
