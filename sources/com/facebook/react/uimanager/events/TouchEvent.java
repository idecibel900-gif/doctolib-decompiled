package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.uimanager.common.ViewUtil;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TouchEvent extends Event {
    private short coalescingKey;
    private MotionEvent motionEvent;
    private TouchEventType touchEventType;
    private float viewX;
    private float viewY;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = TouchEvent.class.getSimpleName();
    private static final Pools$SynchronizedPool EVENTS_POOL = new Pools$SynchronizedPool(3);

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TouchEventType.values().length];
            try {
                iArr[TouchEventType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TouchEventType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TouchEventType.CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TouchEventType.MOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ TouchEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TouchEvent() {
    }

    public final float getViewX() {
        return this.viewX;
    }

    public final float getViewY() {
        return this.viewY;
    }

    public final MotionEvent getMotionEvent() {
        Object objAssertNotNull = Assertions.assertNotNull(this.motionEvent);
        Intrinsics.checkNotNullExpressionValue(objAssertNotNull, "assertNotNull(...)");
        return (MotionEvent) objAssertNotNull;
    }

    public final TouchEventType getTouchEventType() {
        Object objAssertNotNull = Assertions.assertNotNull(this.touchEventType);
        Intrinsics.checkNotNullExpressionValue(objAssertNotNull, "assertNotNull(...)");
        return (TouchEventType) objAssertNotNull;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void init(int i, int i2, TouchEventType touchEventType, MotionEvent motionEvent, long j, float f, float f2, TouchEventCoalescingKeyHelper touchEventCoalescingKeyHelper) {
        super.init(i, i2, motionEvent.getEventTime());
        short coalescingKey = 0;
        SoftAssertions.assertCondition(j != Long.MIN_VALUE, "Gesture start time must be initialized");
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            touchEventCoalescingKeyHelper.addCoalescingKey(j);
        } else if (action == 1) {
            touchEventCoalescingKeyHelper.removeCoalescingKey(j);
        } else if (action == 2) {
            coalescingKey = touchEventCoalescingKeyHelper.getCoalescingKey(j);
        } else if (action == 3) {
            touchEventCoalescingKeyHelper.removeCoalescingKey(j);
        } else if (action == 5 || action == 6) {
            touchEventCoalescingKeyHelper.incrementCoalescingKey(j);
        }
        this.motionEvent = MotionEvent.obtain(motionEvent);
        this.touchEventType = touchEventType;
        this.coalescingKey = coalescingKey;
        this.viewX = f;
        this.viewY = f2;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void onDispose() {
        MotionEvent motionEvent = this.motionEvent;
        if (motionEvent != null) {
            motionEvent.recycle();
        }
        this.motionEvent = null;
        try {
            EVENTS_POOL.release(this);
        } catch (IllegalStateException e) {
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ReactSoftExceptionLogger.logSoftException(TAG2, e);
        }
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        TouchEventType.Companion companion = TouchEventType.Companion;
        Object objAssertNotNull = Assertions.assertNotNull(this.touchEventType);
        Intrinsics.checkNotNullExpressionValue(objAssertNotNull, "assertNotNull(...)");
        return companion.getJSEventName((TouchEventType) objAssertNotNull);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        TouchEventType touchEventType = (TouchEventType) Assertions.assertNotNull(this.touchEventType);
        int i = touchEventType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[touchEventType.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return false;
        }
        if (i == 4) {
            return true;
        }
        throw new RuntimeException("Unknown touch event type: " + this.touchEventType);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return this.coalescingKey;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        if (verifyMotionEvent()) {
            TouchesHelper.sendTouchesLegacy(rctEventEmitter, this);
        }
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatchModern(RCTModernEventEmitter rctEventEmitter) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        if (verifyMotionEvent()) {
            int uIManagerType = ViewUtil.getUIManagerType(getViewTag(), getSurfaceId());
            if (uIManagerType == 1) {
                TouchesHelper.sendTouchesLegacy(rctEventEmitter, this);
            } else {
                if (uIManagerType != 2) {
                    return;
                }
                TouchesHelper.sendTouchEvent(rctEventEmitter, this);
            }
        }
    }

    @Override // com.facebook.react.uimanager.events.Event
    public int getEventCategory() {
        TouchEventType touchEventType = this.touchEventType;
        if (touchEventType == null) {
            return 2;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[touchEventType.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2 || i == 3) {
            return 1;
        }
        if (i == 4) {
            return 4;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean verifyMotionEvent() {
        if (this.motionEvent != null) {
            return true;
        }
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        ReactSoftExceptionLogger.logSoftException(TAG2, new IllegalStateException("Cannot dispatch a TouchEvent that has no MotionEvent; the TouchEvent has been recycled"));
        return false;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TouchEvent obtain(int i, int i2, TouchEventType touchEventType, MotionEvent motionEvent, long j, float f, float f2, TouchEventCoalescingKeyHelper touchEventCoalescingKeyHelper) {
            Intrinsics.checkNotNullParameter(touchEventCoalescingKeyHelper, "touchEventCoalescingKeyHelper");
            TouchEvent touchEvent = (TouchEvent) TouchEvent.EVENTS_POOL.acquire();
            if (touchEvent == null) {
                touchEvent = new TouchEvent(null);
            }
            TouchEvent touchEvent2 = touchEvent;
            Object objAssertNotNull = Assertions.assertNotNull(motionEvent);
            Intrinsics.checkNotNullExpressionValue(objAssertNotNull, "assertNotNull(...)");
            touchEvent2.init(i, i2, touchEventType, (MotionEvent) objAssertNotNull, j, f, f2, touchEventCoalescingKeyHelper);
            return touchEvent2;
        }
    }
}
