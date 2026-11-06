package expo.modules.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BatteryLevelReceiver extends BroadcastReceiver {
    private final Function2 sendEvent;

    public BatteryLevelReceiver(Function2 sendEvent) {
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        this.sendEvent = sendEvent;
    }

    private final void onBatteryLevelChange(float f) {
        Function2 function2 = this.sendEvent;
        Bundle bundle = new Bundle();
        bundle.putFloat("batteryLevel", f);
        Unit unit = Unit.INSTANCE;
        function2.invoke("Expo.batteryLevelDidChange", bundle);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intent intentRegisterReceiver = context.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            return;
        }
        int intExtra = intentRegisterReceiver.getIntExtra("level", -1);
        int intExtra2 = intentRegisterReceiver.getIntExtra("scale", -1);
        onBatteryLevelChange((intExtra == -1 || intExtra2 == -1) ? -1.0f : intExtra / intExtra2);
    }
}
