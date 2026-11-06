package com.swmansion.worklets.runloop;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

/* JADX INFO: loaded from: classes4.dex */
public class AnimationFrameCallback {

    @DoNotStrip
    private final HybridData mHybridData;

    public native void onAnimationFrame(double d);

    @DoNotStrip
    private AnimationFrameCallback(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
