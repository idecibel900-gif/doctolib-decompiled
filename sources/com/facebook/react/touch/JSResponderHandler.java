package com.facebook.react.touch;

import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class JSResponderHandler implements OnInterceptTouchEventListener {
    private static final Companion Companion = new Companion(null);
    private volatile int currentJSResponder = -1;
    private ViewParent viewParentBlockingNativeResponder;

    public final void setJSResponder(int i, ViewParent viewParent) {
        this.currentJSResponder = i;
        maybeUnblockNativeResponder();
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(true);
            this.viewParentBlockingNativeResponder = viewParent;
        }
    }

    public final void clearJSResponder() {
        this.currentJSResponder = -1;
        maybeUnblockNativeResponder();
    }

    private final void maybeUnblockNativeResponder() {
        ViewParent viewParent = this.viewParentBlockingNativeResponder;
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(false);
        }
        this.viewParentBlockingNativeResponder = null;
    }

    @Override // com.facebook.react.touch.OnInterceptTouchEventListener
    public boolean onInterceptTouchEvent(ViewGroup view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = this.currentJSResponder;
        return (i == -1 || event.getAction() == 1 || view.getId() != i) ? false : true;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
