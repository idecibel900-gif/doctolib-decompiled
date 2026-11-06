package io.sentry.react;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

/* JADX INFO: loaded from: classes5.dex */
public abstract class NativeRNSentrySpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNSentry";

    @DoNotStrip
    @ReactMethod
    public abstract void addBreadcrumb(ReadableMap readableMap);

    @DoNotStrip
    @ReactMethod
    public abstract void addListener(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void captureEnvelope(String str, ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void captureReplay(boolean z, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void captureScreenshot(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void clearBreadcrumbs();

    @DoNotStrip
    @ReactMethod
    public abstract void closeNativeSdk(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void crash();

    @DoNotStrip
    @ReactMethod
    public abstract void crashedLastRun(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void disableNativeFramesTracking();

    @DoNotStrip
    @ReactMethod
    public abstract void disableShakeDetection();

    @DoNotStrip
    @ReactMethod
    public abstract void enableNativeFramesTracking();

    @DoNotStrip
    @ReactMethod
    public abstract void enableShakeDetection();

    @DoNotStrip
    @ReactMethod
    public abstract void encodeToBase64(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void fetchModules(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void fetchNativeAppStart(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void fetchNativeDeviceContexts(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void fetchNativeFrames(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void fetchNativeFramesDelay(double d, double d2, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void fetchNativeLogAttributes(Promise promise);

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract String fetchNativePackageName();

    @DoNotStrip
    @ReactMethod
    public abstract void fetchNativeRelease(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void fetchNativeSdkInfo(Promise promise);

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract WritableMap fetchNativeStackFramesBy(ReadableArray readableArray);

    @DoNotStrip
    @ReactMethod
    public abstract void fetchViewHierarchy(Promise promise);

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract String getCurrentReplayId();

    @DoNotStrip
    @ReactMethod
    public abstract void getDataFromUri(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getNewScreenTimeToDisplay(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void initNativeReactNavigationNewFrameTracking(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void initNativeSdk(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void pauseAppHangTracking();

    @DoNotStrip
    @ReactMethod
    public abstract void popTimeToDisplayFor(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void removeAttribute(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void removeListeners(double d);

    @DoNotStrip
    @ReactMethod
    public abstract void resumeAppHangTracking();

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract boolean setActiveSpanId(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void setAttribute(String str, String str2);

    @DoNotStrip
    @ReactMethod
    public abstract void setAttributes(ReadableMap readableMap);

    @DoNotStrip
    @ReactMethod
    public abstract void setContext(String str, ReadableMap readableMap);

    @DoNotStrip
    @ReactMethod
    public abstract void setExtra(String str, String str2);

    @DoNotStrip
    @ReactMethod
    public abstract void setTag(String str, String str2);

    @DoNotStrip
    @ReactMethod
    public abstract void setUser(ReadableMap readableMap, ReadableMap readableMap2);

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract WritableMap startProfiling(boolean z);

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract WritableMap stopProfiling();

    public NativeRNSentrySpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }
}
