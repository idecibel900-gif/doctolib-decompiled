package com.reactnativekeyboardcontroller.views.overlay;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ReactViewGroup;
import com.reactnativekeyboardcontroller.extensions.ContextKt;
import com.reactnativekeyboardcontroller.extensions.FloatKt;
import com.reactnativekeyboardcontroller.log.Logger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class OverKeyboardRootViewGroup extends ReactViewGroup implements RootView {
    private EventDispatcher eventDispatcher;
    private boolean isAttached;
    private JSPointerDispatcherCompat jsPointerDispatcher;
    private final JSTouchDispatcher jsTouchDispatcher;
    private final ThemedReactContext reactContext;
    private StateWrapper stateWrapper;

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverKeyboardRootViewGroup(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.jsTouchDispatcher = new JSTouchDispatcher(this);
        if (ReactFeatureFlags.dispatchPointerEvents) {
            this.jsPointerDispatcher = new JSPointerDispatcherCompat(this);
        }
    }

    public final EventDispatcher getEventDispatcher$react_native_keyboard_controller_release() {
        return this.eventDispatcher;
    }

    public final void setEventDispatcher$react_native_keyboard_controller_release(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    public final StateWrapper getStateWrapper$react_native_keyboard_controller_release() {
        return this.stateWrapper;
    }

    public final void setStateWrapper$react_native_keyboard_controller_release(StateWrapper stateWrapper) {
        this.stateWrapper = stateWrapper;
    }

    public final boolean isAttached$react_native_keyboard_controller_release() {
        return this.isAttached;
    }

    public final void setAttached$react_native_keyboard_controller_release(boolean z) {
        this.isAttached = z;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Point displaySize = ContextKt.getDisplaySize(this.reactContext);
        stretchTo(displaySize.x, displaySize.y);
        this.isAttached = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stretchTo(0, 0);
        this.isAttached = false;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        stretchTo(i, i2);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EventDispatcher eventDispatcher = this.eventDispatcher;
        if (eventDispatcher != null) {
            try {
                this.jsTouchDispatcher.handleTouchEvent(event, eventDispatcher);
                JSPointerDispatcherCompat jSPointerDispatcherCompat = this.jsPointerDispatcher;
                if (jSPointerDispatcherCompat != null) {
                    jSPointerDispatcherCompat.handleMotionEventCompat(event, eventDispatcher, true);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (RuntimeException e) {
                Logger.INSTANCE.w(OverKeyboardViewGroupKt.TAG, "Can not handle touch event", e);
                Unit unit2 = Unit.INSTANCE;
            }
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EventDispatcher eventDispatcher = this.eventDispatcher;
        if (eventDispatcher != null) {
            try {
                this.jsTouchDispatcher.handleTouchEvent(event, eventDispatcher);
                JSPointerDispatcherCompat jSPointerDispatcherCompat = this.jsPointerDispatcher;
                if (jSPointerDispatcherCompat != null) {
                    jSPointerDispatcherCompat.handleMotionEventCompat(event, eventDispatcher, false);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (RuntimeException e) {
                Logger.INSTANCE.w(OverKeyboardViewGroupKt.TAG, "Can not handle touch event", e);
                Unit unit2 = Unit.INSTANCE;
            }
        }
        super.onTouchEvent(event);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(MotionEvent event) {
        JSPointerDispatcherCompat jSPointerDispatcherCompat;
        Intrinsics.checkNotNullParameter(event, "event");
        EventDispatcher eventDispatcher = this.eventDispatcher;
        if (eventDispatcher != null && (jSPointerDispatcherCompat = this.jsPointerDispatcher) != null) {
            jSPointerDispatcherCompat.handleMotionEventCompat(event, eventDispatcher, true);
        }
        return super.onInterceptHoverEvent(event);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    public boolean onHoverEvent(MotionEvent event) {
        JSPointerDispatcherCompat jSPointerDispatcherCompat;
        Intrinsics.checkNotNullParameter(event, "event");
        EventDispatcher eventDispatcher = this.eventDispatcher;
        if (eventDispatcher != null && (jSPointerDispatcherCompat = this.jsPointerDispatcher) != null) {
            jSPointerDispatcherCompat.handleMotionEventCompat(event, eventDispatcher, false);
        }
        return super.onHoverEvent(event);
    }

    @Override // com.facebook.react.uimanager.RootView
    public void onChildStartedNativeGesture(View view, MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        EventDispatcher eventDispatcher = this.eventDispatcher;
        if (eventDispatcher != null) {
            this.jsTouchDispatcher.onChildStartedNativeGesture(ev, eventDispatcher);
            JSPointerDispatcherCompat jSPointerDispatcherCompat = this.jsPointerDispatcher;
            if (jSPointerDispatcherCompat != null) {
                jSPointerDispatcherCompat.onChildStartedNativeGesture(view, ev, eventDispatcher);
            }
        }
    }

    @Override // com.facebook.react.uimanager.RootView
    public void onChildEndedNativeGesture(View childView, MotionEvent ev) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(ev, "ev");
        EventDispatcher eventDispatcher = this.eventDispatcher;
        if (eventDispatcher != null) {
            this.jsTouchDispatcher.onChildEndedNativeGesture(ev, eventDispatcher);
        }
        JSPointerDispatcherCompat jSPointerDispatcherCompat = this.jsPointerDispatcher;
        if (jSPointerDispatcherCompat != null) {
            jSPointerDispatcherCompat.onChildEndedNativeGesture();
        }
    }

    private final void stretchTo(int i, int i2) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putDouble("screenWidth", FloatKt.getDp(i));
        writableNativeMap.putDouble("screenHeight", FloatKt.getDp(i2));
        StateWrapper stateWrapper = this.stateWrapper;
        if (stateWrapper != null) {
            stateWrapper.updateState(writableNativeMap);
        }
    }
}
