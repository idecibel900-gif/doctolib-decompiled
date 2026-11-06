package com.reactnativekeyboardcontroller.views.overlay;

import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class OverKeyboardHostView extends ReactViewGroup {
    private final EventDispatcher dispatcher;
    private OverKeyboardRootViewGroup hostView;
    private final ThemedReactContext reactContext;
    private WindowManager windowManager;

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public void addChildrenForAccessibility(ArrayList outChildren) {
        Intrinsics.checkNotNullParameter(outChildren, "outChildren");
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverKeyboardHostView(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, getId());
        this.dispatcher = eventDispatcherForReactTag;
        Object systemService = reactContext.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.windowManager = (WindowManager) systemService;
        OverKeyboardRootViewGroup overKeyboardRootViewGroup = new OverKeyboardRootViewGroup(reactContext);
        this.hostView = overKeyboardRootViewGroup;
        overKeyboardRootViewGroup.setEventDispatcher$react_native_keyboard_controller_release(eventDispatcherForReactTag);
    }

    public final StateWrapper getStateWrapper() {
        return this.hostView.getStateWrapper$react_native_keyboard_controller_release();
    }

    public final void setStateWrapper(StateWrapper stateWrapper) {
        this.hostView.setStateWrapper$react_native_keyboard_controller_release(stateWrapper);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        hide();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        UiThreadUtil.assertOnUiThread();
        this.hostView.addView(view, i);
    }

    @Override // android.view.ViewGroup
    public int getChildCount() {
        return this.hostView.getChildCount();
    }

    @Override // android.view.ViewGroup
    public View getChildAt(int i) {
        return this.hostView.getChildAt(i);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        UiThreadUtil.assertOnUiThread();
        if (view != null) {
            this.hostView.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        UiThreadUtil.assertOnUiThread();
        this.hostView.removeView(getChildAt(i));
    }

    public final void show() {
        this.windowManager.addView(this.hostView, new WindowManager.LayoutParams(-1, -1, 1000, 520, -3));
    }

    public final void hide() {
        if (this.hostView.isAttached$react_native_keyboard_controller_release()) {
            this.windowManager.removeView(this.hostView);
        }
    }
}
