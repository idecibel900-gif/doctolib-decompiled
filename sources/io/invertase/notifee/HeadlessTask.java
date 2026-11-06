package io.invertase.notifee;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import app.notifee.core.EventSubscriber;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.ReactInstanceEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class HeadlessTask {
    public static final Companion Companion = new Companion(null);
    private static final AtomicInteger sLastTaskId = new AtomicInteger(0);
    private final ArrayList mTaskQueue = new ArrayList();
    private final AtomicBoolean mIsReactContextInitialized = new AtomicBoolean(false);
    private final AtomicBoolean mWillDrainTaskQueue = new AtomicBoolean(false);
    private final AtomicBoolean mIsInitializingReactContext = new AtomicBoolean(false);
    private final AtomicBoolean mIsHeadlessJsTaskListenerRegistered = new AtomicBoolean(false);

    public interface GenericCallback {
        void call();
    }

    public final void stopAllTasks() {
        Iterator it = this.mTaskQueue.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            onFinishHeadlessTask(((TaskConfig) next).getTaskId());
        }
    }

    public final void onFinishHeadlessTask(int i) {
        Object next;
        if (this.mIsReactContextInitialized.get()) {
            Companion companion = Companion;
            Context context = EventSubscriber.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            ReactContext reactContext = companion.getReactContext(context);
            if (reactContext != null) {
                synchronized (this.mTaskQueue) {
                    try {
                        Iterator it = this.mTaskQueue.iterator();
                        do {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                        } while (((TaskConfig) next).getTaskId() != i);
                        TaskConfig taskConfig = (TaskConfig) next;
                        if (taskConfig != null) {
                            HeadlessJsTaskContext.Companion.getInstance(reactContext).finishTask(taskConfig.getReactTaskId());
                            Unit unit = Unit.INSTANCE;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Failed to find task: ");
                            sb.append(i);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    public final void startTask(Context context, TaskConfig taskConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
        UiThreadUtil.assertOnUiThread();
        synchronized (this.mTaskQueue) {
            this.mTaskQueue.add(taskConfig);
        }
        if (!this.mIsReactContextInitialized.get()) {
            createReactContextAndScheduleTask$default(this, context, null, 2, null);
            return;
        }
        ReactContext reactContext = Companion.getReactContext(context);
        if (reactContext == null) {
            this.mIsReactContextInitialized.set(false);
            this.mWillDrainTaskQueue.set(false);
            this.mIsInitializingReactContext.set(false);
            this.mIsHeadlessJsTaskListenerRegistered.set(false);
            createReactContextAndScheduleTask(context, reactContext);
            return;
        }
        invokeStartTask(reactContext, taskConfig);
    }

    private final synchronized void invokeStartTask(ReactContext reactContext, TaskConfig taskConfig) {
        try {
            if (taskConfig.getReactTaskId() > 0) {
                return;
            }
            HeadlessJsTaskContext companion = HeadlessJsTaskContext.Companion.getInstance(reactContext);
            try {
                if (this.mIsHeadlessJsTaskListenerRegistered.compareAndSet(false, true)) {
                    companion.addTaskEventListener(new HeadlessJsTaskEventListener() { // from class: io.invertase.notifee.HeadlessTask.invokeStartTask.1
                        @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
                        public void onHeadlessJsTaskStart(int i) {
                        }

                        @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
                        public void onHeadlessJsTaskFinish(int i) {
                            Object next;
                            ArrayList arrayList = HeadlessTask.this.mTaskQueue;
                            HeadlessTask headlessTask = HeadlessTask.this;
                            synchronized (arrayList) {
                                try {
                                    if (headlessTask.mTaskQueue.isEmpty()) {
                                        return;
                                    }
                                    Iterator it = headlessTask.mTaskQueue.iterator();
                                    do {
                                        if (!it.hasNext()) {
                                            next = null;
                                            break;
                                        }
                                        next = it.next();
                                    } while (((TaskConfig) next).getReactTaskId() != i);
                                    TaskConfig taskConfig2 = (TaskConfig) next;
                                    if (taskConfig2 != null) {
                                        taskConfig2.getTaskId();
                                        headlessTask.mTaskQueue.remove(taskConfig2);
                                        GenericCallback callback = taskConfig2.getCallback();
                                        if (callback != null) {
                                            callback.call();
                                            Unit unit = Unit.INSTANCE;
                                        }
                                    } else {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("Failed to find taskId: ");
                                        sb.append(i);
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    });
                }
                taskConfig.setReactTaskId(companion.startTask(taskConfig.getTaskConfig()));
            } catch (IllegalStateException e) {
                e.getMessage();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    static /* synthetic */ void createReactContextAndScheduleTask$default(HeadlessTask headlessTask, Context context, ReactContext reactContext, int i, Object obj) {
        if ((i & 2) != 0) {
            reactContext = Companion.getReactContext(context);
        }
        headlessTask.createReactContextAndScheduleTask(context, reactContext);
    }

    private final void createReactContextAndScheduleTask(final Context context, ReactContext reactContext) {
        if (reactContext != null && !this.mIsInitializingReactContext.get()) {
            this.mIsReactContextInitialized.set(true);
            drainTaskQueue(context, reactContext);
            return;
        }
        if (this.mIsInitializingReactContext.compareAndSet(false, true)) {
            final Object reactHost = Companion.getReactHost(context);
            ReactInstanceEventListener reactInstanceEventListener = new ReactInstanceEventListener() { // from class: io.invertase.notifee.HeadlessTask$createReactContextAndScheduleTask$callback$1
                @Override // com.facebook.react.ReactInstanceEventListener
                public void onReactContextInitialized(ReactContext reactCtx) {
                    Intrinsics.checkNotNullParameter(reactCtx, "reactCtx");
                    this.this$0.mIsReactContextInitialized.set(true);
                    this.this$0.drainTaskQueue(context, reactCtx);
                    try {
                        Object obj = reactHost;
                        Intrinsics.checkNotNull(obj);
                        obj.getClass().getMethod("removeReactInstanceEventListener", ReactInstanceEventListener.class).invoke(reactHost, this);
                    } catch (Exception e) {
                        e.toString();
                    }
                }
            };
            try {
                Intrinsics.checkNotNull(reactHost);
                reactHost.getClass().getMethod("addReactInstanceEventListener", ReactInstanceEventListener.class).invoke(reactHost, reactInstanceEventListener);
                reactHost.getClass().getMethod("start", null).invoke(reactHost, null);
            } catch (Exception e) {
                String message = e.getMessage();
                StringBuilder sb = new StringBuilder();
                sb.append("reflection error ReactHost start: ");
                sb.append(message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drainTaskQueue(final Context context, final ReactContext reactContext) {
        if (this.mWillDrainTaskQueue.compareAndSet(false, true)) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: io.invertase.notifee.HeadlessTask$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    HeadlessTask.drainTaskQueue$lambda$4(context, reactContext, this);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void drainTaskQueue$lambda$4(Context context, ReactContext reactContext, HeadlessTask headlessTask) {
        if (Companion.getReactContext(context) != reactContext) {
            return;
        }
        synchronized (headlessTask.mTaskQueue) {
            try {
                Iterator it = headlessTask.mTaskQueue.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    headlessTask.invokeStartTask(reactContext, (TaskConfig) next);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final class TaskConfig {
        private final GenericCallback callback;
        private final WritableMap params;
        private int reactTaskId;
        private final int taskId;
        private final String taskName;
        private final long taskTimeout;

        public TaskConfig(String taskName, long j, WritableMap params, GenericCallback genericCallback) {
            Intrinsics.checkNotNullParameter(taskName, "taskName");
            Intrinsics.checkNotNullParameter(params, "params");
            this.taskName = taskName;
            this.taskTimeout = j;
            this.callback = genericCallback;
            int nextTaskId = HeadlessTask.Companion.getNextTaskId();
            this.taskId = nextTaskId;
            WritableMap writableMapCopy = params.copy();
            writableMapCopy.putInt("taskId", nextTaskId);
            this.params = writableMapCopy;
        }

        public final GenericCallback getCallback() {
            return this.callback;
        }

        public final int getTaskId() {
            return this.taskId;
        }

        public final int getReactTaskId() {
            return this.reactTaskId;
        }

        public final void setReactTaskId(int i) {
            this.reactTaskId = i;
        }

        public final HeadlessJsTaskConfig getTaskConfig() {
            return new HeadlessJsTaskConfig(this.taskName, this.params, this.taskTimeout, true, null, 16, null);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final synchronized int getNextTaskId() {
            return HeadlessTask.sLastTaskId.incrementAndGet();
        }

        public final Object getReactHost(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Context applicationContext = context.getApplicationContext();
            try {
                return applicationContext.getClass().getMethod("getReactHost", null).invoke(applicationContext, null);
            } catch (Exception unused) {
                return null;
            }
        }

        public final ReactContext getReactContext(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Object reactHost = getReactHost(context);
            Assertions.assertNotNull(reactHost, "getReactHost() is null in New Architecture");
            try {
                Intrinsics.checkNotNull(reactHost);
                Object objInvoke = reactHost.getClass().getMethod("getCurrentReactContext", null).invoke(reactHost, null);
                if (objInvoke instanceof ReactContext) {
                    return (ReactContext) objInvoke;
                }
                return null;
            } catch (Exception e) {
                e.getMessage();
                return null;
            }
        }
    }
}
