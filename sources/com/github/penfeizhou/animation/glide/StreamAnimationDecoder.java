package com.github.penfeizhou.animation.glide;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.github.penfeizhou.animation.apng.decode.APNGParser;
import com.github.penfeizhou.animation.avif.decode.AVIFParser;
import com.github.penfeizhou.animation.gif.decode.GifParser;
import com.github.penfeizhou.animation.io.StreamReader;
import com.github.penfeizhou.animation.webp.decode.WebPParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes3.dex */
public class StreamAnimationDecoder implements ResourceDecoder {
    private final ResourceDecoder byteBufferDecoder;

    public StreamAnimationDecoder(ResourceDecoder resourceDecoder) {
        this.byteBufferDecoder = resourceDecoder;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(InputStream inputStream, Options options) {
        if (!((Boolean) options.get(AnimationDecoderOption.DISABLE_ANIMATION_WEBP_DECODER)).booleanValue() && WebPParser.isAWebP(new StreamReader(inputStream))) {
            return true;
        }
        if (!((Boolean) options.get(AnimationDecoderOption.DISABLE_ANIMATION_APNG_DECODER)).booleanValue() && APNGParser.isAPNG(new StreamReader(inputStream))) {
            return true;
        }
        if (((Boolean) options.get(AnimationDecoderOption.DISABLE_ANIMATION_GIF_DECODER)).booleanValue() || !GifParser.isGif(new StreamReader(inputStream))) {
            return !((Boolean) options.get(AnimationDecoderOption.DISABLE_ANIMATION_AVIF_DECODER)).booleanValue() && AVIFParser.isAVIF(new StreamReader(inputStream));
        }
        return true;
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
