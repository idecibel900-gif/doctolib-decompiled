package com.datadog.android.core.internal.system;

import com.datadog.android.api.context.DeviceType;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface AndroidInfoProvider {
    String getArchitecture();

    String getCurrentLocale();

    String getDeviceBrand();

    String getDeviceBuildId();

    String getDeviceModel();

    String getDeviceName();

    DeviceType getDeviceType();

    List getLocales();

    Integer getNumberOfDisplays();

    String getOsMajorVersion();

    String getOsName();

    String getOsVersion();

    String getTimeZone();
}
