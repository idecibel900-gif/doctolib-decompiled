package com.facebook.react.views.scroll;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.views.virtual.VirtualViewMode;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class VirtualViewContainerStateExperimental extends VirtualViewContainerState {
    private Set HPV;
    private Set P;
    private Set V;
    private final boolean horizontal;
    private final IntervalTree virtualViews;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualViewContainerStateExperimental(ViewGroup scrollView) {
        super(scrollView);
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        boolean z = false;
        if (!(scrollView instanceof ReactScrollView) && (scrollView instanceof ReactHorizontalScrollView)) {
            z = true;
        }
        this.horizontal = z;
        this.virtualViews = new IntervalTree(z);
        this.HPV = new LinkedHashSet();
        this.P = new LinkedHashSet();
        this.V = new LinkedHashSet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.views.scroll.VirtualViewContainerState
    public IntervalTree getVirtualViews() {
        return this.virtualViews;
    }

    @Override // com.facebook.react.views.scroll.VirtualViewContainerState
    public void onChange(VirtualView virtualView) {
        Intrinsics.checkNotNullParameter(virtualView, "virtualView");
        if (getVirtualViews().add(virtualView)) {
            if (VirtualViewContainerKt.getIS_DEBUG_BUILD() && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
                FLog.d("VirtualViewContainerStateExperimental:add", "virtualViewID=" + virtualView.getVirtualViewID());
            }
        } else if (VirtualViewContainerKt.getIS_DEBUG_BUILD() && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
            FLog.d("VirtualViewContainerStateExperimental:update", "virtualViewID=" + virtualView.getVirtualViewID());
        }
        updateModes(virtualView);
    }

    @Override // com.facebook.react.views.scroll.VirtualViewContainerState
    protected void updateModes(VirtualView virtualView) {
        updateRects();
        if (virtualView != null) {
            updateMode(virtualView);
        } else {
            updateModesAll();
        }
    }

    private final void updateMode(VirtualView virtualView) {
        VirtualViewMode virtualViewMode;
        Rect containerRelativeRect = virtualView.getContainerRelativeRect();
        VirtualViewMode virtualViewMode2 = VirtualViewMode.Hidden;
        Rect emptyRect = getEmptyRect();
        if (VirtualViewContainerKt.rectsOverlap(containerRelativeRect, getVisibleRect())) {
            emptyRect = getVisibleRect();
            if (getOnWindowFocusChangeListener() == null || getScrollView().hasWindowFocus()) {
                virtualViewMode = VirtualViewMode.Visible;
            } else {
                virtualViewMode = VirtualViewMode.Prerender;
            }
        } else if (VirtualViewContainerKt.rectsOverlap(containerRelativeRect, getPrerenderRect())) {
            virtualViewMode = VirtualViewMode.Prerender;
            emptyRect = getPrerenderRect();
        } else {
            virtualViewMode = (getHysteresisRatio() <= 0.0d || !VirtualViewContainerKt.rectsOverlap(containerRelativeRect, getHysteresisRect())) ? virtualViewMode2 : null;
        }
        if (virtualViewMode != null) {
            virtualView.onModeChange(virtualViewMode, emptyRect);
        }
        if (virtualViewMode == VirtualViewMode.Visible) {
            this.HPV.add(virtualView.getVirtualViewID());
            this.P.remove(virtualView.getVirtualViewID());
            this.V.add(virtualView.getVirtualViewID());
        } else if (virtualViewMode == VirtualViewMode.Prerender) {
            this.HPV.add(virtualView.getVirtualViewID());
            this.P.add(virtualView.getVirtualViewID());
            this.V.remove(virtualView.getVirtualViewID());
        } else if (virtualViewMode == virtualViewMode2) {
            this.HPV.remove(virtualView.getVirtualViewID());
            this.P.remove(virtualView.getVirtualViewID());
            this.V.remove(virtualView.getVirtualViewID());
        } else {
            this.HPV.add(virtualView.getVirtualViewID());
            this.P.remove(virtualView.getVirtualViewID());
            this.V.remove(virtualView.getVirtualViewID());
        }
    }

    private final void updateModesAll() {
        Set setQuery = getVirtualViews().query(getVisibleRect());
        Set setQuery2 = getVirtualViews().query(getPrerenderRect());
        Set setQuery3 = getVirtualViews().query(getHysteresisRect());
        if (VirtualViewContainerKt.getIS_DEBUG_BUILD() && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
            FLog.d("VirtualViewContainerStateExperimental:updateModes", "V: " + this.V + ", P: " + this.P + ", HPV: " + this.HPV);
        }
        Set setMinus = SetsKt.minus(setQuery2, (Iterable) setQuery);
        if (VirtualViewContainerKt.getIS_DEBUG_BUILD() && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
            FLog.d("VirtualViewContainerStateExperimental:updateModes", "V': " + setQuery + ", P': " + setMinus + ", HPV': " + setQuery3);
        }
        Set setMinus2 = SetsKt.minus(setQuery, (Iterable) this.V);
        Set setMinus3 = SetsKt.minus(setMinus, (Iterable) this.P);
        Set set = setQuery3;
        Set setMinus4 = SetsKt.minus(this.HPV, (Iterable) set);
        if (VirtualViewContainerKt.getIS_DEBUG_BUILD() && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
            FLog.d("VirtualViewContainerStateExperimental:updateModes", "toV: " + setMinus2 + ", toP: " + setMinus3 + ", toH: " + setMinus4);
        }
        Iterator it = setMinus2.iterator();
        while (it.hasNext()) {
            VirtualView virtualView = getVirtualViews().getVirtualView((String) it.next());
            if (virtualView != null) {
                virtualView.onModeChange(VirtualViewMode.Visible, getVisibleRect());
            }
        }
        Iterator it2 = setMinus3.iterator();
        while (it2.hasNext()) {
            VirtualView virtualView2 = getVirtualViews().getVirtualView((String) it2.next());
            if (virtualView2 != null) {
                virtualView2.onModeChange(VirtualViewMode.Prerender, getPrerenderRect());
            }
        }
        Iterator it3 = setMinus4.iterator();
        while (it3.hasNext()) {
            VirtualView virtualView3 = getVirtualViews().getVirtualView((String) it3.next());
            if (virtualView3 != null) {
                virtualView3.onModeChange(VirtualViewMode.Hidden, getEmptyRect());
            }
        }
        this.V = setQuery;
        this.P = CollectionsKt.toMutableSet(setMinus);
        this.HPV = CollectionsKt.toMutableSet(set);
    }
}
