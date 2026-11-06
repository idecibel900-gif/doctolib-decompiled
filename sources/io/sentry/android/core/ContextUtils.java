package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.util.AndroidLazyEvaluator;
import io.sentry.protocol.App;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ContextUtils {
    private static final AndroidLazyEvaluator staticPackageInfo33 = new AndroidLazyEvaluator(new AndroidLazyEvaluator.AndroidEvaluator() { // from class: io.sentry.android.core.ContextUtils$$ExternalSyntheticLambda1
        @Override // io.sentry.android.core.util.AndroidLazyEvaluator.AndroidEvaluator
        public final Object evaluate(Context context) {
            return ContextUtils.$r8$lambda$ha3xvwncWzUQ35qlZdJubyJWSiI(context);
        }
    });
    private static final AndroidLazyEvaluator staticPackageInfo = new AndroidLazyEvaluator(new AndroidLazyEvaluator.AndroidEvaluator() { // from class: io.sentry.android.core.ContextUtils$$ExternalSyntheticLambda2
        @Override // io.sentry.android.core.util.AndroidLazyEvaluator.AndroidEvaluator
        public final Object evaluate(Context context) {
            return ContextUtils.$r8$lambda$RBnQjC1S_BFAZwf7p_O1WfW6sxc(context);
        }
    });
    private static final AndroidLazyEvaluator applicationName = new AndroidLazyEvaluator(new AndroidLazyEvaluator.AndroidEvaluator() { // from class: io.sentry.android.core.ContextUtils$$ExternalSyntheticLambda3
        @Override // io.sentry.android.core.util.AndroidLazyEvaluator.AndroidEvaluator
        public final Object evaluate(Context context) {
            return ContextUtils.$r8$lambda$C9bKRXq4hDZaGeX3Xp6o_avLB2w(context);
        }
    });
    private static final AndroidLazyEvaluator staticAppInfo33 = new AndroidLazyEvaluator(new AndroidLazyEvaluator.AndroidEvaluator() { // from class: io.sentry.android.core.ContextUtils$$ExternalSyntheticLambda4
        @Override // io.sentry.android.core.util.AndroidLazyEvaluator.AndroidEvaluator
        public final Object evaluate(Context context) {
            return ContextUtils.$r8$lambda$SMzOBxVCN5CwF7yf0rKk05RJntY(context);
        }
    });
    private static final AndroidLazyEvaluator staticAppInfo = new AndroidLazyEvaluator(new AndroidLazyEvaluator.AndroidEvaluator() { // from class: io.sentry.android.core.ContextUtils$$ExternalSyntheticLambda5
        @Override // io.sentry.android.core.util.AndroidLazyEvaluator.AndroidEvaluator
        public final Object evaluate(Context context) {
            return ContextUtils.$r8$lambda$q9rYJvAOeesY655grfOSzb9xsQ8(context);
        }
    });

    static class SideLoadedInfo {
        private final String installerStore;
        private final boolean isSideLoaded;

        public SideLoadedInfo(boolean z, String str) {
            this.isSideLoaded = z;
            this.installerStore = str;
        }

        public Map asTags() {
            HashMap map = new HashMap();
            map.put("isSideLoaded", String.valueOf(this.isSideLoaded));
            String str = this.installerStore;
            if (str != null) {
                map.put("installerStore", str);
            }
            return map;
        }
    }

    static class SplitApksInfo {
        private final boolean isSplitApks;
        private final String[] splitNames;

        public SplitApksInfo(boolean z, String[] strArr) {
            this.isSplitApks = z;
            this.splitNames = strArr;
        }

        public boolean isSplitApks() {
            return this.isSplitApks;
        }

        public String[] getSplitNames() {
            return this.splitNames;
        }
    }

    public static /* synthetic */ PackageInfo $r8$lambda$ha3xvwncWzUQ35qlZdJubyJWSiI(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* synthetic */ PackageInfo $r8$lambda$RBnQjC1S_BFAZwf7p_O1WfW6sxc(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* synthetic */ String $r8$lambda$C9bKRXq4hDZaGeX3Xp6o_avLB2w(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            if (i == 0) {
                CharSequence charSequence = applicationInfo.nonLocalizedLabel;
                if (charSequence != null) {
                    return charSequence.toString();
                }
                return context.getPackageManager().getApplicationLabel(applicationInfo).toString();
            }
            return context.getString(i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* synthetic */ ApplicationInfo $r8$lambda$SMzOBxVCN5CwF7yf0rKk05RJntY(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.ApplicationInfoFlags.of(128L));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* synthetic */ ApplicationInfo $r8$lambda$q9rYJvAOeesY655grfOSzb9xsQ8(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (Throwable unused) {
            return null;
        }
    }

    static PackageInfo getPackageInfo(Context context, BuildInfoProvider buildInfoProvider) {
        if (buildInfoProvider.getSdkInfoVersion() >= 33) {
            return (PackageInfo) staticPackageInfo33.getValue(context);
        }
        return (PackageInfo) staticPackageInfo.getValue(context);
    }

    static PackageInfo getPackageInfo(Context context, int i, ILogger iLogger, BuildInfoProvider buildInfoProvider) {
        try {
            if (buildInfoProvider.getSdkInfoVersion() >= 33) {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(i));
            }
            return context.getPackageManager().getPackageInfo(context.getPackageName(), i);
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Error getting package info.", th);
            return null;
        }
    }

    static ApplicationInfo getApplicationInfo(Context context, BuildInfoProvider buildInfoProvider) {
        if (buildInfoProvider.getSdkInfoVersion() >= 33) {
            return (ApplicationInfo) staticAppInfo33.getValue(context);
        }
        return (ApplicationInfo) staticAppInfo.getValue(context);
    }

    static String getVersionCode(PackageInfo packageInfo, BuildInfoProvider buildInfoProvider) {
        if (buildInfoProvider.getSdkInfoVersion() >= 28) {
            return Long.toString(packageInfo.getLongVersionCode());
        }
        return getVersionCodeDep(packageInfo);
    }

    private static String getVersionCodeDep(PackageInfo packageInfo) {
        return Integer.toString(packageInfo.versionCode);
    }

    public static boolean isForegroundImportance() {
        try {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            return runningAppProcessInfo.importance == 100;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean appIsLibraryForComposePreview(Context context) {
        if (!context.getPackageName().endsWith(".test")) {
            return false;
        }
        try {
            Iterator<ActivityManager.AppTask> it = ((ActivityManager) context.getSystemService("activity")).getAppTasks().iterator();
            while (it.hasNext()) {
                ComponentName component = it.next().getTaskInfo().baseIntent.getComponent();
                if (component != null && component.getClassName().equals("androidx.compose.ui.tooling.PreviewActivity")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    static String getKernelVersion(ILogger iLogger) {
        String property = System.getProperty("os.version");
        File file = new File("/proc/version");
        if (!file.canRead()) {
            return property;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                return line;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            iLogger.log(SentryLevel.ERROR, "Exception while attempting to read kernel information", e);
            return property;
        }
    }

    static SideLoadedInfo retrieveSideLoadedInfo(Context context, ILogger iLogger, BuildInfoProvider buildInfoProvider) {
        String str;
        try {
            PackageInfo packageInfo = getPackageInfo(context, buildInfoProvider);
            PackageManager packageManager = context.getPackageManager();
            if (packageInfo != null && packageManager != null) {
                str = packageInfo.packageName;
                try {
                    String installerPackageName = packageManager.getInstallerPackageName(str);
                    return new SideLoadedInfo(installerPackageName == null, installerPackageName);
                } catch (IllegalArgumentException unused) {
                    iLogger.log(SentryLevel.DEBUG, "%s package isn't installed.", str);
                    return null;
                }
            }
        } catch (IllegalArgumentException unused2) {
            str = null;
        }
        return null;
    }

    static SplitApksInfo retrieveSplitApksInfo(Context context, BuildInfoProvider buildInfoProvider) {
        Bundle bundle;
        ApplicationInfo applicationInfo = getApplicationInfo(context, buildInfoProvider);
        PackageInfo packageInfo = getPackageInfo(context, buildInfoProvider);
        if (packageInfo == null) {
            return null;
        }
        return new SplitApksInfo((applicationInfo == null || (bundle = applicationInfo.metaData) == null) ? false : bundle.getBoolean("com.android.vending.splits.required"), packageInfo.splitNames);
    }

    static String getApplicationName(Context context) {
        return (String) applicationName.getValue(context);
    }

    static DisplayMetrics getDisplayMetrics(Context context, ILogger iLogger) {
        try {
            return context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Error getting DisplayMetrics.", th);
            return null;
        }
    }

    static String getFamily(ILogger iLogger) {
        try {
            return Build.MODEL.split(" ", -1)[0];
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Error getting device family.", th);
            return null;
        }
    }

    static String[] getArchitectures() {
        return Build.SUPPORTED_ABIS;
    }

    static ActivityManager.MemoryInfo getMemInfo(Context context, ILogger iLogger) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager == null) {
                iLogger.log(SentryLevel.INFO, "Error getting MemoryInfo.", new Object[0]);
                return null;
            }
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo;
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Error getting MemoryInfo.", th);
            return null;
        }
    }

    static Intent registerReceiver(Context context, SentryOptions sentryOptions, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, Handler handler) {
        return registerReceiver(context, new BuildInfoProvider(sentryOptions.getLogger()), broadcastReceiver, intentFilter, handler);
    }

    static Intent registerReceiver(Context context, BuildInfoProvider buildInfoProvider, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, Handler handler) {
        if (buildInfoProvider.getSdkInfoVersion() >= 33) {
            return context.registerReceiver(broadcastReceiver, intentFilter, null, handler, 4);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, null, handler);
    }

    static void setAppPackageInfo(PackageInfo packageInfo, BuildInfoProvider buildInfoProvider, DeviceInfoUtil deviceInfoUtil, App app2) {
        app2.setAppIdentifier(packageInfo.packageName);
        app2.setAppVersion(packageInfo.versionName);
        app2.setAppBuild(getVersionCode(packageInfo, buildInfoProvider));
        HashMap map = new HashMap();
        String[] strArr = packageInfo.requestedPermissions;
        int[] iArr = packageInfo.requestedPermissionsFlags;
        if (strArr != null && strArr.length > 0 && iArr != null && iArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                map.put(str.substring(str.lastIndexOf(46) + 1), (iArr[i] & 2) == 2 ? "granted" : "not_granted");
            }
        }
        app2.setPermissions(map);
        if (deviceInfoUtil != null) {
            try {
                SplitApksInfo splitApksInfo = deviceInfoUtil.getSplitApksInfo();
                if (splitApksInfo != null) {
                    app2.setSplitApks(Boolean.valueOf(splitApksInfo.isSplitApks()));
                    if (splitApksInfo.getSplitNames() != null) {
                        app2.setSplitNames(Arrays.asList(splitApksInfo.getSplitNames()));
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static Context getApplicationContext(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }
}
