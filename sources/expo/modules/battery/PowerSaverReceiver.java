package expo.modules.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PowerSaverReceiver extends BroadcastReceiver {
    private final Function2 sendEvent;

    public PowerSaverReceiver(Function2 sendEvent) {
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        this.sendEvent = sendEvent;
    }

    private final void onLowPowerModeChange(boolean z) {
        Function2 function2 = this.sendEvent;
        Bundle bundle = new Bundle();
        bundle.putBoolean("lowPowerMode", z);
        Unit unit = Unit.INSTANCE;
        function2.invoke("Expo.powerModeDidChange", bundle);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Object systemService = context.getApplicationContext().getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        onLowPowerModeChange(((PowerManager) systemService).isPowerSaveMode());
    }
}
