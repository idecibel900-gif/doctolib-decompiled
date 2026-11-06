package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class FeatureFlags implements JsonSerializable {
    private Map unknown;
    private List values;

    public FeatureFlags(List list) {
        this.values = list;
    }

    public List getValues() {
        return this.values;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FeatureFlags.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.values, ((FeatureFlags) obj).values);
    }

    public int hashCode() {
        return Objects.hash(this.values);
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("values").value(iLogger, this.values);
        Map map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public FeatureFlags deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            List arrayList = null;
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals("values")) {
                    arrayList = objectReader.nextListOrNull(iLogger, new FeatureFlag.Deserializer());
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                }
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            FeatureFlags featureFlags = new FeatureFlags(arrayList);
            featureFlags.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return featureFlags;
        }
    }
}
