package com.datadog.android.api.context;

import com.datadog.android.DatadogSite;
import com.datadog.android.privacy.TrackingConsent;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DatadogContext {
    private final String appBuildId;
    private final String clientToken;
    private final DeviceInfo deviceInfo;
    private final String env;
    private final Map featuresContext;
    private final NetworkInfo networkInfo;
    private final ProcessInfo processInfo;
    private final String sdkVersion;
    private final String service;
    private final DatadogSite site;
    private final String source;
    private final TimeInfo time;
    private final TrackingConsent trackingConsent;
    private final UserInfo userInfo;
    private final String variant;
    private final String version;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DatadogContext)) {
            return false;
        }
        DatadogContext datadogContext = (DatadogContext) obj;
        return this.site == datadogContext.site && Intrinsics.areEqual(this.clientToken, datadogContext.clientToken) && Intrinsics.areEqual(this.service, datadogContext.service) && Intrinsics.areEqual(this.env, datadogContext.env) && Intrinsics.areEqual(this.version, datadogContext.version) && Intrinsics.areEqual(this.variant, datadogContext.variant) && Intrinsics.areEqual(this.source, datadogContext.source) && Intrinsics.areEqual(this.sdkVersion, datadogContext.sdkVersion) && Intrinsics.areEqual(this.time, datadogContext.time) && Intrinsics.areEqual(this.processInfo, datadogContext.processInfo) && Intrinsics.areEqual(this.networkInfo, datadogContext.networkInfo) && Intrinsics.areEqual(this.deviceInfo, datadogContext.deviceInfo) && Intrinsics.areEqual(this.userInfo, datadogContext.userInfo) && Intrinsics.areEqual((Object) null, (Object) null) && this.trackingConsent == datadogContext.trackingConsent && Intrinsics.areEqual(this.appBuildId, datadogContext.appBuildId) && Intrinsics.areEqual(this.featuresContext, datadogContext.featuresContext);
    }

    public final AccountInfo getAccountInfo() {
        return null;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((this.site.hashCode() * 31) + this.clientToken.hashCode()) * 31) + this.service.hashCode()) * 31) + this.env.hashCode()) * 31) + this.version.hashCode()) * 31) + this.variant.hashCode()) * 31) + this.source.hashCode()) * 31) + this.sdkVersion.hashCode()) * 31) + this.time.hashCode()) * 31) + this.processInfo.hashCode()) * 31) + this.networkInfo.hashCode()) * 31) + this.deviceInfo.hashCode()) * 31) + this.userInfo.hashCode()) * 961) + this.trackingConsent.hashCode()) * 31;
        String str = this.appBuildId;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.featuresContext.hashCode();
    }

    public String toString() {
        return "DatadogContext(site=" + this.site + ", clientToken=" + this.clientToken + ", service=" + this.service + ", env=" + this.env + ", version=" + this.version + ", variant=" + this.variant + ", source=" + this.source + ", sdkVersion=" + this.sdkVersion + ", time=" + this.time + ", processInfo=" + this.processInfo + ", networkInfo=" + this.networkInfo + ", deviceInfo=" + this.deviceInfo + ", userInfo=" + this.userInfo + ", accountInfo=" + ((Object) null) + ", trackingConsent=" + this.trackingConsent + ", appBuildId=" + this.appBuildId + ", featuresContext=" + this.featuresContext + ")";
    }

    public DatadogContext(DatadogSite site, String clientToken, String service, String env, String version, String variant, String source, String sdkVersion, TimeInfo time, ProcessInfo processInfo, NetworkInfo networkInfo, DeviceInfo deviceInfo, UserInfo userInfo, AccountInfo accountInfo, TrackingConsent trackingConsent, String str, Map featuresContext) {
        Intrinsics.checkNotNullParameter(site, "site");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(processInfo, "processInfo");
        Intrinsics.checkNotNullParameter(networkInfo, "networkInfo");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(trackingConsent, "trackingConsent");
        Intrinsics.checkNotNullParameter(featuresContext, "featuresContext");
        this.site = site;
        this.clientToken = clientToken;
        this.service = service;
        this.env = env;
        this.version = version;
        this.variant = variant;
        this.source = source;
        this.sdkVersion = sdkVersion;
        this.time = time;
        this.processInfo = processInfo;
        this.networkInfo = networkInfo;
        this.deviceInfo = deviceInfo;
        this.userInfo = userInfo;
        this.trackingConsent = trackingConsent;
        this.appBuildId = str;
        this.featuresContext = featuresContext;
    }

    public final DatadogSite getSite() {
        return this.site;
    }

    public final String getClientToken() {
        return this.clientToken;
    }

    public final String getService() {
        return this.service;
    }

    public final String getEnv() {
        return this.env;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getVariant() {
        return this.variant;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final TimeInfo getTime() {
        return this.time;
    }

    public final ProcessInfo getProcessInfo() {
        return this.processInfo;
    }

    public final NetworkInfo getNetworkInfo() {
        return this.networkInfo;
    }

    public final DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    public final String getAppBuildId() {
        return this.appBuildId;
    }

    public final Map getFeaturesContext() {
        return this.featuresContext;
    }
}
