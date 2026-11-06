package com.vonage.webrtc;

/* JADX INFO: loaded from: classes4.dex */
public class LibaomAv1Encoder extends WrappedNativeVideoEncoder {
    static native long nativeCreateEncoder();

    @Override // com.vonage.webrtc.WrappedNativeVideoEncoder, com.vonage.webrtc.VideoEncoder
    public boolean isHardwareEncoder() {
        return false;
    }

    @Override // com.vonage.webrtc.WrappedNativeVideoEncoder, com.vonage.webrtc.VideoEncoder
    public long createNativeVideoEncoder() {
        return nativeCreateEncoder();
    }
}
