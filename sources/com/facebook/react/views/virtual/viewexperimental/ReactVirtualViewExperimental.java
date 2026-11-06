package com.facebook.react.views.virtual.viewexperimental;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import com.facebook.common.logging.FLog;
import com.facebook.react.R$id;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.views.scroll.VirtualView;
import com.facebook.react.views.scroll.VirtualViewContainer;
import com.facebook.react.views.scroll.VirtualViewContainerState;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.virtual.VirtualViewMode;
import com.facebook.react.views.virtual.VirtualViewModeChangeEmitter;
import com.facebook.react.views.virtual.VirtualViewRenderState;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactVirtualViewExperimental extends ReactViewGroup implements VirtualView, View.OnLayoutChangeListener {
    private final Rect containerRelativeRect;
    private boolean hadLayout;
    private final Rect lastClippingRect;
    private final Rect lastContainerRelativeRect;
    private VirtualViewMode mode;
    private VirtualViewModeChangeEmitter modeChangeEmitter;
    private int offsetX;
    private int offsetY;
    private VirtualViewRenderState renderState;
    private VirtualViewContainer scrollView;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VirtualViewMode.values().length];
            try {
                iArr[VirtualViewMode.Visible.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VirtualViewMode.Prerender.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VirtualViewMode.Hidden.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactVirtualViewExperimental(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.renderState = VirtualViewRenderState.Unknown;
        this.lastContainerRelativeRect = new Rect();
        this.lastClippingRect = new Rect();
        this.containerRelativeRect = new Rect();
    }

    public final VirtualViewMode getMode$ReactAndroid_release() {
        return this.mode;
    }

    public final void setMode$ReactAndroid_release(VirtualViewMode virtualViewMode) {
        this.mode = virtualViewMode;
    }

    public final VirtualViewModeChangeEmitter getModeChangeEmitter$ReactAndroid_release() {
        return this.modeChangeEmitter;
    }

    public final void setModeChangeEmitter$ReactAndroid_release(VirtualViewModeChangeEmitter virtualViewModeChangeEmitter) {
        this.modeChangeEmitter = virtualViewModeChangeEmitter;
    }

    public final VirtualViewRenderState getRenderState$ReactAndroid_release() {
        return this.renderState;
    }

    public final void setRenderState$ReactAndroid_release(VirtualViewRenderState virtualViewRenderState) {
        Intrinsics.checkNotNullParameter(virtualViewRenderState, "<set-?>");
        this.renderState = virtualViewRenderState;
    }

    @Override // com.facebook.react.views.scroll.VirtualView
    public Rect getContainerRelativeRect() {
        return this.containerRelativeRect;
    }

    public final String getNativeId$ReactAndroid_release() {
        Object tag = getTag(R$id.view_tag_native_id);
        if (tag instanceof String) {
            return (String) tag;
        }
        return null;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        doAttachedToWindow$ReactAndroid_release();
    }

    public final void doAttachedToWindow$ReactAndroid_release() {
        this.scrollView = getScrollView();
        if (this.hadLayout) {
            updateParentOffset();
            reportRectChangeToContainer();
        }
        if (ReactVirtualViewExperimentalKt.IS_DEBUG_BUILD && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
            FLog.d("ReactVirtualViewExperimental:[" + getVirtualViewID() + "]:doAttachedToWindow", "");
        }
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.hadLayout = true;
        if (z) {
            Rect containerRelativeRect = getContainerRelativeRect();
            int i5 = this.offsetX;
            int i6 = this.offsetY;
            containerRelativeRect.set(i + i5, i2 + i6, i3 + i5, i4 + i6);
            if (ReactVirtualViewExperimentalKt.IS_DEBUG_BUILD && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
                FLog.d("ReactVirtualViewExperimental:[" + getVirtualViewID() + "]:onLayout", "containerRelativeRect=" + getContainerRelativeRect());
            }
            reportRectChangeToContainer();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i5 == i && i6 == i2) {
            return;
        }
        updateParentOffset();
        if (ReactVirtualViewExperimentalKt.IS_DEBUG_BUILD && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
            FLog.d("ReactVirtualViewExperimental:[" + getVirtualViewID() + "]:onLayoutChange", "containerRelativeRect=" + getContainerRelativeRect());
        }
        reportRectChangeToContainer();
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        getContainerRelativeRect().set(getLeft() + this.offsetX, getTop() + this.offsetY, getRight() + this.offsetX, getBottom() + this.offsetY);
        if (ReactVirtualViewExperimentalKt.IS_DEBUG_BUILD && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
            FLog.d("ReactVirtualViewExperimental:[" + getVirtualViewID() + "]:onSizeChanged", "container=" + getContainerRelativeRect());
        }
        reportRectChangeToContainer();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        recycleView$ReactAndroid_release();
    }

    @Override // com.facebook.react.views.view.ReactViewGroup
    public void recycleView$ReactAndroid_release() {
        VirtualViewContainerState virtualViewContainerState;
        cleanupLayoutListeners();
        VirtualViewContainer virtualViewContainer = this.scrollView;
        if (virtualViewContainer != null && (virtualViewContainerState = virtualViewContainer.getVirtualViewContainerState()) != null) {
            virtualViewContainerState.remove(this);
        }
        this.scrollView = null;
        this.mode = null;
        this.modeChangeEmitter = null;
        this.hadLayout = false;
        this.lastContainerRelativeRect.setEmpty();
        this.lastClippingRect.setEmpty();
        getContainerRelativeRect().setEmpty();
    }

    @Override // com.facebook.react.views.scroll.VirtualView
    public String getVirtualViewID() {
        String nativeId$ReactAndroid_release = getNativeId$ReactAndroid_release();
        if (nativeId$ReactAndroid_release == null) {
            nativeId$ReactAndroid_release = "unknown";
        }
        return nativeId$ReactAndroid_release + ":::" + getId();
    }

    @Override // com.facebook.react.views.scroll.VirtualView
    public void onModeChange(VirtualViewMode newMode, Rect thresholdRect) {
        VirtualViewModeChangeEmitter virtualViewModeChangeEmitter;
        VirtualViewModeChangeEmitter virtualViewModeChangeEmitter2;
        Intrinsics.checkNotNullParameter(newMode, "newMode");
        Intrinsics.checkNotNullParameter(thresholdRect, "thresholdRect");
        if (this.modeChangeEmitter == null || this.scrollView == null) {
            return;
        }
        VirtualViewMode virtualViewMode = VirtualViewMode.Visible;
        if (newMode == virtualViewMode) {
            updateClippingRect(null);
        }
        VirtualViewMode virtualViewMode2 = this.mode;
        if (newMode == virtualViewMode2) {
            if (ReactVirtualViewExperimentalKt.IS_DEBUG_BUILD && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
                FLog.d("ReactVirtualViewExperimental:[" + getVirtualViewID() + "]:onModeChange", "no change " + newMode);
                return;
            }
            return;
        }
        this.mode = newMode;
        if (ReactVirtualViewExperimentalKt.IS_DEBUG_BUILD && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
            FLog.d("ReactVirtualViewExperimental:[" + getVirtualViewID() + "]:onModeChange", virtualViewMode2 + "->" + newMode);
        }
        if (virtualViewMode2 == virtualViewMode) {
            updateClippingRect(null);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[newMode.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (virtualViewMode2 == virtualViewMode || (virtualViewModeChangeEmitter2 = this.modeChangeEmitter) == null) {
                    return;
                }
                virtualViewModeChangeEmitter2.emitModeChange(VirtualViewMode.Prerender, getContainerRelativeRect(), thresholdRect, false);
                return;
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            VirtualViewModeChangeEmitter virtualViewModeChangeEmitter3 = this.modeChangeEmitter;
            if (virtualViewModeChangeEmitter3 != null) {
                virtualViewModeChangeEmitter3.emitModeChange(VirtualViewMode.Hidden, getContainerRelativeRect(), thresholdRect, false);
                return;
            }
            return;
        }
        VirtualViewRenderState virtualViewRenderState = this.renderState;
        if (virtualViewRenderState == VirtualViewRenderState.Unknown) {
            VirtualViewModeChangeEmitter virtualViewModeChangeEmitter4 = this.modeChangeEmitter;
            if (virtualViewModeChangeEmitter4 != null) {
                virtualViewModeChangeEmitter4.emitModeChange(virtualViewMode, getContainerRelativeRect(), thresholdRect, true);
                return;
            }
            return;
        }
        if ((virtualViewMode2 == VirtualViewMode.Prerender && virtualViewRenderState == VirtualViewRenderState.Rendered) || (virtualViewModeChangeEmitter = this.modeChangeEmitter) == null) {
            return;
        }
        virtualViewModeChangeEmitter.emitModeChange(virtualViewMode, getContainerRelativeRect(), thresholdRect, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.views.view.ReactViewGroup, com.facebook.react.uimanager.ReactClippingViewGroup
    public void updateClippingRect(Set set) {
        if (get_removeClippedSubviews$ReactAndroid_release()) {
            if (this.scrollView == null) {
                super.updateClippingRect(set);
                return;
            }
            Rect clippingRect$ReactAndroid_release = getClippingRect$ReactAndroid_release();
            if (clippingRect$ReactAndroid_release == null) {
                throw new IllegalStateException("Required value was null.");
            }
            VirtualViewContainer virtualViewContainer = this.scrollView;
            if (virtualViewContainer == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Intrinsics.checkNotNull(virtualViewContainer, "null cannot be cast to non-null type com.facebook.react.uimanager.ReactClippingViewGroup");
            ReactClippingViewGroup reactClippingViewGroup = (ReactClippingViewGroup) virtualViewContainer;
            if (ReactNativeFeatureFlags.enableVirtualViewClippingWithoutScrollViewClipping()) {
                if (reactClippingViewGroup.getRemoveClippedSubviews()) {
                    reactClippingViewGroup.getClippingRect(clippingRect$ReactAndroid_release);
                } else {
                    ((View) reactClippingViewGroup).getDrawingRect(clippingRect$ReactAndroid_release);
                }
            } else {
                if (!reactClippingViewGroup.getRemoveClippedSubviews()) {
                    super.updateClippingRect(set);
                    return;
                }
                reactClippingViewGroup.getClippingRect(clippingRect$ReactAndroid_release);
            }
            clippingRect$ReactAndroid_release.intersect(getContainerRelativeRect());
            clippingRect$ReactAndroid_release.offset(-getContainerRelativeRect().left, -getContainerRelativeRect().top);
            if (Intrinsics.areEqual(this.lastClippingRect, clippingRect$ReactAndroid_release)) {
                return;
            }
            updateClippingToRect$ReactAndroid_release(clippingRect$ReactAndroid_release, set);
            this.lastClippingRect.set(clippingRect$ReactAndroid_release);
        }
    }

    private final void updateParentOffset() {
        VirtualViewContainer virtualViewContainer = this.scrollView;
        if (virtualViewContainer == null) {
            return;
        }
        this.offsetX = 0;
        this.offsetY = 0;
        for (ViewParent parent = getParent(); parent != null && !Intrinsics.areEqual(parent, virtualViewContainer); parent = parent.getParent()) {
            if (parent instanceof View) {
                View view = (View) parent;
                this.offsetX += view.getLeft();
                this.offsetY += view.getTop();
            }
        }
        getContainerRelativeRect().set(getLeft() + this.offsetX, getTop() + this.offsetY, getRight() + this.offsetX, getBottom() + this.offsetY);
    }

    private final void reportRectChangeToContainer() {
        VirtualViewContainerState virtualViewContainerState;
        if (Intrinsics.areEqual(this.lastContainerRelativeRect, getContainerRelativeRect())) {
            if (ReactVirtualViewExperimentalKt.IS_DEBUG_BUILD && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
                FLog.d("ReactVirtualViewExperimental:[" + getVirtualViewID() + "]:reportRectChangeToContainer", "no rect change " + getContainerRelativeRect());
                return;
            }
            return;
        }
        VirtualViewContainer virtualViewContainer = this.scrollView;
        if (virtualViewContainer != null) {
            if (virtualViewContainer != null && (virtualViewContainerState = virtualViewContainer.getVirtualViewContainerState()) != null) {
                virtualViewContainerState.onChange(this);
            }
            this.lastContainerRelativeRect.set(getContainerRelativeRect());
        }
    }

    private final VirtualViewContainer getScrollView() {
        return traverseParentStack(true);
    }

    private final void cleanupLayoutListeners() {
        traverseParentStack(false);
    }

    private final VirtualViewContainer traverseParentStack(boolean z) {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof VirtualViewContainer) {
                return (VirtualViewContainer) parent;
            }
            if (parent instanceof ReactRoot) {
                return null;
            }
            if (parent instanceof View) {
                View view = (View) parent;
                view.removeOnLayoutChangeListener(this);
                if (z) {
                    view.addOnLayoutChangeListener(this);
                }
            }
        }
        return null;
    }
}
