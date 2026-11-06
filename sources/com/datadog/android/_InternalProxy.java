package com.datadog.android;

import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class _InternalProxy {
    public static final Companion Companion = new Companion(null);
    private final _TelemetryProxy _telemetry;
    private final SdkCore sdkCore;

    public _InternalProxy(SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        this.sdkCore = sdkCore;
        this._telemetry = new _TelemetryProxy(sdkCore);
    }

    public static final class _TelemetryProxy {
        private final SdkCore sdkCore;

        public _TelemetryProxy(SdkCore sdkCore) {
            Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
            this.sdkCore = sdkCore;
        }

        private final FeatureScope getRumFeature() {
            SdkCore sdkCore = this.sdkCore;
            FeatureSdkCore featureSdkCore = sdkCore instanceof FeatureSdkCore ? (FeatureSdkCore) sdkCore : null;
            if (featureSdkCore != null) {
                return featureSdkCore.getFeature("rum");
            }
            return null;
        }

        public final void debug(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            InternalTelemetryEvent.Log.Debug debug = new InternalTelemetryEvent.Log.Debug(message, null);
            FeatureScope rumFeature = getRumFeature();
            if (rumFeature != null) {
                rumFeature.sendEvent(debug);
            }
        }

        public final void error(String message, Throwable th) {
            Intrinsics.checkNotNullParameter(message, "message");
            InternalTelemetryEvent.Log.Error error = new InternalTelemetryEvent.Log.Error(message, null, th, null, null, 26, null);
            FeatureScope rumFeature = getRumFeature();
            if (rumFeature != null) {
                rumFeature.sendEvent(error);
            }
        }

        public final void error(String message, String str, String str2) {
            Intrinsics.checkNotNullParameter(message, "message");
            InternalTelemetryEvent.Log.Error error = new InternalTelemetryEvent.Log.Error(message, null, null, str, str2, 6, null);
            FeatureScope rumFeature = getRumFeature();
            if (rumFeature != null) {
                rumFeature.sendEvent(error);
            }
        }
    }

    public final _TelemetryProxy get_telemetry() {
        return this._telemetry;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
