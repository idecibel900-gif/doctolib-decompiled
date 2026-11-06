package com.swmansion.rnscreens.utils;

import android.content.Context;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes4.dex */
public final class DeviceUtils {
    public static final DeviceUtils INSTANCE = new DeviceUtils();

    private DeviceUtils() {
    }

    public final boolean isPlatformAndroidTV(Context context) {
        PackageManager packageManager;
        return (context == null || (packageManager = context.getPackageManager()) == null || !packageManager.hasSystemFeature("android.software.leanback")) ? false : true;
    }
}
