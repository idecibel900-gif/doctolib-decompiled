package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationManagerCompat {
    private static String sEnabledNotificationListeners;
    private static SideChannelManager sSideChannelManager;
    private final Context mContext;
    private final NotificationManager mNotificationManager;
    private static final Object sEnabledNotificationListenersLock = new Object();
    private static Set sEnabledNotificationListenerPackages = new HashSet();
    private static final Object sLock = new Object();

    private interface Task {
        void send(INotificationSideChannel iNotificationSideChannel);
    }

    public static NotificationManagerCompat from(Context context) {
        return new NotificationManagerCompat(context);
    }

    private NotificationManagerCompat(Context context) {
        this.mContext = context;
        this.mNotificationManager = (NotificationManager) context.getSystemService("notification");
    }

    public void cancel(int i) {
        cancel(null, i);
    }

    public void cancel(String str, int i) {
        this.mNotificationManager.cancel(str, i);
    }

    public void cancelAll() {
        this.mNotificationManager.cancelAll();
    }

    public void notify(int i, Notification notification) {
        notify(null, i, notification);
    }

    public void notify(String str, int i, Notification notification) {
        if (useSideChannelForNotification(notification)) {
            pushSideChannelQueue(new NotifyTask(this.mContext.getPackageName(), i, str, notification));
            this.mNotificationManager.cancel(str, i);
        } else {
            this.mNotificationManager.notify(str, i, notification);
        }
    }

    public boolean areNotificationsEnabled() {
        return Api24Impl.areNotificationsEnabled(this.mNotificationManager);
    }

    public void createNotificationChannel(NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.createNotificationChannel(this.mNotificationManager, notificationChannel);
        }
    }

    public void createNotificationChannelGroup(NotificationChannelGroup notificationChannelGroup) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.createNotificationChannelGroup(this.mNotificationManager, notificationChannelGroup);
        }
    }

    public void deleteNotificationChannel(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.deleteNotificationChannel(this.mNotificationManager, str);
        }
    }

    public void deleteNotificationChannelGroup(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.deleteNotificationChannelGroup(this.mNotificationManager, str);
        }
    }

    public NotificationChannel getNotificationChannel(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getNotificationChannel(this.mNotificationManager, str);
        }
        return null;
    }

    public NotificationChannelGroup getNotificationChannelGroup(String str) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return Api28Impl.getNotificationChannelGroup(this.mNotificationManager, str);
        }
        if (i >= 26) {
            Iterator it = getNotificationChannelGroups().iterator();
            while (it.hasNext()) {
                NotificationChannelGroup notificationChannelGroupM = NotificationManagerCompat$$ExternalSyntheticApiModelOutline0.m(it.next());
                if (Api26Impl.getId(notificationChannelGroupM).equals(str)) {
                    return notificationChannelGroupM;
                }
            }
        }
        return null;
    }

    public List getNotificationChannels() {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getNotificationChannels(this.mNotificationManager);
        }
        return Collections.EMPTY_LIST;
    }

    public List getNotificationChannelGroups() {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getNotificationChannelGroups(this.mNotificationManager);
        }
        return Collections.EMPTY_LIST;
    }

    public static Set getEnabledListenerPackages(Context context) {
        Set set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (sEnabledNotificationListenersLock) {
            if (string != null) {
                try {
                    if (!string.equals(sEnabledNotificationListeners)) {
                        String[] strArrSplit = string.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1);
                        HashSet hashSet = new HashSet(strArrSplit.length);
                        for (String str : strArrSplit) {
                            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                            if (componentNameUnflattenFromString != null) {
                                hashSet.add(componentNameUnflattenFromString.getPackageName());
                            }
                        }
                        sEnabledNotificationListenerPackages = hashSet;
                        sEnabledNotificationListeners = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            set = sEnabledNotificationListenerPackages;
        }
        return set;
    }

    public boolean canUseFullScreenIntent() {
        int i = Build.VERSION.SDK_INT;
        if (i < 29) {
            return true;
        }
        if (i < 34) {
            return this.mContext.checkSelfPermission("android.permission.USE_FULL_SCREEN_INTENT") == 0;
        }
        return Api34Impl.canUseFullScreenIntent(this.mNotificationManager);
    }

    private static boolean useSideChannelForNotification(Notification notification) {
        Bundle extras = NotificationCompat.getExtras(notification);
        return extras != null && extras.getBoolean("android.support.useSideChannel");
    }

    private void pushSideChannelQueue(Task task) {
        synchronized (sLock) {
            try {
                if (sSideChannelManager == null) {
                    sSideChannelManager = new SideChannelManager(this.mContext.getApplicationContext());
                }
                sSideChannelManager.queueTask(task);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static class SideChannelManager implements Handler.Callback, ServiceConnection {
        private final Context mContext;
        private final Handler mHandler;
        private final HandlerThread mHandlerThread;
        private final Map mRecordMap = new HashMap();
        private Set mCachedEnabledPackages = new HashSet();

        SideChannelManager(Context context) {
            this.mContext = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            this.mHandler = new Handler(handlerThread.getLooper(), this);
        }

        public void queueTask(Task task) {
            this.mHandler.obtainMessage(0, task).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                handleQueueTask((Task) message.obj);
                return true;
            }
            if (i == 1) {
                ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent) message.obj;
                handleServiceConnected(serviceConnectedEvent.componentName, serviceConnectedEvent.iBinder);
                return true;
            }
            if (i == 2) {
                handleServiceDisconnected((ComponentName) message.obj);
                return true;
            }
            if (i != 3) {
                return false;
            }
            handleRetryListenerQueue((ComponentName) message.obj);
            return true;
        }

        private void handleQueueTask(Task task) {
            updateListenerMap();
            for (ListenerRecord listenerRecord : this.mRecordMap.values()) {
                listenerRecord.taskQueue.add(task);
                processListenerQueue(listenerRecord);
            }
        }

        private void handleServiceConnected(ComponentName componentName, IBinder iBinder) {
            ListenerRecord listenerRecord = (ListenerRecord) this.mRecordMap.get(componentName);
            if (listenerRecord != null) {
                listenerRecord.service = INotificationSideChannel.Stub.asInterface(iBinder);
                listenerRecord.retryCount = 0;
                processListenerQueue(listenerRecord);
            }
        }

        private void handleServiceDisconnected(ComponentName componentName) {
            ListenerRecord listenerRecord = (ListenerRecord) this.mRecordMap.get(componentName);
            if (listenerRecord != null) {
                ensureServiceUnbound(listenerRecord);
            }
        }

        private void handleRetryListenerQueue(ComponentName componentName) {
            ListenerRecord listenerRecord = (ListenerRecord) this.mRecordMap.get(componentName);
            if (listenerRecord != null) {
                processListenerQueue(listenerRecord);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Objects.toString(componentName);
            }
            this.mHandler.obtainMessage(1, new ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Objects.toString(componentName);
            }
            this.mHandler.obtainMessage(2, componentName).sendToTarget();
        }

        private void updateListenerMap() {
            Set enabledListenerPackages = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
            if (enabledListenerPackages.equals(this.mCachedEnabledPackages)) {
                return;
            }
            this.mCachedEnabledPackages = enabledListenerPackages;
            List<ResolveInfo> listQueryIntentServices = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                if (enabledListenerPackages.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        componentName.toString();
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.mRecordMap.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Objects.toString(componentName2);
                    }
                    this.mRecordMap.put(componentName2, new ListenerRecord(componentName2));
                }
            }
            Iterator it = this.mRecordMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (!hashSet.contains(entry.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Objects.toString(entry.getKey());
                    }
                    ensureServiceUnbound((ListenerRecord) entry.getValue());
                    it.remove();
                }
            }
        }

        private boolean ensureServiceBound(ListenerRecord listenerRecord) {
            if (listenerRecord.bound) {
                return true;
            }
            boolean zBindService = this.mContext.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(listenerRecord.componentName), this, 33);
            listenerRecord.bound = zBindService;
            if (zBindService) {
                listenerRecord.retryCount = 0;
            } else {
                Objects.toString(listenerRecord.componentName);
                this.mContext.unbindService(this);
            }
            return listenerRecord.bound;
        }

        private void ensureServiceUnbound(ListenerRecord listenerRecord) {
            if (listenerRecord.bound) {
                this.mContext.unbindService(this);
                listenerRecord.bound = false;
            }
            listenerRecord.service = null;
        }

        private void scheduleListenerRetry(ListenerRecord listenerRecord) {
            if (this.mHandler.hasMessages(3, listenerRecord.componentName)) {
                return;
            }
            int i = listenerRecord.retryCount;
            int i2 = i + 1;
            listenerRecord.retryCount = i2;
            if (i2 > 6) {
                listenerRecord.taskQueue.size();
                Objects.toString(listenerRecord.componentName);
                listenerRecord.taskQueue.clear();
            } else {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, listenerRecord.componentName), (1 << i) * 1000);
            }
        }

        private void processListenerQueue(ListenerRecord listenerRecord) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Objects.toString(listenerRecord.componentName);
                listenerRecord.taskQueue.size();
            }
            if (listenerRecord.taskQueue.isEmpty()) {
                return;
            }
            if (!ensureServiceBound(listenerRecord) || listenerRecord.service == null) {
                scheduleListenerRetry(listenerRecord);
                return;
            }
            while (true) {
                Task task = (Task) listenerRecord.taskQueue.peek();
                if (task == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        task.toString();
                    }
                    task.send(listenerRecord.service);
                    listenerRecord.taskQueue.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Objects.toString(listenerRecord.componentName);
                    }
                } catch (RemoteException unused2) {
                    Objects.toString(listenerRecord.componentName);
                }
            }
            if (listenerRecord.taskQueue.isEmpty()) {
                return;
            }
            scheduleListenerRetry(listenerRecord);
        }

        private static class ListenerRecord {
            final ComponentName componentName;
            INotificationSideChannel service;
            boolean bound = false;
            ArrayDeque taskQueue = new ArrayDeque();
            int retryCount = 0;

            ListenerRecord(ComponentName componentName) {
                this.componentName = componentName;
            }
        }
    }

    private static class ServiceConnectedEvent {
        final ComponentName componentName;
        final IBinder iBinder;

        ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
            this.componentName = componentName;
            this.iBinder = iBinder;
        }
    }

    private static class NotifyTask implements Task {
        final int id;
        final Notification notif;
        final String packageName;
        final String tag;

        NotifyTask(String str, int i, String str2, Notification notification) {
            this.packageName = str;
            this.id = i;
            this.tag = str2;
            this.notif = notification;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(INotificationSideChannel iNotificationSideChannel) {
            iNotificationSideChannel.notify(this.packageName, this.id, this.tag, this.notif);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.packageName + ", id:" + this.id + ", tag:" + this.tag + "]";
        }
    }

    static class Api24Impl {
        static boolean areNotificationsEnabled(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }
    }

    static class Api26Impl {
        static void createNotificationChannel(NotificationManager notificationManager, NotificationChannel notificationChannel) {
            notificationManager.createNotificationChannel(notificationChannel);
        }

        static NotificationChannel getNotificationChannel(NotificationManager notificationManager, String str) {
            return notificationManager.getNotificationChannel(str);
        }

        static List getNotificationChannels(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannels();
        }

        static void createNotificationChannelGroup(NotificationManager notificationManager, NotificationChannelGroup notificationChannelGroup) {
            notificationManager.createNotificationChannelGroup(notificationChannelGroup);
        }

        static List getNotificationChannelGroups(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannelGroups();
        }

        static void deleteNotificationChannel(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannel(str);
        }

        static void deleteNotificationChannelGroup(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannelGroup(str);
        }

        static String getId(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getId();
        }
    }

    static class Api28Impl {
        static NotificationChannelGroup getNotificationChannelGroup(NotificationManager notificationManager, String str) {
            return notificationManager.getNotificationChannelGroup(str);
        }
    }

    static class Api34Impl {
        static boolean canUseFullScreenIntent(NotificationManager notificationManager) {
            return notificationManager.canUseFullScreenIntent();
        }
    }
}
