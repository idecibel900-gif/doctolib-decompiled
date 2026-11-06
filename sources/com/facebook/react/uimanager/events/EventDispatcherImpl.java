package com.facebook.react.uimanager.events;

import android.util.LongSparseArray;
import android.view.Choreographer;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.systrace.Systrace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public final class EventDispatcherImpl implements EventDispatcher, LifecycleEventListener {
    public static final Companion Companion = new Companion(null);
    private static final Comparator EVENT_COMPARATOR = new Comparator() { // from class: com.facebook.react.uimanager.events.EventDispatcherImpl$$ExternalSyntheticLambda1
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return EventDispatcherImpl.EVENT_COMPARATOR$lambda$5((Event) obj, (Event) obj2);
        }
    };
    private final ScheduleDispatchFrameCallback currentFrameCallback;
    private final DispatchEventsRunnable dispatchEventsRunnable;
    private final LongSparseArray eventCookieToLastEventIdx;
    private final Map eventNameToEventId;
    private final ArrayList eventStaging;
    private final Object eventsStagingLock;
    private Event[] eventsToDispatch;
    private final Object eventsToDispatchLock;
    private int eventsToDispatchSize;
    private volatile boolean hasDispatchScheduled;
    private final AtomicInteger hasDispatchScheduledCount;
    private final CopyOnWriteArrayList listeners;
    private short nextEventTypeId;
    private final CopyOnWriteArrayList postEventDispatchListeners;
    private final ReactApplicationContext reactContext;
    private final EventEmitterImpl reactEventEmitter;

    public EventDispatcherImpl(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.eventsStagingLock = new Object();
        this.eventsToDispatchLock = new Object();
        this.eventCookieToLastEventIdx = new LongSparseArray();
        this.eventNameToEventId = new LinkedHashMap();
        this.dispatchEventsRunnable = new DispatchEventsRunnable();
        this.eventStaging = new ArrayList();
        this.listeners = new CopyOnWriteArrayList();
        this.postEventDispatchListeners = new CopyOnWriteArrayList();
        this.currentFrameCallback = new ScheduleDispatchFrameCallback();
        this.hasDispatchScheduledCount = new AtomicInteger();
        this.eventsToDispatch = new Event[16];
        reactContext.addLifecycleEventListener(this);
        this.reactEventEmitter = new EventEmitterImpl(reactContext);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public void dispatchEvent(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!event.isInitialized()) {
            throw new IllegalArgumentException("Dispatched event hasn't been initialized");
        }
        Iterator it = this.listeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ((EventDispatcherListener) it.next()).onEventDispatch(event);
        }
        synchronized (this.eventsStagingLock) {
            this.eventStaging.add(event);
            Systrace.startAsyncFlow(0L, event.getEventName(), event.getUniqueID());
            Unit unit = Unit.INSTANCE;
        }
        maybePostFrameCallbackFromNonUI();
    }

    private final void maybePostFrameCallbackFromNonUI() {
        this.currentFrameCallback.maybePostFromNonUI();
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public void addListener(EventDispatcherListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public void removeListener(EventDispatcherListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        maybePostFrameCallbackFromNonUI();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        stopFrameCallback();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        stopFrameCallback();
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public void onCatalystInstanceDestroyed() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.uimanager.events.EventDispatcherImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.stopFrameCallback();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopFrameCallback() {
        UiThreadUtil.assertOnUiThread();
        this.currentFrameCallback.stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveStagedEventsToDispatchQueue() {
        synchronized (this.eventsStagingLock) {
            synchronized (this.eventsToDispatchLock) {
                try {
                    int size = this.eventStaging.size();
                    for (int i = 0; i < size; i++) {
                        Object obj = this.eventStaging.get(i);
                        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                        Event event = (Event) obj;
                        if (!event.canCoalesce()) {
                            addEventToEventsToDispatch(event);
                        } else {
                            long eventCookie = getEventCookie(event.getViewTag(), event.getEventName(), event.getCoalescingKey());
                            Integer num = (Integer) this.eventCookieToLastEventIdx.get(eventCookie);
                            Event event2 = null;
                            if (num == null) {
                                this.eventCookieToLastEventIdx.put(eventCookie, Integer.valueOf(this.eventsToDispatchSize));
                            } else {
                                Event event3 = this.eventsToDispatch[num.intValue()];
                                if (event3 == null) {
                                    throw new IllegalStateException("Required value was null.");
                                }
                                Event eventCoalesce = event.coalesce(event3);
                                if (eventCoalesce != event3) {
                                    this.eventCookieToLastEventIdx.put(eventCookie, Integer.valueOf(this.eventsToDispatchSize));
                                    this.eventsToDispatch[num.intValue()] = null;
                                    event2 = event3;
                                    event = eventCoalesce;
                                } else {
                                    event2 = event;
                                    event = null;
                                }
                            }
                            if (event != null) {
                                addEventToEventsToDispatch(event);
                            }
                            if (event2 != null) {
                                event2.dispose();
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.eventStaging.clear();
        }
    }

    private final long getEventCookie(int i, String str, short s) {
        short sShortValue;
        Short sh = (Short) this.eventNameToEventId.get(str);
        if (sh != null) {
            sShortValue = sh.shortValue();
        } else {
            short s2 = this.nextEventTypeId;
            this.nextEventTypeId = (short) (s2 + 1);
            this.eventNameToEventId.put(str, Short.valueOf(s2));
            sShortValue = s2;
        }
        return Companion.getEventCookie(i, sShortValue, s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class ScheduleDispatchFrameCallback implements Choreographer.FrameCallback {
        private volatile boolean isPosted;
        private boolean shouldStop;

        public ScheduleDispatchFrameCallback() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            UiThreadUtil.assertOnUiThread();
            if (this.shouldStop) {
                this.isPosted = false;
            } else {
                post();
            }
            Systrace.beginSection(0L, "ScheduleDispatchFrameCallback");
            try {
                EventDispatcherImpl.this.moveStagedEventsToDispatchQueue();
                if (!EventDispatcherImpl.this.hasDispatchScheduled) {
                    EventDispatcherImpl.this.hasDispatchScheduled = true;
                    Systrace.startAsyncFlow(0L, "ScheduleDispatchFrameCallback", EventDispatcherImpl.this.hasDispatchScheduledCount.get());
                    EventDispatcherImpl.this.reactContext.runOnJSQueueThread(EventDispatcherImpl.this.dispatchEventsRunnable);
                }
            } finally {
                Systrace.endSection(0L);
            }
        }

        public final void stop() {
            this.shouldStop = true;
        }

        public final void maybePost() {
            if (this.isPosted) {
                return;
            }
            this.isPosted = true;
            post();
        }

        public final void post() {
            ReactChoreographer.Companion.getInstance().postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, EventDispatcherImpl.this.currentFrameCallback);
        }

        public final void maybePostFromNonUI() {
            if (this.isPosted) {
                return;
            }
            if (!EventDispatcherImpl.this.reactContext.isOnUiQueueThread()) {
                EventDispatcherImpl.this.reactContext.runOnUiQueueThread(new Runnable() { // from class: com.facebook.react.uimanager.events.EventDispatcherImpl$ScheduleDispatchFrameCallback$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.maybePost();
                    }
                });
            } else {
                maybePost();
            }
        }
    }

    private final class DispatchEventsRunnable implements Runnable {
        public DispatchEventsRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Systrace.beginSection(0L, "DispatchEventsRunnable");
            try {
                Systrace.endAsyncFlow(0L, "ScheduleDispatchFrameCallback", EventDispatcherImpl.this.hasDispatchScheduledCount.getAndIncrement());
                EventDispatcherImpl.this.hasDispatchScheduled = false;
                Object obj = EventDispatcherImpl.this.eventsToDispatchLock;
                EventDispatcherImpl eventDispatcherImpl = EventDispatcherImpl.this;
                synchronized (obj) {
                    try {
                        if (eventDispatcherImpl.eventsToDispatchSize > 0) {
                            if (eventDispatcherImpl.eventsToDispatchSize > 1) {
                                Arrays.sort(eventDispatcherImpl.eventsToDispatch, 0, eventDispatcherImpl.eventsToDispatchSize, EventDispatcherImpl.EVENT_COMPARATOR);
                            }
                            int i = eventDispatcherImpl.eventsToDispatchSize;
                            for (int i2 = 0; i2 < i; i2++) {
                                Event event = eventDispatcherImpl.eventsToDispatch[i2];
                                if (event != null) {
                                    Systrace.endAsyncFlow(0L, event.getEventName(), event.getUniqueID());
                                    event.dispatchModern(eventDispatcherImpl.reactEventEmitter);
                                    event.dispose();
                                }
                            }
                            eventDispatcherImpl.clearEventsToDispatch();
                            eventDispatcherImpl.eventCookieToLastEventIdx.clear();
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                Iterator it = EventDispatcherImpl.this.postEventDispatchListeners.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    ((BatchEventDispatchedListener) it.next()).onBatchEventDispatched();
                }
                Systrace.endSection(0L);
            } catch (Throwable th2) {
                Systrace.endSection(0L);
                throw th2;
            }
        }
    }

    private final void addEventToEventsToDispatch(Event event) {
        int i = this.eventsToDispatchSize;
        Event[] eventArr = this.eventsToDispatch;
        if (i == eventArr.length) {
            Object[] objArrCopyOf = Arrays.copyOf(eventArr, eventArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            this.eventsToDispatch = (Event[]) objArrCopyOf;
        }
        Event[] eventArr2 = this.eventsToDispatch;
        int i2 = this.eventsToDispatchSize;
        this.eventsToDispatchSize = i2 + 1;
        eventArr2[i2] = event;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearEventsToDispatch() {
        Arrays.fill(this.eventsToDispatch, 0, this.eventsToDispatchSize, (Object) null);
        this.eventsToDispatchSize = 0;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long getEventCookie(int i, short s, short s2) {
            return ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((long) i) | ((((long) s2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int EVENT_COMPARATOR$lambda$5(Event event, Event event2) {
        if (event == null && event2 == null) {
            return 0;
        }
        if (event == null) {
            return -1;
        }
        if (event2 == null) {
            return 1;
        }
        long timestampMs = event.getTimestampMs() - event2.getTimestampMs();
        if (timestampMs == 0) {
            return 0;
        }
        return timestampMs < 0 ? -1 : 1;
    }
}
