package com.facebook.react.views.scroll;

import android.os.SystemClock;
import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableMapBuilder;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.events.Event;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ScrollEvent extends Event {
    private int contentHeight;
    private int contentWidth;
    private ScrollEventType scrollEventType;
    private int scrollViewHeight;
    private int scrollViewWidth;
    private float scrollX;
    private float scrollY;
    private long timestamp;
    private float xVelocity;
    private float yVelocity;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = ScrollEvent.class.getSimpleName();
    private static final Pools$SynchronizedPool EVENTS_POOL = new Pools$SynchronizedPool(3);

    public /* synthetic */ ScrollEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final ScrollEvent obtain(int i, ScrollEventType scrollEventType, float f, float f2, float f3, float f4, int i2, int i3, int i4, int i5) {
        return Companion.obtain(i, scrollEventType, f, f2, f3, f4, i2, i3, i4, i5);
    }

    private ScrollEvent() {
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
        readableMapBuilder.put("top", 0.0d);
        readableMapBuilder.put("bottom", 0.0d);
        readableMapBuilder.put("left", 0.0d);
        readableMapBuilder.put("right", 0.0d);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        ReadableMapBuilder readableMapBuilder2 = new ReadableMapBuilder(writableMapCreateMap2);
        readableMapBuilder2.put("x", PixelUtil.toDIPFromPixel(this.scrollX));
        readableMapBuilder2.put("y", PixelUtil.toDIPFromPixel(this.scrollY));
        WritableMap writableMapCreateMap3 = Arguments.createMap();
        ReadableMapBuilder readableMapBuilder3 = new ReadableMapBuilder(writableMapCreateMap3);
        readableMapBuilder3.put("width", PixelUtil.toDIPFromPixel(this.contentWidth));
        readableMapBuilder3.put("height", PixelUtil.toDIPFromPixel(this.contentHeight));
        WritableMap writableMapCreateMap4 = Arguments.createMap();
        ReadableMapBuilder readableMapBuilder4 = new ReadableMapBuilder(writableMapCreateMap4);
        readableMapBuilder4.put("width", PixelUtil.toDIPFromPixel(this.scrollViewWidth));
        readableMapBuilder4.put("height", PixelUtil.toDIPFromPixel(this.scrollViewHeight));
        WritableMap writableMapCreateMap5 = Arguments.createMap();
        ReadableMapBuilder readableMapBuilder5 = new ReadableMapBuilder(writableMapCreateMap5);
        readableMapBuilder5.put("x", PixelUtil.toDIPFromPixel(this.xVelocity));
        readableMapBuilder5.put("y", PixelUtil.toDIPFromPixel(this.yVelocity));
        WritableMap writableMapCreateMap6 = Arguments.createMap();
        writableMapCreateMap6.putMap("contentInset", writableMapCreateMap);
        writableMapCreateMap6.putMap("contentOffset", writableMapCreateMap2);
        writableMapCreateMap6.putMap("contentSize", writableMapCreateMap3);
        writableMapCreateMap6.putMap("layoutMeasurement", writableMapCreateMap4);
        writableMapCreateMap6.putMap("velocity", writableMapCreateMap5);
        writableMapCreateMap6.putInt("target", getViewTag());
        writableMapCreateMap6.putDouble(DiagnosticsEntry.TIMESTAMP_KEY, this.timestamp);
        writableMapCreateMap6.putBoolean("responderIgnoreScroll", !ReactNativeFeatureFlags.shouldTriggerResponderTransferOnScrollAndroid());
        return writableMapCreateMap6;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void onDispose() {
        try {
            EVENTS_POOL.release(this);
        } catch (IllegalStateException e) {
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ReactSoftExceptionLogger.logSoftException(TAG2, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void init(int i, int i2, ScrollEventType scrollEventType, float f, float f2, float f3, float f4, int i3, int i4, int i5, int i6) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        super.init(i, i2, jUptimeMillis);
        this.scrollEventType = scrollEventType;
        this.scrollX = f;
        this.scrollY = f2;
        this.xVelocity = f3;
        this.yVelocity = f4;
        this.contentWidth = i3;
        this.contentHeight = i4;
        this.scrollViewWidth = i5;
        this.scrollViewHeight = i6;
        this.timestamp = jUptimeMillis;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        ScrollEventType.Companion companion = ScrollEventType.Companion;
        Object objAssertNotNull = Assertions.assertNotNull(this.scrollEventType);
        Intrinsics.checkNotNullExpressionValue(objAssertNotNull, "assertNotNull(...)");
        return companion.getJSEventName((ScrollEventType) objAssertNotNull);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return this.scrollEventType == ScrollEventType.SCROLL;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ScrollEvent obtain(int i, int i2, ScrollEventType scrollEventType, float f, float f2, float f3, float f4, int i3, int i4, int i5, int i6) {
            ScrollEvent scrollEvent = (ScrollEvent) ScrollEvent.EVENTS_POOL.acquire();
            if (scrollEvent == null) {
                scrollEvent = new ScrollEvent(null);
            }
            ScrollEvent scrollEvent2 = scrollEvent;
            scrollEvent2.init(i, i2, scrollEventType, f, f2, f3, f4, i3, i4, i5, i6);
            return scrollEvent2;
        }

        public final ScrollEvent obtain(int i, ScrollEventType scrollEventType, float f, float f2, float f3, float f4, int i2, int i3, int i4, int i5) {
            return obtain(-1, i, scrollEventType, f, f2, f3, f4, i2, i3, i4, i5);
        }
    }
}
