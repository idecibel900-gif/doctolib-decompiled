package com.vonage.webrtc;

/* JADX INFO: loaded from: classes4.dex */
public abstract class WrappedNativeVideoDecoder implements VideoDecoder {
    @Override // com.vonage.webrtc.VideoDecoder
    public abstract long createNativeVideoDecoder();

    @Override // com.vonage.webrtc.VideoDecoder
    public final VideoCodecStatus initDecode(VideoDecoder.Settings settings, VideoDecoder.Callback callback) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override // com.vonage.webrtc.VideoDecoder
    public final VideoCodecStatus release() {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override // com.vonage.webrtc.VideoDecoder
    public final VideoCodecStatus decode(EncodedImage encodedImage, VideoDecoder.DecodeInfo decodeInfo) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override // com.vonage.webrtc.VideoDecoder
    public final String getImplementationName() {
        throw new UnsupportedOperationException("Not implemented.");
    }
}
