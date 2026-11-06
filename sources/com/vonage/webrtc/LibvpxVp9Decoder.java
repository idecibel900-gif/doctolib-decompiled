package com.vonage.webrtc;

/* JADX INFO: loaded from: classes4.dex */
public class LibvpxVp9Decoder extends WrappedNativeVideoDecoder {
    static native long nativeCreateDecoder();

    static native boolean nativeIsSupported();

    @Override // com.vonage.webrtc.WrappedNativeVideoDecoder, com.vonage.webrtc.VideoDecoder
    public long createNativeVideoDecoder() {
        return nativeCreateDecoder();
    }
}
