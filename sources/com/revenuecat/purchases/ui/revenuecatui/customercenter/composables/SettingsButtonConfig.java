package com.revenuecat.purchases.ui.revenuecatui.customercenter.composables;

import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/composables/SettingsButtonConfig;", "", "enabled", "", "loading", "(ZZ)V", "getEnabled", "()Z", "getLoading", "component1", "component2", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SettingsButtonConfig {
    public static final int $stable = 0;
    private final boolean enabled;
    private final boolean loading;

    /* JADX WARN: Illegal instructions before constructor call */
    public SettingsButtonConfig() {
        boolean z = false;
        this(z, z, 3, null);
    }

    public static /* synthetic */ SettingsButtonConfig copy$default(SettingsButtonConfig settingsButtonConfig, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = settingsButtonConfig.enabled;
        }
        if ((i & 2) != 0) {
            z2 = settingsButtonConfig.loading;
        }
        return settingsButtonConfig.copy(z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getLoading() {
        return this.loading;
    }

    public final SettingsButtonConfig copy(boolean enabled, boolean loading) {
        return new SettingsButtonConfig(enabled, loading);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsButtonConfig)) {
            return false;
        }
        SettingsButtonConfig settingsButtonConfig = (SettingsButtonConfig) other;
        return this.enabled == settingsButtonConfig.enabled && this.loading == settingsButtonConfig.loading;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.enabled) * 31) + Boolean.hashCode(this.loading);
    }

    public String toString() {
        return "SettingsButtonConfig(enabled=" + this.enabled + ", loading=" + this.loading + ')';
    }

    public SettingsButtonConfig(boolean z, boolean z2) {
        this.enabled = z;
        this.loading = z2;
    }

    public /* synthetic */ SettingsButtonConfig(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? false : z2);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getLoading() {
        return this.loading;
    }
}
