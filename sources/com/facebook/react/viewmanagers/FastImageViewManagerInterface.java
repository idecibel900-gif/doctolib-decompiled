package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface FastImageViewManagerInterface extends ViewManagerWithGeneratedInterface {
    void setBlurRadius(View view, int i);

    void setDefaultSource(View view, String str);

    void setResizeMode(View view, String str);

    void setSource(View view, ReadableMap readableMap);

    void setTintColor(View view, Integer num);

    void setTransition(View view, String str);
}
