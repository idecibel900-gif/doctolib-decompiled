package io.sentry;

import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryEnvelopeItemHeader implements JsonSerializable {
    private final String attachmentType;
    private final String contentType;
    private final String fileName;
    private final Callable getLength;
    private final Integer itemCount;
    private final int length;
    private final String platform;
    private final SentryItemType type;
    private Map unknown;

    public SentryItemType getType() {
        return this.type;
    }

    public int getLength() {
        Callable callable = this.getLength;
        if (callable != null) {
            try {
                return ((Integer) callable.call()).intValue();
            } catch (Throwable unused) {
                return -1;
            }
        }
        return this.length;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getFileName() {
        return this.fileName;
    }

    public SentryEnvelopeItemHeader(SentryItemType sentryItemType, int i, String str, String str2, String str3, String str4, Integer num) {
        this.type = (SentryItemType) Objects.requireNonNull(sentryItemType, "type is required");
        this.contentType = str;
        this.length = i;
        this.fileName = str2;
        this.getLength = null;
        this.attachmentType = str3;
        this.platform = str4;
        this.itemCount = num;
    }

    SentryEnvelopeItemHeader(SentryItemType sentryItemType, Callable callable, String str, String str2, String str3) {
        this(sentryItemType, callable, str, str2, str3, (String) null, (Integer) null);
    }

    SentryEnvelopeItemHeader(SentryItemType sentryItemType, Callable callable, String str, String str2, String str3, String str4, Integer num) {
        this.type = (SentryItemType) Objects.requireNonNull(sentryItemType, "type is required");
        this.contentType = str;
        this.length = -1;
        this.fileName = str2;
        this.getLength = callable;
        this.attachmentType = str3;
        this.platform = str4;
        this.itemCount = num;
    }

    SentryEnvelopeItemHeader(SentryItemType sentryItemType, Callable callable, String str, String str2) {
        this(sentryItemType, callable, str, str2, null);
    }

    public String getAttachmentType() {
        return this.attachmentType;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.contentType != null) {
            objectWriter.name("content_type").value(this.contentType);
        }
        if (this.fileName != null) {
            objectWriter.name("filename").value(this.fileName);
        }
        objectWriter.name("type").value(iLogger, this.type);
        if (this.attachmentType != null) {
            objectWriter.name("attachment_type").value(this.attachmentType);
        }
        if (this.platform != null) {
            objectWriter.name("platform").value(this.platform);
        }
        if (this.itemCount != null) {
            objectWriter.name("item_count").value(this.itemCount);
        }
        objectWriter.name("length").value(getLength());
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
        public SentryEnvelopeItemHeader deserialize(ObjectReader objectReader, ILogger iLogger) throws Exception {
            objectReader.beginObject();
            HashMap map = null;
            SentryItemType sentryItemType = null;
            String strNextStringOrNull = null;
            String strNextStringOrNull2 = null;
            String strNextStringOrNull3 = null;
            String strNextStringOrNull4 = null;
            Integer numNextIntegerOrNull = null;
            int iNextInt = 0;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "item_count":
                        numNextIntegerOrNull = objectReader.nextIntegerOrNull();
                        break;
                    case "length":
                        iNextInt = objectReader.nextInt();
                        break;
                    case "filename":
                        strNextStringOrNull2 = objectReader.nextStringOrNull();
                        break;
                    case "attachment_type":
                        strNextStringOrNull3 = objectReader.nextStringOrNull();
                        break;
                    case "type":
                        sentryItemType = (SentryItemType) objectReader.nextOrNull(iLogger, new SentryItemType.Deserializer());
                        break;
                    case "content_type":
                        strNextStringOrNull = objectReader.nextStringOrNull();
                        break;
                    case "platform":
                        strNextStringOrNull4 = objectReader.nextStringOrNull();
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        objectReader.nextUnknown(iLogger, map, strNextName);
                        break;
                }
            }
            if (sentryItemType == null) {
                throw missingRequiredFieldException("type", iLogger);
            }
            SentryEnvelopeItemHeader sentryEnvelopeItemHeader = new SentryEnvelopeItemHeader(sentryItemType, iNextInt, strNextStringOrNull, strNextStringOrNull2, strNextStringOrNull3, strNextStringOrNull4, numNextIntegerOrNull);
            sentryEnvelopeItemHeader.setUnknown(map);
            objectReader.endObject();
            return sentryEnvelopeItemHeader;
        }

        private Exception missingRequiredFieldException(String str, ILogger iLogger) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            iLogger.log(SentryLevel.ERROR, str2, illegalStateException);
            return illegalStateException;
        }
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }
}
