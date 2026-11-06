package com.swmansion.reanimated.nativeProxy;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.RCTModernEventEmitter;

/* JADX INFO: loaded from: classes4.dex */
@DoNotStrip
public class EventHandler implements RCTModernEventEmitter {
    public UIManagerModule.CustomEventNamesResolver mCustomEventNamesResolver;

    @DoNotStrip
    private final HybridData mHybridData;

    public native void receiveEvent(String str, int i, WritableMap writableMap);

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
    }

    @DoNotStrip
    private EventHandler(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public void receiveEvent(int i, int i2, String str, boolean z, int i3, WritableMap writableMap, int i4) {
        receiveEvent(this.mCustomEventNamesResolver.resolveCustomEventName(str), i2, writableMap);
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public void receiveEvent(int i, int i2, String str, WritableMap writableMap) {
        receiveEvent(this.mCustomEventNamesResolver.resolveCustomEventName(str), i2, writableMap);
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    public void receiveEvent(int i, String str, WritableMap writableMap) {
        receiveEvent(this.mCustomEventNamesResolver.resolveCustomEventName(str), i, writableMap);
    }
}
