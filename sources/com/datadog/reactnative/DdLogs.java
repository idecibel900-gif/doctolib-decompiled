package com.datadog.reactnative;

import app.notifee.core.event.LogEvent;
import com.amazon.a.a.o.b;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J \u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J \u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J \u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J>\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J>\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J>\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J>\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/datadog/reactnative/DdLogs;", "Lcom/datadog/reactnative/NativeDdLogsSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "datadogWrapper", "Lcom/datadog/reactnative/DatadogWrapper;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/datadog/reactnative/DatadogWrapper;)V", "implementation", "Lcom/datadog/reactnative/DdLogsImplementation;", "getName", "", "debug", "", "message", "context", "Lcom/facebook/react/bridge/ReadableMap;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "info", LogEvent.LEVEL_WARN, "error", "debugWithError", "errorKind", b.f, "stacktrace", "infoWithError", "warnWithError", "errorWithError", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DdLogs extends NativeDdLogsSpec {
    private final DdLogsImplementation implementation;

    public /* synthetic */ DdLogs(ReactApplicationContext reactApplicationContext, DatadogWrapper datadogWrapper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactApplicationContext, (i & 2) != 0 ? new DatadogSDKWrapper() : datadogWrapper);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DdLogs(ReactApplicationContext reactContext, DatadogWrapper datadogWrapper) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(datadogWrapper, "datadogWrapper");
        this.implementation = new DdLogsImplementation(null, datadogWrapper, 1, null);
    }

    @Override // com.datadog.reactnative.NativeDdLogsSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return NativeDdLogsSpec.NAME;
    }

    @Override // com.datadog.reactnative.NativeDdLogsSpec
    @ReactMethod
    public void debug(String message, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.debug(message, context, promise);
    }

    @Override // com.datadog.reactnative.NativeDdLogsSpec
    @ReactMethod
    public void info(String message, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.info(message, context, promise);
    }

    @Override // com.datadog.reactnative.NativeDdLogsSpec
    @ReactMethod
    public void warn(String message, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.warn(message, context, promise);
    }

    @Override // com.datadog.reactnative.NativeDdLogsSpec
    @ReactMethod
    public void error(String message, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.error(message, context, promise);
    }

    @Override // com.datadog.reactnative.NativeDdLogsSpec
    @ReactMethod
    public void debugWithError(String message, String errorKind, String errorMessage, String stacktrace, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.debugWithError(message, errorKind, errorMessage, stacktrace, context, promise);
    }

    @Override // com.datadog.reactnative.NativeDdLogsSpec
    @ReactMethod
    public void infoWithError(String message, String errorKind, String errorMessage, String stacktrace, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.infoWithError(message, errorKind, errorMessage, stacktrace, context, promise);
    }

    @Override // com.datadog.reactnative.NativeDdLogsSpec
    @ReactMethod
    public void warnWithError(String message, String errorKind, String errorMessage, String stacktrace, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.warnWithError(message, errorKind, errorMessage, stacktrace, context, promise);
    }

    @Override // com.datadog.reactnative.NativeDdLogsSpec
    @ReactMethod
    public void errorWithError(String message, String errorKind, String errorMessage, String stacktrace, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.errorWithError(message, errorKind, errorMessage, stacktrace, context, promise);
    }
}
