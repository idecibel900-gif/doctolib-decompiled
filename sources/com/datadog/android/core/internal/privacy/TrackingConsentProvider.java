package com.datadog.android.core.internal.privacy;

import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.privacy.TrackingConsentProviderCallback;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TrackingConsentProvider implements ConsentProvider {
    private final LinkedList callbacks;
    private volatile TrackingConsent consent;

    public TrackingConsentProvider(TrackingConsent consent) {
        Intrinsics.checkNotNullParameter(consent, "consent");
        this.callbacks = new LinkedList();
        this.consent = consent;
    }

    @Override // com.datadog.android.core.internal.privacy.ConsentProvider
    public TrackingConsent getConsent() {
        return this.consent;
    }

    @Override // com.datadog.android.core.internal.privacy.ConsentProvider
    public synchronized void setConsent(TrackingConsent consent) {
        Intrinsics.checkNotNullParameter(consent, "consent");
        if (consent == this.consent) {
            return;
        }
        TrackingConsent trackingConsent = this.consent;
        this.consent = consent;
        notifyCallbacks(trackingConsent, consent);
    }

    @Override // com.datadog.android.core.internal.privacy.ConsentProvider
    public synchronized void registerCallback(TrackingConsentProviderCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callbacks.add(callback);
    }

    @Override // com.datadog.android.core.internal.privacy.ConsentProvider
    public synchronized void unregisterCallback(TrackingConsentProviderCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callbacks.remove(callback);
    }

    @Override // com.datadog.android.core.internal.privacy.ConsentProvider
    public synchronized void unregisterAllCallbacks() {
        this.callbacks.clear();
    }

    private final void notifyCallbacks(TrackingConsent trackingConsent, TrackingConsent trackingConsent2) {
        Iterator it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((TrackingConsentProviderCallback) it.next()).onConsentUpdated(trackingConsent, trackingConsent2);
        }
    }
}
