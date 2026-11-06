package com.datadog.android.telemetry.model;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.datadog.android.core.internal.utils.JsonSerializer;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.firebase.messaging.Constants;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.react.RNPurchasesModule;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes3.dex */
public final class TelemetryConfigurationEvent {
    public static final Companion Companion = new Companion(null);
    private final Action action;
    private final Application application;
    private final long date;
    private final Dd dd;
    private final Number effectiveSampleRate;
    private final List experimentalFeatures;
    private final String service;
    private final Session session;
    private final Source source;
    private final Telemetry telemetry;
    private final String type;
    private final String version;
    private final View view;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TelemetryConfigurationEvent)) {
            return false;
        }
        TelemetryConfigurationEvent telemetryConfigurationEvent = (TelemetryConfigurationEvent) obj;
        return Intrinsics.areEqual(this.dd, telemetryConfigurationEvent.dd) && this.date == telemetryConfigurationEvent.date && Intrinsics.areEqual(this.service, telemetryConfigurationEvent.service) && this.source == telemetryConfigurationEvent.source && Intrinsics.areEqual(this.version, telemetryConfigurationEvent.version) && Intrinsics.areEqual(this.application, telemetryConfigurationEvent.application) && Intrinsics.areEqual(this.session, telemetryConfigurationEvent.session) && Intrinsics.areEqual(this.view, telemetryConfigurationEvent.view) && Intrinsics.areEqual(this.action, telemetryConfigurationEvent.action) && Intrinsics.areEqual(this.effectiveSampleRate, telemetryConfigurationEvent.effectiveSampleRate) && Intrinsics.areEqual(this.experimentalFeatures, telemetryConfigurationEvent.experimentalFeatures) && Intrinsics.areEqual(this.telemetry, telemetryConfigurationEvent.telemetry);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.dd.hashCode() * 31) + Long.hashCode(this.date)) * 31) + this.service.hashCode()) * 31) + this.source.hashCode()) * 31) + this.version.hashCode()) * 31;
        Application application = this.application;
        int iHashCode2 = (iHashCode + (application == null ? 0 : application.hashCode())) * 31;
        Session session = this.session;
        int iHashCode3 = (iHashCode2 + (session == null ? 0 : session.hashCode())) * 31;
        View view = this.view;
        int iHashCode4 = (iHashCode3 + (view == null ? 0 : view.hashCode())) * 31;
        Action action = this.action;
        int iHashCode5 = (iHashCode4 + (action == null ? 0 : action.hashCode())) * 31;
        Number number = this.effectiveSampleRate;
        int iHashCode6 = (iHashCode5 + (number == null ? 0 : number.hashCode())) * 31;
        List list = this.experimentalFeatures;
        return ((iHashCode6 + (list != null ? list.hashCode() : 0)) * 31) + this.telemetry.hashCode();
    }

    public String toString() {
        return "TelemetryConfigurationEvent(dd=" + this.dd + ", date=" + this.date + ", service=" + this.service + ", source=" + this.source + ", version=" + this.version + ", application=" + this.application + ", session=" + this.session + ", view=" + this.view + ", action=" + this.action + ", effectiveSampleRate=" + this.effectiveSampleRate + ", experimentalFeatures=" + this.experimentalFeatures + ", telemetry=" + this.telemetry + ")";
    }

    public TelemetryConfigurationEvent(Dd dd, long j, String service, Source source, String version, Application application, Session session, View view, Action action, Number number, List list, Telemetry telemetry) {
        Intrinsics.checkNotNullParameter(dd, "dd");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(telemetry, "telemetry");
        this.dd = dd;
        this.date = j;
        this.service = service;
        this.source = source;
        this.version = version;
        this.application = application;
        this.session = session;
        this.view = view;
        this.action = action;
        this.effectiveSampleRate = number;
        this.experimentalFeatures = list;
        this.telemetry = telemetry;
        this.type = "telemetry";
    }

    public final Telemetry getTelemetry() {
        return this.telemetry;
    }

    public final JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("_dd", this.dd.toJson());
        jsonObject.addProperty("type", this.type);
        jsonObject.addProperty("date", Long.valueOf(this.date));
        jsonObject.addProperty("service", this.service);
        jsonObject.add(Constants.ScionAnalytics.PARAM_SOURCE, this.source.toJson());
        jsonObject.addProperty(DiagnosticsEntry.VERSION_KEY, this.version);
        Application application = this.application;
        if (application != null) {
            jsonObject.add("application", application.toJson());
        }
        Session session = this.session;
        if (session != null) {
            jsonObject.add("session", session.toJson());
        }
        View view = this.view;
        if (view != null) {
            jsonObject.add("view", view.toJson());
        }
        Action action = this.action;
        if (action != null) {
            jsonObject.add("action", action.toJson());
        }
        Number number = this.effectiveSampleRate;
        if (number != null) {
            jsonObject.addProperty("effective_sample_rate", number);
        }
        List list = this.experimentalFeatures;
        if (list != null) {
            JsonArray jsonArray = new JsonArray(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jsonArray.add((String) it.next());
            }
            jsonObject.add("experimental_features", jsonArray);
        }
        jsonObject.add("telemetry", this.telemetry.toJson());
        return jsonObject;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static final class Dd {
        public static final Companion Companion = new Companion(null);
        private final long formatVersion = 2;

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("format_version", Long.valueOf(this.formatVersion));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public static final class Application {
        public static final Companion Companion = new Companion(null);
        private final String id;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Application) && Intrinsics.areEqual(this.id, ((Application) obj).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "Application(id=" + this.id + ")";
        }

        public Application(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(DiagnosticsEntry.ID_KEY, this.id);
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public static final class Session {
        public static final Companion Companion = new Companion(null);
        private final String id;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Session) && Intrinsics.areEqual(this.id, ((Session) obj).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "Session(id=" + this.id + ")";
        }

        public Session(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(DiagnosticsEntry.ID_KEY, this.id);
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public static final class View {
        public static final Companion Companion = new Companion(null);
        private final String id;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof View) && Intrinsics.areEqual(this.id, ((View) obj).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "View(id=" + this.id + ")";
        }

        public View(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(DiagnosticsEntry.ID_KEY, this.id);
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public static final class Action {
        public static final Companion Companion = new Companion(null);
        private final String id;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Action) && Intrinsics.areEqual(this.id, ((Action) obj).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "Action(id=" + this.id + ")";
        }

        public Action(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(DiagnosticsEntry.ID_KEY, this.id);
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public static final class Telemetry {
        public static final Companion Companion = new Companion(null);
        private static final String[] RESERVED_PROPERTIES = {"device", "os", "type", "configuration"};
        private final Map additionalProperties;
        private final Configuration configuration;
        private final Device device;
        private final Os os;
        private final String type;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Telemetry)) {
                return false;
            }
            Telemetry telemetry = (Telemetry) obj;
            return Intrinsics.areEqual(this.device, telemetry.device) && Intrinsics.areEqual(this.os, telemetry.os) && Intrinsics.areEqual(this.configuration, telemetry.configuration) && Intrinsics.areEqual(this.additionalProperties, telemetry.additionalProperties);
        }

        public int hashCode() {
            Device device = this.device;
            int iHashCode = (device == null ? 0 : device.hashCode()) * 31;
            Os os = this.os;
            return ((((iHashCode + (os != null ? os.hashCode() : 0)) * 31) + this.configuration.hashCode()) * 31) + this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Telemetry(device=" + this.device + ", os=" + this.os + ", configuration=" + this.configuration + ", additionalProperties=" + this.additionalProperties + ")";
        }

        public Telemetry(Device device, Os os, Configuration configuration, Map additionalProperties) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.device = device;
            this.os = os;
            this.configuration = configuration;
            this.additionalProperties = additionalProperties;
            this.type = "configuration";
        }

        public final Configuration getConfiguration() {
            return this.configuration;
        }

        public /* synthetic */ Telemetry(Device device, Os os, Configuration configuration, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : device, (i & 2) != 0 ? null : os, configuration, (i & 8) != 0 ? new LinkedHashMap() : map);
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Device device = this.device;
            if (device != null) {
                jsonObject.add("device", device.toJson());
            }
            Os os = this.os;
            if (os != null) {
                jsonObject.add("os", os.toJson());
            }
            jsonObject.addProperty("type", this.type);
            jsonObject.add("configuration", this.configuration.toJson());
            for (Map.Entry entry : this.additionalProperties.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (!ArraysKt.contains(RESERVED_PROPERTIES, str)) {
                    jsonObject.add(str, JsonSerializer.INSTANCE.toJsonElement(value));
                }
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public static final class Device {
        public static final Companion Companion = new Companion(null);
        private final String architecture;
        private final String brand;
        private final String model;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Device)) {
                return false;
            }
            Device device = (Device) obj;
            return Intrinsics.areEqual(this.architecture, device.architecture) && Intrinsics.areEqual(this.brand, device.brand) && Intrinsics.areEqual(this.model, device.model);
        }

        public int hashCode() {
            String str = this.architecture;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.brand;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.model;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "Device(architecture=" + this.architecture + ", brand=" + this.brand + ", model=" + this.model + ")";
        }

        public Device(String str, String str2, String str3) {
            this.architecture = str;
            this.brand = str2;
            this.model = str3;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.architecture;
            if (str != null) {
                jsonObject.addProperty("architecture", str);
            }
            String str2 = this.brand;
            if (str2 != null) {
                jsonObject.addProperty("brand", str2);
            }
            String str3 = this.model;
            if (str3 != null) {
                jsonObject.addProperty("model", str3);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public static final class Os {
        public static final Companion Companion = new Companion(null);
        private final String build;
        private final String name;
        private final String version;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Os)) {
                return false;
            }
            Os os = (Os) obj;
            return Intrinsics.areEqual(this.build, os.build) && Intrinsics.areEqual(this.name, os.name) && Intrinsics.areEqual(this.version, os.version);
        }

        public int hashCode() {
            String str = this.build;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.name;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.version;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "Os(build=" + this.build + ", name=" + this.name + ", version=" + this.version + ")";
        }

        public Os(String str, String str2, String str3) {
            this.build = str;
            this.name = str2;
            this.version = str3;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.build;
            if (str != null) {
                jsonObject.addProperty("build", str);
            }
            String str2 = this.name;
            if (str2 != null) {
                jsonObject.addProperty("name", str2);
            }
            String str3 = this.version;
            if (str3 != null) {
                jsonObject.addProperty(DiagnosticsEntry.VERSION_KEY, str3);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public static final class Configuration {
        public static final Companion Companion = new Companion(null);
        private final String actionNameAttribute;
        private final Boolean allowFallbackToLocalStorage;
        private final Boolean allowUntrustedEvents;
        private final Long appHangThreshold;
        private final Boolean backgroundTasksEnabled;
        private final Long batchProcessingLevel;
        private final Long batchSize;
        private final Long batchUploadFrequency;
        private final Boolean compressIntakeRequests;
        private String dartVersion;
        private String defaultPrivacyLevel;
        private Boolean enablePrivacyForActionName;
        private final List forwardConsoleLogs;
        private final Boolean forwardErrorsToLogs;
        private final List forwardReports;
        private String imagePrivacyLevel;
        private String initializationType;
        private final Long invTimeThresholdMs;
        private final Boolean isMainProcess;
        private Long mobileVitalsUpdatePeriod;
        private final Long numberOfDisplays;
        private final List plugins;
        private final Long premiumSampleRate;
        private String reactNativeVersion;
        private String reactVersion;
        private final Long replaySampleRate;
        private final List selectedTracingPropagators;
        private Boolean sendLogsAfterSessionExpiration;
        private final SessionPersistence sessionPersistence;
        private Long sessionReplaySampleRate;
        private final Long sessionSampleRate;
        private final Boolean silentMultipleInit;
        private Boolean startRecordingImmediately;
        private Boolean startSessionReplayRecordingManually;
        private final Boolean storeContextsAcrossPages;
        private final Long telemetryConfigurationSampleRate;
        private final Long telemetrySampleRate;
        private final Long telemetryUsageSampleRate;
        private String textAndInputPrivacyLevel;
        private final Long tnsTimeThresholdMs;
        private String touchPrivacyLevel;
        private TraceContextInjection traceContextInjection;
        private final Long traceSampleRate;
        private String tracerApi;
        private String tracerApiVersion;
        private Boolean trackAnonymousUser;
        private Boolean trackBackgroundEvents;
        private Boolean trackCrossPlatformLongTasks;
        private Boolean trackErrors;
        private final List trackFeatureFlagsForEvents;
        private Boolean trackFlutterPerformance;
        private Boolean trackFrustrations;
        private Boolean trackInteractions;
        private Boolean trackLongTask;
        private Boolean trackNativeErrors;
        private Boolean trackNativeLongTasks;
        private Boolean trackNativeViews;
        private Boolean trackNetworkRequests;
        private Boolean trackResources;
        private final Boolean trackSessionAcrossSubdomains;
        private Boolean trackUserInteractions;
        private Boolean trackViewsManually;
        private final TrackingConsent trackingConsent;
        private String unityVersion;
        private final Boolean useAllowedTracingOrigins;
        private final Boolean useAllowedTracingUrls;
        private final Boolean useBeforeSend;
        private final Boolean useCrossSiteSessionCookie;
        private final Boolean useExcludedActivityUrls;
        private Boolean useFirstPartyHosts;
        private final Boolean useLocalEncryption;
        private final Boolean usePartitionedCrossSiteSessionCookie;
        private Boolean usePciIntake;
        private Boolean useProxy;
        private final Boolean useSecureSessionCookie;
        private final Boolean useTracing;
        private final Boolean useWorkerUrl;
        private final ViewTrackingStrategy viewTrackingStrategy;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Configuration)) {
                return false;
            }
            Configuration configuration = (Configuration) obj;
            return Intrinsics.areEqual(this.sessionSampleRate, configuration.sessionSampleRate) && Intrinsics.areEqual(this.telemetrySampleRate, configuration.telemetrySampleRate) && Intrinsics.areEqual(this.telemetryConfigurationSampleRate, configuration.telemetryConfigurationSampleRate) && Intrinsics.areEqual(this.telemetryUsageSampleRate, configuration.telemetryUsageSampleRate) && Intrinsics.areEqual(this.traceSampleRate, configuration.traceSampleRate) && this.traceContextInjection == configuration.traceContextInjection && Intrinsics.areEqual(this.premiumSampleRate, configuration.premiumSampleRate) && Intrinsics.areEqual(this.replaySampleRate, configuration.replaySampleRate) && Intrinsics.areEqual(this.sessionReplaySampleRate, configuration.sessionReplaySampleRate) && this.trackingConsent == configuration.trackingConsent && Intrinsics.areEqual(this.startSessionReplayRecordingManually, configuration.startSessionReplayRecordingManually) && Intrinsics.areEqual(this.startRecordingImmediately, configuration.startRecordingImmediately) && Intrinsics.areEqual(this.useProxy, configuration.useProxy) && Intrinsics.areEqual(this.useBeforeSend, configuration.useBeforeSend) && Intrinsics.areEqual(this.silentMultipleInit, configuration.silentMultipleInit) && Intrinsics.areEqual(this.trackSessionAcrossSubdomains, configuration.trackSessionAcrossSubdomains) && Intrinsics.areEqual(this.trackResources, configuration.trackResources) && Intrinsics.areEqual(this.trackLongTask, configuration.trackLongTask) && Intrinsics.areEqual(this.useCrossSiteSessionCookie, configuration.useCrossSiteSessionCookie) && Intrinsics.areEqual(this.usePartitionedCrossSiteSessionCookie, configuration.usePartitionedCrossSiteSessionCookie) && Intrinsics.areEqual(this.useSecureSessionCookie, configuration.useSecureSessionCookie) && Intrinsics.areEqual(this.allowFallbackToLocalStorage, configuration.allowFallbackToLocalStorage) && this.sessionPersistence == configuration.sessionPersistence && Intrinsics.areEqual(this.storeContextsAcrossPages, configuration.storeContextsAcrossPages) && Intrinsics.areEqual(this.allowUntrustedEvents, configuration.allowUntrustedEvents) && Intrinsics.areEqual(this.actionNameAttribute, configuration.actionNameAttribute) && Intrinsics.areEqual(this.useAllowedTracingOrigins, configuration.useAllowedTracingOrigins) && Intrinsics.areEqual(this.useAllowedTracingUrls, configuration.useAllowedTracingUrls) && Intrinsics.areEqual(this.selectedTracingPropagators, configuration.selectedTracingPropagators) && Intrinsics.areEqual(this.defaultPrivacyLevel, configuration.defaultPrivacyLevel) && Intrinsics.areEqual(this.textAndInputPrivacyLevel, configuration.textAndInputPrivacyLevel) && Intrinsics.areEqual(this.imagePrivacyLevel, configuration.imagePrivacyLevel) && Intrinsics.areEqual(this.touchPrivacyLevel, configuration.touchPrivacyLevel) && Intrinsics.areEqual(this.enablePrivacyForActionName, configuration.enablePrivacyForActionName) && Intrinsics.areEqual(this.useExcludedActivityUrls, configuration.useExcludedActivityUrls) && Intrinsics.areEqual(this.useWorkerUrl, configuration.useWorkerUrl) && Intrinsics.areEqual(this.compressIntakeRequests, configuration.compressIntakeRequests) && Intrinsics.areEqual(this.trackFrustrations, configuration.trackFrustrations) && Intrinsics.areEqual(this.trackViewsManually, configuration.trackViewsManually) && Intrinsics.areEqual(this.trackInteractions, configuration.trackInteractions) && Intrinsics.areEqual(this.trackUserInteractions, configuration.trackUserInteractions) && Intrinsics.areEqual(this.forwardErrorsToLogs, configuration.forwardErrorsToLogs) && Intrinsics.areEqual(this.numberOfDisplays, configuration.numberOfDisplays) && Intrinsics.areEqual(this.forwardConsoleLogs, configuration.forwardConsoleLogs) && Intrinsics.areEqual(this.forwardReports, configuration.forwardReports) && Intrinsics.areEqual(this.useLocalEncryption, configuration.useLocalEncryption) && this.viewTrackingStrategy == configuration.viewTrackingStrategy && Intrinsics.areEqual(this.trackBackgroundEvents, configuration.trackBackgroundEvents) && Intrinsics.areEqual(this.mobileVitalsUpdatePeriod, configuration.mobileVitalsUpdatePeriod) && Intrinsics.areEqual(this.trackErrors, configuration.trackErrors) && Intrinsics.areEqual(this.trackNetworkRequests, configuration.trackNetworkRequests) && Intrinsics.areEqual(this.useTracing, configuration.useTracing) && Intrinsics.areEqual(this.trackNativeViews, configuration.trackNativeViews) && Intrinsics.areEqual(this.trackNativeErrors, configuration.trackNativeErrors) && Intrinsics.areEqual(this.trackNativeLongTasks, configuration.trackNativeLongTasks) && Intrinsics.areEqual(this.trackCrossPlatformLongTasks, configuration.trackCrossPlatformLongTasks) && Intrinsics.areEqual(this.useFirstPartyHosts, configuration.useFirstPartyHosts) && Intrinsics.areEqual(this.initializationType, configuration.initializationType) && Intrinsics.areEqual(this.trackFlutterPerformance, configuration.trackFlutterPerformance) && Intrinsics.areEqual(this.batchSize, configuration.batchSize) && Intrinsics.areEqual(this.batchUploadFrequency, configuration.batchUploadFrequency) && Intrinsics.areEqual(this.batchProcessingLevel, configuration.batchProcessingLevel) && Intrinsics.areEqual(this.backgroundTasksEnabled, configuration.backgroundTasksEnabled) && Intrinsics.areEqual(this.reactVersion, configuration.reactVersion) && Intrinsics.areEqual(this.reactNativeVersion, configuration.reactNativeVersion) && Intrinsics.areEqual(this.dartVersion, configuration.dartVersion) && Intrinsics.areEqual(this.unityVersion, configuration.unityVersion) && Intrinsics.areEqual(this.appHangThreshold, configuration.appHangThreshold) && Intrinsics.areEqual(this.usePciIntake, configuration.usePciIntake) && Intrinsics.areEqual(this.tracerApi, configuration.tracerApi) && Intrinsics.areEqual(this.tracerApiVersion, configuration.tracerApiVersion) && Intrinsics.areEqual(this.sendLogsAfterSessionExpiration, configuration.sendLogsAfterSessionExpiration) && Intrinsics.areEqual(this.plugins, configuration.plugins) && Intrinsics.areEqual(this.isMainProcess, configuration.isMainProcess) && Intrinsics.areEqual(this.invTimeThresholdMs, configuration.invTimeThresholdMs) && Intrinsics.areEqual(this.tnsTimeThresholdMs, configuration.tnsTimeThresholdMs) && Intrinsics.areEqual(this.trackFeatureFlagsForEvents, configuration.trackFeatureFlagsForEvents) && Intrinsics.areEqual(this.trackAnonymousUser, configuration.trackAnonymousUser);
        }

        public int hashCode() {
            Long l = this.sessionSampleRate;
            int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
            Long l2 = this.telemetrySampleRate;
            int iHashCode2 = (iHashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
            Long l3 = this.telemetryConfigurationSampleRate;
            int iHashCode3 = (iHashCode2 + (l3 == null ? 0 : l3.hashCode())) * 31;
            Long l4 = this.telemetryUsageSampleRate;
            int iHashCode4 = (iHashCode3 + (l4 == null ? 0 : l4.hashCode())) * 31;
            Long l5 = this.traceSampleRate;
            int iHashCode5 = (iHashCode4 + (l5 == null ? 0 : l5.hashCode())) * 31;
            TraceContextInjection traceContextInjection = this.traceContextInjection;
            int iHashCode6 = (iHashCode5 + (traceContextInjection == null ? 0 : traceContextInjection.hashCode())) * 31;
            Long l6 = this.premiumSampleRate;
            int iHashCode7 = (iHashCode6 + (l6 == null ? 0 : l6.hashCode())) * 31;
            Long l7 = this.replaySampleRate;
            int iHashCode8 = (iHashCode7 + (l7 == null ? 0 : l7.hashCode())) * 31;
            Long l8 = this.sessionReplaySampleRate;
            int iHashCode9 = (iHashCode8 + (l8 == null ? 0 : l8.hashCode())) * 31;
            TrackingConsent trackingConsent = this.trackingConsent;
            int iHashCode10 = (iHashCode9 + (trackingConsent == null ? 0 : trackingConsent.hashCode())) * 31;
            Boolean bool = this.startSessionReplayRecordingManually;
            int iHashCode11 = (iHashCode10 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.startRecordingImmediately;
            int iHashCode12 = (iHashCode11 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.useProxy;
            int iHashCode13 = (iHashCode12 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.useBeforeSend;
            int iHashCode14 = (iHashCode13 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Boolean bool5 = this.silentMultipleInit;
            int iHashCode15 = (iHashCode14 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
            Boolean bool6 = this.trackSessionAcrossSubdomains;
            int iHashCode16 = (iHashCode15 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
            Boolean bool7 = this.trackResources;
            int iHashCode17 = (iHashCode16 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
            Boolean bool8 = this.trackLongTask;
            int iHashCode18 = (iHashCode17 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
            Boolean bool9 = this.useCrossSiteSessionCookie;
            int iHashCode19 = (iHashCode18 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
            Boolean bool10 = this.usePartitionedCrossSiteSessionCookie;
            int iHashCode20 = (iHashCode19 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
            Boolean bool11 = this.useSecureSessionCookie;
            int iHashCode21 = (iHashCode20 + (bool11 == null ? 0 : bool11.hashCode())) * 31;
            Boolean bool12 = this.allowFallbackToLocalStorage;
            int iHashCode22 = (iHashCode21 + (bool12 == null ? 0 : bool12.hashCode())) * 31;
            SessionPersistence sessionPersistence = this.sessionPersistence;
            int iHashCode23 = (iHashCode22 + (sessionPersistence == null ? 0 : sessionPersistence.hashCode())) * 31;
            Boolean bool13 = this.storeContextsAcrossPages;
            int iHashCode24 = (iHashCode23 + (bool13 == null ? 0 : bool13.hashCode())) * 31;
            Boolean bool14 = this.allowUntrustedEvents;
            int iHashCode25 = (iHashCode24 + (bool14 == null ? 0 : bool14.hashCode())) * 31;
            String str = this.actionNameAttribute;
            int iHashCode26 = (iHashCode25 + (str == null ? 0 : str.hashCode())) * 31;
            Boolean bool15 = this.useAllowedTracingOrigins;
            int iHashCode27 = (iHashCode26 + (bool15 == null ? 0 : bool15.hashCode())) * 31;
            Boolean bool16 = this.useAllowedTracingUrls;
            int iHashCode28 = (iHashCode27 + (bool16 == null ? 0 : bool16.hashCode())) * 31;
            List list = this.selectedTracingPropagators;
            int iHashCode29 = (iHashCode28 + (list == null ? 0 : list.hashCode())) * 31;
            String str2 = this.defaultPrivacyLevel;
            int iHashCode30 = (iHashCode29 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.textAndInputPrivacyLevel;
            int iHashCode31 = (iHashCode30 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.imagePrivacyLevel;
            int iHashCode32 = (iHashCode31 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.touchPrivacyLevel;
            int iHashCode33 = (iHashCode32 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Boolean bool17 = this.enablePrivacyForActionName;
            int iHashCode34 = (iHashCode33 + (bool17 == null ? 0 : bool17.hashCode())) * 31;
            Boolean bool18 = this.useExcludedActivityUrls;
            int iHashCode35 = (iHashCode34 + (bool18 == null ? 0 : bool18.hashCode())) * 31;
            Boolean bool19 = this.useWorkerUrl;
            int iHashCode36 = (iHashCode35 + (bool19 == null ? 0 : bool19.hashCode())) * 31;
            Boolean bool20 = this.compressIntakeRequests;
            int iHashCode37 = (iHashCode36 + (bool20 == null ? 0 : bool20.hashCode())) * 31;
            Boolean bool21 = this.trackFrustrations;
            int iHashCode38 = (iHashCode37 + (bool21 == null ? 0 : bool21.hashCode())) * 31;
            Boolean bool22 = this.trackViewsManually;
            int iHashCode39 = (iHashCode38 + (bool22 == null ? 0 : bool22.hashCode())) * 31;
            Boolean bool23 = this.trackInteractions;
            int iHashCode40 = (iHashCode39 + (bool23 == null ? 0 : bool23.hashCode())) * 31;
            Boolean bool24 = this.trackUserInteractions;
            int iHashCode41 = (iHashCode40 + (bool24 == null ? 0 : bool24.hashCode())) * 31;
            Boolean bool25 = this.forwardErrorsToLogs;
            int iHashCode42 = (iHashCode41 + (bool25 == null ? 0 : bool25.hashCode())) * 31;
            Long l9 = this.numberOfDisplays;
            int iHashCode43 = (iHashCode42 + (l9 == null ? 0 : l9.hashCode())) * 31;
            List list2 = this.forwardConsoleLogs;
            int iHashCode44 = (iHashCode43 + (list2 == null ? 0 : list2.hashCode())) * 31;
            List list3 = this.forwardReports;
            int iHashCode45 = (iHashCode44 + (list3 == null ? 0 : list3.hashCode())) * 31;
            Boolean bool26 = this.useLocalEncryption;
            int iHashCode46 = (iHashCode45 + (bool26 == null ? 0 : bool26.hashCode())) * 31;
            ViewTrackingStrategy viewTrackingStrategy = this.viewTrackingStrategy;
            int iHashCode47 = (iHashCode46 + (viewTrackingStrategy == null ? 0 : viewTrackingStrategy.hashCode())) * 31;
            Boolean bool27 = this.trackBackgroundEvents;
            int iHashCode48 = (iHashCode47 + (bool27 == null ? 0 : bool27.hashCode())) * 31;
            Long l10 = this.mobileVitalsUpdatePeriod;
            int iHashCode49 = (iHashCode48 + (l10 == null ? 0 : l10.hashCode())) * 31;
            Boolean bool28 = this.trackErrors;
            int iHashCode50 = (iHashCode49 + (bool28 == null ? 0 : bool28.hashCode())) * 31;
            Boolean bool29 = this.trackNetworkRequests;
            int iHashCode51 = (iHashCode50 + (bool29 == null ? 0 : bool29.hashCode())) * 31;
            Boolean bool30 = this.useTracing;
            int iHashCode52 = (iHashCode51 + (bool30 == null ? 0 : bool30.hashCode())) * 31;
            Boolean bool31 = this.trackNativeViews;
            int iHashCode53 = (iHashCode52 + (bool31 == null ? 0 : bool31.hashCode())) * 31;
            Boolean bool32 = this.trackNativeErrors;
            int iHashCode54 = (iHashCode53 + (bool32 == null ? 0 : bool32.hashCode())) * 31;
            Boolean bool33 = this.trackNativeLongTasks;
            int iHashCode55 = (iHashCode54 + (bool33 == null ? 0 : bool33.hashCode())) * 31;
            Boolean bool34 = this.trackCrossPlatformLongTasks;
            int iHashCode56 = (iHashCode55 + (bool34 == null ? 0 : bool34.hashCode())) * 31;
            Boolean bool35 = this.useFirstPartyHosts;
            int iHashCode57 = (iHashCode56 + (bool35 == null ? 0 : bool35.hashCode())) * 31;
            String str6 = this.initializationType;
            int iHashCode58 = (iHashCode57 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Boolean bool36 = this.trackFlutterPerformance;
            int iHashCode59 = (iHashCode58 + (bool36 == null ? 0 : bool36.hashCode())) * 31;
            Long l11 = this.batchSize;
            int iHashCode60 = (iHashCode59 + (l11 == null ? 0 : l11.hashCode())) * 31;
            Long l12 = this.batchUploadFrequency;
            int iHashCode61 = (iHashCode60 + (l12 == null ? 0 : l12.hashCode())) * 31;
            Long l13 = this.batchProcessingLevel;
            int iHashCode62 = (iHashCode61 + (l13 == null ? 0 : l13.hashCode())) * 31;
            Boolean bool37 = this.backgroundTasksEnabled;
            int iHashCode63 = (iHashCode62 + (bool37 == null ? 0 : bool37.hashCode())) * 31;
            String str7 = this.reactVersion;
            int iHashCode64 = (iHashCode63 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.reactNativeVersion;
            int iHashCode65 = (iHashCode64 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.dartVersion;
            int iHashCode66 = (iHashCode65 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.unityVersion;
            int iHashCode67 = (iHashCode66 + (str10 == null ? 0 : str10.hashCode())) * 31;
            Long l14 = this.appHangThreshold;
            int iHashCode68 = (iHashCode67 + (l14 == null ? 0 : l14.hashCode())) * 31;
            Boolean bool38 = this.usePciIntake;
            int iHashCode69 = (iHashCode68 + (bool38 == null ? 0 : bool38.hashCode())) * 31;
            String str11 = this.tracerApi;
            int iHashCode70 = (iHashCode69 + (str11 == null ? 0 : str11.hashCode())) * 31;
            String str12 = this.tracerApiVersion;
            int iHashCode71 = (iHashCode70 + (str12 == null ? 0 : str12.hashCode())) * 31;
            Boolean bool39 = this.sendLogsAfterSessionExpiration;
            int iHashCode72 = (iHashCode71 + (bool39 == null ? 0 : bool39.hashCode())) * 31;
            List list4 = this.plugins;
            int iHashCode73 = (iHashCode72 + (list4 == null ? 0 : list4.hashCode())) * 31;
            Boolean bool40 = this.isMainProcess;
            int iHashCode74 = (iHashCode73 + (bool40 == null ? 0 : bool40.hashCode())) * 31;
            Long l15 = this.invTimeThresholdMs;
            int iHashCode75 = (iHashCode74 + (l15 == null ? 0 : l15.hashCode())) * 31;
            Long l16 = this.tnsTimeThresholdMs;
            int iHashCode76 = (iHashCode75 + (l16 == null ? 0 : l16.hashCode())) * 31;
            List list5 = this.trackFeatureFlagsForEvents;
            int iHashCode77 = (iHashCode76 + (list5 == null ? 0 : list5.hashCode())) * 31;
            Boolean bool41 = this.trackAnonymousUser;
            return iHashCode77 + (bool41 != null ? bool41.hashCode() : 0);
        }

        public String toString() {
            return "Configuration(sessionSampleRate=" + this.sessionSampleRate + ", telemetrySampleRate=" + this.telemetrySampleRate + ", telemetryConfigurationSampleRate=" + this.telemetryConfigurationSampleRate + ", telemetryUsageSampleRate=" + this.telemetryUsageSampleRate + ", traceSampleRate=" + this.traceSampleRate + ", traceContextInjection=" + this.traceContextInjection + ", premiumSampleRate=" + this.premiumSampleRate + ", replaySampleRate=" + this.replaySampleRate + ", sessionReplaySampleRate=" + this.sessionReplaySampleRate + ", trackingConsent=" + this.trackingConsent + ", startSessionReplayRecordingManually=" + this.startSessionReplayRecordingManually + ", startRecordingImmediately=" + this.startRecordingImmediately + ", useProxy=" + this.useProxy + ", useBeforeSend=" + this.useBeforeSend + ", silentMultipleInit=" + this.silentMultipleInit + ", trackSessionAcrossSubdomains=" + this.trackSessionAcrossSubdomains + ", trackResources=" + this.trackResources + ", trackLongTask=" + this.trackLongTask + ", useCrossSiteSessionCookie=" + this.useCrossSiteSessionCookie + ", usePartitionedCrossSiteSessionCookie=" + this.usePartitionedCrossSiteSessionCookie + ", useSecureSessionCookie=" + this.useSecureSessionCookie + ", allowFallbackToLocalStorage=" + this.allowFallbackToLocalStorage + ", sessionPersistence=" + this.sessionPersistence + ", storeContextsAcrossPages=" + this.storeContextsAcrossPages + ", allowUntrustedEvents=" + this.allowUntrustedEvents + ", actionNameAttribute=" + this.actionNameAttribute + ", useAllowedTracingOrigins=" + this.useAllowedTracingOrigins + ", useAllowedTracingUrls=" + this.useAllowedTracingUrls + ", selectedTracingPropagators=" + this.selectedTracingPropagators + ", defaultPrivacyLevel=" + this.defaultPrivacyLevel + ", textAndInputPrivacyLevel=" + this.textAndInputPrivacyLevel + ", imagePrivacyLevel=" + this.imagePrivacyLevel + ", touchPrivacyLevel=" + this.touchPrivacyLevel + ", enablePrivacyForActionName=" + this.enablePrivacyForActionName + ", useExcludedActivityUrls=" + this.useExcludedActivityUrls + ", useWorkerUrl=" + this.useWorkerUrl + ", compressIntakeRequests=" + this.compressIntakeRequests + ", trackFrustrations=" + this.trackFrustrations + ", trackViewsManually=" + this.trackViewsManually + ", trackInteractions=" + this.trackInteractions + ", trackUserInteractions=" + this.trackUserInteractions + ", forwardErrorsToLogs=" + this.forwardErrorsToLogs + ", numberOfDisplays=" + this.numberOfDisplays + ", forwardConsoleLogs=" + this.forwardConsoleLogs + ", forwardReports=" + this.forwardReports + ", useLocalEncryption=" + this.useLocalEncryption + ", viewTrackingStrategy=" + this.viewTrackingStrategy + ", trackBackgroundEvents=" + this.trackBackgroundEvents + ", mobileVitalsUpdatePeriod=" + this.mobileVitalsUpdatePeriod + ", trackErrors=" + this.trackErrors + ", trackNetworkRequests=" + this.trackNetworkRequests + ", useTracing=" + this.useTracing + ", trackNativeViews=" + this.trackNativeViews + ", trackNativeErrors=" + this.trackNativeErrors + ", trackNativeLongTasks=" + this.trackNativeLongTasks + ", trackCrossPlatformLongTasks=" + this.trackCrossPlatformLongTasks + ", useFirstPartyHosts=" + this.useFirstPartyHosts + ", initializationType=" + this.initializationType + ", trackFlutterPerformance=" + this.trackFlutterPerformance + ", batchSize=" + this.batchSize + ", batchUploadFrequency=" + this.batchUploadFrequency + ", batchProcessingLevel=" + this.batchProcessingLevel + ", backgroundTasksEnabled=" + this.backgroundTasksEnabled + ", reactVersion=" + this.reactVersion + ", reactNativeVersion=" + this.reactNativeVersion + ", dartVersion=" + this.dartVersion + ", unityVersion=" + this.unityVersion + ", appHangThreshold=" + this.appHangThreshold + ", usePciIntake=" + this.usePciIntake + ", tracerApi=" + this.tracerApi + ", tracerApiVersion=" + this.tracerApiVersion + ", sendLogsAfterSessionExpiration=" + this.sendLogsAfterSessionExpiration + ", plugins=" + this.plugins + ", isMainProcess=" + this.isMainProcess + ", invTimeThresholdMs=" + this.invTimeThresholdMs + ", tnsTimeThresholdMs=" + this.tnsTimeThresholdMs + ", trackFeatureFlagsForEvents=" + this.trackFeatureFlagsForEvents + ", trackAnonymousUser=" + this.trackAnonymousUser + ")";
        }

        public Configuration(Long l, Long l2, Long l3, Long l4, Long l5, TraceContextInjection traceContextInjection, Long l6, Long l7, Long l8, TrackingConsent trackingConsent, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, SessionPersistence sessionPersistence, Boolean bool13, Boolean bool14, String str, Boolean bool15, Boolean bool16, List list, String str2, String str3, String str4, String str5, Boolean bool17, Boolean bool18, Boolean bool19, Boolean bool20, Boolean bool21, Boolean bool22, Boolean bool23, Boolean bool24, Boolean bool25, Long l9, List list2, List list3, Boolean bool26, ViewTrackingStrategy viewTrackingStrategy, Boolean bool27, Long l10, Boolean bool28, Boolean bool29, Boolean bool30, Boolean bool31, Boolean bool32, Boolean bool33, Boolean bool34, Boolean bool35, String str6, Boolean bool36, Long l11, Long l12, Long l13, Boolean bool37, String str7, String str8, String str9, String str10, Long l14, Boolean bool38, String str11, String str12, Boolean bool39, List list4, Boolean bool40, Long l15, Long l16, List list5, Boolean bool41) {
            this.sessionSampleRate = l;
            this.telemetrySampleRate = l2;
            this.telemetryConfigurationSampleRate = l3;
            this.telemetryUsageSampleRate = l4;
            this.traceSampleRate = l5;
            this.traceContextInjection = traceContextInjection;
            this.premiumSampleRate = l6;
            this.replaySampleRate = l7;
            this.sessionReplaySampleRate = l8;
            this.trackingConsent = trackingConsent;
            this.startSessionReplayRecordingManually = bool;
            this.startRecordingImmediately = bool2;
            this.useProxy = bool3;
            this.useBeforeSend = bool4;
            this.silentMultipleInit = bool5;
            this.trackSessionAcrossSubdomains = bool6;
            this.trackResources = bool7;
            this.trackLongTask = bool8;
            this.useCrossSiteSessionCookie = bool9;
            this.usePartitionedCrossSiteSessionCookie = bool10;
            this.useSecureSessionCookie = bool11;
            this.allowFallbackToLocalStorage = bool12;
            this.sessionPersistence = sessionPersistence;
            this.storeContextsAcrossPages = bool13;
            this.allowUntrustedEvents = bool14;
            this.actionNameAttribute = str;
            this.useAllowedTracingOrigins = bool15;
            this.useAllowedTracingUrls = bool16;
            this.selectedTracingPropagators = list;
            this.defaultPrivacyLevel = str2;
            this.textAndInputPrivacyLevel = str3;
            this.imagePrivacyLevel = str4;
            this.touchPrivacyLevel = str5;
            this.enablePrivacyForActionName = bool17;
            this.useExcludedActivityUrls = bool18;
            this.useWorkerUrl = bool19;
            this.compressIntakeRequests = bool20;
            this.trackFrustrations = bool21;
            this.trackViewsManually = bool22;
            this.trackInteractions = bool23;
            this.trackUserInteractions = bool24;
            this.forwardErrorsToLogs = bool25;
            this.numberOfDisplays = l9;
            this.forwardConsoleLogs = list2;
            this.forwardReports = list3;
            this.useLocalEncryption = bool26;
            this.viewTrackingStrategy = viewTrackingStrategy;
            this.trackBackgroundEvents = bool27;
            this.mobileVitalsUpdatePeriod = l10;
            this.trackErrors = bool28;
            this.trackNetworkRequests = bool29;
            this.useTracing = bool30;
            this.trackNativeViews = bool31;
            this.trackNativeErrors = bool32;
            this.trackNativeLongTasks = bool33;
            this.trackCrossPlatformLongTasks = bool34;
            this.useFirstPartyHosts = bool35;
            this.initializationType = str6;
            this.trackFlutterPerformance = bool36;
            this.batchSize = l11;
            this.batchUploadFrequency = l12;
            this.batchProcessingLevel = l13;
            this.backgroundTasksEnabled = bool37;
            this.reactVersion = str7;
            this.reactNativeVersion = str8;
            this.dartVersion = str9;
            this.unityVersion = str10;
            this.appHangThreshold = l14;
            this.usePciIntake = bool38;
            this.tracerApi = str11;
            this.tracerApiVersion = str12;
            this.sendLogsAfterSessionExpiration = bool39;
            this.plugins = list4;
            this.isMainProcess = bool40;
            this.invTimeThresholdMs = l15;
            this.tnsTimeThresholdMs = l16;
            this.trackFeatureFlagsForEvents = list5;
            this.trackAnonymousUser = bool41;
        }

        public final void setTrackResources(Boolean bool) {
            this.trackResources = bool;
        }

        public final void setTrackLongTask(Boolean bool) {
            this.trackLongTask = bool;
        }

        public final void setTrackInteractions(Boolean bool) {
            this.trackInteractions = bool;
        }

        public final void setTrackErrors(Boolean bool) {
            this.trackErrors = bool;
        }

        public final void setTrackNetworkRequests(Boolean bool) {
            this.trackNetworkRequests = bool;
        }

        public final void setTrackNativeErrors(Boolean bool) {
            this.trackNativeErrors = bool;
        }

        public final void setTrackNativeLongTasks(Boolean bool) {
            this.trackNativeLongTasks = bool;
        }

        public final void setTrackCrossPlatformLongTasks(Boolean bool) {
            this.trackCrossPlatformLongTasks = bool;
        }

        public final void setInitializationType(String str) {
            this.initializationType = str;
        }

        public final void setReactVersion(String str) {
            this.reactVersion = str;
        }

        public final void setReactNativeVersion(String str) {
            this.reactNativeVersion = str;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Configuration(Long l, Long l2, Long l3, Long l4, Long l5, TraceContextInjection traceContextInjection, Long l6, Long l7, Long l8, TrackingConsent trackingConsent, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, SessionPersistence sessionPersistence, Boolean bool13, Boolean bool14, String str, Boolean bool15, Boolean bool16, List list, String str2, String str3, String str4, String str5, Boolean bool17, Boolean bool18, Boolean bool19, Boolean bool20, Boolean bool21, Boolean bool22, Boolean bool23, Boolean bool24, Boolean bool25, Long l9, List list2, List list3, Boolean bool26, ViewTrackingStrategy viewTrackingStrategy, Boolean bool27, Long l10, Boolean bool28, Boolean bool29, Boolean bool30, Boolean bool31, Boolean bool32, Boolean bool33, Boolean bool34, Boolean bool35, String str6, Boolean bool36, Long l11, Long l12, Long l13, Boolean bool37, String str7, String str8, String str9, String str10, Long l14, Boolean bool38, String str11, String str12, Boolean bool39, List list4, Boolean bool40, Long l15, Long l16, List list5, Boolean bool41, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            Long l17 = (i & 1) != 0 ? null : l;
            Long l18 = (i & 2) != 0 ? null : l2;
            Long l19 = (i & 4) != 0 ? null : l3;
            Long l20 = (i & 8) != 0 ? null : l4;
            Long l21 = (i & 16) != 0 ? null : l5;
            TraceContextInjection traceContextInjection2 = (i & 32) != 0 ? null : traceContextInjection;
            Long l22 = (i & 64) != 0 ? null : l6;
            Long l23 = (i & 128) != 0 ? null : l7;
            Long l24 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : l8;
            TrackingConsent trackingConsent2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : trackingConsent;
            Boolean bool42 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : bool;
            Boolean bool43 = (i & 2048) != 0 ? null : bool2;
            Boolean bool44 = (i & 4096) != 0 ? null : bool3;
            Long l25 = l17;
            Boolean bool45 = (i & 8192) != 0 ? null : bool4;
            Boolean bool46 = (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : bool5;
            Boolean bool47 = (i & 32768) != 0 ? null : bool6;
            Boolean bool48 = (i & 65536) != 0 ? null : bool7;
            Boolean bool49 = (i & 131072) != 0 ? null : bool8;
            Boolean bool50 = (i & 262144) != 0 ? null : bool9;
            Boolean bool51 = (i & 524288) != 0 ? null : bool10;
            Boolean bool52 = (i & 1048576) != 0 ? null : bool11;
            Boolean bool53 = (i & 2097152) != 0 ? null : bool12;
            SessionPersistence sessionPersistence2 = (i & 4194304) != 0 ? null : sessionPersistence;
            Boolean bool54 = (i & 8388608) != 0 ? null : bool13;
            Boolean bool55 = (i & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? null : bool14;
            String str13 = (i & 33554432) != 0 ? null : str;
            Boolean bool56 = (i & 67108864) != 0 ? null : bool15;
            Boolean bool57 = (i & 134217728) != 0 ? null : bool16;
            List list6 = (i & 268435456) != 0 ? null : list;
            String str14 = (i & 536870912) != 0 ? null : str2;
            String str15 = (i & 1073741824) != 0 ? null : str3;
            String str16 = (i & LinearLayoutManager.INVALID_OFFSET) != 0 ? null : str4;
            this(l25, l18, l19, l20, l21, traceContextInjection2, l22, l23, l24, trackingConsent2, bool42, bool43, bool44, bool45, bool46, bool47, bool48, bool49, bool50, bool51, bool52, bool53, sessionPersistence2, bool54, bool55, str13, bool56, bool57, list6, str14, str15, str16, (i2 & 1) != 0 ? null : str5, (i2 & 2) != 0 ? null : bool17, (i2 & 4) != 0 ? null : bool18, (i2 & 8) != 0 ? null : bool19, (i2 & 16) != 0 ? null : bool20, (i2 & 32) != 0 ? null : bool21, (i2 & 64) != 0 ? null : bool22, (i2 & 128) != 0 ? null : bool23, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : bool24, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : bool25, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : l9, (i2 & 2048) != 0 ? null : list2, (i2 & 4096) != 0 ? null : list3, (i2 & 8192) != 0 ? null : bool26, (i2 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : viewTrackingStrategy, (i2 & 32768) != 0 ? null : bool27, (i2 & 65536) != 0 ? null : l10, (i2 & 131072) != 0 ? null : bool28, (i2 & 262144) != 0 ? null : bool29, (i2 & 524288) != 0 ? null : bool30, (i2 & 1048576) != 0 ? null : bool31, (i2 & 2097152) != 0 ? null : bool32, (i2 & 4194304) != 0 ? null : bool33, (i2 & 8388608) != 0 ? null : bool34, (i2 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? null : bool35, (i2 & 33554432) != 0 ? null : str6, (i2 & 67108864) != 0 ? null : bool36, (i2 & 134217728) != 0 ? null : l11, (i2 & 268435456) != 0 ? null : l12, (i2 & 536870912) != 0 ? null : l13, (i2 & 1073741824) != 0 ? null : bool37, (i2 & LinearLayoutManager.INVALID_OFFSET) != 0 ? null : str7, (i3 & 1) != 0 ? null : str8, (i3 & 2) != 0 ? null : str9, (i3 & 4) != 0 ? null : str10, (i3 & 8) != 0 ? null : l14, (i3 & 16) != 0 ? null : bool38, (i3 & 32) != 0 ? null : str11, (i3 & 64) != 0 ? null : str12, (i3 & 128) != 0 ? null : bool39, (i3 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : list4, (i3 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : bool40, (i3 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : l15, (i3 & 2048) != 0 ? null : l16, (i3 & 4096) != 0 ? null : list5, (i3 & 8192) != 0 ? Boolean.TRUE : bool41);
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Long l = this.sessionSampleRate;
            if (l != null) {
                jsonObject.addProperty("session_sample_rate", Long.valueOf(l.longValue()));
                Unit unit = Unit.INSTANCE;
            }
            Long l2 = this.telemetrySampleRate;
            if (l2 != null) {
                jsonObject.addProperty("telemetry_sample_rate", Long.valueOf(l2.longValue()));
                Unit unit2 = Unit.INSTANCE;
            }
            Long l3 = this.telemetryConfigurationSampleRate;
            if (l3 != null) {
                jsonObject.addProperty("telemetry_configuration_sample_rate", Long.valueOf(l3.longValue()));
                Unit unit3 = Unit.INSTANCE;
            }
            Long l4 = this.telemetryUsageSampleRate;
            if (l4 != null) {
                jsonObject.addProperty("telemetry_usage_sample_rate", Long.valueOf(l4.longValue()));
                Unit unit4 = Unit.INSTANCE;
            }
            Long l5 = this.traceSampleRate;
            if (l5 != null) {
                jsonObject.addProperty("trace_sample_rate", Long.valueOf(l5.longValue()));
                Unit unit5 = Unit.INSTANCE;
            }
            TraceContextInjection traceContextInjection = this.traceContextInjection;
            if (traceContextInjection != null) {
                jsonObject.add("trace_context_injection", traceContextInjection.toJson());
                Unit unit6 = Unit.INSTANCE;
            }
            Long l6 = this.premiumSampleRate;
            if (l6 != null) {
                jsonObject.addProperty("premium_sample_rate", Long.valueOf(l6.longValue()));
                Unit unit7 = Unit.INSTANCE;
            }
            Long l7 = this.replaySampleRate;
            if (l7 != null) {
                jsonObject.addProperty("replay_sample_rate", Long.valueOf(l7.longValue()));
                Unit unit8 = Unit.INSTANCE;
            }
            Long l8 = this.sessionReplaySampleRate;
            if (l8 != null) {
                jsonObject.addProperty("session_replay_sample_rate", Long.valueOf(l8.longValue()));
                Unit unit9 = Unit.INSTANCE;
            }
            TrackingConsent trackingConsent = this.trackingConsent;
            if (trackingConsent != null) {
                jsonObject.add("tracking_consent", trackingConsent.toJson());
                Unit unit10 = Unit.INSTANCE;
            }
            Boolean bool = this.startSessionReplayRecordingManually;
            if (bool != null) {
                jsonObject.addProperty("start_session_replay_recording_manually", bool);
                Unit unit11 = Unit.INSTANCE;
            }
            Boolean bool2 = this.startRecordingImmediately;
            if (bool2 != null) {
                jsonObject.addProperty("start_recording_immediately", bool2);
                Unit unit12 = Unit.INSTANCE;
            }
            Boolean bool3 = this.useProxy;
            if (bool3 != null) {
                jsonObject.addProperty("use_proxy", bool3);
                Unit unit13 = Unit.INSTANCE;
            }
            Boolean bool4 = this.useBeforeSend;
            if (bool4 != null) {
                jsonObject.addProperty("use_before_send", bool4);
                Unit unit14 = Unit.INSTANCE;
            }
            Boolean bool5 = this.silentMultipleInit;
            if (bool5 != null) {
                jsonObject.addProperty("silent_multiple_init", bool5);
                Unit unit15 = Unit.INSTANCE;
            }
            Boolean bool6 = this.trackSessionAcrossSubdomains;
            if (bool6 != null) {
                jsonObject.addProperty("track_session_across_subdomains", bool6);
                Unit unit16 = Unit.INSTANCE;
            }
            Boolean bool7 = this.trackResources;
            if (bool7 != null) {
                jsonObject.addProperty("track_resources", bool7);
                Unit unit17 = Unit.INSTANCE;
            }
            Boolean bool8 = this.trackLongTask;
            if (bool8 != null) {
                jsonObject.addProperty("track_long_task", bool8);
                Unit unit18 = Unit.INSTANCE;
            }
            Boolean bool9 = this.useCrossSiteSessionCookie;
            if (bool9 != null) {
                jsonObject.addProperty("use_cross_site_session_cookie", bool9);
                Unit unit19 = Unit.INSTANCE;
            }
            Boolean bool10 = this.usePartitionedCrossSiteSessionCookie;
            if (bool10 != null) {
                jsonObject.addProperty("use_partitioned_cross_site_session_cookie", bool10);
                Unit unit20 = Unit.INSTANCE;
            }
            Boolean bool11 = this.useSecureSessionCookie;
            if (bool11 != null) {
                jsonObject.addProperty("use_secure_session_cookie", bool11);
                Unit unit21 = Unit.INSTANCE;
            }
            Boolean bool12 = this.allowFallbackToLocalStorage;
            if (bool12 != null) {
                jsonObject.addProperty("allow_fallback_to_local_storage", bool12);
                Unit unit22 = Unit.INSTANCE;
            }
            SessionPersistence sessionPersistence = this.sessionPersistence;
            if (sessionPersistence != null) {
                jsonObject.add("session_persistence", sessionPersistence.toJson());
                Unit unit23 = Unit.INSTANCE;
            }
            Boolean bool13 = this.storeContextsAcrossPages;
            if (bool13 != null) {
                jsonObject.addProperty("store_contexts_across_pages", bool13);
                Unit unit24 = Unit.INSTANCE;
            }
            Boolean bool14 = this.allowUntrustedEvents;
            if (bool14 != null) {
                jsonObject.addProperty("allow_untrusted_events", bool14);
                Unit unit25 = Unit.INSTANCE;
            }
            String str = this.actionNameAttribute;
            if (str != null) {
                jsonObject.addProperty("action_name_attribute", str);
                Unit unit26 = Unit.INSTANCE;
            }
            Boolean bool15 = this.useAllowedTracingOrigins;
            if (bool15 != null) {
                jsonObject.addProperty("use_allowed_tracing_origins", bool15);
                Unit unit27 = Unit.INSTANCE;
            }
            Boolean bool16 = this.useAllowedTracingUrls;
            if (bool16 != null) {
                jsonObject.addProperty("use_allowed_tracing_urls", bool16);
                Unit unit28 = Unit.INSTANCE;
            }
            List list = this.selectedTracingPropagators;
            if (list != null) {
                JsonArray jsonArray = new JsonArray(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    jsonArray.add(((SelectedTracingPropagator) it.next()).toJson());
                }
                jsonObject.add("selected_tracing_propagators", jsonArray);
                Unit unit29 = Unit.INSTANCE;
            }
            String str2 = this.defaultPrivacyLevel;
            if (str2 != null) {
                jsonObject.addProperty("default_privacy_level", str2);
                Unit unit30 = Unit.INSTANCE;
            }
            String str3 = this.textAndInputPrivacyLevel;
            if (str3 != null) {
                jsonObject.addProperty("text_and_input_privacy_level", str3);
                Unit unit31 = Unit.INSTANCE;
            }
            String str4 = this.imagePrivacyLevel;
            if (str4 != null) {
                jsonObject.addProperty("image_privacy_level", str4);
                Unit unit32 = Unit.INSTANCE;
            }
            String str5 = this.touchPrivacyLevel;
            if (str5 != null) {
                jsonObject.addProperty("touch_privacy_level", str5);
                Unit unit33 = Unit.INSTANCE;
            }
            Boolean bool17 = this.enablePrivacyForActionName;
            if (bool17 != null) {
                jsonObject.addProperty("enable_privacy_for_action_name", bool17);
                Unit unit34 = Unit.INSTANCE;
            }
            Boolean bool18 = this.useExcludedActivityUrls;
            if (bool18 != null) {
                jsonObject.addProperty("use_excluded_activity_urls", bool18);
                Unit unit35 = Unit.INSTANCE;
            }
            Boolean bool19 = this.useWorkerUrl;
            if (bool19 != null) {
                jsonObject.addProperty("use_worker_url", bool19);
                Unit unit36 = Unit.INSTANCE;
            }
            Boolean bool20 = this.compressIntakeRequests;
            if (bool20 != null) {
                jsonObject.addProperty("compress_intake_requests", bool20);
                Unit unit37 = Unit.INSTANCE;
            }
            Boolean bool21 = this.trackFrustrations;
            if (bool21 != null) {
                jsonObject.addProperty("track_frustrations", bool21);
                Unit unit38 = Unit.INSTANCE;
            }
            Boolean bool22 = this.trackViewsManually;
            if (bool22 != null) {
                jsonObject.addProperty("track_views_manually", bool22);
                Unit unit39 = Unit.INSTANCE;
            }
            Boolean bool23 = this.trackInteractions;
            if (bool23 != null) {
                jsonObject.addProperty("track_interactions", bool23);
                Unit unit40 = Unit.INSTANCE;
            }
            Boolean bool24 = this.trackUserInteractions;
            if (bool24 != null) {
                jsonObject.addProperty("track_user_interactions", bool24);
                Unit unit41 = Unit.INSTANCE;
            }
            Boolean bool25 = this.forwardErrorsToLogs;
            if (bool25 != null) {
                jsonObject.addProperty("forward_errors_to_logs", bool25);
                Unit unit42 = Unit.INSTANCE;
            }
            Long l9 = this.numberOfDisplays;
            if (l9 != null) {
                jsonObject.addProperty("number_of_displays", Long.valueOf(l9.longValue()));
                Unit unit43 = Unit.INSTANCE;
            }
            List list2 = this.forwardConsoleLogs;
            if (list2 != null) {
                JsonArray jsonArray2 = new JsonArray(list2.size());
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    jsonArray2.add((String) it2.next());
                }
                jsonObject.add("forward_console_logs", jsonArray2);
                Unit unit44 = Unit.INSTANCE;
            }
            List list3 = this.forwardReports;
            if (list3 != null) {
                JsonArray jsonArray3 = new JsonArray(list3.size());
                Iterator it3 = list3.iterator();
                while (it3.hasNext()) {
                    jsonArray3.add((String) it3.next());
                }
                jsonObject.add("forward_reports", jsonArray3);
                Unit unit45 = Unit.INSTANCE;
            }
            Boolean bool26 = this.useLocalEncryption;
            if (bool26 != null) {
                jsonObject.addProperty("use_local_encryption", bool26);
                Unit unit46 = Unit.INSTANCE;
            }
            ViewTrackingStrategy viewTrackingStrategy = this.viewTrackingStrategy;
            if (viewTrackingStrategy != null) {
                jsonObject.add("view_tracking_strategy", viewTrackingStrategy.toJson());
                Unit unit47 = Unit.INSTANCE;
            }
            Boolean bool27 = this.trackBackgroundEvents;
            if (bool27 != null) {
                jsonObject.addProperty("track_background_events", bool27);
                Unit unit48 = Unit.INSTANCE;
            }
            Long l10 = this.mobileVitalsUpdatePeriod;
            if (l10 != null) {
                jsonObject.addProperty("mobile_vitals_update_period", Long.valueOf(l10.longValue()));
                Unit unit49 = Unit.INSTANCE;
            }
            Boolean bool28 = this.trackErrors;
            if (bool28 != null) {
                jsonObject.addProperty("track_errors", bool28);
                Unit unit50 = Unit.INSTANCE;
            }
            Boolean bool29 = this.trackNetworkRequests;
            if (bool29 != null) {
                jsonObject.addProperty("track_network_requests", bool29);
                Unit unit51 = Unit.INSTANCE;
            }
            Boolean bool30 = this.useTracing;
            if (bool30 != null) {
                jsonObject.addProperty("use_tracing", bool30);
                Unit unit52 = Unit.INSTANCE;
            }
            Boolean bool31 = this.trackNativeViews;
            if (bool31 != null) {
                jsonObject.addProperty("track_native_views", bool31);
                Unit unit53 = Unit.INSTANCE;
            }
            Boolean bool32 = this.trackNativeErrors;
            if (bool32 != null) {
                jsonObject.addProperty("track_native_errors", bool32);
                Unit unit54 = Unit.INSTANCE;
            }
            Boolean bool33 = this.trackNativeLongTasks;
            if (bool33 != null) {
                jsonObject.addProperty("track_native_long_tasks", bool33);
                Unit unit55 = Unit.INSTANCE;
            }
            Boolean bool34 = this.trackCrossPlatformLongTasks;
            if (bool34 != null) {
                jsonObject.addProperty("track_cross_platform_long_tasks", bool34);
                Unit unit56 = Unit.INSTANCE;
            }
            Boolean bool35 = this.useFirstPartyHosts;
            if (bool35 != null) {
                jsonObject.addProperty("use_first_party_hosts", bool35);
                Unit unit57 = Unit.INSTANCE;
            }
            String str6 = this.initializationType;
            if (str6 != null) {
                jsonObject.addProperty("initialization_type", str6);
                Unit unit58 = Unit.INSTANCE;
            }
            Boolean bool36 = this.trackFlutterPerformance;
            if (bool36 != null) {
                jsonObject.addProperty("track_flutter_performance", bool36);
                Unit unit59 = Unit.INSTANCE;
            }
            Long l11 = this.batchSize;
            if (l11 != null) {
                jsonObject.addProperty("batch_size", Long.valueOf(l11.longValue()));
                Unit unit60 = Unit.INSTANCE;
            }
            Long l12 = this.batchUploadFrequency;
            if (l12 != null) {
                jsonObject.addProperty("batch_upload_frequency", Long.valueOf(l12.longValue()));
                Unit unit61 = Unit.INSTANCE;
            }
            Long l13 = this.batchProcessingLevel;
            if (l13 != null) {
                jsonObject.addProperty("batch_processing_level", Long.valueOf(l13.longValue()));
                Unit unit62 = Unit.INSTANCE;
            }
            Boolean bool37 = this.backgroundTasksEnabled;
            if (bool37 != null) {
                jsonObject.addProperty("background_tasks_enabled", bool37);
                Unit unit63 = Unit.INSTANCE;
            }
            String str7 = this.reactVersion;
            if (str7 != null) {
                jsonObject.addProperty("react_version", str7);
                Unit unit64 = Unit.INSTANCE;
            }
            String str8 = this.reactNativeVersion;
            if (str8 != null) {
                jsonObject.addProperty("react_native_version", str8);
                Unit unit65 = Unit.INSTANCE;
            }
            String str9 = this.dartVersion;
            if (str9 != null) {
                jsonObject.addProperty("dart_version", str9);
                Unit unit66 = Unit.INSTANCE;
            }
            String str10 = this.unityVersion;
            if (str10 != null) {
                jsonObject.addProperty("unity_version", str10);
                Unit unit67 = Unit.INSTANCE;
            }
            Long l14 = this.appHangThreshold;
            if (l14 != null) {
                jsonObject.addProperty("app_hang_threshold", Long.valueOf(l14.longValue()));
                Unit unit68 = Unit.INSTANCE;
            }
            Boolean bool38 = this.usePciIntake;
            if (bool38 != null) {
                jsonObject.addProperty("use_pci_intake", bool38);
                Unit unit69 = Unit.INSTANCE;
            }
            String str11 = this.tracerApi;
            if (str11 != null) {
                jsonObject.addProperty("tracer_api", str11);
                Unit unit70 = Unit.INSTANCE;
            }
            String str12 = this.tracerApiVersion;
            if (str12 != null) {
                jsonObject.addProperty("tracer_api_version", str12);
                Unit unit71 = Unit.INSTANCE;
            }
            Boolean bool39 = this.sendLogsAfterSessionExpiration;
            if (bool39 != null) {
                jsonObject.addProperty("send_logs_after_session_expiration", bool39);
                Unit unit72 = Unit.INSTANCE;
            }
            List list4 = this.plugins;
            if (list4 != null) {
                JsonArray jsonArray4 = new JsonArray(list4.size());
                Iterator it4 = list4.iterator();
                if (it4.hasNext()) {
                    MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(it4.next());
                    throw null;
                }
                jsonObject.add("plugins", jsonArray4);
                Unit unit73 = Unit.INSTANCE;
            }
            Boolean bool40 = this.isMainProcess;
            if (bool40 != null) {
                jsonObject.addProperty("is_main_process", bool40);
                Unit unit74 = Unit.INSTANCE;
            }
            Long l15 = this.invTimeThresholdMs;
            if (l15 != null) {
                jsonObject.addProperty("inv_time_threshold_ms", Long.valueOf(l15.longValue()));
                Unit unit75 = Unit.INSTANCE;
            }
            Long l16 = this.tnsTimeThresholdMs;
            if (l16 != null) {
                jsonObject.addProperty("tns_time_threshold_ms", Long.valueOf(l16.longValue()));
                Unit unit76 = Unit.INSTANCE;
            }
            List list5 = this.trackFeatureFlagsForEvents;
            if (list5 != null) {
                JsonArray jsonArray5 = new JsonArray(list5.size());
                Iterator it5 = list5.iterator();
                while (it5.hasNext()) {
                    jsonArray5.add(((TrackFeatureFlagsForEvent) it5.next()).toJson());
                }
                jsonObject.add("track_feature_flags_for_events", jsonArray5);
                Unit unit77 = Unit.INSTANCE;
            }
            Boolean bool41 = this.trackAnonymousUser;
            if (bool41 != null) {
                jsonObject.addProperty("track_anonymous_user", bool41);
                Unit unit78 = Unit.INSTANCE;
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public enum Source {
        ANDROID("android"),
        IOS("ios"),
        BROWSER("browser"),
        FLUTTER("flutter"),
        REACT_NATIVE(RNPurchasesModule.PLATFORM_NAME),
        UNITY("unity"),
        KOTLIN_MULTIPLATFORM("kotlin-multiplatform");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        Source(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Source fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (Source source : Source.values()) {
                    if (Intrinsics.areEqual(source.jsonValue, jsonString)) {
                        return source;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum TraceContextInjection {
        ALL("all"),
        SAMPLED("sampled");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        TraceContextInjection(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public enum TrackingConsent {
        GRANTED("granted"),
        NOT_GRANTED("not-granted"),
        PENDING("pending");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        TrackingConsent(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public enum SessionPersistence {
        LOCAL_STORAGE("local-storage"),
        COOKIE("cookie");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        SessionPersistence(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public enum SelectedTracingPropagator {
        DATADOG("datadog"),
        B3("b3"),
        B3MULTI("b3multi"),
        TRACECONTEXT("tracecontext");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        SelectedTracingPropagator(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public enum ViewTrackingStrategy {
        ACTIVITYVIEWTRACKINGSTRATEGY("ActivityViewTrackingStrategy"),
        FRAGMENTVIEWTRACKINGSTRATEGY("FragmentViewTrackingStrategy"),
        MIXEDVIEWTRACKINGSTRATEGY("MixedViewTrackingStrategy"),
        NAVIGATIONVIEWTRACKINGSTRATEGY("NavigationViewTrackingStrategy");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        ViewTrackingStrategy(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public enum TrackFeatureFlagsForEvent {
        VITAL("vital"),
        RESOURCE("resource"),
        ACTION("action"),
        LONG_TASK("long_task");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        TrackFeatureFlagsForEvent(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
