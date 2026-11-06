package com.vonage.webrtc;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SoftwareVideoEncoderFactory implements VideoEncoderFactory {
    private static final String TAG = "SoftwareVideoEncoderFactory";
    private final long nativeFactory = nativeCreateFactory();

    private static native long nativeCreateEncoder(long j, VideoCodecInfo videoCodecInfo);

    private static native long nativeCreateFactory();

    private static native List<VideoCodecInfo> nativeGetSupportedCodecs(long j);

    @Override // com.vonage.webrtc.VideoEncoderFactory
    public VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo) {
        final long jNativeCreateEncoder = nativeCreateEncoder(this.nativeFactory, videoCodecInfo);
        if (jNativeCreateEncoder == 0) {
            Logging.w(TAG, "Trying to create encoder for unsupported format. " + videoCodecInfo);
            return null;
        }
        return new WrappedNativeVideoEncoder() { // from class: com.vonage.webrtc.SoftwareVideoEncoderFactory.1
            @Override // com.vonage.webrtc.WrappedNativeVideoEncoder, com.vonage.webrtc.VideoEncoder
            public boolean isHardwareEncoder() {
                return false;
            }

            @Override // com.vonage.webrtc.WrappedNativeVideoEncoder, com.vonage.webrtc.VideoEncoder
            public long createNativeVideoEncoder() {
                return jNativeCreateEncoder;
            }
        };
    }

    @Override // com.vonage.webrtc.VideoEncoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        return (VideoCodecInfo[]) nativeGetSupportedCodecs(this.nativeFactory).toArray(new VideoCodecInfo[0]);
    }
}
