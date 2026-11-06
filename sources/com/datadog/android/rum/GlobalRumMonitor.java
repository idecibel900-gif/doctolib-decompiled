package com.datadog.android.rum;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.rum.internal.monitor.NoOpAdvancedRumMonitor;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class GlobalRumMonitor {
    public static final GlobalRumMonitor INSTANCE = new GlobalRumMonitor();
    private static final Map registeredMonitors = new LinkedHashMap();

    private GlobalRumMonitor() {
    }

    public static final RumMonitor get(final SdkCore sdkCore) {
        RumMonitor noOpAdvancedRumMonitor;
        InternalLogger internalLogger;
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Map map = registeredMonitors;
        synchronized (map) {
            try {
                noOpAdvancedRumMonitor = (RumMonitor) map.get(sdkCore);
                if (noOpAdvancedRumMonitor == null) {
                    FeatureSdkCore featureSdkCore = sdkCore instanceof FeatureSdkCore ? (FeatureSdkCore) sdkCore : null;
                    if (featureSdkCore != null && (internalLogger = featureSdkCore.getInternalLogger()) != null) {
                        InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.rum.GlobalRumMonitor$get$1$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                String str = String.format(Locale.US, "No RumMonitor for the SDK instance with name %s found, returning no-op implementation.", Arrays.copyOf(new Object[]{sdkCore.getName()}, 1));
                                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                                return str;
                            }
                        }, (Throwable) null, false, (Map) null, 56, (Object) null);
                    }
                    noOpAdvancedRumMonitor = new NoOpAdvancedRumMonitor();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return noOpAdvancedRumMonitor;
    }

    public final boolean registerIfAbsent$dd_sdk_android_rum_release(RumMonitor monitor, SdkCore sdkCore) {
        boolean z;
        Intrinsics.checkNotNullParameter(monitor, "monitor");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Map map = registeredMonitors;
        synchronized (map) {
            try {
                if (map.containsKey(sdkCore)) {
                    InternalLogger.DefaultImpls.log$default(((FeatureSdkCore) sdkCore).getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.rum.GlobalRumMonitor$registerIfAbsent$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "A RumMonitor has already been registered for this SDK instance";
                        }
                    }, (Throwable) null, false, (Map) null, 56, (Object) null);
                    z = false;
                } else {
                    map.put(sdkCore, monitor);
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public final void unregister$dd_sdk_android_rum_release(SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Map map = registeredMonitors;
        synchronized (map) {
        }
    }
}
