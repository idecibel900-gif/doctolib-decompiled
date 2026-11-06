package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class ProfileContext implements JsonSerializable {
    private SentryId profilerId;
    private Map unknown;

    public ProfileContext() {
        this(SentryId.EMPTY_ID);
    }

    public ProfileContext(SentryId sentryId) {
        this.profilerId = sentryId;
    }

    public ProfileContext(ProfileContext profileContext) {
        this.profilerId = profileContext.profilerId;
        Map mapNewConcurrentHashMap = CollectionUtils.newConcurrentHashMap(profileContext.unknown);
        if (mapNewConcurrentHashMap != null) {
            this.unknown = mapNewConcurrentHashMap;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProfileContext) {
            return this.profilerId.equals(((ProfileContext) obj).profilerId);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.profilerId);
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("profiler_id").value(iLogger, this.profilerId);
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
        public ProfileContext deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            ProfileContext profileContext = new ProfileContext();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals("profiler_id")) {
                    SentryId sentryId = (SentryId) objectReader.nextOrNull(iLogger, new SentryId.Deserializer());
                    if (sentryId != null) {
                        profileContext.profilerId = sentryId;
                    }
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                }
            }
            profileContext.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return profileContext;
        }
    }
}
