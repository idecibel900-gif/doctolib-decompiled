package com.datadog.android.core.internal.privacy;

import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.privacy.TrackingConsentProviderCallback;

/* JADX INFO: loaded from: classes3.dex */
public interface ConsentProvider {
    TrackingConsent getConsent();

    void registerCallback(TrackingConsentProviderCallback trackingConsentProviderCallback);

    void setConsent(TrackingConsent trackingConsent);

    void unregisterAllCallbacks();

    void unregisterCallback(TrackingConsentProviderCallback trackingConsentProviderCallback);
}
