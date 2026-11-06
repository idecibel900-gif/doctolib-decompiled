package com.opentokreactnative;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeOpentokSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "OpentokReactNative";

    @DoNotStrip
    @ReactMethod
    public abstract void connect(String str, String str2, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void disableForceMute(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void disconnect(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void forceDisconnect(String str, String str2, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void forceMuteAll(String str, ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void forceMuteStream(String str, String str2, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getCapabilities(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getPublisherRtcStatsReport(String str, String str2);

    @DoNotStrip
    @ReactMethod
    public abstract void getSubscriberRtcStatsReport(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void initSession(String str, String str2, ReadableMap readableMap);

    @DoNotStrip
    @ReactMethod
    public abstract void publish(String str, String str2);

    @DoNotStrip
    @ReactMethod
    public abstract void removeSubscriber(String str, String str2);

    @DoNotStrip
    @ReactMethod
    public abstract void reportIssue(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void sendSignal(String str, String str2, String str3, String str4);

    @DoNotStrip
    @ReactMethod
    public abstract void setAudioTransformers(String str, String str2, ReadableArray readableArray);

    @DoNotStrip
    @ReactMethod
    public abstract void setEncryptionSecret(String str, String str2, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setVideoTransformers(String str, String str2, ReadableArray readableArray);

    @DoNotStrip
    @ReactMethod
    public abstract void unpublish(String str, String str2);

    public NativeOpentokSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "OpentokReactNative";
    }

    protected final void emitOnArchiveStarted(ReadableMap readableMap) {
        this.mEventEmitterCallback.invoke("onArchiveStarted", readableMap);
    }

    protected final void emitOnArchiveStopped(ReadableMap readableMap) {
        this.mEventEmitterCallback.invoke("onArchiveStopped", readableMap);
    }

    protected final void emitOnConnectionCreated(ReadableMap readableMap) {
        this.mEventEmitterCallback.invoke("onConnectionCreated", readableMap);
    }

    protected final void emitOnConnectionDestroyed(ReadableMap readableMap) {
        this.mEventEmitterCallback.invoke("onConnectionDestroyed", readableMap);
    }

    protected final void emitOnMuteForced(ReadableMap readableMap) {
        this.mEventEmitterCallback.invoke("onMuteForced", readableMap);
    }

    protected final void emitOnSessionConnected(ReadableMap readableMap) {
        this.mEventEmitterCallback.invoke("onSessionConnected", readableMap);
    }

    protected final void emitOnSessionDisconnected(ReadableMap readableMap) {
        this.mEventEmitterCallback.invoke("onSessionDisconnected", readableMap);
    }

    protected final void emitOnSessionReconnecting(ReadableMap readableMap) {
        this.mEventEmitterCallback.invoke("onSessionReconnecting", readableMap);
    }

    protected final void emitOnSessionReconnected(ReadableMap readableMap) {
        this.mEventEmitterCallback.invoke("onSessionReconnected", readableMap);
    }

    protected final void emitOnStreamCreated(ReadableMap readableMap) {
        this.mEventEmitterCallback.invoke("onStreamCreated", readableMap);
    }

    protected final void emitOnStreamDestroyed(ReadableMap readableMap) {
        this.mEventEmitterCallback.invoke("onStreamDestroyed", readableMap);
    }

    protected final void emitOnStreamPropertyChanged(ReadableMap readableMap) {
        this.mEventEmitterCallback.invoke("onStreamPropertyChanged", readableMap);
    }

    protected final void emitOnSignalReceived(ReadableMap readableMap) {
        this.mEventEmitterCallback.invoke("onSignalReceived", readableMap);
    }

    protected final void emitOnSessionError(ReadableMap readableMap) {
        this.mEventEmitterCallback.invoke("onSessionError", readableMap);
    }
}
