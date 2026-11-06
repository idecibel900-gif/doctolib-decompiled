package com.facebook.react.uimanager;

import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.TouchEvent;
import com.facebook.react.uimanager.events.TouchEventCoalescingKeyHelper;
import com.facebook.react.uimanager.events.TouchEventType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class JSTouchDispatcher {
    private boolean childIsHandlingNativeGesture;
    private long gestureStartTime;
    private final float[] targetCoordinates;
    private int targetTag;
    private final TouchEventCoalescingKeyHelper touchEventCoalescingKeyHelper;
    private final ViewGroup viewGroup;

    public JSTouchDispatcher(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        this.viewGroup = viewGroup;
        this.targetTag = -1;
        this.targetCoordinates = new float[2];
        this.gestureStartTime = Long.MIN_VALUE;
        this.touchEventCoalescingKeyHelper = new TouchEventCoalescingKeyHelper();
    }

    public final void onChildStartedNativeGesture(MotionEvent androidEvent, EventDispatcher eventDispatcher) {
        Intrinsics.checkNotNullParameter(androidEvent, "androidEvent");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        onChildStartedNativeGesture(androidEvent, eventDispatcher, null);
    }

    public final void onChildStartedNativeGesture(MotionEvent androidEvent, EventDispatcher eventDispatcher, ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(androidEvent, "androidEvent");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        if (this.childIsHandlingNativeGesture) {
            return;
        }
        dispatchCancelEvent(androidEvent, eventDispatcher);
        this.childIsHandlingNativeGesture = true;
        if (this.targetTag != -1 && ReactNativeFeatureFlags.sweepActiveTouchOnChildNativeGesturesAndroid()) {
            sweepActiveTouchForTag(UIManagerHelper.getSurfaceId(this.viewGroup), this.targetTag, reactContext);
        }
        this.targetTag = -1;
    }

    public final void onChildEndedNativeGesture(MotionEvent androidEvent, EventDispatcher eventDispatcher) {
        Intrinsics.checkNotNullParameter(androidEvent, "androidEvent");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        this.childIsHandlingNativeGesture = false;
    }

    public final void handleTouchEvent(MotionEvent ev, EventDispatcher eventDispatcher) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        handleTouchEvent(ev, eventDispatcher, null);
    }

    public final void handleTouchEvent(MotionEvent ev, EventDispatcher eventDispatcher, ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        int action = ev.getAction() & 255;
        if (action == 0) {
            if (this.targetTag != -1) {
                FLog.e("ReactNative", "Got DOWN touch before receiving UP or CANCEL from last gesture");
            }
            this.childIsHandlingNativeGesture = false;
            this.gestureStartTime = ev.getEventTime();
            this.targetTag = findTargetTagAndSetCoordinates(ev);
            markActiveTouchForTag(UIManagerHelper.getSurfaceId(this.viewGroup), this.targetTag, reactContext);
            TouchEvent.Companion companion = TouchEvent.Companion;
            int surfaceId = UIManagerHelper.getSurfaceId(this.viewGroup);
            int i = this.targetTag;
            TouchEventType touchEventType = TouchEventType.START;
            long j = this.gestureStartTime;
            float[] fArr = this.targetCoordinates;
            eventDispatcher.dispatchEvent(companion.obtain(surfaceId, i, touchEventType, ev, j, fArr[0], fArr[1], this.touchEventCoalescingKeyHelper));
            return;
        }
        if (this.childIsHandlingNativeGesture) {
            return;
        }
        int i2 = this.targetTag;
        if (i2 == -1) {
            FLog.e("ReactNative", "Unexpected state: received touch event but didn't get starting ACTION_DOWN for this gesture before");
            return;
        }
        if (action == 1) {
            findTargetTagAndSetCoordinates(ev);
            int surfaceId2 = UIManagerHelper.getSurfaceId(this.viewGroup);
            TouchEvent.Companion companion2 = TouchEvent.Companion;
            int i3 = this.targetTag;
            TouchEventType touchEventType2 = TouchEventType.END;
            long j2 = this.gestureStartTime;
            float[] fArr2 = this.targetCoordinates;
            eventDispatcher.dispatchEvent(companion2.obtain(surfaceId2, i3, touchEventType2, ev, j2, fArr2[0], fArr2[1], this.touchEventCoalescingKeyHelper));
            sweepActiveTouchForTag(surfaceId2, this.targetTag, reactContext);
            this.targetTag = -1;
            this.gestureStartTime = Long.MIN_VALUE;
            return;
        }
        if (action == 2) {
            findTargetTagAndSetCoordinates(ev);
            TouchEvent.Companion companion3 = TouchEvent.Companion;
            int surfaceId3 = UIManagerHelper.getSurfaceId(this.viewGroup);
            int i4 = this.targetTag;
            TouchEventType touchEventType3 = TouchEventType.MOVE;
            long j3 = this.gestureStartTime;
            float[] fArr3 = this.targetCoordinates;
            eventDispatcher.dispatchEvent(companion3.obtain(surfaceId3, i4, touchEventType3, ev, j3, fArr3[0], fArr3[1], this.touchEventCoalescingKeyHelper));
            return;
        }
        if (action == 5) {
            TouchEvent.Companion companion4 = TouchEvent.Companion;
            int surfaceId4 = UIManagerHelper.getSurfaceId(this.viewGroup);
            int i5 = this.targetTag;
            TouchEventType touchEventType4 = TouchEventType.START;
            long j4 = this.gestureStartTime;
            float[] fArr4 = this.targetCoordinates;
            eventDispatcher.dispatchEvent(companion4.obtain(surfaceId4, i5, touchEventType4, ev, j4, fArr4[0], fArr4[1], this.touchEventCoalescingKeyHelper));
            return;
        }
        if (action == 6) {
            TouchEvent.Companion companion5 = TouchEvent.Companion;
            int surfaceId5 = UIManagerHelper.getSurfaceId(this.viewGroup);
            int i6 = this.targetTag;
            TouchEventType touchEventType5 = TouchEventType.END;
            long j5 = this.gestureStartTime;
            float[] fArr5 = this.targetCoordinates;
            eventDispatcher.dispatchEvent(companion5.obtain(surfaceId5, i6, touchEventType5, ev, j5, fArr5[0], fArr5[1], this.touchEventCoalescingKeyHelper));
            return;
        }
        if (action == 3) {
            if (this.touchEventCoalescingKeyHelper.hasCoalescingKey(ev.getDownTime())) {
                dispatchCancelEvent(ev, eventDispatcher);
            } else {
                FLog.e("ReactNative", "Received an ACTION_CANCEL touch event for which we have no corresponding ACTION_DOWN");
            }
            sweepActiveTouchForTag(UIManagerHelper.getSurfaceId(this.viewGroup), this.targetTag, reactContext);
            this.targetTag = -1;
            this.gestureStartTime = Long.MIN_VALUE;
            return;
        }
        FLog.w("ReactNative", "Warning : touch event was ignored. Action=" + action + " Target=" + i2);
    }

    private final void markActiveTouchForTag(int i, int i2, ReactContext reactContext) {
        UIManager uIManager;
        if (reactContext == null || (uIManager = UIManagerHelper.getUIManager(reactContext, 2)) == null) {
            return;
        }
        uIManager.markActiveTouchForTag(i, i2);
    }

    private final void sweepActiveTouchForTag(int i, int i2, ReactContext reactContext) {
        UIManager uIManager;
        if (reactContext == null || (uIManager = UIManagerHelper.getUIManager(reactContext, 2)) == null) {
            return;
        }
        uIManager.sweepActiveTouchForTag(i, i2);
    }

    private final int findTargetTagAndSetCoordinates(MotionEvent motionEvent) {
        return TouchTargetHelper.findTargetTagAndCoordinatesForTouch(motionEvent.getX(), motionEvent.getY(), this.viewGroup, this.targetCoordinates, null);
    }

    private final void dispatchCancelEvent(MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        if (this.targetTag == -1) {
            FLog.w("ReactNative", "Can't cancel already finished gesture. Is a child View trying to start a gesture from an UP/CANCEL event?");
            return;
        }
        Assertions.assertCondition(!this.childIsHandlingNativeGesture, "Expected to not have already sent a cancel for this gesture");
        EventDispatcher eventDispatcher2 = (EventDispatcher) Assertions.assertNotNull(eventDispatcher);
        TouchEvent.Companion companion = TouchEvent.Companion;
        int surfaceId = UIManagerHelper.getSurfaceId(this.viewGroup);
        int i = this.targetTag;
        TouchEventType touchEventType = TouchEventType.CANCEL;
        long j = this.gestureStartTime;
        float[] fArr = this.targetCoordinates;
        eventDispatcher2.dispatchEvent(companion.obtain(surfaceId, i, touchEventType, motionEvent, j, fArr[0], fArr[1], this.touchEventCoalescingKeyHelper));
    }
}
