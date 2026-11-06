package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import androidx.profileinstaller.ProfileInstallReceiver$$ExternalSyntheticLambda0;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
final class ProxyNotificationInitializer {
    private static final String MANIFEST_METADATA_NOTIFICATION_DELEGATION_ENABLED = "firebase_messaging_notification_delegation_enabled";

    private ProxyNotificationInitializer() {
    }

    @TargetApi(29)
    static Task<Void> setEnableProxyNotification(Executor executor, final Context context, final boolean z) {
        if (!PlatformVersion.isAtLeastQ()) {
            return Tasks.forResult(null);
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new Runnable() { // from class: com.google.firebase.messaging.ProxyNotificationInitializer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ProxyNotificationInitializer.$r8$lambda$4f3YGOo_VogWWzQiXH4gueD5Xb8(context, z, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public static /* synthetic */ void $r8$lambda$4f3YGOo_VogWWzQiXH4gueD5Xb8(Context context, boolean z, TaskCompletionSource taskCompletionSource) {
        try {
            if (!allowedToUse(context)) {
                context.getPackageName();
                return;
            }
            ProxyNotificationPreferences.setProxyNotificationsInitialized(context, true);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (!z) {
                if ("com.google.android.gms".equals(notificationManager.getNotificationDelegate())) {
                    notificationManager.setNotificationDelegate(null);
                }
            } else {
                notificationManager.setNotificationDelegate("com.google.android.gms");
            }
        } finally {
            taskCompletionSource.trySetResult(null);
        }
    }

    static boolean isProxyNotificationEnabled(Context context) {
        if (!PlatformVersion.isAtLeastQ()) {
            return false;
        }
        if (allowedToUse(context)) {
            return "com.google.android.gms".equals(((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationDelegate());
        }
        context.getPackageName();
        return false;
    }

    private static boolean shouldEnableProxyNotification(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            Context applicationContext = context.getApplicationContext();
            PackageManager packageManager = applicationContext.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(MANIFEST_METADATA_NOTIFICATION_DELEGATION_ENABLED)) {
                return true;
            }
            return applicationInfo.metaData.getBoolean(MANIFEST_METADATA_NOTIFICATION_DELEGATION_ENABLED);
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    static void initialize(Context context) {
        if (ProxyNotificationPreferences.isProxyNotificationInitialized(context)) {
            return;
        }
        setEnableProxyNotification(new ProfileInstallReceiver$$ExternalSyntheticLambda0(), context, shouldEnableProxyNotification(context));
    }

    private static boolean allowedToUse(Context context) {
        return Binder.getCallingUid() == context.getApplicationInfo().uid;
    }
}
