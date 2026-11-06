package com.facebook.react;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlags;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HeadlessJsTaskService extends Service implements HeadlessJsTaskEventListener {
    public static final Companion Companion = new Companion(null);
    private static PowerManager.WakeLock wakeLock;
    private final Set<Integer> activeTasks = new CopyOnWriteArraySet();

    @SuppressLint({"WakelockTimeout"})
    public static final void acquireWakeLockNow(Context context) {
        Companion.acquireWakeLockNow(context);
    }

    protected static /* synthetic */ void getReactNativeHost$annotations() {
    }

    protected abstract HeadlessJsTaskConfig getTaskConfig(Intent intent);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
    public void onHeadlessJsTaskStart(int i) {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        HeadlessJsTaskConfig taskConfig = getTaskConfig(intent);
        if (taskConfig == null) {
            return 2;
        }
        startTask(taskConfig);
        return 3;
    }

    protected final void startTask(HeadlessJsTaskConfig taskConfig) {
        Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
        UiThreadUtil.assertOnUiThread();
        Companion.acquireWakeLockNow(this);
        ReactContext reactContext = getReactContext();
        if (reactContext == null) {
            createReactContextAndScheduleTask(taskConfig);
        } else {
            invokeStartTask(reactContext, taskConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invokeStartTask(ReactContext reactContext, final HeadlessJsTaskConfig headlessJsTaskConfig) {
        final HeadlessJsTaskContext companion = HeadlessJsTaskContext.Companion.getInstance(reactContext);
        companion.addTaskEventListener(this);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.HeadlessJsTaskService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                HeadlessJsTaskService.invokeStartTask$lambda$0(companion, headlessJsTaskConfig, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeStartTask$lambda$0(HeadlessJsTaskContext headlessJsTaskContext, HeadlessJsTaskConfig headlessJsTaskConfig, HeadlessJsTaskService headlessJsTaskService) {
        headlessJsTaskService.activeTasks.add(Integer.valueOf(headlessJsTaskContext.startTask(headlessJsTaskConfig)));
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ReactContext reactContext = getReactContext();
        if (reactContext != null) {
            HeadlessJsTaskContext.Companion.getInstance(reactContext).removeTaskEventListener(this);
        }
        PowerManager.WakeLock wakeLock2 = wakeLock;
        if (wakeLock2 != null) {
            wakeLock2.release();
        }
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
    public void onHeadlessJsTaskFinish(int i) {
        this.activeTasks.remove(Integer.valueOf(i));
        if (this.activeTasks.isEmpty()) {
            stopSelf();
        }
    }

    protected ReactNativeHost getReactNativeHost() {
        ComponentCallbacks2 application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.facebook.react.ReactApplication");
        return ((ReactApplication) application).getReactNativeHost();
    }

    protected ReactHost getReactHost() {
        ComponentCallbacks2 application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.facebook.react.ReactApplication");
        return ((ReactApplication) application).getReactHost();
    }

    protected final ReactContext getReactContext() {
        if (ReactNativeNewArchitectureFeatureFlags.enableBridgelessArchitecture()) {
            ReactHost reactHost = getReactHost();
            if (reactHost == null) {
                throw new IllegalStateException("ReactHost is not initialized in New Architecture");
            }
            return reactHost.getCurrentReactContext();
        }
        ReactInstanceManager reactInstanceManager = getReactNativeHost().getReactInstanceManager();
        Intrinsics.checkNotNullExpressionValue(reactInstanceManager, "getReactInstanceManager(...)");
        return reactInstanceManager.getCurrentReactContext();
    }

    private final void createReactContextAndScheduleTask(final HeadlessJsTaskConfig headlessJsTaskConfig) {
        if (ReactNativeNewArchitectureFeatureFlags.enableBridgelessArchitecture()) {
            final ReactHost reactHost = getReactHost();
            if (reactHost == null) {
                throw new IllegalStateException("Required value was null.");
            }
            reactHost.addReactInstanceEventListener(new ReactInstanceEventListener() { // from class: com.facebook.react.HeadlessJsTaskService.createReactContextAndScheduleTask.1
                @Override // com.facebook.react.ReactInstanceEventListener
                public void onReactContextInitialized(ReactContext context) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    HeadlessJsTaskService.this.invokeStartTask(context, headlessJsTaskConfig);
                    reactHost.removeReactInstanceEventListener(this);
                }
            });
            reactHost.start();
            return;
        }
        final ReactInstanceManager reactInstanceManager = getReactNativeHost().getReactInstanceManager();
        Intrinsics.checkNotNullExpressionValue(reactInstanceManager, "getReactInstanceManager(...)");
        reactInstanceManager.addReactInstanceEventListener(new ReactInstanceEventListener() { // from class: com.facebook.react.HeadlessJsTaskService.createReactContextAndScheduleTask.2
            @Override // com.facebook.react.ReactInstanceEventListener
            public void onReactContextInitialized(ReactContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
                HeadlessJsTaskService.this.invokeStartTask(context, headlessJsTaskConfig);
                reactInstanceManager.removeReactInstanceEventListener(this);
            }
        });
        reactInstanceManager.createReactContextInBackground();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void acquireWakeLockNow(Context context) {
            PowerManager.WakeLock wakeLock;
            Intrinsics.checkNotNullParameter(context, "context");
            if (HeadlessJsTaskService.wakeLock == null || !((wakeLock = HeadlessJsTaskService.wakeLock) == null || wakeLock.isHeld())) {
                Object systemService = context.getSystemService("power");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService).newWakeLock(1, HeadlessJsTaskService.class.getCanonicalName());
                wakeLockNewWakeLock.setReferenceCounted(false);
                wakeLockNewWakeLock.acquire();
                HeadlessJsTaskService.wakeLock = wakeLockNewWakeLock;
            }
        }
    }
}
