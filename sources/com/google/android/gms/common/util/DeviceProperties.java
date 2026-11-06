package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DeviceProperties {
    private static Boolean zzf;
    private static Boolean zzg;
    private static Boolean zzj;
    private static Boolean zzl;

    public static boolean isAuto(Context context) {
        return zze(context.getPackageManager());
    }

    public static boolean isUserBuild() {
        int i = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        return "user".equals(Build.TYPE);
    }

    public static boolean isWearable(Context context) {
        return zzb(context.getPackageManager());
    }

    public static boolean isWearableWithoutPlayStore(Context context) {
        if (isWearable(context) && !PlatformVersion.isAtLeastN()) {
            return true;
        }
        if (zzc(context)) {
            return !PlatformVersion.isAtLeastO() || PlatformVersion.isAtLeastR();
        }
        return false;
    }

    public static boolean zzb(PackageManager packageManager) {
        if (zzf == null) {
            zzf = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return zzf.booleanValue();
    }

    public static boolean zzc(Context context) {
        if (zzg == null) {
            zzg = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return zzg.booleanValue();
    }

    public static boolean zzd(Context context) {
        if (zzj == null) {
            zzj = Boolean.valueOf(PlatformVersion.isAtLeastO() ? context.getPackageManager().hasSystemFeature("android.hardware.type.embedded") : context.getPackageManager().hasSystemFeature("android.hardware.type.iot"));
        }
        return zzj.booleanValue();
    }

    public static boolean zze(PackageManager packageManager) {
        if (zzl == null) {
            boolean z = false;
            if (PlatformVersion.isAtLeastO() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z = true;
            }
            zzl = Boolean.valueOf(z);
        }
        return zzl.booleanValue();
    }
}
