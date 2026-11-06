package com.bumptech.glide.integration.avif;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.ByteBufferUtil;
import com.bumptech.glide.util.Preconditions;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class AvifStreamBitmapDecoder implements ResourceDecoder {
    private final ArrayPool arrayPool;
    private final AvifByteBufferBitmapDecoder avifByteBufferDecoder;
    private final List parsers;

    public AvifStreamBitmapDecoder(List list, AvifByteBufferBitmapDecoder avifByteBufferBitmapDecoder, ArrayPool arrayPool) {
        this.parsers = list;
        this.avifByteBufferDecoder = (AvifByteBufferBitmapDecoder) Preconditions.checkNotNull(avifByteBufferBitmapDecoder);
        this.arrayPool = (ArrayPool) Preconditions.checkNotNull(arrayPool);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(InputStream inputStream, int i, int i2, Options options) {
        return this.avifByteBufferDecoder.decode(ByteBufferUtil.fromStream(inputStream), i, i2, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(InputStream inputStream, Options options) {
        ImageHeaderParser.ImageType type = ImageHeaderParserUtils.getType(this.parsers, inputStream, this.arrayPool);
        return type.equals(ImageHeaderParser.ImageType.AVIF) || type.equals(ImageHeaderParser.ImageType.ANIMATED_AVIF);
    }
}
