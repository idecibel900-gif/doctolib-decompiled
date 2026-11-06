package com.datadog.android.rum.internal.domain.battery;

import com.datadog.android.rum.internal.domain.InfoData;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BatteryInfo implements InfoData {
    private final Float batteryLevel;
    private final Boolean lowPowerMode;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BatteryInfo)) {
            return false;
        }
        BatteryInfo batteryInfo = (BatteryInfo) obj;
        return Intrinsics.areEqual(this.batteryLevel, batteryInfo.batteryLevel) && Intrinsics.areEqual(this.lowPowerMode, batteryInfo.lowPowerMode);
    }

    public int hashCode() {
        Float f = this.batteryLevel;
        int iHashCode = (f == null ? 0 : f.hashCode()) * 31;
        Boolean bool = this.lowPowerMode;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "BatteryInfo(batteryLevel=" + this.batteryLevel + ", lowPowerMode=" + this.lowPowerMode + ")";
    }

    public BatteryInfo(Float f, Boolean bool) {
        this.batteryLevel = f;
        this.lowPowerMode = bool;
    }

    public /* synthetic */ BatteryInfo(Float f, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : f, (i & 2) != 0 ? null : bool);
    }

    public final Float getBatteryLevel() {
        return this.batteryLevel;
    }

    public final Boolean getLowPowerMode() {
        return this.lowPowerMode;
    }
}
