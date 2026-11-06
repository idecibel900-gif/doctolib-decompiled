package io.sentry;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public enum SentryAttributeType {
    STRING,
    BOOLEAN,
    INTEGER,
    DOUBLE,
    ARRAY;

    public String apiName() {
        return name().toLowerCase(Locale.ROOT);
    }

    public static SentryAttributeType inferFrom(Object obj) {
        if (obj instanceof Boolean) {
            return BOOLEAN;
        }
        if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof Byte) || (obj instanceof BigInteger) || (obj instanceof AtomicInteger) || (obj instanceof AtomicLong)) {
            return INTEGER;
        }
        if (obj instanceof Number) {
            return DOUBLE;
        }
        if ((obj instanceof Collection) || (obj != null && obj.getClass().isArray())) {
            return ARRAY;
        }
        return STRING;
    }
}
