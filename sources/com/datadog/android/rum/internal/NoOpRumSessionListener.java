package com.datadog.android.rum.internal;

import com.datadog.android.rum.RumSessionListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpRumSessionListener implements RumSessionListener {
    public int hashCode() {
        return 0;
    }

    @Override // com.datadog.android.rum.RumSessionListener
    public void onSessionStarted(String sessionId, boolean z) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof NoOpRumSessionListener);
    }
}
