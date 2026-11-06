package com.vonage.webrtc;

/* JADX INFO: loaded from: classes4.dex */
public class BuiltinAudioEncoderFactoryFactory implements AudioEncoderFactoryFactory {
    private static native long nativeCreateBuiltinAudioEncoderFactory();

    @Override // com.vonage.webrtc.AudioEncoderFactoryFactory
    public long createNativeAudioEncoderFactory() {
        return nativeCreateBuiltinAudioEncoderFactory();
    }
}
