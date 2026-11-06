package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.SystemClock;
import kotlin.Deprecated;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Event {
    private static final Companion Companion = new Companion(null);
    private static int uniqueIdCounter;
    private EventAnimationDriverMatchSpec eventAnimationDriverMatchSpecCached;
    private boolean isInitialized;
    private int surfaceId;
    private long timestampMs;
    private final int uniqueID;
    private int viewTag;

    public interface EventAnimationDriverMatchSpec {
        boolean match(int i, String str);
    }

    public boolean canCoalesce() {
        return true;
    }

    protected boolean experimental_isSynchronous() {
        return false;
    }

    public short getCoalescingKey() {
        return (short) 0;
    }

    protected int getEventCategory() {
        return 2;
    }

    protected WritableMap getEventData() {
        return null;
    }

    public abstract String getEventName();

    public void onDispose() {
    }

    public final boolean isInitialized() {
        return this.isInitialized;
    }

    public final int getSurfaceId() {
        return this.surfaceId;
    }

    public final int getViewTag() {
        return this.viewTag;
    }

    public final long getTimestampMs() {
        return this.timestampMs;
    }

    public final int getUniqueID() {
        return this.uniqueID;
    }

    protected Event() {
        int i = uniqueIdCounter;
        uniqueIdCounter = i + 1;
        this.uniqueID = i;
    }

    protected Event(int i) {
        int i2 = uniqueIdCounter;
        uniqueIdCounter = i2 + 1;
        this.uniqueID = i2;
        init(i);
    }

    protected Event(int i, int i2) {
        int i3 = uniqueIdCounter;
        uniqueIdCounter = i3 + 1;
        this.uniqueID = i3;
        init(i, i2);
    }

    @Deprecated
    protected final void init(int i) {
        init(-1, i);
    }

    protected final void init(int i, int i2, long j) {
        this.surfaceId = i;
        this.viewTag = i2;
        this.timestampMs = j;
        this.isInitialized = true;
    }

    protected final void init(int i, int i2) {
        init(i, i2, SystemClock.uptimeMillis());
    }

    public Event coalesce(Event event) {
        return this.timestampMs >= (event != null ? event.timestampMs : 0L) ? this : event;
    }

    public final void dispose() {
        this.isInitialized = false;
        onDispose();
    }

    public final String internal_getEventNameCompat() {
        return getEventName();
    }

    public EventAnimationDriverMatchSpec getEventAnimationDriverMatchSpec() {
        if (this.eventAnimationDriverMatchSpecCached == null) {
            this.eventAnimationDriverMatchSpecCached = new EventAnimationDriverMatchSpec() { // from class: com.facebook.react.uimanager.events.Event$eventAnimationDriverMatchSpec$1
                @Override // com.facebook.react.uimanager.events.Event.EventAnimationDriverMatchSpec
                public boolean match(int i, String eventNameRhs) {
                    Intrinsics.checkNotNullParameter(eventNameRhs, "eventNameRhs");
                    return this.this$0.getViewTag() == i && Intrinsics.areEqual(this.this$0.internal_getEventNameCompat(), eventNameRhs);
                }
            };
        }
        return this.eventAnimationDriverMatchSpecCached;
    }

    @Deprecated
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        rctEventEmitter.receiveEvent(this.viewTag, internal_getEventNameCompat(), getEventData());
    }

    public final WritableMap internal_getEventData$ReactAndroid_release() {
        return getEventData();
    }

    public final int internal_getEventCategory$ReactAndroid_release() {
        return getEventCategory();
    }

    public final boolean internal_experimental_isSynchronous$ReactAndroid_release() {
        return experimental_isSynchronous();
    }

    public void dispatchModern(RCTModernEventEmitter rctEventEmitter) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        int i = this.surfaceId;
        if (i != -1) {
            rctEventEmitter.receiveEvent(i, this.viewTag, internal_getEventNameCompat(), canCoalesce(), getCoalescingKey(), getEventData(), getEventCategory());
        } else {
            dispatch(rctEventEmitter);
        }
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
