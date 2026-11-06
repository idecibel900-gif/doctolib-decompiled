package com.datadog.android.api.context;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DeviceInfo {
    private final String architecture;
    private final String deviceBrand;
    private final String deviceBuildId;
    private final String deviceModel;
    private final String deviceName;
    private final DeviceType deviceType;
    private final LocaleInfo localeInfo;
    private final Integer numberOfDisplays;
    private final String osMajorVersion;
    private final String osName;
    private final String osVersion;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        return Intrinsics.areEqual(this.deviceName, deviceInfo.deviceName) && Intrinsics.areEqual(this.deviceBrand, deviceInfo.deviceBrand) && Intrinsics.areEqual(this.deviceModel, deviceInfo.deviceModel) && this.deviceType == deviceInfo.deviceType && Intrinsics.areEqual(this.deviceBuildId, deviceInfo.deviceBuildId) && Intrinsics.areEqual(this.osName, deviceInfo.osName) && Intrinsics.areEqual(this.osMajorVersion, deviceInfo.osMajorVersion) && Intrinsics.areEqual(this.osVersion, deviceInfo.osVersion) && Intrinsics.areEqual(this.architecture, deviceInfo.architecture) && Intrinsics.areEqual(this.numberOfDisplays, deviceInfo.numberOfDisplays) && Intrinsics.areEqual(this.localeInfo, deviceInfo.localeInfo);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((this.deviceName.hashCode() * 31) + this.deviceBrand.hashCode()) * 31) + this.deviceModel.hashCode()) * 31) + this.deviceType.hashCode()) * 31) + this.deviceBuildId.hashCode()) * 31) + this.osName.hashCode()) * 31) + this.osMajorVersion.hashCode()) * 31) + this.osVersion.hashCode()) * 31) + this.architecture.hashCode()) * 31;
        Integer num = this.numberOfDisplays;
        return ((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.localeInfo.hashCode();
    }

    public String toString() {
        return "DeviceInfo(deviceName=" + this.deviceName + ", deviceBrand=" + this.deviceBrand + ", deviceModel=" + this.deviceModel + ", deviceType=" + this.deviceType + ", deviceBuildId=" + this.deviceBuildId + ", osName=" + this.osName + ", osMajorVersion=" + this.osMajorVersion + ", osVersion=" + this.osVersion + ", architecture=" + this.architecture + ", numberOfDisplays=" + this.numberOfDisplays + ", localeInfo=" + this.localeInfo + ")";
    }

    public DeviceInfo(String deviceName, String deviceBrand, String deviceModel, DeviceType deviceType, String deviceBuildId, String osName, String osMajorVersion, String osVersion, String architecture, Integer num, LocaleInfo localeInfo) {
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(deviceBrand, "deviceBrand");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(deviceBuildId, "deviceBuildId");
        Intrinsics.checkNotNullParameter(osName, "osName");
        Intrinsics.checkNotNullParameter(osMajorVersion, "osMajorVersion");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(architecture, "architecture");
        Intrinsics.checkNotNullParameter(localeInfo, "localeInfo");
        this.deviceName = deviceName;
        this.deviceBrand = deviceBrand;
        this.deviceModel = deviceModel;
        this.deviceType = deviceType;
        this.deviceBuildId = deviceBuildId;
        this.osName = osName;
        this.osMajorVersion = osMajorVersion;
        this.osVersion = osVersion;
        this.architecture = architecture;
        this.numberOfDisplays = num;
        this.localeInfo = localeInfo;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getDeviceBrand() {
        return this.deviceBrand;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final DeviceType getDeviceType() {
        return this.deviceType;
    }

    public final String getDeviceBuildId() {
        return this.deviceBuildId;
    }

    public final String getOsName() {
        return this.osName;
    }

    public final String getOsMajorVersion() {
        return this.osMajorVersion;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getArchitecture() {
        return this.architecture;
    }

    public final Integer getNumberOfDisplays() {
        return this.numberOfDisplays;
    }

    public final LocaleInfo getLocaleInfo() {
        return this.localeInfo;
    }
}
