package com.facebook.imagepipeline.nativecode;

import com.facebook.soloader.nativeloader.NativeLoader;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeFiltersLoader {
    public static void load() {
        NativeLoader.loadLibrary("native-filters");
    }
}
