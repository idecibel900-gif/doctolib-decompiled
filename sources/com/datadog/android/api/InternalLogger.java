package com.datadog.android.api;

import com.datadog.android.core.internal.logger.SdkInternalLogger;
import com.datadog.android.core.metrics.PerformanceMetric;
import com.datadog.android.core.metrics.TelemetryMetricType;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public interface InternalLogger {
    public static final Companion Companion = Companion.$$INSTANCE;

    public enum Level {
        VERBOSE,
        DEBUG,
        INFO,
        WARN,
        ERROR
    }

    public enum Target {
        USER,
        MAINTAINER,
        TELEMETRY
    }

    void log(Level level, Target target, Function0 function0, Throwable th, boolean z, Map map);

    void log(Level level, List list, Function0 function0, Throwable th, boolean z, Map map);

    void logApiUsage(float f, Function0 function0);

    void logMetric(Function0 function0, Map map, float f, Float f2);

    PerformanceMetric startPerformanceMeasure(String str, TelemetryMetricType telemetryMetricType, float f, String str2);

    public static final class DefaultImpls {
        public static /* synthetic */ void log$default(InternalLogger internalLogger, Level level, Target target, Function0 function0, Throwable th, boolean z, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
            }
            if ((i & 8) != 0) {
                th = null;
            }
            if ((i & 16) != 0) {
                z = false;
            }
            if ((i & 32) != 0) {
                map = null;
            }
            internalLogger.log(level, target, function0, th, z, map);
        }

        public static /* synthetic */ void log$default(InternalLogger internalLogger, Level level, List list, Function0 function0, Throwable th, boolean z, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
            }
            if ((i & 8) != 0) {
                th = null;
            }
            if ((i & 16) != 0) {
                z = false;
            }
            if ((i & 32) != 0) {
                map = null;
            }
            internalLogger.log(level, list, function0, th, z, map);
        }

        public static /* synthetic */ void logMetric$default(InternalLogger internalLogger, Function0 function0, Map map, float f, Float f2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logMetric");
            }
            if ((i & 8) != 0) {
                f2 = null;
            }
            internalLogger.logMetric(function0, map, f, f2);
        }

        public static /* synthetic */ void logApiUsage$default(InternalLogger internalLogger, float f, Function0 function0, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logApiUsage");
            }
            if ((i & 1) != 0) {
                f = 15.0f;
            }
            internalLogger.logApiUsage(f, function0);
        }
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final InternalLogger UNBOUND = new SdkInternalLogger(null, null, null, 6, null);

        private Companion() {
        }

        public final InternalLogger getUNBOUND() {
            return UNBOUND;
        }
    }
}
