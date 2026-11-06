package io.sentry;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public interface MeasurementUnit {
    String apiName();

    public enum Duration implements MeasurementUnit {
        NANOSECOND,
        MICROSECOND,
        MILLISECOND,
        SECOND,
        MINUTE,
        HOUR,
        DAY,
        WEEK;

        @Override // io.sentry.MeasurementUnit
        public String apiName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }
}
