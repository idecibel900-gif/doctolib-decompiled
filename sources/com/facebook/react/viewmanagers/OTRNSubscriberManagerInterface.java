package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface OTRNSubscriberManagerInterface extends ViewManagerWithGeneratedInterface {
    void setAudioVolume(View view, float f);

    void setPreferredFrameRate(View view, int i);

    void setPreferredResolution(View view, String str);

    void setScaleBehavior(View view, String str);

    void setSessionId(View view, String str);

    void setStreamId(View view, String str);

    void setSubscribeToAudio(View view, boolean z);

    void setSubscribeToCaptions(View view, boolean z);

    void setSubscribeToVideo(View view, boolean z);
}
