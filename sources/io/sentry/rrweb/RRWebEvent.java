package io.sentry.rrweb;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.ILogger;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RRWebEvent {
    private long timestamp = System.currentTimeMillis();
    private RRWebEventType type;

    protected RRWebEvent(RRWebEventType rRWebEventType) {
        this.type = rRWebEventType;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RRWebEvent)) {
            return false;
        }
        RRWebEvent rRWebEvent = (RRWebEvent) obj;
        return this.timestamp == rRWebEvent.timestamp && this.type == rRWebEvent.type;
    }

    public int hashCode() {
        return Objects.hash(this.type, Long.valueOf(this.timestamp));
    }

    public static final class Serializer {
        public void serialize(RRWebEvent rRWebEvent, ObjectWriter objectWriter, ILogger iLogger) {
            objectWriter.name("type").value(iLogger, rRWebEvent.type);
            objectWriter.name(DiagnosticsEntry.TIMESTAMP_KEY).value(rRWebEvent.timestamp);
        }
    }

    public static final class Deserializer {
        public boolean deserializeValue(RRWebEvent rRWebEvent, String str, ObjectReader objectReader, ILogger iLogger) {
            str.getClass();
            if (str.equals("type")) {
                rRWebEvent.type = (RRWebEventType) Objects.requireNonNull((RRWebEventType) objectReader.nextOrNull(iLogger, new RRWebEventType.Deserializer()), "");
                return true;
            }
            if (!str.equals(DiagnosticsEntry.TIMESTAMP_KEY)) {
                return false;
            }
            rRWebEvent.timestamp = objectReader.nextLong();
            return true;
        }
    }
}
