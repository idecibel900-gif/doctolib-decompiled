package com.reactnativekeyboardcontroller.extensions;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.reactnativekeyboardcontroller.log.Logger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ThemedReactContextKt {
    public static final void dispatchEvent(ThemedReactContext themedReactContext, int i, Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNull(themedReactContext, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(themedReactContext, i);
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(event);
        }
    }

    public static final void emitEvent(ThemedReactContext themedReactContext, String event, WritableMap params) {
        ReactApplicationContext reactApplicationContext;
        DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        if (themedReactContext != null && (reactApplicationContext = themedReactContext.getReactApplicationContext()) != null && (rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)) != null) {
            rCTDeviceEventEmitter.emit(event, params);
        }
        Logger.i$default(Logger.INSTANCE, "ThemedReactContext", event, null, 4, null);
    }

    public static final void keepShadowNodesInSync(ThemedReactContext themedReactContext, int i) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        writableArrayCreateArray.pushInt(new int[]{i}[0]);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putArray("tags", writableArrayCreateArray);
        emitEvent(themedReactContext, "onUserDrivenAnimationEnded", writableMapCreateMap);
    }

    public static final String getAppearance(ThemedReactContext themedReactContext) {
        return (themedReactContext != null && ContextKt.isSystemDarkMode(themedReactContext)) ? "dark" : "light";
    }
}
