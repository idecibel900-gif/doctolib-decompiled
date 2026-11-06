package app.notifee.core;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Trace;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import app.notifee.core.event.ForegroundServiceEvent;
import app.notifee.core.event.NotificationEvent;
import app.notifee.core.interfaces.MethodCallResult;
import app.notifee.core.model.NotificationModel;
import app.notifee.core.utility.ParcelableCompatReader;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;

/* JADX INFO: loaded from: classes3.dex */
public class ForegroundService extends Service {
    public static int mCurrentForegroundServiceType = -1;
    private static int mCurrentHashCode;
    private static Notification mCurrentNotification;
    private static Bundle mCurrentNotificationBundle;
    public static String mCurrentNotificationId;
    private static final Object sLock = new Object();
    private volatile boolean mStartForegroundCalled = false;

    private static boolean hasAnyForegroundServiceType(int i) {
        return (i == 0 || i == -1) ? false : true;
    }

    private static boolean isDeclared(int i, int i2) {
        return (i & i2) == i2;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    static boolean repostIfActive(String str) {
        synchronized (sLock) {
            try {
                String str2 = mCurrentNotificationId;
                if (str2 != null && str2.equals(str) && mCurrentNotification != null) {
                    Logger.w("ForegroundService", "Re-posting foreground service notification dismissed by user");
                    NotificationManagerCompat.from(ContextHolder.getApplicationContext()).notify(mCurrentHashCode, mCurrentNotification);
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static void start(int i, Notification notification, Bundle bundle) {
        Context applicationContext = ContextHolder.getApplicationContext();
        if (applicationContext == null) {
            Logger.e("ForegroundService", "Application context is null; cannot start ForegroundService.");
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34) {
            try {
                if (applicationContext.getPackageManager().getServiceInfo(new ComponentName(applicationContext, (Class<?>) ForegroundService.class), 128).getForegroundServiceType() == 0) {
                    Logger.e("ForegroundService", "No foregroundServiceType declared for app.notifee.core.ForegroundService in your AndroidManifest.xml. Android 14+ requires an explicit foregroundServiceType. Add <service android:name=\"app.notifee.core.ForegroundService\" android:foregroundServiceType=\"yourType\" /> to your app manifest. Aborting foreground service start.");
                    return;
                }
            } catch (PackageManager.NameNotFoundException e) {
                Logger.e("ForegroundService", "ForegroundService not found in manifest", (Exception) e);
                return;
            }
        }
        Intent intent = new Intent(applicationContext, (Class<?>) ForegroundService.class);
        intent.setAction("app.notifee.core.ForegroundService.START");
        intent.putExtra("hashCode", i);
        intent.putExtra("notification", notification);
        intent.putExtra("notificationBundle", bundle);
        if (i2 >= 26) {
            applicationContext.startForegroundService(intent);
        } else {
            applicationContext.startService(intent);
        }
    }

    static void stop() {
        Context applicationContext = ContextHolder.getApplicationContext();
        if (applicationContext == null) {
            Logger.e("ForegroundService", "Application context is null; cannot stop ForegroundService.");
            return;
        }
        Intent intent = new Intent(applicationContext, (Class<?>) ForegroundService.class);
        intent.setAction("app.notifee.core.ForegroundService.STOP");
        try {
            applicationContext.startService(intent);
        } catch (IllegalStateException e) {
            Logger.w("ForegroundService", "startService() threw IllegalStateException on STOP path; falling back to stopService()", e);
            applicationContext.stopService(intent);
        } catch (Exception e2) {
            Logger.e("ForegroundService", "Unable to stop foreground service", e2);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Trace.beginSection("notifee:ForegroundService.onStartCommand");
        boolean z = false;
        Object notificationEvent = null;
        if (intent != null) {
            try {
                if (!"app.notifee.core.ForegroundService.STOP".equals(intent.getAction())) {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        int i3 = extras.getInt("hashCode");
                        Notification notification = (Notification) ParcelableCompatReader.getParcelable(extras, "notification", Notification.class);
                        Bundle bundle = extras.getBundle("notificationBundle");
                        if (notification != null && bundle != null) {
                            NotificationModel notificationModelFromBundle = NotificationModel.fromBundle(bundle);
                            synchronized (sLock) {
                                try {
                                    String str = mCurrentNotificationId;
                                    if (str == null) {
                                        mCurrentNotificationId = notificationModelFromBundle.getId();
                                        mCurrentNotificationBundle = bundle;
                                        mCurrentNotification = notification;
                                        mCurrentHashCode = i3;
                                        int i4 = Build.VERSION.SDK_INT;
                                        if (i4 >= 29) {
                                            int foregroundServiceType = notificationModelFromBundle.getAndroid().getForegroundServiceType();
                                            if (foregroundServiceType == -1) {
                                                foregroundServiceType = resolveManifestServiceType();
                                            }
                                            if (i4 < 34 || foregroundServiceType != 0) {
                                                Trace.beginSection("notifee:startForeground");
                                                try {
                                                    startForeground(i3, notification, foregroundServiceType);
                                                    Trace.endSection();
                                                    this.mStartForegroundCalled = true;
                                                    mCurrentForegroundServiceType = foregroundServiceType;
                                                } catch (Throwable th) {
                                                    Trace.endSection();
                                                    throw th;
                                                }
                                            } else {
                                                Logger.e("ForegroundService", "Resolved foreground service type is NONE on API 34+; aborting startForeground to avoid InvalidForegroundServiceTypeException.");
                                                mCurrentNotificationId = null;
                                                mCurrentForegroundServiceType = -1;
                                                mCurrentNotificationBundle = null;
                                                mCurrentNotification = null;
                                                mCurrentHashCode = 0;
                                                z = true;
                                            }
                                        } else {
                                            Trace.beginSection("notifee:startForeground");
                                            try {
                                                startForeground(i3, notification);
                                                Trace.endSection();
                                                this.mStartForegroundCalled = true;
                                            } catch (Throwable th2) {
                                                Trace.endSection();
                                                throw th2;
                                            }
                                        }
                                        if (!z) {
                                            notificationEvent = new ForegroundServiceEvent(notificationModelFromBundle, new MethodCallResult() { // from class: app.notifee.core.ForegroundService$$ExternalSyntheticLambda0
                                                @Override // app.notifee.core.interfaces.MethodCallResult
                                                public final void onComplete(Exception exc, Object obj) {
                                                    this.f$0.lambda$onStartCommand$0(exc, (Void) obj);
                                                }
                                            });
                                        }
                                    } else if (str.equals(notificationModelFromBundle.getId())) {
                                        int i5 = Build.VERSION.SDK_INT;
                                        if (i5 < 29) {
                                            NotificationManagerCompat.from(ContextHolder.getApplicationContext()).notify(i3, notification);
                                        } else {
                                            int foregroundServiceType2 = notificationModelFromBundle.getAndroid().getForegroundServiceType();
                                            if (foregroundServiceType2 == -1) {
                                                foregroundServiceType2 = resolveManifestServiceType();
                                            }
                                            if (i5 >= 34 && foregroundServiceType2 == 0) {
                                                Logger.e("ForegroundService", "Resolved foreground service type is NONE on API 34+; skipping type change.");
                                            } else if (foregroundServiceType2 != mCurrentForegroundServiceType) {
                                                Trace.beginSection("notifee:startForeground");
                                                try {
                                                    startForeground(i3, notification, foregroundServiceType2);
                                                    Trace.endSection();
                                                    this.mStartForegroundCalled = true;
                                                    mCurrentForegroundServiceType = foregroundServiceType2;
                                                } catch (Throwable th3) {
                                                    Trace.endSection();
                                                    throw th3;
                                                }
                                            }
                                            NotificationManagerCompat.from(ContextHolder.getApplicationContext()).notify(i3, notification);
                                        }
                                    } else {
                                        notificationEvent = new NotificationEvent(8, notificationModelFromBundle);
                                    }
                                } catch (Throwable th4) {
                                    throw th4;
                                }
                            }
                            if (z) {
                                ensureStartForegroundContractSatisfied();
                                Trace.endSection();
                                return 2;
                            }
                            if (notificationEvent != null) {
                                EventBus.post(notificationEvent);
                            }
                        }
                    }
                    Trace.endSection();
                    return 2;
                }
            } catch (Throwable th5) {
                Trace.endSection();
                throw th5;
            }
            Trace.endSection();
            throw th5;
        }
        ensureStartForegroundContractSatisfied();
        stopSelf();
        synchronized (sLock) {
            mCurrentNotificationId = null;
            mCurrentForegroundServiceType = -1;
            mCurrentNotificationBundle = null;
            mCurrentNotification = null;
            mCurrentHashCode = 0;
        }
        Trace.endSection();
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStartCommand$0(Exception exc, Void r3) {
        stopForegroundCompat();
        synchronized (sLock) {
            mCurrentNotificationId = null;
            mCurrentForegroundServiceType = -1;
            mCurrentNotificationBundle = null;
            mCurrentNotification = null;
            mCurrentHashCode = 0;
        }
    }

    @Override // android.app.Service
    public void onTimeout(int i) {
        handleTimeout(i, -1);
    }

    public void onTimeout(int i, int i2) {
        handleTimeout(i, i2);
    }

    private static int resolveManifestServiceType() {
        try {
            Context applicationContext = ContextHolder.getApplicationContext();
            if (applicationContext == null) {
                return Build.VERSION.SDK_INT >= 34 ? 0 : -1;
            }
            int foregroundServiceType = applicationContext.getPackageManager().getServiceInfo(new ComponentName(applicationContext, (Class<?>) ForegroundService.class), 128).getForegroundServiceType();
            if (foregroundServiceType != 0) {
                return foregroundServiceType;
            }
            return Build.VERSION.SDK_INT >= 34 ? 0 : -1;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.e("ForegroundService", "ForegroundService not found in manifest", (Exception) e);
        }
    }

    private void ensureDefensiveChannel() {
        android.app.NotificationManager notificationManager;
        if (Build.VERSION.SDK_INT < 26 || (notificationManager = (android.app.NotificationManager) getSystemService("notification")) == null || notificationManager.getNotificationChannel("notifee_fg_default") != null) {
            return;
        }
        NotificationChannel notificationChannelM = ChannelManager$$ExternalSyntheticApiModelOutline2.m("notifee_fg_default", "Foreground Service", 1);
        notificationChannelM.setShowBadge(false);
        notificationChannelM.enableLights(false);
        notificationChannelM.enableVibration(false);
        notificationChannelM.setSound(null, null);
        notificationManager.createNotificationChannel(notificationChannelM);
    }

    private void stopForegroundCompat() {
        if (Build.VERSION.SDK_INT >= 33) {
            stopForeground(1);
        } else {
            stopForeground(true);
        }
    }

    private int getDeclaredForegroundServiceType() {
        try {
            return getPackageManager().getServiceInfo(new ComponentName(this, (Class<?>) ForegroundService.class), 128).getForegroundServiceType();
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    private static int selectDefensiveForegroundServiceType(int i) {
        int[] iArr = {2048, 1, 2, IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING};
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = iArr[i2];
            if (isDeclared(i, i3)) {
                return i3;
            }
        }
        return i;
    }

    private void ensureStartForegroundContractSatisfied() {
        int declaredForegroundServiceType;
        if (this.mStartForegroundCalled) {
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            declaredForegroundServiceType = getDeclaredForegroundServiceType();
            if (!hasAnyForegroundServiceType(declaredForegroundServiceType)) {
                Logger.e("ForegroundService", "react-native-notify-kit: ForegroundService cannot start — no foregroundServiceType declared in AndroidManifest.xml on API 34+. See https://github.com/marcocrupi/react-native-notify-kit#foreground-service-setup-android-14");
                throw new RuntimeException("react-native-notify-kit: ForegroundService cannot start — no foregroundServiceType declared in AndroidManifest.xml on API 34+. See https://github.com/marcocrupi/react-native-notify-kit#foreground-service-setup-android-14");
            }
        } else {
            declaredForegroundServiceType = 0;
        }
        try {
            ensureDefensiveChannel();
            Notification notificationBuild = new NotificationCompat.Builder(this, "notifee_fg_default").setSmallIcon(R.drawable.ic_dialog_info).build();
            if (i >= 34) {
                startForeground(2147483646, notificationBuild, selectDefensiveForegroundServiceType(declaredForegroundServiceType));
            } else {
                startForeground(2147483646, notificationBuild);
            }
            this.mStartForegroundCalled = true;
            stopForegroundCompat();
        } catch (SecurityException e) {
            Logger.w("ForegroundService", "Defensive startForeground() was denied by Android while stopping the service; continuing with stopSelf() to avoid a fatal app crash.", e);
        } catch (Exception e2) {
            Logger.e("ForegroundService", "react-native-notify-kit: defensive startForeground() failed. This indicates an inconsistent service state and the process cannot recover.", e2);
            throw new RuntimeException("react-native-notify-kit: defensive startForeground() failed. This indicates an inconsistent service state and the process cannot recover.", e2);
        }
    }

    private void handleTimeout(int i, int i2) {
        Bundle bundle;
        Logger.e("ForegroundService", "Foreground service timed out (startId=" + i + ", type=" + i2 + "). Stopping service.");
        synchronized (sLock) {
            bundle = mCurrentNotificationBundle;
            mCurrentNotificationId = null;
            mCurrentForegroundServiceType = -1;
            mCurrentNotificationBundle = null;
            mCurrentNotification = null;
            mCurrentHashCode = 0;
        }
        stopForegroundCompat();
        stopSelf(i);
        if (bundle != null) {
            NotificationModel notificationModelFromBundle = NotificationModel.fromBundle(bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("startId", i);
            bundle2.putInt("fgsType", i2);
            EventBus.post(new NotificationEvent(9, notificationModelFromBundle, bundle2));
        }
    }
}
