package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes3.dex */
public class StreamGifDecoder implements ResourceDecoder {
    private final ArrayPool byteArrayPool;
    private final ResourceDecoder byteBufferDecoder;
    private final List parsers;

    public StreamGifDecoder(List list, ResourceDecoder resourceDecoder, ArrayPool arrayPool) {
        this.parsers = list;
        this.byteBufferDecoder = resourceDecoder;
        this.byteArrayPool = arrayPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(InputStream inputStream, Options options) {
        return !((Boolean) options.get(GifOptions.DISABLE_ANIMATION)).booleanValue() && ImageHeaderParserUtils.getType(this.parsers, inputStream, this.byteArrayPool) == ImageHeaderParser.ImageType.GIF;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(InputStream inputStream, int i, int i2, Options options) {
        byte[] bArrInputStreamToBytes = inputStreamToBytes(inputStream);
        if (bArrInputStreamToBytes == null) {
            return null;
        }
        return this.byteBufferDecoder.decode(ByteBuffer.wrap(bArrInputStreamToBytes), i, i2, options);
    }

    private static byte[] inputStreamToBytes(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Http2.INITIAL_MAX_FRAME_SIZE);
        try {
            byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
