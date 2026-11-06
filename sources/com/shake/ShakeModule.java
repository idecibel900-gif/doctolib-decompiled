package com.shake;

import android.hardware.SensorManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0017J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0010H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/shake/ShakeModule;", "Lcom/shake/ShakeSpec;", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "shakeDetector", "Lcom/shake/CustomShakeDetector;", "getName", "", "initialize", "", "invalidate", "sendEvent", "configure", "sensitivity", "", "addListener", "eventName", "removeListeners", "count", "Companion", "react-native-shake_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShakeModule extends ShakeSpec {
    public static final String EVENT_NAME = "ShakeEvent";
    public static final String NAME = "RNShake";
    private final ReactApplicationContext context;
    private CustomShakeDetector shakeDetector;

    @Override // com.shake.NativeShakeSpec
    @ReactMethod
    public void addListener(String eventName) {
    }

    @Override // com.shake.NativeShakeSpec
    @ReactMethod
    public void removeListeners(double count) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShakeModule(ReactApplicationContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.shake.NativeShakeSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNShake";
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        super.initialize();
        CustomShakeDetector customShakeDetector = new CustomShakeDetector(new CustomShakeDetector.ShakeListener() { // from class: com.shake.ShakeModule$$ExternalSyntheticLambda1
            @Override // com.shake.CustomShakeDetector.ShakeListener
            public final void onShake() {
                this.f$0.sendEvent();
            }
        }, 0.0f, 0, 6, null);
        this.shakeDetector = customShakeDetector;
        Object systemService = this.context.getSystemService("sensor");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        customShakeDetector.start((SensorManager) systemService);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        CustomShakeDetector customShakeDetector = this.shakeDetector;
        if (customShakeDetector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shakeDetector");
            customShakeDetector = null;
        }
        customShakeDetector.stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendEvent() {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(EVENT_NAME, null);
    }

    @Override // com.shake.NativeShakeSpec
    @ReactMethod
    public void configure(double sensitivity) {
        Object systemService = this.context.getSystemService("sensor");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        SensorManager sensorManager = (SensorManager) systemService;
        float f = ((float) sensitivity) * 9.80665f;
        CustomShakeDetector customShakeDetector = this.shakeDetector;
        if (customShakeDetector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shakeDetector");
            customShakeDetector = null;
        }
        customShakeDetector.stop();
        CustomShakeDetector customShakeDetector2 = new CustomShakeDetector(new CustomShakeDetector.ShakeListener() { // from class: com.shake.ShakeModule$$ExternalSyntheticLambda0
            @Override // com.shake.CustomShakeDetector.ShakeListener
            public final void onShake() {
                this.f$0.sendEvent();
            }
        }, f, 0, 4, null);
        this.shakeDetector = customShakeDetector2;
        customShakeDetector2.start(sensorManager);
    }
}
