package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface OTRNPublisherManagerInterface extends ViewManagerWithGeneratedInterface {
    void setAllowAudioCaptureWhileMuted(View view, boolean z);

    void setAudioBitrate(View view, int i);

    void setAudioTrack(View view, boolean z);

    void setCameraPosition(View view, String str);

    void setCameraTorch(View view, boolean z);

    void setCameraZoomFactor(View view, float f);

    void setDegradationPreference(View view, int i);

    void setEnableDtx(View view, boolean z);

    void setFrameRate(View view, int i);

    void setMaxVideoBitrate(View view, int i);

    void setName(View view, String str);

    void setPreferredVideoCodecs(View view, String str);

    void setPublishAudio(View view, boolean z);

    void setPublishCaptions(View view, boolean z);

    void setPublishSenderStats(View view, boolean z);

    void setPublishVideo(View view, boolean z);

    void setPublisherAudioFallback(View view, boolean z);

    void setPublisherId(View view, String str);

    void setResolution(View view, String str);

    void setScalableScreenshare(View view, boolean z);

    void setScaleBehavior(View view, String str);

    void setSessionId(View view, String str);

    void setSubscriberAudioFallback(View view, boolean z);

    void setVideoBitratePreset(View view, String str);

    void setVideoContentHint(View view, String str);

    void setVideoSource(View view, String str);

    void setVideoTrack(View view, boolean z);
}
