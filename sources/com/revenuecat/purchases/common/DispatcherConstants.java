package com.revenuecat.purchases.common;

import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import kotlin.Metadata;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/common/DispatcherConstants;", "", "()V", "jitterDelay", "Lkotlin/time/Duration;", "getJitterDelay-UwyO8pc", "()J", "J", "jitterLongDelay", "getJitterLongDelay-UwyO8pc", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DispatcherConstants {
    public static final DispatcherConstants INSTANCE = new DispatcherConstants();
    private static final long jitterDelay;
    private static final long jitterLongDelay;

    private DispatcherConstants() {
    }

    static {
        Duration.Companion companion = Duration.Companion;
        DurationUnit durationUnit = DurationUnit.MILLISECONDS;
        jitterDelay = DurationKt.toDuration(HTTPTimeoutManager.SUPPORTED_FALLBACK_TIMEOUT_MS, durationUnit);
        jitterLongDelay = DurationKt.toDuration(10000L, durationUnit);
    }

    /* JADX INFO: renamed from: getJitterDelay-UwyO8pc, reason: not valid java name */
    public final long m3851getJitterDelayUwyO8pc() {
        return jitterDelay;
    }

    /* JADX INFO: renamed from: getJitterLongDelay-UwyO8pc, reason: not valid java name */
    public final long m3852getJitterLongDelayUwyO8pc() {
        return jitterLongDelay;
    }
}
