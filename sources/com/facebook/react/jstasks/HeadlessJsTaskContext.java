package com.facebook.react.jstasks;

import android.util.SparseArray;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.appregistry.AppRegistry;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class HeadlessJsTaskContext {
    public static final Companion Companion = new Companion(null);
    private static final WeakHashMap INSTANCES = new WeakHashMap();
    private final Map activeTaskConfigs;
    private final Set activeTasks;
    private final Set headlessJsTaskEventListeners;
    private final AtomicInteger lastTaskId;
    private final WeakReference reactContext;
    private final SparseArray taskTimeouts;

    public /* synthetic */ HeadlessJsTaskContext(ReactContext reactContext, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactContext);
    }

    private HeadlessJsTaskContext(ReactContext reactContext) {
        this.reactContext = new WeakReference(reactContext);
        this.headlessJsTaskEventListeners = new CopyOnWriteArraySet();
        this.lastTaskId = new AtomicInteger(0);
        this.activeTasks = new CopyOnWriteArraySet();
        this.activeTaskConfigs = new ConcurrentHashMap();
        this.taskTimeouts = new SparseArray();
    }

    public final synchronized void addTaskEventListener(HeadlessJsTaskEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.headlessJsTaskEventListeners.add(listener);
        Iterator it = this.activeTasks.iterator();
        while (it.hasNext()) {
            listener.onHeadlessJsTaskStart(((Number) it.next()).intValue());
        }
    }

    public final void removeTaskEventListener(HeadlessJsTaskEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.headlessJsTaskEventListeners.remove(listener);
    }

    public final boolean hasActiveTasks() {
        return !this.activeTasks.isEmpty();
    }

    public final synchronized int startTask(HeadlessJsTaskConfig taskConfig) {
        int iIncrementAndGet;
        Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
        iIncrementAndGet = this.lastTaskId.incrementAndGet();
        startTask(taskConfig, iIncrementAndGet);
        return iIncrementAndGet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void startTask(HeadlessJsTaskConfig headlessJsTaskConfig, int i) {
        try {
            UiThreadUtil.assertOnUiThread();
            ReactContext reactContext = (ReactContext) Assertions.assertNotNull(this.reactContext.get(), "Tried to start a task on a react context that has already been destroyed");
            if (reactContext.getLifecycleState() == LifecycleState.RESUMED && !headlessJsTaskConfig.isAllowedInForeground()) {
                throw new IllegalStateException(("Tried to start task " + headlessJsTaskConfig.getTaskKey() + " while in foreground, but this is not allowed.").toString());
            }
            this.activeTasks.add(Integer.valueOf(i));
            this.activeTaskConfigs.put(Integer.valueOf(i), new HeadlessJsTaskConfig(headlessJsTaskConfig));
            if (reactContext.hasActiveReactInstance()) {
                ((AppRegistry) reactContext.getJSModule(AppRegistry.class)).startHeadlessTask(i, headlessJsTaskConfig.getTaskKey(), headlessJsTaskConfig.getData());
            } else {
                ReactSoftExceptionLogger.logSoftException("HeadlessJsTaskContext", new RuntimeException("Cannot start headless task, CatalystInstance not available"));
            }
            if (headlessJsTaskConfig.getTimeout() > 0) {
                scheduleTaskTimeout(i, headlessJsTaskConfig.getTimeout());
            }
            Iterator it = this.headlessJsTaskEventListeners.iterator();
            while (it.hasNext()) {
                ((HeadlessJsTaskEventListener) it.next()).onHeadlessJsTaskStart(i);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean retryTask(final int i) {
        HeadlessJsTaskConfig headlessJsTaskConfig = (HeadlessJsTaskConfig) this.activeTaskConfigs.get(Integer.valueOf(i));
        if (headlessJsTaskConfig == null) {
            throw new IllegalStateException(("Tried to retrieve non-existent task config with id " + i + ".").toString());
        }
        HeadlessJsTaskRetryPolicy retryPolicy = headlessJsTaskConfig.getRetryPolicy();
        if (retryPolicy != null && retryPolicy.canRetry()) {
            removeTimeout(i);
            final HeadlessJsTaskConfig headlessJsTaskConfig2 = new HeadlessJsTaskConfig(headlessJsTaskConfig.getTaskKey(), headlessJsTaskConfig.getData(), headlessJsTaskConfig.getTimeout(), headlessJsTaskConfig.isAllowedInForeground(), retryPolicy.update());
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.jstasks.HeadlessJsTaskContext$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.startTask(headlessJsTaskConfig2, i);
                }
            }, retryPolicy.getDelay());
            return true;
        }
        return false;
    }

    public final synchronized void finishTask(final int i) {
        boolean zRemove = this.activeTasks.remove(Integer.valueOf(i));
        this.activeTaskConfigs.remove(Integer.valueOf(i));
        removeTimeout(i);
        if (zRemove) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.jstasks.HeadlessJsTaskContext$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    HeadlessJsTaskContext.finishTask$lambda$4(this.f$0, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void finishTask$lambda$4(HeadlessJsTaskContext headlessJsTaskContext, int i) {
        Iterator it = headlessJsTaskContext.headlessJsTaskEventListeners.iterator();
        while (it.hasNext()) {
            ((HeadlessJsTaskEventListener) it.next()).onHeadlessJsTaskFinish(i);
        }
    }

    private final void removeTimeout(int i) {
        Runnable runnable = (Runnable) this.taskTimeouts.get(i);
        if (runnable != null) {
            UiThreadUtil.removeOnUiThread(runnable);
            this.taskTimeouts.remove(i);
        }
    }

    public final synchronized boolean isTaskRunning(int i) {
        return this.activeTasks.contains(Integer.valueOf(i));
    }

    private final void scheduleTaskTimeout(final int i, long j) {
        Runnable runnable = new Runnable() { // from class: com.facebook.react.jstasks.HeadlessJsTaskContext$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.finishTask(i);
            }
        };
        this.taskTimeouts.append(i, runnable);
        UiThreadUtil.runOnUiThread(runnable, j);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HeadlessJsTaskContext getInstance(ReactContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            WeakHashMap weakHashMap = HeadlessJsTaskContext.INSTANCES;
            Object headlessJsTaskContext = weakHashMap.get(context);
            if (headlessJsTaskContext == null) {
                headlessJsTaskContext = new HeadlessJsTaskContext(context, null);
                weakHashMap.put(context, headlessJsTaskContext);
            }
            return (HeadlessJsTaskContext) headlessJsTaskContext;
        }
    }
}
