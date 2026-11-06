package com.vonage.webrtc;

import android.media.MediaCodecInfo;

/* JADX INFO: loaded from: classes4.dex */
public class HardwareVideoDecoderFactory extends MediaCodecVideoDecoderFactory {
    private static final Predicate<MediaCodecInfo> defaultAllowedPredicate = new Predicate<MediaCodecInfo>() { // from class: com.vonage.webrtc.HardwareVideoDecoderFactory.1
        @Override // com.vonage.webrtc.Predicate
        public boolean test(MediaCodecInfo mediaCodecInfo) {
            return MediaCodecUtils.isHardwareAccelerated(mediaCodecInfo);
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

    @Deprecated
    public HardwareVideoDecoderFactory() {
        this(null);
    }

    public HardwareVideoDecoderFactory(EglBase.Context context) {
        this(context, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public HardwareVideoDecoderFactory(EglBase.Context context, Predicate<MediaCodecInfo> predicate) {
        Predicate<MediaCodecInfo> predicateAnd;
        if (predicate == null) {
            predicateAnd = defaultAllowedPredicate;
        } else {
            predicateAnd = predicate.and(defaultAllowedPredicate);
        }
        super(context, predicateAnd);
    }
}
