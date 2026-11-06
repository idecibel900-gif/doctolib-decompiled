package com.datadog.android.rum.tracking;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum._RumInternalProxy;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ActivityLifecycleTrackingStrategy implements Application.ActivityLifecycleCallbacks, TrackingStrategy {
    public static final Companion Companion = new Companion(null);
    protected FeatureSdkCore sdkCore;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    protected final FeatureSdkCore getSdkCore() {
        FeatureSdkCore featureSdkCore = this.sdkCore;
        if (featureSdkCore != null) {
            return featureSdkCore;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sdkCore");
        return null;
    }

    protected final void setSdkCore(FeatureSdkCore featureSdkCore) {
        Intrinsics.checkNotNullParameter(featureSdkCore, "<set-?>");
        this.sdkCore = featureSdkCore;
    }

    public final InternalLogger getInternalLogger$dd_sdk_android_rum_release() {
        if (this.sdkCore != null) {
            return getSdkCore().getInternalLogger();
        }
        return InternalLogger.Companion.getUNBOUND();
    }

    @Override // com.datadog.android.rum.tracking.TrackingStrategy
    public void register(SdkCore sdkCore, Context context) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof Application) {
            setSdkCore((FeatureSdkCore) sdkCore);
            ((Application) context).registerActivityLifecycleCallbacks(this);
        } else {
            InternalLogger.DefaultImpls.log$default(((FeatureSdkCore) sdkCore).getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy.register.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "In order to use the RUM automatic tracking feature you will have to use the Application context when initializing the SDK";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
    }

    @Override // com.datadog.android.rum.tracking.TrackingStrategy
    public void unregister(Context context) {
        if (context instanceof Application) {
            ((Application) context).unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        _RumInternalProxy _ruminternalproxy_getInternal;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.sdkCore == null || (_ruminternalproxy_getInternal = GlobalRumMonitor.get(getSdkCore())._getInternal()) == null) {
            return;
        }
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
        _ruminternalproxy_getInternal.setSyntheticsAttributeFromIntent$dd_sdk_android_rum_release(intent);
    }

    protected final Object withSdkCore(Function1 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.sdkCore != null) {
            return block.invoke(getSdkCore());
        }
        InternalLogger.DefaultImpls.log$default(InternalLogger.Companion.getUNBOUND(), InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy.withSdkCore.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "RUM feature is not initialized yet, you need to register it with a SDK instance by calling SdkCore#registerFeature method. Cannot provide SDK instance for view tracking.";
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return null;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
