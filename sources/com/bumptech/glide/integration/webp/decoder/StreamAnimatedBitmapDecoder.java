package com.bumptech.glide.integration.webp.decoder;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class StreamAnimatedBitmapDecoder implements ResourceDecoder {
    private final AnimatedWebpBitmapDecoder bitmapDecoder;

    public StreamAnimatedBitmapDecoder(AnimatedWebpBitmapDecoder animatedWebpBitmapDecoder) {
        this.bitmapDecoder = animatedWebpBitmapDecoder;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(InputStream inputStream, Options options) {
        return this.bitmapDecoder.handles(inputStream, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(InputStream inputStream, int i, int i2, Options options) {
        return this.bitmapDecoder.decode(inputStream, i, i2, options);
    }
}
