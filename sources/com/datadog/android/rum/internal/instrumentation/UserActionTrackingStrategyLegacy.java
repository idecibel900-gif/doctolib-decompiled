package com.datadog.android.rum.internal.instrumentation;

import android.app.Activity;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.rum.internal.instrumentation.gestures.GesturesTracker;
import com.datadog.android.rum.internal.tracking.UserActionTrackingStrategy;
import com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class UserActionTrackingStrategyLegacy extends ActivityLifecycleTrackingStrategy implements UserActionTrackingStrategy {
    private final GesturesTracker gesturesTracker;

    public final GesturesTracker getGesturesTracker$dd_sdk_android_rum_release() {
        return this.gesturesTracker;
    }

    public UserActionTrackingStrategyLegacy(GesturesTracker gesturesTracker) {
        Intrinsics.checkNotNullParameter(gesturesTracker, "gesturesTracker");
        this.gesturesTracker = gesturesTracker;
    }

    @Override // com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityResumed(activity);
        withSdkCore(new Function1() { // from class: com.datadog.android.rum.internal.instrumentation.UserActionTrackingStrategyLegacy.onActivityResumed.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((FeatureSdkCore) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(FeatureSdkCore it) {
                Intrinsics.checkNotNullParameter(it, "it");
                UserActionTrackingStrategyLegacy.this.getGesturesTracker$dd_sdk_android_rum_release().startTracking(activity.getWindow(), activity, it);
            }
        });
    }

    @Override // com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityPaused(activity);
        this.gesturesTracker.stopTracking(activity.getWindow(), activity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(UserActionTrackingStrategyLegacy.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.datadog.android.rum.internal.instrumentation.UserActionTrackingStrategyLegacy");
        return Intrinsics.areEqual(this.gesturesTracker, ((UserActionTrackingStrategyLegacy) obj).gesturesTracker);
    }

    public int hashCode() {
        return this.gesturesTracker.hashCode();
    }

    public String toString() {
        return "UserActionTrackingStrategyLegacy(" + this.gesturesTracker + ")";
    }
}
