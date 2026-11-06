package com.vonage.webrtc;

/* JADX INFO: loaded from: classes4.dex */
public class BuiltinAudioDecoderFactoryFactory implements AudioDecoderFactoryFactory {
    private static native long nativeCreateBuiltinAudioDecoderFactory();

    @Override // com.vonage.webrtc.AudioDecoderFactoryFactory
    public long createNativeAudioDecoderFactory() {
        return nativeCreateBuiltinAudioDecoderFactory();
    }
}
