package com.vonage.webrtc;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SoftwareVideoDecoderFactory implements VideoDecoderFactory {
    private static final String TAG = "SoftwareVideoDecoderFactory";
    private final long nativeFactory = nativeCreateFactory();

    private static native long nativeCreateDecoder(long j, VideoCodecInfo videoCodecInfo);

    private static native long nativeCreateFactory();

    private static native List<VideoCodecInfo> nativeGetSupportedCodecs(long j);

    @Override // com.vonage.webrtc.VideoDecoderFactory
    public VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
        final long jNativeCreateDecoder = nativeCreateDecoder(this.nativeFactory, videoCodecInfo);
        if (jNativeCreateDecoder == 0) {
            Logging.w(TAG, "Trying to create decoder for unsupported format. " + videoCodecInfo);
            return null;
        }
        return new WrappedNativeVideoDecoder() { // from class: com.vonage.webrtc.SoftwareVideoDecoderFactory.1
            @Override // com.vonage.webrtc.WrappedNativeVideoDecoder, com.vonage.webrtc.VideoDecoder
            public long createNativeVideoDecoder() {
                return jNativeCreateDecoder;
            }
        };
    }

    @Override // com.vonage.webrtc.VideoDecoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        return (VideoCodecInfo[]) nativeGetSupportedCodecs(this.nativeFactory).toArray(new VideoCodecInfo[0]);
    }
}
