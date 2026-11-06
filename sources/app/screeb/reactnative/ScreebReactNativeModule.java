package app.screeb.reactnative;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import app.screeb.sdk.Screeb;
import app.screeb.sdk.ScreebHookCallback;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.react.RNPurchasesModule;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = "ScreebReactNative")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001<B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016JJ\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0014\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J,\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J,\u0010\u0018\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016JY\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010\u001e2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\"JY\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\r2\b\u0010%\u001a\u0004\u0018\u00010\u001e2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\"J\u0010\u0010&\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010)\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010*\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010+\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010,\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010/\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u00100\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u000106\u0018\u0001052\b\u00107\u001a\u0004\u0018\u00010\rH\u0002J \u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u000206\u0018\u0001052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J \u00109\u001a\u00020\t2\u0006\u00102\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0007H\u0002¨\u0006="}, d2 = {"Lapp/screeb/reactnative/ScreebReactNativeModule;", "Lapp/screeb/reactnative/NativeScreebReactNativeSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getName", "", "initSdk", "", "channelId", "userId", DiagnosticsEntry.PROPERTIES_KEY, "Lcom/facebook/react/bridge/ReadableMap;", "hooks", "initOptions", "language", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "setIdentity", "setProperties", "assignGroup", "type", "name", "unassignGroup", "trackEvent", "trackScreen", "startSurvey", "surveyId", "allowMultipleResponses", "", "hiddenFields", "ignoreSurveyStatus", "distributionId", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/Boolean;Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/react/bridge/Promise;)V", "startMessage", "messageId", "ignoreMessageStatus", "debug", "debugTargeting", "sessionReplayStart", "sessionReplayStop", "resetIdentity", "getIdentity", "closeSdk", "handleDeepLink", "url", "closeSurvey", "closeMessage", "onHookResult", "hookId", "result", "fromReadableMap", "Ljava/util/HashMap;", "", "readableMap", "makeHooks", "emitHookEvent", "nativeHookId", "payload", "Companion", "screeb_react-native_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreebReactNativeModule extends NativeScreebReactNativeSpec {
    public static final String NAME = "ScreebReactNative";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreebReactNativeModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "ScreebReactNative";
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec
    public void initSdk(final String channelId, final String userId, final ReadableMap properties, ReadableMap hooks, final ReadableMap initOptions, final String language, final Promise promise) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Screeb.INSTANCE.setSecondarySDK(RNPurchasesModule.PLATFORM_NAME, "4.4.3");
        final HashMap<String, Object> mapMakeHooks = makeHooks(hooks);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                ScreebReactNativeModule.initSdk$lambda$0(channelId, userId, this, properties, initOptions, mapMakeHooks, language, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSdk$lambda$0(String str, String str2, ScreebReactNativeModule screebReactNativeModule, ReadableMap readableMap, ReadableMap readableMap2, HashMap map, String str3, Promise promise) throws Throwable {
        Screeb.INSTANCE.pluginInit(str, str2, screebReactNativeModule.fromReadableMap(readableMap), screebReactNativeModule.fromReadableMap(readableMap2), map, str3);
        promise.resolve(null);
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec
    public void setIdentity(final String userId, final ReadableMap properties, final Promise promise) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                ScreebReactNativeModule.setIdentity$lambda$1(userId, this, properties, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setIdentity$lambda$1(String str, ScreebReactNativeModule screebReactNativeModule, ReadableMap readableMap, Promise promise) {
        Screeb.INSTANCE.setIdentity(str, screebReactNativeModule.fromReadableMap(readableMap));
        promise.resolve(null);
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec
    public void setProperties(final ReadableMap properties, final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                ScreebReactNativeModule.setProperties$lambda$3(this.f$0, properties, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setProperties$lambda$3(ScreebReactNativeModule screebReactNativeModule, ReadableMap readableMap, Promise promise) {
        HashMap<String, Object> mapFromReadableMap = screebReactNativeModule.fromReadableMap(readableMap);
        if (mapFromReadableMap != null) {
            Screeb.INSTANCE.setVisitorProperties(mapFromReadableMap);
        }
        promise.resolve(null);
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec
    public void assignGroup(final String type, final String name, final ReadableMap properties, final Promise promise) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(promise, "promise");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                ScreebReactNativeModule.assignGroup$lambda$4(type, name, this, properties, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void assignGroup$lambda$4(String str, String str2, ScreebReactNativeModule screebReactNativeModule, ReadableMap readableMap, Promise promise) {
        Screeb.INSTANCE.assignGroup(str, str2, screebReactNativeModule.fromReadableMap(readableMap));
        promise.resolve(null);
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec
    public void unassignGroup(final String type, final String name, final ReadableMap properties, final Promise promise) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(promise, "promise");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                ScreebReactNativeModule.unassignGroup$lambda$5(type, name, this, properties, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void unassignGroup$lambda$5(String str, String str2, ScreebReactNativeModule screebReactNativeModule, ReadableMap readableMap, Promise promise) {
        Screeb.INSTANCE.unassignGroup(str, str2, screebReactNativeModule.fromReadableMap(readableMap));
        promise.resolve(null);
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec
    public void trackEvent(final String name, final ReadableMap properties, final Promise promise) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(promise, "promise");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ScreebReactNativeModule.trackEvent$lambda$6(name, this, properties, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trackEvent$lambda$6(String str, ScreebReactNativeModule screebReactNativeModule, ReadableMap readableMap, Promise promise) {
        Screeb.INSTANCE.trackEvent(str, screebReactNativeModule.fromReadableMap(readableMap));
        promise.resolve(null);
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec
    public void trackScreen(final String name, final ReadableMap properties, final Promise promise) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(promise, "promise");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                ScreebReactNativeModule.trackScreen$lambda$7(name, this, properties, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trackScreen$lambda$7(String str, ScreebReactNativeModule screebReactNativeModule, ReadableMap readableMap, Promise promise) {
        Screeb.INSTANCE.trackScreen(str, screebReactNativeModule.fromReadableMap(readableMap));
        promise.resolve(null);
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec
    public void startSurvey(final String surveyId, final Boolean allowMultipleResponses, final ReadableMap hiddenFields, final Boolean ignoreSurveyStatus, ReadableMap hooks, final String language, final String distributionId, final Promise promise) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        final HashMap<String, Object> mapMakeHooks = makeHooks(hooks);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                ScreebReactNativeModule.startSurvey$lambda$8(surveyId, allowMultipleResponses, this, hiddenFields, ignoreSurveyStatus, mapMakeHooks, language, distributionId, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startSurvey$lambda$8(String str, Boolean bool, ScreebReactNativeModule screebReactNativeModule, ReadableMap readableMap, Boolean bool2, HashMap map, String str2, String str3, Promise promise) {
        Screeb.INSTANCE.startSurvey(str, bool != null ? bool.booleanValue() : true, screebReactNativeModule.fromReadableMap(readableMap), bool2 != null ? bool2.booleanValue() : true, map, str2, str3);
        promise.resolve(null);
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec
    public void startMessage(final String messageId, final Boolean allowMultipleResponses, final ReadableMap hiddenFields, final Boolean ignoreMessageStatus, ReadableMap hooks, final String language, final String distributionId, final Promise promise) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        final HashMap<String, Object> mapMakeHooks = makeHooks(hooks);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                ScreebReactNativeModule.startMessage$lambda$9(messageId, allowMultipleResponses, this, hiddenFields, ignoreMessageStatus, mapMakeHooks, language, distributionId, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startMessage$lambda$9(String str, Boolean bool, ScreebReactNativeModule screebReactNativeModule, ReadableMap readableMap, Boolean bool2, HashMap map, String str2, String str3, Promise promise) {
        Screeb.INSTANCE.startMessage(str, bool != null ? bool.booleanValue() : true, screebReactNativeModule.fromReadableMap(readableMap), bool2 != null ? bool2.booleanValue() : true, map, str2, str3);
        promise.resolve(null);
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec
    public void debug(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                ScreebReactNativeModule.debug$lambda$11(promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void debug$lambda$11(final Promise promise) {
        Screeb.INSTANCE.debug(new Function2() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ScreebReactNativeModule.debug$lambda$11$lambda$10(promise, (String) obj, (Exception) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit debug$lambda$11$lambda$10(Promise promise, String debugInfo, Exception exc) {
        Intrinsics.checkNotNullParameter(debugInfo, "debugInfo");
        if (exc != null) {
            promise.reject("DEBUG_ERROR", exc.getMessage(), exc);
        } else {
            promise.resolve(debugInfo);
        }
        return Unit.INSTANCE;
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec
    public void debugTargeting(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                ScreebReactNativeModule.debugTargeting$lambda$13(promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void debugTargeting$lambda$13(final Promise promise) {
        Screeb.INSTANCE.debugTargeting(new Function2() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ScreebReactNativeModule.debugTargeting$lambda$13$lambda$12(promise, (String) obj, (Exception) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit debugTargeting$lambda$13$lambda$12(Promise promise, String debugInfo, Exception exc) {
        Intrinsics.checkNotNullParameter(debugInfo, "debugInfo");
        if (exc != null) {
            promise.reject("DEBUG_TARGETING_ERROR", exc.getMessage(), exc);
        } else {
            promise.resolve(debugInfo);
        }
        return Unit.INSTANCE;
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec
    public void sessionReplayStart(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                ScreebReactNativeModule.sessionReplayStart$lambda$14(promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sessionReplayStart$lambda$14(Promise promise) {
        Screeb.INSTANCE.sessionReplayStart();
        promise.resolve(null);
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec
    public void sessionReplayStop(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                ScreebReactNativeModule.sessionReplayStop$lambda$15(promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sessionReplayStop$lambda$15(Promise promise) {
        Screeb.INSTANCE.sessionReplayStop();
        promise.resolve(null);
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec
    public void resetIdentity(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                ScreebReactNativeModule.resetIdentity$lambda$16(promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetIdentity$lambda$16(Promise promise) {
        Screeb.INSTANCE.resetIdentity();
        promise.resolve(null);
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec
    public void getIdentity(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                ScreebReactNativeModule.getIdentity$lambda$18(promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getIdentity$lambda$18(final Promise promise) {
        Screeb.INSTANCE.getIdentity(new Function2() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ScreebReactNativeModule.getIdentity$lambda$18$lambda$17(promise, (HashMap) obj, (Exception) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getIdentity$lambda$18$lambda$17(Promise promise, HashMap map, Exception exc) {
        if (exc != null) {
            promise.reject("GET_IDENTITY_ERROR", exc.getMessage(), exc);
        } else {
            promise.resolve(map);
        }
        return Unit.INSTANCE;
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec
    public void closeSdk(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                ScreebReactNativeModule.closeSdk$lambda$19(promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void closeSdk$lambda$19(Promise promise) {
        Screeb.INSTANCE.closeSdk();
        promise.resolve(null);
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec
    public void handleDeepLink(final String url, final Promise promise) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(promise, "promise");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                ScreebReactNativeModule.handleDeepLink$lambda$20(url, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleDeepLink$lambda$20(String str, Promise promise) throws Throwable {
        Screeb.INSTANCE.handleDeepLink(Uri.parse(str));
        promise.resolve(null);
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec
    public void closeSurvey(final String surveyId, final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ScreebReactNativeModule.closeSurvey$lambda$21(surveyId, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void closeSurvey$lambda$21(String str, Promise promise) {
        Screeb.INSTANCE.closeSurvey(str);
        promise.resolve(null);
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec
    public void closeMessage(final String messageId, final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                ScreebReactNativeModule.closeMessage$lambda$22(messageId, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void closeMessage$lambda$22(String str, Promise promise) {
        Screeb.INSTANCE.closeMessage(str);
        promise.resolve(null);
    }

    @Override // app.screeb.reactnative.NativeScreebReactNativeSpec
    public void onHookResult(final String hookId, final ReadableMap result, final Promise promise) {
        Intrinsics.checkNotNullParameter(hookId, "hookId");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(promise, "promise");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                ScreebReactNativeModule.onHookResult$lambda$23(hookId, result, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onHookResult$lambda$23(String str, ReadableMap readableMap, Promise promise) {
        Screeb.INSTANCE.onHookResult(str, readableMap.toHashMap());
        promise.resolve(null);
    }

    private final HashMap<String, Object> fromReadableMap(ReadableMap readableMap) {
        HashMap<String, Object> hashMap = readableMap != null ? readableMap.toHashMap() : null;
        if (hashMap != null) {
            return hashMap;
        }
        return null;
    }

    private final HashMap<String, Object> makeHooks(ReadableMap hooks) {
        if (hooks == null) {
            return null;
        }
        HashMap map = new HashMap();
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = hooks.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            String string = hooks.getString(strNextKey);
            if (string != null) {
                map.put(strNextKey, string);
            }
        }
        if (map.isEmpty()) {
            return null;
        }
        return Screeb.INSTANCE.makeHooks(map, new ScreebHookCallback() { // from class: app.screeb.reactnative.ScreebReactNativeModule$$ExternalSyntheticLambda4
            @Override // app.screeb.sdk.ScreebHookCallback
            public final void invoke(String str, String str2, String str3) {
                ScreebReactNativeModule.makeHooks$lambda$24(this.f$0, str, str2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void makeHooks$lambda$24(ScreebReactNativeModule screebReactNativeModule, String hookId, String nativeHookId, String payload) {
        Intrinsics.checkNotNullParameter(hookId, "hookId");
        Intrinsics.checkNotNullParameter(nativeHookId, "nativeHookId");
        Intrinsics.checkNotNullParameter(payload, "payload");
        screebReactNativeModule.emitHookEvent(hookId, nativeHookId, payload);
    }

    private final void emitHookEvent(String hookId, String nativeHookId, String payload) {
        DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("hookId", hookId);
        writableMapCreateMap.putString("nativeHookId", nativeHookId);
        writableMapCreateMap.putString("payload", payload);
        Unit unit = Unit.INSTANCE;
        rCTDeviceEventEmitter.emit("ScreebEvent", writableMapCreateMap);
    }
}
