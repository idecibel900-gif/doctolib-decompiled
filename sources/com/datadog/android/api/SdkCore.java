package com.datadog.android.api;

import com.datadog.android.api.context.TimeInfo;
import com.datadog.android.privacy.TrackingConsent;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface SdkCore {
    void addUserProperties(Map map);

    void clearAllData();

    String getName();

    String getService();

    TimeInfo getTime();

    void setTrackingConsent(TrackingConsent trackingConsent);

    void setUserInfo(String str, String str2, String str3, Map map);
}
