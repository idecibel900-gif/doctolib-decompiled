package com.opentok.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.PowerManager;

/* JADX INFO: loaded from: classes4.dex */
public class PermissionsUtils {
    static boolean isBatteryOptimizationIgnored(Context context) {
        return ((PowerManager) context.getSystemService("power")).isIgnoringBatteryOptimizations(context.getPackageName());
    }

    public static void requestBatteryOptimizationIntent(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        String packageName = context.getPackageName();
        if (powerManager.isIgnoringBatteryOptimizations(packageName)) {
            return;
        }
        Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        intent.setData(Uri.parse("package:" + packageName));
        if (context instanceof Activity) {
            ((Activity) context).startActivity(intent);
        }
    }
}
