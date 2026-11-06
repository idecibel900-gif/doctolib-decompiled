package com.facebook.fresco.ui.common;

/* JADX INFO: loaded from: classes3.dex */
public interface ImagePerfNotifier {
    void notifyStatusUpdated(ImagePerfState imagePerfState, ImageLoadStatus imageLoadStatus);

    void notifyVisibilityUpdated(ImagePerfState imagePerfState, VisibilityState visibilityState);
}
