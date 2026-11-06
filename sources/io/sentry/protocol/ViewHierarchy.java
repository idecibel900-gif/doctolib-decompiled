package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class ViewHierarchy implements JsonSerializable {
    private final String renderingSystem;
    private Map unknown;
    private final List windows;

    public ViewHierarchy(String str, List list) {
        this.renderingSystem = str;
        this.windows = list;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.renderingSystem != null) {
            objectWriter.name("rendering_system").value(this.renderingSystem);
        }
        if (this.windows != null) {
            objectWriter.name("windows").value(iLogger, this.windows);
        }
        Map map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.endObject();
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public ViewHierarchy deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            String strNextStringOrNull = null;
            List listNextListOrNull = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals("rendering_system")) {
                    strNextStringOrNull = objectReader.nextStringOrNull();
                } else if (strNextName.equals("windows")) {
                    listNextListOrNull = objectReader.nextListOrNull(iLogger, new ViewHierarchyNode.Deserializer());
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            objectReader.endObject();
            ViewHierarchy viewHierarchy = new ViewHierarchy(strNextStringOrNull, listNextListOrNull);
            viewHierarchy.setUnknown(map);
            return viewHierarchy;
        }
    }
}
