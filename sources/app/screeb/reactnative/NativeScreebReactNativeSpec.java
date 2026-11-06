package app.screeb.reactnative;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeScreebReactNativeSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "ScreebReactNative";

    @DoNotStrip
    @ReactMethod
    public abstract void assignGroup(String str, String str2, ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void closeMessage(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void closeSdk(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void closeSurvey(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void debug(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void debugTargeting(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getIdentity(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void handleDeepLink(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void initSdk(String str, String str2, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, String str3, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void onHookResult(String str, ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void resetIdentity(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void sessionReplayStart(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void sessionReplayStop(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setIdentity(String str, ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setProperties(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void startMessage(String str, Boolean bool, ReadableMap readableMap, Boolean bool2, ReadableMap readableMap2, String str2, String str3, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void startSurvey(String str, Boolean bool, ReadableMap readableMap, Boolean bool2, ReadableMap readableMap2, String str2, String str3, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void trackEvent(String str, ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void trackScreen(String str, ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void unassignGroup(String str, String str2, ReadableMap readableMap, Promise promise);

    public NativeScreebReactNativeSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "ScreebReactNative";
    }
}
