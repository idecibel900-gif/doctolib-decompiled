package io.sentry;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.protocol.User;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.StringUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class Session implements JsonSerializable {
    private String abnormalMechanism;
    private final String distinctId;
    private Double duration;
    private final String environment;
    private final AtomicInteger errorCount;
    private Boolean init;
    private final String ipAddress;
    private final String release;
    private Long sequence;
    private final String sessionId;
    private final AutoClosableReentrantLock sessionLock;
    private final Date started;
    private State status;
    private Date timestamp;
    private Map unknown;
    private String userAgent;

    public enum State {
        Ok,
        Exited,
        Crashed,
        Abnormal
    }

    public Session(State state, Date date, Date date2, int i, String str, String str2, Boolean bool, Long l, Double d, String str3, String str4, String str5, String str6, String str7) {
        this.sessionLock = new AutoClosableReentrantLock();
        this.status = state;
        this.started = date;
        this.timestamp = date2;
        this.errorCount = new AtomicInteger(i);
        this.distinctId = str;
        this.sessionId = str2;
        this.init = bool;
        this.sequence = l;
        this.duration = d;
        this.ipAddress = str3;
        this.userAgent = str4;
        this.environment = str5;
        this.release = str6;
        this.abnormalMechanism = str7;
    }

    public Session(String str, User user, String str2, String str3) {
        this(State.Ok, DateUtils.getCurrentDateTime(), DateUtils.getCurrentDateTime(), 0, str, SentryUUID.generateSentryId(), Boolean.TRUE, null, null, user != null ? user.getIpAddress() : null, null, str2, str3, null);
    }

    public boolean isTerminated() {
        return this.status != State.Ok;
    }

    public Date getStarted() {
        Date date = this.started;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getRelease() {
        return this.release;
    }

    public Boolean getInit() {
        return this.init;
    }

    public void setInitAsTrue() {
        this.init = Boolean.TRUE;
    }

    public int errorCount() {
        return this.errorCount.get();
    }

    public State getStatus() {
        return this.status;
    }

    public String getAbnormalMechanism() {
        return this.abnormalMechanism;
    }

    public void end() {
        end(DateUtils.getCurrentDateTime());
    }

    public void end(Date date) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.sessionLock.acquire();
        try {
            this.init = null;
            if (this.status == State.Ok) {
                this.status = State.Exited;
            }
            if (date != null) {
                this.timestamp = date;
            } else {
                this.timestamp = DateUtils.getCurrentDateTime();
            }
            Date date2 = this.timestamp;
            if (date2 != null) {
                this.duration = Double.valueOf(calculateDurationTime(date2));
                this.sequence = Long.valueOf(getSequenceTimestamp(this.timestamp));
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private double calculateDurationTime(Date date) {
        return Math.abs(date.getTime() - this.started.getTime()) / 1000.0d;
    }

    public boolean update(State state, String str, boolean z) {
        return update(state, str, z, null);
    }

    public boolean update(State state, String str, boolean z, String str2) {
        boolean z2;
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.sessionLock.acquire();
        boolean z3 = true;
        if (state != null) {
            try {
                this.status = state;
                z2 = true;
            } catch (Throwable th) {
                if (iSentryLifecycleTokenAcquire != null) {
                    try {
                        iSentryLifecycleTokenAcquire.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } else {
            z2 = false;
        }
        if (str != null) {
            this.userAgent = str;
            z2 = true;
        }
        if (z) {
            this.errorCount.addAndGet(1);
            z2 = true;
        }
        if (str2 != null) {
            this.abnormalMechanism = str2;
        } else {
            z3 = z2;
        }
        if (z3) {
            this.init = null;
            Date currentDateTime = DateUtils.getCurrentDateTime();
            this.timestamp = currentDateTime;
            if (currentDateTime != null) {
                this.sequence = Long.valueOf(getSequenceTimestamp(currentDateTime));
            }
        }
        if (iSentryLifecycleTokenAcquire != null) {
            iSentryLifecycleTokenAcquire.close();
        }
        return z3;
    }

    private long getSequenceTimestamp(Date date) {
        long time = date.getTime();
        return time < 0 ? Math.abs(time) : time;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Session m5166clone() {
        return new Session(this.status, this.started, this.timestamp, this.errorCount.get(), this.distinctId, this.sessionId, this.init, this.sequence, this.duration, this.ipAddress, this.userAgent, this.environment, this.release, this.abnormalMechanism);
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.sessionId != null) {
            objectWriter.name("sid").value(this.sessionId);
        }
        if (this.distinctId != null) {
            objectWriter.name("did").value(this.distinctId);
        }
        if (this.init != null) {
            objectWriter.name("init").value(this.init);
        }
        objectWriter.name("started").value(iLogger, this.started);
        objectWriter.name("status").value(iLogger, this.status.name().toLowerCase(Locale.ROOT));
        if (this.sequence != null) {
            objectWriter.name("seq").value(this.sequence);
        }
        objectWriter.name("errors").value(this.errorCount.intValue());
        if (this.duration != null) {
            objectWriter.name("duration").value(this.duration);
        }
        if (this.timestamp != null) {
            objectWriter.name(DiagnosticsEntry.TIMESTAMP_KEY).value(iLogger, this.timestamp);
        }
        if (this.abnormalMechanism != null) {
            objectWriter.name("abnormal_mechanism").value(iLogger, this.abnormalMechanism);
        }
        objectWriter.name("attrs");
        objectWriter.beginObject();
        objectWriter.name("release").value(iLogger, this.release);
        if (this.environment != null) {
            objectWriter.name("environment").value(iLogger, this.environment);
        }
        if (this.ipAddress != null) {
            objectWriter.name("ip_address").value(iLogger, this.ipAddress);
        }
        if (this.userAgent != null) {
            objectWriter.name("user_agent").value(iLogger, this.userAgent);
        }
        objectWriter.endObject();
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
        public Session deserialize(ObjectReader objectReader, ILogger iLogger) throws Exception {
            objectReader.beginObject();
            Integer numNextIntegerOrNull = null;
            ConcurrentHashMap concurrentHashMap = null;
            State stateValueOf = null;
            Date dateNextDateOrNull = null;
            Date dateNextDateOrNull2 = null;
            String strNextStringOrNull = null;
            String str = null;
            Boolean boolNextBooleanOrNull = null;
            Long lNextLongOrNull = null;
            Double dNextDoubleOrNull = null;
            String strNextStringOrNull2 = null;
            String strNextStringOrNull3 = null;
            String strNextStringOrNull4 = null;
            String strNextStringOrNull5 = null;
            String strNextStringOrNull6 = null;
            while (true) {
                Integer num = numNextIntegerOrNull;
                ConcurrentHashMap concurrentHashMap2 = concurrentHashMap;
                State state = stateValueOf;
                Date date = dateNextDateOrNull;
                Date date2 = dateNextDateOrNull2;
                if (objectReader.peek() != JsonToken.NAME) {
                    if (state == null) {
                        throw missingRequiredFieldException("status", iLogger);
                    }
                    if (date == null) {
                        throw missingRequiredFieldException("started", iLogger);
                    }
                    if (num == null) {
                        throw missingRequiredFieldException("errors", iLogger);
                    }
                    if (strNextStringOrNull5 == null) {
                        throw missingRequiredFieldException("release", iLogger);
                    }
                    Session session = new Session(state, date, date2, num.intValue(), strNextStringOrNull, str, boolNextBooleanOrNull, lNextLongOrNull, dNextDoubleOrNull, strNextStringOrNull2, strNextStringOrNull3, strNextStringOrNull4, strNextStringOrNull5, strNextStringOrNull6);
                    session.setUnknown(concurrentHashMap2);
                    objectReader.endObject();
                    return session;
                }
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "duration":
                        dNextDoubleOrNull = objectReader.nextDoubleOrNull();
                        numNextIntegerOrNull = num;
                        concurrentHashMap = concurrentHashMap2;
                        stateValueOf = state;
                        dateNextDateOrNull = date;
                        dateNextDateOrNull2 = date2;
                        break;
                    case "started":
                        dateNextDateOrNull = objectReader.nextDateOrNull(iLogger);
                        numNextIntegerOrNull = num;
                        concurrentHashMap = concurrentHashMap2;
                        stateValueOf = state;
                        dateNextDateOrNull2 = date2;
                        break;
                    case "errors":
                        numNextIntegerOrNull = objectReader.nextIntegerOrNull();
                        concurrentHashMap = concurrentHashMap2;
                        stateValueOf = state;
                        dateNextDateOrNull = date;
                        dateNextDateOrNull2 = date2;
                        break;
                    case "status":
                        String strCapitalize = StringUtils.capitalize(objectReader.nextStringOrNull());
                        if (strCapitalize != null) {
                            stateValueOf = State.valueOf(strCapitalize);
                            numNextIntegerOrNull = num;
                            concurrentHashMap = concurrentHashMap2;
                        } else {
                            numNextIntegerOrNull = num;
                            concurrentHashMap = concurrentHashMap2;
                            stateValueOf = state;
                        }
                        dateNextDateOrNull = date;
                        dateNextDateOrNull2 = date2;
                        break;
                    case "did":
                        strNextStringOrNull = objectReader.nextStringOrNull();
                        numNextIntegerOrNull = num;
                        concurrentHashMap = concurrentHashMap2;
                        stateValueOf = state;
                        dateNextDateOrNull = date;
                        dateNextDateOrNull2 = date2;
                        break;
                    case "seq":
                        lNextLongOrNull = objectReader.nextLongOrNull();
                        numNextIntegerOrNull = num;
                        concurrentHashMap = concurrentHashMap2;
                        stateValueOf = state;
                        dateNextDateOrNull = date;
                        dateNextDateOrNull2 = date2;
                        break;
                    case "sid":
                        String strNextStringOrNull7 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull7 == null || !(strNextStringOrNull7.length() == 36 || strNextStringOrNull7.length() == 32)) {
                            iLogger.log(SentryLevel.ERROR, "%s sid is not valid.", strNextStringOrNull7);
                        } else {
                            str = strNextStringOrNull7;
                        }
                        numNextIntegerOrNull = num;
                        concurrentHashMap = concurrentHashMap2;
                        stateValueOf = state;
                        dateNextDateOrNull = date;
                        dateNextDateOrNull2 = date2;
                        break;
                    case "init":
                        boolNextBooleanOrNull = objectReader.nextBooleanOrNull();
                        numNextIntegerOrNull = num;
                        concurrentHashMap = concurrentHashMap2;
                        stateValueOf = state;
                        dateNextDateOrNull = date;
                        dateNextDateOrNull2 = date2;
                        break;
                    case "timestamp":
                        dateNextDateOrNull2 = objectReader.nextDateOrNull(iLogger);
                        numNextIntegerOrNull = num;
                        concurrentHashMap = concurrentHashMap2;
                        stateValueOf = state;
                        dateNextDateOrNull = date;
                        break;
                    case "attrs":
                        objectReader.beginObject();
                        while (objectReader.peek() == JsonToken.NAME) {
                            String strNextName2 = objectReader.nextName();
                            strNextName2.getClass();
                            switch (strNextName2) {
                                case "environment":
                                    strNextStringOrNull4 = objectReader.nextStringOrNull();
                                    break;
                                case "release":
                                    strNextStringOrNull5 = objectReader.nextStringOrNull();
                                    break;
                                case "ip_address":
                                    strNextStringOrNull2 = objectReader.nextStringOrNull();
                                    break;
                                case "user_agent":
                                    strNextStringOrNull3 = objectReader.nextStringOrNull();
                                    break;
                                default:
                                    objectReader.skipValue();
                                    break;
                            }
                        }
                        objectReader.endObject();
                        numNextIntegerOrNull = num;
                        concurrentHashMap = concurrentHashMap2;
                        stateValueOf = state;
                        dateNextDateOrNull = date;
                        dateNextDateOrNull2 = date2;
                        break;
                    case "abnormal_mechanism":
                        strNextStringOrNull6 = objectReader.nextStringOrNull();
                        numNextIntegerOrNull = num;
                        concurrentHashMap = concurrentHashMap2;
                        stateValueOf = state;
                        dateNextDateOrNull = date;
                        dateNextDateOrNull2 = date2;
                        break;
                    default:
                        concurrentHashMap = concurrentHashMap2 == null ? new ConcurrentHashMap() : concurrentHashMap2;
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        numNextIntegerOrNull = num;
                        stateValueOf = state;
                        dateNextDateOrNull = date;
                        dateNextDateOrNull2 = date2;
                        break;
                }
            }
        }

        private Exception missingRequiredFieldException(String str, ILogger iLogger) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            iLogger.log(SentryLevel.ERROR, str2, illegalStateException);
            return illegalStateException;
        }
    }
}
