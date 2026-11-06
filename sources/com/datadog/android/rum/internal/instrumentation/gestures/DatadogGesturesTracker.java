package com.datadog.android.rum.internal.instrumentation.gestures;

import android.content.Context;
import android.view.Window;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.rum.tracking.ActionTrackingStrategy;
import com.datadog.android.rum.tracking.InteractionPredicate;
import com.datadog.android.rum.tracking.ViewAttributesProvider;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DatadogGesturesTracker implements GesturesTracker {
    private final ActionTrackingStrategy composeActionsTrackingStrategy;
    private final InteractionPredicate interactionPredicate;
    private final InternalLogger internalLogger;
    private final ViewAttributesProvider[] targetAttributesProviders;

    public DatadogGesturesTracker(ViewAttributesProvider[] targetAttributesProviders, InteractionPredicate interactionPredicate, ActionTrackingStrategy composeActionsTrackingStrategy, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(targetAttributesProviders, "targetAttributesProviders");
        Intrinsics.checkNotNullParameter(interactionPredicate, "interactionPredicate");
        Intrinsics.checkNotNullParameter(composeActionsTrackingStrategy, "composeActionsTrackingStrategy");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.targetAttributesProviders = targetAttributesProviders;
        this.interactionPredicate = interactionPredicate;
        this.composeActionsTrackingStrategy = composeActionsTrackingStrategy;
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.rum.internal.instrumentation.gestures.GesturesTracker
    public void startTracking(Window window, Context context, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        if (window == null) {
            return;
        }
        Window.Callback callback = window.getCallback();
        if (callback == null) {
            callback = new NoOpWindowCallback();
        }
        window.setCallback(new WindowCallbackWrapper(window, sdkCore, callback, generateGestureDetector$dd_sdk_android_rum_release(context, window, sdkCore), this.interactionPredicate, null, this.targetAttributesProviders, this.internalLogger, 32, null));
    }

    @Override // com.datadog.android.rum.internal.instrumentation.gestures.GesturesTracker
    public void stopTracking(Window window, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (window == null) {
            return;
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof WindowCallbackWrapper) {
            WindowCallbackWrapper windowCallbackWrapper = (WindowCallbackWrapper) callback;
            if (!(windowCallbackWrapper.getWrappedCallback() instanceof NoOpWindowCallback)) {
                window.setCallback(windowCallbackWrapper.getWrappedCallback());
            } else {
                window.setCallback(null);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(DatadogGesturesTracker.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.datadog.android.rum.internal.instrumentation.gestures.DatadogGesturesTracker");
        DatadogGesturesTracker datadogGesturesTracker = (DatadogGesturesTracker) obj;
        return Arrays.equals(this.targetAttributesProviders, datadogGesturesTracker.targetAttributesProviders) && Intrinsics.areEqual(this.interactionPredicate.getClass(), datadogGesturesTracker.interactionPredicate.getClass());
    }

    public int hashCode() {
        int iHashCode = Arrays.hashCode(this.targetAttributesProviders) + 544;
        return iHashCode + (iHashCode * 31) + this.interactionPredicate.getClass().hashCode();
    }

    public String toString() {
        return "DatadogGesturesTracker(" + ArraysKt.joinToString$default(this.targetAttributesProviders, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + ")";
    }

    public final GesturesDetectorWrapper generateGestureDetector$dd_sdk_android_rum_release(Context context, Window window, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        return new GesturesDetectorWrapper(context, new GesturesListener(sdkCore, new WeakReference(window), this.targetAttributesProviders, this.interactionPredicate, new WeakReference(context), this.internalLogger, this.composeActionsTrackingStrategy, null, 128, null));
    }
}
