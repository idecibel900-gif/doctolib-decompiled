package io.sentry.protocol;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class Browser implements JsonSerializable {
    private String name;
    private Map unknown;
    private String version;

    public Browser() {
    }

    Browser(Browser browser) {
        this.name = browser.name;
        this.version = browser.version;
        this.unknown = CollectionUtils.newConcurrentHashMap(browser.unknown);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Browser.class == obj.getClass()) {
            Browser browser = (Browser) obj;
            if (Objects.equals(this.name, browser.name) && Objects.equals(this.version, browser.version)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.name, this.version);
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.name != null) {
            objectWriter.name("name").value(this.name);
        }
        if (this.version != null) {
            objectWriter.name(DiagnosticsEntry.VERSION_KEY).value(this.version);
        }
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

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public Browser deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            Browser browser = new Browser();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals("name")) {
                    browser.name = objectReader.nextStringOrNull();
                } else if (strNextName.equals(DiagnosticsEntry.VERSION_KEY)) {
                    browser.version = objectReader.nextStringOrNull();
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                }
            }
            browser.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return browser;
        }
    }
}
