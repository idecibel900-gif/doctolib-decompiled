package com.facebook.react.animated;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AnimationDriver {
    public ValueAnimatedNode animatedValue;
    public Callback endCallback;
    public boolean hasFinished;
    public int id;

    public abstract void resetConfig(ReadableMap readableMap);

    public abstract void runAnimationStep(long j);
}
