package com.datadog.android.core.internal.privacy;

import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.privacy.TrackingConsentProviderCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpConsentProvider implements ConsentProvider {
    @Override // com.datadog.android.core.internal.privacy.ConsentProvider
    public void registerCallback(TrackingConsentProviderCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.datadog.android.core.internal.privacy.ConsentProvider
    public void setConsent(TrackingConsent consent) {
        Intrinsics.checkNotNullParameter(consent, "consent");
    }

    @Override // com.datadog.android.core.internal.privacy.ConsentProvider
    public void unregisterAllCallbacks() {
    }

    @Override // com.datadog.android.core.internal.privacy.ConsentProvider
    public void unregisterCallback(TrackingConsentProviderCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.datadog.android.core.internal.privacy.ConsentProvider
    public TrackingConsent getConsent() {
        return TrackingConsent.GRANTED;
    }
}
