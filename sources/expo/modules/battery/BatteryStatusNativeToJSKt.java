package expo.modules.battery;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BatteryStatusNativeToJSKt {
    public static final BatteryModule.BatteryState batteryStatusNativeToJS(int i) {
        if (i == 2) {
            return BatteryModule.BatteryState.CHARGING;
        }
        if (i == 3) {
            return BatteryModule.BatteryState.UNPLUGGED;
        }
        if (i == 4) {
            return BatteryModule.BatteryState.UNPLUGGED;
        }
        if (i == 5) {
            return BatteryModule.BatteryState.FULL;
        }
        return BatteryModule.BatteryState.UNKNOWN;
    }
}
