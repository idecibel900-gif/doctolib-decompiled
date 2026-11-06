package com.datadog.reactnative;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ConfigurationForTelemetry {
    private final String initializationType;
    private final String reactNativeVersion;
    private final String reactVersion;
    private final Boolean trackErrors;
    private final Boolean trackInteractions;
    private final Boolean trackNetworkRequests;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigurationForTelemetry)) {
            return false;
        }
        ConfigurationForTelemetry configurationForTelemetry = (ConfigurationForTelemetry) obj;
        return Intrinsics.areEqual(this.initializationType, configurationForTelemetry.initializationType) && Intrinsics.areEqual(this.trackErrors, configurationForTelemetry.trackErrors) && Intrinsics.areEqual(this.trackInteractions, configurationForTelemetry.trackInteractions) && Intrinsics.areEqual(this.trackNetworkRequests, configurationForTelemetry.trackNetworkRequests) && Intrinsics.areEqual(this.reactVersion, configurationForTelemetry.reactVersion) && Intrinsics.areEqual(this.reactNativeVersion, configurationForTelemetry.reactNativeVersion);
    }

    public int hashCode() {
        String str = this.initializationType;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.trackErrors;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.trackInteractions;
        int iHashCode3 = (iHashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.trackNetworkRequests;
        int iHashCode4 = (iHashCode3 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str2 = this.reactVersion;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.reactNativeVersion;
        return iHashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ConfigurationForTelemetry(initializationType=" + this.initializationType + ", trackErrors=" + this.trackErrors + ", trackInteractions=" + this.trackInteractions + ", trackNetworkRequests=" + this.trackNetworkRequests + ", reactVersion=" + this.reactVersion + ", reactNativeVersion=" + this.reactNativeVersion + ")";
    }

    public ConfigurationForTelemetry(String str, Boolean bool, Boolean bool2, Boolean bool3, String str2, String str3) {
        this.initializationType = str;
        this.trackErrors = bool;
        this.trackInteractions = bool2;
        this.trackNetworkRequests = bool3;
        this.reactVersion = str2;
        this.reactNativeVersion = str3;
    }

    public final String getInitializationType() {
        return this.initializationType;
    }

    public final Boolean getTrackErrors() {
        return this.trackErrors;
    }

    public final Boolean getTrackInteractions() {
        return this.trackInteractions;
    }

    public final Boolean getTrackNetworkRequests() {
        return this.trackNetworkRequests;
    }

    public final String getReactVersion() {
        return this.reactVersion;
    }

    public final String getReactNativeVersion() {
        return this.reactNativeVersion;
    }
}
