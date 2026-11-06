package com.bumptech.glide.integration.avif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.module.LibraryGlideModule;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class AvifGlideModule extends LibraryGlideModule {
    @Override // com.bumptech.glide.module.LibraryGlideModule
    public void registerComponents(Context context, Glide glide, Registry registry) {
        AvifByteBufferBitmapDecoder avifByteBufferBitmapDecoder = new AvifByteBufferBitmapDecoder(glide.getBitmapPool());
        registry.prepend("Bitmap", ByteBuffer.class, Bitmap.class, avifByteBufferBitmapDecoder);
        registry.prepend("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(context.getResources(), avifByteBufferBitmapDecoder));
        ResourceDecoder avifStreamBitmapDecoder = new AvifStreamBitmapDecoder(registry.getImageHeaderParsers(), avifByteBufferBitmapDecoder, glide.getArrayPool());
        registry.prepend("Bitmap", InputStream.class, Bitmap.class, avifStreamBitmapDecoder);
        registry.prepend("BitmapDrawable", InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(context.getResources(), avifStreamBitmapDecoder));
    }
}
