package com.datadog.android.trace.internal.handlers;

import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.opentracing.LogHandler;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AndroidSpanLogsHandler implements LogHandler {
    public static final Companion Companion = new Companion(null);
    private final FeatureSdkCore sdkCore;

    public AndroidSpanLogsHandler(FeatureSdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        this.sdkCore = sdkCore;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
