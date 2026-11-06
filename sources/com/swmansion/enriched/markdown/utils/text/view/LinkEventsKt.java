package com.swmansion.enriched.markdown.utils.text.view;

import android.content.Context;
import android.text.method.MovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.swmansion.enriched.markdown.events.LinkLongPressEvent;
import com.swmansion.enriched.markdown.events.LinkPressEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LinkEventsKt {
    public static final void emitLinkPressEvent(View view, String url) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Context context = view.getContext();
        ReactContext reactContext = context instanceof ReactContext ? (ReactContext) context : null;
        if (reactContext == null) {
            return;
        }
        int surfaceId = UIManagerHelper.getSurfaceId(reactContext);
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, view.getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new LinkPressEvent(surfaceId, view.getId(), url));
        }
    }

    public static final void emitLinkLongPressEvent(View view, String url) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Context context = view.getContext();
        ReactContext reactContext = context instanceof ReactContext ? (ReactContext) context : null;
        if (reactContext == null) {
            return;
        }
        int surfaceId = UIManagerHelper.getSurfaceId(reactContext);
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, view.getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new LinkLongPressEvent(surfaceId, view.getId(), url));
        }
    }

    public static final void cancelJSTouchForLinkTap(TextView textView, MotionEvent event) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        MovementMethod movementMethod = textView.getMovementMethod();
        if ((movementMethod instanceof LinkLongPressMovementMethod) && ((LinkLongPressMovementMethod) movementMethod).isLinkTouchActive()) {
            ViewParent parent = textView.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            NativeGestureUtil.notifyNativeGestureStarted(textView, event);
        }
    }

    public static final void reallowParentInterceptIfLinkReleased(TextView textView) {
        ViewParent parent;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        MovementMethod movementMethod = textView.getMovementMethod();
        if (!(movementMethod instanceof LinkLongPressMovementMethod) || ((LinkLongPressMovementMethod) movementMethod).isLinkTouchActive() || (parent = textView.getParent()) == null) {
            return;
        }
        parent.requestDisallowInterceptTouchEvent(false);
    }

    public static final void cancelJSTouchForCheckboxTap(View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        NativeGestureUtil.notifyNativeGestureStarted(view, event);
    }
}
