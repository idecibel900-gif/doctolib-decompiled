package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.android.AndroidDependenciesDetector;

/* JADX INFO: loaded from: classes5.dex */
public class EventBus {
    private static final EventBusBuilder DEFAULT_BUILDER = new EventBusBuilder();
    private static final Map eventTypesCache = new HashMap();
    private final AsyncPoster asyncPoster;
    private final BackgroundPoster backgroundPoster;
    private final boolean eventInheritance;
    private final ExecutorService executorService;
    private final int indexCount;
    private final boolean logNoSubscriberMessages;
    private final boolean logSubscriberExceptions;
    private final Logger logger;
    private final Poster mainThreadPoster;
    private final MainThreadSupport mainThreadSupport;
    private final boolean sendNoSubscriberEvent;
    private final boolean sendSubscriberExceptionEvent;
    private final SubscriberMethodFinder subscriberMethodFinder;
    private final boolean throwSubscriberException;
    private final ThreadLocal currentPostingThreadState = new ThreadLocal() { // from class: org.greenrobot.eventbus.EventBus.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public PostingThreadState initialValue() {
            return new PostingThreadState();
        }
    };
    private final Map subscriptionsByEventType = new HashMap();
    private final Map typesBySubscriber = new HashMap();
    private final Map stickyEvents = new ConcurrentHashMap();

    public static EventBusBuilder builder() {
        return new EventBusBuilder();
    }

    EventBus(EventBusBuilder eventBusBuilder) {
        this.logger = eventBusBuilder.getLogger();
        MainThreadSupport mainThreadSupport = eventBusBuilder.getMainThreadSupport();
        this.mainThreadSupport = mainThreadSupport;
        this.mainThreadPoster = mainThreadSupport != null ? mainThreadSupport.createPoster(this) : null;
        this.backgroundPoster = new BackgroundPoster(this);
        this.asyncPoster = new AsyncPoster(this);
        List list = eventBusBuilder.subscriberInfoIndexes;
        this.indexCount = list != null ? list.size() : 0;
        this.subscriberMethodFinder = new SubscriberMethodFinder(eventBusBuilder.subscriberInfoIndexes, eventBusBuilder.strictMethodVerification, eventBusBuilder.ignoreGeneratedIndex);
        this.logSubscriberExceptions = eventBusBuilder.logSubscriberExceptions;
        this.logNoSubscriberMessages = eventBusBuilder.logNoSubscriberMessages;
        this.sendSubscriberExceptionEvent = eventBusBuilder.sendSubscriberExceptionEvent;
        this.sendNoSubscriberEvent = eventBusBuilder.sendNoSubscriberEvent;
        this.throwSubscriberException = eventBusBuilder.throwSubscriberException;
        this.eventInheritance = eventBusBuilder.eventInheritance;
        this.executorService = eventBusBuilder.executorService;
    }

    public void register(Object obj) {
        if (AndroidDependenciesDetector.isAndroidSDKAvailable() && !AndroidDependenciesDetector.areAndroidComponentsAvailable()) {
            throw new RuntimeException("It looks like you are using EventBus on Android, make sure to add the \"eventbus\" Android library to your dependencies.");
        }
        List listFindSubscriberMethods = this.subscriberMethodFinder.findSubscriberMethods(obj.getClass());
        synchronized (this) {
            try {
                Iterator it = listFindSubscriberMethods.iterator();
                while (it.hasNext()) {
                    subscribe(obj, (SubscriberMethod) it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void subscribe(Object obj, SubscriberMethod subscriberMethod) {
        Class cls = subscriberMethod.eventType;
        Subscription subscription = new Subscription(obj, subscriberMethod);
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.subscriptionsByEventType.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.subscriptionsByEventType.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(subscription)) {
            throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i = 0; i <= size; i++) {
            if (i == size || subscriberMethod.priority > ((Subscription) copyOnWriteArrayList.get(i)).subscriberMethod.priority) {
                copyOnWriteArrayList.add(i, subscription);
                break;
            }
        }
        List arrayList = (List) this.typesBySubscriber.get(obj);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.typesBySubscriber.put(obj, arrayList);
        }
        arrayList.add(cls);
        if (subscriberMethod.sticky) {
            if (this.eventInheritance) {
                for (Map.Entry entry : this.stickyEvents.entrySet()) {
                    if (cls.isAssignableFrom((Class) entry.getKey())) {
                        checkPostStickyEventToSubscription(subscription, entry.getValue());
                    }
                }
                return;
            }
            checkPostStickyEventToSubscription(subscription, this.stickyEvents.get(cls));
        }
    }

    private void checkPostStickyEventToSubscription(Subscription subscription, Object obj) {
        if (obj != null) {
            postToSubscription(subscription, obj, isMainThread());
        }
    }

    private boolean isMainThread() {
        MainThreadSupport mainThreadSupport = this.mainThreadSupport;
        return mainThreadSupport == null || mainThreadSupport.isMainThread();
    }

    public void post(Object obj) {
        PostingThreadState postingThreadState = (PostingThreadState) this.currentPostingThreadState.get();
        List list = postingThreadState.eventQueue;
        list.add(obj);
        if (postingThreadState.isPosting) {
            return;
        }
        postingThreadState.isMainThread = isMainThread();
        postingThreadState.isPosting = true;
        if (postingThreadState.canceled) {
            throw new EventBusException("Internal error. Abort state was not reset");
        }
        while (!list.isEmpty()) {
            try {
                postSingleEvent(list.remove(0), postingThreadState);
            } catch (Throwable th) {
                postingThreadState.isPosting = false;
                postingThreadState.isMainThread = false;
                throw th;
            }
        }
        postingThreadState.isPosting = false;
        postingThreadState.isMainThread = false;
    }

    public void postSticky(Object obj) {
        synchronized (this.stickyEvents) {
            this.stickyEvents.put(obj.getClass(), obj);
        }
        post(obj);
    }

    public Object removeStickyEvent(Class cls) {
        Object objCast;
        synchronized (this.stickyEvents) {
            objCast = cls.cast(this.stickyEvents.remove(cls));
        }
        return objCast;
    }

    private void postSingleEvent(Object obj, PostingThreadState postingThreadState) {
        boolean zPostSingleEventForEventType;
        Class<?> cls = obj.getClass();
        if (this.eventInheritance) {
            List listLookupAllEventTypes = lookupAllEventTypes(cls);
            int size = listLookupAllEventTypes.size();
            zPostSingleEventForEventType = false;
            for (int i = 0; i < size; i++) {
                zPostSingleEventForEventType |= postSingleEventForEventType(obj, postingThreadState, (Class) listLookupAllEventTypes.get(i));
            }
        } else {
            zPostSingleEventForEventType = postSingleEventForEventType(obj, postingThreadState, cls);
        }
        if (zPostSingleEventForEventType) {
            return;
        }
        if (this.logNoSubscriberMessages) {
            this.logger.log(Level.FINE, "No subscribers registered for event " + cls);
        }
        if (!this.sendNoSubscriberEvent || cls == NoSubscriberEvent.class || cls == SubscriberExceptionEvent.class) {
            return;
        }
        post(new NoSubscriberEvent(this, obj));
    }

    private boolean postSingleEventForEventType(Object obj, PostingThreadState postingThreadState, Class cls) {
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = (CopyOnWriteArrayList) this.subscriptionsByEventType.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (Subscription subscription : copyOnWriteArrayList) {
            postingThreadState.event = obj;
            postingThreadState.subscription = subscription;
            try {
                postToSubscription(subscription, obj, postingThreadState.isMainThread);
                boolean z = postingThreadState.canceled;
                postingThreadState.event = null;
                postingThreadState.subscription = null;
                postingThreadState.canceled = false;
                if (z) {
                    return true;
                }
            } catch (Throwable th) {
                postingThreadState.event = null;
                postingThreadState.subscription = null;
                postingThreadState.canceled = false;
                throw th;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: org.greenrobot.eventbus.EventBus$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$greenrobot$eventbus$ThreadMode;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            $SwitchMap$org$greenrobot$eventbus$ThreadMode = iArr;
            try {
                iArr[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$greenrobot$eventbus$ThreadMode[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$greenrobot$eventbus$ThreadMode[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$greenrobot$eventbus$ThreadMode[ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$greenrobot$eventbus$ThreadMode[ThreadMode.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void postToSubscription(Subscription subscription, Object obj, boolean z) {
        int i = AnonymousClass2.$SwitchMap$org$greenrobot$eventbus$ThreadMode[subscription.subscriberMethod.threadMode.ordinal()];
        if (i == 1) {
            invokeSubscriber(subscription, obj);
            return;
        }
        if (i == 2) {
            if (z) {
                invokeSubscriber(subscription, obj);
                return;
            } else {
                this.mainThreadPoster.enqueue(subscription, obj);
                return;
            }
        }
        if (i == 3) {
            Poster poster = this.mainThreadPoster;
            if (poster != null) {
                poster.enqueue(subscription, obj);
                return;
            } else {
                invokeSubscriber(subscription, obj);
                return;
            }
        }
        if (i == 4) {
            if (z) {
                this.backgroundPoster.enqueue(subscription, obj);
                return;
            } else {
                invokeSubscriber(subscription, obj);
                return;
            }
        }
        if (i == 5) {
            this.asyncPoster.enqueue(subscription, obj);
            return;
        }
        throw new IllegalStateException("Unknown thread mode: " + subscription.subscriberMethod.threadMode);
    }

    private static List lookupAllEventTypes(Class cls) {
        List arrayList;
        Map map = eventTypesCache;
        synchronized (map) {
            try {
                arrayList = (List) map.get(cls);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    for (Class superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                        arrayList.add(superclass);
                        addInterfaces(arrayList, superclass.getInterfaces());
                    }
                    eventTypesCache.put(cls, arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    static void addInterfaces(List list, Class[] clsArr) {
        for (Class cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                addInterfaces(list, cls.getInterfaces());
            }
        }
    }

    void invokeSubscriber(PendingPost pendingPost) {
        Object obj = pendingPost.event;
        Subscription subscription = pendingPost.subscription;
        PendingPost.releasePendingPost(pendingPost);
        if (subscription.active) {
            invokeSubscriber(subscription, obj);
        }
    }

    void invokeSubscriber(Subscription subscription, Object obj) {
        try {
            subscription.subscriberMethod.method.invoke(subscription.subscriber, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            handleSubscriberException(subscription, obj, e2.getCause());
        }
    }

    private void handleSubscriberException(Subscription subscription, Object obj, Throwable th) {
        if (obj instanceof SubscriberExceptionEvent) {
            if (this.logSubscriberExceptions) {
                Logger logger = this.logger;
                Level level = Level.SEVERE;
                logger.log(level, "SubscriberExceptionEvent subscriber " + subscription.subscriber.getClass() + " threw an exception", th);
                SubscriberExceptionEvent subscriberExceptionEvent = (SubscriberExceptionEvent) obj;
                this.logger.log(level, "Initial event " + subscriberExceptionEvent.causingEvent + " caused exception in " + subscriberExceptionEvent.causingSubscriber, subscriberExceptionEvent.throwable);
                return;
            }
            return;
        }
        if (this.throwSubscriberException) {
            throw new EventBusException("Invoking subscriber failed", th);
        }
        if (this.logSubscriberExceptions) {
            this.logger.log(Level.SEVERE, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + subscription.subscriber.getClass(), th);
        }
        if (this.sendSubscriberExceptionEvent) {
            post(new SubscriberExceptionEvent(this, th, obj, subscription.subscriber));
        }
    }

    static final class PostingThreadState {
        boolean canceled;
        Object event;
        final List eventQueue = new ArrayList();
        boolean isMainThread;
        boolean isPosting;
        Subscription subscription;

        PostingThreadState() {
        }
    }

    ExecutorService getExecutorService() {
        return this.executorService;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public String toString() {
        return "EventBus[indexCount=" + this.indexCount + ", eventInheritance=" + this.eventInheritance + "]";
    }
}
