package com.datadog.android;

import android.content.Context;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.core.internal.DatadogCore;
import com.datadog.android.core.internal.HashGenerator;
import com.datadog.android.core.internal.NoOpInternalSdkCore;
import com.datadog.android.core.internal.SdkCoreRegistry;
import com.datadog.android.core.internal.Sha256HashGenerator;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.internal.utils.ThrowableExtKt;
import com.datadog.android.privacy.TrackingConsent;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class Datadog {
    public static final Datadog INSTANCE = new Datadog();
    private static final SdkCoreRegistry registry = new SdkCoreRegistry(RuntimeUtilsKt.getUnboundInternalLogger());
    private static HashGenerator hashGenerator = new Sha256HashGenerator();
    private static int libraryVerbosity = Integer.MAX_VALUE;

    private Datadog() {
    }

    public static final SdkCore initialize(String str, Context context, Configuration configuration, TrackingConsent trackingConsent) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(trackingConsent, "trackingConsent");
        SdkCoreRegistry sdkCoreRegistry = registry;
        synchronized (sdkCoreRegistry) {
            SdkCore sdkCoreRegistry2 = sdkCoreRegistry.getInstance(str2);
            if (sdkCoreRegistry2 != null) {
                InternalLogger.DefaultImpls.log$default(RuntimeUtilsKt.getUnboundInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.Datadog$initialize$1$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "The Datadog library has already been initialized.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return sdkCoreRegistry2;
            }
            String strGenerate = hashGenerator.generate(str2 + "/" + configuration.getCoreConfig$dd_sdk_android_core_release().getSite().getSiteName$dd_sdk_android_core_release());
            if (strGenerate == null) {
                InternalLogger.DefaultImpls.log$default(RuntimeUtilsKt.getUnboundInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.Datadog$initialize$1$2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Cannot create SDK instance ID, stopping SDK initialization.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return null;
            }
            if (str2 == null) {
                str2 = "_dd.sdk_core.default";
            }
            String str3 = str2;
            DatadogCore datadogCore = new DatadogCore(context, strGenerate, str3, null, null, null, 56, null);
            datadogCore.initialize$dd_sdk_android_core_release(configuration);
            datadogCore.setTrackingConsent(trackingConsent);
            sdkCoreRegistry.register(str3, datadogCore);
            return datadogCore;
        }
    }

    public static final SdkCore initialize(Context context, Configuration configuration, TrackingConsent trackingConsent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(trackingConsent, "trackingConsent");
        return initialize(null, context, configuration, trackingConsent);
    }

    public static /* synthetic */ SdkCore getInstance$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return getInstance(str);
    }

    public static final SdkCore getInstance(final String str) {
        SdkCore sdkCoreRegistry;
        SdkCoreRegistry sdkCoreRegistry2 = registry;
        synchronized (sdkCoreRegistry2) {
            if (str == null) {
                str = "_dd.sdk_core.default";
            }
            try {
                sdkCoreRegistry = sdkCoreRegistry2.getInstance(str);
                if (sdkCoreRegistry == null) {
                    final Throwable thFillInStackTrace = new Throwable().fillInStackTrace();
                    InternalLogger.DefaultImpls.log$default(RuntimeUtilsKt.getUnboundInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.Datadog$getInstance$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            Locale locale = Locale.US;
                            String str2 = str;
                            Throwable stackCapture = thFillInStackTrace;
                            Intrinsics.checkNotNullExpressionValue(stackCapture, "stackCapture");
                            String str3 = String.format(locale, "SDK instance with name %s is not found, returning no-op implementation. Please make sure to call Datadog.initialize([instanceName]) before getting the instance. SDK instance was requested from:\n%s", Arrays.copyOf(new Object[]{str2, CollectionsKt.joinToString$default(CollectionsKt.drop(StringsKt.lines(ThrowableExtKt.loggableStackTrace(stackCapture)), 1), "\n", null, null, 0, null, null, 62, null)}, 2));
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            return str3;
                        }
                    }, (Throwable) null, false, (Map) null, 56, (Object) null);
                    sdkCoreRegistry = NoOpInternalSdkCore.INSTANCE;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sdkCoreRegistry;
    }

    public static /* synthetic */ boolean isInitialized$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return isInitialized(str);
    }

    public static final boolean isInitialized(String str) {
        boolean z;
        SdkCoreRegistry sdkCoreRegistry = registry;
        synchronized (sdkCoreRegistry) {
            z = sdkCoreRegistry.getInstance(str) != null;
        }
        return z;
    }

    public static final void setVerbosity(int i) {
        libraryVerbosity = i;
    }

    public static final int getVerbosity() {
        return libraryVerbosity;
    }

    public static /* synthetic */ void setTrackingConsent$default(TrackingConsent trackingConsent, SdkCore sdkCore, int i, Object obj) {
        if ((i & 2) != 0) {
            sdkCore = getInstance$default(null, 1, null);
        }
        setTrackingConsent(trackingConsent, sdkCore);
    }

    public static final void setTrackingConsent(TrackingConsent consent, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(consent, "consent");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        sdkCore.setTrackingConsent(consent);
    }

    public static /* synthetic */ void setUserInfo$default(String str, String str2, String str3, Map map, SdkCore sdkCore, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 16) != 0) {
            sdkCore = getInstance$default(null, 1, null);
        }
        setUserInfo(str, str2, str3, map, sdkCore);
    }

    public static final void setUserInfo(String id, String str, String str2, Map extraInfo, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        sdkCore.setUserInfo(id, str, str2, extraInfo);
    }

    public static /* synthetic */ void setUserInfoDeprecated$default(String str, String str2, String str3, Map map, SdkCore sdkCore, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 16) != 0) {
            sdkCore = getInstance$default(null, 1, null);
        }
        setUserInfoDeprecated(str, str2, str3, map, sdkCore);
    }

    public static final void setUserInfoDeprecated(String str, String str2, String str3, Map extraInfo, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        sdkCore.setUserInfo(str, str2, str3, extraInfo);
    }

    public static /* synthetic */ void addUserProperties$default(Map map, SdkCore sdkCore, int i, Object obj) {
        if ((i & 2) != 0) {
            sdkCore = getInstance$default(null, 1, null);
        }
        addUserProperties(map, sdkCore);
    }

    public static final void addUserProperties(Map extraInfo, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        sdkCore.addUserProperties(extraInfo);
    }

    public static final void clearAllData(SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        sdkCore.clearAllData();
    }

    public static /* synthetic */ _InternalProxy _internalProxy$default(Datadog datadog, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return datadog._internalProxy(str);
    }

    public final _InternalProxy _internalProxy(String str) {
        return new _InternalProxy(getInstance(str));
    }
}
