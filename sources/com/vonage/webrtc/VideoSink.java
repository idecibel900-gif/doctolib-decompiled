package com.vonage.webrtc;

/* JADX INFO: loaded from: classes4.dex */
public interface VideoSink {
    @CalledByNative
    void onFrame(VideoFrame videoFrame);
}
