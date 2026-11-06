package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface AndroidSwipeRefreshLayoutManagerInterface extends ViewManagerWithGeneratedInterface {
    void setColors(View view, ReadableArray readableArray);

    void setEnabled(View view, boolean z);

    void setNativeRefreshing(View view, boolean z);

    void setProgressBackgroundColor(View view, Integer num);

    void setProgressViewOffset(View view, float f);

    void setRefreshing(View view, boolean z);

    void setSize(View view, String str);
}
