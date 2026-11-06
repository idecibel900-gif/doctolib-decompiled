package com.datadog.android.rum.internal.instrumentation;

import android.content.Context;
import android.os.Looper;
import android.util.Printer;
import com.datadog.android.api.SdkCore;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import com.datadog.android.rum.tracking.TrackingStrategy;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class MainLooperLongTaskStrategy implements Printer, TrackingStrategy {
    public static final Companion Companion = new Companion(null);
    private SdkCore sdkCore;
    private long startUptimeNs;
    private String target = "";
    private final long thresholdMs;
    private final long thresholdNS;

    public MainLooperLongTaskStrategy(long j) {
        this.thresholdMs = j;
        this.thresholdNS = TimeUnit.MILLISECONDS.toNanos(j);
    }

    @Override // com.datadog.android.rum.tracking.TrackingStrategy
    public void register(SdkCore sdkCore, Context context) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(context, "context");
        this.sdkCore = sdkCore;
        Looper.getMainLooper().setMessageLogging(this);
    }

    @Override // com.datadog.android.rum.tracking.TrackingStrategy
    public void unregister(Context context) {
        Looper.getMainLooper().setMessageLogging(null);
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (str != null) {
            detectLongTask(str);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(MainLooperLongTaskStrategy.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.datadog.android.rum.internal.instrumentation.MainLooperLongTaskStrategy");
        return this.thresholdMs == ((MainLooperLongTaskStrategy) obj).thresholdMs;
    }

    public int hashCode() {
        return Long.hashCode(this.thresholdMs);
    }

    public String toString() {
        return "MainLooperLongTaskStrategy(" + this.thresholdMs + ")";
    }

    private final void detectLongTask(String str) {
        SdkCore sdkCore;
        long jNanoTime = System.nanoTime();
        if (StringsKt.startsWith$default(str, ">>>>> Dispatching to ", false, 2, (Object) null)) {
            String strSubstring = str.substring(21);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            this.target = strSubstring;
            this.startUptimeNs = jNanoTime;
            return;
        }
        if (StringsKt.startsWith$default(str, "<<<<< Finished to ", false, 2, (Object) null)) {
            long j = jNanoTime - this.startUptimeNs;
            if (j <= this.thresholdNS || (sdkCore = this.sdkCore) == null) {
                return;
            }
            if (sdkCore == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sdkCore");
                sdkCore = null;
            }
            RumMonitor rumMonitor = GlobalRumMonitor.get(sdkCore);
            AdvancedRumMonitor advancedRumMonitor = rumMonitor instanceof AdvancedRumMonitor ? (AdvancedRumMonitor) rumMonitor : null;
            if (advancedRumMonitor != null) {
                advancedRumMonitor.addLongTask(j, this.target);
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
