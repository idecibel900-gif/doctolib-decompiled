package com.bumptech.glide.integration.webp.decoder;

import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class WebpDrawableEncoder implements ResourceEncoder {
    @Override // com.bumptech.glide.load.ResourceEncoder
    public EncodeStrategy getEncodeStrategy(Options options) {
        return EncodeStrategy.SOURCE;
    }

    @Override // com.bumptech.glide.load.Encoder
    public boolean encode(Resource resource, File file, Options options) throws Throwable {
        try {
            ByteBufferUtil.toFile(((WebpDrawable) resource.get()).getBuffer(), file);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
