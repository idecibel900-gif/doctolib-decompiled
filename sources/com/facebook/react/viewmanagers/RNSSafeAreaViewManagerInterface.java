package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface RNSSafeAreaViewManagerInterface extends ViewManagerWithGeneratedInterface {
    void setEdges(View view, ReadableMap readableMap);

    void setInsetType(View view, String str);
}
