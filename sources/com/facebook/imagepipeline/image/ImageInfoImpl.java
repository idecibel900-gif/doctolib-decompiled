package com.facebook.imagepipeline.image;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ImageInfoImpl implements ImageInfo {
    private final Map extras;
    private final int height;
    private final QualityInfo qualityInfo;
    private final int sizeInBytes;
    private final int width;

    public ImageInfoImpl(int i, int i2, int i3, QualityInfo qualityInfo, Map map) {
        this.width = i;
        this.height = i2;
        this.sizeInBytes = i3;
        this.qualityInfo = qualityInfo;
        this.extras = map;
    }

    @Override // com.facebook.imagepipeline.image.HasImageMetadata, com.facebook.fresco.middleware.HasExtraData
    public Map getExtras() {
        return this.extras;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getWidth() {
        return this.width;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getHeight() {
        return this.height;
    }
}
