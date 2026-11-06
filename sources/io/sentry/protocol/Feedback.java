package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class Feedback implements JsonSerializable {
    private SentryId associatedEventId;
    private String contactEmail;
    private String message;
    private String name;
    private SentryId replayId;
    private Map unknown;
    private String url;

    public Feedback(String str) {
        setMessage(str);
    }

    public Feedback(Feedback feedback) {
        this.message = feedback.message;
        this.contactEmail = feedback.contactEmail;
        this.name = feedback.name;
        this.associatedEventId = feedback.associatedEventId;
        this.replayId = feedback.replayId;
        this.url = feedback.url;
        this.unknown = CollectionUtils.newConcurrentHashMap(feedback.unknown);
    }

    public void setContactEmail(String str) {
        this.contactEmail = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setAssociatedEventId(SentryId sentryId) {
        this.associatedEventId = sentryId;
    }

    public SentryId getReplayId() {
        return this.replayId;
    }

    public void setReplayId(SentryId sentryId) {
        this.replayId = sentryId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        if (str.length() > 4096) {
            this.message = str.substring(0, 4096);
        } else {
            this.message = str;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Feedback)) {
            return false;
        }
        Feedback feedback = (Feedback) obj;
        return Objects.equals(this.message, feedback.message) && Objects.equals(this.contactEmail, feedback.contactEmail) && Objects.equals(this.name, feedback.name) && Objects.equals(this.associatedEventId, feedback.associatedEventId) && Objects.equals(this.replayId, feedback.replayId) && Objects.equals(this.url, feedback.url) && Objects.equals(this.unknown, feedback.unknown);
    }

    public String toString() {
        return "Feedback{message='" + this.message + "', contactEmail='" + this.contactEmail + "', name='" + this.name + "', associatedEventId=" + this.associatedEventId + ", replayId=" + this.replayId + ", url='" + this.url + "', unknown=" + this.unknown + '}';
    }

    public int hashCode() {
        return Objects.hash(this.message, this.contactEmail, this.name, this.associatedEventId, this.replayId, this.url, this.unknown);
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("message").value(this.message);
        if (this.contactEmail != null) {
            objectWriter.name("contact_email").value(this.contactEmail);
        }
        if (this.name != null) {
            objectWriter.name("name").value(this.name);
        }
        if (this.associatedEventId != null) {
            objectWriter.name("associated_event_id");
            this.associatedEventId.serialize(objectWriter, iLogger);
        }
        if (this.replayId != null) {
            objectWriter.name("replay_id");
            this.replayId.serialize(objectWriter, iLogger);
        }
        if (this.url != null) {
            objectWriter.name("url").value(this.url);
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
        public Feedback deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            String strNextStringOrNull = null;
            String strNextStringOrNull2 = null;
            String strNextStringOrNull3 = null;
            SentryId sentryIdDeserialize = null;
            SentryId sentryIdDeserialize2 = null;
            String strNextStringOrNull4 = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "associated_event_id":
                        sentryIdDeserialize = new SentryId.Deserializer().deserialize(objectReader, iLogger);
                        break;
                    case "replay_id":
                        sentryIdDeserialize2 = new SentryId.Deserializer().deserialize(objectReader, iLogger);
                        break;
                    case "url":
                        strNextStringOrNull4 = objectReader.nextStringOrNull();
                        break;
                    case "name":
                        strNextStringOrNull3 = objectReader.nextStringOrNull();
                        break;
                    case "contact_email":
                        strNextStringOrNull2 = objectReader.nextStringOrNull();
                        break;
                    case "message":
                        strNextStringOrNull = objectReader.nextStringOrNull();
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
            if (strNextStringOrNull == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"message\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"message\"", illegalStateException);
                throw illegalStateException;
            }
            Feedback feedback = new Feedback(strNextStringOrNull);
            feedback.contactEmail = strNextStringOrNull2;
            feedback.name = strNextStringOrNull3;
            feedback.associatedEventId = sentryIdDeserialize;
            feedback.replayId = sentryIdDeserialize2;
            feedback.url = strNextStringOrNull4;
            feedback.unknown = map;
            return feedback;
        }
    }
}
