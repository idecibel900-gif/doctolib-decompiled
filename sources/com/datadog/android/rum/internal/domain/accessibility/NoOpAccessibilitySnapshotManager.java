package com.datadog.android.rum.internal.domain.accessibility;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpAccessibilitySnapshotManager implements AccessibilitySnapshotManager {
    @Override // com.datadog.android.rum.internal.domain.accessibility.AccessibilitySnapshotManager
    public AccessibilityInfo getIfChanged() {
        return null;
    }
}
