package com.facebook.react;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactApplicationContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactPackageHelper {
    public static final ReactPackageHelper INSTANCE = new ReactPackageHelper();

    private ReactPackageHelper() {
    }

    public final Iterable getNativeModuleIterator(ReactPackage reactPackage, ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(reactPackage, "reactPackage");
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        FLog.d("ReactNative", reactPackage.getClass().getSimpleName() + " is not a LazyReactPackage, falling back to old version.");
        return new ReactPackageHelper$getNativeModuleIterator$$inlined$Iterable$1(reactPackage.createNativeModules(reactApplicationContext));
    }
}
