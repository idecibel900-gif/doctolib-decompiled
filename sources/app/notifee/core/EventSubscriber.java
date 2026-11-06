package app.notifee.core;

import android.content.Context;
import app.notifee.core.event.BlockStateEvent;
import app.notifee.core.event.ForegroundServiceEvent;
import app.notifee.core.event.LogEvent;
import app.notifee.core.event.NotificationEvent;
import app.notifee.core.interfaces.EventListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class EventSubscriber {
    private static final EventSubscriber mInstance = new EventSubscriber();
    private final Set<EventListener> mListeners = new HashSet();

    private EventSubscriber() {
        EventBus.register(this);
    }

    @KeepForSdk
    public static void register(EventListener eventListener) {
        mInstance.mListeners.add(eventListener);
    }

    @KeepForSdk
    public static void unregister(EventListener eventListener) {
        mInstance.mListeners.remove(eventListener);
    }

    @KeepForSdk
    public static Context getContext() {
        return ContextHolder.getApplicationContext();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNotificationEvent(NotificationEvent notificationEvent) {
        Iterator<EventListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onNotificationEvent(notificationEvent);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLogEvent(LogEvent logEvent) {
        Iterator<EventListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onLogEvent(logEvent);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onBlockStateEvent(BlockStateEvent blockStateEvent) {
        Iterator<EventListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onBlockStateEvent(blockStateEvent);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onForegroundServiceEvent(ForegroundServiceEvent foregroundServiceEvent) {
        Iterator<EventListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onForegroundServiceEvent(foregroundServiceEvent);
        }
    }
}
