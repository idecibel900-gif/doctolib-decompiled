package com.datadog.android.log;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.core.sampling.RateBasedSampler;
import com.datadog.android.log.internal.LogsFeature;
import com.datadog.android.log.internal.domain.DatadogLogGenerator;
import com.datadog.android.log.internal.logger.CombinedLogHandler;
import com.datadog.android.log.internal.logger.DatadogLogHandler;
import com.datadog.android.log.internal.logger.LogHandler;
import com.datadog.android.log.internal.logger.LogcatLogHandler;
import com.datadog.android.log.internal.logger.NoOpLogHandler;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class Logger {
    public static final Companion Companion = new Companion(null);
    private final ConcurrentHashMap attributes;
    private LogHandler handler;
    private final CopyOnWriteArraySet tags;

    public Logger(LogHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handler = handler;
        this.attributes = new ConcurrentHashMap();
        this.tags = new CopyOnWriteArraySet();
    }

    public static /* synthetic */ void d$default(Logger logger, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        logger.d(str, th, map);
    }

    public final void d(String message, Throwable th, Map attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        internalLog$dd_sdk_android_logs_release$default(this, 3, message, th, attributes, null, 16, null);
    }

    public static /* synthetic */ void i$default(Logger logger, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        logger.i(str, th, map);
    }

    public final void i(String message, Throwable th, Map attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        internalLog$dd_sdk_android_logs_release$default(this, 4, message, th, attributes, null, 16, null);
    }

    public static /* synthetic */ void w$default(Logger logger, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        logger.w(str, th, map);
    }

    public final void w(String message, Throwable th, Map attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        internalLog$dd_sdk_android_logs_release$default(this, 5, message, th, attributes, null, 16, null);
    }

    public static /* synthetic */ void e$default(Logger logger, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        logger.e(str, th, map);
    }

    public final void e(String message, Throwable th, Map attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        internalLog$dd_sdk_android_logs_release$default(this, 6, message, th, attributes, null, 16, null);
    }

    public final void log(int i, String message, String str, String str2, String str3, Map attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        internalLog$default(this, i, message, str, str2, str3, attributes, null, 64, null);
    }

    public static final class Builder {
        private boolean bundleWithRumEnabled;
        private boolean bundleWithTraceEnabled;
        private boolean logcatLogsEnabled;
        private String loggerName;
        private int minDatadogLogsPriority;
        private boolean networkInfoEnabled;
        private float sampleRate;
        private final FeatureSdkCore sdkCore;
        private String serviceName;

        public Builder(SdkCore sdkCore) {
            Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
            this.sdkCore = (FeatureSdkCore) sdkCore;
            this.bundleWithTraceEnabled = true;
            this.bundleWithRumEnabled = true;
            this.sampleRate = 100.0f;
            this.minDatadogLogsPriority = -1;
        }

        public final Logger build() {
            LogHandler logHandlerBuildLogcatHandler;
            FeatureScope feature = this.sdkCore.getFeature("logs");
            LogsFeature logsFeature = feature != null ? (LogsFeature) feature.unwrap() : null;
            boolean z = this.sampleRate > 0.0f;
            if (z && this.logcatLogsEnabled) {
                logHandlerBuildLogcatHandler = new CombinedLogHandler(buildDatadogHandler(this.sdkCore, logsFeature), buildLogcatHandler(this.sdkCore));
            } else if (z) {
                logHandlerBuildLogcatHandler = buildDatadogHandler(this.sdkCore, logsFeature);
            } else {
                logHandlerBuildLogcatHandler = this.logcatLogsEnabled ? buildLogcatHandler(this.sdkCore) : new NoOpLogHandler();
            }
            return new Logger(logHandlerBuildLogcatHandler);
        }

        public final Builder setLogcatLogsEnabled(boolean z) {
            this.logcatLogsEnabled = z;
            return this;
        }

        public final Builder setName(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.loggerName = name;
            return this;
        }

        public final Builder setBundleWithTraceEnabled(boolean z) {
            this.bundleWithTraceEnabled = z;
            return this;
        }

        public final Builder setBundleWithRumEnabled(boolean z) {
            this.bundleWithRumEnabled = z;
            return this;
        }

        private final LogHandler buildLogcatHandler(SdkCore sdkCore) {
            String service = this.serviceName;
            if (service == null) {
                service = sdkCore != null ? sdkCore.getService() : null;
                if (service == null) {
                    service = "unknown";
                }
            }
            return new LogcatLogHandler(service, true, false, 4, null);
        }

        private final LogHandler buildDatadogHandler(FeatureSdkCore featureSdkCore, LogsFeature logsFeature) {
            if (logsFeature == null) {
                InternalLogger.DefaultImpls.log$default(featureSdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.log.Logger$Builder$buildDatadogHandler$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "You're trying to create a Logger instance, but the SDK was not yet initialized. This Logger will not be able to send any messages. Please initialize the Datadog SDK first before creating a new Logger instance.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return new NoOpLogHandler();
            }
            String packageName$dd_sdk_android_logs_release = this.loggerName;
            if (packageName$dd_sdk_android_logs_release == null) {
                packageName$dd_sdk_android_logs_release = logsFeature.getPackageName$dd_sdk_android_logs_release();
            }
            String str = packageName$dd_sdk_android_logs_release;
            String service = this.serviceName;
            if (service == null) {
                service = featureSdkCore.getService();
            }
            DatadogLogGenerator datadogLogGenerator = new DatadogLogGenerator(service);
            DataWriter dataWriter$dd_sdk_android_logs_release = logsFeature.getDataWriter$dd_sdk_android_logs_release();
            int i = this.minDatadogLogsPriority;
            return new DatadogLogHandler(str, datadogLogGenerator, featureSdkCore, dataWriter$dd_sdk_android_logs_release, this.networkInfoEnabled, this.bundleWithTraceEnabled, this.bundleWithRumEnabled, new RateBasedSampler(this.sampleRate), i);
        }
    }

    public static /* synthetic */ void internalLog$dd_sdk_android_logs_release$default(Logger logger, int i, String str, Throwable th, Map map, Long l, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            l = null;
        }
        logger.internalLog$dd_sdk_android_logs_release(i, str, th, map, l);
    }

    public final void internalLog$dd_sdk_android_logs_release(int i, String message, Throwable th, Map localAttributes, Long l) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(localAttributes, "localAttributes");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.attributes);
        linkedHashMap.putAll(localAttributes);
        this.handler.handleLog(i, message, th, linkedHashMap, new HashSet(this.tags), l);
    }

    static /* synthetic */ void internalLog$default(Logger logger, int i, String str, String str2, String str3, String str4, Map map, Long l, int i2, Object obj) {
        logger.internalLog(i, str, str2, str3, str4, map, (i2 & 64) != 0 ? null : l);
    }

    private final void internalLog(int i, String str, String str2, String str3, String str4, Map map, Long l) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.attributes);
        linkedHashMap.putAll(map);
        this.handler.handleLog(i, str, str2, str3, str4, linkedHashMap, new HashSet(this.tags), l);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
