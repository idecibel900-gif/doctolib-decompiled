package com.datadog.reactnative;

import android.content.Context;
import com.datadog.android.Datadog;
import com.datadog.android._InternalProxy;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.log.Logs;
import com.datadog.android.log.LogsConfiguration;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum.Rum;
import com.datadog.android.rum.RumConfiguration;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.trace.Trace;
import com.datadog.android.trace.TraceConfiguration;
import com.datadog.android.webview.WebViewTracking;
import com.facebook.react.bridge.ReadableMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DatadogSDKWrapper implements DatadogWrapper {
    private boolean bundleLogsWithRum = true;
    private boolean bundleLogsWithTraces = true;
    private _InternalProxy._TelemetryProxy telemetryProxy;
    private WebViewTracking._InternalWebViewProxy webViewProxy;

    /* JADX INFO: Access modifiers changed from: private */
    public static final String sendTelemetryLog$lambda$0(String str) {
        return str;
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public boolean getBundleLogsWithRum() {
        return this.bundleLogsWithRum;
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void setBundleLogsWithRum(boolean z) {
        this.bundleLogsWithRum = z;
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public boolean getBundleLogsWithTraces() {
        return this.bundleLogsWithTraces;
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void setBundleLogsWithTraces(boolean z) {
        this.bundleLogsWithTraces = z;
    }

    private final _InternalProxy._TelemetryProxy getTelemetryProxy() {
        if (this.telemetryProxy == null && isInitialized()) {
            this.telemetryProxy = Datadog._internalProxy$default(Datadog.INSTANCE, null, 1, null).get_telemetry();
        }
        return this.telemetryProxy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final WebViewTracking._InternalWebViewProxy getWebViewProxy() {
        if (this.webViewProxy == null && isInitialized()) {
            this.webViewProxy = new WebViewTracking._InternalWebViewProxy(DatadogSDKWrapperStorage.INSTANCE.getSdkCore(), null, 2, 0 == true ? 1 : 0);
        }
        return this.webViewProxy;
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void setVerbosity(int i) {
        Datadog.setVerbosity(i);
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void initialize(Context context, Configuration configuration, TrackingConsent consent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(consent, "consent");
        SdkCore sdkCoreInitialize = Datadog.initialize(context, configuration, consent);
        DatadogSDKWrapperStorage datadogSDKWrapperStorage = DatadogSDKWrapperStorage.INSTANCE;
        Intrinsics.checkNotNull(sdkCoreInitialize, "null cannot be cast to non-null type com.datadog.android.core.InternalSdkCore");
        InternalSdkCore internalSdkCore = (InternalSdkCore) sdkCoreInitialize;
        datadogSDKWrapperStorage.setSdkCore(internalSdkCore);
        datadogSDKWrapperStorage.notifyOnInitializedListeners(internalSdkCore);
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void enableRum(RumConfiguration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Rum.enable(configuration, DatadogSDKWrapperStorage.INSTANCE.getSdkCore());
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void enableLogs(LogsConfiguration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Logs.enable(configuration, DatadogSDKWrapperStorage.INSTANCE.getSdkCore());
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void enableTrace(TraceConfiguration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Trace.enable(configuration, DatadogSDKWrapperStorage.INSTANCE.getSdkCore());
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void setUser(String str, String str2, String str3, Map extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Datadog.setUserInfoDeprecated$default(str, str2, str3, extraInfo, null, 16, null);
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void setUserInfo(String id, String str, String str2, Map extraInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Datadog.setUserInfo$default(id, str, str2, extraInfo, null, 16, null);
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void addUserExtraInfo(Map extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Datadog.addUserProperties$default(extraInfo, null, 2, null);
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void addRumGlobalAttributes(Map attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        RumMonitor rumMonitor = getRumMonitor();
        for (Map.Entry entry : attributes.entrySet()) {
            rumMonitor.addAttribute((String) entry.getKey(), entry.getValue());
        }
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void setTrackingConsent(TrackingConsent trackingConsent) {
        Intrinsics.checkNotNullParameter(trackingConsent, "trackingConsent");
        Datadog.setTrackingConsent$default(trackingConsent, null, 2, null);
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void sendTelemetryLog(final String message, ReadableMap attributes, ReadableMap config) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(config, "config");
        FeatureSdkCore featureSdkCore = (FeatureSdkCore) DatadogSDKWrapperStorage.INSTANCE.getSdkCore();
        InternalLogger internalLogger = featureSdkCore != null ? featureSdkCore.getInternalLogger() : null;
        Map map = DdSdkBridgeExtKt.toMap(attributes);
        Map map2 = DdSdkBridgeExtKt.toMap(config);
        if (internalLogger != null) {
            InternalLogger.Level level = InternalLogger.Level.INFO;
            InternalLogger.Target target = InternalLogger.Target.TELEMETRY;
            Function0 function0 = new Function0() { // from class: com.datadog.reactnative.DatadogSDKWrapper$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DatadogSDKWrapper.sendTelemetryLog$lambda$0(message);
                }
            };
            Object obj = map2.get("onlyOnce");
            Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
            InternalLogger.DefaultImpls.log$default(internalLogger, level, target, function0, (Throwable) null, bool != null ? bool.booleanValue() : true, map, 8, (Object) null);
        }
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void telemetryDebug(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        _InternalProxy._TelemetryProxy telemetryProxy = getTelemetryProxy();
        if (telemetryProxy != null) {
            telemetryProxy.debug(message);
        }
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void telemetryError(String message, String str, String str2) {
        Intrinsics.checkNotNullParameter(message, "message");
        _InternalProxy._TelemetryProxy telemetryProxy = getTelemetryProxy();
        if (telemetryProxy != null) {
            telemetryProxy.error(message, str, str2);
        }
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void telemetryError(String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        _InternalProxy._TelemetryProxy telemetryProxy = getTelemetryProxy();
        if (telemetryProxy != null) {
            telemetryProxy.error(message, th);
        }
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void consumeWebviewEvent(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        WebViewTracking._InternalWebViewProxy webViewProxy = getWebViewProxy();
        if (webViewProxy != null) {
            webViewProxy.consumeWebviewEvent(message);
        }
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public boolean isInitialized() {
        return Datadog.isInitialized$default(null, 1, null);
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public RumMonitor getRumMonitor() {
        return GlobalRumMonitor.get(DatadogSDKWrapperStorage.INSTANCE.getSdkCore());
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void clearAllData() {
        Datadog.clearAllData(DatadogSDKWrapperStorage.INSTANCE.getSdkCore());
    }
}
