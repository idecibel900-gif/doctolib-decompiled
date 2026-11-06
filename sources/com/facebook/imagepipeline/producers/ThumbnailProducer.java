package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;

/* JADX INFO: loaded from: classes3.dex */
public interface ThumbnailProducer extends Producer {
    boolean canProvideImageForSize(ResizeOptions resizeOptions);
}
