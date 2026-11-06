package com.datadog.reactnative;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0006\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J(\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J(\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0018\u0010\"\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0010\u0010#\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0012\u0010$\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/datadog/reactnative/DdSdk;", "Lcom/datadog/reactnative/NativeDdSdkSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "datadogWrapper", "Lcom/datadog/reactnative/DatadogWrapper;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/datadog/reactnative/DatadogWrapper;)V", "implementation", "Lcom/datadog/reactnative/DdSdkImplementation;", "getName", "", "initialize", "", "configuration", "Lcom/facebook/react/bridge/ReadableMap;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "setAttributes", "attributes", "setUser", "user", "setUserInfo", "addUserExtraInfo", "extraInfo", "setTrackingConsent", "trackingConsent", "sendTelemetryLog", "message", "config", "telemetryDebug", "telemetryError", "stack", "kind", "consumeWebviewEvent", "clearAllData", "addListener", "eventType", "removeListeners", "count", "", "registerLifecycleEvents", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DdSdk extends NativeDdSdkSpec {
    private final DdSdkImplementation implementation;

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    public void addListener(String eventType) {
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    public void removeListeners(double count) {
    }

    public /* synthetic */ DdSdk(ReactApplicationContext reactApplicationContext, DatadogWrapper datadogWrapper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactApplicationContext, (i & 2) != 0 ? new DatadogSDKWrapper() : datadogWrapper);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DdSdk(ReactApplicationContext reactContext, DatadogWrapper datadogWrapper) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(datadogWrapper, "datadogWrapper");
        this.implementation = new DdSdkImplementation(reactContext, datadogWrapper, null, null, 12, null);
        registerLifecycleEvents(reactContext);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return NativeDdSdkSpec.NAME;
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void initialize(ReadableMap configuration, Promise promise) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.initialize(configuration, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void setAttributes(ReadableMap attributes, Promise promise) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.setAttributes(attributes, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @Deprecated
    @ReactMethod
    public void setUser(ReadableMap user, Promise promise) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.setUser(user, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void setUserInfo(ReadableMap user, Promise promise) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.setUserInfo(user, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void addUserExtraInfo(ReadableMap extraInfo, Promise promise) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.addUserExtraInfo(extraInfo, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void setTrackingConsent(String trackingConsent, Promise promise) {
        Intrinsics.checkNotNullParameter(trackingConsent, "trackingConsent");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.setTrackingConsent(trackingConsent, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void sendTelemetryLog(String message, ReadableMap attributes, ReadableMap config, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.sendTelemetryLog(message, attributes, config, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void telemetryDebug(String message, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.telemetryDebug(message, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void telemetryError(String message, String stack, String kind, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.telemetryError(message, stack, kind, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void consumeWebviewEvent(String message, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.consumeWebviewEvent(message, promise);
    }

    @Override // com.datadog.reactnative.NativeDdSdkSpec
    @ReactMethod
    public void clearAllData(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.clearAllData(promise);
    }

    private final void registerLifecycleEvents(final ReactApplicationContext reactContext) {
        reactContext.addLifecycleEventListener(new LifecycleEventListener() { // from class: com.datadog.reactnative.DdSdk.registerLifecycleEvents.1
            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostResume() {
                Activity currentActivity = DdSdk.this.getCurrentActivity();
                if (currentActivity != null) {
                    Bundle extras = currentActivity.getIntent().getExtras();
                    DdSdkSynthetics ddSdkSynthetics = DdSdkSynthetics.INSTANCE;
                    ddSdkSynthetics.setTestId(extras != null ? extras.getString("_dd.synthetics.test_id") : null);
                    ddSdkSynthetics.setResultId(extras != null ? extras.getString("_dd.synthetics.result_id") : null);
                }
                DdSdkSessionStartedListener.Companion.getInstance().setReactContext(reactContext);
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostPause() {
                DdSdkSessionStartedListener.Companion.invalidate();
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostDestroy() {
                DdSdkSessionStartedListener.Companion.invalidate();
            }
        });
    }
}
