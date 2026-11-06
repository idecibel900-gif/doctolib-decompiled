package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReactStylesDiffMapBackingFieldAccessor {
    static ReadableMap getBackingMap(ReactStylesDiffMap reactStylesDiffMap) {
        return reactStylesDiffMap.internal_backingMap();
    }
}
