package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.Map;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes5.dex */
public final class UserFeedback implements JsonSerializable {
    private String comments;
    private String email;
    private final SentryId eventId;
    private String name;
    private Map unknown;

    public UserFeedback(SentryId sentryId, String str, String str2, String str3) {
        this.eventId = sentryId;
        this.name = str;
        this.email = str2;
        this.comments = str3;
    }

    public String toString() {
        return "UserFeedback{eventId=" + this.eventId + ", name='" + this.name + "', email='" + this.email + "', comments='" + this.comments + "'}";
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("event_id");
        this.eventId.serialize(objectWriter, iLogger);
        if (this.name != null) {
            objectWriter.name("name").value(this.name);
        }
        if (this.email != null) {
            objectWriter.name(AuthorizationRequest.Scope.EMAIL).value(this.email);
        }
        if (this.comments != null) {
            objectWriter.name("comments").value(this.comments);
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
        public UserFeedback deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            SentryId sentryIdDeserialize = null;
            String strNextStringOrNull = null;
            String strNextStringOrNull2 = null;
            String strNextStringOrNull3 = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "comments":
                        strNextStringOrNull3 = objectReader.nextStringOrNull();
                        break;
                    case "name":
                        strNextStringOrNull = objectReader.nextStringOrNull();
                        break;
                    case "email":
                        strNextStringOrNull2 = objectReader.nextStringOrNull();
                        break;
                    case "event_id":
                        sentryIdDeserialize = new SentryId.Deserializer().deserialize(objectReader, iLogger);
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
            if (sentryIdDeserialize == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"event_id\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"event_id\"", illegalStateException);
                throw illegalStateException;
            }
            UserFeedback userFeedback = new UserFeedback(sentryIdDeserialize, strNextStringOrNull, strNextStringOrNull2, strNextStringOrNull3);
            userFeedback.setUnknown(map);
            return userFeedback;
        }
    }
}
