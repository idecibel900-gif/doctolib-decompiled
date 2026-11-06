package com.datadog.reactnative;

import com.datadog.android.log.Logger;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DdLogsImplementation {
    public static final Companion Companion = new Companion(null);
    private final DatadogWrapper datadog;
    private final Lazy reactNativeLogger$delegate;

    public DdLogsImplementation(final Logger logger, DatadogWrapper datadog) {
        Intrinsics.checkNotNullParameter(datadog, "datadog");
        this.datadog = datadog;
        this.reactNativeLogger$delegate = LazyKt.lazy(new Function0() { // from class: com.datadog.reactnative.DdLogsImplementation$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DdLogsImplementation.reactNativeLogger_delegate$lambda$0(this.f$0, logger);
            }
        });
    }

    public /* synthetic */ DdLogsImplementation(Logger logger, DatadogWrapper datadogWrapper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : logger, (i & 2) != 0 ? new DatadogSDKWrapper() : datadogWrapper);
    }

    private final Logger getReactNativeLogger() {
        return (Logger) this.reactNativeLogger$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Logger reactNativeLogger_delegate$lambda$0(DdLogsImplementation ddLogsImplementation, Logger logger) {
        return logger == null ? new Logger.Builder(DatadogSDKWrapperStorage.INSTANCE.getSdkCore()).setLogcatLogsEnabled(true).setBundleWithRumEnabled(ddLogsImplementation.datadog.getBundleLogsWithRum()).setBundleWithTraceEnabled(ddLogsImplementation.datadog.getBundleLogsWithTraces()).setName(NativeDdLogsSpec.NAME).build() : logger;
    }

    public final void debug(String message, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (!this.datadog.isInitialized()) {
            promise.reject(new IllegalStateException("DD_INTERNAL_LOG_SENT_BEFORE_SDK_INIT"));
        } else {
            Logger.d$default(getReactNativeLogger(), message, null, MapsKt.plus(context.toHashMap(), GlobalState.INSTANCE.getGlobalAttributes$datadog_mobile_react_native_release()), 2, null);
            promise.resolve(null);
        }
    }

    public final void info(String message, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (!this.datadog.isInitialized()) {
            promise.reject(new IllegalStateException("DD_INTERNAL_LOG_SENT_BEFORE_SDK_INIT"));
        } else {
            Logger.i$default(getReactNativeLogger(), message, null, MapsKt.plus(context.toHashMap(), GlobalState.INSTANCE.getGlobalAttributes$datadog_mobile_react_native_release()), 2, null);
            promise.resolve(null);
        }
    }

    public final void warn(String message, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (!this.datadog.isInitialized()) {
            promise.reject(new IllegalStateException("DD_INTERNAL_LOG_SENT_BEFORE_SDK_INIT"));
        } else {
            Logger.w$default(getReactNativeLogger(), message, null, MapsKt.plus(context.toHashMap(), GlobalState.INSTANCE.getGlobalAttributes$datadog_mobile_react_native_release()), 2, null);
            promise.resolve(null);
        }
    }

    public final void error(String message, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (!this.datadog.isInitialized()) {
            promise.reject(new IllegalStateException("DD_INTERNAL_LOG_SENT_BEFORE_SDK_INIT"));
        } else {
            Logger.e$default(getReactNativeLogger(), message, null, MapsKt.plus(context.toHashMap(), GlobalState.INSTANCE.getGlobalAttributes$datadog_mobile_react_native_release()), 2, null);
            promise.resolve(null);
        }
    }

    public final void debugWithError(String message, String str, String str2, String str3, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (!this.datadog.isInitialized()) {
            promise.reject(new IllegalStateException("DD_INTERNAL_LOG_SENT_BEFORE_SDK_INIT"));
        } else {
            getReactNativeLogger().log(3, message, str, str2, str3, MapsKt.plus(context.toHashMap(), GlobalState.INSTANCE.getGlobalAttributes$datadog_mobile_react_native_release()));
            promise.resolve(null);
        }
    }

    public final void infoWithError(String message, String str, String str2, String str3, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (!this.datadog.isInitialized()) {
            promise.reject(new IllegalStateException("DD_INTERNAL_LOG_SENT_BEFORE_SDK_INIT"));
        } else {
            getReactNativeLogger().log(4, message, str, str2, str3, MapsKt.plus(context.toHashMap(), GlobalState.INSTANCE.getGlobalAttributes$datadog_mobile_react_native_release()));
            promise.resolve(null);
        }
    }

    public final void warnWithError(String message, String str, String str2, String str3, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (!this.datadog.isInitialized()) {
            promise.reject(new IllegalStateException("DD_INTERNAL_LOG_SENT_BEFORE_SDK_INIT"));
        } else {
            getReactNativeLogger().log(5, message, str, str2, str3, MapsKt.plus(context.toHashMap(), GlobalState.INSTANCE.getGlobalAttributes$datadog_mobile_react_native_release()));
            promise.resolve(null);
        }
    }

    public final void errorWithError(String message, String str, String str2, String str3, ReadableMap context, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (!this.datadog.isInitialized()) {
            promise.reject(new IllegalStateException("DD_INTERNAL_LOG_SENT_BEFORE_SDK_INIT"));
        } else {
            getReactNativeLogger().log(6, message, str, str2, str3, MapsKt.plus(context.toHashMap(), GlobalState.INSTANCE.getGlobalAttributes$datadog_mobile_react_native_release()));
            promise.resolve(null);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
