package expo.modules.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PowerManager;
import androidx.tracing.Trace;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.Exceptions$ReactContextLost;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ConstantComponentBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.Enumerable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lexpo/modules/battery/BatteryModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "Landroid/content/Context;", "context", "", "unregisterBroadcastReceivers", "(Landroid/content/Context;)V", "registerBroadcastReceivers", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "definition", "()Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "", "Landroid/content/BroadcastReceiver;", "broadcastReceivers", "Ljava/util/List;", "getContext", "()Landroid/content/Context;", "", "isLowPowerModeEnabled", "()Z", "BatteryState", "expo-battery_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BatteryModule extends Module {
    private final List broadcastReceivers = new ArrayList();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lexpo/modules/battery/BatteryModule$BatteryState;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "UNPLUGGED", "CHARGING", "FULL", "expo-battery_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum BatteryState implements Enumerable {
        UNKNOWN(0),
        UNPLUGGED(1),
        CHARGING(2),
        FULL(3);

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final int value;

        public static EnumEntries getEntries() {
            return $ENTRIES;
        }

        BatteryState(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent stringAsyncFunctionComponent;
        AsyncFunctionComponent stringAsyncFunctionComponent2;
        AsyncFunctionComponent stringAsyncFunctionComponent3;
        AsyncFunctionComponent stringAsyncFunctionComponent4;
        Trace.beginSection("[ExpoModulesCore] " + (getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(this);
            moduleDefinitionBuilder.Name("ExpoBattery");
            ConstantComponentBuilder constantComponentBuilder = new ConstantComponentBuilder("isSupported");
            constantComponentBuilder.setGetter(new Function0() { // from class: expo.modules.battery.BatteryModule$definition$lambda$9$$inlined$Constant$1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.TRUE;
                }
            });
            moduleDefinitionBuilder.getConstants().put("isSupported", constantComponentBuilder);
            moduleDefinitionBuilder.Events("Expo.batteryLevelDidChange", "Expo.batteryStateDidChange", "Expo.powerModeDidChange");
            Map eventListeners = moduleDefinitionBuilder.getEventListeners();
            EventName eventName = EventName.MODULE_CREATE;
            eventListeners.put(eventName, new BasicEventListener(eventName, new Function0() { // from class: expo.modules.battery.BatteryModule$definition$lambda$9$$inlined$OnCreate$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m4864invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m4864invoke() {
                    BatteryModule batteryModule = this.this$0;
                    batteryModule.registerBroadcastReceivers(batteryModule.getContext());
                }
            }));
            Map eventListeners2 = moduleDefinitionBuilder.getEventListeners();
            EventName eventName2 = EventName.MODULE_DESTROY;
            eventListeners2.put(eventName2, new BasicEventListener(eventName2, new Function0() { // from class: expo.modules.battery.BatteryModule$definition$lambda$9$$inlined$OnDestroy$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m4865invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m4865invoke() {
                    BatteryModule batteryModule = this.this$0;
                    batteryModule.unregisterBroadcastReceivers(batteryModule.getContext());
                }
            }));
            Map eventListeners3 = moduleDefinitionBuilder.getEventListeners();
            EventName eventName3 = EventName.ACTIVITY_ENTERS_FOREGROUND;
            eventListeners3.put(eventName3, new BasicEventListener(eventName3, new Function0() { // from class: expo.modules.battery.BatteryModule$definition$lambda$9$$inlined$OnActivityEntersForeground$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m4863invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m4863invoke() {
                    BatteryModule batteryModule = this.this$0;
                    batteryModule.registerBroadcastReceivers(batteryModule.getContext());
                }
            }));
            Map eventListeners4 = moduleDefinitionBuilder.getEventListeners();
            EventName eventName4 = EventName.ACTIVITY_ENTERS_BACKGROUND;
            eventListeners4.put(eventName4, new BasicEventListener(eventName4, new Function0() { // from class: expo.modules.battery.BatteryModule$definition$lambda$9$$inlined$OnActivityEntersBackground$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m4862invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m4862invoke() {
                    BatteryModule batteryModule = this.this$0;
                    batteryModule.unregisterBroadcastReceivers(batteryModule.getContext());
                }
            }));
            AnyType[] anyTypeArr = new AnyType[0];
            Function1 function1 = new Function1() { // from class: expo.modules.battery.BatteryModule$definition$lambda$9$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Intent intentRegisterReceiver = this.this$0.getContext().getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                    float f = -1.0f;
                    if (intentRegisterReceiver != null) {
                        int intExtra = intentRegisterReceiver.getIntExtra("level", -1);
                        int intExtra2 = intentRegisterReceiver.getIntExtra("scale", -1);
                        if (intExtra != -1 && intExtra2 != -1) {
                            f = intExtra / intExtra2;
                        }
                    }
                    return Float.valueOf(f);
                }
            };
            Class cls = Integer.TYPE;
            boolean zAreEqual = Intrinsics.areEqual(Float.class, cls);
            Class cls2 = Float.TYPE;
            Class cls3 = Double.TYPE;
            Class cls4 = Boolean.TYPE;
            if (zAreEqual) {
                stringAsyncFunctionComponent = new IntAsyncFunctionComponent("getBatteryLevelAsync", anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Float.class, cls4)) {
                stringAsyncFunctionComponent = new BoolAsyncFunctionComponent("getBatteryLevelAsync", anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Float.class, cls3)) {
                stringAsyncFunctionComponent = new DoubleAsyncFunctionComponent("getBatteryLevelAsync", anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Float.class, cls2)) {
                stringAsyncFunctionComponent = new FloatAsyncFunctionComponent("getBatteryLevelAsync", anyTypeArr, function1);
            } else {
                stringAsyncFunctionComponent = Intrinsics.areEqual(Float.class, String.class) ? new StringAsyncFunctionComponent("getBatteryLevelAsync", anyTypeArr, function1) : new UntypedAsyncFunctionComponent("getBatteryLevelAsync", anyTypeArr, function1);
            }
            moduleDefinitionBuilder.getAsyncFunctions().put("getBatteryLevelAsync", stringAsyncFunctionComponent);
            AnyType[] anyTypeArr2 = new AnyType[0];
            Function1 function2 = new Function1() { // from class: expo.modules.battery.BatteryModule$definition$lambda$9$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    int value;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Intent intentRegisterReceiver = this.this$0.getContext().getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                    if (intentRegisterReceiver == null) {
                        value = BatteryModule.BatteryState.UNKNOWN.getValue();
                    } else {
                        value = BatteryStatusNativeToJSKt.batteryStatusNativeToJS(intentRegisterReceiver.getIntExtra("status", -1)).getValue();
                    }
                    return Integer.valueOf(value);
                }
            };
            if (Intrinsics.areEqual(Integer.class, cls)) {
                stringAsyncFunctionComponent2 = new IntAsyncFunctionComponent("getBatteryStateAsync", anyTypeArr2, function2);
            } else if (Intrinsics.areEqual(Integer.class, cls4)) {
                stringAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("getBatteryStateAsync", anyTypeArr2, function2);
            } else if (Intrinsics.areEqual(Integer.class, cls3)) {
                stringAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("getBatteryStateAsync", anyTypeArr2, function2);
            } else if (Intrinsics.areEqual(Integer.class, cls2)) {
                stringAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("getBatteryStateAsync", anyTypeArr2, function2);
            } else {
                stringAsyncFunctionComponent2 = Intrinsics.areEqual(Integer.class, String.class) ? new StringAsyncFunctionComponent("getBatteryStateAsync", anyTypeArr2, function2) : new UntypedAsyncFunctionComponent("getBatteryStateAsync", anyTypeArr2, function2);
            }
            moduleDefinitionBuilder.getAsyncFunctions().put("getBatteryStateAsync", stringAsyncFunctionComponent2);
            AnyType[] anyTypeArr3 = new AnyType[0];
            Function1 function3 = new Function1() { // from class: expo.modules.battery.BatteryModule$definition$lambda$9$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(this.this$0.isLowPowerModeEnabled());
                }
            };
            if (Intrinsics.areEqual(Boolean.class, cls)) {
                stringAsyncFunctionComponent3 = new IntAsyncFunctionComponent("isLowPowerModeEnabledAsync", anyTypeArr3, function3);
            } else if (Intrinsics.areEqual(Boolean.class, cls4)) {
                stringAsyncFunctionComponent3 = new BoolAsyncFunctionComponent("isLowPowerModeEnabledAsync", anyTypeArr3, function3);
            } else if (Intrinsics.areEqual(Boolean.class, cls3)) {
                stringAsyncFunctionComponent3 = new DoubleAsyncFunctionComponent("isLowPowerModeEnabledAsync", anyTypeArr3, function3);
            } else if (Intrinsics.areEqual(Boolean.class, cls2)) {
                stringAsyncFunctionComponent3 = new FloatAsyncFunctionComponent("isLowPowerModeEnabledAsync", anyTypeArr3, function3);
            } else {
                stringAsyncFunctionComponent3 = Intrinsics.areEqual(Boolean.class, String.class) ? new StringAsyncFunctionComponent("isLowPowerModeEnabledAsync", anyTypeArr3, function3) : new UntypedAsyncFunctionComponent("isLowPowerModeEnabledAsync", anyTypeArr3, function3);
            }
            moduleDefinitionBuilder.getAsyncFunctions().put("isLowPowerModeEnabledAsync", stringAsyncFunctionComponent3);
            AnyType[] anyTypeArr4 = new AnyType[0];
            Function1 function4 = new Function1() { // from class: expo.modules.battery.BatteryModule$definition$lambda$9$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    String packageName = this.this$0.getContext().getApplicationContext().getPackageName();
                    Object systemService = this.this$0.getContext().getApplicationContext().getSystemService("power");
                    PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
                    boolean z = false;
                    if (powerManager != null && !powerManager.isIgnoringBatteryOptimizations(packageName)) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            };
            if (Intrinsics.areEqual(Boolean.class, cls)) {
                stringAsyncFunctionComponent4 = new IntAsyncFunctionComponent("isBatteryOptimizationEnabledAsync", anyTypeArr4, function4);
            } else if (Intrinsics.areEqual(Boolean.class, cls4)) {
                stringAsyncFunctionComponent4 = new BoolAsyncFunctionComponent("isBatteryOptimizationEnabledAsync", anyTypeArr4, function4);
            } else if (Intrinsics.areEqual(Boolean.class, cls3)) {
                stringAsyncFunctionComponent4 = new DoubleAsyncFunctionComponent("isBatteryOptimizationEnabledAsync", anyTypeArr4, function4);
            } else if (Intrinsics.areEqual(Boolean.class, cls2)) {
                stringAsyncFunctionComponent4 = new FloatAsyncFunctionComponent("isBatteryOptimizationEnabledAsync", anyTypeArr4, function4);
            } else {
                stringAsyncFunctionComponent4 = Intrinsics.areEqual(Boolean.class, String.class) ? new StringAsyncFunctionComponent("isBatteryOptimizationEnabledAsync", anyTypeArr4, function4) : new UntypedAsyncFunctionComponent("isBatteryOptimizationEnabledAsync", anyTypeArr4, function4);
            }
            moduleDefinitionBuilder.getAsyncFunctions().put("isBatteryOptimizationEnabledAsync", stringAsyncFunctionComponent4);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() throws Exceptions$ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions$ReactContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerBroadcastReceivers(Context context) {
        synchronized (this.broadcastReceivers) {
            if (this.broadcastReceivers.isEmpty()) {
                Unit unit = Unit.INSTANCE;
                final WeakReference weakReference = new WeakReference(this);
                Function2 function2 = new Function2() { // from class: expo.modules.battery.BatteryModule$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BatteryModule.registerBroadcastReceivers$lambda$14(weakReference, (String) obj, (Bundle) obj2);
                    }
                };
                BatteryStateReceiver batteryStateReceiver = new BatteryStateReceiver(function2);
                PowerSaverReceiver powerSaverReceiver = new PowerSaverReceiver(function2);
                BatteryLevelReceiver batteryLevelReceiver = new BatteryLevelReceiver(function2);
                context.registerReceiver(batteryStateReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                context.registerReceiver(powerSaverReceiver, new IntentFilter("android.os.action.POWER_SAVE_MODE_CHANGED"));
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_LOW");
                intentFilter.addAction("android.intent.action.BATTERY_OKAY");
                context.registerReceiver(batteryLevelReceiver, intentFilter);
                synchronized (this.broadcastReceivers) {
                    List list = this.broadcastReceivers;
                    list.add(batteryStateReceiver);
                    list.add(batteryLevelReceiver);
                    list.add(powerSaverReceiver);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unregisterBroadcastReceivers(Context context) {
        synchronized (this.broadcastReceivers) {
            try {
                List list = this.broadcastReceivers;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    context.unregisterReceiver((BroadcastReceiver) it.next());
                }
                list.clear();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerBroadcastReceivers$lambda$14(WeakReference weakReference, String name, Bundle body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        try {
            BatteryModule batteryModule = (BatteryModule) weakReference.get();
            if (batteryModule != null) {
                batteryModule.sendEvent(name, body);
            }
        } catch (Throwable unused) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isLowPowerModeEnabled() {
        Object systemService = getContext().getApplicationContext().getSystemService("power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        if (powerManager == null) {
            return false;
        }
        return powerManager.isPowerSaveMode();
    }
}
