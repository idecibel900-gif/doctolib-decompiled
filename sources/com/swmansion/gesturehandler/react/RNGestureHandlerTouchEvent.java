package com.swmansion.gesturehandler.react;

import android.view.View;
import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.gesturehandler.core.GestureHandler;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class RNGestureHandlerTouchEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private static final Pools$SynchronizedPool EVENTS_POOL = new Pools$SynchronizedPool(7);
    private short coalescingKey;
    private WritableMap extraData;

    public /* synthetic */ RNGestureHandlerTouchEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return true;
    }

    private RNGestureHandlerTouchEvent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void init(GestureHandler gestureHandler) {
        View view = gestureHandler.getView();
        Intrinsics.checkNotNull(view);
        super.init(UIManagerHelper.getSurfaceId(view), view.getId());
        this.extraData = Companion.createEventData(gestureHandler);
        this.coalescingKey = gestureHandler.getEventCoalescingKey();
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void onDispose() {
        this.extraData = null;
        EVENTS_POOL.release(this);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "onGestureHandlerEvent";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return this.coalescingKey;
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        return this.extraData;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RNGestureHandlerTouchEvent obtain(GestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            RNGestureHandlerTouchEvent rNGestureHandlerTouchEvent = (RNGestureHandlerTouchEvent) RNGestureHandlerTouchEvent.EVENTS_POOL.acquire();
            if (rNGestureHandlerTouchEvent == null) {
                rNGestureHandlerTouchEvent = new RNGestureHandlerTouchEvent(null);
            }
            rNGestureHandlerTouchEvent.init(handler);
            return rNGestureHandlerTouchEvent;
        }

        public final WritableMap createEventData(GestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putInt("handlerTag", handler.getTag());
            writableMapCreateMap.putInt("state", handler.getState());
            writableMapCreateMap.putInt("numberOfTouches", handler.getTrackedPointersCount());
            writableMapCreateMap.putInt("eventType", handler.getTouchEventType());
            writableMapCreateMap.putInt("pointerType", handler.getPointerType());
            WritableArray writableArrayConsumeChangedTouchesPayload = handler.consumeChangedTouchesPayload();
            if (writableArrayConsumeChangedTouchesPayload != null) {
                writableMapCreateMap.putArray("changedTouches", writableArrayConsumeChangedTouchesPayload);
            }
            WritableArray writableArrayConsumeAllTouchesPayload = handler.consumeAllTouchesPayload();
            if (writableArrayConsumeAllTouchesPayload != null) {
                writableMapCreateMap.putArray("allTouches", writableArrayConsumeAllTouchesPayload);
            }
            if (handler.isAwaiting() && handler.getState() == 4) {
                writableMapCreateMap.putInt("state", 2);
            }
            return writableMapCreateMap;
        }
    }
}
