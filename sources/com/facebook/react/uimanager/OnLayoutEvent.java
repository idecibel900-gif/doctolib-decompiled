package com.facebook.react.uimanager;

import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMapBuilder;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class OnLayoutEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private static final Pools$SynchronizedPool EVENTS_POOL;
    private int height;
    private int width;
    private int x;
    private int y;

    public /* synthetic */ OnLayoutEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final OnLayoutEvent obtain(int i, int i2, int i3, int i4, int i5, int i6) {
        return Companion.obtain(i, i2, i3, i4, i5, i6);
    }

    private OnLayoutEvent() {
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
        readableMapBuilder.put("x", PixelUtil.toDIPFromPixel(this.x));
        readableMapBuilder.put("y", PixelUtil.toDIPFromPixel(this.y));
        readableMapBuilder.put("width", PixelUtil.toDIPFromPixel(this.width));
        readableMapBuilder.put("height", PixelUtil.toDIPFromPixel(this.height));
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putMap("layout", writableMapCreateMap);
        writableMapCreateMap2.putInt("target", getViewTag());
        return writableMapCreateMap2;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void onDispose() {
        EVENTS_POOL.release(this);
    }

    protected final void init(int i, int i2, int i3, int i4, int i5, int i6) {
        super.init(i, i2);
        this.x = i3;
        this.y = i4;
        this.width = i5;
        this.height = i6;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topLayout";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OnLayoutEvent obtain(int i, int i2, int i3, int i4, int i5, int i6) {
            OnLayoutEvent onLayoutEvent = (OnLayoutEvent) OnLayoutEvent.EVENTS_POOL.acquire();
            if (onLayoutEvent == null) {
                onLayoutEvent = new OnLayoutEvent(null);
            }
            OnLayoutEvent onLayoutEvent2 = onLayoutEvent;
            onLayoutEvent2.init(i, i2, i3, i4, i5, i6);
            return onLayoutEvent2;
        }
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture("OnLayoutEvent", LegacyArchitectureLogLevel.WARNING);
        EVENTS_POOL = new Pools$SynchronizedPool(20);
    }
}
