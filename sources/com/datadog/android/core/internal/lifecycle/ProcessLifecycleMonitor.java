package com.datadog.android.core.internal.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ProcessLifecycleMonitor implements Application.ActivityLifecycleCallbacks {
    private final AtomicInteger activitiesResumedCounter;
    private final AtomicInteger activitiesStartedCounter;
    private final Callback callback;
    private final AtomicBoolean wasPaused;
    private final AtomicBoolean wasStopped;

    public interface Callback {
        void onPaused();

        void onResumed();

        void onStarted();

        void onStopped();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    public ProcessLifecycleMonitor(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        this.activitiesResumedCounter = new AtomicInteger(0);
        this.activitiesStartedCounter = new AtomicInteger(0);
        this.wasPaused = new AtomicBoolean(true);
        this.wasStopped = new AtomicBoolean(true);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.activitiesResumedCounter.decrementAndGet() != 0 || this.wasPaused.getAndSet(true)) {
            return;
        }
        this.callback.onPaused();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.activitiesStartedCounter.incrementAndGet() == 1 && this.wasStopped.getAndSet(false)) {
            this.callback.onStarted();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.activitiesStartedCounter.decrementAndGet() == 0 && this.wasPaused.get()) {
            this.callback.onStopped();
            this.wasStopped.set(true);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.activitiesResumedCounter.incrementAndGet() == 1 && this.wasPaused.getAndSet(false)) {
            this.callback.onResumed();
        }
    }
}
