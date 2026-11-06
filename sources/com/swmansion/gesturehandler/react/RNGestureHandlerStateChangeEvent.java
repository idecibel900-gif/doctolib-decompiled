package com.swmansion.gesturehandler.react;

import android.view.View;
import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.react.eventbuilders.GestureHandlerEventDataBuilder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class RNGestureHandlerStateChangeEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private static final Pools$SynchronizedPool EVENTS_POOL = new Pools$SynchronizedPool(7);
    private GestureHandlerEventDataBuilder dataBuilder;
    private int newState;
    private int oldState;

    public /* synthetic */ RNGestureHandlerStateChangeEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    private RNGestureHandlerStateChangeEvent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void init(GestureHandler gestureHandler, int i, int i2, GestureHandlerEventDataBuilder gestureHandlerEventDataBuilder) {
        View view = gestureHandler.getView();
        Intrinsics.checkNotNull(view);
        super.init(UIManagerHelper.getSurfaceId(view), view.getId());
        this.dataBuilder = gestureHandlerEventDataBuilder;
        this.newState = i;
        this.oldState = i2;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void onDispose() {
        this.dataBuilder = null;
        this.newState = 0;
        this.oldState = 0;
        EVENTS_POOL.release(this);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "onGestureHandlerStateChange";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        Companion companion = Companion;
        GestureHandlerEventDataBuilder gestureHandlerEventDataBuilder = this.dataBuilder;
        Intrinsics.checkNotNull(gestureHandlerEventDataBuilder);
        return companion.createEventData(gestureHandlerEventDataBuilder, this.newState, this.oldState);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RNGestureHandlerStateChangeEvent obtain(GestureHandler handler, int i, int i2, GestureHandlerEventDataBuilder dataBuilder) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(dataBuilder, "dataBuilder");
            RNGestureHandlerStateChangeEvent rNGestureHandlerStateChangeEvent = (RNGestureHandlerStateChangeEvent) RNGestureHandlerStateChangeEvent.EVENTS_POOL.acquire();
            if (rNGestureHandlerStateChangeEvent == null) {
                rNGestureHandlerStateChangeEvent = new RNGestureHandlerStateChangeEvent(null);
            }
            rNGestureHandlerStateChangeEvent.init(handler, i, i2, dataBuilder);
            return rNGestureHandlerStateChangeEvent;
        }

        public final WritableMap createEventData(GestureHandlerEventDataBuilder dataBuilder, int i, int i2) {
            Intrinsics.checkNotNullParameter(dataBuilder, "dataBuilder");
            WritableMap writableMapCreateMap = Arguments.createMap();
            dataBuilder.buildEventData(writableMapCreateMap);
            writableMapCreateMap.putInt("state", i);
            writableMapCreateMap.putInt("oldState", i2);
            return writableMapCreateMap;
        }
    }
}
