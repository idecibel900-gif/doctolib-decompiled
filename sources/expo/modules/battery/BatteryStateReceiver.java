package expo.modules.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BatteryStateReceiver extends BroadcastReceiver {
    private final Function2 sendEvent;

    public BatteryStateReceiver(Function2 sendEvent) {
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        this.sendEvent = sendEvent;
    }

    private final void onBatteryStateChange(BatteryModule.BatteryState batteryState) {
        Function2 function2 = this.sendEvent;
        Bundle bundle = new Bundle();
        bundle.putInt("batteryState", batteryState.getValue());
        Unit unit = Unit.INSTANCE;
        function2.invoke("Expo.batteryStateDidChange", bundle);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        onBatteryStateChange(BatteryStatusNativeToJSKt.batteryStatusNativeToJS(intent.getIntExtra("status", -1)));
    }
}
