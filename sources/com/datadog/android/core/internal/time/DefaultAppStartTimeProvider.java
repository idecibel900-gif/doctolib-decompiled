package com.datadog.android.core.internal.time;

import android.os.Process;
import android.os.SystemClock;
import com.datadog.android.core.internal.DatadogCore;
import com.datadog.android.core.internal.system.BuildSdkVersionProvider;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultAppStartTimeProvider implements AppStartTimeProvider {
    private final Lazy appStartTimeNs$delegate;

    public DefaultAppStartTimeProvider(final BuildSdkVersionProvider buildSdkVersionProvider) {
        Intrinsics.checkNotNullParameter(buildSdkVersionProvider, "buildSdkVersionProvider");
        this.appStartTimeNs$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.datadog.android.core.internal.time.DefaultAppStartTimeProvider$appStartTimeNs$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                long startupTimeNs$dd_sdk_android_core_release;
                if (buildSdkVersionProvider.getVersion() >= 24) {
                    startupTimeNs$dd_sdk_android_core_release = System.nanoTime() - TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
                } else {
                    startupTimeNs$dd_sdk_android_core_release = DatadogCore.Companion.getStartupTimeNs$dd_sdk_android_core_release();
                }
                return Long.valueOf(startupTimeNs$dd_sdk_android_core_release);
            }
        });
    }

    public /* synthetic */ DefaultAppStartTimeProvider(BuildSdkVersionProvider buildSdkVersionProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? BuildSdkVersionProvider.Companion.getDEFAULT() : buildSdkVersionProvider);
    }

    @Override // com.datadog.android.core.internal.time.AppStartTimeProvider
    public long getAppStartTimeNs() {
        return ((Number) this.appStartTimeNs$delegate.getValue()).longValue();
    }
}
