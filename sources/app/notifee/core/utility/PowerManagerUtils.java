package app.notifee.core.utility;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import app.notifee.core.ContextHolder;
import app.notifee.core.Logger;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PowerManagerUtils {
    private static volatile Intent sPowerManagerIntentCache;

    public static void setPowerManagerIntentCache(Intent intent) {
        synchronized (PowerManagerUtils.class) {
            sPowerManagerIntentCache = intent;
        }
    }

    public static Intent getPowerManagerIntent() {
        Intent intent;
        synchronized (PowerManagerUtils.class) {
            intent = sPowerManagerIntentCache;
        }
        return intent;
    }

    public static void openBatteryOptimizationSettings(Activity activity) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
            intent.setFlags(268435456);
            if (activity != null) {
                IntentUtils.startActivityOnUiThread(activity, intent);
            }
        } catch (Exception e) {
            Logger.e("PowerManagerUtils", "An error occurred whilst trying to open battery optimization settings", e);
        }
    }

    public static Boolean isBatteryOptimizationEnabled(Context context) {
        return Boolean.valueOf(!((PowerManager) context.getSystemService("power")).isIgnoringBatteryOptimizations(context.getPackageName()));
    }

    public static void lightUpScreenIfNeeded(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager.isInteractive()) {
            return;
        }
        powerManager.newWakeLock(805306394, "Notifee:lock").acquire(3000L);
        powerManager.newWakeLock(1, "Notifee:cpuLock").acquire(3000L);
    }

    public static PowerManagerInfo getPowerManagerInfo() {
        return new PowerManagerInfo(Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, IntentUtils.getActivityName(getFirstPowerManagerIntent()));
    }

    public static void openPowerManagerSettings(Activity activity) {
        if (activity == null) {
            Logger.w("PowerManagerUtils", "Activity is null when trying to open the device's power manager");
            return;
        }
        final Context applicationContext = ContextHolder.getApplicationContext();
        if (applicationContext == null) {
            Logger.w("PowerManagerUtils", "Unable to get application context when opening the device's power manager");
            return;
        }
        final List powerManagerIntentCandidates = getPowerManagerIntentCandidates();
        if (powerManagerIntentCandidates.isEmpty()) {
            Logger.w("PowerManagerUtils", "Unable to find an activity to open the device's power manager");
        } else {
            activity.runOnUiThread(new Runnable() { // from class: app.notifee.core.utility.PowerManagerUtils$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PowerManagerUtils.$r8$lambda$jhmsMBJkRKPkFrvsvp1mXtqhqMY(powerManagerIntentCandidates, applicationContext);
                }
            });
        }
    }

    public static /* synthetic */ void $r8$lambda$jhmsMBJkRKPkFrvsvp1mXtqhqMY(List list, Context context) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (startPowerManagerIntent(context, (Intent) it.next())) {
                return;
            }
        }
        Logger.w("PowerManagerUtils", "Unable to open the device's power manager");
    }

    private static Intent getFirstPowerManagerIntent() {
        List manufacturerPowerManagerIntents = getManufacturerPowerManagerIntents(getManufacturerName());
        if (manufacturerPowerManagerIntents.isEmpty()) {
            return null;
        }
        return (Intent) manufacturerPowerManagerIntents.get(0);
    }

    private static List getPowerManagerIntentCandidates() {
        ArrayList arrayList = new ArrayList();
        Intent powerManagerIntent = getPowerManagerIntent();
        if (powerManagerIntent != null) {
            arrayList.add(powerManagerIntent);
        }
        for (Intent intent : getManufacturerPowerManagerIntents(getManufacturerName())) {
            if (!containsEquivalentIntent(arrayList, intent)) {
                arrayList.add(intent);
            }
        }
        return arrayList;
    }

    private static String getManufacturerName() {
        return Build.BRAND.toLowerCase(Locale.US);
    }

    private static boolean containsEquivalentIntent(List list, Intent intent) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((Intent) it.next()).filterEquals(intent)) {
                return true;
            }
        }
        return false;
    }

    private static boolean startPowerManagerIntent(Context context, Intent intent) {
        Intent intent2 = new Intent(intent);
        intent2.setFlags(268435456);
        try {
            context.startActivity(intent2);
            setPowerManagerIntentCache(intent2);
            return true;
        } catch (ActivityNotFoundException e) {
            e = e;
            Logger.w("PowerManagerUtils", "Unable to start activity: " + IntentUtils.getActivityName(intent2), e);
            return false;
        } catch (SecurityException e2) {
            e = e2;
            Logger.w("PowerManagerUtils", "Unable to start activity: " + IntentUtils.getActivityName(intent2), e);
            return false;
        } catch (RuntimeException e3) {
            Logger.w("PowerManagerUtils", "Unable to start activity: " + IntentUtils.getActivityName(intent2), e3);
            return false;
        }
    }

    private static List getManufacturerPowerManagerIntents(String str) {
        ArrayList arrayList = new ArrayList();
        str.getClass();
        switch (str) {
            case "oneplus":
                return Arrays.asList(createIntent("com.oneplus.security", "com.oneplus.security.chainlaunch.view.ChainLaunchAppListActivity"));
            case "huawei":
                return Arrays.asList(createIntent("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity"), createIntent("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity"), createIntent("com.huawei.systemmanager", "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity"));
            case "xiaomi":
            case "redmi":
                return Arrays.asList(createIntent("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
            case "htc":
                return Arrays.asList(createIntent("com.htc.pitroad", "com.htc.pitroad.landingpage.activity.LandingPageActivity"));
            case "asus":
                return Arrays.asList(createIntent("com.asus.mobilemanager", "com.asus.mobilemanager.powersaver.PowerSaverSettings"), createIntent("com.asus.mobilemanager", "com.asus.mobilemanager.autostart.AutoStartActivity"), createIntent("com.asus.mobilemanager", "com.asus.mobilemanager.entry.FunctionActivity").setData(Uri.parse("mobilemanager://function/entry/AutoStart")));
            case "letv":
                return Arrays.asList(createIntent("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity").setData(Uri.parse("mobilemanager://function/entry/AutoStart")));
            case "oppo":
            case "coloros":
                return Arrays.asList(createIntent("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"), createIntent("com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity"), createIntent("com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity"), createIntent("com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerUsageModelActivity"), createIntent("com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerSaverModeActivity"), createIntent("com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerConsumptionActivity"));
            case "vivo":
                return Arrays.asList(createIntent("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity"), createIntent("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"), createIntent("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager"));
            case "honor":
                return Arrays.asList(createIntent("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity"));
            case "meizu":
                return Arrays.asList(createIntent("com.meizu.safe", "com.meizu.safe.security.SHOW_APPSEC").addCategory("android.intent.category.DEFAULT"));
            case "nokia":
                return Arrays.asList(createIntent("com.evenwell.powersaving.g3", "com.evenwell.powersaving.g3.exception.PowerSaverExceptionActivity"));
            case "samsung":
                return Arrays.asList(createIntent("com.samsung.android.lool", "com.samsung.android.sm.ui.battery.BatteryActivity"), createIntent("com.samsung.android.sm", "com.samsung.android.sm.ui.battery.BatteryActivity"), createIntent("com.samsung.android.lool", "com.samsung.android.sm.battery.ui.BatteryActivity"));
            default:
                return arrayList;
        }
    }

    private static Intent createIntent(String str, String str2) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        return intent;
    }

    public static class PowerManagerInfo {
        String activity;
        String manufacturer;
        String model;
        String version;

        public PowerManagerInfo(String str, String str2, String str3, String str4) {
            this.manufacturer = str;
            this.model = str2;
            this.version = str3;
            this.activity = str4;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putString("manufacturer", this.manufacturer);
            bundle.putString("model", this.model);
            bundle.putString(DiagnosticsEntry.VERSION_KEY, this.version);
            bundle.putString("activity", this.activity);
            return bundle;
        }
    }
}
