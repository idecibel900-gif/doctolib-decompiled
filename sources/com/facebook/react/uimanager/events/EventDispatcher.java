package com.facebook.react.uimanager.events;

/* JADX INFO: loaded from: classes3.dex */
public interface EventDispatcher {
    void addListener(EventDispatcherListener eventDispatcherListener);

    void dispatchEvent(Event event);

    void onCatalystInstanceDestroyed();

    void removeListener(EventDispatcherListener eventDispatcherListener);
}
