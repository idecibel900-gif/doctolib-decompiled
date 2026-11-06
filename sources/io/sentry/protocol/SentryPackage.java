package io.sentry.protocol;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryPackage implements JsonSerializable {
    private String name;
    private Map unknown;
    private String version;

    public SentryPackage(String str, String str2) {
        this.name = (String) Objects.requireNonNull(str, "name is required.");
        this.version = (String) Objects.requireNonNull(str2, "version is required.");
    }

    public String getName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SentryPackage.class == obj.getClass()) {
            SentryPackage sentryPackage = (SentryPackage) obj;
            if (java.util.Objects.equals(this.name, sentryPackage.name) && java.util.Objects.equals(this.version, sentryPackage.version)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return java.util.Objects.hash(this.name, this.version);
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("name").value(this.name);
        objectWriter.name(DiagnosticsEntry.VERSION_KEY).value(this.version);
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
        public SentryPackage deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            String strNextString = null;
            String strNextString2 = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals("name")) {
                    strNextString = objectReader.nextString();
                } else if (strNextName.equals(DiagnosticsEntry.VERSION_KEY)) {
                    strNextString2 = objectReader.nextString();
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            objectReader.endObject();
            if (strNextString == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"name\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"name\"", illegalStateException);
                throw illegalStateException;
            }
            if (strNextString2 == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"version\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"version\"", illegalStateException2);
                throw illegalStateException2;
            }
            SentryPackage sentryPackage = new SentryPackage(strNextString, strNextString2);
            sentryPackage.setUnknown(map);
            return sentryPackage;
        }
    }
}
