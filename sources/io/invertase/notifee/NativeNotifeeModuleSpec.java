package io.invertase.notifee;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class NativeNotifeeModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "NotifeeApiModule";

    @DoNotStrip
    @ReactMethod
    public abstract void addListener(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void cancelAllNotifications(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void cancelAllNotificationsWithIds(ReadableArray readableArray, double d, String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void cancelDisplayedNotification(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void cancelDisplayedNotifications(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void cancelDisplayedNotificationsWithIds(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void cancelNotification(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void cancelTriggerNotification(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void cancelTriggerNotifications(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void cancelTriggerNotificationsWithIds(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void createChannel(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void createChannelGroup(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void createChannelGroups(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void createChannels(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void createTriggerNotification(ReadableMap readableMap, ReadableMap readableMap2, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void decrementBadgeCount(double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void deleteChannel(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void deleteChannelGroup(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void displayNotification(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getBadgeCount(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getChannel(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getChannelGroup(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getChannelGroups(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getChannels(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getDisplayedNotifications(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getInitialNotification(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getNotificationCategories(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getNotificationSettings(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getPowerManagerInfo(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getTriggerNotificationIds(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getTriggerNotifications(Promise promise);

    protected abstract Map<String, Object> getTypedExportedConstants();

    @DoNotStrip
    @ReactMethod
    public abstract void hideNotificationDrawer();

    @DoNotStrip
    @ReactMethod
    public abstract void incrementBadgeCount(double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void isBatteryOptimizationEnabled(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void isChannelBlocked(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void isChannelCreated(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void openAlarmPermissionSettings(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void openBatteryOptimizationSettings(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void openNotificationSettings(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void openPowerManagerSettings(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void prewarmForegroundService(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void removeListeners(double d);

    @DoNotStrip
    @ReactMethod
    public abstract void requestPermission(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setBadgeCount(double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setNotificationCategories(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setNotificationConfig(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void stopForegroundService(Promise promise);

    public NativeNotifeeModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "NotifeeApiModule";
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @DoNotStrip
    public final Map<String, Object> getConstants() {
        Map<String, Object> typedExportedConstants = getTypedExportedConstants();
        if (ReactBuildConfig.DEBUG || ReactBuildConfig.IS_INTERNAL_BUILD) {
            HashSet hashSet = new HashSet(Arrays.asList("ANDROID_API_LEVEL"));
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet(typedExportedConstants.keySet());
            hashSet3.removeAll(hashSet);
            hashSet3.removeAll(hashSet2);
            if (!hashSet3.isEmpty()) {
                throw new IllegalStateException(String.format("Native Module Flow doesn't declare constants: %s", hashSet3));
            }
            hashSet.removeAll(typedExportedConstants.keySet());
            if (!hashSet.isEmpty()) {
                throw new IllegalStateException(String.format("Native Module doesn't fill in constants: %s", hashSet));
            }
        }
        return typedExportedConstants;
    }
}
