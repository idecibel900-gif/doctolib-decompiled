package com.datadog.android.rum.internal.domain.scope;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class RumViewInfo {
    private final Map attributes;
    private final boolean isActive;
    private final RumScopeKey key;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RumViewInfo)) {
            return false;
        }
        RumViewInfo rumViewInfo = (RumViewInfo) obj;
        return Intrinsics.areEqual(this.key, rumViewInfo.key) && Intrinsics.areEqual(this.attributes, rumViewInfo.attributes) && this.isActive == rumViewInfo.isActive;
    }

    public int hashCode() {
        return (((this.key.hashCode() * 31) + this.attributes.hashCode()) * 31) + Boolean.hashCode(this.isActive);
    }

    public String toString() {
        return "RumViewInfo(key=" + this.key + ", attributes=" + this.attributes + ", isActive=" + this.isActive + ")";
    }

    public RumViewInfo(RumScopeKey key, Map attributes, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.key = key;
        this.attributes = attributes;
        this.isActive = z;
    }

    public final RumScopeKey getKey() {
        return this.key;
    }

    public final Map getAttributes() {
        return this.attributes;
    }

    public final boolean isActive() {
        return this.isActive;
    }
}
