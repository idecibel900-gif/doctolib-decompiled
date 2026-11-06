package com.datadog.reactnative;

import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J(\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/datadog/reactnative/DdTrace;", "Lcom/datadog/reactnative/NativeDdTraceSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "implementation", "Lcom/datadog/reactnative/DdTraceImplementation;", "getName", "", "startSpan", "", "operation", "context", "Lcom/facebook/react/bridge/ReadableMap;", "timestampMs", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "finishSpan", "spanId", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DdTrace extends NativeDdTraceSpec {
    private final DdTraceImplementation implementation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DdTrace(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.implementation = new DdTraceImplementation(null, 1, null);
    }

    @Override // com.datadog.reactnative.NativeDdTraceSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return NativeDdTraceSpec.NAME;
    }

    @Override // com.datadog.reactnative.NativeDdTraceSpec
    @ReactMethod
    public void startSpan(String operation, ReadableMap context, double timestampMs, Promise promise) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.startSpan(operation, context, timestampMs, promise);
    }

    @Override // com.datadog.reactnative.NativeDdTraceSpec
    @ReactMethod
    public void finishSpan(String spanId, ReadableMap context, double timestampMs, Promise promise) {
        Intrinsics.checkNotNullParameter(spanId, "spanId");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.implementation.finishSpan(spanId, context, timestampMs, promise);
    }
}
