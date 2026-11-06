package com.revenuecat.purchases.common;

import com.opentok.android.PublisherKit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/common/BackgroundAwareCallbackCacheKey;", "", "cacheKey", "", "", "appInBackground", "", "(Ljava/util/List;Z)V", "getAppInBackground", "()Z", "getCacheKey", "()Ljava/util/List;", "component1", "component2", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BackgroundAwareCallbackCacheKey {
    private final boolean appInBackground;
    private final List<String> cacheKey;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BackgroundAwareCallbackCacheKey copy$default(BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = backgroundAwareCallbackCacheKey.cacheKey;
        }
        if ((i & 2) != 0) {
            z = backgroundAwareCallbackCacheKey.appInBackground;
        }
        return backgroundAwareCallbackCacheKey.copy(list, z);
    }

    public final List<String> component1() {
        return this.cacheKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getAppInBackground() {
        return this.appInBackground;
    }

    public final BackgroundAwareCallbackCacheKey copy(List<String> cacheKey, boolean appInBackground) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        return new BackgroundAwareCallbackCacheKey(cacheKey, appInBackground);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BackgroundAwareCallbackCacheKey)) {
            return false;
        }
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey = (BackgroundAwareCallbackCacheKey) other;
        return Intrinsics.areEqual(this.cacheKey, backgroundAwareCallbackCacheKey.cacheKey) && this.appInBackground == backgroundAwareCallbackCacheKey.appInBackground;
    }

    public int hashCode() {
        return (this.cacheKey.hashCode() * 31) + Boolean.hashCode(this.appInBackground);
    }

    public String toString() {
        return "BackgroundAwareCallbackCacheKey(cacheKey=" + this.cacheKey + ", appInBackground=" + this.appInBackground + ')';
    }

    public BackgroundAwareCallbackCacheKey(List<String> cacheKey, boolean z) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        this.cacheKey = cacheKey;
        this.appInBackground = z;
    }

    public final List<String> getCacheKey() {
        return this.cacheKey;
    }

    public final boolean getAppInBackground() {
        return this.appInBackground;
    }
}
