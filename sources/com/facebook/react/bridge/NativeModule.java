package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public interface NativeModule {
    @Deprecated
    default boolean canOverrideExistingModule() {
        return false;
    }

    String getName();

    void initialize();

    void invalidate();

    @Deprecated(forRemoval = true, since = "Use invalidate method instead")
    default void onCatalystInstanceDestroy() {
    }
}
