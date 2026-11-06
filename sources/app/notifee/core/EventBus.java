package app.notifee.core;

/* JADX INFO: loaded from: classes3.dex */
public class EventBus {
    private static final EventBus instance = new EventBus();
    private org.greenrobot.eventbus.EventBus eventBus = org.greenrobot.eventbus.EventBus.builder().build();

    private EventBus() {
    }

    public static EventBus getInstance() {
        return instance;
    }

    public static void register(Object obj) {
        getInstance().getDefault().register(obj);
    }

    public static Object removeStickEvent(Class cls) {
        return getInstance().getDefault().removeStickyEvent(cls);
    }

    public static void post(Object obj) {
        getInstance().getDefault().post(obj);
    }

    static void postSticky(Object obj) {
        getInstance().getDefault().postSticky(obj);
    }

    private org.greenrobot.eventbus.EventBus getDefault() {
        return this.eventBus;
    }
}
