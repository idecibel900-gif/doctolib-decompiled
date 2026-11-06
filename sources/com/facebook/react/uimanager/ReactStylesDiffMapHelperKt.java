package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReactStylesDiffMapHelperKt {
    public static final ReadableMap getBackingMap(ReactStylesDiffMap reactStylesDiffMap) {
        Intrinsics.checkNotNullParameter(reactStylesDiffMap, "<this>");
        ReadableMap backingMap = ReactStylesDiffMapBackingFieldAccessor.getBackingMap(reactStylesDiffMap);
        Intrinsics.checkNotNullExpressionValue(backingMap, "getBackingMap(...)");
        return backingMap;
    }
}
