package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityManager;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.UIManagerModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ExtensionsKt {
    public static final DeviceEventManagerModule.RCTDeviceEventEmitter getDeviceEventEmitter(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "<this>");
        JavaScriptModule jSModule = reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        Intrinsics.checkNotNullExpressionValue(jSModule, "getJSModule(...)");
        return (DeviceEventManagerModule.RCTDeviceEventEmitter) jSModule;
    }

    public static final UIManagerModule getUIManager(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "<this>");
        NativeModule nativeModule = reactContext.getNativeModule((Class<NativeModule>) UIManagerModule.class);
        Intrinsics.checkNotNull(nativeModule);
        return (UIManagerModule) nativeModule;
    }

    public static final boolean isScreenReaderOn(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        return ((AccessibilityManager) systemService).isTouchExplorationEnabled();
    }

    public static final boolean isHoverAction(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "<this>");
        return motionEvent.getAction() == 7 || motionEvent.getAction() == 9 || motionEvent.getAction() == 10;
    }
}
