package com.datadog.android.telemetry.internal;

import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TelemetryEventIdKt {
    public static final TelemetryEventId getIdentity(InternalTelemetryEvent internalTelemetryEvent) {
        Intrinsics.checkNotNullParameter(internalTelemetryEvent, "<this>");
        if (!(internalTelemetryEvent instanceof InternalTelemetryEvent.Log.Error)) {
            return internalTelemetryEvent instanceof InternalTelemetryEvent.Log.Debug ? new TelemetryEventId(type(internalTelemetryEvent), ((InternalTelemetryEvent.Log.Debug) internalTelemetryEvent).getMessage(), null) : new TelemetryEventId(type(internalTelemetryEvent), "", null);
        }
        TelemetryType telemetryTypeType = type(internalTelemetryEvent);
        InternalTelemetryEvent.Log.Error error = (InternalTelemetryEvent.Log.Error) internalTelemetryEvent;
        return new TelemetryEventId(telemetryTypeType, error.getMessage(), error.resolveKind());
    }

    public static final TelemetryType type(InternalTelemetryEvent internalTelemetryEvent) {
        Intrinsics.checkNotNullParameter(internalTelemetryEvent, "<this>");
        if (internalTelemetryEvent instanceof InternalTelemetryEvent.Log.Debug) {
            return TelemetryType.DEBUG;
        }
        if (internalTelemetryEvent instanceof InternalTelemetryEvent.Log.Error) {
            return TelemetryType.ERROR;
        }
        if (internalTelemetryEvent instanceof InternalTelemetryEvent.Configuration) {
            return TelemetryType.CONFIGURATION;
        }
        if (internalTelemetryEvent instanceof InternalTelemetryEvent.Metric) {
            return TelemetryType.METRIC;
        }
        if (internalTelemetryEvent instanceof InternalTelemetryEvent.ApiUsage) {
            return TelemetryType.API_USAGE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
