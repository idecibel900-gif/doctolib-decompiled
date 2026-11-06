package com.datadog.android.core.internal.logger;

import com.datadog.android.BuildConfig;
import com.datadog.android.Datadog;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.internal.metrics.MethodCalledTelemetry;
import com.datadog.android.core.metrics.PerformanceMetric;
import com.datadog.android.core.metrics.TelemetryMetricType;
import com.datadog.android.core.sampling.RateBasedSampler;
import com.datadog.android.internal.attributes.LocalAttribute$Key;
import com.datadog.android.internal.attributes.LocalAttributeKt;
import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class SdkInternalLogger implements InternalLogger {
    public static final Companion Companion = new Companion(null);
    private final LogcatLogHandler maintainerLogger;
    private final Set onlyOnceMaintainerMessages;
    private final Set onlyOnceTelemetryMessages;
    private final Set onlyOnceUserMessages;
    private final FeatureSdkCore sdkCore;
    private final LogcatLogHandler userLogger;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[InternalLogger.Target.values().length];
            try {
                iArr[InternalLogger.Target.USER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InternalLogger.Target.MAINTAINER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InternalLogger.Target.TELEMETRY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TelemetryMetricType.values().length];
            try {
                iArr2[TelemetryMetricType.MethodCalled.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[InternalLogger.Level.values().length];
            try {
                iArr3[InternalLogger.Level.VERBOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[InternalLogger.Level.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[InternalLogger.Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[InternalLogger.Level.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[InternalLogger.Level.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public SdkInternalLogger(FeatureSdkCore featureSdkCore, Function0 userLogHandlerFactory, Function0 maintainerLogHandlerFactory) {
        Intrinsics.checkNotNullParameter(userLogHandlerFactory, "userLogHandlerFactory");
        Intrinsics.checkNotNullParameter(maintainerLogHandlerFactory, "maintainerLogHandlerFactory");
        this.sdkCore = featureSdkCore;
        this.userLogger = (LogcatLogHandler) userLogHandlerFactory.invoke();
        this.maintainerLogger = (LogcatLogHandler) maintainerLogHandlerFactory.invoke();
        this.onlyOnceUserMessages = new LinkedHashSet();
        this.onlyOnceMaintainerMessages = new LinkedHashSet();
        this.onlyOnceTelemetryMessages = new LinkedHashSet();
    }

    public /* synthetic */ SdkInternalLogger(FeatureSdkCore featureSdkCore, Function0 function0, Function0 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(featureSdkCore, (i & 2) != 0 ? new Function0() { // from class: com.datadog.android.core.internal.logger.SdkInternalLogger.1
            @Override // kotlin.jvm.functions.Function0
            public final LogcatLogHandler invoke() {
                return new LogcatLogHandler("Datadog", new Function1() { // from class: com.datadog.android.core.internal.logger.SdkInternalLogger.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).intValue());
                    }

                    public final Boolean invoke(int i2) {
                        return Boolean.valueOf(i2 >= Datadog.getVerbosity());
                    }
                });
            }
        } : function0, (i & 4) != 0 ? new Function0() { // from class: com.datadog.android.core.internal.logger.SdkInternalLogger.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final LogcatLogHandler invoke() {
                Boolean LOGCAT_ENABLED = BuildConfig.LOGCAT_ENABLED;
                Intrinsics.checkNotNullExpressionValue(LOGCAT_ENABLED, "LOGCAT_ENABLED");
                Function1 function2 = null;
                Object[] objArr = 0;
                if (LOGCAT_ENABLED.booleanValue()) {
                    return new LogcatLogHandler("DD_LOG", function2, 2, objArr == true ? 1 : 0);
                }
                return null;
            }
        } : function1);
    }

    @Override // com.datadog.android.api.InternalLogger
    public void log(InternalLogger.Level level, InternalLogger.Target target, Function0 messageBuilder, Throwable th, boolean z, Map map) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(messageBuilder, "messageBuilder");
        int i = WhenMappings.$EnumSwitchMapping$0[target.ordinal()];
        if (i == 1) {
            logToUser(level, messageBuilder, th, z);
        } else if (i == 2) {
            logToMaintainer(level, messageBuilder, th, z);
        } else {
            if (i != 3) {
                return;
            }
            logToTelemetry(level, messageBuilder, th, z, map);
        }
    }

    @Override // com.datadog.android.api.InternalLogger
    public void log(InternalLogger.Level level, List targets, Function0 messageBuilder, Throwable th, boolean z, Map map) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(targets, "targets");
        Intrinsics.checkNotNullParameter(messageBuilder, "messageBuilder");
        Iterator it = targets.iterator();
        while (it.hasNext()) {
            log(level, (InternalLogger.Target) it.next(), messageBuilder, th, z, map);
        }
    }

    @Override // com.datadog.android.api.InternalLogger
    public void logMetric(Function0 messageBuilder, Map additionalProperties, float f, Float f2) {
        FeatureSdkCore featureSdkCore;
        FeatureScope feature;
        Intrinsics.checkNotNullParameter(messageBuilder, "messageBuilder");
        Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
        if (!sample(f) || (featureSdkCore = this.sdkCore) == null || (feature = featureSdkCore.getFeature("rum")) == null) {
            return;
        }
        feature.sendEvent(new InternalTelemetryEvent.Metric((String) messageBuilder.invoke(), LocalAttributeKt.enrichWithNonNullAttribute(LocalAttributeKt.enrichWithNonNullAttribute(MapsKt.toMutableMap(additionalProperties), LocalAttribute$Key.CREATION_SAMPLING_RATE, f2), LocalAttribute$Key.REPORTING_SAMPLING_RATE, Float.valueOf(f))));
    }

    @Override // com.datadog.android.api.InternalLogger
    public PerformanceMetric startPerformanceMeasure(String callerClass, TelemetryMetricType metric, float f, String operationName) {
        Intrinsics.checkNotNullParameter(callerClass, "callerClass");
        Intrinsics.checkNotNullParameter(metric, "metric");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        if (!sample(f)) {
            return null;
        }
        if (WhenMappings.$EnumSwitchMapping$1[metric.ordinal()] != 1) {
            throw new NoWhenBranchMatchedException();
        }
        return new MethodCalledTelemetry(this, operationName, callerClass, f, 0L, 16, null);
    }

    @Override // com.datadog.android.api.InternalLogger
    public void logApiUsage(float f, Function0 apiUsageEventBuilder) {
        FeatureSdkCore featureSdkCore;
        FeatureScope feature;
        Intrinsics.checkNotNullParameter(apiUsageEventBuilder, "apiUsageEventBuilder");
        if (!sample(f) || (featureSdkCore = this.sdkCore) == null || (feature = featureSdkCore.getFeature("rum")) == null) {
            return;
        }
        InternalTelemetryEvent.ApiUsage apiUsage = (InternalTelemetryEvent.ApiUsage) apiUsageEventBuilder.invoke();
        LocalAttributeKt.enrichWithNonNullAttribute(apiUsage.getAdditionalProperties(), LocalAttribute$Key.REPORTING_SAMPLING_RATE, Float.valueOf(f));
        feature.sendEvent(apiUsage);
    }

    public final boolean sample(float f) {
        return new RateBasedSampler(f).sample(Unit.INSTANCE);
    }

    private final void logToUser(InternalLogger.Level level, Function0 function0, Throwable th, boolean z) {
        sendToLogHandler(this.userLogger, level, function0, th, z, this.onlyOnceUserMessages);
    }

    private final void logToMaintainer(InternalLogger.Level level, Function0 function0, Throwable th, boolean z) {
        LogcatLogHandler logcatLogHandler = this.maintainerLogger;
        if (logcatLogHandler != null) {
            sendToLogHandler(logcatLogHandler, level, function0, th, z, this.onlyOnceMaintainerMessages);
        }
    }

    private final void sendToLogHandler(LogcatLogHandler logcatLogHandler, InternalLogger.Level level, Function0 function0, Throwable th, boolean z, Set set) {
        if (logcatLogHandler.canLog(toLogLevel(level))) {
            String strWithSdkName = withSdkName((String) function0.invoke());
            if (z) {
                if (set.contains(strWithSdkName)) {
                    return;
                } else {
                    set.add(strWithSdkName);
                }
            }
            logcatLogHandler.log(toLogLevel(level), strWithSdkName, th);
        }
    }

    private final void logToTelemetry(InternalLogger.Level level, Function0 function0, Throwable th, boolean z, Map map) {
        FeatureScope feature;
        Object error;
        FeatureSdkCore featureSdkCore = this.sdkCore;
        if (featureSdkCore == null || (feature = featureSdkCore.getFeature("rum")) == null) {
            return;
        }
        String str = (String) function0.invoke();
        if (z) {
            if (this.onlyOnceTelemetryMessages.contains(str)) {
                return;
            } else {
                this.onlyOnceTelemetryMessages.add(str);
            }
        }
        if (level == InternalLogger.Level.ERROR || level == InternalLogger.Level.WARN || th != null) {
            error = new InternalTelemetryEvent.Log.Error(str, map, th, null, null, 24, null);
        } else {
            error = new InternalTelemetryEvent.Log.Debug(str, map);
        }
        feature.sendEvent(error);
    }

    private final int toLogLevel(InternalLogger.Level level) {
        int i = WhenMappings.$EnumSwitchMapping$2[level.ordinal()];
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 4;
        }
        if (i == 4) {
            return 5;
        }
        if (i == 5) {
            return 6;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String withSdkName(String str) {
        FeatureSdkCore featureSdkCore = this.sdkCore;
        String name = featureSdkCore != null ? featureSdkCore.getName() : null;
        if (name == null) {
            return str;
        }
        return "[" + name + "]: " + str;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
