package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class SdkInfo implements JsonSerializable {
    private String sdkName;
    private Map unknown;
    private Integer versionMajor;
    private Integer versionMinor;
    private Integer versionPatchlevel;

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.sdkName != null) {
            objectWriter.name("sdk_name").value(this.sdkName);
        }
        if (this.versionMajor != null) {
            objectWriter.name("version_major").value(this.versionMajor);
        }
        if (this.versionMinor != null) {
            objectWriter.name("version_minor").value(this.versionMinor);
        }
        if (this.versionPatchlevel != null) {
            objectWriter.name("version_patchlevel").value(this.versionPatchlevel);
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
        public SdkInfo deserialize(ObjectReader objectReader, ILogger iLogger) {
            SdkInfo sdkInfo = new SdkInfo();
            objectReader.beginObject();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "sdk_name":
                        sdkInfo.sdkName = objectReader.nextStringOrNull();
                        break;
                    case "version_patchlevel":
                        sdkInfo.versionPatchlevel = objectReader.nextIntegerOrNull();
                        break;
                    case "version_major":
                        sdkInfo.versionMajor = objectReader.nextIntegerOrNull();
                        break;
                    case "version_minor":
                        sdkInfo.versionMinor = objectReader.nextIntegerOrNull();
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        objectReader.nextUnknown(iLogger, map, strNextName);
                        break;
                }
            }
            objectReader.endObject();
            sdkInfo.setUnknown(map);
            return sdkInfo;
        }
    }
}
