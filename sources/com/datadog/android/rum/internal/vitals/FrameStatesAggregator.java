package com.datadog.android.rum.internal.vitals;

import android.app.Activity;
import android.app.Application;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.FrameMetrics;
import android.view.View;
import android.view.Window;
import androidx.metrics.performance.FrameData;
import androidx.metrics.performance.JankStats;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.system.BuildSdkVersionProvider;
import com.datadog.android.rum.internal.domain.FrameMetricsData;
import com.google.firebase.messaging.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Settings;

/* JADX INFO: loaded from: classes3.dex */
public final class FrameStatesAggregator implements Application.ActivityLifecycleCallbacks, JankStats.OnFrameListener {
    public static final Companion Companion = new Companion(null);
    private final WeakHashMap activeActivities;
    private final WeakHashMap activeWindowsListener;
    private BuildSdkVersionProvider buildSdkVersionProvider;
    private Display display;
    private final FrameMetricsData frameMetricsData;
    private DDFrameMetricsListener frameMetricsListener;
    private final List frameStateListeners;
    private final InternalLogger internalLogger;
    private final JankStatsProvider jankStatsProvider;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
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

    public FrameStatesAggregator(List frameStateListeners, InternalLogger internalLogger, JankStatsProvider jankStatsProvider, BuildSdkVersionProvider buildSdkVersionProvider) {
        Intrinsics.checkNotNullParameter(frameStateListeners, "frameStateListeners");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(jankStatsProvider, "jankStatsProvider");
        Intrinsics.checkNotNullParameter(buildSdkVersionProvider, "buildSdkVersionProvider");
        this.frameStateListeners = frameStateListeners;
        this.internalLogger = internalLogger;
        this.jankStatsProvider = jankStatsProvider;
        this.buildSdkVersionProvider = buildSdkVersionProvider;
        this.activeWindowsListener = new WeakHashMap();
        this.activeActivities = new WeakHashMap();
        this.frameMetricsData = new FrameMetricsData(0, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, false, 0L, 0L, 0L, 0L, 0.0d, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
    }

    public final List getFrameStateListeners$dd_sdk_android_rum_release() {
        return this.frameStateListeners;
    }

    public /* synthetic */ FrameStatesAggregator(List list, InternalLogger internalLogger, JankStatsProvider jankStatsProvider, BuildSdkVersionProvider buildSdkVersionProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, internalLogger, (i & 4) != 0 ? JankStatsProvider.Companion.getDEFAULT() : jankStatsProvider, (i & 8) != 0 ? BuildSdkVersionProvider.Companion.getDEFAULT() : buildSdkVersionProvider);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        trackActivity(window, activity);
        boolean zContainsKey = this.activeWindowsListener.containsKey(window);
        trackWindowJankStats(window);
        trackWindowMetrics(zContainsKey, window, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        final Window window = activity.getWindow();
        if (!this.activeActivities.containsKey(window)) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator.onActivityStopped.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Activity stopped but window was not tracked";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        List arrayList = (List) this.activeActivities.get(window);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        CollectionsKt.removeAll(arrayList, new Function1() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator.onActivityStopped.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(WeakReference it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.get() == null || Intrinsics.areEqual(it.get(), activity));
            }
        });
        this.activeActivities.put(window, arrayList);
        if (arrayList.isEmpty()) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.DEBUG, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator.onActivityStopped.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Disabling jankStats for window " + window;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            try {
                JankStats jankStats = (JankStats) this.activeWindowsListener.get(window);
                if (jankStats != null) {
                    if (jankStats.isTrackingEnabled()) {
                        jankStats.setTrackingEnabled(false);
                    } else {
                        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.TELEMETRY, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator$onActivityStopped$4$1
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Trying to disable JankStats instance which was already disabled before, this shouldn't happen.";
                            }
                        }, (Throwable) null, false, (Map) null, 56, (Object) null);
                    }
                }
            } catch (IllegalArgumentException e) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.TELEMETRY, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator.onActivityStopped.5
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to disable JankStats tracking";
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
            } catch (NullPointerException e2) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.TELEMETRY, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator.onActivityStopped.6
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to disable JankStats tracking";
                    }
                }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Collection collection = (Collection) this.activeActivities.get(activity.getWindow());
        if (collection == null || collection.isEmpty()) {
            this.activeWindowsListener.remove(activity.getWindow());
            this.activeActivities.remove(activity.getWindow());
            if (this.buildSdkVersionProvider.getVersion() >= 31) {
                Window window = activity.getWindow();
                Intrinsics.checkNotNullExpressionValue(window, "activity.window");
                unregisterMetricListener(window);
            }
        }
    }

    @Override // androidx.metrics.performance.JankStats.OnFrameListener
    public void onFrame(FrameData volatileFrameData) {
        Intrinsics.checkNotNullParameter(volatileFrameData, "volatileFrameData");
        int size = this.frameStateListeners.size();
        for (int i = 0; i < size; i++) {
            ((FrameStateListener) this.frameStateListeners.get(i)).onFrame(volatileFrameData);
        }
    }

    private final void trackActivity(Window window, Activity activity) {
        Object next;
        List arrayList = (List) this.activeActivities.get(window);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((WeakReference) next).get(), activity));
        if (next != null) {
            return;
        }
        arrayList.add(new WeakReference(activity));
        this.activeActivities.put(window, arrayList);
    }

    private final void trackWindowJankStats(final Window window) {
        JankStats jankStats = (JankStats) this.activeWindowsListener.get(window);
        if (jankStats != null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.DEBUG, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator.trackWindowJankStats.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Resuming jankStats for window " + window;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            jankStats.setTrackingEnabled(true);
            return;
        }
        InternalLogger internalLogger = this.internalLogger;
        InternalLogger.Level level = InternalLogger.Level.DEBUG;
        InternalLogger.Target target = InternalLogger.Target.MAINTAINER;
        InternalLogger.DefaultImpls.log$default(internalLogger, level, target, new Function0() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator.trackWindowJankStats.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Starting jankStats for window " + window;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        JankStats jankStatsCreateJankStatsAndTrack = this.jankStatsProvider.createJankStatsAndTrack(window, this, this.internalLogger);
        if (jankStatsCreateJankStatsAndTrack == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, target, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator.trackWindowJankStats.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to create JankStats";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else {
            this.activeWindowsListener.put(window, jankStatsCreateJankStatsAndTrack);
        }
    }

    private final void trackWindowMetrics(boolean z, Window window, Activity activity) {
        if (this.buildSdkVersionProvider.getVersion() >= 31 && !z) {
            registerMetricListener(window);
        } else if (this.display == null && this.buildSdkVersionProvider.getVersion() == 30) {
            Object systemService = activity.getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
            this.display = ((DisplayManager) systemService).getDisplay(0);
        }
    }

    private final void registerMetricListener(final Window window) {
        if (this.frameMetricsListener == null) {
            this.frameMetricsListener = new DDFrameMetricsListener();
        }
        final Handler handler = new Handler(Looper.getMainLooper());
        final View viewPeekDecorView = window.peekDecorView();
        if (viewPeekDecorView == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator.registerMetricListener.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to attach JankStatsListener to window, decorView is null";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else {
            viewPeekDecorView.post(new Runnable() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    FrameStatesAggregator.registerMetricListener$lambda$3(viewPeekDecorView, this, window, handler);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerMetricListener$lambda$3(View view, FrameStatesAggregator this$0, Window window, Handler handler) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(window, "$window");
        Intrinsics.checkNotNullParameter(handler, "$handler");
        if (!view.isHardwareAccelerated()) {
            InternalLogger.DefaultImpls.log$default(this$0.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator$registerMetricListener$2$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to attach JankStatsListener to window, decorView is not hardware accelerated";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        DDFrameMetricsListener dDFrameMetricsListener = this$0.frameMetricsListener;
        if (dDFrameMetricsListener != null) {
            try {
                window.addOnFrameMetricsAvailableListener(dDFrameMetricsListener, handler);
            } catch (IllegalStateException e) {
                InternalLogger.DefaultImpls.log$default(this$0.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator$registerMetricListener$2$2$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Unable to attach JankStatsListener to window";
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
        }
    }

    private final void unregisterMetricListener(Window window) {
        try {
            window.removeOnFrameMetricsAvailableListener(this.frameMetricsListener);
        } catch (IllegalArgumentException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator.unregisterMetricListener.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to detach JankStatsListener to window, most probably because it wasn't attached";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        }
    }

    public final class DDFrameMetricsListener implements Window.OnFrameMetricsAvailableListener {
        public DDFrameMetricsListener() {
        }

        @Override // android.view.Window.OnFrameMetricsAvailableListener
        public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
            Intrinsics.checkNotNullParameter(window, "window");
            Intrinsics.checkNotNullParameter(frameMetrics, "frameMetrics");
            int size = FrameStatesAggregator.this.getFrameStateListeners$dd_sdk_android_rum_release().size();
            for (int i2 = 0; i2 < size; i2++) {
                FrameStateListener frameStateListener = (FrameStateListener) FrameStatesAggregator.this.getFrameStateListeners$dd_sdk_android_rum_release().get(i2);
                FrameStatesAggregator frameStatesAggregator = FrameStatesAggregator.this;
                frameStateListener.onFrameMetricsData(frameStatesAggregator.update(frameStatesAggregator.frameMetricsData, frameMetrics, i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameMetricsData update(FrameMetricsData frameMetricsData, FrameMetrics frameMetrics, int i) {
        Display display = this.display;
        frameMetricsData.setDisplayRefreshRate(display != null ? display.getRefreshRate() : 60.0d);
        if (this.buildSdkVersionProvider.getVersion() >= 24) {
            frameMetricsData.setDroppedFrames(i);
            frameMetricsData.setUnknownDelayDuration(frameMetrics.getMetric(0));
            frameMetricsData.setInputHandlingDuration(frameMetrics.getMetric(1));
            frameMetricsData.setAnimationDuration(frameMetrics.getMetric(2));
            frameMetricsData.setLayoutMeasureDuration(frameMetrics.getMetric(3));
            frameMetricsData.setDrawDuration(frameMetrics.getMetric(4));
            frameMetricsData.setSyncDuration(frameMetrics.getMetric(5));
            frameMetricsData.setCommandIssueDuration(frameMetrics.getMetric(6));
            frameMetricsData.setSwapBuffersDuration(frameMetrics.getMetric(7));
            frameMetricsData.setTotalDuration(frameMetrics.getMetric(8));
            frameMetricsData.setFirstDrawFrame(frameMetrics.getMetric(9) == 1);
        }
        if (this.buildSdkVersionProvider.getVersion() >= 26) {
            frameMetricsData.setIntendedVsyncTimestamp(frameMetrics.getMetric(10));
            frameMetricsData.setVsyncTimestamp(frameMetrics.getMetric(11));
        }
        if (this.buildSdkVersionProvider.getVersion() >= 31) {
            frameMetricsData.setGpuDuration(frameMetrics.getMetric(12));
            frameMetricsData.setDeadline(frameMetrics.getMetric(13));
        }
        return frameMetricsData;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
