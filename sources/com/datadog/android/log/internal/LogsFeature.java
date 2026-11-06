package com.datadog.android.log.internal;

import android.content.Context;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.api.context.UserInfo;
import com.datadog.android.api.feature.FeatureEventReceiver;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.feature.StorageBackedFeature;
import com.datadog.android.api.net.RequestFactory;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.FeatureStorageConfiguration;
import com.datadog.android.api.storage.NoOpDataWriter;
import com.datadog.android.core.feature.event.JvmCrash;
import com.datadog.android.event.EventMapper;
import com.datadog.android.event.MapperSerializer;
import com.datadog.android.log.internal.domain.DatadogLogGenerator;
import com.datadog.android.log.internal.domain.LogGenerator;
import com.datadog.android.log.internal.domain.event.LogEventMapperWrapper;
import com.datadog.android.log.internal.domain.event.LogEventSerializer;
import com.datadog.android.log.internal.net.LogsRequestFactory;
import com.datadog.android.log.internal.storage.LogsDataWriter;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class LogsFeature implements StorageBackedFeature, FeatureEventReceiver {
    public static final Companion Companion = new Companion(null);
    private final ConcurrentHashMap attributes;
    private DataWriter dataWriter;
    private final EventMapper eventMapper;
    private final AtomicBoolean initialized;
    private final DatadogLogGenerator logGenerator;
    private final String name;
    private String packageName;
    private final Lazy requestFactory$delegate;
    private final FeatureSdkCore sdkCore;
    private final FeatureStorageConfiguration storageConfiguration;

    /* JADX WARN: Multi-variable type inference failed */
    public LogsFeature(FeatureSdkCore sdkCore, final String str, EventMapper eventMapper) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
        this.sdkCore = sdkCore;
        this.eventMapper = eventMapper;
        this.dataWriter = new NoOpDataWriter();
        this.initialized = new AtomicBoolean(false);
        this.packageName = "";
        this.logGenerator = new DatadogLogGenerator(null, 1, 0 == true ? 1 : 0);
        this.attributes = new ConcurrentHashMap();
        this.name = "logs";
        this.requestFactory$delegate = LazyKt.lazy(new Function0() { // from class: com.datadog.android.log.internal.LogsFeature$requestFactory$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final LogsRequestFactory invoke() {
                return new LogsRequestFactory(str, this.sdkCore.getInternalLogger());
            }
        });
        this.storageConfiguration = FeatureStorageConfiguration.Companion.getDEFAULT();
    }

    public final DataWriter getDataWriter$dd_sdk_android_logs_release() {
        return this.dataWriter;
    }

    public final String getPackageName$dd_sdk_android_logs_release() {
        return this.packageName;
    }

    public final Map getAttributes$dd_sdk_android_logs_release() {
        return MapsKt.toMap(this.attributes);
    }

    @Override // com.datadog.android.api.feature.Feature
    public String getName() {
        return this.name;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onInitialize(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.sdkCore.setEventReceiver(getName(), this);
        String packageName = appContext.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "appContext.packageName");
        this.packageName = packageName;
        this.dataWriter = createDataWriter(this.eventMapper);
        this.initialized.set(true);
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public RequestFactory getRequestFactory() {
        return (RequestFactory) this.requestFactory$delegate.getValue();
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public FeatureStorageConfiguration getStorageConfiguration() {
        return this.storageConfiguration;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onStop() {
        this.sdkCore.removeEventReceiver(getName());
        this.dataWriter = new NoOpDataWriter();
        this.packageName = "";
        this.initialized.set(false);
        this.attributes.clear();
    }

    @Override // com.datadog.android.api.feature.FeatureEventReceiver
    public void onReceive(final Object event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof JvmCrash.Logs) {
            sendJvmCrashLog((JvmCrash.Logs) event);
            return;
        }
        if (!(event instanceof Map)) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.log.internal.LogsFeature.onReceive.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Logs feature receive an event of unsupported type=%s.", Arrays.copyOf(new Object[]{event.getClass().getCanonicalName()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        Map map = (Map) event;
        if (Intrinsics.areEqual(map.get("type"), "ndk_crash")) {
            sendNdkCrashLog(map);
        } else if (Intrinsics.areEqual(map.get("type"), "span_log")) {
            sendSpanLog(map);
        } else {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.log.internal.LogsFeature.onReceive.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Logs feature received an event with unknown value of \"type\" property=%s.", Arrays.copyOf(new Object[]{((Map) event).get("type")}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final DataWriter createDataWriter(EventMapper eventMapper) {
        return new LogsDataWriter(new MapperSerializer(new LogEventMapperWrapper(eventMapper, this.sdkCore.getInternalLogger()), new LogEventSerializer(this.sdkCore.getInternalLogger(), null, 2, 0 == true ? 1 : 0)), this.sdkCore.getInternalLogger());
    }

    private final void sendJvmCrashLog(final JvmCrash.Logs logs) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Map attributes$dd_sdk_android_logs_release = getAttributes$dd_sdk_android_logs_release();
        FeatureScope feature = this.sdkCore.getFeature(getName());
        if (feature != null) {
            FeatureScope.DefaultImpls.withWriteContext$default(feature, false, new Function2() { // from class: com.datadog.android.log.internal.LogsFeature.sendJvmCrashLog.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((DatadogContext) obj, (EventBatchWriter) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(DatadogContext datadogContext, EventBatchWriter eventBatchWriter) {
                    Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
                    Intrinsics.checkNotNullParameter(eventBatchWriter, "eventBatchWriter");
                    DatadogLogGenerator datadogLogGenerator = LogsFeature.this.logGenerator;
                    String loggerName = logs.getLoggerName();
                    String message = logs.getMessage();
                    Throwable throwable = logs.getThrowable();
                    long timestamp = logs.getTimestamp();
                    String threadName = logs.getThreadName();
                    List threads = logs.getThreads();
                    LogsFeature.this.getDataWriter$dd_sdk_android_logs_release().write(eventBatchWriter, LogGenerator.DefaultImpls.generateLog$default(datadogLogGenerator, 9, message, throwable, attributes$dd_sdk_android_logs_release, SetsKt.emptySet(), timestamp, threadName, datadogContext, true, loggerName, true, true, null, null, null, threads, 8192, null), EventType.CRASH);
                    countDownLatch.countDown();
                }
            }, 1, null);
        }
        try {
            countDownLatch.await(500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.log.internal.LogsFeature.sendJvmCrashLog.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Log event write operation wait was interrupted.";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        }
    }

    private final void sendNdkCrashLog(Map map) {
        final LinkedHashMap linkedHashMap;
        Object obj = map.get(DiagnosticsEntry.TIMESTAMP_KEY);
        final Long l = obj instanceof Long ? (Long) obj : null;
        Object obj2 = map.get("message");
        final String str = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = map.get("loggerName");
        final String str2 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = map.get("attributes");
        Map map2 = obj4 instanceof Map ? (Map) obj4 : null;
        if (map2 != null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : map2.entrySet()) {
                if (entry.getKey() instanceof String) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                Object key = entry2.getKey();
                Intrinsics.checkNotNull(key, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap3.put((String) key, entry2.getValue());
            }
            linkedHashMap = linkedHashMap3;
        } else {
            linkedHashMap = null;
        }
        Object obj5 = map.get("networkInfo");
        final NetworkInfo networkInfo = obj5 instanceof NetworkInfo ? (NetworkInfo) obj5 : null;
        Object obj6 = map.get("userInfo");
        final UserInfo userInfo = obj6 instanceof UserInfo ? (UserInfo) obj6 : null;
        if (str2 == null || str == null || l == null || linkedHashMap == null) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.log.internal.LogsFeature.sendNdkCrashLog.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Logs feature received a NDK crash event where one or more mandatory (loggerName, message, timestamp, attributes) fields are either missing or have wrong type.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        FeatureScope feature = this.sdkCore.getFeature(getName());
        if (feature != null) {
            FeatureScope.DefaultImpls.withWriteContext$default(feature, false, new Function2() { // from class: com.datadog.android.log.internal.LogsFeature.sendNdkCrashLog.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj7, Object obj8) {
                    invoke((DatadogContext) obj7, (EventBatchWriter) obj8);
                    return Unit.INSTANCE;
                }

                public final void invoke(DatadogContext datadogContext, EventBatchWriter eventBatchWriter) {
                    Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
                    Intrinsics.checkNotNullParameter(eventBatchWriter, "eventBatchWriter");
                    DatadogLogGenerator datadogLogGenerator = LogsFeature.this.logGenerator;
                    String name = Thread.currentThread().getName();
                    Set setEmptySet = SetsKt.emptySet();
                    String str3 = str;
                    Map map3 = linkedHashMap;
                    long jLongValue = l.longValue();
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    LogsFeature.this.getDataWriter$dd_sdk_android_logs_release().write(eventBatchWriter, LogGenerator.DefaultImpls.generateLog$default(datadogLogGenerator, 9, str3, null, map3, setEmptySet, jLongValue, name, datadogContext, true, str2, false, false, userInfo, null, networkInfo, null, 40960, null), EventType.CRASH);
                }
            }, 1, null);
        }
    }

    private final void sendSpanLog(Map map) {
        final LinkedHashMap linkedHashMap;
        Object obj = map.get(DiagnosticsEntry.TIMESTAMP_KEY);
        final Long l = obj instanceof Long ? (Long) obj : null;
        Object obj2 = map.get("message");
        final String str = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = map.get("loggerName");
        final String str2 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = map.get("attributes");
        Map map2 = obj4 instanceof Map ? (Map) obj4 : null;
        if (map2 != null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : map2.entrySet()) {
                if (entry.getKey() instanceof String) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                Object key = entry2.getKey();
                Intrinsics.checkNotNull(key, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap3.put((String) key, entry2.getValue());
            }
            linkedHashMap = linkedHashMap3;
        } else {
            linkedHashMap = null;
        }
        Object obj5 = map.get("logStatus");
        Integer num = obj5 instanceof Integer ? (Integer) obj5 : null;
        final int iIntValue = num != null ? num.intValue() : 2;
        if (str2 == null || str == null || linkedHashMap == null || l == null) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.log.internal.LogsFeature.sendSpanLog.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Logs feature received a Span log event where one or more mandatory (loggerName, message, timestamp, attributes) fields are either missing or have wrong type.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        FeatureScope feature = this.sdkCore.getFeature(getName());
        if (feature != null) {
            FeatureScope.DefaultImpls.withWriteContext$default(feature, false, new Function2() { // from class: com.datadog.android.log.internal.LogsFeature.sendSpanLog.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj6, Object obj7) {
                    invoke((DatadogContext) obj6, (EventBatchWriter) obj7);
                    return Unit.INSTANCE;
                }

                public final void invoke(DatadogContext datadogContext, EventBatchWriter eventBatchWriter) {
                    Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
                    Intrinsics.checkNotNullParameter(eventBatchWriter, "eventBatchWriter");
                    DatadogLogGenerator datadogLogGenerator = LogsFeature.this.logGenerator;
                    String name = Thread.currentThread().getName();
                    Set setEmptySet = SetsKt.emptySet();
                    int i = iIntValue;
                    String str3 = str;
                    Map map3 = linkedHashMap;
                    long jLongValue = l.longValue();
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    LogsFeature.this.getDataWriter$dd_sdk_android_logs_release().write(eventBatchWriter, LogGenerator.DefaultImpls.generateLog$default(datadogLogGenerator, i, str3, null, map3, setEmptySet, jLongValue, name, datadogContext, true, str2, false, true, null, null, null, null, 61440, null), EventType.DEFAULT);
                }
            }, 1, null);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
