package app.notifee.core;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.AlarmManagerCompat;
import app.notifee.core.database.WorkDataEntity;
import app.notifee.core.database.WorkDataRepository;
import app.notifee.core.model.NotificationAndroidModel;
import app.notifee.core.model.NotificationModel;
import app.notifee.core.model.TimestampTriggerModel;
import app.notifee.core.utility.AlarmUtils;
import app.notifee.core.utility.BundleValueReader;
import app.notifee.core.utility.ExtendedListenableFuture;
import app.notifee.core.utility.ObjectUtils;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
class NotifeeAlarmManager {
    private static final long STALE_TRIGGER_GRACE_PERIOD_MS;
    private static final ScheduledExecutorService TIMEOUT_SCHEDULER;
    private static final ExecutorService alarmManagerExecutor;
    private static final ListeningExecutorService alarmManagerListeningExecutor;
    private static final AtomicBoolean rescheduleInProgress;

    NotifeeAlarmManager() {
    }

    static {
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        alarmManagerExecutor = executorServiceNewCachedThreadPool;
        alarmManagerListeningExecutor = MoreExecutors.listeningDecorator(executorServiceNewCachedThreadPool);
        STALE_TRIGGER_GRACE_PERIOD_MS = TimeUnit.HOURS.toMillis(24L);
        rescheduleInProgress = new AtomicBoolean(false);
        TIMEOUT_SCHEDULER = Executors.newSingleThreadScheduledExecutor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void finishReceiverWhenDone(ListenableFuture listenableFuture, final BroadcastReceiver.PendingResult pendingResult, final Runnable runnable, final String str) {
        Futures.addCallback(Futures.withTimeout(listenableFuture, 8L, TimeUnit.SECONDS, TIMEOUT_SCHEDULER), new FutureCallback() { // from class: app.notifee.core.NotifeeAlarmManager.1
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Object obj) {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
                BroadcastReceiver.PendingResult pendingResult2 = pendingResult;
                if (pendingResult2 != null) {
                    pendingResult2.finish();
                }
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                if (th instanceof TimeoutException) {
                    Logger.w("NotifeeAlarmManager", "Room write for " + str + " did not complete within 8s; finishing BroadcastReceiver anyway to avoid ANR");
                } else {
                    Logger.e("NotifeeAlarmManager", "Failure in " + str, new Exception(th));
                }
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
                BroadcastReceiver.PendingResult pendingResult2 = pendingResult;
                if (pendingResult2 != null) {
                    pendingResult2.finish();
                }
            }
        }, alarmManagerListeningExecutor);
    }

