package com.facebook.react.views.scroll;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.facebook.common.logging.FLog;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import java.util.Collection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class VirtualViewContainerState {
    public static final Companion Companion = new Companion(null);
    private final Rect emptyRect;
    private final double hysteresisRatio;
    private final Rect hysteresisRect;
    private final ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListener;
    private final double prerenderRatio;
    private final Rect prerenderRect;
    private final ViewGroup scrollView;
    private final Rect visibleRect;

    public static final VirtualViewContainerState create(ViewGroup viewGroup) {
        return Companion.create(viewGroup);
    }

    protected abstract Collection getVirtualViews();

    protected abstract void updateModes(VirtualView virtualView);

    protected final double getPrerenderRatio() {
        return this.prerenderRatio;
    }

    protected final double getHysteresisRatio() {
        return this.hysteresisRatio;
    }

    protected final Rect getEmptyRect() {
        return this.emptyRect;
    }

    protected final Rect getVisibleRect() {
        return this.visibleRect;
    }

    protected final Rect getPrerenderRect() {
        return this.prerenderRect;
    }

    protected final Rect getHysteresisRect() {
        return this.hysteresisRect;
    }

    protected final ViewTreeObserver.OnWindowFocusChangeListener getOnWindowFocusChangeListener() {
        return this.onWindowFocusChangeListener;
    }

    protected final ViewGroup getScrollView() {
        return this.scrollView;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VirtualViewContainerState create(ViewGroup scrollView) {
            Intrinsics.checkNotNullParameter(scrollView, "scrollView");
            if (ReactNativeFeatureFlags.enableVirtualViewContainerStateExperimental()) {
                return new VirtualViewContainerStateExperimental(scrollView);
            }
            return new VirtualViewContainerStateClassic(scrollView);
        }
    }

    public VirtualViewContainerState(ViewGroup scrollView) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        this.prerenderRatio = ReactNativeFeatureFlags.virtualViewPrerenderRatio();
        this.hysteresisRatio = ReactNativeFeatureFlags.virtualViewHysteresisRatio();
        this.emptyRect = new Rect();
        this.visibleRect = new Rect();
        this.prerenderRect = new Rect();
        this.hysteresisRect = new Rect();
        ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListener = ReactNativeFeatureFlags.enableVirtualViewWindowFocusDetection() ? new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.facebook.react.views.scroll.VirtualViewContainerState$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z) {
                VirtualViewContainerState.onWindowFocusChangeListener$lambda$0(this.f$0, z);
            }
        } : null;
        this.onWindowFocusChangeListener = onWindowFocusChangeListener;
        this.scrollView = scrollView;
        if (onWindowFocusChangeListener != null) {
            scrollView.getViewTreeObserver().addOnWindowFocusChangeListener(onWindowFocusChangeListener);
        }
    }

    public final void cleanup() {
        if (this.onWindowFocusChangeListener != null) {
            this.scrollView.getViewTreeObserver().removeOnWindowFocusChangeListener(this.onWindowFocusChangeListener);
        }
    }

    public void onChange(VirtualView virtualView) {
        Intrinsics.checkNotNullParameter(virtualView, "virtualView");
        if (getVirtualViews().add(virtualView)) {
            if (VirtualViewContainerKt.getIS_DEBUG_BUILD() && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
                FLog.d("VirtualViewContainerState:add", "virtualViewID=" + virtualView.getVirtualViewID());
            }
        } else if (VirtualViewContainerKt.getIS_DEBUG_BUILD() && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
            FLog.d("VirtualViewContainerState:update", "virtualViewID=" + virtualView.getVirtualViewID());
        }
        updateModes(virtualView);
    }

    public void remove(VirtualView virtualView) {
        Intrinsics.checkNotNullParameter(virtualView, "virtualView");
        getVirtualViews().remove(virtualView);
        if (VirtualViewContainerKt.getIS_DEBUG_BUILD() && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
            FLog.d("VirtualViewContainerState:remove", "virtualViewID=" + virtualView.getVirtualViewID());
        }
    }

    protected final void updateRects() {
        this.scrollView.getDrawingRect(this.visibleRect);
        if (this.visibleRect.isEmpty()) {
            if (VirtualViewContainerKt.getIS_DEBUG_BUILD() && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
                FLog.d("VirtualViewContainerState:updateRects", "scrollView visibleRect is empty");
            }
            this.prerenderRect.set(this.visibleRect);
            this.hysteresisRect.set(this.prerenderRect);
            return;
        }
        this.prerenderRect.set(this.visibleRect);
        Rect rect = this.prerenderRect;
        rect.inset((int) (((double) (-rect.width())) * this.prerenderRatio), (int) (((double) (-this.prerenderRect.height())) * this.prerenderRatio));
        this.hysteresisRect.set(this.prerenderRect);
        this.hysteresisRect.inset((int) (((double) (-this.visibleRect.width())) * this.hysteresisRatio), (int) (((double) (-this.visibleRect.height())) * this.hysteresisRatio));
        if (VirtualViewContainerKt.getIS_DEBUG_BUILD() && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
            FLog.d("VirtualViewContainerState:updateRects", "visibleRect " + this.visibleRect + " prerenderRect " + this.prerenderRect + " hysteresisRect " + this.hysteresisRect);
        }
    }

    public static /* synthetic */ void updateModes$default(VirtualViewContainerState virtualViewContainerState, VirtualView virtualView, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateModes");
        }
        if ((i & 1) != 0) {
            virtualView = null;
        }
        virtualViewContainerState.updateModes(virtualView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onWindowFocusChangeListener$lambda$0(VirtualViewContainerState virtualViewContainerState, boolean z) {
        if (VirtualViewContainerKt.getIS_DEBUG_BUILD() && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
            FLog.d("VirtualViewContainerState:onWindowFocusChanged", "");
        }
        updateModes$default(virtualViewContainerState, null, 1, null);
    }

    public final void updateState() {
        if (VirtualViewContainerKt.getIS_DEBUG_BUILD() && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
            FLog.d("VirtualViewContainerState:updateState", "");
        }
        updateModes$default(this, null, 1, null);
    }
}
