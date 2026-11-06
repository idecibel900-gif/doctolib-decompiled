package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class FeatureFlag implements JsonSerializable {
    private String flag;
    private boolean result;
    private Map unknown;

    public FeatureFlag(String str, boolean z) {
        this.flag = str;
        this.result = z;
    }

    public String getFlag() {
        return this.flag;
    }

    public Boolean getResult() {
        return Boolean.valueOf(this.result);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && FeatureFlag.class == obj.getClass()) {
            FeatureFlag featureFlag = (FeatureFlag) obj;
            if (Objects.equals(this.flag, featureFlag.flag) && Objects.equals(Boolean.valueOf(this.result), Boolean.valueOf(featureFlag.result))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.flag, Boolean.valueOf(this.result));
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("flag").value(this.flag);
        objectWriter.name("result").value(this.result);
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
        public FeatureFlag deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            String strNextStringOrNull = null;
            Boolean boolNextBooleanOrNull = null;
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals("result")) {
                    boolNextBooleanOrNull = objectReader.nextBooleanOrNull();
                } else if (strNextName.equals("flag")) {
                    strNextStringOrNull = objectReader.nextStringOrNull();
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                }
            }
            if (strNextStringOrNull == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"flag\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"flag\"", illegalStateException);
                throw illegalStateException;
            }
            if (boolNextBooleanOrNull == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"result\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"result\"", illegalStateException2);
                throw illegalStateException2;
            }
            FeatureFlag featureFlag = new FeatureFlag(strNextStringOrNull, boolNextBooleanOrNull.booleanValue());
            featureFlag.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return featureFlag;
        }
    }
}
