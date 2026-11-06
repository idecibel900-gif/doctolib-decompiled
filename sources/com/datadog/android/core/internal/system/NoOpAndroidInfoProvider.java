package com.datadog.android.core.internal.system;

import com.datadog.android.api.context.DeviceType;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpAndroidInfoProvider implements AndroidInfoProvider {
    private final Integer numberOfDisplays;
    private final String deviceName = "";
    private final String deviceBrand = "";
    private final String deviceModel = "";
    private final DeviceType deviceType = DeviceType.MOBILE;
    private final String deviceBuildId = "";
    private final String osName = "";
    private final String osMajorVersion = "";
    private final String osVersion = "";
    private final String architecture = "";
    private final List locales = CollectionsKt.emptyList();
    private final String currentLocale = "";
    private final String timeZone = "";

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getDeviceName() {
        return this.deviceName;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getDeviceBrand() {
        return this.deviceBrand;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getDeviceModel() {
        return this.deviceModel;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public DeviceType getDeviceType() {
        return this.deviceType;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getDeviceBuildId() {
        return this.deviceBuildId;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getOsName() {
        return this.osName;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getOsMajorVersion() {
        return this.osMajorVersion;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getOsVersion() {
        return this.osVersion;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getArchitecture() {
        return this.architecture;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public Integer getNumberOfDisplays() {
        return this.numberOfDisplays;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public List getLocales() {
        return this.locales;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getCurrentLocale() {
        return this.currentLocale;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getTimeZone() {
        return this.timeZone;
    }
}
