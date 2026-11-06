package app.notifee.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationManagerCompat;
import app.notifee.core.event.InitialNotificationEvent;
import app.notifee.core.event.MainComponentEvent;
import app.notifee.core.interfaces.EventListener;
import app.notifee.core.interfaces.MethodCallResult;
import app.notifee.core.model.ChannelGroupModel;
import app.notifee.core.model.ChannelModel;
import app.notifee.core.model.NotificationModel;
import app.notifee.core.utility.AlarmUtils;
import app.notifee.core.utility.FullScreenIntentUtils;
import app.notifee.core.utility.PowerManagerUtils;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class Notifee {

    @KeepForSdk
    public static final int REQUEST_CODE_NOTIFICATION_PERMISSION = 11111;
    private static final String TAG = "API";
    private static final ExecutorService executorService;
    private static final ListeningExecutorService lExecutorService;
    private static boolean mIsnitialized = false;
    private static Notifee mNotifee;
    private MethodCallResult<Bundle> requestPermissionCallResult;

    static {
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        executorService = executorServiceNewCachedThreadPool;
        lExecutorService = MoreExecutors.listeningDecorator(executorServiceNewCachedThreadPool);
    }

    @KeepForSdk
    public static ListeningExecutorService getListeningExecutorService() {
        return lExecutorService;
    }

    @KeepForSdk
    public static Notifee getInstance() {
        if (!mIsnitialized) {
            Logger.w(TAG, "getInstance() accessed before event listener is initialized");
            mNotifee = new Notifee();
        }
        return mNotifee;
    }

    @KeepForSdk
    public static Context getContext() {
        return ContextHolder.getApplicationContext();
    }

    @KeepForSdk
    public static void initialize(EventListener eventListener) {
        synchronized (Notifee.class) {
            try {
                if (mIsnitialized) {
                    return;
                }
                if (mNotifee == null) {
                    mNotifee = new Notifee();
                }
                if (eventListener != null) {
                    EventSubscriber.register(eventListener);
                }
                mIsnitialized = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public String getMainComponent(String str) {
        MainComponentEvent mainComponentEvent = (MainComponentEvent) EventBus.removeStickEvent(MainComponentEvent.class);
        return mainComponentEvent == null ? str : mainComponentEvent.getMainComponent();
    }

    @KeepForSdk
    public void cancelAllNotifications(int i, final MethodCallResult<Void> methodCallResult) {
        Futures.addCallback(NotificationManager.cancelAllNotifications(i), new FutureCallback() { // from class: app.notifee.core.Notifee.1
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Void r3) {
                methodCallResult.onComplete(null, r3);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                methodCallResult.onComplete(new Exception(th), null);
            }
        }, getListeningExecutorService());
    }

    @KeepForSdk
    public void cancelAllNotificationsWithIds(int i, List<String> list, String str, final MethodCallResult<Void> methodCallResult) {
        Futures.addCallback(NotificationManager.cancelAllNotificationsWithIds(i, list, str), new FutureCallback() { // from class: app.notifee.core.Notifee.2
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Void r3) {
                methodCallResult.onComplete(null, r3);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                methodCallResult.onComplete(new Exception(th), null);
            }
        }, getListeningExecutorService());
    }

    @KeepForSdk
    public void openAlarmPermissionSettings(Activity activity, MethodCallResult<Void> methodCallResult) {
        AlarmUtils.openAlarmPermissionSettings(activity);
        methodCallResult.onComplete(null, null);
    }

    @KeepForSdk
    public void createChannel(Bundle bundle, final MethodCallResult<Void> methodCallResult) {
        Futures.addCallback(ChannelManager.createChannel(ChannelModel.fromBundle(bundle)), new FutureCallback() { // from class: app.notifee.core.Notifee.3
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Void r3) {
                methodCallResult.onComplete(null, r3);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                methodCallResult.onComplete(new Exception(th), null);
            }
        }, getListeningExecutorService());
    }

    @KeepForSdk
    public void createChannels(List<Bundle> list, final MethodCallResult<Void> methodCallResult) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Bundle> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(ChannelModel.fromBundle(it.next()));
        }
        Futures.addCallback(ChannelManager.createChannels(arrayList), new FutureCallback() { // from class: app.notifee.core.Notifee.4
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Void r3) {
                methodCallResult.onComplete(null, r3);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                methodCallResult.onComplete(new Exception(th), null);
            }
        }, getListeningExecutorService());
    }

    @KeepForSdk
    public void createChannelGroup(Bundle bundle, final MethodCallResult<Void> methodCallResult) {
        Futures.addCallback(ChannelManager.createChannelGroup(ChannelGroupModel.fromBundle(bundle)), new FutureCallback() { // from class: app.notifee.core.Notifee.5
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Void r3) {
                methodCallResult.onComplete(null, r3);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                methodCallResult.onComplete(new Exception(th), null);
            }
        }, getListeningExecutorService());
    }

    @KeepForSdk
    public void createChannelGroups(List<Bundle> list, final MethodCallResult<Void> methodCallResult) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Bundle> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(ChannelGroupModel.fromBundle(it.next()));
        }
        Futures.addCallback(ChannelManager.createChannelGroups(arrayList), new FutureCallback() { // from class: app.notifee.core.Notifee.6
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Void r3) {
                methodCallResult.onComplete(null, r3);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                methodCallResult.onComplete(new Exception(th), null);
            }
        }, getListeningExecutorService());
    }

    @KeepForSdk
    public void deleteChannel(String str, MethodCallResult<Void> methodCallResult) {
        ChannelManager.deleteChannel(str);
        methodCallResult.onComplete(null, null);
    }

    @KeepForSdk
    public void deleteChannelGroup(String str, MethodCallResult<Void> methodCallResult) {
        ChannelManager.deleteChannelGroup(str);
        methodCallResult.onComplete(null, null);
    }

    @KeepForSdk
    public void displayNotification(Bundle bundle, final MethodCallResult<Void> methodCallResult) {
        Futures.addCallback(NotificationManager.displayNotification(NotificationModel.fromBundle(bundle), null), new FutureCallback() { // from class: app.notifee.core.Notifee.7
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Void r3) {
                methodCallResult.onComplete(null, r3);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                Exception exc = new Exception(th);
                Logger.e(Notifee.TAG, "displayNotification", exc);
                methodCallResult.onComplete(exc, null);
            }
        }, getListeningExecutorService());
    }

    @KeepForSdk
    public void createTriggerNotification(Bundle bundle, Bundle bundle2, final MethodCallResult<Void> methodCallResult) {
        Futures.addCallback(NotificationManager.createTriggerNotification(NotificationModel.fromBundle(bundle), bundle2), new FutureCallback() { // from class: app.notifee.core.Notifee.8
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Void r3) {
                methodCallResult.onComplete(null, r3);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                Exception exc = new Exception(th);
                Logger.e(Notifee.TAG, "createTriggerNotification", exc);
                methodCallResult.onComplete(exc, null);
            }
        }, getListeningExecutorService());
    }

    @KeepForSdk
    public void getTriggerNotificationIds(MethodCallResult<List<String>> methodCallResult) {
        NotificationManager.getTriggerNotificationIds(methodCallResult);
    }

    @KeepForSdk
    public void getDisplayedNotifications(final MethodCallResult<List<Bundle>> methodCallResult) {
        Futures.addCallback(NotificationManager.getDisplayedNotifications(), new FutureCallback() { // from class: app.notifee.core.Notifee.9
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(List list) {
                methodCallResult.onComplete(null, list);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                methodCallResult.onComplete(new Exception(th), null);
            }
        }, getListeningExecutorService());
    }

    @KeepForSdk
    public void getTriggerNotifications(MethodCallResult<List<Bundle>> methodCallResult) {
        NotificationManager.getTriggerNotifications(methodCallResult);
    }

    @KeepForSdk
    public void getChannels(final MethodCallResult<List<Bundle>> methodCallResult) {
        Futures.addCallback(ChannelManager.getChannels(), new FutureCallback() { // from class: app.notifee.core.Notifee.10
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(List list) {
                methodCallResult.onComplete(null, list);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                methodCallResult.onComplete(new Exception(th), null);
            }
        }, getListeningExecutorService());
    }

    @KeepForSdk
    public void getChannel(String str, final MethodCallResult<Bundle> methodCallResult) {
        Futures.addCallback(ChannelManager.getChannel(str), new FutureCallback() { // from class: app.notifee.core.Notifee.11
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Bundle bundle) {
                methodCallResult.onComplete(null, bundle);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                methodCallResult.onComplete(new Exception(th), null);
            }
        }, getListeningExecutorService());
    }

    @KeepForSdk
    public void getChannelGroups(final MethodCallResult<List<Bundle>> methodCallResult) {
        Futures.addCallback(ChannelManager.getChannelGroups(), new FutureCallback() { // from class: app.notifee.core.Notifee.12
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(List list) {
                methodCallResult.onComplete(null, list);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                methodCallResult.onComplete(new Exception(th), null);
            }
        }, getListeningExecutorService());
    }

    @KeepForSdk
    public void getChannelGroup(String str, final MethodCallResult<Bundle> methodCallResult) {
        Futures.addCallback(ChannelManager.getChannelGroup(str), new FutureCallback() { // from class: app.notifee.core.Notifee.13
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Bundle bundle) {
                methodCallResult.onComplete(null, bundle);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                methodCallResult.onComplete(new Exception(th), null);
            }
        }, getListeningExecutorService());
    }

    @KeepForSdk
    public void isChannelCreated(String str, final MethodCallResult<Boolean> methodCallResult) {
        Futures.addCallback(ChannelManager.isChannelCreated(str), new FutureCallback() { // from class: app.notifee.core.Notifee.14
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Boolean bool) {
                methodCallResult.onComplete(null, bool);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                methodCallResult.onComplete(new Exception(th), null);
            }
        }, getListeningExecutorService());
    }

    @KeepForSdk
    public void isChannelBlocked(String str, final MethodCallResult<Boolean> methodCallResult) {
        Futures.addCallback(ChannelManager.isChannelBlocked(str), new FutureCallback() { // from class: app.notifee.core.Notifee.15
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Boolean bool) {
                methodCallResult.onComplete(null, bool);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                methodCallResult.onComplete(new Exception(th), null);
            }
        }, getListeningExecutorService());
    }

    @KeepForSdk
    public void getInitialNotification(Activity activity, MethodCallResult<Bundle> methodCallResult) {
        InitialNotificationEvent initialNotificationEvent = (InitialNotificationEvent) EventBus.removeStickEvent(InitialNotificationEvent.class);
        Bundle bundle = new Bundle();
        if (initialNotificationEvent != null) {
            bundle.putAll(initialNotificationEvent.getExtras());
            bundle.putBundle("notification", initialNotificationEvent.getNotificationModel().toBundle());
            methodCallResult.onComplete(null, bundle);
            return;
        }
        if (activity != null) {
            try {
                Intent intent = activity.getIntent();
                if (intent != null && intent.getExtras() != null && intent.hasExtra("notification")) {
                    bundle.putBundle("notification", intent.getBundleExtra("notification"));
                    methodCallResult.onComplete(null, bundle);
                    return;
                }
            } catch (Exception e) {
                Logger.e(TAG, "getInitialNotification", e);
            }
        }
        methodCallResult.onComplete(null, null);
    }

    @KeepForSdk
    public void isBatteryOptimizationEnabled(MethodCallResult<Boolean> methodCallResult) {
        methodCallResult.onComplete(null, PowerManagerUtils.isBatteryOptimizationEnabled(ContextHolder.getApplicationContext()));
    }

    @KeepForSdk
    public void openBatteryOptimizationSettings(Activity activity, MethodCallResult<Void> methodCallResult) {
        PowerManagerUtils.openBatteryOptimizationSettings(activity);
        methodCallResult.onComplete(null, null);
    }

    @KeepForSdk
    public void getPowerManagerInfo(MethodCallResult<Bundle> methodCallResult) {
        methodCallResult.onComplete(null, PowerManagerUtils.getPowerManagerInfo().toBundle());
    }

    @KeepForSdk
    public void openPowerManagerSettings(Activity activity, MethodCallResult<Void> methodCallResult) {
        PowerManagerUtils.openPowerManagerSettings(activity);
        methodCallResult.onComplete(null, null);
    }

    @KeepForSdk
    public void getNotificationSettings(MethodCallResult<Bundle> methodCallResult) {
        boolean zAreNotificationsEnabled = NotificationManagerCompat.from(ContextHolder.getApplicationContext()).areNotificationsEnabled();
        Bundle bundle = new Bundle();
        if (zAreNotificationsEnabled) {
            bundle.putInt("authorizationStatus", 1);
        } else if (Build.VERSION.SDK_INT >= 33 && !Preferences.getSharedInstance().getBooleanValue("permission_requested", false)) {
            bundle.putInt("authorizationStatus", -1);
        } else {
            bundle.putInt("authorizationStatus", 0);
        }
        boolean zCanScheduleExactAlarms = AlarmUtils.canScheduleExactAlarms();
        Bundle bundle2 = new Bundle();
        if (zCanScheduleExactAlarms) {
            bundle2.putInt("alarm", 1);
        } else {
            bundle2.putInt("alarm", 0);
        }
        if (FullScreenIntentUtils.canUseFullScreenIntent()) {
            bundle2.putInt("fullScreenIntent", 1);
        } else {
            bundle2.putInt("fullScreenIntent", 0);
        }
        bundle.putBundle("android", bundle2);
        methodCallResult.onComplete(null, bundle);
    }

    @KeepForSdk
    public void setRequestPermissionCallback(MethodCallResult<Bundle> methodCallResult) {
        this.requestPermissionCallResult = methodCallResult;
    }

    @KeepForSdk
    public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 11111) {
            return false;
        }
        Preferences.getSharedInstance().setBooleanValue("permission_requested", true);
        MethodCallResult<Bundle> methodCallResult = this.requestPermissionCallResult;
        if (methodCallResult == null) {
            return false;
        }
        getNotificationSettings(methodCallResult);
        return true;
    }

    @KeepForSdk
    public void openNotificationSettings(String str, Activity activity, MethodCallResult<Void> methodCallResult) {
        final Intent intent;
        if (getContext() == null || activity == null) {
            Logger.d("openNotificationSettings", "attempted to start activity but no current activity or context was available.");
            methodCallResult.onComplete(null, null);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (str != null) {
                intent = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.CHANNEL_ID", str);
            } else {
                intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            }
            intent.putExtra("android.provider.extra.APP_PACKAGE", getContext().getPackageName());
        } else {
            intent = new Intent("android.settings.APPLICATION_SETTINGS");
        }
        intent.setFlags(268435456);
        activity.runOnUiThread(new Runnable() { // from class: app.notifee.core.Notifee$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Notifee.getContext().startActivity(intent);
            }
        });
        methodCallResult.onComplete(null, null);
    }

    @KeepForSdk
    public void stopForegroundService(MethodCallResult<Void> methodCallResult) {
        ForegroundService.stop();
        methodCallResult.onComplete(null, null);
    }
}
