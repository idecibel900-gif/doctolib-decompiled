package org.greenrobot.eventbus;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.android.AndroidComponents;

/* JADX INFO: loaded from: classes5.dex */
public class EventBusBuilder {
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    boolean ignoreGeneratedIndex;
    Logger logger;
    MainThreadSupport mainThreadSupport;
    boolean strictMethodVerification;
    List subscriberInfoIndexes;
    boolean throwSubscriberException;
    boolean logSubscriberExceptions = true;
    boolean logNoSubscriberMessages = true;
    boolean sendSubscriberExceptionEvent = true;
    boolean sendNoSubscriberEvent = true;
    boolean eventInheritance = true;
    ExecutorService executorService = DEFAULT_EXECUTOR_SERVICE;

    EventBusBuilder() {
    }

    Logger getLogger() {
        Logger logger = this.logger;
        return logger != null ? logger : Logger.Default.get();
    }

    MainThreadSupport getMainThreadSupport() {
        MainThreadSupport mainThreadSupport = this.mainThreadSupport;
        if (mainThreadSupport != null) {
            return mainThreadSupport;
        }
        if (AndroidComponents.areAvailable()) {
            return AndroidComponents.get().defaultMainThreadSupport;
        }
        return null;
    }

    public EventBus build() {
        return new EventBus(this);
    }
}