    static void displayScheduledNotification(Bundle bundle, BroadcastReceiver.PendingResult pendingResult) {
        if (bundle == null) {
            if (pendingResult != null) {
                pendingResult.finish();
                return;
            }
            return;
        }
        final String string = bundle.getString("notificationId");
        if (string == null) {
            if (pendingResult != null) {
                pendingResult.finish();
            }
        } else {
            finishReceiverWhenDone(Futures.transformAsync(new WorkDataRepository(ContextHolder.getApplicationContext()).getWorkDataById(string), new AsyncFunction() { // from class: app.notifee.core.NotifeeAlarmManager$$ExternalSyntheticLambda0
                @Override // com.google.common.util.concurrent.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    return NotifeeAlarmManager.$r8$lambda$30BMPoTErUfBIaVaze00DGHWzvI(string, (WorkDataEntity) obj);
                }
            }, alarmManagerExecutor), pendingResult, null, "displayScheduledNotification[" + string + "]");
        }
    }

    public static /* synthetic */ ListenableFuture $r8$lambda$30BMPoTErUfBIaVaze00DGHWzvI(final String str, final WorkDataEntity workDataEntity) {
        if (workDataEntity == null || workDataEntity.getNotification() == null || workDataEntity.getTrigger() == null) {
            Logger.w("NotifeeAlarmManager", "Attempted to handle doScheduledWork but no notification data was found.");
            return Futures.immediateFuture(null);
        }
        final Bundle bundleBytesToBundle = ObjectUtils.bytesToBundle(workDataEntity.getTrigger());
        final NotificationModel notificationModelFromBundle = NotificationModel.fromBundle(ObjectUtils.bytesToBundle(workDataEntity.getNotification()));
        return Futures.transformAsync(NotificationManager.displayNotification(notificationModelFromBundle, bundleBytesToBundle), new AsyncFunction() { // from class: app.notifee.core.NotifeeAlarmManager$$ExternalSyntheticLambda2
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return NotifeeAlarmManager.$r8$lambda$VNiV7GFqhDoWvaeRsekOOcH6wVI(bundleBytesToBundle, notificationModelFromBundle, str, workDataEntity, (Void) obj);
            }
        }, alarmManagerExecutor);
    }

    public static /* synthetic */ ListenableFuture $r8$lambda$VNiV7GFqhDoWvaeRsekOOcH6wVI(Bundle bundle, NotificationModel notificationModel, String str, WorkDataEntity workDataEntity, Void r5) {
        if (bundle.containsKey("repeatFrequency") && BundleValueReader.getIntPreserving(bundle, "repeatFrequency") != -1) {
            TimestampTriggerModel timestampTriggerModelFromBundle = TimestampTriggerModel.fromBundle(bundle);
            scheduleTimestampTriggerNotification(notificationModel, timestampTriggerModelFromBundle);
            return WorkDataRepository.getInstance(ContextHolder.getApplicationContext()).update(new WorkDataEntity(str, workDataEntity.getNotification(), ObjectUtils.bundleToBytes(timestampTriggerModelFromBundle.toBundle()), Boolean.TRUE));
        }
        return WorkDataRepository.getInstance(ContextHolder.getApplicationContext()).deleteById(str);
    }

    public static PendingIntent getAlarmManagerIntentForNotification(String str) {
        try {
            Context applicationContext = ContextHolder.getApplicationContext();
            Intent intent = new Intent(applicationContext, (Class<?>) NotificationAlarmReceiver.class);
            intent.putExtra("notificationId", str);
            return PendingIntent.getBroadcast(applicationContext, str.hashCode(), intent, 167772160);
        } catch (Exception e) {
            Logger.e("NotifeeAlarmManager", "Unable to create AlarmManager intent", e);
            return null;
        }
    }

    static void scheduleTimestampTriggerNotification(NotificationModel notificationModel, TimestampTriggerModel timestampTriggerModel) {
        PendingIntent alarmManagerIntentForNotification = getAlarmManagerIntentForNotification(notificationModel.getId());
        if (alarmManagerIntentForNotification == null) {
            Logger.w("NotifeeAlarmManager", "Failed to create PendingIntent for notification: " + notificationModel.getId());
            return;
        }
        AlarmManager alarmManager = AlarmUtils.getAlarmManager();
        TimestampTriggerModel.AlarmType alarmType = timestampTriggerModel.getAlarmType();
        if (Build.VERSION.SDK_INT >= 31 && Arrays.asList(TimestampTriggerModel.AlarmType.SET_EXACT, TimestampTriggerModel.AlarmType.SET_EXACT_AND_ALLOW_WHILE_IDLE, TimestampTriggerModel.AlarmType.SET_ALARM_CLOCK).contains(alarmType) && !alarmManager.canScheduleExactAlarms()) {
            Logger.w("NotifeeAlarmManager", "SCHEDULE_EXACT_ALARM permission not granted. Falling back to inexact alarm.");
            timestampTriggerModel.setNextTimestamp();
            AlarmManagerCompat.setAndAllowWhileIdle(alarmManager, 0, timestampTriggerModel.getTimestamp(), alarmManagerIntentForNotification);
            return;
        }
        timestampTriggerModel.setNextTimestamp();
        try {
            int i = AnonymousClass3.$SwitchMap$app$notifee$core$model$TimestampTriggerModel$AlarmType[alarmType.ordinal()];
            if (i == 1) {
                alarmManager.set(0, timestampTriggerModel.getTimestamp(), alarmManagerIntentForNotification);
                return;
            }
            if (i == 2) {
                AlarmManagerCompat.setAndAllowWhileIdle(alarmManager, 0, timestampTriggerModel.getTimestamp(), alarmManagerIntentForNotification);
                return;
            }
            if (i == 3) {
                AlarmManagerCompat.setExact(alarmManager, 0, timestampTriggerModel.getTimestamp(), alarmManagerIntentForNotification);
                return;
            }
            if (i == 4) {
                AlarmManagerCompat.setExactAndAllowWhileIdle(alarmManager, 0, timestampTriggerModel.getTimestamp(), alarmManagerIntentForNotification);
            } else {
                if (i != 5) {
                    return;
                }
                AlarmManagerCompat.setAlarmClock(alarmManager, timestampTriggerModel.getTimestamp(), NotificationPendingIntent.createIntent(notificationModel.getHashCode().intValue(), buildShowIntentPressActionBundle(notificationModel), 1, new String[]{"notification"}, notificationModel.toBundle()), alarmManagerIntentForNotification);
            }
        } catch (SecurityException e) {
            Logger.w("NotifeeAlarmManager", "SecurityException scheduling exact alarm, falling back to inexact: " + e.getMessage());
            try {
                AlarmManagerCompat.setAndAllowWhileIdle(alarmManager, 0, timestampTriggerModel.getTimestamp(), alarmManagerIntentForNotification);
            } catch (SecurityException e2) {
                Logger.e("NotifeeAlarmManager", "Failed to schedule even inexact alarm", (Exception) e2);
            }
        }
    }

    /* JADX INFO: renamed from: app.notifee.core.NotifeeAlarmManager$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$app$notifee$core$model$TimestampTriggerModel$AlarmType;

        static {
            int[] iArr = new int[TimestampTriggerModel.AlarmType.values().length];
            $SwitchMap$app$notifee$core$model$TimestampTriggerModel$AlarmType = iArr;
            try {
                iArr[TimestampTriggerModel.AlarmType.SET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$app$notifee$core$model$TimestampTriggerModel$AlarmType[TimestampTriggerModel.AlarmType.SET_AND_ALLOW_WHILE_IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$app$notifee$core$model$TimestampTriggerModel$AlarmType[TimestampTriggerModel.AlarmType.SET_EXACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$app$notifee$core$model$TimestampTriggerModel$AlarmType[TimestampTriggerModel.AlarmType.SET_EXACT_AND_ALLOW_WHILE_IDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$app$notifee$core$model$TimestampTriggerModel$AlarmType[TimestampTriggerModel.AlarmType.SET_ALARM_CLOCK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static Bundle buildShowIntentPressActionBundle(NotificationModel notificationModel) {
        NotificationAndroidModel android2 = notificationModel.getAndroid();
        Bundle pressAction = android2 != null ? android2.getPressAction() : null;
        if (pressAction != null && !"__NOTIFEE_OPT_OUT__".equals(pressAction.getString(DiagnosticsEntry.ID_KEY))) {
            return pressAction;
        }
        Bundle bundle = new Bundle();
        bundle.putString(DiagnosticsEntry.ID_KEY, "default");
        bundle.putString("launchActivity", "default");
        return bundle;
    }

    ListenableFuture getScheduledNotifications() {
        return new WorkDataRepository(ContextHolder.getApplicationContext()).getAllWithAlarmManager(Boolean.TRUE);
    }

    public static void cancelNotification(String str) {
        PendingIntent alarmManagerIntentForNotification = getAlarmManagerIntentForNotification(str);
        AlarmManager alarmManager = AlarmUtils.getAlarmManager();
        if (alarmManagerIntentForNotification != null) {
            alarmManager.cancel(alarmManagerIntentForNotification);
        }
    }

    public static ListenableFuture cancelAllNotifications() {
        return new ExtendedListenableFuture(WorkDataRepository.getInstance(ContextHolder.getApplicationContext()).getAllWithAlarmManager(Boolean.TRUE)).continueWith(new AsyncFunction() { // from class: app.notifee.core.NotifeeAlarmManager$$ExternalSyntheticLambda6
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return NotifeeAlarmManager.m2981$r8$lambda$90yDjgZCIQImu5htpApMWfXuQ((List) obj);
            }
        }, alarmManagerListeningExecutor);
    }

    /* JADX INFO: renamed from: $r8$lambda$9-0yDjgZCIQImu5ht-pApMWfXuQ, reason: not valid java name */
    public static /* synthetic */ ListenableFuture m2981$r8$lambda$90yDjgZCIQImu5htpApMWfXuQ(List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                cancelNotification(((WorkDataEntity) it.next()).getId());
            }
        }
        return Futures.immediateFuture(null);
    }

    ListenableFuture rescheduleNotification(WorkDataEntity workDataEntity) {
        if (workDataEntity.getNotification() == null || workDataEntity.getTrigger() == null) {
            return Futures.immediateFuture(null);
        }
        byte[] notification = workDataEntity.getNotification();
        Bundle bundleBytesToBundle = ObjectUtils.bytesToBundle(workDataEntity.getTrigger());
        NotificationModel notificationModelFromBundle = NotificationModel.fromBundle(ObjectUtils.bytesToBundle(notification));
        int intPreserving = BundleValueReader.getIntPreserving(bundleBytesToBundle, "type");
        if (intPreserving != 0) {
            if (intPreserving == 1) {
                return Futures.immediateFuture(null);
            }
            return Futures.immediateFuture(null);
        }
        TimestampTriggerModel timestampTriggerModelFromBundle = TimestampTriggerModel.fromBundle(bundleBytesToBundle);
        if (!timestampTriggerModelFromBundle.getWithAlarmManager().booleanValue()) {
            return Futures.immediateFuture(null);
        }
        ListenableFuture listenableFutureHandleStaleNonRepeatingTrigger = handleStaleNonRepeatingTrigger(notificationModelFromBundle, timestampTriggerModelFromBundle);
        if (listenableFutureHandleStaleNonRepeatingTrigger != null) {
            return listenableFutureHandleStaleNonRepeatingTrigger;
        }
        scheduleTimestampTriggerNotification(notificationModelFromBundle, timestampTriggerModelFromBundle);
        return WorkDataRepository.getInstance(ContextHolder.getApplicationContext()).update(new WorkDataEntity(workDataEntity.getId(), workDataEntity.getNotification(), ObjectUtils.bundleToBytes(timestampTriggerModelFromBundle.toBundle()), workDataEntity.getWithAlarmManager()));
    }

    static ListenableFuture handleStaleNonRepeatingTrigger(NotificationModel notificationModel, TimestampTriggerModel timestampTriggerModel) {
        return handleStaleNonRepeatingTrigger(notificationModel, timestampTriggerModel, alarmManagerListeningExecutor);
    }

    static ListenableFuture handleStaleNonRepeatingTrigger(final NotificationModel notificationModel, TimestampTriggerModel timestampTriggerModel, Executor executor) {
        if (timestampTriggerModel.getRepeatFrequency() != null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long timestamp = timestampTriggerModel.getTimestamp();
        if (timestamp >= jCurrentTimeMillis) {
            return null;
        }
        final String id = notificationModel.getId();
        final WorkDataRepository workDataRepository = WorkDataRepository.getInstance(ContextHolder.getApplicationContext());
        long j = jCurrentTimeMillis - timestamp;
        long j2 = STALE_TRIGGER_GRACE_PERIOD_MS;
        if (j > j2) {
            Logger.i("NotifeeAlarmManager", "Deleting stale non-repeating trigger (age " + j + "ms > " + j2 + "ms grace period): " + id);
            return workDataRepository.deleteById(id);
        }
        Logger.i("NotifeeAlarmManager", "Firing stale non-repeating trigger once within grace period (age " + j + "ms): " + id);
        return Futures.transformAsync(Futures.catchingAsync(Futures.submitAsync(new AsyncCallable() { // from class: app.notifee.core.NotifeeAlarmManager$$ExternalSyntheticLambda3
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final ListenableFuture call() {
                return NotificationManager.displayNotification(notificationModel, null);
            }
        }, executor), Exception.class, new AsyncFunction() { // from class: app.notifee.core.NotifeeAlarmManager$$ExternalSyntheticLambda4
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return NotifeeAlarmManager.$r8$lambda$cQmIfzylaynoj6wOqzIc0GYkVlY(id, (Exception) obj);
            }
        }, executor), new AsyncFunction() { // from class: app.notifee.core.NotifeeAlarmManager$$ExternalSyntheticLambda5
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return workDataRepository.deleteById(id);
            }
        }, executor);
    }

    public static /* synthetic */ ListenableFuture $r8$lambda$cQmIfzylaynoj6wOqzIc0GYkVlY(String str, Exception exc) {
        Logger.w("NotifeeAlarmManager", "Late-fire of stale trigger " + str + " failed, proceeding to delete row", exc);
        return Futures.immediateFuture(null);
    }

    void rescheduleNotifications(final BroadcastReceiver.PendingResult pendingResult) {
        if (!rescheduleInProgress.compareAndSet(false, true)) {
            Logger.i("NotifeeAlarmManager", "Reschedule already in progress, skipping duplicate request");
            if (pendingResult != null) {
                pendingResult.finish();
                return;
            }
            return;
        }
        final Runnable runnable = new Runnable() { // from class: app.notifee.core.NotifeeAlarmManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                NotifeeAlarmManager.rescheduleInProgress.set(false);
            }
        };
        Logger.d("NotifeeAlarmManager", "Reschedule Notifications on reboot");
        Futures.addCallback(getScheduledNotifications(), new FutureCallback() { // from class: app.notifee.core.NotifeeAlarmManager.2
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(List list) {
                StringBuilder sb = new StringBuilder();
                sb.append("Reschedule starting for ");
                sb.append(list != null ? list.size() : 0);
                sb.append(" recurring alarms");
                Logger.d("NotifeeAlarmManager", sb.toString());
                if (list == null || list.isEmpty()) {
                    runnable.run();
                    BroadcastReceiver.PendingResult pendingResult2 = pendingResult;
                    if (pendingResult2 != null) {
                        pendingResult2.finish();
                        return;
                    }
                    return;
                }
                ArrayList arrayList = new ArrayList(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    WorkDataEntity workDataEntity = (WorkDataEntity) it.next();
                    try {
                        arrayList.add(NotifeeAlarmManager.this.rescheduleNotification(workDataEntity));
                    } catch (Throwable th) {
                        Logger.w("NotifeeAlarmManager", "Failed to reschedule entity " + workDataEntity.getId() + ": " + th.getMessage());
                    }
                }
                NotifeeAlarmManager.finishReceiverWhenDone(Futures.allAsList(arrayList), pendingResult, runnable, "rescheduleNotifications");
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                Logger.e("NotifeeAlarmManager", "Failed to reschedule notifications", new Exception(th));
                runnable.run();
                BroadcastReceiver.PendingResult pendingResult2 = pendingResult;
                if (pendingResult2 != null) {
                    pendingResult2.finish();
                }
            }
        }, alarmManagerListeningExecutor);
    }
}
