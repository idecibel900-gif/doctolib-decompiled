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
public final class RNGestureHandlerEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private static final Pools$SynchronizedPool EVENTS_POOL = new Pools$SynchronizedPool(7);
    private short coalescingKey;
    private GestureHandlerEventDataBuilder dataBuilder;
    private boolean useTopPrefixedName;

    public /* synthetic */ RNGestureHandlerEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return true;
    }

    private RNGestureHandlerEvent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void init(GestureHandler gestureHandler, GestureHandlerEventDataBuilder gestureHandlerEventDataBuilder, boolean z) {
        View view = gestureHandler.getView();
        Intrinsics.checkNotNull(view);
        super.init(UIManagerHelper.getSurfaceId(view), view.getId());
        this.dataBuilder = gestureHandlerEventDataBuilder;
        this.useTopPrefixedName = z;
        this.coalescingKey = gestureHandler.getEventCoalescingKey();
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void onDispose() {
        this.dataBuilder = null;
        EVENTS_POOL.release(this);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        if (this.useTopPrefixedName) {
            return "topGestureHandlerEvent";
        }
        return "onGestureHandlerEvent";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return this.coalescingKey;
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        Companion companion = Companion;
        GestureHandlerEventDataBuilder gestureHandlerEventDataBuilder = this.dataBuilder;
        Intrinsics.checkNotNull(gestureHandlerEventDataBuilder);
        return companion.createEventData(gestureHandlerEventDataBuilder);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ RNGestureHandlerEvent obtain$default(Companion companion, GestureHandler gestureHandler, GestureHandlerEventDataBuilder gestureHandlerEventDataBuilder, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.obtain(gestureHandler, gestureHandlerEventDataBuilder, z);
        }

        public final RNGestureHandlerEvent obtain(GestureHandler handler, GestureHandlerEventDataBuilder dataBuilder, boolean z) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(dataBuilder, "dataBuilder");
            RNGestureHandlerEvent rNGestureHandlerEvent = (RNGestureHandlerEvent) RNGestureHandlerEvent.EVENTS_POOL.acquire();
            if (rNGestureHandlerEvent == null) {
                rNGestureHandlerEvent = new RNGestureHandlerEvent(null);
            }
            rNGestureHandlerEvent.init(handler, dataBuilder, z);
            return rNGestureHandlerEvent;
        }

        public final WritableMap createEventData(GestureHandlerEventDataBuilder dataBuilder) {
            Intrinsics.checkNotNullParameter(dataBuilder, "dataBuilder");
            WritableMap writableMapCreateMap = Arguments.createMap();
            dataBuilder.buildEventData(writableMapCreateMap);
            return writableMapCreateMap;
        }
    }
}
