package com.datadog.reactnative;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CustomEndpoints {
    private final String logs;
    private final String rum;
    private final String trace;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomEndpoints)) {
            return false;
        }
        CustomEndpoints customEndpoints = (CustomEndpoints) obj;
        return Intrinsics.areEqual(this.rum, customEndpoints.rum) && Intrinsics.areEqual(this.logs, customEndpoints.logs) && Intrinsics.areEqual(this.trace, customEndpoints.trace);
    }

    public int hashCode() {
        String str = this.rum;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.logs;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.trace;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "CustomEndpoints(rum=" + this.rum + ", logs=" + this.logs + ", trace=" + this.trace + ")";
    }

    public CustomEndpoints(String str, String str2, String str3) {
        this.rum = str;
        this.logs = str2;
        this.trace = str3;
    }

    public final String getRum() {
        return this.rum;
    }

    public final String getLogs() {
        return this.logs;
    }

    public final String getTrace() {
        return this.trace;
    }
}
