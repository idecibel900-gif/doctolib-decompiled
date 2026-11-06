package com.bumptech.glide.integration.webp.decoder;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class StreamBitmapWebpDecoder implements ResourceDecoder {
    private final ArrayPool byteArrayPool;
    private final WebpDownsampler downsampler;

    public StreamBitmapWebpDecoder(WebpDownsampler webpDownsampler, ArrayPool arrayPool) {
        this.downsampler = webpDownsampler;
        this.byteArrayPool = arrayPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(InputStream inputStream, Options options) {
        return this.downsampler.handles(inputStream, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(InputStream inputStream, int i, int i2, Options options) {
        return this.downsampler.decode(inputStream, i, i2, options);
    }
}
