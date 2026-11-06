package com.revenuecat.purchases.common;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/common/PlatformInfo;", "", "flavor", "", DiagnosticsEntry.VERSION_KEY, "(Ljava/lang/String;Ljava/lang/String;)V", "getFlavor", "()Ljava/lang/String;", "getVersion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlatformInfo {
    private final String flavor;
    private final String version;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlatformInfo)) {
            return false;
        }
        PlatformInfo platformInfo = (PlatformInfo) obj;
        return Intrinsics.areEqual(this.flavor, platformInfo.flavor) && Intrinsics.areEqual(this.version, platformInfo.version);
    }

    public int hashCode() {
        int iHashCode = this.flavor.hashCode() * 31;
        String str = this.version;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "PlatformInfo(flavor=" + this.flavor + ", version=" + this.version + ')';
    }

    public PlatformInfo(String flavor, String str) {
        Intrinsics.checkNotNullParameter(flavor, "flavor");
        this.flavor = flavor;
        this.version = str;
    }

    public final String getFlavor() {
        return this.flavor;
    }

    public final String getVersion() {
        return this.version;
    }
}
