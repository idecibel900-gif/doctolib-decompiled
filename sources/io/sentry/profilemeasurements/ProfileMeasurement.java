package io.sentry.profilemeasurements;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class ProfileMeasurement implements JsonSerializable {
    private String unit;
    private Map unknown;
    private Collection values;

    public ProfileMeasurement() {
        this("unknown", new ArrayList());
    }

    public ProfileMeasurement(String str, Collection collection) {
        this.unit = str;
        this.values = collection;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ProfileMeasurement.class == obj.getClass()) {
            ProfileMeasurement profileMeasurement = (ProfileMeasurement) obj;
            if (Objects.equals(this.unknown, profileMeasurement.unknown) && this.unit.equals(profileMeasurement.unit) && new ArrayList(this.values).equals(new ArrayList(profileMeasurement.values))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.unknown, this.unit, this.values);
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("unit").value(iLogger, this.unit);
        objectWriter.name("values").value(iLogger, this.values);
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

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public ProfileMeasurement deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            ProfileMeasurement profileMeasurement = new ProfileMeasurement();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals("values")) {
                    List listNextListOrNull = objectReader.nextListOrNull(iLogger, new ProfileMeasurementValue.Deserializer());
                    if (listNextListOrNull != null) {
                        profileMeasurement.values = listNextListOrNull;
                    }
                } else if (strNextName.equals("unit")) {
                    String strNextStringOrNull = objectReader.nextStringOrNull();
                    if (strNextStringOrNull != null) {
                        profileMeasurement.unit = strNextStringOrNull;
                    }
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                }
            }
            profileMeasurement.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return profileMeasurement;
        }
    }
}
