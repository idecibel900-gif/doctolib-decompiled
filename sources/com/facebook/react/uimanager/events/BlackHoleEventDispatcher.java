package com.facebook.react.uimanager.events;

import com.facebook.common.logging.FLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BlackHoleEventDispatcher implements EventDispatcher {
    public static final BlackHoleEventDispatcher INSTANCE = new BlackHoleEventDispatcher();

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public void addListener(EventDispatcherListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public void onCatalystInstanceDestroyed() {
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public void removeListener(EventDispatcherListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    private BlackHoleEventDispatcher() {
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public void dispatchEvent(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        FLog.d("BlackHoleEventDispatcher", "Trying to emit event to JS, but the React instance isn't ready. Event: " + event.getEventName());
    }
}
