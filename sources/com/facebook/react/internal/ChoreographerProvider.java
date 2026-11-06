package com.facebook.react.internal;

/* JADX INFO: loaded from: classes3.dex */
public interface ChoreographerProvider {

    public interface Choreographer {
        void postFrameCallback(android.view.Choreographer.FrameCallback frameCallback);

        void removeFrameCallback(android.view.Choreographer.FrameCallback frameCallback);
    }

    Choreographer getChoreographer();
}
