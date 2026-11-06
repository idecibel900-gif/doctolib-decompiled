package io.sentry.protocol.profiling;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.vendor.gson.stream.JsonToken;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class SentrySample implements JsonSerializable {
    private int stackId;
    private String threadId;
    private double timestamp;
    private Map unknown;

    public void setTimestamp(double d) {
        this.timestamp = d;
    }

    public void setStackId(int i) {
        this.stackId = i;
    }

    public void setThreadId(String str) {
        this.threadId = str;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name(DiagnosticsEntry.TIMESTAMP_KEY).value(iLogger, doubleToBigDecimal(Double.valueOf(this.timestamp)));
        objectWriter.name("stack_id").value(iLogger, Integer.valueOf(this.stackId));
        if (this.threadId != null) {
            objectWriter.name("thread_id").value(iLogger, this.threadId);
        }
        Map map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.endObject();
    }

    private BigDecimal doubleToBigDecimal(Double d) {
        return BigDecimal.valueOf(d.doubleValue()).setScale(6, RoundingMode.DOWN);
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public SentrySample deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            SentrySample sentrySample = new SentrySample();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "thread_id":
                        sentrySample.threadId = objectReader.nextStringOrNull();
                        break;
                    case "timestamp":
                        sentrySample.timestamp = objectReader.nextDouble();
                        break;
                    case "stack_id":
                        sentrySample.stackId = objectReader.nextInt();
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        objectReader.nextUnknown(iLogger, map, strNextName);
                        break;
                }
            }
            sentrySample.setUnknown(map);
            objectReader.endObject();
            return sentrySample;
        }
    }
}
