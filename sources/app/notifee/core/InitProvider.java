package app.notifee.core;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Trace;
import android.provider.Settings;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class InitProvider extends ContentProvider {
    private static final String PROVIDER_AUTHORITY = "notifee-init-provider";
    private static final String TAG = "InitProvider";

    static boolean shouldRescheduleAfterBoot(int i, int i2) {
        if (i == -1) {
            return true;
        }
        return (i2 == -1 || i == i2) ? false : true;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        if (providerInfo != null && !providerInfo.authority.endsWith(PROVIDER_AUTHORITY)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. This is most likely due to a missing applicationId variable in application's build.gradle.");
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    @KeepForSdk
    public boolean onCreate() {
        Trace.beginSection("notifee:InitProvider.onCreate");
        try {
            if (ContextHolder.getApplicationContext() == null) {
                Context context = getContext();
                if (context != null && context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                ContextHolder.setApplicationContext(context);
            }
            Context applicationContext = ContextHolder.getApplicationContext();
            if (applicationContext != null) {
                if (isWarmupEnabled(applicationContext)) {
                    dispatchWarmup(applicationContext);
                }
                dispatchBootCheck(applicationContext);
            }
            return false;
        } finally {
            Trace.endSection();
        }
    }

    private static boolean isWarmupEnabled(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            return bundle == null || bundle.getBoolean("notifee_init_warmup_enabled", true);
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private static void dispatchWarmup(final Context context) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: app.notifee.core.InitProvider$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return InitProvider.m2979$r8$lambda$FF6qNCLdSH6lflHmhiCSMFZWs0(runnable);
            }
        });
        executorServiceNewSingleThreadExecutor.submit(new Runnable() { // from class: app.notifee.core.InitProvider$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                WarmupHelper.runWarmup(context);
            }
        });
        executorServiceNewSingleThreadExecutor.shutdown();
    }

    /* JADX INFO: renamed from: $r8$lambda$FF6qNCLdSH6lflHmhiCSMFZ-Ws0, reason: not valid java name */
    public static /* synthetic */ Thread m2979$r8$lambda$FF6qNCLdSH6lflHmhiCSMFZWs0(Runnable runnable) {
        Thread thread = new Thread(runnable, "notifee-init-warmup");
        thread.setDaemon(true);
        thread.setPriority(1);
        return thread;
    }

    private static void dispatchBootCheck(final Context context) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: app.notifee.core.InitProvider$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return InitProvider.$r8$lambda$EgDMPxENd5sQNTILgCOYaSoQSgs(runnable);
            }
        });
        executorServiceNewSingleThreadExecutor.submit(new Runnable() { // from class: app.notifee.core.InitProvider$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                InitProvider.runBootCheck(context);
            }
        });
        executorServiceNewSingleThreadExecutor.shutdown();
    }

    public static /* synthetic */ Thread $r8$lambda$EgDMPxENd5sQNTILgCOYaSoQSgs(Runnable runnable) {
        Thread thread = new Thread(runnable, "notifee-boot-check");
        thread.setDaemon(true);
        thread.setPriority(1);
        return thread;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void runBootCheck(Context context) {
        try {
            int bootCount = readBootCount(context);
            int intValue = Preferences.getSharedInstance().getIntValue("notifee_last_known_boot_count", -1);
            boolean zShouldRescheduleAfterBoot = shouldRescheduleAfterBoot(bootCount, intValue);
            if (bootCount == -1 && intValue == -1) {
                Logger.i(TAG, "BOOT_COUNT unavailable on first run; running conservative reschedule");
            } else if (bootCount == -1) {
                Logger.i(TAG, "BOOT_COUNT unavailable; running conservative reschedule to be safe");
            } else if (intValue == -1) {
                Logger.i(TAG, "First run: recording BOOT_COUNT baseline " + bootCount);
            } else if (bootCount != intValue) {
                Logger.i(TAG, "Boot detected since last run (" + intValue + " -> " + bootCount + "), rescheduling");
            }
            if (bootCount != -1) {
                Preferences.getSharedInstance().setIntValue("notifee_last_known_boot_count", bootCount);
            }
            if (zShouldRescheduleAfterBoot) {
                new NotifeeAlarmManager().rescheduleNotifications(null);
            }
        } catch (Throwable th) {
            Logger.e(TAG, "Cold-start reschedule check failed", th);
        }
    }

    private static int readBootCount(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "boot_count", -1);
        } catch (Throwable th) {
            Logger.w(TAG, "Failed to read Settings.Global.BOOT_COUNT", th);
            return -1;
        }
    }
}
