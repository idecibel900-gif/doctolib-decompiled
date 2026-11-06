package com.bumptech.glide.integration.avif;

import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import org.aomedia.avif.android.AvifDecoder;

/* JADX INFO: loaded from: classes3.dex */
public final class AvifByteBufferBitmapDecoder implements ResourceDecoder {
    private final BitmapPool bitmapPool;

    public AvifByteBufferBitmapDecoder(BitmapPool bitmapPool) {
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool);
    }

    private ByteBuffer maybeCopyBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.isDirect()) {
            return byteBuffer;
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(byteBuffer.remaining());
        byteBufferAllocateDirect.put(byteBuffer);
        byteBufferAllocateDirect.flip();
        return byteBufferAllocateDirect;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(ByteBuffer byteBuffer, int i, int i2, Options options) {
        Bitmap.Config config;
        ByteBuffer byteBufferMaybeCopyBuffer = maybeCopyBuffer(byteBuffer);
        AvifDecoder.Info info = new AvifDecoder.Info();
        if (!AvifDecoder.getInfo(byteBufferMaybeCopyBuffer, byteBufferMaybeCopyBuffer.remaining(), info)) {
            return null;
        }
        if (options.get(Downsampler.DECODE_FORMAT) == DecodeFormat.PREFER_RGB_565) {
            config = Bitmap.Config.RGB_565;
        } else {
            config = info.depth == 8 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGBA_F16;
        }
        Bitmap bitmap = this.bitmapPool.get(info.width, info.height, config);
        if (!AvifDecoder.decode(byteBufferMaybeCopyBuffer, byteBufferMaybeCopyBuffer.remaining(), bitmap)) {
            this.bitmapPool.put(bitmap);
            return null;
        }
        return BitmapResource.obtain(bitmap, this.bitmapPool);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(ByteBuffer byteBuffer, Options options) {
        return AvifDecoder.isAvifImage(maybeCopyBuffer(byteBuffer));
    }
}
