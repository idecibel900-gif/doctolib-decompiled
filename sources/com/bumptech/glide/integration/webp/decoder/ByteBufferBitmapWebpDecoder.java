package com.bumptech.glide.integration.webp.decoder;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class ByteBufferBitmapWebpDecoder implements ResourceDecoder {
    private final WebpDownsampler downsampler;

    public ByteBufferBitmapWebpDecoder(WebpDownsampler webpDownsampler) {
        this.downsampler = webpDownsampler;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(ByteBuffer byteBuffer, Options options) {
        return this.downsampler.handles(byteBuffer, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(ByteBuffer byteBuffer, int i, int i2, Options options) {
        return this.downsampler.decode(ByteBufferUtil.toStream(byteBuffer), i, i2, options);
    }
}
