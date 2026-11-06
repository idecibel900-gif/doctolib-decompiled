package com.datadog.android.rum.internal.instrumentation;

import android.app.Activity;
import android.os.Bundle;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.rum.internal.instrumentation.gestures.GesturesTracker;
import com.datadog.android.rum.internal.tracking.UserActionTrackingStrategy;
import com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class UserActionTrackingStrategyApi29 extends ActivityLifecycleTrackingStrategy implements UserActionTrackingStrategy {
    private final GesturesTracker gesturesTracker;

    public final GesturesTracker getGesturesTracker$dd_sdk_android_rum_release() {
        return this.gesturesTracker;
    }

    public UserActionTrackingStrategyApi29(GesturesTracker gesturesTracker) {
        Intrinsics.checkNotNullParameter(gesturesTracker, "gesturesTracker");
        this.gesturesTracker = gesturesTracker;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(final Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        withSdkCore(new Function1() { // from class: com.datadog.android.rum.internal.instrumentation.UserActionTrackingStrategyApi29.onActivityPreCreated.1
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
                UserActionTrackingStrategyApi29.this.getGesturesTracker$dd_sdk_android_rum_release().startTracking(activity.getWindow(), activity, it);
            }
        });
        super.onActivityPreCreated(activity, bundle);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(UserActionTrackingStrategyApi29.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.datadog.android.rum.internal.instrumentation.UserActionTrackingStrategyApi29");
        return Intrinsics.areEqual(this.gesturesTracker, ((UserActionTrackingStrategyApi29) obj).gesturesTracker);
    }

    public int hashCode() {
        return this.gesturesTracker.hashCode();
    }

    public String toString() {
        return "UserActionTrackingStrategyApi29(" + this.gesturesTracker + ")";
    }
}
