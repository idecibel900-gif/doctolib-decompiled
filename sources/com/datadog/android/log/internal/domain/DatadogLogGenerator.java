package com.datadog.android.log.internal.domain;

import com.amazon.a.a.o.b.f;
import com.datadog.android.api.context.AccountInfo;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.api.context.UserInfo;
import com.datadog.android.core.feature.event.ThreadDump;
import com.datadog.android.log.internal.utils.LogUtilsKt;
import com.datadog.android.log.model.LogEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DatadogLogGenerator implements LogGenerator {
    public static final Companion Companion = new Companion(null);
    private final String serviceName;
    private final SimpleDateFormat simpleDateFormat;

    public DatadogLogGenerator(String str) {
        this.serviceName = str;
        this.simpleDateFormat = LogUtilsKt.buildLogDateFormat();
    }

    public /* synthetic */ DatadogLogGenerator(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    @Override // com.datadog.android.log.internal.domain.LogGenerator
    public LogEvent generateLog(int i, String message, Throwable th, Map attributes, Set tags, long j, String threadName, DatadogContext datadogContext, boolean z, String loggerName, boolean z2, boolean z3, UserInfo userInfo, AccountInfo accountInfo, NetworkInfo networkInfo, List threads) {
        LogEvent.Error error;
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(threadName, "threadName");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(loggerName, "loggerName");
        Intrinsics.checkNotNullParameter(threads, "threads");
        Map mutableMap = MapsKt.toMutableMap(attributes);
        if (th != null) {
            Object objRemove = mutableMap.remove("_dd.error.fingerprint");
            String str = objRemove instanceof String ? (String) objRemove : null;
            String canonicalName = th.getClass().getCanonicalName();
            if (canonicalName == null) {
                canonicalName = th.getClass().getSimpleName();
            }
            String str2 = canonicalName;
            String strStackTraceToString = ExceptionsKt.stackTraceToString(th);
            String message2 = th.getMessage();
            List<ThreadDump> list = threads;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ThreadDump threadDump : list) {
                arrayList.add(new LogEvent.Thread(threadDump.getName(), threadDump.getCrashed(), threadDump.getStack(), threadDump.getState()));
            }
            error = new LogEvent.Error(str2, message2, strStackTraceToString, null, str, arrayList.isEmpty() ? null : arrayList, 8, null);
        } else {
            error = null;
        }
        return internalGenerateLog(i, message, error, mutableMap, tags, j, threadName, datadogContext, z, loggerName, z2, z3, userInfo, accountInfo, networkInfo);
    }

    @Override // com.datadog.android.log.internal.domain.LogGenerator
    public LogEvent generateLog(int i, String message, String str, String str2, String str3, Map attributes, Set tags, long j, String threadName, DatadogContext datadogContext, boolean z, String loggerName, boolean z2, boolean z3, UserInfo userInfo, AccountInfo accountInfo, NetworkInfo networkInfo) {
        LogEvent.Error error;
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(threadName, "threadName");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(loggerName, "loggerName");
        Map mutableMap = MapsKt.toMutableMap(attributes);
        if (str == null && str2 == null && str3 == null) {
            error = null;
        } else {
            Object objRemove = mutableMap.remove("_dd.error.source_type");
            String str4 = objRemove instanceof String ? (String) objRemove : null;
            Object objRemove2 = mutableMap.remove("_dd.error.fingerprint");
            error = new LogEvent.Error(str, str2, str3, str4, objRemove2 instanceof String ? (String) objRemove2 : null, null, 32, null);
        }
        return internalGenerateLog(i, message, error, mutableMap, tags, j, threadName, datadogContext, z, loggerName, z2, z3, userInfo, accountInfo, networkInfo);
    }

    private final LogEvent internalGenerateLog(int i, String str, LogEvent.Error error, Map map, Set set, long j, String str2, DatadogContext datadogContext, boolean z, String str3, boolean z2, boolean z3, UserInfo userInfo, AccountInfo accountInfo, NetworkInfo networkInfo) {
        String formattedDate;
        long serverTimeOffsetMs = j + datadogContext.getTime().getServerTimeOffsetMs();
        Map mapResolveAttributes = resolveAttributes(datadogContext, map, z2, str2, z3);
        synchronized (this.simpleDateFormat) {
            formattedDate = this.simpleDateFormat.format(new Date(serverTimeOffsetMs));
        }
        Set setResolveTags = resolveTags(datadogContext, set);
        LogEvent.Usr usrResolveUserInfo = resolveUserInfo(datadogContext, userInfo);
        LogEvent.Account accountResolveAccountInfo = resolveAccountInfo(datadogContext, accountInfo);
        LogEvent.Network networkResolveNetworkInfo = (networkInfo != null || z) ? resolveNetworkInfo(datadogContext, networkInfo) : null;
        LogEvent.Logger logger = new LogEvent.Logger(str3, str2, datadogContext.getSdkVersion());
        String service = this.serviceName;
        if (service == null) {
            service = datadogContext.getService();
        }
        String str4 = service;
        LogEvent.Status statusResolveLogLevelStatus = resolveLogLevelStatus(i);
        String appBuildId = datadogContext.getAppBuildId();
        LogEvent.Dd dd = new LogEvent.Dd(new LogEvent.Device(datadogContext.getDeviceInfo().getArchitecture()));
        String strJoinToString$default = CollectionsKt.joinToString$default(setResolveTags, f.a, null, null, 0, null, null, 62, null);
        Intrinsics.checkNotNullExpressionValue(formattedDate, "formattedDate");
        return new LogEvent(statusResolveLogLevelStatus, str4, str, formattedDate, logger, dd, usrResolveUserInfo, accountResolveAccountInfo, networkResolveNetworkInfo, error, appBuildId, strJoinToString$default, mapResolveAttributes);
    }

    private final String envTag(DatadogContext datadogContext) {
        String env = datadogContext.getEnv();
        if (env.length() <= 0) {
            return null;
        }
        return "env:" + env;
    }

    private final String appVersionTag(DatadogContext datadogContext) {
        String version = datadogContext.getVersion();
        if (version.length() <= 0) {
            return null;
        }
        return "version:" + version;
    }

    private final String variantTag(DatadogContext datadogContext) {
        String variant = datadogContext.getVariant();
        if (variant.length() <= 0) {
            return null;
        }
        return "variant:" + variant;
    }

    private final LogEvent.Network resolveNetworkInfo(DatadogContext datadogContext, NetworkInfo networkInfo) {
        if (networkInfo == null) {
            networkInfo = datadogContext.getNetworkInfo();
        }
        LogEvent.SimCarrier simCarrierResolveSimCarrier = resolveSimCarrier(networkInfo);
        Long strength = networkInfo.getStrength();
        String string = strength != null ? strength.toString() : null;
        Long downKbps = networkInfo.getDownKbps();
        String string2 = downKbps != null ? downKbps.toString() : null;
        Long upKbps = networkInfo.getUpKbps();
        return new LogEvent.Network(new LogEvent.Client(simCarrierResolveSimCarrier, string, string2, upKbps != null ? upKbps.toString() : null, networkInfo.getConnectivity().toString()));
    }

    private final LogEvent.Usr resolveUserInfo(DatadogContext datadogContext, UserInfo userInfo) {
        if (userInfo == null) {
            userInfo = datadogContext.getUserInfo();
        }
        return new LogEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), MapsKt.toMutableMap(userInfo.getAdditionalProperties()));
    }

    private final LogEvent.Account resolveAccountInfo(DatadogContext datadogContext, AccountInfo accountInfo) {
        datadogContext.getAccountInfo();
        return null;
    }

    private final Set resolveTags(DatadogContext datadogContext, Set set) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(set);
        String strEnvTag = envTag(datadogContext);
        if (strEnvTag != null) {
            linkedHashSet.add(strEnvTag);
        }
        String strAppVersionTag = appVersionTag(datadogContext);
        if (strAppVersionTag != null) {
            linkedHashSet.add(strAppVersionTag);
        }
        String strVariantTag = variantTag(datadogContext);
        if (strVariantTag != null) {
            linkedHashSet.add(strVariantTag);
        }
        return linkedHashSet;
    }

    private final Map resolveAttributes(DatadogContext datadogContext, Map map, boolean z, String str, boolean z2) {
        Map map2;
        Map map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(map);
        if (z && (map3 = (Map) datadogContext.getFeaturesContext().get("tracing")) != null) {
            Object obj = map3.get("context@" + str);
            Map map4 = obj instanceof Map ? (Map) obj : null;
            if (map4 != null) {
                linkedHashMap.put("dd.trace_id", map4.get("trace_id"));
                linkedHashMap.put("dd.span_id", map4.get("span_id"));
            }
        }
        if (z2 && (map2 = (Map) datadogContext.getFeaturesContext().get("rum")) != null) {
            linkedHashMap.put("application_id", map2.get("application_id"));
            linkedHashMap.put("session_id", map2.get("session_id"));
            linkedHashMap.put("view.id", map2.get("view_id"));
            linkedHashMap.put("user_action.id", map2.get("action_id"));
        }
        return linkedHashMap;
    }

    private final LogEvent.Status resolveLogLevelStatus(int i) {
        switch (i) {
            case 2:
                return LogEvent.Status.TRACE;
            case 3:
                return LogEvent.Status.DEBUG;
            case 4:
                return LogEvent.Status.INFO;
            case 5:
                return LogEvent.Status.WARN;
            case 6:
                return LogEvent.Status.ERROR;
            case 7:
                return LogEvent.Status.CRITICAL;
            case 8:
            default:
                return LogEvent.Status.DEBUG;
            case 9:
                return LogEvent.Status.EMERGENCY;
        }
    }

    private final LogEvent.SimCarrier resolveSimCarrier(NetworkInfo networkInfo) {
        if (networkInfo.getCarrierId() == null && networkInfo.getCarrierName() == null) {
            return null;
        }
        Long carrierId = networkInfo.getCarrierId();
        return new LogEvent.SimCarrier(carrierId != null ? carrierId.toString() : null, networkInfo.getCarrierName());
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
