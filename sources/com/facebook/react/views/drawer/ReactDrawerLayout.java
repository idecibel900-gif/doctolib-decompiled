package com.facebook.react.views.drawer;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.facebook.common.logging.FLog;
import com.facebook.react.R$id;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactDrawerLayout extends DrawerLayout {
    public static final Companion Companion = new Companion(null);
    private boolean dragging;
    private int drawerPosition;
    private int drawerWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactDrawerLayout(ReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.drawerPosition = 8388611;
        this.drawerWidth = -1;
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() { // from class: com.facebook.react.views.drawer.ReactDrawerLayout.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                ReactAccessibilityDelegate.AccessibilityRole.Companion companion = ReactAccessibilityDelegate.AccessibilityRole.Companion;
                ReactAccessibilityDelegate.AccessibilityRole accessibilityRoleFromViewTag = companion.fromViewTag(host);
                if (accessibilityRoleFromViewTag != null) {
                    info.setClassName(companion.getValue(accessibilityRoleFromViewTag));
                }
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(event, "event");
                super.onInitializeAccessibilityEvent(host, event);
                Object tag = host.getTag(R$id.accessibility_role);
                if (tag instanceof ReactAccessibilityDelegate.AccessibilityRole) {
                    event.setClassName(ReactAccessibilityDelegate.AccessibilityRole.Companion.getValue((ReactAccessibilityDelegate.AccessibilityRole) tag));
                }
            }
        });
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        try {
            if (!super.onInterceptTouchEvent(ev)) {
                return false;
            }
            NativeGestureUtil.notifyNativeGestureStarted(this, ev);
            this.dragging = true;
            return true;
        } catch (IllegalArgumentException e) {
            FLog.w("ReactNative", "Error intercepting touch event.", e);
            return false;
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getActionMasked() == 1 && this.dragging) {
            NativeGestureUtil.notifyNativeGestureEnded(this, ev);
            this.dragging = false;
        }
        return super.onTouchEvent(ev);
    }

    public final void openDrawer$ReactAndroid_release() {
        openDrawer(this.drawerPosition);
    }

    public final void closeDrawer$ReactAndroid_release() {
        closeDrawer(this.drawerPosition);
    }

    public final void setDrawerPosition$ReactAndroid_release(int i) {
        this.drawerPosition = i;
        setDrawerProperties$ReactAndroid_release();
    }

    public final void setDrawerWidth$ReactAndroid_release(int i) {
        this.drawerWidth = i;
        setDrawerProperties$ReactAndroid_release();
    }

    public final void setDrawerProperties$ReactAndroid_release() {
        if (getChildCount() == 2) {
            View childAt = getChildAt(1);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.drawerlayout.widget.DrawerLayout.LayoutParams");
            DrawerLayout.LayoutParams layoutParams2 = (DrawerLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = this.drawerPosition;
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = this.drawerWidth;
            childAt.setLayoutParams(layoutParams2);
            childAt.setClickable(true);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
