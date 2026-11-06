package com.datadog.android.rum.internal.domain.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.datadog.android.rum.internal.domain.InfoProvider;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultBatteryInfoProvider implements InfoProvider {
    private static final Companion Companion = new Companion(null);
    private final Context applicationContext;
    private volatile Float batteryLevel;
    private final int batteryLevelPollInterval;
    private final BatteryManager batteryManager;
    private AtomicLong lastTimeBatteryLevelChecked;
    private volatile Boolean lowPowerMode;
    private final PowerManager powerManager;
    private final DefaultBatteryInfoProvider$powerSaveModeReceiver$1 powerSaveModeReceiver;
    private final SystemClockWrapper systemClockWrapper;

    private final float normalizeBatteryLevel(int i) {
        return i / 100.0f;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.datadog.android.rum.internal.domain.battery.DefaultBatteryInfoProvider$powerSaveModeReceiver$1] */
    public DefaultBatteryInfoProvider(Context applicationContext, PowerManager powerManager, BatteryManager batteryManager, int i, SystemClockWrapper systemClockWrapper) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(systemClockWrapper, "systemClockWrapper");
        this.applicationContext = applicationContext;
        this.powerManager = powerManager;
        this.batteryManager = batteryManager;
        this.batteryLevelPollInterval = i;
        this.systemClockWrapper = systemClockWrapper;
        this.lastTimeBatteryLevelChecked = new AtomicLong(systemClockWrapper.elapsedRealTime());
        this.powerSaveModeReceiver = new BroadcastReceiver() { // from class: com.datadog.android.rum.internal.domain.battery.DefaultBatteryInfoProvider$powerSaveModeReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                PowerManager powerManager2 = this.this$0.powerManager;
                Boolean boolValueOf = powerManager2 != null ? Boolean.valueOf(powerManager2.isPowerSaveMode()) : null;
                if (boolValueOf != null) {
                    this.this$0.setLowPowerMode(boolValueOf);
                }
            }
        };
        registerReceivers();
        buildInitialState();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DefaultBatteryInfoProvider(Context context, PowerManager powerManager, BatteryManager batteryManager, int i, SystemClockWrapper systemClockWrapper, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != 0) {
            Object systemService = context.getSystemService("power");
            powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        }
        PowerManager powerManager2 = powerManager;
        if ((i2 & 4) != 0) {
            Object systemService2 = context.getSystemService("batterymanager");
            batteryManager = systemService2 instanceof BatteryManager ? (BatteryManager) systemService2 : null;
        }
        this(context, powerManager2, batteryManager, (i2 & 8) != 0 ? 60000 : i, (i2 & 16) != 0 ? new SystemClockWrapper() : systemClockWrapper);
    }

    public final void setLowPowerMode(Boolean bool) {
        this.lowPowerMode = bool;
    }

    @Override // com.datadog.android.rum.internal.domain.InfoProvider
    public synchronized BatteryInfo getState() {
        try {
            long jElapsedRealTime = this.systemClockWrapper.elapsedRealTime();
            if (jElapsedRealTime - ((long) this.batteryLevelPollInterval) >= this.lastTimeBatteryLevelChecked.get()) {
                this.lastTimeBatteryLevelChecked.set(jElapsedRealTime);
                Float fResolveBatteryLevel = resolveBatteryLevel();
                if (fResolveBatteryLevel != null) {
                    this.batteryLevel = Float.valueOf(fResolveBatteryLevel.floatValue());
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return new BatteryInfo(this.batteryLevel, this.lowPowerMode);
    }

    @Override // com.datadog.android.rum.internal.domain.InfoProvider
    public void cleanup() {
        safeUnregisterReceiver(this.powerSaveModeReceiver);
    }

    private final void safeUnregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            this.applicationContext.unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException unused) {
        }
    }

    private final void buildInitialState() {
        this.lowPowerMode = resolveLowPowerMode();
        this.batteryLevel = resolveBatteryLevel();
    }

    private final void registerReceivers() {
        this.applicationContext.registerReceiver(this.powerSaveModeReceiver, new IntentFilter("android.os.action.POWER_SAVE_MODE_CHANGED"));
    }

    private final Boolean resolveLowPowerMode() {
        PowerManager powerManager = this.powerManager;
        if (powerManager != null) {
            return Boolean.valueOf(powerManager.isPowerSaveMode());
        }
        return null;
    }

    private final Float resolveBatteryLevel() {
        BatteryManager batteryManager = this.batteryManager;
        Integer numValueOf = batteryManager != null ? Integer.valueOf(batteryManager.getIntProperty(4)) : null;
        if (numValueOf == null) {
            return null;
        }
        int iIntValue = numValueOf.intValue();
        if (iIntValue == (Build.VERSION.SDK_INT > 28 ? LinearLayoutManager.INVALID_OFFSET : 0)) {
            return null;
        }
        return Float.valueOf(normalizeBatteryLevel(iIntValue));
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
