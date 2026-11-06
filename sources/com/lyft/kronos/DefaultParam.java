package com.lyft.kronos;

import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class DefaultParam {
    private static final long CACHE_EXPIRATION_MS;
    private static final long MAX_NTP_RESPONSE_TIME_MS;
    private static final long MIN_WAIT_TIME_BETWEEN_SYNC_MS;
    private static final long TIMEOUT_MS;
    public static final DefaultParam INSTANCE = new DefaultParam();
    private static final List NTP_HOSTS = CollectionsKt.listOf((Object[]) new String[]{"0.pool.ntp.org", "1.pool.ntp.org", "2.pool.ntp.org", "3.pool.ntp.org"});

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        CACHE_EXPIRATION_MS = timeUnit.toMillis(1L);
        MIN_WAIT_TIME_BETWEEN_SYNC_MS = timeUnit.toMillis(1L);
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        TIMEOUT_MS = timeUnit2.toMillis(6L);
        MAX_NTP_RESPONSE_TIME_MS = timeUnit2.toMillis(5L);
    }

    private DefaultParam() {
    }

    public final List getNTP_HOSTS() {
        return NTP_HOSTS;
    }

    public final long getCACHE_EXPIRATION_MS() {
        return CACHE_EXPIRATION_MS;
    }

    public final long getMIN_WAIT_TIME_BETWEEN_SYNC_MS() {
        return MIN_WAIT_TIME_BETWEEN_SYNC_MS;
    }

    public final long getTIMEOUT_MS() {
        return TIMEOUT_MS;
    }

    public final long getMAX_NTP_RESPONSE_TIME_MS() {
        return MAX_NTP_RESPONSE_TIME_MS;
    }
}
