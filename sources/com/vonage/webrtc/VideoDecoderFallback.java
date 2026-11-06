package com.vonage.webrtc;

/* JADX INFO: loaded from: classes4.dex */
public class VideoDecoderFallback extends WrappedNativeVideoDecoder {
    private final VideoDecoder fallback;
    private final VideoDecoder primary;

    private static native long nativeCreateDecoder(VideoDecoder videoDecoder, VideoDecoder videoDecoder2);

    public VideoDecoderFallback(VideoDecoder videoDecoder, VideoDecoder videoDecoder2) {
        this.fallback = videoDecoder;
        this.primary = videoDecoder2;
    }

    @Override // com.vonage.webrtc.WrappedNativeVideoDecoder, com.vonage.webrtc.VideoDecoder
    public long createNativeVideoDecoder() {
        return nativeCreateDecoder(this.fallback, this.primary);
    }
}
