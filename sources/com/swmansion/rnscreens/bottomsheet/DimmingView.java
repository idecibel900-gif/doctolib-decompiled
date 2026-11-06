package com.swmansion.rnscreens.bottomsheet;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactCompoundViewGroup;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.swmansion.rnscreens.ext.NumericExtKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class DimmingView extends ViewGroup implements ReactCompoundViewGroup, ReactPointerEventsView {
    public static final Companion Companion = new Companion(null);
    private final DimmingViewPointerEventsProxy pointerEventsProxy;

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    public PointerEvents getPointerEvents() {
        return this.pointerEventsProxy.getPointerEvents();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DimmingView(Context context, float f, DimmingViewPointerEventsProxy pointerEventsProxy) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pointerEventsProxy, "pointerEventsProxy");
        this.pointerEventsProxy = pointerEventsProxy;
        pointerEventsProxy.setPointerEventsImpl(new DimmingViewPointerEventsImpl(this));
        setFocusable(false);
        setBackgroundColor(-16777216);
        setAlpha(f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DimmingView(Context context, float f) {
        this(context, f, new DimmingViewPointerEventsProxy(null));
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final boolean getBlockGestures$react_native_screens_release() {
        return !NumericExtKt.equalWithRespectToEps$default(getAlpha(), 0.0f, 0.0f, 2, null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getBlockGestures$react_native_screens_release()) {
            callOnClick();
        }
        return getBlockGestures$react_native_screens_release();
    }

    @Override // com.facebook.react.uimanager.ReactCompoundView
    public int reactTagForTouch(float f, float f2) {
        throw new IllegalStateException("[RNScreens] DimmingView should never be asked for the view tag!");
    }

    @Override // com.facebook.react.uimanager.ReactCompoundViewGroup
    public boolean interceptsTouchEvent(float f, float f2) {
        return getBlockGestures$react_native_screens_release();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.pointerEventsProxy.setPointerEventsImpl(null);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
