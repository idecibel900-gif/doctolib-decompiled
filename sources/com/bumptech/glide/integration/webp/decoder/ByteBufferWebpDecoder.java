package com.bumptech.glide.integration.webp.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.integration.webp.WebpHeaderParser;
import com.bumptech.glide.integration.webp.WebpImage;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.load.resource.gif.GifBitmapProvider;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class ByteBufferWebpDecoder implements ResourceDecoder {
    public static final Option DISABLE_ANIMATION = Option.memory("com.bumptech.glide.integration.webp.decoder.ByteBufferWebpDecoder.DisableAnimation", Boolean.FALSE);
    private final BitmapPool mBitmapPool;
    private final Context mContext;
    private final GifBitmapProvider mProvider;

    public ByteBufferWebpDecoder(Context context, ArrayPool arrayPool, BitmapPool bitmapPool) {
        this.mContext = context.getApplicationContext();
        this.mBitmapPool = bitmapPool;
        this.mProvider = new GifBitmapProvider(bitmapPool, arrayPool);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(ByteBuffer byteBuffer, Options options) {
        if (((Boolean) options.get(DISABLE_ANIMATION)).booleanValue()) {
            return false;
        }
        return WebpHeaderParser.isAnimatedWebpType(WebpHeaderParser.getType(byteBuffer));
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(ByteBuffer byteBuffer, int i, int i2, Options options) {
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.get(bArr, 0, iRemaining);
        WebpImage webpImageCreate = WebpImage.create(bArr);
        WebpDecoder webpDecoder = new WebpDecoder(this.mProvider, webpImageCreate, byteBuffer, Utils.getSampleSize(webpImageCreate.getWidth(), webpImageCreate.getHeight(), i, i2), (WebpFrameCacheStrategy) options.get(WebpFrameLoader.FRAME_CACHE_STRATEGY));
        webpDecoder.advance();
        Bitmap nextFrame = webpDecoder.getNextFrame();
        if (nextFrame == null) {
            return null;
        }
        return new WebpDrawableResource(new WebpDrawable(this.mContext, webpDecoder, this.mBitmapPool, UnitTransformation.get(), i, i2, nextFrame));
    }
}
