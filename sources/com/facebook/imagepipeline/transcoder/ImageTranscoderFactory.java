package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;

/* JADX INFO: loaded from: classes3.dex */
public interface ImageTranscoderFactory {
    ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z);
}
