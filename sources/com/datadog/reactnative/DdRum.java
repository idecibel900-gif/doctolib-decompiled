package com.datadog.reactnative;

import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J0\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J(\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J0\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J0\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J0\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J8\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J@\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J@\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\u0018\u0010'\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\u0018\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\u0010\u0010+\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J \u0010,\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\u0010\u0010.\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0017R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/datadog/reactnative/DdRum;", "Lcom/datadog/reactnative/NativeDdRumSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "datadogWrapper", "Lcom/datadog/reactnative/DatadogWrapper;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/datadog/reactnative/DatadogWrapper;)V", "implementation", "Lcom/datadog/reactnative/DdRumImplementation;", "getName", "", "startView", "", SubscriberAttributeKt.JSON_NAME_KEY, "name", "context", "Lcom/facebook/react/bridge/ReadableMap;", "timestampMs", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "stopView", "startAction", "type", "stopAction", "addAction", "startResource", "method", "url", "stopResource", "statusCode", "kind", "size", "addError", "message", Constants.ScionAnalytics.PARAM_SOURCE, "stacktrace", "fingerprint", "addTiming", "addViewLoadingTime", "overwrite", "", "stopSession", "addFeatureFlagEvaluation", "value", "getCurrentSessionId", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DdRum extends NativeDdRumSpec {
    private final DdRumImplementation implementation;

    public /* synthetic */ DdRum(ReactApplicationContext reactApplicationContext, DatadogWrapper datadogWrapper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactApplicationContext, (i & 2) != 0 ? new DatadogSDKWrapper() : datadogWrapper);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DdRum(ReactApplicationContext reactContext, DatadogWrapper datadogWrapper) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(datadogWrapper, "datadogWrapper");
        this.implementation = new DdRumImplementation(datadogWrapper);
    }

    @Override // com.datadog.reactnative.NativeDdRumSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return NativeDdRumSpec.NAME;
    }

    @Override // com.datadog.reactnative.NativeDdRumSpec
    @ReactMethod
    public void startView(String key, String name, ReadableMap context, double timestampMs, Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.startView(key, name, context, timestampMs, promise);
    }

    @Override // com.datadog.reactnative.NativeDdRumSpec
    @ReactMethod
    public void stopView(String key, ReadableMap context, double timestampMs, Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.stopView(key, context, timestampMs, promise);
    }

    @Override // com.datadog.reactnative.NativeDdRumSpec
    @ReactMethod
    public void startAction(String type, String name, ReadableMap context, double timestampMs, Promise promise) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.startAction(type, name, context, timestampMs, promise);
    }

    @Override // com.datadog.reactnative.NativeDdRumSpec
    @ReactMethod
    public void stopAction(String type, String name, ReadableMap context, double timestampMs, Promise promise) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.stopAction(type, name, context, timestampMs, promise);
    }

    @Override // com.datadog.reactnative.NativeDdRumSpec
    @ReactMethod
    public void addAction(String type, String name, ReadableMap context, double timestampMs, Promise promise) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.addAction(type, name, context, timestampMs, promise);
    }

    @Override // com.datadog.reactnative.NativeDdRumSpec
    @ReactMethod
    public void startResource(String key, String method, String url, ReadableMap context, double timestampMs, Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.startResource(key, method, url, context, timestampMs, promise);
    }

    @Override // com.datadog.reactnative.NativeDdRumSpec
    @ReactMethod
    public void stopResource(String key, double statusCode, String kind, double size, ReadableMap context, double timestampMs, Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.stopResource(key, statusCode, kind, size, context, timestampMs, promise);
    }

    @Override // com.datadog.reactnative.NativeDdRumSpec
    @ReactMethod
    public void addError(String message, String source, String stacktrace, ReadableMap context, double timestampMs, String fingerprint, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(stacktrace, "stacktrace");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fingerprint, "fingerprint");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.addError(message, source, stacktrace, context, timestampMs, fingerprint, promise);
    }

    @Override // com.datadog.reactnative.NativeDdRumSpec
    @ReactMethod
    public void addTiming(String name, Promise promise) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.addTiming(name, promise);
    }

    @Override // com.datadog.reactnative.NativeDdRumSpec
    @ReactMethod
    public void addViewLoadingTime(boolean overwrite, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.addViewLoadingTime(overwrite, promise);
    }

    @Override // com.datadog.reactnative.NativeDdRumSpec
    @ReactMethod
    public void stopSession(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.stopSession(promise);
    }

    @Override // com.datadog.reactnative.NativeDdRumSpec
    @ReactMethod
    public void addFeatureFlagEvaluation(String name, ReadableMap value, Promise promise) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.addFeatureFlagEvaluation(name, value, promise);
    }

    @Override // com.datadog.reactnative.NativeDdRumSpec
    @ReactMethod
    public void getCurrentSessionId(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.getCurrentSessionId(promise);
    }
}
