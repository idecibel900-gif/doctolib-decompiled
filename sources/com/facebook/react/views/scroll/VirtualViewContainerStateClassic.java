package com.facebook.react.views.scroll;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.views.virtual.VirtualViewMode;
import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class VirtualViewContainerStateClassic extends VirtualViewContainerState {
    private final Collection virtualViews;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualViewContainerStateClassic(ViewGroup scrollView) {
        super(scrollView);
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        this.virtualViews = new LinkedHashSet();
    }

    @Override // com.facebook.react.views.scroll.VirtualViewContainerState
    protected Collection getVirtualViews() {
        return this.virtualViews;
    }

    @Override // com.facebook.react.views.scroll.VirtualViewContainerState
    protected void updateModes(VirtualView virtualView) {
        getScrollView().getDrawingRect(getVisibleRect());
        if (getVisibleRect().isEmpty()) {
            if (VirtualViewContainerKt.getIS_DEBUG_BUILD() && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
                FLog.d("VirtualViewContainerStateClassic:updateModes", "scrollView visibleRect is empty");
                return;
            }
            return;
        }
        getPrerenderRect().set(getVisibleRect());
        getPrerenderRect().inset((int) (((double) (-getPrerenderRect().width())) * getPrerenderRatio()), (int) (((double) (-getPrerenderRect().height())) * getPrerenderRatio()));
        if (getHysteresisRatio() > 0.0d) {
            getHysteresisRect().set(getPrerenderRect());
            getHysteresisRect().inset((int) (((double) (-getVisibleRect().width())) * getHysteresisRatio()), (int) (((double) (-getVisibleRect().height())) * getHysteresisRatio()));
        }
        for (VirtualView virtualView2 : virtualView != null ? CollectionsKt.listOf(virtualView) : CollectionsKt.toMutableSet(getVirtualViews())) {
            Rect containerRelativeRect = virtualView2.getContainerRelativeRect();
            VirtualViewMode virtualViewMode = VirtualViewMode.Hidden;
            Rect emptyRect = getEmptyRect();
            if (VirtualViewContainerKt.rectsOverlap(containerRelativeRect, getVisibleRect())) {
                emptyRect = getVisibleRect();
                virtualViewMode = (getOnWindowFocusChangeListener() == null || getScrollView().hasWindowFocus()) ? VirtualViewMode.Visible : VirtualViewMode.Prerender;
            } else if (VirtualViewContainerKt.rectsOverlap(containerRelativeRect, getPrerenderRect())) {
                virtualViewMode = VirtualViewMode.Prerender;
                emptyRect = getPrerenderRect();
            } else if (getHysteresisRatio() > 0.0d && VirtualViewContainerKt.rectsOverlap(containerRelativeRect, getHysteresisRect())) {
                virtualViewMode = null;
            }
            if (virtualViewMode != null) {
                virtualView2.onModeChange(virtualViewMode, emptyRect);
                if (VirtualViewContainerKt.getIS_DEBUG_BUILD() && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
                    FLog.d("VirtualViewContainerStateClassic:updateModes", "virtualView=" + virtualView2.getVirtualViewID() + " mode=" + virtualViewMode + "  rect=" + containerRelativeRect + " thresholdRect=" + emptyRect);
                }
            }
        }
    }
}
