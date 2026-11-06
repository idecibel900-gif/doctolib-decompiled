package com.swmansion.rnscreens;

import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;

/* JADX INFO: loaded from: classes4.dex */
public final class PointerEventsBoxNoneImpl implements ReactPointerEventsView {
    private final PointerEvents pointerEvents = PointerEvents.BOX_NONE;

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    public PointerEvents getPointerEvents() {
        return this.pointerEvents;
    }
}
