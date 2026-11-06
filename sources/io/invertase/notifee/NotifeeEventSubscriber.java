package io.invertase.notifee;

import android.os.Bundle;
import androidx.annotation.Keep;
import app.notifee.core.event.BlockStateEvent;
import app.notifee.core.event.ForegroundServiceEvent;
import app.notifee.core.event.LogEvent;
import app.notifee.core.event.NotificationEvent;
import app.notifee.core.interfaces.EventListener;
import app.notifee.core.model.NotificationModel;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0012"}, d2 = {"Lio/invertase/notifee/NotifeeEventSubscriber;", "Lapp/notifee/core/interfaces/EventListener;", "<init>", "()V", "onNotificationEvent", "", "notificationEvent", "Lapp/notifee/core/event/NotificationEvent;", "onLogEvent", "logEvent", "Lapp/notifee/core/event/LogEvent;", "onBlockStateEvent", "blockStateEvent", "Lapp/notifee/core/event/BlockStateEvent;", "onForegroundServiceEvent", "foregroundServiceEvent", "Lapp/notifee/core/event/ForegroundServiceEvent;", "Companion", "react-native-notify-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotifeeEventSubscriber implements EventListener {
    public static final String FOREGROUND_NOTIFICATION_TASK_KEY = "app.notifee.foreground-service-headless-task";
    private static final String KEY_BLOCKED = "blocked";
    private static final String KEY_DETAIL = "detail";
    private static final String KEY_DETAIL_INPUT = "input";
    private static final String KEY_DETAIL_PRESS_ACTION = "pressAction";
    private static final String KEY_HEADLESS = "headless";
    private static final String KEY_NOTIFICATION = "notification";
    private static final String KEY_TYPE = "type";
    public static final String NOTIFICATION_EVENT_KEY = "app.notifee.notification-event";

    @Override // app.notifee.core.interfaces.EventListener
    public void onLogEvent(LogEvent logEvent) {
        Intrinsics.checkNotNullParameter(logEvent, "logEvent");
    }

    @Override // app.notifee.core.interfaces.EventListener
    public void onNotificationEvent(NotificationEvent notificationEvent) {
        Intrinsics.checkNotNullParameter(notificationEvent, "notificationEvent");
        WritableMap writableMapCreateMap = Arguments.createMap();
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap.putInt(KEY_TYPE, notificationEvent.getType());
        Bundle bundle = notificationEvent.getNotification().toBundle();
        Intrinsics.checkNotNullExpressionValue(bundle, "toBundle(...)");
        writableMapCreateMap2.putMap(KEY_NOTIFICATION, Arguments.fromBundle(bundle));
        Bundle extras = notificationEvent.getExtras();
        if (extras != null) {
            Bundle bundle2 = extras.getBundle(KEY_DETAIL_PRESS_ACTION);
            if (bundle2 != null) {
                writableMapCreateMap2.putMap(KEY_DETAIL_PRESS_ACTION, Arguments.fromBundle(bundle2));
            }
            String string = extras.getString(KEY_DETAIL_INPUT);
            if (string != null) {
                writableMapCreateMap2.putString(KEY_DETAIL_INPUT, string);
            }
            if (extras.containsKey("startId")) {
                writableMapCreateMap2.putInt("startId", extras.getInt("startId"));
            }
            if (extras.containsKey("fgsType")) {
                writableMapCreateMap2.putInt("fgsType", extras.getInt("fgsType"));
            }
        }
        writableMapCreateMap.putMap(KEY_DETAIL, writableMapCreateMap2);
        NotifeeReactUtils notifeeReactUtils = NotifeeReactUtils.INSTANCE;
        if (notifeeReactUtils.isAppInForeground()) {
            writableMapCreateMap.putBoolean(KEY_HEADLESS, false);
            notifeeReactUtils.sendEvent(NOTIFICATION_EVENT_KEY, writableMapCreateMap);
        } else {
            writableMapCreateMap.putBoolean(KEY_HEADLESS, true);
            notifeeReactUtils.startHeadlessTask(NOTIFICATION_EVENT_KEY, writableMapCreateMap, 60000L, null);
        }
    }

    @Override // app.notifee.core.interfaces.EventListener
    public void onBlockStateEvent(BlockStateEvent blockStateEvent) {
        Intrinsics.checkNotNullParameter(blockStateEvent, "blockStateEvent");
        WritableMap writableMapCreateMap = Arguments.createMap();
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        int type = blockStateEvent.getType();
        writableMapCreateMap.putInt(KEY_TYPE, type);
        if (type == 5 || type == 6) {
            String str = type == 5 ? "channel" : "channelGroup";
            Bundle channelOrGroupBundle = blockStateEvent.getChannelOrGroupBundle();
            if (channelOrGroupBundle != null) {
                writableMapCreateMap2.putMap(str, Arguments.fromBundle(channelOrGroupBundle));
            }
        }
        if (type == 4) {
            writableMapCreateMap2.putBoolean(KEY_BLOCKED, blockStateEvent.isBlocked());
        }
        writableMapCreateMap.putMap(KEY_DETAIL, writableMapCreateMap2);
        NotifeeReactUtils notifeeReactUtils = NotifeeReactUtils.INSTANCE;
        if (notifeeReactUtils.isAppInForeground()) {
            writableMapCreateMap.putBoolean(KEY_HEADLESS, false);
            notifeeReactUtils.sendEvent(NOTIFICATION_EVENT_KEY, writableMapCreateMap);
        } else {
            writableMapCreateMap.putBoolean(KEY_HEADLESS, true);
            notifeeReactUtils.startHeadlessTask(NOTIFICATION_EVENT_KEY, writableMapCreateMap, 0L, new AnonymousClass2(blockStateEvent));
        }
    }

    /* JADX INFO: renamed from: io.invertase.notifee.NotifeeEventSubscriber$onBlockStateEvent$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 implements HeadlessTask.GenericCallback, FunctionAdapter {
        final /* synthetic */ BlockStateEvent $tmp0;

        AnonymousClass2(BlockStateEvent blockStateEvent) {
            this.$tmp0 = blockStateEvent;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof HeadlessTask.GenericCallback) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function getFunctionDelegate() {
            return new FunctionReferenceImpl(0, this.$tmp0, BlockStateEvent.class, "setCompletionResult", "setCompletionResult()V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // io.invertase.notifee.HeadlessTask.GenericCallback
        public final void call() {
            this.$tmp0.setCompletionResult();
        }
    }

    @Override // app.notifee.core.interfaces.EventListener
    public void onForegroundServiceEvent(ForegroundServiceEvent foregroundServiceEvent) {
        Intrinsics.checkNotNullParameter(foregroundServiceEvent, "foregroundServiceEvent");
        NotificationModel notification = foregroundServiceEvent.getNotification();
        WritableMap writableMapCreateMap = Arguments.createMap();
        Bundle bundle = notification.toBundle();
        Intrinsics.checkNotNullExpressionValue(bundle, "toBundle(...)");
        writableMapCreateMap.putMap(KEY_NOTIFICATION, Arguments.fromBundle(bundle));
        NotifeeReactUtils.INSTANCE.startHeadlessTask(FOREGROUND_NOTIFICATION_TASK_KEY, writableMapCreateMap, 0L, new AnonymousClass1(foregroundServiceEvent));
    }

    /* JADX INFO: renamed from: io.invertase.notifee.NotifeeEventSubscriber$onForegroundServiceEvent$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 implements HeadlessTask.GenericCallback, FunctionAdapter {
        final /* synthetic */ ForegroundServiceEvent $tmp0;

        AnonymousClass1(ForegroundServiceEvent foregroundServiceEvent) {
            this.$tmp0 = foregroundServiceEvent;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof HeadlessTask.GenericCallback) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function getFunctionDelegate() {
            return new FunctionReferenceImpl(0, this.$tmp0, ForegroundServiceEvent.class, "setCompletionResult", "setCompletionResult()V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // io.invertase.notifee.HeadlessTask.GenericCallback
        public final void call() {
            this.$tmp0.setCompletionResult();
        }
    }
}
