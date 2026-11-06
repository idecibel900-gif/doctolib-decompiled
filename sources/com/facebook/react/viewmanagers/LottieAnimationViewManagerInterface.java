package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface LottieAnimationViewManagerInterface extends ViewManagerWithGeneratedInterface {
    void pause(View view);

    void play(View view, int i, int i2);

    void reset(View view);

    void resume(View view);

    void setAutoPlay(View view, boolean z);

    void setCacheComposition(View view, boolean z);

    void setColorFilters(View view, ReadableArray readableArray);

    void setDummy(View view, ReadableMap readableMap);

    void setEnableMergePathsAndroidForKitKatAndAbove(View view, boolean z);

    void setEnableSafeModeAndroid(View view, boolean z);

    void setHardwareAccelerationAndroid(View view, boolean z);

    void setImageAssetsFolder(View view, String str);

    void setLoop(View view, boolean z);

    void setProgress(View view, float f);

    void setRenderMode(View view, String str);

    void setResizeMode(View view, String str);

    void setSourceDotLottieURI(View view, String str);

    void setSourceJson(View view, String str);

    void setSourceName(View view, String str);

    void setSourceURL(View view, String str);

    void setSpeed(View view, double d);

    void setTextFiltersAndroid(View view, ReadableArray readableArray);

    void setTextFiltersIOS(View view, ReadableArray readableArray);
}
