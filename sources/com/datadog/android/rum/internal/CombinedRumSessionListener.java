package com.datadog.android.rum.internal;

import com.datadog.android.rum.RumSessionListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CombinedRumSessionListener implements RumSessionListener {
    private final RumSessionListener[] listeners;

    public CombinedRumSessionListener(RumSessionListener... listeners) {
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        this.listeners = listeners;
    }

    @Override // com.datadog.android.rum.RumSessionListener
    public void onSessionStarted(String sessionId, boolean z) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        for (RumSessionListener rumSessionListener : this.listeners) {
            rumSessionListener.onSessionStarted(sessionId, z);
        }
    }
}
