package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper;
import com.swmansion.gesturehandler.react.eventbuilders.HoverGestureHandlerEventDataBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class HoverGestureHandler extends GestureHandler {
    private Handler handler;
    private Runnable finishRunnable = new Runnable() { // from class: com.swmansion.gesturehandler.core.HoverGestureHandler$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.finish();
        }
    };
    private StylusData stylusData = new StylusData(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 31, null);

    public final StylusData getStylusData() {
        return this.stylusData;
    }

    private final boolean isAncestorOf(GestureHandler gestureHandler) {
        View view = gestureHandler.getView();
        while (view != null) {
            if (Intrinsics.areEqual(view, getView())) {
                return true;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return false;
    }

    static /* synthetic */ Boolean isViewDisplayedOverAnother$default(HoverGestureHandler hoverGestureHandler, View view, View view2, View view3, int i, Object obj) {
        if ((i & 4) != 0) {
            view3 = view.getRootView();
        }
        return hoverGestureHandler.isViewDisplayedOverAnother(view, view2, view3);
    }

    private final Boolean isViewDisplayedOverAnother(View view, View view2, View view3) {
        if (Intrinsics.areEqual(view3, view2)) {
            return Boolean.TRUE;
        }
        if (Intrinsics.areEqual(view3, view)) {
            return Boolean.FALSE;
        }
        if (!(view3 instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view3;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.checkNotNull(childAt);
            Boolean boolIsViewDisplayedOverAnother = isViewDisplayedOverAnother(view, view2, childAt);
            if (boolIsViewDisplayedOverAnother != null) {
                return boolIsViewDisplayedOverAnother;
            }
        }
        return null;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public boolean shouldBeCancelledBy(GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if ((handler instanceof HoverGestureHandler) && !((HoverGestureHandler) handler).isAncestorOf(this)) {
            View view = handler.getView();
            Intrinsics.checkNotNull(view);
            View view2 = getView();
            Intrinsics.checkNotNull(view2);
            Boolean boolIsViewDisplayedOverAnother$default = isViewDisplayedOverAnother$default(this, view, view2, null, 4, null);
            Intrinsics.checkNotNull(boolIsViewDisplayedOverAnother$default);
            return boolIsViewDisplayedOverAnother$default.booleanValue();
        }
        return super.shouldBeCancelledBy(handler);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public boolean shouldRequireToWaitForFailure(GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if ((handler instanceof HoverGestureHandler) && !isAncestorOf(handler) && !((HoverGestureHandler) handler).isAncestorOf(this)) {
            View view = getView();
            Intrinsics.checkNotNull(view);
            View view2 = handler.getView();
            Intrinsics.checkNotNull(view2);
            Boolean boolIsViewDisplayedOverAnother$default = isViewDisplayedOverAnother$default(this, view, view2, null, 4, null);
            if (boolIsViewDisplayedOverAnother$default != null) {
                return boolIsViewDisplayedOverAnother$default.booleanValue();
            }
        }
        return super.shouldRequireToWaitForFailure(handler);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public boolean shouldRecognizeSimultaneously(GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (((handler instanceof HoverGestureHandler) && (isAncestorOf(handler) || ((HoverGestureHandler) handler).isAncestorOf(this))) || (handler instanceof RNGestureHandlerRootHelper.RootViewGestureHandler)) {
            return true;
        }
        return super.shouldRecognizeSimultaneously(handler);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onHandle(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (event.getAction() == 0) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.handler = null;
            return;
        }
        if (event.getAction() != 1 || isWithinBounds()) {
            return;
        }
        finish();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onHandleHover(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (event.getAction() == 10) {
            if (this.handler == null) {
                this.handler = new Handler(Looper.getMainLooper());
            }
            Handler handler = this.handler;
            Intrinsics.checkNotNull(handler);
            handler.postDelayed(this.finishRunnable, 4L);
            return;
        }
        if (!isWithinBounds()) {
            finish();
            return;
        }
        if (getState() == 4 && event.getToolType(0) == 2) {
            this.stylusData = StylusData.Companion.fromEvent(event);
            return;
        }
        if (getState() == 0) {
            if (event.getAction() == 7 || event.getAction() == 9) {
                begin();
                activate();
            }
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onReset() {
        super.onReset();
        this.stylusData = new StylusData(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 31, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finish() {
        int state = getState();
        if (state == 0) {
            cancel();
        } else if (state == 2) {
            fail();
        } else {
            if (state != 4) {
                return;
            }
            end();
        }
    }

    public static final class Factory extends GestureHandler.Factory {
        private final Class type = HoverGestureHandler.class;
        private final String name = "HoverGestureHandler";

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public Class getType() {
            return this.type;
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public String getName() {
            return this.name;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public HoverGestureHandler create(Context context) {
            return new HoverGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public HoverGestureHandlerEventDataBuilder createEventBuilder(HoverGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new HoverGestureHandlerEventDataBuilder(handler);
        }
    }
}
