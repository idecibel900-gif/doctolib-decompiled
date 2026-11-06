package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.EncodedImage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DecodeException extends RuntimeException {
    private final EncodedImage encodedImage;

    public final EncodedImage getEncodedImage() {
        return this.encodedImage;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DecodeException(String str, EncodedImage encodedImage) {
        super(str);
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        this.encodedImage = encodedImage;
    }
}
