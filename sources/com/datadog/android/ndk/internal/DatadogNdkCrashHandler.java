package com.datadog.android.ndk.internal;

import com.amazon.a.a.o.b.f;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.api.context.UserInfo;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.internal.persistence.Deserializer;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import com.datadog.android.core.internal.persistence.file.FileReader;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.google.gson.JsonObject;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: loaded from: classes3.dex */
public final class DatadogNdkCrashHandler implements NdkCrashHandler {
    public static final Companion Companion = new Companion(null);
    private final ExecutorService dataPersistenceExecutorService;
    private final FileReader envFileReader;
    private final InternalLogger internalLogger;
    private NdkCrashLog lastNdkCrashLog;
    private NetworkInfo lastNetworkInfo;
    private JsonObject lastRumViewEvent;
    private final Function0 lastRumViewEventProvider;
    private UserInfo lastUserInfo;
    private final String nativeCrashSourceType;
    private final File ndkCrashDataDirectory;
    private final Deserializer ndkCrashLogDeserializer;
    private final Deserializer networkInfoDeserializer;
    private boolean processedForLogs;
    private boolean processedForRum;
    private final Deserializer userInfoDeserializer;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NdkCrashHandler.ReportTarget.values().length];
            try {
                iArr[NdkCrashHandler.ReportTarget.RUM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NdkCrashHandler.ReportTarget.LOGS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DatadogNdkCrashHandler(File storageDir, ExecutorService dataPersistenceExecutorService, Deserializer ndkCrashLogDeserializer, Deserializer networkInfoDeserializer, Deserializer userInfoDeserializer, InternalLogger internalLogger, FileReader envFileReader, Function0 lastRumViewEventProvider, String nativeCrashSourceType) {
        Intrinsics.checkNotNullParameter(storageDir, "storageDir");
        Intrinsics.checkNotNullParameter(dataPersistenceExecutorService, "dataPersistenceExecutorService");
        Intrinsics.checkNotNullParameter(ndkCrashLogDeserializer, "ndkCrashLogDeserializer");
        Intrinsics.checkNotNullParameter(networkInfoDeserializer, "networkInfoDeserializer");
        Intrinsics.checkNotNullParameter(userInfoDeserializer, "userInfoDeserializer");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(envFileReader, "envFileReader");
        Intrinsics.checkNotNullParameter(lastRumViewEventProvider, "lastRumViewEventProvider");
        Intrinsics.checkNotNullParameter(nativeCrashSourceType, "nativeCrashSourceType");
        this.dataPersistenceExecutorService = dataPersistenceExecutorService;
        this.ndkCrashLogDeserializer = ndkCrashLogDeserializer;
        this.networkInfoDeserializer = networkInfoDeserializer;
        this.userInfoDeserializer = userInfoDeserializer;
        this.internalLogger = internalLogger;
        this.envFileReader = envFileReader;
        this.lastRumViewEventProvider = lastRumViewEventProvider;
        this.nativeCrashSourceType = nativeCrashSourceType;
        this.ndkCrashDataDirectory = Companion.getNdkGrantedDir(storageDir);
    }

    public final File getNdkCrashDataDirectory$dd_sdk_android_core_release() {
        return this.ndkCrashDataDirectory;
    }

    @Override // com.datadog.android.ndk.internal.NdkCrashHandler
    public void prepareData() {
        ConcurrencyExtKt.executeSafe(this.dataPersistenceExecutorService, "NDK crash check", this.internalLogger, new Runnable() { // from class: com.datadog.android.ndk.internal.DatadogNdkCrashHandler$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DatadogNdkCrashHandler.prepareData$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prepareData$lambda$0(DatadogNdkCrashHandler this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.readCrashData();
    }

    @Override // com.datadog.android.ndk.internal.NdkCrashHandler
    public void handleNdkCrash(final FeatureSdkCore sdkCore, final NdkCrashHandler.ReportTarget reportTarget) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(reportTarget, "reportTarget");
        ConcurrencyExtKt.executeSafe(this.dataPersistenceExecutorService, "NDK crash report ", this.internalLogger, new Runnable() { // from class: com.datadog.android.ndk.internal.DatadogNdkCrashHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DatadogNdkCrashHandler.handleNdkCrash$lambda$1(this.f$0, sdkCore, reportTarget);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleNdkCrash$lambda$1(DatadogNdkCrashHandler this$0, FeatureSdkCore sdkCore, NdkCrashHandler.ReportTarget reportTarget) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sdkCore, "$sdkCore");
        Intrinsics.checkNotNullParameter(reportTarget, "$reportTarget");
        this$0.checkAndHandleNdkCrashReport(sdkCore, reportTarget);
    }

    private final void readCrashData() {
        try {
            if (FileExtKt.existsSafe(this.ndkCrashDataDirectory, this.internalLogger)) {
                try {
                    this.lastRumViewEvent = (JsonObject) this.lastRumViewEventProvider.invoke();
                    File[] fileArrListFilesSafe = FileExtKt.listFilesSafe(this.ndkCrashDataDirectory, this.internalLogger);
                    if (fileArrListFilesSafe != null) {
                        for (File file : fileArrListFilesSafe) {
                            String name = file.getName();
                            if (name != null) {
                                int iHashCode = name.hashCode();
                                if (iHashCode != -528983909) {
                                    if (iHashCode != 408381112) {
                                        if (iHashCode == 1847397036 && name.equals("crash_log")) {
                                            String textSafe$default = FileExtKt.readTextSafe$default(file, null, this.internalLogger, 1, null);
                                            this.lastNdkCrashLog = textSafe$default != null ? (NdkCrashLog) this.ndkCrashLogDeserializer.deserialize(textSafe$default) : null;
                                        }
                                    } else if (name.equals("user_information")) {
                                        String fileContent = readFileContent(file, this.envFileReader);
                                        this.lastUserInfo = fileContent != null ? (UserInfo) this.userInfoDeserializer.deserialize(fileContent) : null;
                                    }
                                } else if (name.equals("network_information")) {
                                    String fileContent2 = readFileContent(file, this.envFileReader);
                                    this.lastNetworkInfo = fileContent2 != null ? (NetworkInfo) this.networkInfoDeserializer.deserialize(fileContent2) : null;
                                }
                            }
                        }
                    }
                } catch (SecurityException e) {
                    InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.ndk.internal.DatadogNdkCrashHandler.readCrashData.2
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Error while trying to read the NDK crash directory";
                        }
                    }, (Throwable) e, false, (Map) null, 48, (Object) null);
                }
            }
        } finally {
            clearCrashLog();
        }
    }

    private final String readFileContent(final File file, FileReader fileReader) {
        final byte[] bArr = (byte[]) fileReader.readData(file);
        if (bArr.length == 0) {
            return null;
        }
        final String str = new String(bArr, Charsets.UTF_8);
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "\\u0000", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str, (CharSequence) WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, false, 2, (Object) null)) {
            return str;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.TELEMETRY, new Function0() { // from class: com.datadog.android.ndk.internal.DatadogNdkCrashHandler$readFileContent$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Decoded file (" + file.getName() + ") content contains NULL character, file content={" + str + "}, raw_bytes=" + ArraysKt.joinToString$default(bArr, (CharSequence) f.a, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return str;
    }

    private final void checkAndHandleNdkCrashReport(FeatureSdkCore featureSdkCore, NdkCrashHandler.ReportTarget reportTarget) {
        DatadogNdkCrashHandler datadogNdkCrashHandler;
        NdkCrashHandler.ReportTarget reportTarget2;
        NdkCrashLog ndkCrashLog = this.lastNdkCrashLog;
        if (ndkCrashLog != null) {
            datadogNdkCrashHandler = this;
            reportTarget2 = reportTarget;
            datadogNdkCrashHandler.handleNdkCrashLog(featureSdkCore, ndkCrashLog, this.lastRumViewEvent, this.lastUserInfo, this.lastNetworkInfo, reportTarget2);
        } else {
            datadogNdkCrashHandler = this;
            reportTarget2 = reportTarget;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[reportTarget2.ordinal()];
        if (i == 1) {
            datadogNdkCrashHandler.processedForRum = true;
        } else if (i == 2) {
            datadogNdkCrashHandler.processedForLogs = true;
        }
        if (datadogNdkCrashHandler.processedForRum && datadogNdkCrashHandler.processedForLogs) {
            clearAllReferences();
        }
    }

    private final void clearAllReferences() {
        this.lastRumViewEvent = null;
        this.lastNetworkInfo = null;
        this.lastUserInfo = null;
        this.lastNdkCrashLog = null;
    }

    private final void handleNdkCrashLog(FeatureSdkCore featureSdkCore, NdkCrashLog ndkCrashLog, JsonObject jsonObject, UserInfo userInfo, NetworkInfo networkInfo, NdkCrashHandler.ReportTarget reportTarget) {
        if (ndkCrashLog == null) {
            return;
        }
        String str = String.format(Locale.US, "NDK crash detected with signal: %s", Arrays.copyOf(new Object[]{ndkCrashLog.getSignalName()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        int i = WhenMappings.$EnumSwitchMapping$0[reportTarget.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            sendCrashLogEvent(featureSdkCore, str, generateLogAttributes(jsonObject, ndkCrashLog), ndkCrashLog, networkInfo, userInfo);
        } else if (jsonObject != null) {
            sendCrashRumEvent(featureSdkCore, str, ndkCrashLog, jsonObject);
        }
    }

    private final Map generateLogAttributes(final JsonObject jsonObject, NdkCrashLog ndkCrashLog) {
        Triple triple;
        if (jsonObject != null) {
            try {
                Function1 function1 = new Function1() { // from class: com.datadog.android.ndk.internal.DatadogNdkCrashHandler$generateLogAttributes$logAttributes$extractId$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(String property) {
                        Intrinsics.checkNotNullParameter(property, "property");
                        return jsonObject.getAsJsonObject(property).getAsJsonPrimitive(DiagnosticsEntry.ID_KEY).getAsString();
                    }
                };
                triple = new Triple((String) function1.invoke("application"), (String) function1.invoke("session"), (String) function1.invoke("view"));
            } catch (Exception e) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.ndk.internal.DatadogNdkCrashHandler$generateLogAttributes$logAttributes$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Cannot read application, session, view IDs data from view event.";
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
                triple = new Triple(null, null, null);
            }
            String str = (String) triple.component1();
            String str2 = (String) triple.component2();
            String str3 = (String) triple.component3();
            if (str != null && str2 != null && str3 != null) {
                return MapsKt.mapOf(TuplesKt.to("session_id", str2), TuplesKt.to("application_id", str), TuplesKt.to("view.id", str3), TuplesKt.to("error.stack", ndkCrashLog.getStacktrace()), TuplesKt.to("error.source_type", this.nativeCrashSourceType));
            }
            return MapsKt.mapOf(TuplesKt.to("error.stack", ndkCrashLog.getStacktrace()), TuplesKt.to("error.source_type", this.nativeCrashSourceType));
        }
        return MapsKt.mapOf(TuplesKt.to("error.stack", ndkCrashLog.getStacktrace()), TuplesKt.to("error.source_type", this.nativeCrashSourceType));
    }

    private final void sendCrashRumEvent(FeatureSdkCore featureSdkCore, String str, NdkCrashLog ndkCrashLog, JsonObject jsonObject) {
        FeatureScope feature = featureSdkCore.getFeature("rum");
        if (feature != null) {
            feature.sendEvent(MapsKt.mapOf(TuplesKt.to("type", "ndk_crash"), TuplesKt.to("sourceType", this.nativeCrashSourceType), TuplesKt.to(DiagnosticsEntry.TIMESTAMP_KEY, Long.valueOf(ndkCrashLog.getTimestamp())), TuplesKt.to("timeSinceAppStartMs", ndkCrashLog.getTimeSinceAppStartMs()), TuplesKt.to("signalName", ndkCrashLog.getSignalName()), TuplesKt.to("stacktrace", ndkCrashLog.getStacktrace()), TuplesKt.to("message", str), TuplesKt.to("lastViewEvent", jsonObject)));
        } else {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.ndk.internal.DatadogNdkCrashHandler.sendCrashRumEvent.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "RUM feature is not registered, won't report NDK crash info as RUM error.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
    }

    private final void sendCrashLogEvent(FeatureSdkCore featureSdkCore, String str, Map map, NdkCrashLog ndkCrashLog, NetworkInfo networkInfo, UserInfo userInfo) {
        FeatureScope feature = featureSdkCore.getFeature("logs");
        if (feature != null) {
            feature.sendEvent(MapsKt.mapOf(TuplesKt.to("loggerName", "ndk_crash"), TuplesKt.to("type", "ndk_crash"), TuplesKt.to("message", str), TuplesKt.to("attributes", map), TuplesKt.to(DiagnosticsEntry.TIMESTAMP_KEY, Long.valueOf(ndkCrashLog.getTimestamp())), TuplesKt.to("networkInfo", networkInfo), TuplesKt.to("userInfo", userInfo)));
        } else {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.ndk.internal.DatadogNdkCrashHandler.sendCrashLogEvent.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Logs feature is not registered, won't report NDK crash info as log.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
    }

    private final void clearCrashLog() {
        if (FileExtKt.existsSafe(this.ndkCrashDataDirectory, this.internalLogger)) {
            try {
                File[] fileArrListFilesSafe = FileExtKt.listFilesSafe(this.ndkCrashDataDirectory, this.internalLogger);
                if (fileArrListFilesSafe != null) {
                    for (File file : fileArrListFilesSafe) {
                        FilesKt.deleteRecursively(file);
                    }
                }
            } catch (Throwable th) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.ndk.internal.DatadogNdkCrashHandler.clearCrashLog.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Unable to clear the NDK crash report file: " + DatadogNdkCrashHandler.this.getNdkCrashDataDirectory$dd_sdk_android_core_release().getAbsolutePath();
                    }
                }, th, false, (Map) null, 48, (Object) null);
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final File getNdkGrantedDir(File file) {
            return new File(file, "ndk_crash_reports_v2");
        }

        private final File getNdkPendingDir(File file) {
            return new File(file, "ndk_crash_reports_intermediary_v2");
        }

        public final File getLastViewEventFile$dd_sdk_android_core_release(File storageDir) {
            Intrinsics.checkNotNullParameter(storageDir, "storageDir");
            return new File(getNdkGrantedDir(storageDir), "last_view_event");
        }

        public final File getPendingNetworkInfoFile$dd_sdk_android_core_release(File storageDir) {
            Intrinsics.checkNotNullParameter(storageDir, "storageDir");
            return new File(getNdkPendingDir(storageDir), "network_information");
        }

        public final File getGrantedNetworkInfoFile$dd_sdk_android_core_release(File storageDir) {
            Intrinsics.checkNotNullParameter(storageDir, "storageDir");
            return new File(getNdkGrantedDir(storageDir), "network_information");
        }

        public final File getPendingUserInfoFile$dd_sdk_android_core_release(File storageDir) {
            Intrinsics.checkNotNullParameter(storageDir, "storageDir");
            return new File(getNdkPendingDir(storageDir), "user_information");
        }

        public final File getGrantedUserInfoFile$dd_sdk_android_core_release(File storageDir) {
            Intrinsics.checkNotNullParameter(storageDir, "storageDir");
            return new File(getNdkGrantedDir(storageDir), "user_information");
        }
    }
}
