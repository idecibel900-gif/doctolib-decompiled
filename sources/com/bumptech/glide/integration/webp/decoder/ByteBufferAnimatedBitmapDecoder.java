package com.bumptech.glide.integration.webp.decoder;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class ByteBufferAnimatedBitmapDecoder implements ResourceDecoder {
    private final AnimatedWebpBitmapDecoder bitmapDecoder;

    public ByteBufferAnimatedBitmapDecoder(AnimatedWebpBitmapDecoder animatedWebpBitmapDecoder) {
        this.bitmapDecoder = animatedWebpBitmapDecoder;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(ByteBuffer byteBuffer, Options options) {
        return this.bitmapDecoder.handles(byteBuffer, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(ByteBuffer byteBuffer, int i, int i2, Options options) {
        return this.bitmapDecoder.decode(byteBuffer, i, i2, options);
    }
}
