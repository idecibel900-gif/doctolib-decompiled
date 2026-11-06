package com.vonage.webrtc;

import android.media.MediaCodecInfo;

/* JADX INFO: loaded from: classes4.dex */
public class PlatformSoftwareVideoDecoderFactory extends MediaCodecVideoDecoderFactory {
    private static final Predicate<MediaCodecInfo> defaultAllowedPredicate = new Predicate<MediaCodecInfo>() { // from class: com.vonage.webrtc.PlatformSoftwareVideoDecoderFactory.1
        @Override // com.vonage.webrtc.Predicate
        public boolean test(MediaCodecInfo mediaCodecInfo) {
            return MediaCodecUtils.isSoftwareOnly(mediaCodecInfo);
        }
    };

    @Override // com.vonage.webrtc.MediaCodecVideoDecoderFactory, com.vonage.webrtc.VideoDecoderFactory
    public /* bridge */ /* synthetic */ VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
        return super.createDecoder(videoCodecInfo);
    }

    @Override // com.vonage.webrtc.MediaCodecVideoDecoderFactory, com.vonage.webrtc.VideoDecoderFactory
    public /* bridge */ /* synthetic */ VideoCodecInfo[] getSupportedCodecs() {
        return super.getSupportedCodecs();
    }

    public PlatformSoftwareVideoDecoderFactory(EglBase.Context context) {
        super(context, defaultAllowedPredicate);
    }
}
