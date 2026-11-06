package com.swmansion.rnscreens.bottomsheet;

import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class DimmingViewPointerEventsImpl implements ReactPointerEventsView {
    private final DimmingView dimmingView;

    public DimmingViewPointerEventsImpl(DimmingView dimmingView) {
        Intrinsics.checkNotNullParameter(dimmingView, "dimmingView");
        this.dimmingView = dimmingView;
    }

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    public PointerEvents getPointerEvents() {
        return this.dimmingView.getBlockGestures$react_native_screens_release() ? PointerEvents.AUTO : PointerEvents.NONE;
    }
}
