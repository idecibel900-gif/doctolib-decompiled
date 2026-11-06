package com.vonage.webrtc;

/* JADX INFO: loaded from: classes4.dex */
public class LibvpxVp9Encoder extends WrappedNativeVideoEncoder {
    static native long nativeCreateEncoder();

    static native boolean nativeIsSupported();

    @Override // com.vonage.webrtc.WrappedNativeVideoEncoder, com.vonage.webrtc.VideoEncoder
    public boolean isHardwareEncoder() {
        return false;
    }

    @Override // com.vonage.webrtc.WrappedNativeVideoEncoder, com.vonage.webrtc.VideoEncoder
    public long createNativeVideoEncoder() {
        return nativeCreateEncoder();
    }
}
