package com.revenuecat.purchases.models;

import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/models/StoreReplacementModeMapping;", "", "playBillingClientMode", "", "legacyPlayBackendName", "", "galaxyBackendName", "googleReplacementMode", "Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "(ILjava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/GoogleReplacementMode;)V", "getGalaxyBackendName", "()Ljava/lang/String;", "getGoogleReplacementMode", "()Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "getLegacyPlayBackendName", "getPlayBillingClientMode", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final /* data */ class StoreReplacementModeMapping {
    private final String galaxyBackendName;
    private final GoogleReplacementMode googleReplacementMode;
    private final String legacyPlayBackendName;
    private final int playBillingClientMode;

    public static /* synthetic */ StoreReplacementModeMapping copy$default(StoreReplacementModeMapping storeReplacementModeMapping, int i, String str, String str2, GoogleReplacementMode googleReplacementMode, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = storeReplacementModeMapping.playBillingClientMode;
        }
        if ((i2 & 2) != 0) {
            str = storeReplacementModeMapping.legacyPlayBackendName;
        }
        if ((i2 & 4) != 0) {
            str2 = storeReplacementModeMapping.galaxyBackendName;
        }
        if ((i2 & 8) != 0) {
            googleReplacementMode = storeReplacementModeMapping.googleReplacementMode;
        }
        return storeReplacementModeMapping.copy(i, str, str2, googleReplacementMode);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPlayBillingClientMode() {
        return this.playBillingClientMode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLegacyPlayBackendName() {
        return this.legacyPlayBackendName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGalaxyBackendName() {
        return this.galaxyBackendName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final GoogleReplacementMode getGoogleReplacementMode() {
        return this.googleReplacementMode;
    }

    public final StoreReplacementModeMapping copy(int playBillingClientMode, String legacyPlayBackendName, String galaxyBackendName, GoogleReplacementMode googleReplacementMode) {
        Intrinsics.checkNotNullParameter(legacyPlayBackendName, "legacyPlayBackendName");
        Intrinsics.checkNotNullParameter(googleReplacementMode, "googleReplacementMode");
        return new StoreReplacementModeMapping(playBillingClientMode, legacyPlayBackendName, galaxyBackendName, googleReplacementMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreReplacementModeMapping)) {
            return false;
        }
        StoreReplacementModeMapping storeReplacementModeMapping = (StoreReplacementModeMapping) other;
        return this.playBillingClientMode == storeReplacementModeMapping.playBillingClientMode && Intrinsics.areEqual(this.legacyPlayBackendName, storeReplacementModeMapping.legacyPlayBackendName) && Intrinsics.areEqual(this.galaxyBackendName, storeReplacementModeMapping.galaxyBackendName) && this.googleReplacementMode == storeReplacementModeMapping.googleReplacementMode;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.playBillingClientMode) * 31) + this.legacyPlayBackendName.hashCode()) * 31;
        String str = this.galaxyBackendName;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.googleReplacementMode.hashCode();
    }

    public String toString() {
        return "StoreReplacementModeMapping(playBillingClientMode=" + this.playBillingClientMode + ", legacyPlayBackendName=" + this.legacyPlayBackendName + ", galaxyBackendName=" + this.galaxyBackendName + ", googleReplacementMode=" + this.googleReplacementMode + ')';
    }

    public StoreReplacementModeMapping(int i, String legacyPlayBackendName, String str, GoogleReplacementMode googleReplacementMode) {
        Intrinsics.checkNotNullParameter(legacyPlayBackendName, "legacyPlayBackendName");
        Intrinsics.checkNotNullParameter(googleReplacementMode, "googleReplacementMode");
        this.playBillingClientMode = i;
        this.legacyPlayBackendName = legacyPlayBackendName;
        this.galaxyBackendName = str;
        this.googleReplacementMode = googleReplacementMode;
    }

    public final int getPlayBillingClientMode() {
        return this.playBillingClientMode;
    }

    public final String getLegacyPlayBackendName() {
        return this.legacyPlayBackendName;
    }

    public final String getGalaxyBackendName() {
        return this.galaxyBackendName;
    }

    public final GoogleReplacementMode getGoogleReplacementMode() {
        return this.googleReplacementMode;
    }
}
