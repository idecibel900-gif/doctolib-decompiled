package com.datadog.reactnative;

import com.datadog.android.rum.RumSessionListener;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.NativeArray;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DdSdkSessionStartedListener implements RumSessionListener {
    private static DdSdkSessionStartedListener instance;
    private static boolean isRnSdkInitialized;
    private Function1 convertToNativeArray;
    private Function1 exceptionHandler;
    private Boolean isNewArchitecture;
    private String lastSessionId;
    private ReactContext reactContext;
    public static final Companion Companion = new Companion(null);
    private static UiThreadExecutor uiThreadExecutor = new ReactUiThreadExecutor();

    public /* synthetic */ DdSdkSessionStartedListener(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DdSdkSessionStartedListener getInstance() {
            if (DdSdkSessionStartedListener.instance == null) {
                DdSdkSessionStartedListener.instance = new DdSdkSessionStartedListener(null);
            }
            DdSdkSessionStartedListener ddSdkSessionStartedListener = DdSdkSessionStartedListener.instance;
            Intrinsics.checkNotNull(ddSdkSessionStartedListener);
            return ddSdkSessionStartedListener;
        }

        public final void invalidate() {
            DdSdkSessionStartedListener.instance = null;
        }
    }

    private DdSdkSessionStartedListener() {
    }

    @Override // com.datadog.android.rum.RumSessionListener
    public void onSessionStarted(String sessionId, boolean z) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.lastSessionId = sessionId;
        trySendSessionStartedToJS(sessionId);
    }

    public final void setReactContext(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        final String str = this.lastSessionId;
        if (str == null) {
            return;
        }
        uiThreadExecutor.runOnUiThread(new Runnable() { // from class: com.datadog.reactnative.DdSdkSessionStartedListener$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.trySendSessionStartedToJS(str);
            }
        });
    }

    public final void onRnSdkInitialized() {
        isRnSdkInitialized = true;
        final String str = this.lastSessionId;
        if (str == null) {
            return;
        }
        uiThreadExecutor.runOnUiThread(new Runnable() { // from class: com.datadog.reactnative.DdSdkSessionStartedListener$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.trySendSessionStartedToJS(str);
            }
        });
    }

    private final boolean hasValidBridge() {
        CatalystInstance catalystInstance;
        ReactContext reactContext = this.reactContext;
        return (reactContext == null || (catalystInstance = reactContext.getCatalystInstance()) == null || isNewArchitecture() || catalystInstance.isDestroyed() || !reactContext.hasActiveReactInstance() || !isRnSdkInitialized) ? false : true;
    }

    private final boolean isNewArchitecture() {
        Boolean bool = this.isNewArchitecture;
        if (bool != null) {
            return bool.booleanValue();
        }
        this.isNewArchitecture = Boolean.TRUE;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trySendSessionStartedToJS(String str) {
        if (hasValidBridge()) {
            sendSessionIdWithBridge(str);
        } else {
            sendSessionIdWithEventEmitter(str);
        }
    }

    private final void sendSessionIdWithBridge(String str) {
        CatalystInstance catalystInstance;
        try {
            String[] strArr = {"RUMSessionStarted", str};
            ReactContext reactContext = this.reactContext;
            if (reactContext == null || (catalystInstance = reactContext.getCatalystInstance()) == null) {
                return;
            }
            catalystInstance.callFunction("DatadogInternalReactBridge", "__datadogOnMessageReceived", buildBridgeArgs(strArr));
        } catch (Exception e) {
            Function1 function1 = this.exceptionHandler;
            if (function1 != null) {
                function1.invoke(e);
            }
        }
    }

    private final NativeArray buildBridgeArgs(String[] strArr) {
        Function1 function1 = this.convertToNativeArray;
        if (function1 != null) {
            if (function1 != null) {
                return (NativeArray) function1.invoke(strArr);
            }
            return null;
        }
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (String str : strArr) {
            writableNativeArray.pushString(str);
        }
        return writableNativeArray;
    }

    private final void sendSessionIdWithEventEmitter(String str) {
        ReactContext reactContext = this.reactContext;
        if (reactContext == null) {
            return;
        }
        try {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("RUMSessionStarted", str);
        } catch (Exception unused) {
        }
    }
}
