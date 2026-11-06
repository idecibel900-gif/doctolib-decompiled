package io.sentry;

import io.sentry.util.SentryRandom;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryAppStartProfilingOptions implements JsonSerializable {
    boolean continuousProfileSampled;
    boolean isContinuousProfilingEnabled;
    boolean isEnableAppStartProfiling;
    boolean isProfilingEnabled;
    boolean isStartProfilerOnAppStart;
    ProfileLifecycle profileLifecycle;
    Double profileSampleRate;
    boolean profileSampled;
    String profilingTracesDirPath;
    int profilingTracesHz;
    Double traceSampleRate;
    boolean traceSampled;
    private Map unknown;

    public SentryAppStartProfilingOptions() {
        this.traceSampled = false;
        this.traceSampleRate = null;
        this.profileSampled = false;
        this.profileSampleRate = null;
        this.continuousProfileSampled = false;
        this.profilingTracesDirPath = null;
        this.isProfilingEnabled = false;
        this.isContinuousProfilingEnabled = false;
        this.profileLifecycle = ProfileLifecycle.MANUAL;
        this.profilingTracesHz = 0;
        this.isEnableAppStartProfiling = true;
        this.isStartProfilerOnAppStart = false;
    }

    SentryAppStartProfilingOptions(SentryOptions sentryOptions, TracesSamplingDecision tracesSamplingDecision) {
        this.traceSampled = tracesSamplingDecision.getSampled().booleanValue();
        this.traceSampleRate = tracesSamplingDecision.getSampleRate();
        this.profileSampled = tracesSamplingDecision.getProfileSampled().booleanValue();
        this.profileSampleRate = tracesSamplingDecision.getProfileSampleRate();
        this.continuousProfileSampled = sentryOptions.getInternalTracesSampler().sampleSessionProfile(SentryRandom.current().nextDouble());
        this.profilingTracesDirPath = sentryOptions.getProfilingTracesDirPath();
        this.isProfilingEnabled = sentryOptions.isProfilingEnabled();
        this.isContinuousProfilingEnabled = sentryOptions.isContinuousProfilingEnabled();
        this.profileLifecycle = sentryOptions.getProfileLifecycle();
        this.profilingTracesHz = sentryOptions.getProfilingTracesHz();
        this.isEnableAppStartProfiling = sentryOptions.isEnableAppStartProfiling();
        this.isStartProfilerOnAppStart = sentryOptions.isStartProfilerOnAppStart();
    }

    public boolean isProfileSampled() {
        return this.profileSampled;
    }

    public boolean isContinuousProfileSampled() {
        return this.continuousProfileSampled;
    }

    public ProfileLifecycle getProfileLifecycle() {
        return this.profileLifecycle;
    }

    public Double getProfileSampleRate() {
        return this.profileSampleRate;
    }

    public boolean isTraceSampled() {
        return this.traceSampled;
    }

    public Double getTraceSampleRate() {
        return this.traceSampleRate;
    }

    public String getProfilingTracesDirPath() {
        return this.profilingTracesDirPath;
    }

    public boolean isProfilingEnabled() {
        return this.isProfilingEnabled;
    }

    public boolean isContinuousProfilingEnabled() {
        return this.isContinuousProfilingEnabled;
    }

    public int getProfilingTracesHz() {
        return this.profilingTracesHz;
    }

    public boolean isEnableAppStartProfiling() {
        return this.isEnableAppStartProfiling;
    }

    public boolean isStartProfilerOnAppStart() {
        return this.isStartProfilerOnAppStart;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("profile_sampled").value(iLogger, Boolean.valueOf(this.profileSampled));
        objectWriter.name("profile_sample_rate").value(iLogger, this.profileSampleRate);
        objectWriter.name("continuous_profile_sampled").value(iLogger, Boolean.valueOf(this.continuousProfileSampled));
        objectWriter.name("trace_sampled").value(iLogger, Boolean.valueOf(this.traceSampled));
        objectWriter.name("trace_sample_rate").value(iLogger, this.traceSampleRate);
        objectWriter.name("profiling_traces_dir_path").value(iLogger, this.profilingTracesDirPath);
        objectWriter.name("is_profiling_enabled").value(iLogger, Boolean.valueOf(this.isProfilingEnabled));
        objectWriter.name("is_continuous_profiling_enabled").value(iLogger, Boolean.valueOf(this.isContinuousProfilingEnabled));
        objectWriter.name("profile_lifecycle").value(iLogger, this.profileLifecycle.name());
        objectWriter.name("profiling_traces_hz").value(iLogger, Integer.valueOf(this.profilingTracesHz));
        objectWriter.name("is_enable_app_start_profiling").value(iLogger, Boolean.valueOf(this.isEnableAppStartProfiling));
        objectWriter.name("is_start_profiler_on_app_start").value(iLogger, Boolean.valueOf(this.isStartProfilerOnAppStart));
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
        public SentryAppStartProfilingOptions deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            SentryAppStartProfilingOptions sentryAppStartProfilingOptions = new SentryAppStartProfilingOptions();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "is_enable_app_start_profiling":
                        Boolean boolNextBooleanOrNull = objectReader.nextBooleanOrNull();
                        if (boolNextBooleanOrNull != null) {
                            sentryAppStartProfilingOptions.isEnableAppStartProfiling = boolNextBooleanOrNull.booleanValue();
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "trace_sampled":
                        Boolean boolNextBooleanOrNull2 = objectReader.nextBooleanOrNull();
                        if (boolNextBooleanOrNull2 != null) {
                            sentryAppStartProfilingOptions.traceSampled = boolNextBooleanOrNull2.booleanValue();
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "profiling_traces_dir_path":
                        String strNextStringOrNull = objectReader.nextStringOrNull();
                        if (strNextStringOrNull != null) {
                            sentryAppStartProfilingOptions.profilingTracesDirPath = strNextStringOrNull;
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "is_continuous_profiling_enabled":
                        Boolean boolNextBooleanOrNull3 = objectReader.nextBooleanOrNull();
                        if (boolNextBooleanOrNull3 != null) {
                            sentryAppStartProfilingOptions.isContinuousProfilingEnabled = boolNextBooleanOrNull3.booleanValue();
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "is_profiling_enabled":
                        Boolean boolNextBooleanOrNull4 = objectReader.nextBooleanOrNull();
                        if (boolNextBooleanOrNull4 != null) {
                            sentryAppStartProfilingOptions.isProfilingEnabled = boolNextBooleanOrNull4.booleanValue();
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "is_start_profiler_on_app_start":
                        Boolean boolNextBooleanOrNull5 = objectReader.nextBooleanOrNull();
                        if (boolNextBooleanOrNull5 != null) {
                            sentryAppStartProfilingOptions.isStartProfilerOnAppStart = boolNextBooleanOrNull5.booleanValue();
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "profile_sampled":
                        Boolean boolNextBooleanOrNull6 = objectReader.nextBooleanOrNull();
                        if (boolNextBooleanOrNull6 != null) {
                            sentryAppStartProfilingOptions.profileSampled = boolNextBooleanOrNull6.booleanValue();
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "profile_lifecycle":
                        String strNextStringOrNull2 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull2 != null) {
                            try {
                                sentryAppStartProfilingOptions.profileLifecycle = ProfileLifecycle.valueOf(strNextStringOrNull2);
                            } catch (IllegalArgumentException unused) {
                                iLogger.log(SentryLevel.ERROR, "Error when deserializing ProfileLifecycle: " + strNextStringOrNull2, new Object[0]);
                            }
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "continuous_profile_sampled":
                        Boolean boolNextBooleanOrNull7 = objectReader.nextBooleanOrNull();
                        if (boolNextBooleanOrNull7 != null) {
                            sentryAppStartProfilingOptions.continuousProfileSampled = boolNextBooleanOrNull7.booleanValue();
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "profiling_traces_hz":
                        Integer numNextIntegerOrNull = objectReader.nextIntegerOrNull();
                        if (numNextIntegerOrNull != null) {
                            sentryAppStartProfilingOptions.profilingTracesHz = numNextIntegerOrNull.intValue();
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "trace_sample_rate":
                        Double dNextDoubleOrNull = objectReader.nextDoubleOrNull();
                        if (dNextDoubleOrNull != null) {
                            sentryAppStartProfilingOptions.traceSampleRate = dNextDoubleOrNull;
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "profile_sample_rate":
                        Double dNextDoubleOrNull2 = objectReader.nextDoubleOrNull();
                        if (dNextDoubleOrNull2 != null) {
                            sentryAppStartProfilingOptions.profileSampleRate = dNextDoubleOrNull2;
                            break;
                        } else {
                            break;
                        }
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            sentryAppStartProfilingOptions.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return sentryAppStartProfilingOptions;
        }
    }
}
