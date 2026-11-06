package com.swmansion.rnscreens.bottomsheet;

import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;

/* JADX INFO: loaded from: classes4.dex */
public final class DimmingViewPointerEventsProxy implements ReactPointerEventsView {
    private DimmingViewPointerEventsImpl pointerEventsImpl;

    public DimmingViewPointerEventsProxy(DimmingViewPointerEventsImpl dimmingViewPointerEventsImpl) {
        this.pointerEventsImpl = dimmingViewPointerEventsImpl;
    }

    public final void setPointerEventsImpl(DimmingViewPointerEventsImpl dimmingViewPointerEventsImpl) {
        this.pointerEventsImpl = dimmingViewPointerEventsImpl;
    }

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    public PointerEvents getPointerEvents() {
        PointerEvents pointerEvents;
        DimmingViewPointerEventsImpl dimmingViewPointerEventsImpl = this.pointerEventsImpl;
        return (dimmingViewPointerEventsImpl == null || (pointerEvents = dimmingViewPointerEventsImpl.getPointerEvents()) == null) ? PointerEvents.NONE : pointerEvents;
    }
}
