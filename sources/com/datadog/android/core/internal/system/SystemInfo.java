package com.datadog.android.core.internal.system;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class SystemInfo {
    private final boolean batteryFullOrCharging;
    private final int batteryLevel;
    private final boolean onExternalPowerSource;
    private final boolean powerSaveMode;

    public static /* synthetic */ SystemInfo copy$default(SystemInfo systemInfo, boolean z, int i, boolean z2, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = systemInfo.batteryFullOrCharging;
        }
        if ((i2 & 2) != 0) {
            i = systemInfo.batteryLevel;
        }
        if ((i2 & 4) != 0) {
            z2 = systemInfo.powerSaveMode;
        }
        if ((i2 & 8) != 0) {
            z3 = systemInfo.onExternalPowerSource;
        }
        return systemInfo.copy(z, i, z2, z3);
    }

    public final SystemInfo copy(boolean z, int i, boolean z2, boolean z3) {
        return new SystemInfo(z, i, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SystemInfo)) {
            return false;
        }
        SystemInfo systemInfo = (SystemInfo) obj;
        return this.batteryFullOrCharging == systemInfo.batteryFullOrCharging && this.batteryLevel == systemInfo.batteryLevel && this.powerSaveMode == systemInfo.powerSaveMode && this.onExternalPowerSource == systemInfo.onExternalPowerSource;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.batteryFullOrCharging) * 31) + Integer.hashCode(this.batteryLevel)) * 31) + Boolean.hashCode(this.powerSaveMode)) * 31) + Boolean.hashCode(this.onExternalPowerSource);
    }

    public String toString() {
        return "SystemInfo(batteryFullOrCharging=" + this.batteryFullOrCharging + ", batteryLevel=" + this.batteryLevel + ", powerSaveMode=" + this.powerSaveMode + ", onExternalPowerSource=" + this.onExternalPowerSource + ")";
    }

    public SystemInfo(boolean z, int i, boolean z2, boolean z3) {
        this.batteryFullOrCharging = z;
        this.batteryLevel = i;
        this.powerSaveMode = z2;
        this.onExternalPowerSource = z3;
    }

    public /* synthetic */ SystemInfo(boolean z, int i, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? -1 : i, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? false : z3);
    }

    public final boolean getBatteryFullOrCharging() {
        return this.batteryFullOrCharging;
    }

    public final int getBatteryLevel() {
        return this.batteryLevel;
    }

    public final boolean getPowerSaveMode() {
        return this.powerSaveMode;
    }

    public final boolean getOnExternalPowerSource() {
        return this.onExternalPowerSource;
    }

    public enum BatteryStatus {
        UNKNOWN,
        CHARGING,
        DISCHARGING,
        NOT_CHARGING,
        FULL;

        public static final Companion Companion = new Companion(null);

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final BatteryStatus fromAndroidStatus(int i) {
                if (i == 2) {
                    return BatteryStatus.CHARGING;
                }
                if (i == 3) {
                    return BatteryStatus.DISCHARGING;
                }
                if (i == 4) {
                    return BatteryStatus.NOT_CHARGING;
                }
                if (i == 5) {
                    return BatteryStatus.FULL;
                }
                return BatteryStatus.UNKNOWN;
            }
        }
    }
}
