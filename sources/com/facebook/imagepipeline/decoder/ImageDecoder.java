package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface ImageDecoder {
    CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions);
}
