package com.datadog.reactnative;

import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DdSdkConfiguration {
    private final Map additionalConfig;
    private final String applicationId;
    private final String batchProcessingLevel;
    private final String batchSize;
    private final Boolean bundleLogsWithRum;
    private final Boolean bundleLogsWithTraces;
    private final String clientToken;
    private final ConfigurationForTelemetry configurationForTelemetry;
    private final CustomEndpoints customEndpoints;
    private final String env;
    private final Map firstPartyHosts;
    private final Double initialResourceThreshold;
    private final Double longTaskThresholdMs;
    private final Boolean nativeCrashReportEnabled;
    private final Boolean nativeInteractionTracking;
    private final Double nativeLongTaskThresholdMs;
    private final Boolean nativeViewTracking;
    private final Pair proxyConfig;
    private final Double sampleRate;
    private final String serviceName;
    private final String site;
    private final Double telemetrySampleRate;
    private final Boolean trackBackgroundEvents;
    private final Boolean trackFrustrations;
    private final Boolean trackNonFatalAnrs;
    private final String trackingConsent;
    private final String uploadFrequency;
    private final String verbosity;
    private final String vitalsUpdateFrequency;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DdSdkConfiguration)) {
            return false;
        }
        DdSdkConfiguration ddSdkConfiguration = (DdSdkConfiguration) obj;
        return Intrinsics.areEqual(this.clientToken, ddSdkConfiguration.clientToken) && Intrinsics.areEqual(this.env, ddSdkConfiguration.env) && Intrinsics.areEqual(this.applicationId, ddSdkConfiguration.applicationId) && Intrinsics.areEqual(this.nativeCrashReportEnabled, ddSdkConfiguration.nativeCrashReportEnabled) && Intrinsics.areEqual(this.nativeLongTaskThresholdMs, ddSdkConfiguration.nativeLongTaskThresholdMs) && Intrinsics.areEqual(this.longTaskThresholdMs, ddSdkConfiguration.longTaskThresholdMs) && Intrinsics.areEqual(this.sampleRate, ddSdkConfiguration.sampleRate) && Intrinsics.areEqual(this.site, ddSdkConfiguration.site) && Intrinsics.areEqual(this.trackingConsent, ddSdkConfiguration.trackingConsent) && Intrinsics.areEqual(this.telemetrySampleRate, ddSdkConfiguration.telemetrySampleRate) && Intrinsics.areEqual(this.vitalsUpdateFrequency, ddSdkConfiguration.vitalsUpdateFrequency) && Intrinsics.areEqual(this.trackFrustrations, ddSdkConfiguration.trackFrustrations) && Intrinsics.areEqual(this.uploadFrequency, ddSdkConfiguration.uploadFrequency) && Intrinsics.areEqual(this.batchSize, ddSdkConfiguration.batchSize) && Intrinsics.areEqual(this.trackBackgroundEvents, ddSdkConfiguration.trackBackgroundEvents) && Intrinsics.areEqual(this.customEndpoints, ddSdkConfiguration.customEndpoints) && Intrinsics.areEqual(this.additionalConfig, ddSdkConfiguration.additionalConfig) && Intrinsics.areEqual(this.configurationForTelemetry, ddSdkConfiguration.configurationForTelemetry) && Intrinsics.areEqual(this.nativeViewTracking, ddSdkConfiguration.nativeViewTracking) && Intrinsics.areEqual(this.nativeInteractionTracking, ddSdkConfiguration.nativeInteractionTracking) && Intrinsics.areEqual(this.verbosity, ddSdkConfiguration.verbosity) && Intrinsics.areEqual(this.proxyConfig, ddSdkConfiguration.proxyConfig) && Intrinsics.areEqual(this.serviceName, ddSdkConfiguration.serviceName) && Intrinsics.areEqual(this.firstPartyHosts, ddSdkConfiguration.firstPartyHosts) && Intrinsics.areEqual(this.bundleLogsWithRum, ddSdkConfiguration.bundleLogsWithRum) && Intrinsics.areEqual(this.bundleLogsWithTraces, ddSdkConfiguration.bundleLogsWithTraces) && Intrinsics.areEqual(this.trackNonFatalAnrs, ddSdkConfiguration.trackNonFatalAnrs) && Intrinsics.areEqual(this.batchProcessingLevel, ddSdkConfiguration.batchProcessingLevel) && Intrinsics.areEqual(this.initialResourceThreshold, ddSdkConfiguration.initialResourceThreshold);
    }

    public int hashCode() {
        int iHashCode = ((((this.clientToken.hashCode() * 31) + this.env.hashCode()) * 31) + this.applicationId.hashCode()) * 31;
        Boolean bool = this.nativeCrashReportEnabled;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Double d = this.nativeLongTaskThresholdMs;
        int iHashCode3 = (iHashCode2 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.longTaskThresholdMs;
        int iHashCode4 = (iHashCode3 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.sampleRate;
        int iHashCode5 = (iHashCode4 + (d3 == null ? 0 : d3.hashCode())) * 31;
        String str = this.site;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.trackingConsent;
        int iHashCode7 = (iHashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d4 = this.telemetrySampleRate;
        int iHashCode8 = (iHashCode7 + (d4 == null ? 0 : d4.hashCode())) * 31;
        String str3 = this.vitalsUpdateFrequency;
        int iHashCode9 = (iHashCode8 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool2 = this.trackFrustrations;
        int iHashCode10 = (iHashCode9 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str4 = this.uploadFrequency;
        int iHashCode11 = (iHashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.batchSize;
        int iHashCode12 = (iHashCode11 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool3 = this.trackBackgroundEvents;
        int iHashCode13 = (iHashCode12 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        CustomEndpoints customEndpoints = this.customEndpoints;
        int iHashCode14 = (iHashCode13 + (customEndpoints == null ? 0 : customEndpoints.hashCode())) * 31;
        Map map = this.additionalConfig;
        int iHashCode15 = (iHashCode14 + (map == null ? 0 : map.hashCode())) * 31;
        ConfigurationForTelemetry configurationForTelemetry = this.configurationForTelemetry;
        int iHashCode16 = (iHashCode15 + (configurationForTelemetry == null ? 0 : configurationForTelemetry.hashCode())) * 31;
        Boolean bool4 = this.nativeViewTracking;
        int iHashCode17 = (iHashCode16 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.nativeInteractionTracking;
        int iHashCode18 = (iHashCode17 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        String str6 = this.verbosity;
        int iHashCode19 = (iHashCode18 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Pair pair = this.proxyConfig;
        int iHashCode20 = (iHashCode19 + (pair == null ? 0 : pair.hashCode())) * 31;
        String str7 = this.serviceName;
        int iHashCode21 = (iHashCode20 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Map map2 = this.firstPartyHosts;
        int iHashCode22 = (iHashCode21 + (map2 == null ? 0 : map2.hashCode())) * 31;
        Boolean bool6 = this.bundleLogsWithRum;
        int iHashCode23 = (iHashCode22 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.bundleLogsWithTraces;
        int iHashCode24 = (iHashCode23 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Boolean bool8 = this.trackNonFatalAnrs;
        int iHashCode25 = (iHashCode24 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        String str8 = this.batchProcessingLevel;
        int iHashCode26 = (iHashCode25 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Double d5 = this.initialResourceThreshold;
        return iHashCode26 + (d5 != null ? d5.hashCode() : 0);
    }

    public String toString() {
        return "DdSdkConfiguration(clientToken=" + this.clientToken + ", env=" + this.env + ", applicationId=" + this.applicationId + ", nativeCrashReportEnabled=" + this.nativeCrashReportEnabled + ", nativeLongTaskThresholdMs=" + this.nativeLongTaskThresholdMs + ", longTaskThresholdMs=" + this.longTaskThresholdMs + ", sampleRate=" + this.sampleRate + ", site=" + this.site + ", trackingConsent=" + this.trackingConsent + ", telemetrySampleRate=" + this.telemetrySampleRate + ", vitalsUpdateFrequency=" + this.vitalsUpdateFrequency + ", trackFrustrations=" + this.trackFrustrations + ", uploadFrequency=" + this.uploadFrequency + ", batchSize=" + this.batchSize + ", trackBackgroundEvents=" + this.trackBackgroundEvents + ", customEndpoints=" + this.customEndpoints + ", additionalConfig=" + this.additionalConfig + ", configurationForTelemetry=" + this.configurationForTelemetry + ", nativeViewTracking=" + this.nativeViewTracking + ", nativeInteractionTracking=" + this.nativeInteractionTracking + ", verbosity=" + this.verbosity + ", proxyConfig=" + this.proxyConfig + ", serviceName=" + this.serviceName + ", firstPartyHosts=" + this.firstPartyHosts + ", bundleLogsWithRum=" + this.bundleLogsWithRum + ", bundleLogsWithTraces=" + this.bundleLogsWithTraces + ", trackNonFatalAnrs=" + this.trackNonFatalAnrs + ", batchProcessingLevel=" + this.batchProcessingLevel + ", initialResourceThreshold=" + this.initialResourceThreshold + ")";
    }

    public DdSdkConfiguration(String clientToken, String env, String applicationId, Boolean bool, Double d, Double d2, Double d3, String str, String str2, Double d4, String str3, Boolean bool2, String str4, String str5, Boolean bool3, CustomEndpoints customEndpoints, Map map, ConfigurationForTelemetry configurationForTelemetry, Boolean bool4, Boolean bool5, String str6, Pair pair, String str7, Map map2, Boolean bool6, Boolean bool7, Boolean bool8, String str8, Double d5) {
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        this.clientToken = clientToken;
        this.env = env;
        this.applicationId = applicationId;
        this.nativeCrashReportEnabled = bool;
        this.nativeLongTaskThresholdMs = d;
        this.longTaskThresholdMs = d2;
        this.sampleRate = d3;
        this.site = str;
        this.trackingConsent = str2;
        this.telemetrySampleRate = d4;
        this.vitalsUpdateFrequency = str3;
        this.trackFrustrations = bool2;
        this.uploadFrequency = str4;
        this.batchSize = str5;
        this.trackBackgroundEvents = bool3;
        this.customEndpoints = customEndpoints;
        this.additionalConfig = map;
        this.configurationForTelemetry = configurationForTelemetry;
        this.nativeViewTracking = bool4;
        this.nativeInteractionTracking = bool5;
        this.verbosity = str6;
        this.proxyConfig = pair;
        this.serviceName = str7;
        this.firstPartyHosts = map2;
        this.bundleLogsWithRum = bool6;
        this.bundleLogsWithTraces = bool7;
        this.trackNonFatalAnrs = bool8;
        this.batchProcessingLevel = str8;
        this.initialResourceThreshold = d5;
    }

    public final String getClientToken() {
        return this.clientToken;
    }

    public final String getEnv() {
        return this.env;
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final Boolean getNativeCrashReportEnabled() {
        return this.nativeCrashReportEnabled;
    }

    public final Double getNativeLongTaskThresholdMs() {
        return this.nativeLongTaskThresholdMs;
    }

    public final Double getLongTaskThresholdMs() {
        return this.longTaskThresholdMs;
    }

    public final Double getSampleRate() {
        return this.sampleRate;
    }

    public final String getSite() {
        return this.site;
    }

    public final String getTrackingConsent() {
        return this.trackingConsent;
    }

    public final Double getTelemetrySampleRate() {
        return this.telemetrySampleRate;
    }

    public final String getVitalsUpdateFrequency() {
        return this.vitalsUpdateFrequency;
    }

    public final Boolean getTrackFrustrations() {
        return this.trackFrustrations;
    }

    public final String getUploadFrequency() {
        return this.uploadFrequency;
    }

    public final String getBatchSize() {
        return this.batchSize;
    }

    public final Boolean getTrackBackgroundEvents() {
        return this.trackBackgroundEvents;
    }

    public final CustomEndpoints getCustomEndpoints() {
        return this.customEndpoints;
    }

    public final Map getAdditionalConfig() {
        return this.additionalConfig;
    }

    public final ConfigurationForTelemetry getConfigurationForTelemetry() {
        return this.configurationForTelemetry;
    }

    public final Boolean getNativeViewTracking() {
        return this.nativeViewTracking;
    }

    public final Boolean getNativeInteractionTracking() {
        return this.nativeInteractionTracking;
    }

    public final String getVerbosity() {
        return this.verbosity;
    }

    public final Pair getProxyConfig() {
        return this.proxyConfig;
    }

    public final String getServiceName() {
        return this.serviceName;
    }

    public final Map getFirstPartyHosts() {
        return this.firstPartyHosts;
    }

    public final Boolean getBundleLogsWithRum() {
        return this.bundleLogsWithRum;
    }

    public final Boolean getBundleLogsWithTraces() {
        return this.bundleLogsWithTraces;
    }

    public final Boolean getTrackNonFatalAnrs() {
        return this.trackNonFatalAnrs;
    }

    public final String getBatchProcessingLevel() {
        return this.batchProcessingLevel;
    }

    public final Double getInitialResourceThreshold() {
        return this.initialResourceThreshold;
    }
}
