package com.datadog.android.core.internal.system;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.receiver.ThreadSafeReceiver;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes3.dex */
public final class BroadcastReceiverSystemInfoProvider extends ThreadSafeReceiver implements SystemInfoProvider {
    private final InternalLogger internalLogger;
    private SystemInfo systemInfo;
    public static final Companion Companion = new Companion(null);
    private static final Set batteryFullOrChargingStatus = SetsKt.setOf((Object[]) new SystemInfo.BatteryStatus[]{SystemInfo.BatteryStatus.CHARGING, SystemInfo.BatteryStatus.FULL});
    private static final Set PLUGGED_IN_STATUS_VALUES = SetsKt.setOf((Object[]) new Integer[]{1, 4, 2});

    public BroadcastReceiverSystemInfoProvider(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
        this.systemInfo = new SystemInfo(false, 0, false, false, 15, null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        Intrinsics.checkNotNullParameter(context, "context");
        if (intent != null) {
            try {
                action = intent.getAction();
            } catch (RuntimeException e) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.core.internal.system.BroadcastReceiverSystemInfoProvider.onReceive.2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Error handling system info broadcast intent.";
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
                return;
            }
        } else {
            action = null;
        }
        if (Intrinsics.areEqual(action, "android.intent.action.BATTERY_CHANGED")) {
            handleBatteryIntent(intent);
        } else if (Intrinsics.areEqual(action, "android.os.action.POWER_SAVE_MODE_CHANGED")) {
            handlePowerSaveIntent(context);
        } else {
            final String str = action;
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.DEBUG, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.system.BroadcastReceiverSystemInfoProvider.onReceive.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Received unknown broadcast intent: [" + str + "]";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
    }

    @Override // com.datadog.android.core.internal.system.SystemInfoProvider
    public void register(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        registerIntentFilter(context, "android.intent.action.BATTERY_CHANGED");
        registerIntentFilter(context, "android.os.action.POWER_SAVE_MODE_CHANGED");
    }

    @Override // com.datadog.android.core.internal.system.SystemInfoProvider
    public void unregister(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        unregisterReceiver(context);
    }

    @Override // com.datadog.android.core.internal.system.SystemInfoProvider
    public SystemInfo getLatestSystemInfo() {
        return this.systemInfo;
    }

    private final void registerIntentFilter(Context context, String str) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        Intent intentRegisterReceiver = registerReceiver(context, intentFilter);
        if (intentRegisterReceiver != null) {
            onReceive(context, intentRegisterReceiver);
        }
    }

    private final void handleBatteryIntent(Intent intent) {
        boolean z = true;
        int intExtra = intent.getIntExtra("status", 1);
        int intExtra2 = intent.getIntExtra("level", -1);
        int intExtra3 = intent.getIntExtra("scale", 100);
        int intExtra4 = intent.getIntExtra("plugged", -1);
        SystemInfo.BatteryStatus batteryStatusFromAndroidStatus = SystemInfo.BatteryStatus.Companion.fromAndroidStatus(intExtra);
        boolean booleanExtra = intent.getBooleanExtra("present", true);
        int iRoundToInt = MathKt.roundToInt((intExtra2 * 100.0f) / intExtra3);
        if (!PLUGGED_IN_STATUS_VALUES.contains(Integer.valueOf(intExtra4)) && booleanExtra) {
            z = false;
        }
        this.systemInfo = SystemInfo.copy$default(this.systemInfo, batteryFullOrChargingStatus.contains(batteryStatusFromAndroidStatus), iRoundToInt, false, z, 4, null);
    }

    private final void handlePowerSaveIntent(Context context) {
        Object systemService = context.getSystemService("power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        this.systemInfo = SystemInfo.copy$default(this.systemInfo, false, 0, powerManager != null ? powerManager.isPowerSaveMode() : false, false, 11, null);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
