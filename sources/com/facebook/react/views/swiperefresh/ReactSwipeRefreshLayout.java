package com.facebook.react.views.swiperefresh;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactSwipeRefreshLayout extends SwipeRefreshLayout {
    private static final Companion Companion = new Companion(null);
    private boolean didLayout;
    private boolean intercepted;
    private boolean nativeGestureStarted;
    private float prevTouchX;
    private float progressViewOffset;
    private boolean refreshing;
    private final int touchSlop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactSwipeRefreshLayout(ReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.touchSlop = ViewConfiguration.get(reactContext).getScaledTouchSlop();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout
    public void setRefreshing(boolean z) {
        this.refreshing = z;
        if (this.didLayout) {
            super.setRefreshing(z);
        }
    }

    public final void setProgressViewOffset(float f) {
        this.progressViewOffset = f;
        if (this.didLayout) {
            int progressCircleDiameter = getProgressCircleDiameter();
            setProgressViewOffset(false, Math.round(PixelUtil.toPixelFromDIP(f)) - progressCircleDiameter, Math.round(PixelUtil.toPixelFromDIP(f + 64.0f)) - progressCircleDiameter);
        }
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.didLayout) {
            return;
        }
        this.didLayout = true;
        setProgressViewOffset(this.progressViewOffset);
        setRefreshing(this.refreshing);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout
    public boolean canChildScrollUp() {
        View childAt = getChildAt(0);
        return childAt != null ? childAt.canScrollVertically(-1) : super.canChildScrollUp();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!shouldInterceptTouchEvent(ev) || !super.onInterceptTouchEvent(ev)) {
            return false;
        }
        NativeGestureUtil.notifyNativeGestureStarted(this, ev);
        this.nativeGestureStarted = true;
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getActionMasked() == 1 && this.nativeGestureStarted) {
            NativeGestureUtil.notifyNativeGestureEnded(this, ev);
            this.nativeGestureStarted = false;
        }
        return super.onTouchEvent(ev);
    }

    private final boolean shouldInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.prevTouchX = motionEvent.getX();
            this.intercepted = false;
        } else if (action == 2) {
            float fAbs = Math.abs(motionEvent.getX() - this.prevTouchX);
            if (this.intercepted || fAbs > this.touchSlop) {
                this.intercepted = true;
                return false;
            }
        }
        return true;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
