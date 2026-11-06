package com.datadog.android.telemetry.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TelemetryEventId {
    private final String kind;
    private final String message;
    private final TelemetryType type;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TelemetryEventId)) {
            return false;
        }
        TelemetryEventId telemetryEventId = (TelemetryEventId) obj;
        return this.type == telemetryEventId.type && Intrinsics.areEqual(this.message, telemetryEventId.message) && Intrinsics.areEqual(this.kind, telemetryEventId.kind);
    }

    public int hashCode() {
        int iHashCode = ((this.type.hashCode() * 31) + this.message.hashCode()) * 31;
        String str = this.kind;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "TelemetryEventId(type=" + this.type + ", message=" + this.message + ", kind=" + this.kind + ")";
    }

    public TelemetryEventId(TelemetryType type, String message, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        this.type = type;
        this.message = message;
        this.kind = str;
    }
}
