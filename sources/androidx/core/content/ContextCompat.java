package androidx.core.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.ObjectsCompat;
import java.io.File;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContextCompat {
    private static final Object sSync = new Object();

    public static boolean startActivities(Context context, Intent[] intentArr, Bundle bundle) {
        context.startActivities(intentArr, bundle);
        return true;
    }

    public static void startActivity(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }

    public static File[] getExternalFilesDirs(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    public static File[] getExternalCacheDirs(Context context) {
        return context.getExternalCacheDirs();
    }

    public static Drawable getDrawable(Context context, int i) {
        return Api21Impl.getDrawable(context, i);
    }

    public static ColorStateList getColorStateList(Context context, int i) {
        return ResourcesCompat.getColorStateList(context.getResources(), i, context.getTheme());
    }

    public static int getColor(Context context, int i) {
        return Api23Impl.getColor(context, i);
    }

    public static int checkSelfPermission(Context context, String str) {
        ObjectsCompat.requireNonNull(str, "permission must be non-null");
        if (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        return NotificationManagerCompat.from(context).areNotificationsEnabled() ? 0 : -1;
    }

    public static File getNoBackupFilesDir(Context context) {
        return Api21Impl.getNoBackupFilesDir(context);
    }

    public static Context createDeviceProtectedStorageContext(Context context) {
        return Api24Impl.createDeviceProtectedStorageContext(context);
    }

    public static Executor getMainExecutor(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getMainExecutor(context);
        }
        return ExecutorCompat.create(new Handler(context.getMainLooper()));
    }

    public static void startForegroundService(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.startForegroundService(context, intent);
        } else {
            context.startService(intent);
        }
    }

    public static Object getSystemService(Context context, Class cls) {
        return Api23Impl.getSystemService(context, cls);
    }

    static class Api21Impl {
        static Drawable getDrawable(Context context, int i) {
            return context.getDrawable(i);
        }

        static File getNoBackupFilesDir(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    static class Api23Impl {
        static int getColor(Context context, int i) {
            return context.getColor(i);
        }

        static Object getSystemService(Context context, Class cls) {
            return context.getSystemService(cls);
        }
    }

    static class Api24Impl {
        static Context createDeviceProtectedStorageContext(Context context) {
            return context.createDeviceProtectedStorageContext();
        }
    }

    static class Api26Impl {
        static ComponentName startForegroundService(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    static class Api28Impl {
        static Executor getMainExecutor(Context context) {
            return context.getMainExecutor();
        }
    }
}
