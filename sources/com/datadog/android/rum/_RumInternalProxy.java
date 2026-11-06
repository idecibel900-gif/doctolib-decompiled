package com.datadog.android.rum;

import android.content.Intent;
import android.os.Bundle;
import com.datadog.android.event.EventMapper;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class _RumInternalProxy {
    public static final Companion Companion = new Companion(null);
    private volatile boolean handledSyntheticsAttribute;
    private final AdvancedRumMonitor rumMonitor;

    public _RumInternalProxy(AdvancedRumMonitor rumMonitor) {
        Intrinsics.checkNotNullParameter(rumMonitor, "rumMonitor");
        this.rumMonitor = rumMonitor;
    }

    public final void addLongTask(long j, String target) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.rumMonitor.addLongTask(j, target);
    }

    public final void updatePerformanceMetric(RumPerformanceMetric metric, double d) {
        Intrinsics.checkNotNullParameter(metric, "metric");
        this.rumMonitor.updatePerformanceMetric(metric, d);
    }

    public final void setSyntheticsAttribute(String str, String str2) {
        if (this.handledSyntheticsAttribute) {
            return;
        }
        this.handledSyntheticsAttribute = true;
        if (str == null || StringsKt.isBlank(str) || str2 == null || StringsKt.isBlank(str2)) {
            return;
        }
        this.rumMonitor.setSyntheticsAttribute(str, str2);
    }

    public final void setSyntheticsAttributeFromIntent$dd_sdk_android_rum_release(Intent intent) {
        Bundle extras;
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            extras = intent.getExtras();
        } catch (Exception unused) {
            extras = null;
        }
        setSyntheticsAttribute(extras != null ? extras.getString("_dd.synthetics.test_id") : null, extras != null ? extras.getString("_dd.synthetics.result_id") : null);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RumConfiguration.Builder setTelemetryConfigurationEventMapper(RumConfiguration.Builder builder, EventMapper eventMapper) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
            return builder.setTelemetryConfigurationEventMapper$dd_sdk_android_rum_release(eventMapper);
        }
    }
}
