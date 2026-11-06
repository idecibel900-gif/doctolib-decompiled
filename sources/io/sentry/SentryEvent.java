package io.sentry;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.protocol.Message;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryThread;
import io.sentry.util.CollectionUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryEvent extends SentryBaseEvent implements JsonSerializable {
    private SentryValues exception;
    private List fingerprint;
    private SentryLevel level;
    private String logger;
    private Message message;
    private Map modules;
    private SentryValues threads;
    private Date timestamp;
    private String transaction;
    private Map unknown;

    SentryEvent(SentryId sentryId, Date date) {
        super(sentryId);
        this.timestamp = date;
    }

    public SentryEvent(Throwable th) {
        this();
        this.throwable = th;
    }

    public SentryEvent() {
        this(new SentryId(), DateUtils.getCurrentDateTime());
    }

    public Date getTimestamp() {
        return (Date) this.timestamp.clone();
    }

    public void setTimestamp(Date date) {
        this.timestamp = date;
    }

    public Message getMessage() {
        return this.message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public List getThreads() {
        SentryValues sentryValues = this.threads;
        if (sentryValues != null) {
            return sentryValues.getValues();
        }
        return null;
    }

    public void setThreads(List list) {
        this.threads = new SentryValues(list);
    }

    public List getExceptions() {
        SentryValues sentryValues = this.exception;
        if (sentryValues == null) {
            return null;
        }
        return sentryValues.getValues();
    }

    public void setExceptions(List list) {
        this.exception = new SentryValues(list);
    }

    public SentryLevel getLevel() {
        return this.level;
    }

    public void setLevel(SentryLevel sentryLevel) {
        this.level = sentryLevel;
    }

    public String getTransaction() {
        return this.transaction;
    }

    public void setTransaction(String str) {
        this.transaction = str;
    }

    public List getFingerprints() {
        return this.fingerprint;
    }

    public void setFingerprints(List list) {
        this.fingerprint = list != null ? new ArrayList(list) : null;
    }

    Map getModules() {
        return this.modules;
    }

    public void setModules(Map map) {
        this.modules = CollectionUtils.newHashMap(map);
    }

    public boolean isCrashed() {
        return getUnhandledException() != null;
    }

    public SentryException getUnhandledException() {
        SentryValues sentryValues = this.exception;
        if (sentryValues == null) {
            return null;
        }
        for (SentryException sentryException : sentryValues.getValues()) {
            if (sentryException.getMechanism() != null && sentryException.getMechanism().isHandled() != null && !sentryException.getMechanism().isHandled().booleanValue()) {
                return sentryException;
            }
        }
        return null;
    }

    public boolean isErrored() {
        SentryValues sentryValues = this.exception;
        return (sentryValues == null || sentryValues.getValues().isEmpty()) ? false : true;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name(DiagnosticsEntry.TIMESTAMP_KEY).value(iLogger, this.timestamp);
        if (this.message != null) {
            objectWriter.name("message").value(iLogger, this.message);
        }
        if (this.logger != null) {
            objectWriter.name("logger").value(this.logger);
        }
        SentryValues sentryValues = this.threads;
        if (sentryValues != null && !sentryValues.getValues().isEmpty()) {
            objectWriter.name("threads");
            objectWriter.beginObject();
            objectWriter.name("values").value(iLogger, this.threads.getValues());
            objectWriter.endObject();
        }
        SentryValues sentryValues2 = this.exception;
        if (sentryValues2 != null && !sentryValues2.getValues().isEmpty()) {
            objectWriter.name("exception");
            objectWriter.beginObject();
            objectWriter.name("values").value(iLogger, this.exception.getValues());
            objectWriter.endObject();
        }
        if (this.level != null) {
            objectWriter.name("level").value(iLogger, this.level);
        }
        if (this.transaction != null) {
            objectWriter.name("transaction").value(this.transaction);
        }
        if (this.fingerprint != null) {
            objectWriter.name("fingerprint").value(iLogger, this.fingerprint);
        }
        if (this.modules != null) {
            objectWriter.name("modules").value(iLogger, this.modules);
        }
        new SentryBaseEvent.Serializer().serialize(this, objectWriter, iLogger);
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

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public SentryEvent deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            SentryEvent sentryEvent = new SentryEvent();
            SentryBaseEvent.Deserializer deserializer = new SentryBaseEvent.Deserializer();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "fingerprint":
                        List list = (List) objectReader.nextObjectOrNull();
                        if (list == null) {
                            break;
                        } else {
                            sentryEvent.fingerprint = list;
                            break;
                        }
                        break;
                    case "threads":
                        objectReader.beginObject();
                        objectReader.nextName();
                        sentryEvent.threads = new SentryValues(objectReader.nextListOrNull(iLogger, new SentryThread.Deserializer()));
                        objectReader.endObject();
                        break;
                    case "logger":
                        sentryEvent.logger = objectReader.nextStringOrNull();
                        break;
                    case "timestamp":
                        Date dateNextDateOrNull = objectReader.nextDateOrNull(iLogger);
                        if (dateNextDateOrNull == null) {
                            break;
                        } else {
                            sentryEvent.timestamp = dateNextDateOrNull;
                            break;
                        }
                        break;
                    case "level":
                        sentryEvent.level = (SentryLevel) objectReader.nextOrNull(iLogger, new SentryLevel.Deserializer());
                        break;
                    case "message":
                        sentryEvent.message = (Message) objectReader.nextOrNull(iLogger, new Message.Deserializer());
                        break;
                    case "modules":
                        sentryEvent.modules = CollectionUtils.newConcurrentHashMap((Map) objectReader.nextObjectOrNull());
                        break;
                    case "exception":
                        objectReader.beginObject();
                        objectReader.nextName();
                        sentryEvent.exception = new SentryValues(objectReader.nextListOrNull(iLogger, new SentryException.Deserializer()));
                        objectReader.endObject();
                        break;
                    case "transaction":
                        sentryEvent.transaction = objectReader.nextStringOrNull();
                        break;
                    default:
                        if (!deserializer.deserializeValue(sentryEvent, strNextName, objectReader, iLogger)) {
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap();
                            }
                            objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                            break;
                        } else {
                            break;
                        }
                        break;
                }
            }
            sentryEvent.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return sentryEvent;
        }
    }
}
