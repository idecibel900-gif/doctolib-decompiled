package io.invertase.notifee;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import app.notifee.core.Logger;
import app.notifee.core.Notifee;
import app.notifee.core.WarmupHelper;
import app.notifee.core.interfaces.MethodCallResult;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0015\u0018\u0000 _2\u00020\u00012\u00020\u0002:\u0001_B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J*\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010'\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010+\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010,\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010-\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010.\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010/\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u00100\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u00101\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u00102\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u00105\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u00106\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u00107\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u00108\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u00109\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010:\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010;\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010<\u001a\u00020\bH\u0016J\u0010\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u0014H\u0016J\u0010\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u0012H\u0016J\b\u0010A\u001a\u00020\u0014H\u0016J\u0014\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020D0CH\u0014J+\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00140I2\u0006\u0010J\u001a\u00020KH\u0016¢\u0006\u0002\u0010LJ\u0018\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010O\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010P\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010S\u001a\u00020\b2\u0006\u0010R\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010T\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010U\u001a\u00020\b2\u0006\u0010V\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010W\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010X\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010Y\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010[\u001a\u00020\b2\u0006\u0010\\\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010]\u001a\u00020\b2\u0006\u0010^\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006`"}, d2 = {"Lio/invertase/notifee/NotifeeApiModule;", "Lio/invertase/notifee/NativeNotifeeModuleSpec;", "Lcom/facebook/react/modules/core/PermissionListener;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "invalidate", "", "cancelAllNotifications", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "cancelDisplayedNotifications", "cancelTriggerNotifications", "cancelAllNotificationsWithIds", "idsArray", "Lcom/facebook/react/bridge/ReadableArray;", "notificationType", "", "tag", "", "getDisplayedNotifications", "getTriggerNotifications", "getTriggerNotificationIds", "createChannel", "channelMap", "Lcom/facebook/react/bridge/ReadableMap;", "createChannels", "channelsArray", "createChannelGroup", "channelGroupMap", "createChannelGroups", "channelGroupsArray", "deleteChannel", "channelId", "deleteChannelGroup", "channelGroupId", "displayNotification", "notification", "openAlarmPermissionSettings", "createTriggerNotification", "notificationMap", "triggerMap", "getChannels", "getChannel", "getChannelGroups", "getChannelGroup", "isChannelCreated", "isChannelBlocked", "getInitialNotification", "getNotificationSettings", "requestPermission", "permissions", "openNotificationSettings", "openBatteryOptimizationSettings", "isBatteryOptimizationEnabled", "getPowerManagerInfo", "openPowerManagerSettings", "stopForegroundService", "prewarmForegroundService", "hideNotificationDrawer", "addListener", "eventName", "removeListeners", "count", "getName", "getTypedExportedConstants", "", "", "onRequestPermissionsResult", "", "requestCode", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)Z", "cancelNotification", "notificationId", "cancelDisplayedNotification", "cancelTriggerNotification", "cancelDisplayedNotificationsWithIds", "ids", "cancelTriggerNotificationsWithIds", "getNotificationCategories", "setNotificationCategories", "categories", "setBadgeCount", "getBadgeCount", "incrementBadgeCount", "incrementBy", "decrementBadgeCount", "decrementBy", "setNotificationConfig", "config", "Companion", "react-native-notify-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotifeeApiModule extends NativeNotifeeModuleSpec implements PermissionListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String NAME = "NotifeeApiModule";
    private static final int NOTIFICATION_TYPE_ALL = 0;
    private static final int NOTIFICATION_TYPE_DISPLAYED = 1;
    private static final int NOTIFICATION_TYPE_TRIGGER = 2;

    public static final String getMainComponent(String str) {
        return INSTANCE.getMainComponent(str);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void removeListeners(double count) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotifeeApiModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getMainComponent(String defaultComponent) {
            Intrinsics.checkNotNullParameter(defaultComponent, "defaultComponent");
            String mainComponent = Notifee.getInstance().getMainComponent(defaultComponent);
            Intrinsics.checkNotNullExpressionValue(mainComponent, "getMainComponent(...)");
            return mainComponent;
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        NotifeeReactUtils.INSTANCE.getHeadlessTaskManager().stopAllTasks();
        super.invalidate();
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void cancelAllNotifications(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().cancelAllNotifications(0, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda21
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.cancelAllNotifications$lambda$0(promise, exc, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelAllNotifications$lambda$0(Promise promise, Exception exc, Void r2) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void cancelDisplayedNotifications(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().cancelAllNotifications(1, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda9
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.cancelDisplayedNotifications$lambda$1(promise, exc, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelDisplayedNotifications$lambda$1(Promise promise, Exception exc, Void r2) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void cancelTriggerNotifications(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().cancelAllNotifications(2, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda30
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.cancelTriggerNotifications$lambda$2(promise, exc, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelTriggerNotifications$lambda$2(Promise promise, Exception exc, Void r2) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void cancelAllNotificationsWithIds(ReadableArray idsArray, double notificationType, String tag, final Promise promise) {
        Intrinsics.checkNotNullParameter(idsArray, "idsArray");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ArrayList arrayList = new ArrayList(idsArray.size());
        int size = idsArray.size();
        for (int i = 0; i < size; i++) {
            String string = idsArray.getString(i);
            Intrinsics.checkNotNull(string);
            arrayList.add(string);
        }
        Notifee.getInstance().cancelAllNotificationsWithIds((int) notificationType, arrayList, tag, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda3
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.cancelAllNotificationsWithIds$lambda$3(promise, exc, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelAllNotificationsWithIds$lambda$3(Promise promise, Exception exc, Void r2) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void getDisplayedNotifications(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().getDisplayedNotifications(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda7
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.getDisplayedNotifications$lambda$4(promise, exc, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDisplayedNotifications$lambda$4(Promise promise, Exception exc, List list) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc, list);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void getTriggerNotifications(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().getTriggerNotifications(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda32
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.getTriggerNotifications$lambda$5(promise, exc, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTriggerNotifications$lambda$5(Promise promise, Exception exc, List list) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc, list);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void getTriggerNotificationIds(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().getTriggerNotificationIds(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda18
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.getTriggerNotificationIds$lambda$6(promise, exc, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTriggerNotificationIds$lambda$6(Promise promise, Exception exc, List list) {
        NotifeeReactUtils.INSTANCE.promiseStringListResolver(promise, exc, list);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void createChannel(ReadableMap channelMap, final Promise promise) {
        Intrinsics.checkNotNullParameter(channelMap, "channelMap");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().createChannel(Arguments.toBundle(channelMap), new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda14
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.createChannel$lambda$7(promise, exc, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createChannel$lambda$7(Promise promise, Exception exc, Void r2) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void createChannels(ReadableArray channelsArray, final Promise promise) {
        Intrinsics.checkNotNullParameter(channelsArray, "channelsArray");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ArrayList arrayList = new ArrayList(channelsArray.size());
        int size = channelsArray.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = Arguments.toBundle(channelsArray.getMap(i));
            Intrinsics.checkNotNull(bundle);
            arrayList.add(bundle);
        }
        Notifee.getInstance().createChannels(arrayList, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda11
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.createChannels$lambda$8(promise, exc, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createChannels$lambda$8(Promise promise, Exception exc, Void r2) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void createChannelGroup(ReadableMap channelGroupMap, final Promise promise) {
        Intrinsics.checkNotNullParameter(channelGroupMap, "channelGroupMap");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().createChannelGroup(Arguments.toBundle(channelGroupMap), new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda10
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.createChannelGroup$lambda$9(promise, exc, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createChannelGroup$lambda$9(Promise promise, Exception exc, Void r2) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void createChannelGroups(ReadableArray channelGroupsArray, final Promise promise) {
        Intrinsics.checkNotNullParameter(channelGroupsArray, "channelGroupsArray");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ArrayList arrayList = new ArrayList(channelGroupsArray.size());
        int size = channelGroupsArray.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = Arguments.toBundle(channelGroupsArray.getMap(i));
            Intrinsics.checkNotNull(bundle);
            arrayList.add(bundle);
        }
        Notifee.getInstance().createChannelGroups(arrayList, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda0
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.createChannelGroups$lambda$10(promise, exc, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createChannelGroups$lambda$10(Promise promise, Exception exc, Void r2) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void deleteChannel(String channelId, final Promise promise) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().deleteChannel(channelId, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda33
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.deleteChannel$lambda$11(promise, exc, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteChannel$lambda$11(Promise promise, Exception exc, Void r2) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void deleteChannelGroup(String channelGroupId, final Promise promise) {
        Intrinsics.checkNotNullParameter(channelGroupId, "channelGroupId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().deleteChannelGroup(channelGroupId, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda15
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.deleteChannelGroup$lambda$12(promise, exc, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteChannelGroup$lambda$12(Promise promise, Exception exc, Void r2) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void displayNotification(ReadableMap notification, final Promise promise) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().displayNotification(Arguments.toBundle(notification), new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda6
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.displayNotification$lambda$13(promise, exc, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayNotification$lambda$13(Promise promise, Exception exc, Void r2) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void openAlarmPermissionSettings(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().openAlarmPermissionSettings(getReactApplicationContext().getCurrentActivity(), new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda17
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.openAlarmPermissionSettings$lambda$14(promise, exc, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openAlarmPermissionSettings$lambda$14(Promise promise, Exception exc, Void r2) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void createTriggerNotification(ReadableMap notificationMap, ReadableMap triggerMap, final Promise promise) {
        Intrinsics.checkNotNullParameter(notificationMap, "notificationMap");
        Intrinsics.checkNotNullParameter(triggerMap, "triggerMap");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().createTriggerNotification(Arguments.toBundle(notificationMap), Arguments.toBundle(triggerMap), new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda26
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.createTriggerNotification$lambda$15(promise, exc, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createTriggerNotification$lambda$15(Promise promise, Exception exc, Void r2) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void getChannels(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().getChannels(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda19
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.getChannels$lambda$16(promise, exc, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getChannels$lambda$16(Promise promise, Exception exc, List list) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc, list);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void getChannel(String channelId, final Promise promise) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().getChannel(channelId, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda4
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.getChannel$lambda$17(promise, exc, (Bundle) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getChannel$lambda$17(Promise promise, Exception exc, Bundle bundle) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc, bundle);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void getChannelGroups(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().getChannelGroups(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda13
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.getChannelGroups$lambda$18(promise, exc, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getChannelGroups$lambda$18(Promise promise, Exception exc, List list) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc, list);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void getChannelGroup(String channelGroupId, final Promise promise) {
        Intrinsics.checkNotNullParameter(channelGroupId, "channelGroupId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().getChannelGroup(channelGroupId, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda34
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.getChannelGroup$lambda$19(promise, exc, (Bundle) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getChannelGroup$lambda$19(Promise promise, Exception exc, Bundle bundle) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc, bundle);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void isChannelCreated(String channelId, final Promise promise) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().isChannelCreated(channelId, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda22
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.isChannelCreated$lambda$20(promise, exc, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isChannelCreated$lambda$20(Promise promise, Exception exc, Boolean bool) {
        NotifeeReactUtils.INSTANCE.promiseBooleanResolver(promise, exc, bool);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void isChannelBlocked(String channelId, final Promise promise) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().isChannelBlocked(channelId, new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda2
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.isChannelBlocked$lambda$21(promise, exc, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isChannelBlocked$lambda$21(Promise promise, Exception exc, Boolean bool) {
        NotifeeReactUtils.INSTANCE.promiseBooleanResolver(promise, exc, bool);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void getInitialNotification(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().getInitialNotification(getReactApplicationContext().getCurrentActivity(), new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda12
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.getInitialNotification$lambda$22(promise, exc, (Bundle) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getInitialNotification$lambda$22(Promise promise, Exception exc, Bundle bundle) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc, bundle);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void getNotificationSettings(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().getNotificationSettings(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda8
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.getNotificationSettings$lambda$23(promise, exc, (Bundle) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getNotificationSettings$lambda$23(Promise promise, Exception exc, Bundle bundle) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc, bundle);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void requestPermission(ReadableMap permissions, final Promise promise) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(promise, "promise");
        int i = Build.VERSION.SDK_INT;
        if (i < 33) {
            Notifee.getInstance().getNotificationSettings(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda23
                @Override // app.notifee.core.interfaces.MethodCallResult
                public final void onComplete(Exception exc, Object obj) {
                    NotifeeApiModule.requestPermission$lambda$24(promise, exc, (Bundle) obj);
                }
            });
            return;
        }
        ComponentCallbacks2 currentActivity = getReactApplicationContext().getCurrentActivity();
        PermissionAwareActivity permissionAwareActivity = currentActivity instanceof PermissionAwareActivity ? (PermissionAwareActivity) currentActivity : null;
        if (permissionAwareActivity == null) {
            Logger.d("requestPermission", "Unable to get permissionAwareActivity for " + i);
            Notifee.getInstance().getNotificationSettings(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda24
                @Override // app.notifee.core.interfaces.MethodCallResult
                public final void onComplete(Exception exc, Object obj) {
                    NotifeeApiModule.requestPermission$lambda$25(promise, exc, (Bundle) obj);
                }
            });
            return;
        }
        Notifee.getInstance().setRequestPermissionCallback(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda25
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.requestPermission$lambda$26(promise, exc, (Bundle) obj);
            }
        });
        try {
            permissionAwareActivity.requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, Notifee.REQUEST_CODE_NOTIFICATION_PERMISSION, this);
        } catch (Exception e) {
            Logger.d("requestPermission", "Failed to request POST_NOTIFICATIONS permission: " + e.getMessage());
            NotifeeReactUtils.INSTANCE.promiseResolver(promise, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$24(Promise promise, Exception exc, Bundle bundle) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$25(Promise promise, Exception exc, Bundle bundle) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$26(Promise promise, Exception exc, Bundle bundle) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc, bundle);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void openNotificationSettings(String channelId, final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().openNotificationSettings(channelId, getReactApplicationContext().getCurrentActivity(), new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda31
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.openNotificationSettings$lambda$27(promise, exc, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openNotificationSettings$lambda$27(Promise promise, Exception exc, Void r2) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void openBatteryOptimizationSettings(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().openBatteryOptimizationSettings(getReactApplicationContext().getCurrentActivity(), new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda16
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.openBatteryOptimizationSettings$lambda$28(promise, exc, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openBatteryOptimizationSettings$lambda$28(Promise promise, Exception exc, Void r2) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void isBatteryOptimizationEnabled(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().isBatteryOptimizationEnabled(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda20
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.isBatteryOptimizationEnabled$lambda$29(promise, exc, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isBatteryOptimizationEnabled$lambda$29(Promise promise, Exception exc, Boolean bool) {
        NotifeeReactUtils.INSTANCE.promiseBooleanResolver(promise, exc, bool);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void getPowerManagerInfo(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().getPowerManagerInfo(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda5
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.getPowerManagerInfo$lambda$30(promise, exc, (Bundle) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPowerManagerInfo$lambda$30(Promise promise, Exception exc, Bundle bundle) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc, bundle);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void openPowerManagerSettings(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().openPowerManagerSettings(getReactApplicationContext().getCurrentActivity(), new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda29
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.openPowerManagerSettings$lambda$31(promise, exc, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openPowerManagerSettings$lambda$31(Promise promise, Exception exc, Void r2) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void stopForegroundService(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Notifee.getInstance().stopForegroundService(new MethodCallResult() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda1
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                NotifeeApiModule.stopForegroundService$lambda$32(promise, exc, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopForegroundService$lambda$32(Promise promise, Exception exc, Void r2) {
        NotifeeReactUtils.INSTANCE.promiseResolver(promise, exc);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void prewarmForegroundService(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        final Context applicationContext = getReactApplicationContext().getApplicationContext();
        if (applicationContext == null) {
            promise.reject("ERR_CONTEXT", "ReactApplicationContext is null");
            return;
        }
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda27
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return NotifeeApiModule.prewarmForegroundService$lambda$35(runnable);
            }
        });
        executorServiceNewSingleThreadExecutor.submit(new Runnable() { // from class: io.invertase.notifee.NotifeeApiModule$$ExternalSyntheticLambda28
            @Override // java.lang.Runnable
            public final void run() {
                NotifeeApiModule.prewarmForegroundService$lambda$36(applicationContext, promise);
            }
        });
        executorServiceNewSingleThreadExecutor.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread prewarmForegroundService$lambda$35(Runnable runnable) {
        Thread thread = new Thread(runnable, "notifee-prewarm");
        thread.setDaemon(true);
        thread.setPriority(1);
        return thread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prewarmForegroundService$lambda$36(Context context, Promise promise) {
        Trace.beginSection("notifee:prewarm");
        try {
            WarmupHelper.runWarmup(context);
            promise.resolve(null);
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Logger.e("NotifeeApiModule", "prewarmForegroundService unexpectedly threw", th);
                promise.resolve(null);
            } finally {
                Trace.endSection();
            }
        }
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void hideNotificationDrawer() {
        NotifeeReactUtils.INSTANCE.hideNotificationDrawer();
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void addListener(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        NotifeeReactUtils.INSTANCE.flushPendingEvents();
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "NotifeeApiModule";
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    protected Map<String, Object> getTypedExportedConstants() {
        return MapsKt.mutableMapOf(TuplesKt.to("ANDROID_API_LEVEL", Integer.valueOf(Build.VERSION.SDK_INT)));
    }

    @Override // com.facebook.react.modules.core.PermissionListener
    public boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        return Notifee.getInstance().onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void cancelNotification(String notificationId, Promise promise) {
        Intrinsics.checkNotNullParameter(notificationId, "notificationId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(null);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void cancelDisplayedNotification(String notificationId, Promise promise) {
        Intrinsics.checkNotNullParameter(notificationId, "notificationId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(null);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void cancelTriggerNotification(String notificationId, Promise promise) {
        Intrinsics.checkNotNullParameter(notificationId, "notificationId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(null);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void cancelDisplayedNotificationsWithIds(ReadableArray ids, Promise promise) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(null);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void cancelTriggerNotificationsWithIds(ReadableArray ids, Promise promise) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(null);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void getNotificationCategories(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Arguments.createArray());
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void setNotificationCategories(ReadableArray categories, Promise promise) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(null);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void setBadgeCount(double count, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(null);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void getBadgeCount(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Double.valueOf(0.0d));
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void incrementBadgeCount(double incrementBy, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(null);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void decrementBadgeCount(double decrementBy, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(null);
    }

    @Override // io.invertase.notifee.NativeNotifeeModuleSpec
    public void setNotificationConfig(ReadableMap config, Promise promise) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(null);
    }
}
