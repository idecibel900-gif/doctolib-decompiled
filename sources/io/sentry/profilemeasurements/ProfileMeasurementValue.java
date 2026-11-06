package io.sentry.profilemeasurements;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.DateUtils;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class ProfileMeasurementValue implements JsonSerializable {
    private String relativeStartNs;
    private double timestamp;
    private Map unknown;
    private double value;

    public ProfileMeasurementValue() {
        this(0L, 0, 0L);
    }

    public ProfileMeasurementValue(Long l, Number number, long j) {
        this.relativeStartNs = l.toString();
        this.value = number.doubleValue();
        this.timestamp = DateUtils.nanosToSeconds(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ProfileMeasurementValue.class == obj.getClass()) {
            ProfileMeasurementValue profileMeasurementValue = (ProfileMeasurementValue) obj;
            if (Objects.equals(this.unknown, profileMeasurementValue.unknown) && this.relativeStartNs.equals(profileMeasurementValue.relativeStartNs) && this.value == profileMeasurementValue.value && this.timestamp == profileMeasurementValue.timestamp) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.unknown, this.relativeStartNs, Double.valueOf(this.value));
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("value").value(iLogger, Double.valueOf(this.value));
        objectWriter.name("elapsed_since_start_ns").value(iLogger, this.relativeStartNs);
        objectWriter.name(DiagnosticsEntry.TIMESTAMP_KEY).value(iLogger, doubleToBigDecimal(Double.valueOf(this.timestamp)));
        Map map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.unknown.get(str);
                objectWriter.name(str);
                objectWriter.value(iLogger, obj);
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
        public ProfileMeasurementValue deserialize(ObjectReader objectReader, ILogger iLogger) {
            Double dValueOf;
            objectReader.beginObject();
            ProfileMeasurementValue profileMeasurementValue = new ProfileMeasurementValue();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "elapsed_since_start_ns":
                        String strNextStringOrNull = objectReader.nextStringOrNull();
                        if (strNextStringOrNull == null) {
                            break;
                        } else {
                            profileMeasurementValue.relativeStartNs = strNextStringOrNull;
                            break;
                        }
                        break;
                    case "timestamp":
                        try {
                            dValueOf = objectReader.nextDoubleOrNull();
                            break;
                        } catch (NumberFormatException unused) {
                            Date dateNextDateOrNull = objectReader.nextDateOrNull(iLogger);
                            dValueOf = dateNextDateOrNull != null ? Double.valueOf(DateUtils.dateToSeconds(dateNextDateOrNull)) : null;
                        }
                        if (dValueOf == null) {
                            break;
                        } else {
                            profileMeasurementValue.timestamp = dValueOf.doubleValue();
                            break;
                        }
                        break;
                    case "value":
                        Double dNextDoubleOrNull = objectReader.nextDoubleOrNull();
                        if (dNextDoubleOrNull == null) {
                            break;
                        } else {
                            profileMeasurementValue.value = dNextDoubleOrNull.doubleValue();
                            break;
                        }
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            profileMeasurementValue.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return profileMeasurementValue;
        }
    }
}
