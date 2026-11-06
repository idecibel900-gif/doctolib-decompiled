package com.facebook.imagepipeline.nativecode;

import com.facebook.soloader.nativeloader.NativeLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ImagePipelineNativeLoader {
    public static final List DEPENDENCIES = Collections.unmodifiableList(new ArrayList());

    public static void load() {
        NativeLoader.loadLibrary("imagepipeline");
    }
}
