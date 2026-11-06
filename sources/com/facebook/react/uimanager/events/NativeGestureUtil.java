package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import android.view.View;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeGestureUtil {
    public static final NativeGestureUtil INSTANCE = new NativeGestureUtil();

    private NativeGestureUtil() {
    }

    public static final void notifyNativeGestureStarted(View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        RootView rootView = RootViewUtil.getRootView(view);
        if (rootView != null) {
            rootView.onChildStartedNativeGesture(view, event);
        }
    }

    public static final void notifyNativeGestureEnded(View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        RootView rootView = RootViewUtil.getRootView(view);
        if (rootView != null) {
            rootView.onChildEndedNativeGesture(view, event);
        }
    }
}
