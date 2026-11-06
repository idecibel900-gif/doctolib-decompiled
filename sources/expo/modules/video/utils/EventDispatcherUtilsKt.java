package expo.modules.video.utils;

import android.view.MotionEvent;
import android.view.View;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.TouchEvent;
import com.facebook.react.uimanager.events.TouchEventCoalescingKeyHelper;
import com.facebook.react.uimanager.events.TouchEventType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class EventDispatcherUtilsKt {
    public static final void dispatchMotionEvent(EventDispatcher eventDispatcher, View view, MotionEvent motionEvent, TouchEventCoalescingKeyHelper touchEventCoalescingKeyHelper) {
        Intrinsics.checkNotNullParameter(eventDispatcher, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(touchEventCoalescingKeyHelper, "touchEventCoalescingKeyHelper");
        if (motionEvent == null) {
            return;
        }
        try {
            eventDispatcher.dispatchEvent(TouchEvent.Companion.obtain(UIManagerHelper.getSurfaceId(view), view.getId(), toTouchEventType(motionEvent), motionEvent, motionEvent.getEventTime(), motionEvent.getX(), motionEvent.getY(), touchEventCoalescingKeyHelper));
        } catch (RuntimeException unused) {
        }
    }

    private static final TouchEventType toTouchEventType(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            return TouchEventType.START;
        }
        if (actionMasked == 1) {
            return TouchEventType.END;
        }
        if (actionMasked == 2) {
            return TouchEventType.MOVE;
        }
        if (actionMasked == 3) {
            return TouchEventType.CANCEL;
        }
        return TouchEventType.CANCEL;
    }
}
