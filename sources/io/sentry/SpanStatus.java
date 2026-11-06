package io.sentry;

import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum SpanStatus implements JsonSerializable {
    OK(0, 399),
    CANCELLED(499),
    INTERNAL_ERROR(500),
    UNKNOWN(500),
    UNKNOWN_ERROR(500),
    INVALID_ARGUMENT(400),
    DEADLINE_EXCEEDED(504),
    NOT_FOUND(RCHTTPStatusCodes.NOT_FOUND),
    ALREADY_EXISTS(409),
    PERMISSION_DENIED(RCHTTPStatusCodes.FORBIDDEN),
    RESOURCE_EXHAUSTED(429),
    FAILED_PRECONDITION(400),
    ABORTED(409),
    OUT_OF_RANGE(400),
    UNIMPLEMENTED(501),
    UNAVAILABLE(503),
    DATA_LOSS(500),
    UNAUTHENTICATED(RCHTTPStatusCodes.UNAUTHORIZED);

    private final int maxHttpStatusCode;
    private final int minHttpStatusCode;

    SpanStatus(int i) {
        this.minHttpStatusCode = i;
        this.maxHttpStatusCode = i;
    }

    SpanStatus(int i, int i2) {
        this.minHttpStatusCode = i;
        this.maxHttpStatusCode = i2;
    }

    public static SpanStatus fromHttpStatusCode(int i) {
        for (SpanStatus spanStatus : values()) {
            if (spanStatus.matches(i)) {
                return spanStatus;
            }
        }
        return null;
    }

    public static SpanStatus fromHttpStatusCode(Integer num, SpanStatus spanStatus) {
        SpanStatus spanStatusFromHttpStatusCode = num != null ? fromHttpStatusCode(num.intValue()) : spanStatus;
        return spanStatusFromHttpStatusCode != null ? spanStatusFromHttpStatusCode : spanStatus;
    }

    private boolean matches(int i) {
        return i >= this.minHttpStatusCode && i <= this.maxHttpStatusCode;
    }

    public String apiName() {
        return name().toLowerCase(Locale.ROOT);
    }

    public static SpanStatus fromApiNameSafely(String str) {
        if (str == null) {
            return null;
        }
        try {
            return valueOf(str.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.value(apiName());
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public SpanStatus deserialize(ObjectReader objectReader, ILogger iLogger) {
            return SpanStatus.valueOf(objectReader.nextString().toUpperCase(Locale.ROOT));
        }
    }
}
