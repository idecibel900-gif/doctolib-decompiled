package com.reactnativepagerview;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PagerViewPackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public List createNativeModules(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.emptyList();
    }

    @Override // com.facebook.react.ReactPackage
    public List createViewManagers(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.listOf(new PagerViewViewManager());
    }
}
