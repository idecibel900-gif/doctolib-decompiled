package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryOptions;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class DebugMeta implements JsonSerializable {
    private List images;
    private SdkInfo sdkInfo;
    private Map unknown;

    public List getImages() {
        return this.images;
    }

    public void setImages(List list) {
        this.images = list != null ? new ArrayList(list) : null;
    }

    public static DebugMeta buildDebugMeta(DebugMeta debugMeta, SentryOptions sentryOptions) {
        ArrayList arrayList = new ArrayList();
        if (sentryOptions.getProguardUuid() != null) {
            DebugImage debugImage = new DebugImage();
            debugImage.setType(DebugImage.PROGUARD);
            debugImage.setUuid(sentryOptions.getProguardUuid());
            arrayList.add(debugImage);
        }
        for (String str : sentryOptions.getBundleIds()) {
            DebugImage debugImage2 = new DebugImage();
            debugImage2.setType(DebugImage.JVM);
            debugImage2.setDebugId(str);
            arrayList.add(debugImage2);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (debugMeta == null) {
            debugMeta = new DebugMeta();
        }
        if (debugMeta.getImages() == null) {
            debugMeta.setImages(arrayList);
            return debugMeta;
        }
        debugMeta.getImages().addAll(arrayList);
        return debugMeta;
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.sdkInfo != null) {
            objectWriter.name("sdk_info").value(iLogger, this.sdkInfo);
        }
        if (this.images != null) {
            objectWriter.name("images").value(iLogger, this.images);
        }
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
        public DebugMeta deserialize(ObjectReader objectReader, ILogger iLogger) {
            DebugMeta debugMeta = new DebugMeta();
            objectReader.beginObject();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals("images")) {
                    debugMeta.images = objectReader.nextListOrNull(iLogger, new DebugImage.Deserializer());
                } else if (strNextName.equals("sdk_info")) {
                    debugMeta.sdkInfo = (SdkInfo) objectReader.nextOrNull(iLogger, new SdkInfo.Deserializer());
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            objectReader.endObject();
            debugMeta.setUnknown(map);
            return debugMeta;
        }
    }
}
