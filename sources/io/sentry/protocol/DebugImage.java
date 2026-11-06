package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class DebugImage implements JsonSerializable {
    public static final String JVM = "jvm";
    public static final String PROGUARD = "proguard";
    private String arch;
    private String codeFile;
    private String codeId;
    private String debugFile;
    private String debugId;
    private String imageAddr;
    private Long imageSize;
    private String type;
    private Map<String, Object> unknown;
    private String uuid;

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getDebugId() {
        return this.debugId;
    }

    public void setDebugId(String str) {
        this.debugId = str;
    }

    public String getDebugFile() {
        return this.debugFile;
    }

    public void setDebugFile(String str) {
        this.debugFile = str;
    }

    public String getCodeFile() {
        return this.codeFile;
    }

    public void setCodeFile(String str) {
        this.codeFile = str;
    }

    public String getImageAddr() {
        return this.imageAddr;
    }

    public void setImageAddr(String str) {
        this.imageAddr = str;
    }

    public Long getImageSize() {
        return this.imageSize;
    }

    public void setImageSize(Long l) {
        this.imageSize = l;
    }

    public void setImageSize(long j) {
        this.imageSize = Long.valueOf(j);
    }

    public String getArch() {
        return this.arch;
    }

    public void setArch(String str) {
        this.arch = str;
    }

    public String getCodeId() {
        return this.codeId;
    }

    public void setCodeId(String str) {
        this.codeId = str;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.uuid != null) {
            objectWriter.name("uuid").value(this.uuid);
        }
        if (this.type != null) {
            objectWriter.name("type").value(this.type);
        }
        if (this.debugId != null) {
            objectWriter.name("debug_id").value(this.debugId);
        }
        if (this.debugFile != null) {
            objectWriter.name("debug_file").value(this.debugFile);
        }
        if (this.codeId != null) {
            objectWriter.name("code_id").value(this.codeId);
        }
        if (this.codeFile != null) {
            objectWriter.name("code_file").value(this.codeFile);
        }
        if (this.imageAddr != null) {
            objectWriter.name("image_addr").value(this.imageAddr);
        }
        if (this.imageSize != null) {
            objectWriter.name("image_size").value(this.imageSize);
        }
        if (this.arch != null) {
            objectWriter.name("arch").value(this.arch);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public DebugImage deserialize(ObjectReader objectReader, ILogger iLogger) {
            DebugImage debugImage = new DebugImage();
            objectReader.beginObject();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "debug_file":
                        debugImage.debugFile = objectReader.nextStringOrNull();
                        break;
                    case "image_addr":
                        debugImage.imageAddr = objectReader.nextStringOrNull();
                        break;
                    case "image_size":
                        debugImage.imageSize = objectReader.nextLongOrNull();
                        break;
                    case "code_file":
                        debugImage.codeFile = objectReader.nextStringOrNull();
                        break;
                    case "arch":
                        debugImage.arch = objectReader.nextStringOrNull();
                        break;
                    case "type":
                        debugImage.type = objectReader.nextStringOrNull();
                        break;
                    case "uuid":
                        debugImage.uuid = objectReader.nextStringOrNull();
                        break;
                    case "debug_id":
                        debugImage.debugId = objectReader.nextStringOrNull();
                        break;
                    case "code_id":
                        debugImage.codeId = objectReader.nextStringOrNull();
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
            debugImage.setUnknown(map);
            return debugImage;
        }
    }
}
