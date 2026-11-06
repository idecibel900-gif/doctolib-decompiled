package io.sentry.clientreport;

import com.google.firebase.messaging.Constants;

/* JADX INFO: loaded from: classes5.dex */
public enum DiscardReason {
    QUEUE_OVERFLOW("queue_overflow"),
    CACHE_OVERFLOW("cache_overflow"),
    RATELIMIT_BACKOFF("ratelimit_backoff"),
    NETWORK_ERROR("network_error"),
    SEND_ERROR(Constants.MessageTypes.SEND_ERROR),
    SAMPLE_RATE("sample_rate"),
    BEFORE_SEND("before_send"),
    EVENT_PROCESSOR("event_processor"),
    BACKPRESSURE("backpressure");

    private final String reason;

    DiscardReason(String str) {
        this.reason = str;
    }

    public String getReason() {
        return this.reason;
    }
}
